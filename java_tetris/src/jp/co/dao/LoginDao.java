package jp.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.entity.EntityUsers;

public class LoginDao {

	private Connection connection;

	public LoginDao(Connection connection) {
		this.connection = connection;
	}

	private static final String SQL_ROGIN = "select * from users where user_name = ? and password =?";
	private static final String SQL_TETRIS_SCORE_MAX ="select tetris_score_max,tetris_score_last from users where user_name = ?";
	private static final String SQL_SELECT_PLAY ="select number_of_plays from users where user_name = ?";
	//ログインチェック
		public List<EntityUsers> roginCheck(String name, String pass) {
			List<EntityUsers> list = new ArrayList<EntityUsers>();

			try (PreparedStatement stmt = connection.prepareStatement(SQL_ROGIN)) {
				stmt.setString(1, name);
				stmt.setString(2, pass);
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					EntityUsers en = new EntityUsers(rs.getString("user_name"), rs.getString("password"));
					list.add(en);

				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return list;
		}

		//テトリスの最高スコアと前回のスコア呼び出し
		public List<EntityUsers> tetrisScore(String name) {
			List<EntityUsers> list = new ArrayList<EntityUsers>();

			try (PreparedStatement stmt = connection.prepareStatement(SQL_TETRIS_SCORE_MAX)) {
				stmt.setString(1, name);
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					EntityUsers en = new EntityUsers(rs.getInt("tetris_score_max"),rs.getInt("tetris_score_last"));
					list.add(en);
				}
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return list;
		}

		//play回数の呼び出し
		public List<EntityUsers> selectNumberOfPlays(String name) {
			List<EntityUsers> list = new ArrayList<EntityUsers>();

			try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_PLAY)) {
				stmt.setString(1, name);
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					EntityUsers en = new EntityUsers(rs.getInt("number_of_plays"));
					list.add(en);
				}
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return list;
		}




}
