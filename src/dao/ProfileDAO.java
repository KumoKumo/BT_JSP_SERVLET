package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Profile;
import servlet.Connector;

public class ProfileDAO {
	Connector con = new Connector();

	public Profile getProfile(int id) throws SQLException, Exception {
		String query = "SELECT * FROM tbl_profile WHERE id=? AND status=1";
		PreparedStatement stmt = con.getConnector().prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet result = stmt.executeQuery();
		Profile profile = new Profile();
		if (result.next()) {
			profile.setId(id);
			profile.setStatus(1);
			profile.setName(result.getString("name"));
			profile.setEmail(result.getString("email"));
			profile.setAddress(result.getString("address"));
		} else {
			profile.setId(id);
			profile.setStatus(0);
		}
		return profile;
	}

	public void delProf(int id) throws Exception {
		String query = "DELETE FROM tbl_profile WHERE id = ?";
		PreparedStatement stmt = con.getConnector().prepareStatement(query);
		stmt.setInt(1, id);
		stmt.executeUpdate();
	}

	public void edit(int id, int status, String name, String email, String address) throws SQLException, Exception {
		String query = "UPDATE tbl_profile SET status=?, name=?, email=?, address=? WHERE id=?";
		PreparedStatement stmt = con.getConnector().prepareStatement(query);
		stmt.setInt(1, status);
		stmt.setString(2, name);
		stmt.setString(3, email);
		stmt.setString(4, address);
		stmt.setInt(5, id);
		stmt.executeUpdate();
	}
	
	public void add() throws SQLException, Exception {
		String query="INSERT INTO tbl_profile(status) VALUES (0)";
		PreparedStatement stmt = con.getConnector().prepareStatement(query);
		stmt.executeUpdate();
	}
}
