package com.rahav.crypto.cryptoSystem.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rahav.crypto.cryptoSystem.services.CryptoServices;

@RestController
public class CryproControllers {

	
	@Autowired
	
	private CryptoServices cryptoServices;
	
	@RequestMapping("getAllCrypto")
	public String getCrypto()
	{
		return  cryptoServices.getCrypto();
	}
	
	
	@RequestMapping("getCrypto")
	public String getCryptoByCurrency(@RequestParam	("currency") String currency)
	{
		System.out.println("currency = "+currency);
		return  cryptoServices.getCryptoByCurrnecy(currency);
	}
	

   //  http://localhost:8080/getCryptoWithPrm?currA=JPY&currB=USD
	@RequestMapping("getCryptoWithPrm")
	public String getCryptoWithPrm(@RequestParam HashMap<String, String>  params)
	{
		System.out.println("currency = "+params.get("currA"));
		return  params.get("currA").toString();
	}
	
	@RequestMapping(value="getCryptoPost" , method = RequestMethod.POST)
	public String getCryptoPost(@RequestBody String  params)
	{
		
		return  cryptoServices.getCryptoBody(params);
	}
}
