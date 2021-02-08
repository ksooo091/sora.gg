package gg.loldao;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class lolDAO {
	static Object aid = null;
	static String sname = null;
	static String api = "RGAPI-e2dd8d69-1688-4da6-8e18-e30cc46ab93b";	
	
	static HttpsURLConnection huc =null;
	public static void idck(HttpServletRequest request) {
	 sname = request.getParameter("sname");
		System.out.println(sname);
		
		try {
			
			sname= URLEncoder.encode(sname, "utf-8");
			String url="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
		url= url + sname + "?api_key=" + api;
		URL u = new URL(url);
		huc = (HttpsURLConnection) u.openConnection();
		InputStream is = huc.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,"utf-8");
			
		JSONParser jp = new JSONParser(); 
		JSONObject loldata = (JSONObject) jp.parse(isr);
		
		
		request.setAttribute("sname", loldata.get("name"));
		aid = loldata.get("accountId");
		request.setAttribute("aid", loldata.get("accountId"));
		request.setAttribute("slv", loldata.get("summonerLevel"));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("오류남;;");
		}
		
	}
	
	public static Object matchck() {
		
		try {
			String url="https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/";
			String sid = (String) aid;
			url= url + sid + "?api_key=" + api;
			
			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
//			huc.addRequestProperty("X-Riot-Token", api);
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
				
			JSONParser jp = new JSONParser(); 
			JSONObject loldata = (JSONObject) jp.parse(isr);
		System.out.println(loldata);
			System.out.println("1");
			JSONArray jjs = (JSONArray) loldata.get("matches");
			System.out.println(loldata.get("matches"));
			JSONObject matches= (JSONObject) jjs.get(0);
			System.out.println(matches.get("gameId"));
		return matches.get("gameId");
			
			
//			for (int i = 0; i < 11; i++) {
//				
//				JSONObject jj = (JSONObject) jjs.get(i);
//				System.out.println("게임번호 " + jj.get("gameId"));
//				System.out.println("사용한 챔피언 " + jj.get("champion"));
//				System.out.println("=====================");
//			}
			//System.out.println("34");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("출력오류ㅠ");
		}

		
		
		
		
		return null;
		
	}
	
	public static void gamedata(HttpServletRequest request) {
		try {
			String url="https://kr.api.riotgames.com/lol/match/v4/matches/";
			Object mid = matchck();
			url= url + mid + "?api_key=" + api;
			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
				
			JSONParser jp = new JSONParser(); 
			JSONObject loldata = (JSONObject) jp.parse(isr);
		System.out.println(loldata);
		request.setAttribute("mdata", loldata);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("오류~~");
		}
	
}
	
}
