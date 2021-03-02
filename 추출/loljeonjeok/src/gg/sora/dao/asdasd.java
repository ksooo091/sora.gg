package gg.sora.dao;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class asdasd {
	public static void main(String[] args) {
		 String aid = null;
//		 String sid = "-QKLT40RNDOBkTSRO1XdtD2NLJz14VPC7hRMMQAjl7yEqCs";
		 String sid = "R_kM8CPdb6f7EbTFNyvZl9Py-inrjZVrsQds";
		String api = "RGAPI-a531df28-32d7-4b3e-bbf7-78897704cbd4";
		HttpsURLConnection huc = null;
		try {
			String url = "https://kr.api.riotgames.com/lol/spectator/v4/active-games/by-summoner/";
			url = url + sid + "?api_key=" + api;

			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			int resCode = huc.getResponseCode();
			//if (resCode == 200) {
				InputStream is = huc.getInputStream();
				System.out.println(3);
				InputStreamReader isr = new InputStreamReader(is, "utf-8");

				JSONParser jp = new JSONParser();
				JSONObject loldata = (JSONObject) jp.parse(isr);
				System.out.println(loldata);
		//	}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
