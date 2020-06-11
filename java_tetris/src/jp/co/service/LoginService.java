package jp.co.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jp.co.dao.LoginDao;
import jp.co.dao.UtilDao;
import jp.co.entity.EntityUsers;

public class LoginService {

	public int roginCheck(String name, String pass) {
		try (Connection con = UtilDao.getConnection()){
			LoginDao da = new LoginDao(con);
			List<EntityUsers> list = da.roginCheck(name, pass);
			return list.size();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//テトリス最高スコア
	public int tetrisScoreMax(String name) {
		try (Connection con = UtilDao.getConnection()){
		LoginDao da = new LoginDao(con);
		List<EntityUsers> list = da.tetrisScore(name);
		return list.get(0).getTetrisScoreMax();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int tetrisScoreLast(String name) {
		try (Connection con = UtilDao.getConnection()){
		LoginDao da = new LoginDao(con);
		List<EntityUsers> list = da.tetrisScore(name);
		return list.get(0).getTetrisScoreLast();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int selectNumberOfPlays(String name) {
		try (Connection con = UtilDao.getConnection()){
		LoginDao da = new LoginDao(con);
		List<EntityUsers> list = da.selectNumberOfPlays(name);
		return list.get(0).getNumberOfPlays();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
