package com.rahav.crypto.cryptoSystem.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Service;

@Service
public class CryptoServices {

	
	public String getCrypto() {
		
		URI uri;
		JSONObject jsonObject = null;
		try {
			uri = new URI ("https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=USD,JPY,EUR");
			JSONTokener jsonTokener = new JSONTokener(uri.toURL().openStream());
			jsonObject = new JSONObject(jsonTokener);
			System.out.println("output is " + jsonObject);
			
		} catch (URISyntaxException  |  IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject.toString();
		
		
	}
	
public String getCryptoByCurrnecy(String currency) {
		
		URI uri;
		JSONObject jsonObject = null;
		try {
			uri = new URI ("https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms="+currency);
			JSONTokener jsonTokener = new JSONTokener(uri.toURL().openStream());
			jsonObject = new JSONObject(jsonTokener);
			System.out.println("output is " + jsonObject);
			
		} catch (URISyntaxException  |  IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject.toString();
		
		
	}

public String getCryptoBody(String request) {
	
	JSONObject jsonObject = new JSONObject(request);
	System.out.println(jsonObject.getJSONObject("RAW").get("MARKET"));
	
	
	return jsonObject.getJSONObject("RAW").get("MARKET").toString();
	
	
}
	
}
