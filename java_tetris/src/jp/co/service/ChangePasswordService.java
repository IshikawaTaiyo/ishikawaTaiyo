package jp.co.service;

import java.sql.Connection;
import java.sql.SQLException;

import jp.co.dao.ChangePasswordDao;
import jp.co.dao.UtilDao;

public class ChangePasswordService {

	public void updatePassword(String newPass,String name) {
		try (Connection con = UtilDao.getConnection()){
		ChangePasswordDao da =new ChangePasswordDao(con);
		da.updatePassword(newPass, name);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
