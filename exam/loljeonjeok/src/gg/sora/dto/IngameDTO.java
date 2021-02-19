package gg.sora.dto;

public class IngameDTO {
private Object teamId ; 
private String spell1Id; 
private String spell2Id; 
private String championIdKr; 
private String championIdEn;
private String summonerName;
private String keyperks;
private String perkSubStyle;
private String gameStartTime;

public IngameDTO() {
	// TODO Auto-generated constructor stub
}

public IngameDTO(Object teamId, String spell1Id, String spell2Id, String championIdKr, String championIdEn,
		String summonerName, String keyperks, String perkSubStyle, String gameStartTime) {
	super();
	this.teamId = teamId;
	this.spell1Id = spell1Id;
	this.spell2Id = spell2Id;
	this.championIdKr = championIdKr;
	this.championIdEn = championIdEn;
	this.summonerName = summonerName;
	this.keyperks = keyperks;
	this.perkSubStyle = perkSubStyle;
	this.gameStartTime = gameStartTime;
}
public Object getTeamId() {
	return teamId;
}

public void setTeamId(Object teamId) {
	this.teamId = teamId;
}

public String getSpell1Id() {
	return spell1Id;
}

public void setSpell1Id(String spell1Id) {
	this.spell1Id = spell1Id;
}

public String getSpell2Id() {
	return spell2Id;
}

public void setSpell2Id(String spell2Id) {
	this.spell2Id = spell2Id;
}

public String getChampionIdKr() {
	return championIdKr;
}

public void setChampionIdKr(String championIdKr) {
	this.championIdKr = championIdKr;
}

public String getChampionIdEn() {
	return championIdEn;
}

public void setChampionIdEn(String championIdEn) {
	this.championIdEn = championIdEn;
}

public String getSummonerName() {
	return summonerName;
}

public void setSummonerName(String summonerName) {
	this.summonerName = summonerName;
}

public String getKeyperks() {
	return keyperks;
}

public void setKeyperks(String keyperks) {
	this.keyperks = keyperks;
}

public String getPerkSubStyle() {
	return perkSubStyle;
}

public void setPerkSubStyle(String perkSubStyle) {
	this.perkSubStyle = perkSubStyle;
}

public String getGameStartTime() {
	return gameStartTime;
}

public void setGameStartTime(String gameStartTime) {
	this.gameStartTime = gameStartTime;
}



}
