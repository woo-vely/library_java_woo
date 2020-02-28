package app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.bean.Admin;

public class AdminRepo {

	public boolean addAdmin(Admin admin) {
		String sql = "INSERT INTO ADMIN(ID, PASSWORD, NAME, BIRTH)" + 
				" VALUES(?, ?, ?, ?)";
		try(Connection con = DBCP.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, admin.getId());
			stmt.setString(2, admin.getPassword());
			stmt.setString(3, admin.getName());
			stmt.setString(4, admin.getBirth());
			
			int cnt = stmt.executeUpdate();
			if(cnt != 1) {
				System.out.println("insert error");
				return false;
			}
		
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Admin getAdmin(String id, String pw) {
		Admin admin = null;
		
		String sql = "SELECT * FROM ADMIN"
				+ " WHERE ID = ?"
				+ " AND PASSWORD = ?";
		
		try(Connection con = DBCP.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, id);
			stmt.setString(2, pw);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				admin = new Admin();
				admin.setId(id);
				admin.setPassword(pw);
			
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
}


















