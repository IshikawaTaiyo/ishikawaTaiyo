package jp.co.service;

import java.sql.Connection;
import java.sql.SQLException;

import jp.co.dao.SelectDao3;
import jp.co.dao.UtilDao;

public class SelectService3 {

	public String selectPssword(String name) {
		try (Connection con = UtilDao.getConnection()){
		SelectDao3 da =new SelectDao3(con);
		return da.selectPassword(name);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
