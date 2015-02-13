package com.example.fragment;





import com.example.compat.ContentFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TwitterFragment extends ContentFragment 
{
    public TwitterFragment() {
    	setTitle("Twitter");
    	setIcon(R.drawable.twitter);
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
          {
        View rootView = inflater.inflate(R.layout.twitter_fragment, container, false);
        WebView myWebView = (WebView) rootView.findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient( new WebViewClient() {
        	public boolean shouldOverrideUrlLoading(WebView view, String url) {return false;}
        });
       
        myWebView.loadUrl("https://mobile.twitter.com/linux");
        
        return rootView;
 
    }
 
}
