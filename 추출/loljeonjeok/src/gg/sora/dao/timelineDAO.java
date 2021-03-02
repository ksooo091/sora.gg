package gg.sora.dao;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import gg.sora.controler.main;
import gg.sora.dto.AssistDTO;
import gg.sora.dto.KillVictimDTO;
import gg.sora.dto.ParticipantDTO;

public class timelineDAO {
	String api = "RGAPI-a531df28-32d7-4b3e-bbf7-78897704cbd4";
DAO dao = new DAO();
	public ArrayList<ParticipantDTO> gamedata(HttpServletRequest request) {
		String mid = request.getParameter("mid");
		ArrayList<ParticipantDTO> participants = new ArrayList<>();

		try {

			String url = "https://kr.api.riotgames.com/lol/match/v4/matches/";
			url = url + mid + "?api_key=" + api;
			URL u = new URL(url);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject loldata = (JSONObject) jp.parse(isr);
			JSONArray participantIdentities = (JSONArray) loldata.get("participantIdentities");
			JSONArray participants2 = (JSONArray) loldata.get("participants");
			for (int i = 0; i < participantIdentities.size(); i++) {

				ParticipantDTO dto = new ParticipantDTO();
				JSONObject participant1 = (JSONObject) participants2.get(i);
				JSONObject participant = (JSONObject) participantIdentities.get(i);
				JSONObject player = (JSONObject) participant.get("player");
				dto.setChampionKr(champ.champnameKr(Integer.parseInt(participant1.get("championId").toString())));
				dto.setChampionEn(champ.champnameEn(Integer.parseInt(participant1.get("championId").toString())));
				dto.setSname(String.valueOf(player.get("summonerName")));
				dto.setParticipantId(i + 1);
				participants.add(dto);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return participants;
	}

	public void timeline(HttpServletRequest request) {
	dao.apiver(request);
		ArrayList<ParticipantDTO> participants = gamedata(request);
		ArrayList<KillVictimDTO> kv = new ArrayList<>();
		ArrayList<AssistDTO> assi = new ArrayList<>();
		for (ParticipantDTO p1 : participants) {
			System.out.println(p1.getParticipantId());
			System.out.println(p1.getSname());

		}

		for (int i = 0; i < participants.size(); i++) {
			participants.get(i).getSname();

		}

		try {
			String mid = request.getParameter("mid");
			String url = "https://kr.api.riotgames.com/lol/match/v4/timelines/by-match/";
			url = url + mid + "?api_key=" + api;

			ArrayList<ParticipantDTO> participants2 = new ArrayList<>();
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
						KillVictimDTO dto1 = new KillVictimDTO();
						assi = new ArrayList<>();
						JSONArray assist = (JSONArray) inevent.get("assistingParticipantIds");

						System.out.println("밀리초 =" + inevent.get("timestamp"));
						
						
						int sec = Integer.parseInt(inevent.get("timestamp").toString()) / 1000;
						int min = sec / 60;
						sec = sec % 60;
						String timestamp = min+"분"+sec+"초";
						dto1.setTimestamp(timestamp);
						
						
						
						System.out.println("죽인놈 =" + inevent.get("killerId"));
						System.out.println("죽인놈 =" + participants
								.get(Integer.parseInt(inevent.get("killerId").toString()) - 1).getSname());
						dto1.setKillSname(participants.get(Integer.parseInt(inevent.get("killerId").toString()) - 1).getSname());
						dto1.setKillChampionKr( participants.get(Integer.parseInt(inevent.get("killerId").toString()) - 1).getChampionKr());
						dto1.setKillChampionEn( participants.get(Integer.parseInt(inevent.get("killerId").toString()) - 1).getChampionEn());
						System.out.println("죽인놈 =" + participants.get(Integer.parseInt(inevent.get("killerId").toString()) - 1).getChampionKr());
						
						System.out.println("죽여진놈=" + inevent.get("victimId"));
						dto1.setVictimSname(participants.get(Integer.parseInt(inevent.get("victimId").toString()) - 1).getSname());
						dto1.setVictimChampionKr(participants.get(Integer.parseInt(inevent.get("victimId").toString()) - 1).getChampionKr());
						dto1.setVictimChampionEn(participants.get(Integer.parseInt(inevent.get("victimId").toString()) - 1).getChampionEn());
						System.out.println("죽여진놈=" + participants.get(Integer.parseInt(inevent.get("victimId").toString()) - 1).getSname());
						
					
						
						for (int k = 0; k < assist.size(); k++) {
							AssistDTO dto2 = new AssistDTO();
							System.out.println("어시스트=" + participants.get(Integer.parseInt(assist.get(k).toString()) - 1).getSname());
							System.out.println("어시 챔프 이름" + participants.get(Integer.parseInt(assist.get(k).toString()) - 1).getChampionEn());
							dto2.setAssistSname(participants.get(Integer.parseInt(assist.get(k).toString()) - 1).getSname());
							dto2.setAssistChampionKr(participants.get(Integer.parseInt(assist.get(k).toString()) - 1).getChampionKr());
							dto2.setAssistChampionEn(participants.get(Integer.parseInt(assist.get(k).toString()) - 1).getChampionEn());
							
//							System.out.println("어시스트 :" + assist.get(k));	
							assi.add(dto2);
							
							
						}
					
						dto1.setAssistList(assi); // 이게 다 반복되서 드가는 중
						System.out.println("****************");
						System.out.println(dto1.getAssistList());
						kv.add(dto1);
//						request.setAttribute("assi", assi);

						System.out.println("-----------------------------");
					}
					
				}
			}
		//	request.setAttribute("assi", assi);
			for (int i = 0; i < assi.size(); i++) {
//				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//				System.out.println(assi.get(i).getAssistChampionKr());
//				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			}
			
			request.setAttribute("kv", kv);

	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
