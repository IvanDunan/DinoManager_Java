package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DAOManager {
	
	UserDAO getUserDAO();
	InstitutionDAO getInstitutionDAO();	
	SubjectDAO getSubjectDAO();
}
