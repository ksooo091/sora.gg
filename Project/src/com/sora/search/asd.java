package com.sora.search;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class asd {
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

//			System.out.println(championFull);

			JSONObject ja = (JSONObject) championFull.get("data");
			JSONObject ja1 = (JSONObject) ja.get("Aatrox");

			// System.out.println(ja1.get("spells")); // 캐릭터 패시브 & 스킬
			JSONArray ja2 = (JSONArray) ja1.get("spells");
			System.out.println(ja2.get(0));
			for (Object object : ja2) {
				System.out.println(object);
			}

			JSONObject ja3 = (JSONObject) ja2.get(0);
			JSONObject ja4 = (JSONObject) ja3.get("image");
			System.out.println(ja4);

			System.out.println(ja4.get("full"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
