package jp.co.entity;

public class EntityRanking {

	private Integer rankingId ;
	private String  rank;

	public EntityRanking() {}

	public EntityRanking(Integer rankingId,String rank) {
		this.rankingId = rankingId;
		this.rank = rank;
	}

	public EntityRanking(String rank) {
		this.rank = rank;
	}

	public Integer getRankingId() {
		return this.rankingId;
	}
	public void setRankingId(Integer rankingId) {
		this.rankingId = rankingId;
	}

	public String getRank() {
		return this.rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}


}
