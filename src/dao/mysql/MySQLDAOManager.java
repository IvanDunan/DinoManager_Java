package dao.mysql;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.*;
import dao.*;



public class MySQLDAOManager implements DAOManager {
	
	private Connection conn;
	
	private UserDAO users = null;
	private InstitutionDAO institutions = null;
	private SubjectDAO subjects = null;
	
	
	public MySQLDAOManager() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinomanager_database3", "root", "root");
	}


	@Override
	public UserDAO getUserDAO() {
		if (users == null) {
			users = new MySQLUserDAO(conn);
		}
		return users;
	}


	@Override
	public InstitutionDAO getInstitutionDAO() {
		if (institutions == null) {
			institutions = new MySQLInstitutionDAO(conn);
			
		}
		return institutions;
	}


	@Override
	public SubjectDAO getSubjectDAO() {
		if (subjects == null) {
			subjects = new MySQLSubjectDAO(conn);
		}
		return subjects;
	}
	
	public static void main(String[] args) throws SQLException {
		MySQLDAOManager man = new MySQLDAOManager();
		List users = (List) man.getUserDAO().getAll();
		System.out.println(users);
		
	}

}
