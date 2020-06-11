package jp.co.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jp.co.dao.SelectDao;
import jp.co.dao.UtilDao;
import jp.co.entity.EntityRanking;
import jp.co.entity.EntityUsers;

public class SelectService {

	public List<EntityUsers> Ranking(){
		try (Connection con = UtilDao.getConnection()){
		SelectDao da =new SelectDao(con);
		List<EntityUsers> list = da.ranking();
		return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<EntityRanking>Rank(){
		try (Connection con = UtilDao.getConnection()){
		SelectDao da =new SelectDao(con);
		List<EntityRanking> list = da.ranki();
		return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int userCount() {
		try (Connection con = UtilDao.getConnection()){
		SelectDao da =new SelectDao(con);
		return da.userCount();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int rankingUser(String name) {
		try (Connection con = UtilDao.getConnection()){
			SelectDao da =new SelectDao(con);
			List<EntityUsers> list = da.rankingUser(name);
			return list.get(0).getRanking();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
