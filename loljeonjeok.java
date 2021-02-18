import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// integer.paser ~~ 는 값들이 다 오브젝트형식이라 사용이 안되서 했씁니다. 혹시나 변환 이렇게 안하고 사용하실수 있는법을 아신다면 알려주세요! 

public class loljeonjeok {
	HttpsURLConnection huc = null;
	String api = "RGAPI-a531df28-32d7-4b3e-bbf7-78897704cbd4";
	String sname = "김길수짱";

	public String idck() {

		try {
			sname = URLEncoder.encode(sname, "utf-8");
			String url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
			url = url + sname + "?api_key=" + api;
			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject loldata = (JSONObject) jp.parse(isr);
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
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			JSONParser jp = new JSONParser();
			JSONObject loldata = (JSONObject) jp.parse(isr);
			JSONArray jjs = (JSONArray) loldata.get("matches");
			JSONObject matches = (JSONObject) jjs.get(0);
			
			for (int i = 0; i < 11; i++) {
				JSONObject jj = (JSONObject) jjs.get(i);
				System.out.println("게임번호 " + jj.get("gameId"));
				System.out.println("게임 타입 " + queuetype.queue(Integer.parseInt(jj.get("queue").toString())));
				// System.out.println("사용한 챔피언 " + jj.get("champion"));
				// int champkey = Integer.parseInt(jj.get("champion").toString());
				System.out.println("사용한 챔피언 " + champ.champnameKr(Integer.parseInt(jj.get("champion").toString())));
				Date timestamp = new Date((long) jj.get("timestamp"));
				System.out.println(timestamp);
				// System.out.println("타임스탬프 " + jj.get("timestamp"));

				System.out.println("=====================");
			}
			return matches.get("gameId"); // 제일 최근에 한 게임 아이디 리턴
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
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject loldata = (JSONObject) jp.parse(isr);
			System.out.println("게임타입 : " + queuetype.queue(Integer.parseInt(loldata.get("queueId").toString())));
			
			JSONArray teams = (JSONArray) loldata.get("teams"); 
			JSONObject blueteaminfo = (JSONObject) teams.get(0); // 블루팀 데이터
			JSONObject purpleteaminfo = (JSONObject) teams.get(1); // 레드팀 데이터
			
			if (Integer.parseInt(loldata.get("queueId").toString()) == 420) { // 솔로랭크 일때만 밴 목록 출력
				JSONArray bluebans = (JSONArray) blueteaminfo.get("bans");
				JSONArray purplebans = (JSONArray) purpleteaminfo.get("bans");
				System.out.println("블루팀 밴 : ");
				for (int i = 0; i < bluebans.size(); i++) {
					JSONObject blueban = (JSONObject) bluebans.get(i);
					System.out.println(champ.champnameKr(Integer.parseInt(blueban.get("championId").toString())));
				}
				System.out.println("퍼플팀 밴 : ");
				for (int i = 0; i < purplebans.size(); i++) {
					JSONObject purpleban = (JSONObject) purplebans.get(i);
					System.out.println(champ.champnameKr(Integer.parseInt(purpleban.get("championId").toString())));
				}

			}


			System.out.println("=====================");
			JSONArray participantIdentities = (JSONArray) loldata.get("participantIdentities");
			JSONArray participants = (JSONArray) loldata.get("participants"); // 구성원 데이터

			for (int i = 0; i < participantIdentities.size(); i++) {
				JSONObject participant1 = (JSONObject) participants.get(i); // 인게임 정보
				JSONObject stats = (JSONObject) participant1.get("stats");
				JSONObject participant2 = (JSONObject) participantIdentities.get(i); // 인게임 외적 정보
				JSONObject timeline = (JSONObject) participant1.get("timeline");
				JSONObject player = (JSONObject) participant2.get("player");
				int pId = Integer.parseInt(participant2.get("participantId").toString());
				System.out.println("게임 내 구성원 번호 " + pId);
				
				if ((boolean) stats.get("win")) {
					System.out.println("게임 결과 : 승리 ");
				} else {
					System.out.println("게임 결과 : 패배 ");
				}
				
				System.out.println("소환사명 " + player.get("summonerName"));
				System.out.println(
						"플레이한 챔피언 :" + champ.champnameKr(Integer.parseInt(participant1.get("championId").toString())));
				System.out.println(
						stats.get("kills") + "/" + stats.get("deaths") + "/" + stats.get("assists") + "\nkda : "
								+ ((Double.parseDouble(stats.get("kills").toString())
										+ Integer.parseInt(stats.get("assists").toString()))
										/ Integer.parseInt(stats.get("deaths").toString())));
			
				
					String playerLane = null;
				if (timeline.get("role").equals("DUO_SUPPORT")) {
					playerLane = "서포터";
				} else if (timeline.get("role").equals("DUO_CARRY")) {
					playerLane = "원거리 딜러";
				} else if (timeline.get("lane").equals("MIDDLE")) {
					playerLane = "미드";
				} else if (timeline.get("lane").equals("JUNGLE")) {
					playerLane = "정글";
				} else if (timeline.get("lane").equals("TOP")) {
					playerLane = "탑";
				}
				System.out.println("라인 : " + playerLane);
				
				
				
				System.out.println("구매한 아이템 : " + stats.get("item0") + "," + stats.get("item1") + ","
						+ stats.get("item2") + "," + stats.get("item3") + "," + stats.get("item4") + ","
						+ stats.get("item5") + "\n장신구: " + stats.get("item6"));
				if ((boolean) stats.get("firstBloodKill")) {
					System.out.println("선취점!");
				}
				System.out.println("=====================");
			}
		} catch (Exception e) {

			e.printStackTrace();
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
			// System.out.println("??");
//			System.out.println(Aatrox);

			// JSONArray ja =

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("안됨!");
			// TODO: handle exception
		}

	}

}
