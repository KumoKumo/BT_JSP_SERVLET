package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Account;
import servlet.Connector;

public class AccountDAO {
	Connector con= new Connector();
	
	public Account getAcc(int id) throws SQLException, Exception {
		Account acc= new Account();
		String query="SELECT * FROM tbl_account WHERE id=?";
		PreparedStatement stmt = con.getConnector().prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet result= stmt.executeQuery();
		con.getConnector().close();
		if(result.next()) {
			acc.setId(Integer.parseInt((result.getString("id"))));
			acc.setUsername(result.getString("username"));
			acc.setPassword(result.getString("password"));
			acc.setStatus(Integer.parseInt(result.getString("status")));
		}
		return acc;
	}

	public int check(String username, String password) throws SQLException, Exception {
		int i=0;
		String query="SELECT * FROM tbl_account WHERE username=? AND password=?";
		PreparedStatement stmt = con.getConnector().prepareStatement(query);
		stmt.setString(1, username);
		stmt.setString(2, password);
		con.getConnector().close();
		ResultSet result= stmt.executeQuery();
		if(result.next()) {
			i= Integer.parseInt(result.getString("id"));
		}
		return i;
	}
	
	public ArrayList<Account> getAll() throws SQLException, Exception{
		ArrayList<Account> list =  new ArrayList<>();
		String query = "SELECT * FROM tbl_account";
		PreparedStatement stmt = con.getConnector().prepareStatement(query);
		ResultSet result= stmt.executeQuery();
		while(result.next()) {//Improve later
			Account acc = new Account(result.getString("username"), result.getString("password"));
			acc.setId(result.getInt("id"));
			acc.setStatus(result.getInt("status"));
			list.add(acc);
		}
		return list;
	}
	
	public void del(int id) throws SQLException, Exception {
		String query="DELETE FROM tbl_account WHERE id = ?";
		PreparedStatement stmt = con.getConnector().prepareStatement(query);
		stmt.setInt(1, id);
		stmt.executeUpdate();
	}
	
	public void edit(int id, String username,String password) throws SQLException, Exception {
		String query="UPDATE tbl_account SET username=?, password=? WHERE id=?";
		PreparedStatement stmt = con.getConnector().prepareStatement(query);
		stmt.setString(1, username);
		stmt.setString(2, password);
		stmt.setInt(3, id);
		stmt.executeUpdate();
	}
	
	public void add(String username, String password) throws SQLException, Exception {
		String query="INSERT INTO tbl_account(username, password, status) VALUES (?,?,0)";
		PreparedStatement stmt = con.getConnector().prepareStatement(query);
		stmt.setString(1, username);
		stmt.setString(2, password);
		stmt.executeUpdate();
	}
}
