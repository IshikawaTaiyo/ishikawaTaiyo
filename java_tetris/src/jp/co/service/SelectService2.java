package jp.co.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jp.co.dao.SelectDao2;
import jp.co.dao.UtilDao;
import jp.co.entity.EntityUsers;

public class SelectService2 {

	public List<EntityUsers> searchUser(String name){
		try (Connection con = UtilDao.getConnection()){
		SelectDao2 da =new SelectDao2(con);
		List<EntityUsers> list = da.searchUser(name);
		return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int searchUserSize(String name){
		try (Connection con = UtilDao.getConnection()){
		SelectDao2 da =new SelectDao2(con);
		List<EntityUsers> list = da.searchUser(name);
		return list.size();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
