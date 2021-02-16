import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
	static String name = null;
	static Object aid = null;
	static Object pid = null;
	static String api = "RGAPI-18982363-b6bf-47c1-b90a-761268a757d4";
	static HttpURLConnection huc = null;

	public static void search(HttpServletRequest request) {

		name = request.getParameter("name");

		try {
			name = URLEncoder.encode(name, "utf-8");

			String url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";

			url = url + name + "?api_key=" + api;

			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();

			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();

			JSONObject lolData = (JSONObject) jp.parse(isr);

//			System.out.println(lolData);

			request.setAttribute("name", lolData.get("name"));
			request.setAttribute("summonerLevel", lolData.get("summonerLevel"));

			String imgUrl = "http://ddragon.leagueoflegends.com/cdn/11.3.1/img/profileicon/"
					+ lolData.get("profileIconId") + ".png"; // ºÒ·¯¿Ã URL

			request.setAttribute("profileIcon", imgUrl);

			aid = lolData.get("accountId");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<gid> gameId() {

		try {
			String url = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/";

			url = url + aid + "?api_key=" + api;

			URL u = new URL(url);

			huc = (HttpsURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();

			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();

			JSONObject lolData = (JSONObject) jp.parse(isr);

			JSONArray matches = (JSONArray) lolData.get("matches");
			System.out.println(matches);

			JSONObject gameId2 = null;

			ArrayList<gid> gids = new ArrayList<gid>();
			

			for (int i = 0; i < 21; i++) {
				gameId2 = (JSONObject) matches.get(i);
				String id3 = gameId2.get("gameId") + "";
//				System.out.println(id3);
				gids.add(new gid(id3));
			}

//			for (gid gid : gids) {
//				System.out.println(gid.getGid());
//			}

			return gids;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Object gameData(HttpServletRequest request) {

		String url = "https://kr.api.riotgames.com/lol/match/v4/matches/";
		String url2 = null;
		try {

		ArrayList<gid> gids = gameId();
		for (gid gid : gids) {

			url2 = url+ gid.getGid() + "?api_key=" + api;
				URL u = new URL(url2);
				huc = (HttpsURLConnection) u.openConnection();

				InputStream is = huc.getInputStream();

				InputStreamReader isr = new InputStreamReader(is, "utf-8");

				JSONParser jp = new JSONParser();

				JSONObject lolData = (JSONObject) jp.parse(isr);

				JSONArray participantIdentities = (JSONArray) lolData.get("participantIdentities");

				for (int i = 0; i < participantIdentities.size(); i++) {
					JSONObject j = (JSONObject) participantIdentities.get(i);
					JSONObject j2 = (JSONObject) j.get("player");
					if (j2.get("currentAccountId").equals(aid)) {
						// System.out.println(j.get("participantId"));
						pid = j.get("participantId");
					}

				}

				JSONArray participants = (JSONArray) lolData.get("participants");
				
				Kda k = null;
				ArrayList<Kda> kdas = new ArrayList<Kda>();
				
				for (int i = 0; i < participants.size(); i++) {
					JSONObject j = (JSONObject) participants.get(i);
					JSONObject j2 = (JSONObject) j.get("stats");
					if (j.get("participantId").equals(pid)) {
						System.out.println(j2.get("kills") + "/" + j2.get("deaths") + "/" + j2.get("assists"));
						System.out.println("lv : "+j2.get("champLevel"));
						System.out.println("---------------------");
//						
//						Object kills = j2.get("kills");
//						Object deaths = j2.get("deaths");
//						Object assists = j2.get("assists");
//						Object champLevel = j2.get("champLevel");
//						
//						k = new Kda(kills, deaths, assists, champLevel);
//						kdas.add(k);
						
					}
					
				}
				url2 = "";
//				return kdas;
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return null;

	}
}
