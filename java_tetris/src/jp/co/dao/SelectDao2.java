package jp.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.entity.EntityUsers;

public class SelectDao2 {

	private Connection connection;

	public SelectDao2(Connection connection) {
		this.connection = connection;
	}

	private static final String SQL_SELECT_USERS_LIKE ="select user_name,tetris_score_max,number_of_plays from users where user_name like '%'||?||'%'";

	public List<EntityUsers> searchUser(String name) {
		List<EntityUsers> list = new ArrayList<EntityUsers>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_USERS_LIKE)) {
			stmt.setString(1,name);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				EntityUsers en = new EntityUsers(rs.getString("user_name"),rs.getInt("tetris_score_max"),rs.getInt("number_of_plays"));
				list.add(en);
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}


}
