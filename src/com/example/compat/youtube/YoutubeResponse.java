package com.example.compat.youtube;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class YoutubeResponse  {
	//PROPERTY DEFINITION
	
	protected String kind;
	protected String etag;
	protected String prevPageToken;
	protected String nextPageToken;
	protected PageInfo pageInfo;
	protected List<Item> items;
	
	
	//METHOD DEFINITION

	public YoutubeResponse(JSONObject jo){
		try {
			kind = jo.getString("kind").toString();
			etag = jo.getString("etag").toString();
			//prevPageToken = jo.getString("prevPageToken").toString();
			nextPageToken = jo.getString("nextPageToken").toString();
			
			pageInfo = new PageInfo(jo.getJSONObject("pageInfo")); 
			items = new ArrayList<Item>();
			JSONArray results = jo.getJSONArray("items");
			
			for(int i = 0; i < results.length(); i++)
			{
			      JSONObject item = results.getJSONObject(i);
			      items.add(new Item(item));
			}
			
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public List<Item> getItems() {
		return items;
	}



	public void setItems(List<Item> items) {
		this.items = items;
	}



	public String getPrevPageToken() {
		return prevPageToken;
	}



	public void setPrevPageToken(String prevPageToken) {
		this.prevPageToken = prevPageToken;
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

	public String getNextPageToken() {
		return nextPageToken;
	}

	public void setNextPageToken(String nextPageToken) {
		this.nextPageToken = nextPageToken;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	
	
	//CLASS DEFINITION
	
	protected class PageInfo{
		protected int totalResults;
		protected int resultsPerPage;
		
		public PageInfo(JSONObject jo){
			try {
				totalResults = Integer.parseInt(jo.getString("totalResults").toString());
				resultsPerPage = Integer.parseInt(jo.getString("resultsPerPage").toString());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public int getTotalResults() {
			return totalResults;
		}
		public void setTotalResults(int totalResults) {
			this.totalResults = totalResults;
		}
		public int getResultsPerPage() {
			return resultsPerPage;
		}
		public void setResultsPerPage(int resultsPerPage) {
			this.resultsPerPage = resultsPerPage;
		}
		
		
	}
	
	
}
