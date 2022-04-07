package com.gzeinnumer.day4_4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//todo 4
public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyHolder> {
    private Context context;
    private List<User> list;

    public RvAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.username.setText(list.get(position).getUsername());
        holder.description.setText(list.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public TextView username;
        public TextView description;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username);
            description =  itemView.findViewById(R.id.description);
        }
    }
}
