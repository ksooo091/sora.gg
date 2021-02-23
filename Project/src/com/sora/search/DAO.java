package com.sora.search;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DAO {

	static HttpsURLConnection huc = null;
	static String api = "RGAPI-a531df28-32d7-4b3e-bbf7-78897704cbd4";

	public static void Info(HttpServletRequest request) {

		try {

			String summonerName = request.getParameter("id");

			String url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
			url = url + summonerName + "?api_key=" + api;

			URL u = new URL(url);

			huc = (HttpsURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();

			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();

			JSONObject loldata = (JSONObject) jp.parse(isr);

			System.out.println(loldata);

//			imgUrl = imgUrl + loldata.

			request.setAttribute("loldata", loldata);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void rotation(HttpServletRequest request) {

		try {
			String url = "https://kr.api.riotgames.com/lol/platform/v3/champion-rotations/";
			url = url + "?api_key=" + api;

			URL u = new URL(url);

			huc = (HttpsURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();

			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();

			JSONObject rotation = (JSONObject) jp.parse(isr);

			// System.out.println(rotation); // 로테이션 관련 정보 확인

			JSONArray jo2 = (JSONArray) rotation.get("freeChampionIds");

			// System.out.println(jo2.get(0)); // 로테이션 챔피언 고유번호 확인

			ArrayList<ChampName> ChampNames = new ArrayList<ChampName>();

			for (Object r : jo2) {
				ChampName cn = new ChampName();
//				System.out.println(r); // 이게 숫자 하나
				int r2 = Integer.parseInt(r + "");
				// System.out.println(r2);

				String ChampNameKr = null;

				switch (r2) {
				case 266:
					ChampNameKr = "아트록스";
					break; // 챔피언 한글 이름
				case 412:
					ChampNameKr = "쓰레쉬";
					break;
				case 23:
					ChampNameKr = "트린다미어";
					break;
				case 79:
					ChampNameKr = "그라가스";
					break;
				case 69:
					ChampNameKr = "카시오페아";
					break;
				case 136:
					ChampNameKr = "아우렐리온 솔";
					break;
				case 13:
					ChampNameKr = "라이즈";
					break;
				case 78:
					ChampNameKr = "뽀삐";
					break;
				case 14:
					ChampNameKr = "사이온";
					break;
				case 1:
					ChampNameKr = "애니";
					break;
				case 202:
					ChampNameKr = "진";
					break;
				case 43:
					ChampNameKr = "카르마";
					break;
				case 111:
					ChampNameKr = "노틸러스";
					break;
				case 240:
					ChampNameKr = "클레드";
					break;
				case 99:
					ChampNameKr = "럭스";
					break;
				case 103:
					ChampNameKr = "아리";
					break;
				case 2:
					ChampNameKr = "올라프";
					break;
				case 112:
					ChampNameKr = "빅토르";
					break;
				case 34:
					ChampNameKr = "애니비아";
					break;
				case 27:
					ChampNameKr = "신지드";
					break;
				case 86:
					ChampNameKr = "가렌";
					break;
				case 127:
					ChampNameKr = "리산드라";
					break;
				case 57:
					ChampNameKr = "마오카이";
					break;
				case 25:
					ChampNameKr = "모르가나";
					break;
				case 28:
					ChampNameKr = "이블린";
					break;
				case 105:
					ChampNameKr = "피즈";
					break;
				case 74:
					ChampNameKr = "하이머딩거";
					break;
				case 238:
					ChampNameKr = "제드";
					break;
				case 68:
					ChampNameKr = "럼블";
					break;
				case 82:
					ChampNameKr = "모데카이저";
					break;
				case 37:
					ChampNameKr = "소나";
					break;
				case 96:
					ChampNameKr = "코그모";
					break;
				case 55:
					ChampNameKr = "카타리나";
					break;
				case 117:
					ChampNameKr = "룰루";
					break;
				case 22:
					ChampNameKr = "애쉬";
					break;
				case 30:
					ChampNameKr = "카서스";
					break;
				case 12:
					ChampNameKr = "알리스타";
					break;
				case 122:
					ChampNameKr = "다리우스";
					break;
				case 67:
					ChampNameKr = "베인";
					break;
				case 110:
					ChampNameKr = "바루스";
					break;
				case 77:
					ChampNameKr = "우디르";
					break;
				case 89:
					ChampNameKr = "레오나";
					break;
				case 126:
					ChampNameKr = "제이스";
					break;
				case 134:
					ChampNameKr = "신드라";
					break;
				case 80:
					ChampNameKr = "판테온";
					break;
				case 92:
					ChampNameKr = "리븐";
					break;
				case 121:
					ChampNameKr = "카직스";
					break;
				case 42:
					ChampNameKr = "코르키";
					break;
				case 268:
					ChampNameKr = "아지르";
					break;
				case 51:
					ChampNameKr = "케이틀린";
					break;
				case 76:
					ChampNameKr = "니달리";
					break;
				case 85:
					ChampNameKr = "케인";
					break;
				case 3:
					ChampNameKr = "갈리오";
					break;
				case 45:
					ChampNameKr = "베이가";
					break;
				case 432:
					ChampNameKr = "바드";
					break;
				case 150:
					ChampNameKr = "나르";
					break;
				case 90:
					ChampNameKr = "말자하";
					break;
				case 104:
					ChampNameKr = "그레이브즈";
					break;
				case 254:
					ChampNameKr = "바이";
					break;
				case 10:
					ChampNameKr = "케일";
					break;
				case 39:
					ChampNameKr = "이렐리아";
					break;
				case 64:
					ChampNameKr = "리 신";
					break;
				case 420:
					ChampNameKr = "일라오이";
					break;
				case 60:
					ChampNameKr = "엘리스";
					break;
				case 106:
					ChampNameKr = "볼리베어";
					break;
				case 20:
					ChampNameKr = "누누와 윌럼프";
					break;
				case 4:
					ChampNameKr = "트위스티드 페이트";
					break;
				case 24:
					ChampNameKr = "잭스";
					break;
				case 102:
					ChampNameKr = "쉬바나";
					break;
				case 429:
					ChampNameKr = "칼리스타";
					break;
				case 36:
					ChampNameKr = "문도 박사";
					break;
				case 427:
					ChampNameKr = "아이번";
					break;
				case 131:
					ChampNameKr = "다이애나";
					break;
				case 63:
					ChampNameKr = "브랜드";
					break;
				case 113:
					ChampNameKr = "세주아니";
					break;
				case 8:
					ChampNameKr = "블라디미르";
					break;
				case 154:
					ChampNameKr = "자크";
					break;
				case 421:
					ChampNameKr = "렉사이";
					break;
				case 133:
					ChampNameKr = "퀸";
					break;
				case 84:
					ChampNameKr = "아칼리";
					break;
				case 163:
					ChampNameKr = "탈리아";
					break;
				case 18:
					ChampNameKr = "트리스타나";
					break;
				case 120:
					ChampNameKr = "헤카림";
					break;
				case 15:
					ChampNameKr = "시비르";
					break;
				case 236:
					ChampNameKr = "루시안";
					break;
				case 107:
					ChampNameKr = "렝가";
					break;
				case 19:
					ChampNameKr = "워윅";
					break;
				case 72:
					ChampNameKr = "스카너";
					break;
				case 54:
					ChampNameKr = "말파이트";
					break;
				case 157:
					ChampNameKr = "야스오";
					break;
				case 101:
					ChampNameKr = "제라스";
					break;
				case 17:
					ChampNameKr = "티모";
					break;
				case 75:
					ChampNameKr = "나서스";
					break;
				case 58:
					ChampNameKr = "레넥톤";
					break;
				case 119:
					ChampNameKr = "드레이븐";
					break;
				case 35:
					ChampNameKr = "샤코";
					break;
				case 50:
					ChampNameKr = "스웨인";
					break;
				case 91:
					ChampNameKr = "탈론";
					break;
				case 40:
					ChampNameKr = "잔나";
					break;
				case 115:
					ChampNameKr = "직스";
					break;
				case 245:
					ChampNameKr = "에코";
					break;
				case 61:
					ChampNameKr = "오리아나";
					break;
				case 114:
					ChampNameKr = "피오라";
					break;
				case 9:
					ChampNameKr = "피들스틱";
					break;
				case 31:
					ChampNameKr = "초가스";
					break;
				case 33:
					ChampNameKr = "람머스";
					break;
				case 7:
					ChampNameKr = "르블랑";
					break;
				case 16:
					ChampNameKr = "소라카";
					break;
				case 26:
					ChampNameKr = "질리언";
					break;
				case 56:
					ChampNameKr = "녹턴";
					break;
				case 222:
					ChampNameKr = "징크스";
					break;
				case 83:
					ChampNameKr = "요릭";
					break;
				case 6:
					ChampNameKr = "우르곳";
					break;
				case 203:
					ChampNameKr = "킨드레드";
					break;
				case 21:
					ChampNameKr = "미스 포츈";
					break;
				case 62:
					ChampNameKr = "오공";
					break;
				case 53:
					ChampNameKr = "블리츠크랭크";
					break;
				case 98:
					ChampNameKr = "쉔";
					break;
				case 201:
					ChampNameKr = "브라움";
					break;
				case 5:
					ChampNameKr = "신 짜오";
					break;
				case 29:
					ChampNameKr = "트위치";
					break;
				case 11:
					ChampNameKr = "마스터 이";
					break;
				case 44:
					ChampNameKr = "타릭";
					break;
				case 32:
					ChampNameKr = "아무무";
					break;
				case 41:
					ChampNameKr = "갱플랭크";
					break;
				case 48:
					ChampNameKr = "트런들";
					break;
				case 38:
					ChampNameKr = "카사딘";
					break;
				case 161:
					ChampNameKr = "벨코즈";
					break;
				case 143:
					ChampNameKr = "자이라";
					break;
				case 267:
					ChampNameKr = "나미";
					break;
				case 59:
					ChampNameKr = "자르반 4세";
					break;
				case 81:
					ChampNameKr = "이즈리얼";
					break;
				case 350:
					ChampNameKr = "유미";
					break;
				case 145:
					ChampNameKr = "카이사";
					break;
				case 518:
					ChampNameKr = "니코";
					break;
				case 142:
					ChampNameKr = "조이";
					break;
				case 498:
					ChampNameKr = "자야";
					break;
				case 517:
					ChampNameKr = "사일러스";
					break;
				case 141:
					ChampNameKr = "케인";
					break;
				case 516:
					ChampNameKr = "오른";
					break;
				case 555:
					ChampNameKr = "파이크";
					break;
				case 164:
					ChampNameKr = "카밀";
					break;
				case 246:
					ChampNameKr = "키아나";
					break;
				case 497:
					ChampNameKr = "라칸";
					break;
				case 777:
					ChampNameKr = "요네";
					break;
				case 876:
					ChampNameKr = "릴리아";
					break;
				case 235:
					ChampNameKr = "세나";
					break;
				case 875:
					ChampNameKr = "세트";
					break;
				case 523:
					ChampNameKr = "아펠리오스";
					break;
				case 223:
					ChampNameKr = "탐 켄치";
					break;
				case 360:
					ChampNameKr = "사미라";
					break;
				case 147:
					ChampNameKr = "세라핀";
					break;
				case 526:
					ChampNameKr = "렐";
					break;
				case 234:
					ChampNameKr = "비에고";
					break;

				default:
					ChampNameKr = "오류";
					break;

				}

				cn.setName(ChampNameKr);
				System.out.println(cn.getName());
				cn.setNo(r2);
				System.out.println(cn.getNo());
				ChampNames.add(cn);

			}
			request.setAttribute("champNameKr", ChampNames);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void rotationImg(HttpServletRequest request) {

		try {
			String url = "https://kr.api.riotgames.com/lol/platform/v3/champion-rotations/";
			url = url + "?api_key=" + api;

			URL u;
			u = new URL(url);

			huc = (HttpsURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();

			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();

			JSONObject rotation = (JSONObject) jp.parse(isr);

			// System.out.println(rotation); // 로테이션 관련 정보 확인

			JSONArray jo2 = (JSONArray) rotation.get("freeChampionIds");

			ArrayList<ChampName> champnames = new ArrayList<ChampName>();

			for (Object r : jo2) {
				ChampName cn = new ChampName();
//				System.out.println(r); // 이게 숫자 하나
				int r2 = Integer.parseInt(r + "");
				// System.out.println(r2);

				String champName = null;

				switch (r2) {
				case 266:
					champName = "Aatrox";
					break; // 챔피언 영어 이름
				case 412:
					champName = "Thresh";
					break;
				case 23:
					champName = "Tryndamere";
					break;
				case 79:
					champName = "Gragas";
					break;
				case 69:
					champName = "Cassiopeia";
					break;
				case 136:
					champName = "AurelionSol";
					break;
				case 13:
					champName = "Ryze";
					break;
				case 78:
					champName = "Poppy";
					break;
				case 14:
					champName = "Sion";
					break;
				case 1:
					champName = "Annie";
					break;
				case 202:
					champName = "Jhin";
					break;
				case 43:
					champName = "Karma";
					break;
				case 111:
					champName = "Nautilus";
					break;
				case 240:
					champName = "Kled";
					break;
				case 99:
					champName = "Lux";
					break;
				case 103:
					champName = "Ahri";
					break;
				case 2:
					champName = "Olaf";
					break;
				case 112:
					champName = "Viktor";
					break;
				case 34:
					champName = "Anivia";
					break;
				case 27:
					champName = "Singed";
					break;
				case 86:
					champName = "Garen";
					break;
				case 127:
					champName = "Lissandra";
					break;
				case 57:
					champName = "Maokai";
					break;
				case 25:
					champName = "Morgana";
					break;
				case 28:
					champName = "Evelynn";
					break;
				case 105:
					champName = "Fizz";
					break;
				case 74:
					champName = "Heimerdinger";
					break;
				case 238:
					champName = "Zed";
					break;
				case 68:
					champName = "Rumble";
					break;
				case 82:
					champName = "Mordekaiser";
					break;
				case 37:
					champName = "Sona";
					break;
				case 96:
					champName = "KogMaw";
					break;
				case 55:
					champName = "Katarina";
					break;
				case 117:
					champName = "Lulu";
					break;
				case 22:
					champName = "Ashe";
					break;
				case 30:
					champName = "Karthus";
					break;
				case 12:
					champName = "Alistar";
					break;
				case 122:
					champName = "Darius";
					break;
				case 67:
					champName = "Vayne";
					break;
				case 110:
					champName = "Varus";
					break;
				case 77:
					champName = "Udyr";
					break;
				case 89:
					champName = "Leona";
					break;
				case 126:
					champName = "Jayce";
					break;
				case 134:
					champName = "Syndra";
					break;
				case 80:
					champName = "Pantheon";
					break;
				case 92:
					champName = "Riven";
					break;
				case 121:
					champName = "Khazix";
					break;
				case 42:
					champName = "Corki";
					break;
				case 268:
					champName = "Azir";
					break;
				case 51:
					champName = "Caitlyn";
					break;
				case 76:
					champName = "Nidalee";
					break;
				case 85:
					champName = "Kennen";
					break;
				case 3:
					champName = "Galio";
					break;
				case 45:
					champName = "Veigar";
					break;
				case 432:
					champName = "Bard";
					break;
				case 150:
					champName = "Gnar";
					break;
				case 90:
					champName = "Malzahar";
					break;
				case 104:
					champName = "Graves";
					break;
				case 254:
					champName = "Vi";
					break;
				case 10:
					champName = "Kayle";
					break;
				case 39:
					champName = "Irelia";
					break;
				case 64:
					champName = "LeeSin";
					break;
				case 420:
					champName = "Illaoi";
					break;
				case 60:
					champName = "Elise";
					break;
				case 106:
					champName = "Volibear";
					break;
				case 20:
					champName = "Nunu";
					break;
				case 4:
					champName = "TwistedFate";
					break;
				case 24:
					champName = "Jax";
					break;
				case 102:
					champName = "Shyvana";
					break;
				case 429:
					champName = "Kalista";
					break;
				case 36:
					champName = "DrMundo";
					break;
				case 427:
					champName = "Ivern";
					break;
				case 131:
					champName = "Diana";
					break;
				case 63:
					champName = "Brand";
					break;
				case 113:
					champName = "Sejuani";
					break;
				case 8:
					champName = "Vladimir";
					break;
				case 154:
					champName = "Zac";
					break;
				case 421:
					champName = "RekSai";
					break;
				case 133:
					champName = "Quinn";
					break;
				case 84:
					champName = "Akali";
					break;
				case 163:
					champName = "Taliyah";
					break;
				case 18:
					champName = "Tristana";
					break;
				case 120:
					champName = "Hecarim";
					break;
				case 15:
					champName = "Sivir";
					break;
				case 236:
					champName = "Lucian";
					break;
				case 107:
					champName = "Rengar";
					break;
				case 19:
					champName = "Warwick";
					break;
				case 72:
					champName = "Skarner";
					break;
				case 54:
					champName = "Malphite";
					break;
				case 157:
					champName = "Yasuo";
					break;
				case 101:
					champName = "Xerath";
					break;
				case 17:
					champName = "Teemo";
					break;
				case 75:
					champName = "Nasus";
					break;
				case 58:
					champName = "Renekton";
					break;
				case 119:
					champName = "Draven";
					break;
				case 35:
					champName = "Shaco";
					break;
				case 50:
					champName = "Swain";
					break;
				case 91:
					champName = "Talon";
					break;
				case 40:
					champName = "Janna";
					break;
				case 115:
					champName = "Ziggs";
					break;
				case 245:
					champName = "Ekko";
					break;
				case 61:
					champName = "Orianna";
					break;
				case 114:
					champName = "Fiora";
					break;
				case 9:
					champName = "Fiddlesticks";
					break;
				case 31:
					champName = "ChoGath";
					break;
				case 33:
					champName = "Rammus";
					break;
				case 7:
					champName = "Leblanc";
					break;
				case 16:
					champName = "Soraka";
					break;
				case 26:
					champName = "Zilean";
					break;
				case 56:
					champName = "Nocturne";
					break;
				case 222:
					champName = "Jinx";
					break;
				case 83:
					champName = "Yorick";
					break;
				case 6:
					champName = "Urgot";
					break;
				case 203:
					champName = "Kindred";
					break;
				case 21:
					champName = "MissFortune";
					break;
				case 62:
					champName = "MonkeyKing";
					break;
				case 53:
					champName = "Blitzcrank";
					break;
				case 98:
					champName = "Shen";
					break;
				case 201:
					champName = "Braum";
					break;
				case 5:
					champName = "XinZhao";
					break;
				case 29:
					champName = "Twitch";
					break;
				case 11:
					champName = "MasterYi";
					break;
				case 44:
					champName = "Taric";
					break;
				case 32:
					champName = "Amumu";
					break;
				case 41:
					champName = "Gangplank";
					break;
				case 48:
					champName = "Trundle";
					break;
				case 38:
					champName = "Kassadin";
					break;
				case 161:
					champName = "Velkoz";
					break;
				case 143:
					champName = "Zyra";
					break;
				case 267:
					champName = "Nami";
					break;
				case 59:
					champName = "JarvanIV";
					break;
				case 81:
					champName = "Ezreal";
					break;
				case 350:
					champName = "Yuumi";
					break;
				case 145:
					champName = "Kaisa";
					break;
				case 518:
					champName = "Neeko";
					break;
				case 142:
					champName = "Zoe";
					break;
				case 498:
					champName = "Xayah";
					break;
				case 517:
					champName = "Sylas";
					break;
				case 141:
					champName = "Kayn";
					break;
				case 516:
					champName = "Ornn";
					break;
				case 555:
					champName = "Pyke";
					break;
				case 164:
					champName = "Camille";
					break;
				case 246:
					champName = "Qiyana";
					break;
				case 497:
					champName = "Rakan";
					break;
				case 777:
					champName = "Yone";
					break;
				case 876:
					champName = "Lillia";
					break;
				case 235:
					champName = "Senna";
					break;
				case 875:
					champName = "Sett";
					break;
				case 523:
					champName = "Aphelios";
					break;

				case 223:
					champName = "TahmKench";
					break;

				case 147:
					champName = "Seraphine";
					break;
				case 360:
					champName = "Samira";
					break;
				case 234:
					champName = "Viego";
					break;
				case 526:
					champName = "Rell";
					break;

				default:
					champName = "오류";
					break;

				}
				cn.setName(champName);
				System.out.println(cn.getName());
				cn.setNo(r2);
				System.out.println(cn.getNo());
				champnames.add(cn);

			}
			request.setAttribute("champName", champnames);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void championSkill(HttpServletRequest request) {

		try {

			int champNum = Integer.parseInt(request.getParameter("no"));

			String champName = null;

			ChampName cn = new ChampName();

			switch (champNum) {
			case 266:
				champName = "Aatrox";
				break; // 챔피언 영어 이름
			case 412:
				champName = "Thresh";
				break;
			case 23:
				champName = "Tryndamere";
				break;
			case 79:
				champName = "Gragas";
				break;
			case 69:
				champName = "Cassiopeia";
				break;
			case 136:
				champName = "AurelionSol";
				break;
			case 13:
				champName = "Ryze";
				break;
			case 78:
				champName = "Poppy";
				break;
			case 14:
				champName = "Sion";
				break;
			case 1:
				champName = "Annie";
				break;
			case 202:
				champName = "Jhin";
				break;
			case 43:
				champName = "Karma";
				break;
			case 111:
				champName = "Nautilus";
				break;
			case 240:
				champName = "Kled";
				break;
			case 99:
				champName = "Lux";
				break;
			case 103:
				champName = "Ahri";
				break;
			case 2:
				champName = "Olaf";
				break;
			case 112:
				champName = "Viktor";
				break;
			case 34:
				champName = "Anivia";
				break;
			case 27:
				champName = "Singed";
				break;
			case 86:
				champName = "Garen";
				break;
			case 127:
				champName = "Lissandra";
				break;
			case 57:
				champName = "Maokai";
				break;
			case 25:
				champName = "Morgana";
				break;
			case 28:
				champName = "Evelynn";
				break;
			case 105:
				champName = "Fizz";
				break;
			case 74:
				champName = "Heimerdinger";
				break;
			case 238:
				champName = "Zed";
				break;
			case 68:
				champName = "Rumble";
				break;
			case 82:
				champName = "Mordekaiser";
				break;
			case 37:
				champName = "Sona";
				break;
			case 96:
				champName = "KogMaw";
				break;
			case 55:
				champName = "Katarina";
				break;
			case 117:
				champName = "Lulu";
				break;
			case 22:
				champName = "Ashe";
				break;
			case 30:
				champName = "Karthus";
				break;
			case 12:
				champName = "Alistar";
				break;
			case 122:
				champName = "Darius";
				break;
			case 67:
				champName = "Vayne";
				break;
			case 110:
				champName = "Varus";
				break;
			case 77:
				champName = "Udyr";
				break;
			case 89:
				champName = "Leona";
				break;
			case 126:
				champName = "Jayce";
				break;
			case 134:
				champName = "Syndra";
				break;
			case 80:
				champName = "Pantheon";
				break;
			case 92:
				champName = "Riven";
				break;
			case 121:
				champName = "Khazix";
				break;
			case 42:
				champName = "Corki";
				break;
			case 268:
				champName = "Azir";
				break;
			case 51:
				champName = "Caitlyn";
				break;
			case 76:
				champName = "Nidalee";
				break;
			case 85:
				champName = "Kennen";
				break;
			case 3:
				champName = "Galio";
				break;
			case 45:
				champName = "Veigar";
				break;
			case 432:
				champName = "Bard";
				break;
			case 150:
				champName = "Gnar";
				break;
			case 90:
				champName = "Malzahar";
				break;
			case 104:
				champName = "Graves";
				break;
			case 254:
				champName = "Vi";
				break;
			case 10:
				champName = "Kayle";
				break;
			case 39:
				champName = "Irelia";
				break;
			case 64:
				champName = "LeeSin";
				break;
			case 420:
				champName = "Illaoi";
				break;
			case 60:
				champName = "Elise";
				break;
			case 106:
				champName = "Volibear";
				break;
			case 20:
				champName = "Nunu";
				break;
			case 4:
				champName = "TwistedFate";
				break;
			case 24:
				champName = "Jax";
				break;
			case 102:
				champName = "Shyvana";
				break;
			case 429:
				champName = "Kalista";
				break;
			case 36:
				champName = "DrMundo";
				break;
			case 427:
				champName = "Ivern";
				break;
			case 131:
				champName = "Diana";
				break;
			case 63:
				champName = "Brand";
				break;
			case 113:
				champName = "Sejuani";
				break;
			case 8:
				champName = "Vladimir";
				break;
			case 154:
				champName = "Zac";
				break;
			case 421:
				champName = "RekSai";
				break;
			case 133:
				champName = "Quinn";
				break;
			case 84:
				champName = "Akali";
				break;
			case 163:
				champName = "Taliyah";
				break;
			case 18:
				champName = "Tristana";
				break;
			case 120:
				champName = "Hecarim";
				break;
			case 15:
				champName = "Sivir";
				break;
			case 236:
				champName = "Lucian";
				break;
			case 107:
				champName = "Rengar";
				break;
			case 19:
				champName = "Warwick";
				break;
			case 72:
				champName = "Skarner";
				break;
			case 54:
				champName = "Malphite";
				break;
			case 157:
				champName = "Yasuo";
				break;
			case 101:
				champName = "Xerath";
				break;
			case 17:
				champName = "Teemo";
				break;
			case 75:
				champName = "Nasus";
				break;
			case 58:
				champName = "Renekton";
				break;
			case 119:
				champName = "Draven";
				break;
			case 35:
				champName = "Shaco";
				break;
			case 50:
				champName = "Swain";
				break;
			case 91:
				champName = "Talon";
				break;
			case 40:
				champName = "Janna";
				break;
			case 115:
				champName = "Ziggs";
				break;
			case 245:
				champName = "Ekko";
				break;
			case 61:
				champName = "Orianna";
				break;
			case 114:
				champName = "Fiora";
				break;
			case 9:
				champName = "Fiddlesticks";
				break;
			case 31:
				champName = "ChoGath";
				break;
			case 33:
				champName = "Rammus";
				break;
			case 7:
				champName = "Leblanc";
				break;
			case 16:
				champName = "Soraka";
				break;
			case 26:
				champName = "Zilean";
				break;
			case 56:
				champName = "Nocturne";
				break;
			case 222:
				champName = "Jinx";
				break;
			case 83:
				champName = "Yorick";
				break;
			case 6:
				champName = "Urgot";
				break;
			case 203:
				champName = "Kindred";
				break;
			case 21:
				champName = "MissFortune";
				break;
			case 62:
				champName = "MonkeyKing";
				break;
			case 53:
				champName = "Blitzcrank";
				break;
			case 98:
				champName = "Shen";
				break;
			case 201:
				champName = "Braum";
				break;
			case 5:
				champName = "XinZhao";
				break;
			case 29:
				champName = "Twitch";
				break;
			case 11:
				champName = "MasterYi";
				break;
			case 44:
				champName = "Taric";
				break;
			case 32:
				champName = "Amumu";
				break;
			case 41:
				champName = "Gangplank";
				break;
			case 48:
				champName = "Trundle";
				break;
			case 38:
				champName = "Kassadin";
				break;
			case 161:
				champName = "Velkoz";
				break;
			case 143:
				champName = "Zyra";
				break;
			case 267:
				champName = "Nami";
				break;
			case 59:
				champName = "JarvanIV";
				break;
			case 81:
				champName = "Ezreal";
				break;
			case 350:
				champName = "Yuumi";
				break;
			case 145:
				champName = "Kaisa";
				break;
			case 518:
				champName = "Neeko";
				break;
			case 142:
				champName = "Zoe";
				break;
			case 498:
				champName = "Xayah";
				break;
			case 517:
				champName = "Sylas";
				break;
			case 141:
				champName = "Kayn";
				break;
			case 516:
				champName = "Ornn";
				break;
			case 555:
				champName = "Pyke";
				break;
			case 164:
				champName = "Camille";
				break;
			case 246:
				champName = "Qiyana";
				break;
			case 497:
				champName = "Rakan";
				break;
			case 777:
				champName = "Yone";
				break;
			case 876:
				champName = "Lillia";
				break;
			case 235:
				champName = "Senna";
				break;
			case 875:
				champName = "Sett";
				break;
			case 523:
				champName = "Aphelios";
				break;

			case 223:
				champName = "TahmKench";
				break;

			case 147:
				champName = "Seraphine";
				break;
			case 360:
				champName = "Samira";
				break;
			case 234:
				champName = "Viego";
				break;
			case 526:
				champName = "Rell";
				break;

			default:
				champName = "오류";
				break;

			}

			HttpURLConnection huc = null;
			String url = "http://ddragon.leagueoflegends.com/cdn/11.4.1/data/ko_KR/championFull.json";

			URL u;
			u = new URL(url);

			huc = (HttpURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();

			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();

			JSONObject championFull = (JSONObject) jp.parse(isr);

			JSONObject jo = (JSONObject) championFull.get("data");
			JSONObject championName = (JSONObject) jo.get(champName);

			JSONArray skills = (JSONArray) championName.get("spells");
			System.out.println(skills.get(0));
			for (Object object : skills) {
				JSONObject jo1 = (JSONObject) object;
				JSONObject img = (JSONObject) jo1.get("image");
				System.out.println(img.get("full"));

				cn.setName(champName);
				cn.setNo(champNum);

			}
			request.setAttribute("cn", cn);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void championPassive(HttpServletRequest request) {
		try {
			int champNum = Integer.parseInt(request.getParameter("no"));

			String champName = null;

			switch (champNum) {
			case 266:
				champName = "Aatrox";
				break; // 챔피언 영어 이름
			case 412:
				champName = "Thresh";
				break;
			case 23:
				champName = "Tryndamere";
				break;
			case 79:
				champName = "Gragas";
				break;
			case 69:
				champName = "Cassiopeia";
				break;
			case 136:
				champName = "AurelionSol";
				break;
			case 13:
				champName = "Ryze";
				break;
			case 78:
				champName = "Poppy";
				break;
			case 14:
				champName = "Sion";
				break;
			case 1:
				champName = "Annie";
				break;
			case 202:
				champName = "Jhin";
				break;
			case 43:
				champName = "Karma";
				break;
			case 111:
				champName = "Nautilus";
				break;
			case 240:
				champName = "Kled";
				break;
			case 99:
				champName = "Lux";
				break;
			case 103:
				champName = "Ahri";
				break;
			case 2:
				champName = "Olaf";
				break;
			case 112:
				champName = "Viktor";
				break;
			case 34:
				champName = "Anivia";
				break;
			case 27:
				champName = "Singed";
				break;
			case 86:
				champName = "Garen";
				break;
			case 127:
				champName = "Lissandra";
				break;
			case 57:
				champName = "Maokai";
				break;
			case 25:
				champName = "Morgana";
				break;
			case 28:
				champName = "Evelynn";
				break;
			case 105:
				champName = "Fizz";
				break;
			case 74:
				champName = "Heimerdinger";
				break;
			case 238:
				champName = "Zed";
				break;
			case 68:
				champName = "Rumble";
				break;
			case 82:
				champName = "Mordekaiser";
				break;
			case 37:
				champName = "Sona";
				break;
			case 96:
				champName = "KogMaw";
				break;
			case 55:
				champName = "Katarina";
				break;
			case 117:
				champName = "Lulu";
				break;
			case 22:
				champName = "Ashe";
				break;
			case 30:
				champName = "Karthus";
				break;
			case 12:
				champName = "Alistar";
				break;
			case 122:
				champName = "Darius";
				break;
			case 67:
				champName = "Vayne";
				break;
			case 110:
				champName = "Varus";
				break;
			case 77:
				champName = "Udyr";
				break;
			case 89:
				champName = "Leona";
				break;
			case 126:
				champName = "Jayce";
				break;
			case 134:
				champName = "Syndra";
				break;
			case 80:
				champName = "Pantheon";
				break;
			case 92:
				champName = "Riven";
				break;
			case 121:
				champName = "Khazix";
				break;
			case 42:
				champName = "Corki";
				break;
			case 268:
				champName = "Azir";
				break;
			case 51:
				champName = "Caitlyn";
				break;
			case 76:
				champName = "Nidalee";
				break;
			case 85:
				champName = "Kennen";
				break;
			case 3:
				champName = "Galio";
				break;
			case 45:
				champName = "Veigar";
				break;
			case 432:
				champName = "Bard";
				break;
			case 150:
				champName = "Gnar";
				break;
			case 90:
				champName = "Malzahar";
				break;
			case 104:
				champName = "Graves";
				break;
			case 254:
				champName = "Vi";
				break;
			case 10:
				champName = "Kayle";
				break;
			case 39:
				champName = "Irelia";
				break;
			case 64:
				champName = "LeeSin";
				break;
			case 420:
				champName = "Illaoi";
				break;
			case 60:
				champName = "Elise";
				break;
			case 106:
				champName = "Volibear";
				break;
			case 20:
				champName = "Nunu";
				break;
			case 4:
				champName = "TwistedFate";
				break;
			case 24:
				champName = "Jax";
				break;
			case 102:
				champName = "Shyvana";
				break;
			case 429:
				champName = "Kalista";
				break;
			case 36:
				champName = "DrMundo";
				break;
			case 427:
				champName = "Ivern";
				break;
			case 131:
				champName = "Diana";
				break;
			case 63:
				champName = "Brand";
				break;
			case 113:
				champName = "Sejuani";
				break;
			case 8:
				champName = "Vladimir";
				break;
			case 154:
				champName = "Zac";
				break;
			case 421:
				champName = "RekSai";
				break;
			case 133:
				champName = "Quinn";
				break;
			case 84:
				champName = "Akali";
				break;
			case 163:
				champName = "Taliyah";
				break;
			case 18:
				champName = "Tristana";
				break;
			case 120:
				champName = "Hecarim";
				break;
			case 15:
				champName = "Sivir";
				break;
			case 236:
				champName = "Lucian";
				break;
			case 107:
				champName = "Rengar";
				break;
			case 19:
				champName = "Warwick";
				break;
			case 72:
				champName = "Skarner";
				break;
			case 54:
				champName = "Malphite";
				break;
			case 157:
				champName = "Yasuo";
				break;
			case 101:
				champName = "Xerath";
				break;
			case 17:
				champName = "Teemo";
				break;
			case 75:
				champName = "Nasus";
				break;
			case 58:
				champName = "Renekton";
				break;
			case 119:
				champName = "Draven";
				break;
			case 35:
				champName = "Shaco";
				break;
			case 50:
				champName = "Swain";
				break;
			case 91:
				champName = "Talon";
				break;
			case 40:
				champName = "Janna";
				break;
			case 115:
				champName = "Ziggs";
				break;
			case 245:
				champName = "Ekko";
				break;
			case 61:
				champName = "Orianna";
				break;
			case 114:
				champName = "Fiora";
				break;
			case 9:
				champName = "Fiddlesticks";
				break;
			case 31:
				champName = "ChoGath";
				break;
			case 33:
				champName = "Rammus";
				break;
			case 7:
				champName = "Leblanc";
				break;
			case 16:
				champName = "Soraka";
				break;
			case 26:
				champName = "Zilean";
				break;
			case 56:
				champName = "Nocturne";
				break;
			case 222:
				champName = "Jinx";
				break;
			case 83:
				champName = "Yorick";
				break;
			case 6:
				champName = "Urgot";
				break;
			case 203:
				champName = "Kindred";
				break;
			case 21:
				champName = "MissFortune";
				break;
			case 62:
				champName = "MonkeyKing";
				break;
			case 53:
				champName = "Blitzcrank";
				break;
			case 98:
				champName = "Shen";
				break;
			case 201:
				champName = "Braum";
				break;
			case 5:
				champName = "XinZhao";
				break;
			case 29:
				champName = "Twitch";
				break;
			case 11:
				champName = "MasterYi";
				break;
			case 44:
				champName = "Taric";
				break;
			case 32:
				champName = "Amumu";
				break;
			case 41:
				champName = "Gangplank";
				break;
			case 48:
				champName = "Trundle";
				break;
			case 38:
				champName = "Kassadin";
				break;
			case 161:
				champName = "Velkoz";
				break;
			case 143:
				champName = "Zyra";
				break;
			case 267:
				champName = "Nami";
				break;
			case 59:
				champName = "JarvanIV";
				break;
			case 81:
				champName = "Ezreal";
				break;
			case 350:
				champName = "Yuumi";
				break;
			case 145:
				champName = "Kaisa";
				break;
			case 518:
				champName = "Neeko";
				break;
			case 142:
				champName = "Zoe";
				break;
			case 498:
				champName = "Xayah";
				break;
			case 517:
				champName = "Sylas";
				break;
			case 141:
				champName = "Kayn";
				break;
			case 516:
				champName = "Ornn";
				break;
			case 555:
				champName = "Pyke";
				break;
			case 164:
				champName = "Camille";
				break;
			case 246:
				champName = "Qiyana";
				break;
			case 497:
				champName = "Rakan";
				break;
			case 777:
				champName = "Yone";
				break;
			case 876:
				champName = "Lillia";
				break;
			case 235:
				champName = "Senna";
				break;
			case 875:
				champName = "Sett";
				break;
			case 523:
				champName = "Aphelios";
				break;

			case 223:
				champName = "TahmKench";
				break;

			case 147:
				champName = "Seraphine";
				break;
			case 360:
				champName = "Samira";
				break;
			case 234:
				champName = "Viego";
				break;
			case 526:
				champName = "Rell";
				break;

			default:
				champName = "오류";
				break;

			}

//			System.out.println(champName); // 챔피언 고유 넘버 -> 이름 변환 확인
			
			HttpURLConnection huc = null;

			String url = "http://ddragon.leagueoflegends.com/cdn/11.4.1/data/ko_KR/champion/" + champName + ".json";
			
//			System.out.println(url); // url 확인

			URL u;
			u = new URL(url);

			huc = (HttpURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();

			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();

			JSONObject championDetail = (JSONObject) jp.parse(isr);

//			System.out.println(championDetail); // 챔피언 정보 확인
			
			JSONObject ja = (JSONObject) championDetail.get("data");
			JSONObject ja1 = (JSONObject) ja.get(champName);
//			System.out.println(ja1);
			
			JSONObject ja2 = (JSONObject) ja1.get("passive");
//			System.out.println(ja2);
			
			JSONObject ja3 = (JSONObject) ja2.get("image");
//			System.out.println(ja3);
			
			String ja4 = (String) ja3.get("full");
//			System.out.println(ja4);
			
			request.setAttribute("passive", ja4);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
