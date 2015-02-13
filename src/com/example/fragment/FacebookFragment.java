package com.example.fragment;





import com.example.compat.ContentFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FacebookFragment extends ContentFragment 
{
    public FacebookFragment() {
    	setTitle("Facebook");
    	setIcon(R.drawable.facebook);
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	
        View rootView = inflater.inflate(R.layout.facebook_fragment, container, false);
        WebView myWebView = (WebView) rootView.findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient( new WebViewClient() {
        	public boolean shouldOverrideUrlLoading(WebView view, String url) {return false;}
        });
       
        myWebView.loadUrl("https://m.facebook.com/pages/LinuxMX/181080501902275");
        return rootView;
 
    }
 
}
