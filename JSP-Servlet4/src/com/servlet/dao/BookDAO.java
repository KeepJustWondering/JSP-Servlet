package com.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.servlet.dto.BookDTO;

public class BookDAO {
	DataSource dataSource;
	//	String driver = "oracle.jdbc.driver.OracleDriver";
//	String url ="jdbc:oracle:thin:@localhost:1521:orcl";
//	String id = "scott";
//	String pw = "tiger";
//	
	
	public BookDAO() {
		try {
//		Class.forName(driver);	
		Context context = new InitialContext();
		dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	public int insert(String name, String loc){
		
		Connection con = null;
		Statement stmt = null;
		int res = -1;
		
		try {
//			con = DriverManager.getConnection(url,id,pw);
			con= dataSource.getConnection();
			stmt = con.createStatement();//Àü¼Û°´Ã¼ 
			String sql = "INSERT INTO book(book_id, book_name,book_loc)";
			sql += "VALUES(BOOK_SEQ.NEXTVAL,'" + name+ "','"+loc+"')";
			
			res = stmt.executeUpdate(sql);
			    
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try {
					if(stmt != null) stmt.close();
					if(con != null) con.close();
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		
		return res;
	}
	
	public ArrayList<BookDTO> select(){
		
		ArrayList<BookDTO> list  = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		
		try {
//			con = DriverManager.getConnection(url,id,pw);
			con= dataSource.getConnection();
			String sql = "SELECT * FROM book";
			
			pstmt = con.prepareStatement(sql);
			
			res = pstmt.executeQuery();
			
			while(res.next()) {
			 int bookId= res.getInt("book_id");
			 String bookName = res.getString("book_name");
			 String bookLoc = res.getString("book_loc");
			
			 BookDTO bookDTO = new BookDTO(bookId,bookName,bookLoc);
			list.add(bookDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(res!=null)res.close();
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
		return list;
	}
}
