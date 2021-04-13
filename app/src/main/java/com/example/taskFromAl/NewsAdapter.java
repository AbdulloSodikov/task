package com.example.taskFromAl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    public MainActivity mainActivity;

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public int getItemCount() {
        return mainActivity.news.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name, city, state, endData;

        public ViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.tv_nameJson);
            city = view.findViewById(R.id.tv_cityJson);
            state = view.findViewById(R.id.tv_stateJson);
            endData = view.findViewById(R.id.tv_dataEndJson);

        }
    }
        @Override
        public void onBindViewHolder(final ViewHolder viewHolder, final int index) {
            viewHolder.name.setText(mainActivity.news.get(index).getName());
            viewHolder.city.setText(mainActivity.news.get(index).getName());
            viewHolder.state.setText(mainActivity.news.get(index).getName());
            viewHolder.endData.setText(mainActivity.news.get(index).getName());
        }
    }


