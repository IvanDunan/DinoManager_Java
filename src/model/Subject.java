package model;

public class Subject {
	
	private long id;
	
	private String name;
	
	private long id_institution;

	public Subject(long id, String name, long id_institution) {
		super();
		this.id = id;
		this.name = name;
		this.id_institution = id_institution;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId_institution() {
		return id_institution;
	}

	public void setId_institution(long id_institution) {
		this.id_institution = id_institution;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (id_institution ^ (id_institution >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Subject other = (Subject) obj;
		if (id != other.id)
			return false;
		if (id_institution != other.id_institution)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", id_institution=" + id_institution + "]";
	}
	
	

}
