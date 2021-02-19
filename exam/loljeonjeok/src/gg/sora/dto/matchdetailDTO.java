package gg.sora.dto;

public class matchdetailDTO {
private String win;
private String summonerName;
private String championEn;
private String championKr;
private String position;
private int kills;
private int deaths;
private int assists;
private double kda;
private Object item0;
private Object item1;
private Object item2;
private Object item3;
private Object item4;
private Object item5;
private Object item6;
private String pb;
public matchdetailDTO() {
	// TODO Auto-generated constructor stub
}
public matchdetailDTO(String win, String summonerName, String championEn, String championKr, String position, int kills,
		int deaths, int assists, double kda, Object item0, Object item1, Object item2, Object item3, Object item4,
		Object item5, Object item6, String pb) {
	super();
	this.win = win;
	this.summonerName = summonerName;
	this.championEn = championEn;
	this.championKr = championKr;
	this.position = position;
	this.kills = kills;
	this.deaths = deaths;
	this.assists = assists;
	this.kda = kda;
	this.item0 = item0;
	this.item1 = item1;
	this.item2 = item2;
	this.item3 = item3;
	this.item4 = item4;
	this.item5 = item5;
	this.item6 = item6;
	this.pb = pb;
}
public String getWin() {
	return win;
}
public void setWin(String win) {
	this.win = win;
}
public String getSummonerName() {
	return summonerName;
}
public void setSummonerName(String summonerName) {
	this.summonerName = summonerName;
}
public String getChampionEn() {
	return championEn;
}
public void setChampionEn(String championEn) {
	this.championEn = championEn;
}
public String getChampionKr() {
	return championKr;
}
public void setChampionKr(String championKr) {
	this.championKr = championKr;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public int getKills() {
	return kills;
}
public void setKills(int kills) {
	this.kills = kills;
}
public int getDeaths() {
	return deaths;
}
public void setDeaths(int deaths) {
	this.deaths = deaths;
}
public int getAssists() {
	return assists;
}
public void setAssists(int assists) {
	this.assists = assists;
}
public double getKda() {
	return kda;
}
public void setKda(double kda) {
	this.kda = kda;
}
public Object getItem0() {
	return item0;
}
public void setItem0(Object item0) {
	this.item0 = item0;
}
public Object getItem1() {
	return item1;
}
public void setItem1(Object item1) {
	this.item1 = item1;
}
public Object getItem2() {
	return item2;
}
public void setItem2(Object item2) {
	this.item2 = item2;
}
public Object getItem3() {
	return item3;
}
public void setItem3(Object item3) {
	this.item3 = item3;
}
public Object getItem4() {
	return item4;
}
public void setItem4(Object item4) {
	this.item4 = item4;
}
public Object getItem5() {
	return item5;
}
public void setItem5(Object item5) {
	this.item5 = item5;
}
public Object getItem6() {
	return item6;
}
public void setItem6(Object item6) {
	this.item6 = item6;
}
public String getPb() {
	return pb;
}
public void setPb(String pb) {
	this.pb = pb;
}


}
