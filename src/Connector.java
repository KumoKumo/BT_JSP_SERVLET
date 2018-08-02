

import java.sql.*;

public class Connector {
	private String url="jdbc:mysql://localhost:3306/something";
	private String user= "root";
	private String password="";
	
	private Connection con;
	
	public Connection getConnector() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		// remember to put jdbc into Web App Libraries
		con= DriverManager.getConnection(url, user, password);
		return con;
	}
}
