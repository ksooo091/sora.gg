import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class loljeonjeok {
	HttpsURLConnection huc = null;
	String api = "RGAPI-a531df28-32d7-4b3e-bbf7-78897704cbd4";
	String sname = "마국밥무봤나";

	public String idck() {

		try {
			sname = URLEncoder.encode(sname, "utf-8");
			String url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
			url = url + sname + "?api_key=" + api;

			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
//	huc.addRequestProperty("X-Riot-Token", api);
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject loldata = (JSONObject) jp.parse(isr);
			// 데이터 요청
			// System.out.println(loldata);

//	JSONObject sumonnerdata =(JSONObject) loldata.get(0);

			System.out.println(loldata.get("name"));
			System.out.println("어카운트id " + loldata.get("accountId"));
			System.out.println("소환사 레벨 " + loldata.get("summonerLevel"));
			return (String) loldata.get("accountId");

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public Object matchck() {

		try {
			String url = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/";
			String sid = idck();
			url = url + sid + "?api_key=" + api;

			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
//			huc.addRequestProperty("X-Riot-Token", api);
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject loldata = (JSONObject) jp.parse(isr);
			System.out.println(loldata);
			System.out.println("1");
			JSONArray jjs = (JSONArray) loldata.get("matches");
			System.out.println(loldata.get("matches"));
			JSONObject matches = (JSONObject) jjs.get(0);
			System.out.println(matches.get("gameId"));
		for (int i = 0; i < 11; i++) {
			
			JSONObject jj = (JSONObject) jjs.get(i);
			System.out.println("게임번호 " + jj.get("gameId"));
			System.out.println("게임 타입 " + queuetype.queue(Integer.parseInt(jj.get("queue").toString())));
			//	System.out.println("사용한 챔피언 " +  jj.get("champion"));
				// int champkey = Integer.parseInt(jj.get("champion").toString());
			System.out.println("사용한 챔피언 " +  champ.champnameKr(Integer.parseInt(jj.get("champion").toString())));
			
			Date timestamp = new Date((long) jj.get("timestamp"));
			System.out.println(timestamp);
			//		System.out.println("타임스탬프 " +  jj.get("timestamp"));
			
			System.out.println("=====================");
		}
		//1612965618237 1612967175349
		return matches.get("gameId");
			// System.out.println("34");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("출력오류ㅠ");
		}

		return null;

	}

	public void gamedata() {
		try {
			String url = "https://kr.api.riotgames.com/lol/match/v4/matches/";
			Object mid = matchck();
			url = url + mid + "?api_key=" + api;
			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
//		huc.addRequestProperty("X-Riot-Token", api);
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject loldata = (JSONObject) jp.parse(isr);
			System.out.println(loldata);
			JSONArray participantIdentities = (JSONArray) loldata.get("participantIdentities");
//	JSONArray player = (JSONArray) participantIdentities.get("player");
			for (int i = 0; i < participantIdentities.size(); i++) {

				JSONObject participant = (JSONObject) participantIdentities.get(i);
				JSONObject player = (JSONObject) participant.get("player");
				System.out.println("사용자번호 " + participant.get("participantId"));
				System.out.println("소환사명 " + player.get("summonerName"));
				System.out.println("=====================");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("오류~~");

		}

	}

	public void champ() {

		try {
			String url = "http://ddragon.leagueoflegends.com/cdn/11.3.1/data/ko_KR/champion.json";
//	URL u = new URL(url);
//	huc = (HttpsURLConnection) u.openConnection();


//	InputStream is = huc.getInputStream();
			InputStream is = new URL(url).openStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
//			BufferedInputStream bi = new BufferedInputStream(is);
			BufferedReader br = new BufferedReader(isr);
			String data = br.readLine();
			JSONParser jp = new JSONParser();
//			JSONObject loldata = (JSONObject) jp.parse(isr);
			JSONObject loldata2 = (JSONObject) jp.parse(data);
JSONObject data2 = (JSONObject) loldata2.get("data");
JSONObject Aatrox = (JSONObject) data2.get("Aatrox");
for (int i = 0; i < data2.size(); i++) {
	
}
System.out.println(Aatrox.get("key"));

//			System.out.println(loldata);
		//	System.out.println("??");
//			System.out.println(Aatrox);
			
			//JSONArray ja = 
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("안됨!");
			// TODO: handle exception
		}

	}

}
