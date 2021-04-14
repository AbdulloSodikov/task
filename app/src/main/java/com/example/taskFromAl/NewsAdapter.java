package com.example.taskFromAl;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

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

        public TextView name, startData, endData, objType;
        public ImageView photo;


        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.tv_nameJson);
            startData = view.findViewById(R.id.tv_startDataJson);
            endData = view.findViewById(R.id.tv_dataEndJson);
            objType = view.findViewById(R.id.tv_objTypeJson);
            photo = view.findViewById(R.id.iv_photo);

        }
    }

        @Override
        public void onBindViewHolder  (final ViewHolder viewHolder, final int index) {
            viewHolder.name.setText(mainActivity.news.get(index).getName());
            viewHolder.startData.setText(mainActivity.news.get(index).getStartDate());
            viewHolder.endData.setText(mainActivity.news.get(index).getAndDate());
            viewHolder.objType.setText(mainActivity.news.get(index).getObjType());
            Glide.with(mainActivity.getApplicationContext()).load(mainActivity.news.get(index).getIcon()).into(viewHolder.photo);

            viewHolder.name.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://guidebook.com" + mainActivity.news.get(index).getUrl()));
                    mainActivity.startActivity(intent);
                }
            });


        }

    }


