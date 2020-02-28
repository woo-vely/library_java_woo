package app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import app.bean.Book;

public class BookRepo {

	public Book searchBookByID(String bSearch) {
		Book book = null;
		String sql = "SELECT LIB_IDID, TITLE, AUTH FROM BOOK"
				+ " WHERE LIB_IDID = ?";
		
		try(Connection con = DBCP.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, bSearch);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				book = new Book();
				book.setLib_idid(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuth(rs.getString(3));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	public Book searchBookByTitle(String bSearch) {
		Book book = null;
		String sql = "SELECT LIB_IDID, TITLE, AUTH FROM BOOK"
				+ " WHERE TITLE = ?";

		try(Connection con = DBCP.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, bSearch);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				book = new Book();
				book.setLib_idid(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuth(rs.getString(3));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	public boolean insertBook(Book ibook) {
		String sql = "INSERT INTO BOOK(LIB_IDID, TITLE, AUTH, PUBL, PYB, CALL_NO, BRCH_CODE)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?)";
		try(Connection con = DBCP.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, ibook.getLib_idid());
			stmt.setString(2, ibook.getTitle());
			stmt.setString(3, ibook.getAuth());
			stmt.setString(4, ibook.getPubl());
			stmt.setString(5, ibook.getPyb());
			stmt.setString(6, ibook.getCall_no());
			stmt.setInt(7, ibook.getBrch_code());
			
			int cnt = stmt.executeUpdate();
			if(cnt != 1) {
				System.out.println("book insert error");
				return false;
			}
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Book> searchBookAuth(String bSearch) {
		List<Book> list = new ArrayList<Book>();
		String sql = "SELECT LIB_IDID, TITLE, AUTH, PUBL, PYB, CALL_NO, BRCH_CODE"
				+ " FROM BOOK WHERE AUTH = ?";
		
		try(Connection con = DBCP.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, bSearch);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Book b = new Book();
				b.setLib_idid(rs.getString(1));
				b.setTitle(rs.getString(2));
				b.setPubl(rs.getString(3));
				b.setPyb(rs.getString(4));
				b.setCall_no(rs.getString(5));
				b.setCall_no(rs.getString(6));
				list.add(b);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Book> searchBookByPubl(String bSearch) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Book> searchBookByPyb(String bSearch) {
		// TODO Auto-generated method stub
		return null;
	}




}


















