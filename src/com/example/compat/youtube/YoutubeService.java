package com.example.compat.youtube;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.compat.AsyncTaskRunner;
import com.example.compat.ContentFragment;
import com.example.fragment.ListYoutubeAdapter;
import com.example.fragment.R;



public class YoutubeService extends AsyncTaskRunner {
	
	Activity activity;
	YoutubeResponse response;
	SwipeRefreshLayout swipeLayout;
	ContentFragment fragment;
	
	 public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public YoutubeResponse getResponse() {
		return response;
	}
	public void setResponse(YoutubeResponse response) {
		this.response = response;
	}
	public SwipeRefreshLayout getSwipeLayout() {
		return swipeLayout;
	}
	public void setSwipeLayout(SwipeRefreshLayout swipeLayout) {
		this.swipeLayout = swipeLayout;
	}
	public YoutubeService(Activity activity,SwipeRefreshLayout swipeLayout,ContentFragment fragment){
		 this.activity = activity;
		 this.swipeLayout = swipeLayout;
		 this.fragment = fragment;
	 }
	 @Override
	    protected void onPostExecute(String result) {
	        super.onPostExecute(result);
	        System.out.println(result);
	        try {
				JSONObject obj = new JSONObject(result);
				response = new YoutubeResponse(obj);
				
				
		        ((YoutubeCallback) fragment).afterLoad(response);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    }
	 
	 public void load(YoutubeRequest request){
		super.execute(request.toString());
	 }
}
