package jp.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.entity.EntityUsers;

public class UpdateDao {


	private Connection connection;

	public UpdateDao(Connection connection) {
		this.connection = connection;
	}

	private static final String SQL_TETRIS_SCORE_MAX_UPDATE ="update users set tetris_score_max = ? where user_name =?";
	private static final String SQL_TETRIS_SCORE_LAST_UPDATE ="update users set tetris_score_last = ? where user_name =?";
	private static final String SQL_TETRIS_SCORE_MAX ="select tetris_score_max,tetris_score_last from users where user_name = ?";
	private static final String SQL_SELECT_PLAY ="select number_of_plays from users where user_name = ?";
	private static final String SQL_UPDATE_PLAY ="update users set number_of_plays = ? where user_name =?";


	public void updateMax(int score,String name) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_TETRIS_SCORE_MAX_UPDATE)) {
			stmt.setInt(1, score);
			stmt.setString(2, name);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateLast(int score,String name) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_TETRIS_SCORE_LAST_UPDATE)) {
			stmt.setInt(1, score);
			stmt.setString(2, name);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
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

	//play回数を上書き
			public void updateNumberOfPlays(Integer plays,String name) {
				try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE_PLAY)) {
					stmt.setInt(1, plays);
					stmt.setString(2, name);
					stmt.executeUpdate();
				}catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}

}
