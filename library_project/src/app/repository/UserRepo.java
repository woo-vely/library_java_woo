package app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import app.bean.User;

public class UserRepo {

	public boolean addUser(User u) {
		String sql = "INSERT INTO MEMBER(ID, PASSWORD, NAME, GENDER)"
				+ " VALUES(?, ?, ?, ?)";
		try(Connection con = DBCP.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, u.getId());
			stmt.setString(2, u.getPassword());
			stmt.setString(3, u.getName());
			stmt.setString(4, u.getGender());
			
			int cnt = stmt.executeUpdate();
			if(cnt != 1) {
				System.out.println("insert user error");
				return false;
			}
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
