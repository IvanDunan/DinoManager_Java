package dao.mysql;

import java.sql.Connection;
import java.util.List;

import dao.SubjectDAO;
import model.Subject;
import model.User;

public class MySQLSubjectDAO implements SubjectDAO{
	
private Connection conn;
	
	public MySQLSubjectDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Subject a) {
		// TODO
		
	}

	@Override
	public void modify(Subject a) {
		// TODO
		
	}

	@Override
	public void delete(Subject a) {
		// TODO
		
	}
	
	public void login(Subject a) {
		// TODO
		
	}
	
	public void checkDataLogin(Subject a) {
		// TODO
		
	}
	
	public void checkSubject(Subject a) {
		// TODO Auto-generated method stub
		
	}
	
	public void tableReport(Subject a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Subject> getAll() {
		// TODO
		return null;
	}

	@Override
	public Subject get(Long id) {
		// TODO 
		return null;
	}

}
