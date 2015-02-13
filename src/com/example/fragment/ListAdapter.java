package com.example.fragment;

import java.util.List;

import com.example.compat.ContentFragment;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<Object> {
	
	public ListAdapter(Context context, int textViewResourceId,List<Object> list) {
        super(context, textViewResourceId, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item_list, null);
        TextView nome = (TextView)convertView.findViewById(R.id.text_item);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.img_item);
        
        ContentFragment fragment =  (ContentFragment) getItem(position); 
        nome.setText(fragment.getTitle());
        imageView.setImageResource(fragment.getIcon());
        return convertView;
    }

}
