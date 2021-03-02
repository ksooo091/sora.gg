package gg.sora.dao;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



//https://ddragon.leagueoflegends.com/cdn/11.4.1/img/map/map11.png 소환사의 협곡 맵	
public class test {
	public static void main(String[] args) {

		String api = "RGAPI-a531df28-32d7-4b3e-bbf7-78897704cbd4";
		String mid = "5024062378";
		try {
			String url = "https://kr.api.riotgames.com/lol/match/v4/timelines/by-match/";
			url = url + mid + "?api_key=" + api;

			URL u = new URL(url);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject loldata = (JSONObject) jp.parse(isr);
			JSONArray frames = (JSONArray) loldata.get("frames");

			for (int i = 0; i < frames.size(); i++) {
				JSONObject abc = (JSONObject) frames.get(i);
				JSONArray events = (JSONArray) abc.get("events");

				for (int j = 0; j < events.size(); j++) {
					JSONObject inevent = (JSONObject) events.get(j);

					if (inevent.get("type").equals("CHAMPION_KILL")) {
						JSONObject position = (JSONObject) inevent.get("position");
						JSONArray assist = (JSONArray) inevent.get("assistingParticipantIds");
						System.out.println("x좌표:" +position.get("x"));
						System.out.println("y좌표:" +position.get("y"));

						System.out.println("밀리초 =" +inevent.get("timestamp"));
						System.out.println("죽인놈 =" +inevent.get("killerId"));
						System.out.println("죽여진놈=" +inevent.get("victimId"));
						for (int k = 0; k < assist.size(); k++) {
							System.out.println("어시스트 :" + assist.get(k));

						}
						
						System.out.println("-----------------------------");
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
