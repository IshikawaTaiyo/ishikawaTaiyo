package jp.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.entity.EntityUsers;

public class InsertDao {

	private Connection connection;

	public InsertDao(Connection connection) {
		this.connection = connection;
	}

	private static final String SQL_HUKUJUU = "select * from users where user_name = ? ";
	private static final String SQL_INSERT ="insert into users (user_name,password,tetris_score_max,tetris_score_last,number_of_plays)values(?,?,?,?,?)";

	//重複調べ
	public List<EntityUsers> Duplication(String name) {
		List<EntityUsers> list = new ArrayList<EntityUsers>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_HUKUJUU)) {
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				EntityUsers en = new EntityUsers(rs.getString("user_name"));
				list.add(en);

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	//DBに値をセット
	public void insert(String user_name,String password) {
		try (PreparedStatement stml = connection.prepareStatement(SQL_INSERT)) {
			stml.setString(1, user_name);
			stml.setString(2, password);
			stml.setInt(3, 0);
			stml.setInt(4, 0);
			stml.setInt(5, 0);
			stml.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
