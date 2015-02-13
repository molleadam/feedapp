package com.example.fragment;





import com.example.compat.ContentFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class InstagramFragment extends ContentFragment 
{
    public InstagramFragment() {
    	setTitle("Instagram");
    	setIcon(R.drawable.instagram);
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
          {
        View rootView = inflater.inflate(R.layout.instagram_fragment, container, false);
        return rootView;
 
    }
    
    @Override
    public void onActivityCreated (Bundle savedInstanceState){
    	super.onActivityCreated(savedInstanceState);
    	Button loadButton = (Button) getActivity().findViewById(R.id.loadinstagram);
    	System.out.println(loadButton.getId());
    	loadButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("ciao");
				
			}
		});
        
	
    }
 
}
