package jp.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangePasswordDao {


	private Connection connection;

	public ChangePasswordDao (Connection connection) {
		this.connection = connection;
	}

	private static final String SQL_UPDATE_PASSWORD ="update users set password = ? where user_name =?";

	public void updatePassword(String newPass,String name) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE_PASSWORD)) {
			stmt.setString(1, newPass);
			stmt.setString(2, name);
			stmt.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}



}
