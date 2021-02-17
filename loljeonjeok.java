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

public class loljeonjeok {
	HttpsURLConnection huc = null;
	String api = "RGAPI-a531df28-32d7-4b3e-bbf7-78897704cbd4";
	String sname = "����¯";

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
			// ������ ��û
			// System.out.println(loldata);

//	JSONObject sumonnerdata =(JSONObject) loldata.get(0);

			System.out.println(loldata.get("name"));
			System.out.println("��ī��Ʈid " + loldata.get("accountId"));
			System.out.println("��ȯ�� ���� " + loldata.get("summonerLevel"));
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
				System.out.println("���ӹ�ȣ " + jj.get("gameId"));
				System.out.println("���� Ÿ�� " + queuetype.queue(Integer.parseInt(jj.get("queue").toString())));
				// System.out.println("����� è�Ǿ� " + jj.get("champion"));
				// int champkey = Integer.parseInt(jj.get("champion").toString());
				System.out.println("����� è�Ǿ� " + champ.champnameKr(Integer.parseInt(jj.get("champion").toString())));

				Date timestamp = new Date((long) jj.get("timestamp"));
				System.out.println(timestamp);
				// System.out.println("Ÿ�ӽ����� " + jj.get("timestamp"));

				System.out.println("=====================");
			}
			// 1612965618237 1612967175349
			return matches.get("gameId");
			// System.out.println("34");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("��¿�����");
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
			System.out.println("����Ÿ�� : " + queuetype.queue(Integer.parseInt(loldata.get("queueId").toString())));
			JSONArray participantIdentities = (JSONArray) loldata.get("participantIdentities");
			JSONArray participants = (JSONArray) loldata.get("participants");
			JSONArray teams = (JSONArray) loldata.get("teams");
//	JSONArray player = (JSONArray) participantIdentities.get("player");
			JSONObject blueteaminfo = (JSONObject) teams.get(0);
			JSONObject purpleteaminfo = (JSONObject) teams.get(1);
if (Integer.parseInt(loldata.get("queueId").toString()) == 420) {
	JSONArray bluebans = (JSONArray) blueteaminfo.get("bans");
	JSONArray purplebans = (JSONArray) purpleteaminfo.get("bans");
	System.out.println("����� ��");
	for (int i = 0; i < bluebans.size(); i++) {
		JSONObject blueban =  (JSONObject) bluebans.get(i);
		System.out.println(champ.champnameKr(Integer.parseInt(blueban.get("championId").toString())));
	}
	System.out.println("������ ��");
	for (int i = 0; i < purplebans.size(); i++) {
		JSONObject purpleban =  (JSONObject) purplebans.get(i);
		System.out.println(champ.champnameKr(Integer.parseInt(purpleban.get("championId").toString())));
	}



}			

			

//			if (blueteaminfo.get("win").equals("Win")) {
//				bluer = "Win";
//				purr = "Lose";
//			}
//			if (purpleteaminfo.get("win").equals("Win")) {
//				bluer = "Lose";
//				purr = "Win";
//			}
			System.out.println("=====================");

			for (int i = 0; i < participantIdentities.size(); i++) {
				JSONObject participant1 = (JSONObject) participants.get(i);
				JSONObject stats = (JSONObject) participant1.get("stats");
				JSONObject participant2 = (JSONObject) participantIdentities.get(i);
				JSONObject player = (JSONObject) participant2.get("player");
				int pId = Integer.parseInt(participant2.get("participantId").toString());
				System.out.println("����ڹ�ȣ " + pId);
				if ((boolean) stats.get("win")) {
					System.out.println("���� ��� : �¸� ");
				} else {
					System.out.println("���� ��� : �й� ");
				}
				System.out.println("��ȯ��� " + player.get("summonerName"));
				System.out.println(
						"�÷����� è�Ǿ� :" + champ.champnameKr(Integer.parseInt(participant1.get("championId").toString())));
				System.out.println(
						stats.get("kills") + "/" + stats.get("deaths") + "/" + stats.get("assists") + "\nkda : "
								+ ((Double.parseDouble(stats.get("kills").toString())
										+ Integer.parseInt(stats.get("assists").toString()))
										/ Integer.parseInt(stats.get("deaths").toString())));

				System.out.println("������ ������ : " + stats.get("item0") + "," + stats.get("item1") + ","
						+ stats.get("item2") + "," + stats.get("item3") + "," + stats.get("item4") + ","
						+ stats.get("item5") + "\n��ű�: " + stats.get("item6"));
				if ((boolean) stats.get("firstBloodKill")) {
					System.out.println("������!");
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
			System.out.println("�ȵ�!");
			// TODO: handle exception
		}

	}

}
