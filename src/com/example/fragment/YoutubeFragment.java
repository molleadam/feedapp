package com.example.fragment;



import com.example.compat.ContentFragment;
import com.example.compat.youtube.Item;
import com.example.compat.youtube.YoutubeCallback;
import com.example.compat.youtube.YoutubeRequest;
import com.example.compat.youtube.YoutubeResponse;
import com.example.compat.youtube.YoutubeService;



import android.os.Bundle;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class YoutubeFragment extends ContentFragment  implements YoutubeCallback
{
	//String url = "https://www.googleapis.com/youtube/v3/search?part=snippet&channelId=UCTWmss2woK0SdSjTh-umjAw&key=AIzaSyBpu8hgnXbkqFVWrAvwRUEz7T13ii3I7WM&pageToken=CAUQAQ";
    
	SwipeRefreshLayout swipeLayout;
	ListView listView ;
	ListYoutubeAdapter adapter;
	
	public YoutubeResponse youtubeResponse = null;
	
	public YoutubeFragment() {
    	setTitle("Youtube");
    	setIcon(R.drawable.youtube);
    	
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
    {
        View rootView = inflater.inflate(R.layout.youtube_fragment, container, false);
       
        return rootView;
    }
    
    @Override
    public void onActivityCreated (Bundle savedInstanceState){
    	super.onActivityCreated(savedInstanceState);
    	
    	swipeLayout = (SwipeRefreshLayout) getActivity().findViewById(R.id.swipe_container);
    	 load();
        swipeLayout.setOnRefreshListener(new OnRefreshListener() {
			@Override
			public void onRefresh() {
				load();
			}
		});
        
    	listView = (ListView) getActivity().findViewById(R.id.youtubeList); 
		adapter = new ListYoutubeAdapter(getActivity().getApplicationContext(), R.layout.item_list_youtube);
        listView.setAdapter(adapter);

    }
        
    private void load(){
    	YoutubeRequest youtubeRequest = new YoutubeRequest();
    	YoutubeService youtubeService = new YoutubeService(getActivity(),swipeLayout,this);
		
		if(youtubeResponse != null){
			youtubeRequest.setPageToken(youtubeResponse.getNextPageToken());
		}
		
		youtubeService.load(youtubeRequest);
    }

	@Override
	public void afterLoad(YoutubeResponse response) {
		this.youtubeResponse = response;
		
        swipeLayout.setRefreshing(false);
        for (Item item : response.getItems()) {
			 //listMessagesAdapter.insert(message, 0);
        	adapter.insert(item,0);
		}
        
        
	}
    
    
 
}
