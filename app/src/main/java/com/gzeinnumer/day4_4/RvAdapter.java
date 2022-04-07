package com.gzeinnumer.day4_4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//todo 4
public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyHolder> implements Filterable {
    private Context context;
    private List<User> list;
    private List<User> listFilter;

    public RvAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
        this.listFilter = new ArrayList<>(list);
    }

    public void setList(ArrayList<User> list) {
        this.list = list;
        this.listFilter = new ArrayList<>(list);
        notifyDataSetChanged();
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

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<User> fildteredList = new ArrayList<>();
            if(constraint == null || constraint.length() == 0){
                Collections.sort(listFilter, new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getUsername().toLowerCase().compareTo(o2.getUsername().toLowerCase());
                    }
                });
                fildteredList.addAll(listFilter);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (User item : listFilter){
                    if( item.getUsername().toLowerCase().contains(filterPattern)){
                        fildteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = fildteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list.clear();
            list.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };
}
