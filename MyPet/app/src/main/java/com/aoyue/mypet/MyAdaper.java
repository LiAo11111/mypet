package com.aoyue.mypet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class MyAdaper extends RecyclerView.Adapter<MyAdaper.MylHolder> {
    private Context context;
    private List<String> list=new ArrayList<>();
    public MyAdaper(Context context,List<String> list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public MylHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.accompany_item, parent, false);
        return new MylHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MylHolder holder, int position) {
        holder.accompanyTime.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MylHolder extends RecyclerView.ViewHolder {
        private TextView accompanyTime;
        public MylHolder(View itemView) {
            super(itemView);
            accompanyTime=itemView.findViewById(R.id.accompany_time);
        }
    }
}
