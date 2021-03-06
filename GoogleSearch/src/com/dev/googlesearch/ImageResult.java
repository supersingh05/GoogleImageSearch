package com.dev.googlesearch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class ImageResult implements Serializable {
	private String fullUrl;
	private String thumbUrl;
	
	public ImageResult(JSONObject json) {
		try {
			this.fullUrl= json.getString("url");
			this.thumbUrl= json.getString("tbUrl");
		} catch (JSONException e)  {
			this.fullUrl=null;
			this.thumbUrl=null;
		}
		
		
	}
	
	public String getFullUrl() {
		return fullUrl;
	}
	
	public String getThumbUrl() {
		return thumbUrl;
	}
	
	public String toString() {
		return this.thumbUrl;
	}

	public static ArrayList<ImageResult> fromJSONArray(JSONArray array) {
			ArrayList<ImageResult> results = new ArrayList<ImageResult>();
			for(int x=0; x < array.length(); x++) {
				try {
					results.add(new ImageResult(array.getJSONObject(x)));
					
				} catch(JSONException e) {
					e.printStackTrace();
				}
			}
			return results;

	}

}
