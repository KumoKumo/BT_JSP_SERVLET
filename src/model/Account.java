package model;

public class Account {
	private int id;
	private int status;
	private String username;
	private String password;
	
	
	
	public Account() {
	}

	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Account(int id, int status, String username, String password) {
		super();
		this.id = id;
		this.status = status;
		this.username = username;
		this.password = password;
	}



	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
