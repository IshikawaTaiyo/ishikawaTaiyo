package jp.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectDao3 {


	private Connection connection;

	public SelectDao3(Connection connection) {
		this.connection = connection;
	}

	private static final String SQL_SELECT_PASSWORD ="select password from users where user_name = ?";

	public String selectPassword(String name) {
		String password ;
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_PASSWORD)) {
			stmt.setString(1,name);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			password = rs.getString("password");
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return password;
	}
}
