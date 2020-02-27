package app.repository;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;

public class DBCP {
private static PoolDataSource poolDataSource;
	
	public static void setConnectionPool(PoolDataSource pds) {
		poolDataSource = pds;
	}
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			return poolDataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
