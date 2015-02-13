package com.example.fragment;


import com.example.compat.SideBarActivity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;



public class MainActivity extends SideBarActivity {
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	protected void onCreateSideBar(){
		addFragment(new FacebookFragment());
		addFragment(new TwitterFragment());
		addFragment(new InstagramFragment());
		addFragment(new YoutubeFragment());
		
	}
	
	
	@Override
	protected Fragment onClickItemSideBar(String name){
		Fragment fragment = null;
		switch (name) {
		case "Facebook":
			fragment = new FacebookFragment();
			break;
		case "Twitter":
			fragment = new TwitterFragment();
			break;
		case "Youtube":
			fragment =  new YoutubeFragment();
			break;
		case "Instagram":
			fragment = new InstagramFragment();
			break;
		default:
			break;
		}
		return fragment;
	}
	

	
	

}
