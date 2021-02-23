package com.sora.search;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class asdf {
	public static void main(String[] args) {

		try {
			HttpsURLConnection huc = null;
			String api = "RGAPI-a531df28-32d7-4b3e-bbf7-78897704cbd4";

			String url = "https://kr.api.riotgames.com/lol/platform/v3/champion-rotations/";
			url = url + "?api_key=" + api;

			URL u = new URL(url);

			huc = (HttpsURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();

			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();

			JSONObject rotation = (JSONObject) jp.parse(isr);

			System.out.println(rotation); // 로테이션 관련 정보 확인

			JSONArray jo = (JSONArray) rotation.get("freeChampionIds");

			System.out.println(jo.get(0)); // 신규 플레이어 기본 챔피언 번호 확인

			for (Object b : jo) {
				System.out.println(b);
				int b2 = Integer.parseInt(b + "");

				String champName = null;

				switch (b2) {
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

				System.out.println(champName);

			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}

}
