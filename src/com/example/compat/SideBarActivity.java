package com.example.compat;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


import com.example.fragment.FacebookFragment;
import com.example.fragment.InstagramFragment;
import com.example.fragment.ListAdapter;

import com.example.fragment.R;
import com.example.fragment.TwitterFragment;
import com.example.fragment.YoutubeFragment;





import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public abstract class  SideBarActivity extends ActionBarActivity {

	ListView listView;
	List<Object> listFragments = new ArrayList<Object>();
	
	 DrawerLayout dLayout;
	
	protected abstract void onCreateSideBar();
	protected abstract android.support.v4.app.Fragment onClickItemSideBar(String name);
	@Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        
        
        try {
	        ViewConfiguration config = ViewConfiguration.get(this);
	        Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
	        if(menuKeyField != null) {
	            menuKeyField.setAccessible(true);
	            menuKeyField.setBoolean(config, false);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
        
        
        
        setContentView(R.layout.sidebar);
        onCreateSideBar();
        
        
        
        
        listView = (ListView) findViewById(R.id.left_drawer);
        ListAdapter adapter = new ListAdapter(getApplicationContext(), R.layout.item_list,listFragments);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener(){
            @Override 
            public void onItemClick(AdapterView<?> adapterView,    View row,    int position,    long index){
            	 changeFragment(row);
            }
          });
        
        if (savedInstanceState == null) 
        {
        	getSupportFragmentManager().beginTransaction().add(R.id.container, new FacebookFragment()).commit();
 
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer);
		
		dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
		
		 
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.mainmenu, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case android.R.id.home:
	        	animateSidebar();
	        return true;
	        
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	
	public void addFragment(Object fragment){
		listFragments.add(fragment);
	}
	public List<Object> getListFragments() {
		return listFragments;
	}


	public void setListFragments(List<Object> listFragments) {
		this.listFragments = listFragments;
	}


	public ListView getListview() {
		return listView;
	}

	public void setListview(ListView listView) {
		this.listView = listView;
	}
	
	public void changeFragment(View row){
		
		TextView textView = (TextView) row.findViewById(R.id.text_item);
		String fragmentName = textView.getText().toString();
		android.support.v4.app.Fragment fragment = onClickItemSideBar(fragmentName);
		getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
		animateSidebar();
	}
	
	
	public void animateSidebar(){
		if(dLayout.isDrawerOpen(listView))
    		dLayout.closeDrawer(listView);
    	else
    		dLayout.openDrawer(listView);
    }
}
