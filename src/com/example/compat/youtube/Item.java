package com.example.compat.youtube;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.compat.youtube.YoutubeResponse.PageInfo;

public class Item{
	String kind;
	String etag;
	Id id;
	public Snippet snippet;
	
	public Item(JSONObject jo){
		try {
			kind = jo.getString("kind").toString();
			etag = jo.getString("etag").toString();
			id = new Id(jo.getJSONObject("id"));
			snippet = new Snippet(jo.getJSONObject("snippet"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	public String getEtag() {
		return etag;
	}


	public void setEtag(String etag) {
		this.etag = etag;
	}


	public Id getId() {
		return id;
	}


	public void setId(Id id) {
		this.id = id;
	}


	public Snippet getSnippet() {
		return snippet;
	}


	public void setSnippet(Snippet snippet) {
		this.snippet = snippet;
	}


	class Id{
		String kind;
		String channelId;
		
		public Id(JSONObject jo){
			try {
				kind = jo.getString("kind").toString();
				//channelId = jo.getString("channelId").toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public String getKind() {
			return kind;
		}
		public void setKind(String kind) {
			this.kind = kind;
		}
		public String getChannelId() {
			return channelId;
		}
		public void setChannelId(String channelId) {
			this.channelId = channelId;
		}
		
		
	}
	
	
	public class Snippet{
		Date publishedAt;
		String channelId;
		String title;
		String description;
		Thumbnails thumbnails; 
		String channelTitle;
		String liveBroadcastContent;
		
		public Snippet(JSONObject jo){
			try {
				channelId = jo.getString("channelId").toString();
				title = jo.getString("title").toString();
				description = jo.getString("description").toString();
				liveBroadcastContent = jo.getString("liveBroadcastContent").toString();
				channelTitle = jo.getString("channelTitle").toString();
				thumbnails = new Thumbnails(jo.getJSONObject("thumbnails"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

		public Thumbnails getThumbnails() {
			return thumbnails;
		}
		public void setThumbnails(Thumbnails thumbnails) {
			this.thumbnails = thumbnails;
		}
		public String getChannelTitle() {
			return channelTitle;
		}
		public void setChannelTitle(String channelTitle) {
			this.channelTitle = channelTitle;
		}
		public String getLiveBroadcastContent() {
			return liveBroadcastContent;
		}
		public void setLiveBroadcastContent(String liveBroadcastContent) {
			this.liveBroadcastContent = liveBroadcastContent;
		}
		public Date getPublishedAt() {
			return publishedAt;
		}
		public void setPublishedAt(Date publishedAt) {
			this.publishedAt = publishedAt;
		}
		public String getChannelId() {
			return channelId;
		}
		public void setChannelId(String channelId) {
			this.channelId = channelId;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		
		public class Thumbnails{
			Default defults;
			Medium medium;
			High high;
			
			public Thumbnails(JSONObject jo){
				try {
					defults = new Default(jo.getJSONObject("default"));
					medium = new Medium(jo.getJSONObject("medium"));
					high = new High(jo.getJSONObject("high"));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			public Default getDefults() {
				return defults;
			}

			public void setDefults(Default defults) {
				this.defults = defults;
			}

			public Medium getMedium() {
				return medium;
			}

			public void setMedium(Medium medium) {
				this.medium = medium;
			}

			public High getHigh() {
				return high;
			}

			public void setHigh(High high) {
				this.high = high;
			}

			public class Default{
				String url;

				public Default(JSONObject jo){
					try {
						url = jo.getString("url").toString();
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				public String getUrl() {
					return url;
				}

				public void setUrl(String url) {
					this.url = url;
				}
				
				
			}
			
			class Medium{
				String url;
				
				public Medium(JSONObject jo){
					try {
						url = jo.getString("url").toString();
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				public String getUrl() {
					return url;
				}

				public void setUrl(String url) {
					this.url = url;
				}
			}
			
			class High{
				String url;
				
				public High(JSONObject jo){
					try {
						url = jo.getString("url").toString();
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				public String getUrl() {
					return url;
				}

				public void setUrl(String url) {
					this.url = url;
				}
			}
		}
		
	}
}