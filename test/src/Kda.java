
public class Kda {
	private Object kills;
	private Object deaths;
	private Object assists;
	private Object champLevel;
	
	public Kda() {
		// TODO Auto-generated constructor stub
	}

	public Kda(Object kills, Object deaths, Object assists, Object champLevel) {
		super();
		this.kills = kills;
		this.deaths = deaths;
		this.assists = assists;
		this.champLevel = champLevel;
	}

	public Object getKills() {
		return kills;
	}

	public void setKills(Object kills) {
		this.kills = kills;
	}

	public Object getDeaths() {
		return deaths;
	}

	public void setDeaths(Object deaths) {
		this.deaths = deaths;
	}

	public Object getAssists() {
		return assists;
	}

	public void setAssists(Object assists) {
		this.assists = assists;
	}

	public Object getChampLevel() {
		return champLevel;
	}

	public void setChampLevel(Object champLevel) {
		this.champLevel = champLevel;
	}
	
	
	
}
