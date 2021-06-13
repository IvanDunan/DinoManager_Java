package model;

import java.io.Serializable;

public class User  {
	
	private long id;
	
	private String user_name;
	private String password;
	private String name;
	private String surnames;
	private String sex;
	private int age;
	private String email;
	private long id_institution;
	private long id_type;
	private long id_subject;
	
	//CONSTRUCTOR
	public User(long id, String user_name, String password, String name, String surnames, String sex, int age,
			String email, long id_institution, long id_type, long id_subject) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.password = password;
		this.name = name;
		this.surnames = surnames;
		this.sex = sex;
		this.age = age;
		this.email = email;
		this.id_institution = id_institution;
		this.id_type = id_type;
		this.id_subject = id_subject;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurnames() {
		return surnames;
	}


	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getId_institution() {
		return id_institution;
	}


	public void setId_institution(long id_institution) {
		this.id_institution = id_institution;
	}


	public long getId_type() {
		return id_type;
	}


	public void setId_type(long id_type) {
		this.id_type = id_type;
	}


	public long getId_subject() {
		return id_subject;
	}


	public void setId_subject(long id_subject) {
		this.id_subject = id_subject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (id_institution ^ (id_institution >>> 32));
		result = prime * result + (int) (id_subject ^ (id_subject >>> 32));
		result = prime * result + (int) (id_type ^ (id_type >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((surnames == null) ? 0 : surnames.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (id_institution != other.id_institution)
			return false;
		if (id_subject != other.id_subject)
			return false;
		if (id_type != other.id_type)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (sex != other.sex)
			return false;
		if (surnames == null) {
			if (other.surnames != null)
				return false;
		} else if (!surnames.equals(other.surnames))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", password=" + password + ", name=" + name
				+ ", surnames=" + surnames + ", sex=" + sex + ", age=" + age + ", email=" + email + ", id_institution="
				+ id_institution + ", id_type=" + id_type + ", id_subject=" + id_subject + "]";
	}
	
	
	
	
	
	
}
