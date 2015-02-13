package com.example.compat;


public class FacebookService extends AsyncTaskRunner {

	public FacebookService(){
		 
	}
	
	@Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        System.out.println(result);
    }
 
	 public void load(String url){
		super.execute(url);
	 }
}
