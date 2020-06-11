package jp.co.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class UtilDao {

	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/tetris", "axizuser", "axiz");
		} catch (Exception e) {
			// 本来は専用の例外クラスを作成したほうがよい
			throw new RuntimeException(e);
		}
	}
}
