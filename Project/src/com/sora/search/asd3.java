package com.sora.search;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class asd3 {
	public static void main(String[] args) {

		try {

			HttpURLConnection huc = null;

			String url = "http://ddragon.leagueoflegends.com/cdn/11.4.1/data/ko_KR/championFull.json";

			URL u = new URL(url);

			huc = (HttpURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();

			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();

			JSONObject championFull = (JSONObject) jp.parse(isr);

//			System.out.println(championFull);	// 전체 정보 (너무 커서 안 돌아가니까 실행하지 마)

			JSONObject ja = (JSONObject) championFull.get("data");
			JSONObject ja1 = (JSONObject) ja.get("Ahri");

			System.out.println(ja1.get("passive")); // 캐릭터 패시브 & 스킬
			JSONObject ja2 = (JSONObject) ja1.get("image");
			
			System.out.println(ja2);
			
//			JSONObject ja3 = (JSONObject) ja2.get("full");
			
//			System.out.println(ja3);
			
//			JSONArray ja2 = (JSONArray) ja1.get("passive");
//			 System.out.println(ja2.get(0));
//	         for (Object object : ja2) {
//	            JSONObject jo = (JSONObject) object;
//	            JSONObject ja4 = (JSONObject)jo.get("image");
//	            System.out.println(ja4.get("full"));
//	         }

//	         JSONObject ja3 = (JSONObject) ja2.get(0);
//	         JSONObject ja4 = (JSONObject) ja3.get("image");
//	         System.out.println(ja4);
//	
//	         System.out.println(ja4.get("full"));



		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
