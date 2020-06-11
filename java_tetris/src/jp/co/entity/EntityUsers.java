package jp.co.entity;

public class EntityUsers {

	private Integer userId;
	private String userName;
	private String password;
	private Integer tetrisScoreMax;
	private Integer tetrisScoreLast;
	private Integer ranking;
	private Integer numberOfPlays;

	public EntityUsers() {}

	public EntityUsers(Integer userId,String userName,String password,Integer tetrisScoreMax,Integer tetrisScoreLast,Integer ranking,Integer numberOfPlays) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.tetrisScoreMax = tetrisScoreMax;
		this.tetrisScoreLast = tetrisScoreLast;
		this.ranking = ranking;
		this.numberOfPlays = numberOfPlays;
	}

	public EntityUsers(String userName,Integer tetrisScoreMax,Integer numberOfPlays) {
		this.userName = userName;
		this.tetrisScoreMax = tetrisScoreMax;
		this.numberOfPlays = numberOfPlays;
	}
	public EntityUsers(Integer ranking,String userName,Integer tetrisScoreMax) {
		this.ranking =ranking;
		this.userName = userName;
		this.tetrisScoreMax = tetrisScoreMax;
	}

	public EntityUsers(String userName,String password) {
		this.userName = userName;
		this.password = password;
	}

	public  EntityUsers(Integer ranking,String userName) {
		this.ranking = ranking;
		this.userName =userName;
	}

	public EntityUsers(String userName,Integer tetrisScoreMax) {
		this.userName = userName;
		this.tetrisScoreMax = tetrisScoreMax;
	}

	public EntityUsers(String userName) {
		this.userName = userName;
	}

	public EntityUsers(Integer tetrisScoreMax,Integer tetrisScoreLast) {
		this.tetrisScoreMax = tetrisScoreMax;
		this.tetrisScoreLast = tetrisScoreLast;
	}

	public EntityUsers(Integer numberOfPlays) {
		this.numberOfPlays =numberOfPlays;
	}

	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTetrisScoreMax() {
		return this.tetrisScoreMax;
	}
	public void settTetrisScoreMax(Integer tetrisScoreMax) {
		this.tetrisScoreMax = tetrisScoreMax;
	}

	public Integer getTetrisScoreLast() {
		return this.tetrisScoreLast;
	}
	public void setTetrisScoreLast(Integer tetrisScoreLast) {
		this.tetrisScoreLast = tetrisScoreLast;
	}

	public Integer getRanking() {
		return this.ranking;
	}
	public void setRanking(Integer ranking) {
		this.ranking =ranking;
	}

	public Integer getNumberOfPlays() {
		return this.numberOfPlays;
	}
	public void setNumberOfPlays(Integer numberOfPlays) {
		this.numberOfPlays = numberOfPlays;
	}

}
