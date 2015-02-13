package com.example.fragment;

import java.util.List;

import com.example.compat.ContentFragment;
import com.example.compat.DownloadImageTask;
import com.example.compat.youtube.Item;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListYoutubeAdapter extends ArrayAdapter<Item> {
	
	public ListYoutubeAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item_list_youtube, null);
        TextView textView = (TextView)convertView.findViewById(R.id.youtube_title);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.youtube_thumbnail);
        
        Item item =  (Item) getItem(position); 
        textView.setText(item.getSnippet().getTitle());
        DownloadImageTask downloadImageTask = new DownloadImageTask(imageView);
        downloadImageTask.execute(item.getSnippet().getThumbnails().getDefults().getUrl());

        return convertView;
    }

}
