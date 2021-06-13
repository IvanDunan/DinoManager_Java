package dao;

import java.util.List;

import model.User;

public interface DAO<T, K> {

	void insert(T a);
	void modify(T a);
	void delete(T a);
	void login(T a);
	void checkSubject (T a);
	void tableReport (T a);
	void checkDataLogin(T a);
	
	List<T> getAll();
	
	T get(Long id);
}
