package app.dbConnection;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import app.bean.Book;



public class OpenAPI_DB_Insert {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	static Connection con = null;
	static PreparedStatement stmt = null;
	
	public static void main(String[] args) {
		ArrayList<Book> list = new ArrayList<>();
		try {
			
			String urlstr = "http://openapi.guro.go.kr:8088/4354754d68646e643539456f465865/json/GurolibItm/1/250/05";
			
			URL url = new URL(urlstr);
			String line = "";
			String result = "";
			String lib_idid = null, title = null, auth = null, publ = null, pyb = null, call_no = null;
			int brch_code;
			
			BufferedReader br;
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line = br.readLine()) != null) {
				result = result.concat(line);
			}
			
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(result);
			
			JSONObject parse_listObj = (JSONObject) obj.get("GurolibItm");
			JSONArray parse_listArr = (JSONArray) parse_listObj.get("row");
			
			for(int i=0; i<parse_listArr.size(); i++) {
				Book book = new Book();
				JSONObject j = (JSONObject) parse_listArr.get(i);
				lib_idid = (String) j.get("LIB_IDID");
				title = (String) j.get("TITLE");
				auth = (String) j.get("AUTH");
				publ = (String) j.get("PUB");
				pyb = (String) j.get("PYBL");
				call_no = (String) j.get("CALL_NO");
				brch_code = Integer.valueOf((String) j.get("BRCH_CODE"));
				
				book.setLib_idid(lib_idid);
				book.setTitle(title);
				book.setAuth(auth);
				book.setPubl(publ);
				book.setPyb(pyb);
				book.setCall_no(call_no);
				book.setBrch_code(brch_code);
				
				list.add(book);
			}
			
			for (int i = 0; i < parse_listArr.size(); i++) {
				lib_idid = list.get(i).getLib_idid();
				title = list.get(i).getTitle();
				auth = list.get(i).getAuth();
				publ = list.get(i).getPubl();
				pyb = list.get(i).getPyb();
				call_no = list.get(i).getCall_no();
				brch_code = list.get(i).getBrch_code();
				
				addBookDB(lib_idid, title, auth, publ, pyb, call_no, brch_code);
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private static void addBookDB(String lib_idid, String title, String auth, String publ, String pyb, String call_no, int brch_code) {
		try {
			String sql = "INSERT INTO BOOK(LIB_IDID, TITLE, AUTH, PUBL, PYB, CALL_NO, BRCH_CODE)"
					+ " VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			con = DriverManager.getConnection(url, "c##libdb", "admin");
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, lib_idid);
			stmt.setString(2, title);
			stmt.setString(3, auth);
			stmt.setString(4, publ);
			stmt.setString(5, pyb);
			stmt.setString(6, call_no);
			stmt.setInt(7, brch_code);
			
			stmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}














