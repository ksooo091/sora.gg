package gg.sora.dao;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import gg.sora.dto.IngameDTO;
import gg.sora.dto.matchdetailDTO;
import gg.sora.dto.matchlistDTO;

public class DAO {

	static String aid = null;
	static String sid = null;
	String api = "RGAPI-a531df28-32d7-4b3e-bbf7-78897704cbd4";
	HttpsURLConnection huc = null;
	

	public void apiver(HttpServletRequest request) {
		String url = "https://ddragon.leagueoflegends.com/api/versions.json";
		System.out.println(1);
		try {
			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			System.out.println(1);
			JSONParser jp = new JSONParser();
			System.out.println(2);
			JSONArray loldata = (JSONArray) jp.parse(isr);

			request.setAttribute("curVer", loldata.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void sumsearch(HttpServletRequest request) {

		try {
			apiver(request);
			String sname = request.getParameter("sname");
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
			aid = String.valueOf(loldata.get("accountId"));
			sid = String.valueOf(loldata.get("id"));
			request.setAttribute("sid", sid);
			System.out.println(aid);
			System.out.println("소환사 레벨 " + loldata.get("summonerLevel"));
			System.out.println(loldata.get("profileIconId"));

			request.setAttribute("sname", loldata.get("name"));
			request.setAttribute("sicon", loldata.get("profileIconId"));
			request.setAttribute("slv", loldata.get("summonerLevel"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void matchl(HttpServletRequest request) {
		apiver(request);
		try {
			String url = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/";
			url = url + aid + "?api_key=" + api;
			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject loldata = (JSONObject) jp.parse(isr);
			JSONArray jjs = (JSONArray) loldata.get("matches");
			// JSONObject matches = (JSONObject) jjs.get(0);

			ArrayList<matchlistDTO> matchlist = new ArrayList<matchlistDTO>();
			String queue = null;

			for (int i = 0; i < 10; i++) {

				matchlistDTO dto = new matchlistDTO();
				JSONObject jj = (JSONObject) jjs.get(i);
				System.out.println("게임번호 " + jj.get("gameId"));
				dto.setGameId(Long.valueOf(jj.get("gameId").toString()));
				System.out.println("게임 타입 " + QueAndPo.queue(Integer.parseInt(jj.get("queue").toString())));
				queue = QueAndPo.queue(Integer.parseInt(jj.get("queue").toString()));
				dto.setQueue(queue);
				// System.out.println("사용한 챔피언 " + jj.get("champion"));
				// int champkey = Integer.parseInt(jj.get("champion").toString());
				System.out.println("사용한 챔피언 " + champ.champnameKr(Integer.parseInt(jj.get("champion").toString())));
				Date timestamp = new Date((long) jj.get("timestamp"));
				SimpleDateFormat sdf = new SimpleDateFormat("M월 dd일 HH시 mm분 ", Locale.KOREA);
				dto.setTimestamp(sdf.format(timestamp));
				dto.setChampionKr(champ.champnameKr(Integer.parseInt(jj.get("champion").toString())));
				dto.setChampionEn(champ.champnameEn(Integer.parseInt(jj.get("champion").toString())));
				dto.setPosition(QueAndPo.position(jj.get("lane"), jj.get("role")));
				// System.out.println("타임스탬프 " + jj.get("timestamp"));
				System.out.println("=====================");
				matchlist.add(dto);
			}
			request.setAttribute("mls", matchlist);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("출력오류ㅠ");
		}

	}

	// 스펠/룬 추가하기 (초상화 옆)
	public void gamedata(HttpServletRequest request) {
		apiver(request);
		try {
			String url = "https://kr.api.riotgames.com/lol/match/v4/matches/";
			String mid = request.getParameter("mid");
			url = url + mid + "?api_key=" + api;
			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject loldata = (JSONObject) jp.parse(isr);
			System.out.println("게임타입 : " + QueAndPo.queue(Integer.parseInt(loldata.get("queueId").toString())));
			request.setAttribute("queueType", QueAndPo.queue(Integer.parseInt(loldata.get("queueId").toString())));
			JSONArray teams = (JSONArray) loldata.get("teams");
			JSONObject blueteaminfo = (JSONObject) teams.get(0); // 블루팀 데이터
			JSONObject purpleteaminfo = (JSONObject) teams.get(1); // 레드팀 데이터
			ArrayList<matchdetailDTO> mde = new ArrayList<>();
			int sec = Integer.parseInt(loldata.get("gameDuration").toString());
			int  min = sec/60;
			sec = sec%60;
			request.setAttribute("min", min);
			request.setAttribute("sec", sec);
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
				matchdetailDTO dto = new matchdetailDTO();
				JSONObject participant1 = (JSONObject) participants.get(i); // 인게임 정보
				JSONObject stats = (JSONObject) participant1.get("stats");
				JSONObject participant2 = (JSONObject) participantIdentities.get(i); // 인게임 외적 정보
				JSONObject player = (JSONObject) participant2.get("player");
				JSONObject timeline = (JSONObject) participant1.get("timeline");
			//	int pId = Integer.parseInt(participant2.get("participantId").toString());

				if ((boolean) stats.get("win")) {
					dto.setWin("승리");
				} else {
					dto.setWin("패배");
				}
				dto.setSummonerName(String.valueOf(player.get("summonerName")));
				dto.setChampionEn(champ.champnameEn(Integer.parseInt(participant1.get("championId").toString())));
				dto.setChampionKr(champ.champnameKr(Integer.parseInt(participant1.get("championId").toString())));

				dto.setPosition(QueAndPo.position(timeline.get("lane"), timeline.get("role")));

				dto.setKills(Integer.parseInt(stats.get("kills").toString()));
				dto.setDeaths(Integer.parseInt(stats.get("deaths").toString()));
				dto.setAssists(Integer.parseInt(stats.get("assists").toString()));
				dto.setKda(((Double.parseDouble(stats.get("kills").toString())
						+ Integer.parseInt(stats.get("assists").toString()))
						/ Integer.parseInt(stats.get("deaths").toString())));

				dto.setItem0(stats.get("item0"));
				dto.setItem1(stats.get("item1"));
				dto.setItem2(stats.get("item2"));
				dto.setItem3(stats.get("item3"));
				dto.setItem4(stats.get("item4"));
				dto.setItem5(stats.get("item5"));
				dto.setItem6(stats.get("item6"));
				dto.setPerkSubStyle(RunAndSpell.perks(Integer.parseInt(stats.get("perkSubStyle").toString())));
				dto.setKeyperks(RunAndSpell.perks(Integer.parseInt(stats.get("perk0").toString())));
				dto.setSpell1Id(RunAndSpell.spell(Integer.parseInt(participant1.get("spell1Id").toString())));
				dto.setSpell2Id(RunAndSpell.spell(Integer.parseInt(participant1.get("spell2Id").toString())));
				if ((boolean) stats.get("firstBloodKill")) {
					dto.setPb("선취점!");
				}
				System.out.println("=====================");
				mde.add(dto);
			}
			request.setAttribute("md", mde);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	
	public void ingamenowdetail(HttpServletRequest request) {
		apiver(request);
		try {
			String url = "https://kr.api.riotgames.com/lol/spectator/v4/active-games/by-summoner/";
			url = url + sid + "?api_key=" + api;

			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject loldata = (JSONObject) jp.parse(isr);

			request.setAttribute("queueType",
					QueAndPo.queue(Integer.parseInt(loldata.get("gameQueueConfigId").toString())));
			Date gameStartTime = new Date((long) loldata.get("gameStartTime"));
			SimpleDateFormat sdf = new SimpleDateFormat("HH시 mm분 ", Locale.KOREA);
			request.setAttribute("stratTime", sdf.format(gameStartTime));

			JSONArray participants = (JSONArray) loldata.get("participants");

			ArrayList<IngameDTO> ingame = new ArrayList<>();
			for (int i = 0; i < participants.size(); i++) {
				IngameDTO dto = new IngameDTO();
				JSONObject participant = (JSONObject) participants.get(i);

				JSONObject perks = (JSONObject) participant.get("perks");
				JSONArray perkIds = (JSONArray) perks.get("perkIds");

				dto.setTeamId(participant.get("teamId"));
				dto.setSpell1Id(RunAndSpell.spell(Integer.parseInt(participant.get("spell1Id").toString())));
				dto.setSpell2Id(RunAndSpell.spell(Integer.parseInt(participant.get("spell2Id").toString())));
				dto.setChampionIdEn(champ.champnameEn(Integer.parseInt(participant.get("championId").toString())));
				dto.setChampionIdKr(champ.champnameKr(Integer.parseInt(participant.get("championId").toString())));
				dto.setSummonerName(String.valueOf(participant.get("summonerName")));
				dto.setPerkSubStyle(RunAndSpell.perks(Integer.parseInt(perks.get("perkSubStyle").toString())));
				dto.setKeyperks(RunAndSpell.perks(Integer.parseInt(perkIds.get(0).toString())));
				
				ingame.add(dto);
			}

			request.setAttribute("igs", ingame);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void ingamenow(HttpServletRequest request) {

		try {
			String url = "https://kr.api.riotgames.com/lol/spectator/v4/active-games/by-summoner/";
			url = url + sid + "?api_key=" + api;

			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject loldata = (JSONObject) jp.parse(isr);
			request.setAttribute("nowgame", "1");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
