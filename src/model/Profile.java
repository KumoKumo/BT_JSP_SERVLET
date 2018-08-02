package model;

public class Profile {
	private int id;
	private int status;
	private String name;
	private String email;
	private String address;

	public Profile() {
	}


	public Profile(int id, int status) {
		super();
		this.id = id;
		this.status = status;
	}

	public Profile(int id, int status, String name, String email, String address) {
		super();
		this.id = id;
		this.status = status;
		this.name = name;
		this.email = email;
		this.address = address;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}

}
