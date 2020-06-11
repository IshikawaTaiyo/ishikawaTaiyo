package jp.co.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jp.co.dao.InsertDao;
import jp.co.dao.UtilDao;
import jp.co.entity.EntityUsers;

public class InsertService {

	public int Duplication(String name) {
		try (Connection con = UtilDao.getConnection()){
		InsertDao da =new InsertDao(con);
		List<EntityUsers> list= da.Duplication(name);
		return list.size();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void insert(String user_name,String password) {
		try (Connection con = UtilDao.getConnection()){
		InsertDao da = new InsertDao(con);
		da.insert(user_name, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
