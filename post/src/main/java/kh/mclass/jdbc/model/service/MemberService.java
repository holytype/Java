package kh.mclass.jdbc.model.service;

import java.sql.Connection;
import java.util.List;

import kh.mclass.jdbc.model.dao.MemberDao;
import static kh.mclass.jdbc.model.common.JdbcTemplate.*;

public class MemberService {
	private MemberDao memberDao = new MemberDao();
	
	public List<MemberDao> selectAllList() {
		Connection conn = getConnection(true);
		//memberDao.selectAllList(conn);
		close(conn);
		return null;
	}
	
	public List<MemberDao> selectOne() {
		Connection conn = getConnection(true);
		//memberDao.selectAllList(conn);
		close(conn);
		return null;
	}
	
	public List<MemberDao> insert() {
		Connection conn = getConnection(true);
		//memberDao.selectAllList(conn);
		close(conn);
		return null;
	}
	
	public List<MemberDao> update() {
		Connection conn = getConnection(true);
		//memberDao.selectAllList(conn);
		close(conn);
		return null;
	}
	
	public List<MemberDao> delete() {
		Connection conn = getConnection(true);
		//memberDao.selectAllList(conn);
		close(conn);
		return null;
	}
}
