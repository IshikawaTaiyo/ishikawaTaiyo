package jp.co.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jp.co.dao.UpdateDao;
import jp.co.dao.UtilDao;
import jp.co.entity.EntityUsers;

public class UpdateService {

	public void updateMax(int score,String name) {
		try (Connection con = UtilDao.getConnection()){
		UpdateDao da = new UpdateDao(con);
		da.updateMax(score, name);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateLast(int score,String name) {
		try (Connection con = UtilDao.getConnection()){
		UpdateDao da = new UpdateDao(con);
		da.updateLast(score, name);
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
	}

	//テトリス最高スコア
		public int tetrisScoreMax(String name) {
			try (Connection con = UtilDao.getConnection()){
			UpdateDao da =new UpdateDao(con);
			List<EntityUsers> list= da.tetrisScore(name);
			return list.get(0).getTetrisScoreMax();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}


		public int tetrisScoreLast(String name) {
			try (Connection con = UtilDao.getConnection()){
			UpdateDao da =new UpdateDao(con);
			List<EntityUsers> list= da.tetrisScore(name);
			return list.get(0).getTetrisScoreLast();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	//play回数を取ってくる
	public int selectNumberOfPlays(String name) {
		try (Connection con = UtilDao.getConnection()){
		UpdateDao da =new UpdateDao(con);
		List<EntityUsers> list= da.selectNumberOfPlays(name);
		return list.get(0).getNumberOfPlays();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateNumberOfPlays(int plays,String name) {
		try (Connection con = UtilDao.getConnection()){
		UpdateDao da = new UpdateDao(con);
		da.updateNumberOfPlays(plays, name);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
