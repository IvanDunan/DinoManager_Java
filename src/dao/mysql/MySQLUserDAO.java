package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.UserDAO;
import model.User;

public class MySQLUserDAO implements UserDAO {
	
	final String INSERT = "INSERT INTO users(user_name, password, name, surnames, sex, age, email, id_institution, id_type, id_subject)"
			+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
	final String LOGIN = "SELECT user_name, password FROM users WHERE user_name=? and password=?";
	final String CHECKDATA = "SELECT user_name, password, name, surnames, sex, age, email, id_institution, id_type, id_subject FROM users WHERE user_name=? and password=?";
	final String MODIFY = "UPDATE users SET user_name = ?, surnames = ?, name = ?, email = ? WHERE id = ?";

	private Connection conn;
	
	public MySQLUserDAO(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void insert(User myUser) {
		try {
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(INSERT);
			st.setString(1, myUser.getUser_name());
			st.setString(2, myUser.getPassword());
			st.setString(3, myUser.getName());
			st.setString(4, myUser.getSurnames());
			st.setString(5, myUser.getSex());
			st.setInt(6, myUser.getAge());
			st.setString(7, myUser.getEmail());
			st.setLong(8, myUser.getId_institution());
			st.setLong(9, myUser.getId_type());
			st.setLong(10, myUser.getId_subject());
			
			if (st.executeUpdate() == 0) {
				System.out.println("PUEDE QUE NO SE HAYA GUARDADO");
			};
			
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modify(User myUser) {
		try {
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(MODIFY);
			st.setString(1, myUser.getUser_name());
			st.setString(2, myUser.getSurnames());
			st.setString(3, myUser.getName());
			st.setString(4, myUser.getEmail());
			st.setLong(5, myUser.getId());
			
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(User a) {
		// TODO Auto-generated method stub
		
	}
	
	public void login(User myUser) {
		try {
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(LOGIN);
			
			st.setString(1, myUser.getUser_name());
			st.setString(2, myUser.getPassword());
			
			ResultSet rs = st.executeQuery();
			
			String name = rs.getString("user_name");
			myUser.setName(name);
			String surnames = rs.getString("surnames");
			myUser.setSurnames(surnames);
			
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void checkDataLogin(User a) {
		try {
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(CHECKDATA);
			st.setString(1, a.getUser_name());
			st.setString(2, a.getPassword());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void checkSubject(User a) {
		// TODO Auto-generated method stub
		
	}
	
	public void tableReport(User a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
