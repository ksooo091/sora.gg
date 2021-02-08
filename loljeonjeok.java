import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class loljeonjeok {
	HttpsURLConnection huc =null;
	String api = "RGAPI-e2dd8d69-1688-4da6-8e18-e30cc46ab93b";	
	String sname= "마국밥무봤나";
	
	public String idck() {
	
	
	try {
		sname= URLEncoder.encode(sname, "utf-8");
		String url="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
		url= url + sname + "?api_key=" + api;
	
	URL u = new URL(url);
	huc = (HttpsURLConnection) u.openConnection();
//	huc.addRequestProperty("X-Riot-Token", api);
	InputStream is = huc.getInputStream();
	InputStreamReader isr = new InputStreamReader(is,"utf-8");
		
	JSONParser jp = new JSONParser(); 
	JSONObject loldata = (JSONObject) jp.parse(isr);
	//데이터 요청
	//System.out.println(loldata);
	
//	JSONObject sumonnerdata =(JSONObject) loldata.get(0);
	
	System.out.println(loldata.get("name"));
	System.out.println("어카운트id " +loldata.get("accountId"));
	System.out.println("소환사 레벨 " +loldata.get("summonerLevel"));
	return (String) loldata.get("accountId");
	
	
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
	
	}
	
	
	public Object matchck() {
		
		try {
			String url="https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/";
			String sid = idck();
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
	
	
	
public void gamedata() {
	try {
		String url="https://kr.api.riotgames.com/lol/match/v4/matches/";
		Object mid = matchck();
		url= url + mid + "?api_key=" + api;
		URL u = new URL(url);
		huc = (HttpsURLConnection) u.openConnection();
//		huc.addRequestProperty("X-Riot-Token", api);
		InputStream is = huc.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,"utf-8");
			
		JSONParser jp = new JSONParser(); 
		JSONObject loldata = (JSONObject) jp.parse(isr);
	System.out.println(loldata);
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("오류~~");
	}
	
	
}
	
	
}
