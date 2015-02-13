package com.example.compat.youtube;

public class YoutubeRequest {

	String url = "https://www.googleapis.com/youtube/v3/search";
	String part = "snippet";
	String channelId = "UCTWmss2woK0SdSjTh-umjAw";
	String key = "AIzaSyBpu8hgnXbkqFVWrAvwRUEz7T13ii3I7WM";
	String pageToken;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getPageToken() {
		return pageToken;
	}
	public void setPageToken(String pageToken) {
		this.pageToken = pageToken;
	}
	
	public String toString(){
		String pageToken = "";
		if(getPageToken() != null){
			pageToken = "&pageToken="+getPageToken();
		}
			
		return getUrl()+"?part="+getPart()+"&channelId="+getChannelId()+"&key="+getKey()+pageToken;
	}
}
