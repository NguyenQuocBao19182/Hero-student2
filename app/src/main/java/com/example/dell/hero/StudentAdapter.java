package com.example.dell.hero;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dell on 15-Jan-18.
 */

public class StudentAdapter extends RecyclerView.Adapter <StudentAdapter.ViewHolder> {

    ArrayList<Student> mStudentList;
    Context context;
    private OnItemClickListener mClickListener;

    public StudentAdapter(ArrayList<Student> heroList, Context context) {
        this.mStudentList = heroList;
        this.context = context;
    }

    @Override


    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
            View itemView = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView, mClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Take data each positon
        holder.nameTextView.setText(mStudentList.get(position).getName());
        holder.imageView.setImageResource(mStudentList.get(position).getImage());
        holder.classTextView.setText(mStudentList.get(position).getClassName());
        holder.idTextView.setText(mStudentList.get(position).getID());
    }

    @Override
    public int getItemCount() {
        return mStudentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nameTextView;
        ImageView imageView;
        TextView classTextView;
        TextView idTextView;

        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_textview);
            imageView = itemView.findViewById(R.id.image_view);
            classTextView = itemView.findViewById(R.id.class_name_textview);
            idTextView = itemView.findViewById(R.id.id_textview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }

    }
    public void setOnItemClickListener(OnItemClickListener listener) {

        mClickListener = listener;
    }
}
