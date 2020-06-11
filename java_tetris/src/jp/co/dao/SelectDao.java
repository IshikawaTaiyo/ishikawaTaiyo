package jp.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.entity.EntityRanking;
import jp.co.entity.EntityUsers;

public class SelectDao {

	private Connection connection;

	public SelectDao(Connection connection) {
		this.connection = connection;
	}

	private static final String SQL_RANKING = "select rank() over(order by tetris_score_max desc ) ranking,user_name,tetris_score_max from users limit 10;";
	private static final String SQL_RANK ="select rank from ranking order by ranking_id";
	private static final String SQL_USER_COUNT = "select count(*) count from users ";
	private static final String SQL_RANKING_USERRANK ="select*from(select rank() over(order by tetris_score_max desc ) ranking,user_name from users )s where user_name = ?";

	public List<EntityUsers> ranking(){
		List<EntityUsers> list = new ArrayList<EntityUsers>();

		try(PreparedStatement stmt =connection.prepareStatement(SQL_RANKING)){
			ResultSet rs =stmt.executeQuery();

			while(rs.next()) {
				EntityUsers en =new EntityUsers(rs.getInt("ranking"),rs.getString("user_name"),rs.getInt("tetris_score_max"));
				list.add(en);
				}
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		return list;
	}

	public List<EntityRanking> ranki(){
		List<EntityRanking> list = new ArrayList<EntityRanking>();

		try(PreparedStatement stmt =connection.prepareStatement(SQL_RANK)){
			ResultSet rs =stmt.executeQuery();

			while(rs.next()) {
				EntityRanking en =new EntityRanking(rs.getString("rank"));
				list.add(en);
				}
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		return list;
	}


	public int userCount(){
		int count;
		try(PreparedStatement stmt =connection.prepareStatement(SQL_USER_COUNT)){
			ResultSet rs =stmt.executeQuery();
			rs.next();
			count =rs.getInt("count");

			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		return count;
	}

	public List<EntityUsers> rankingUser(String name){
		List<EntityUsers> list = new ArrayList<EntityUsers>();

		try(PreparedStatement stmt =connection.prepareStatement(SQL_RANKING_USERRANK)){
			stmt.setString(1, name);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()) {
				EntityUsers en =new EntityUsers(rs.getInt("ranking"),rs.getString("user_name"));
				list.add(en);
				}
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		return list;
	}


}
