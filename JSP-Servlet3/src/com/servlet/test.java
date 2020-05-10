package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("book_name");
		String loc = request.getParameter("book_loc");
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url ="jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pw = "tiger";
		
		Connection con =null;
		Statement stmt = null;
		// ����
		try {
			Class.forName(driver);//����̹� �ε�
			con = DriverManager.getConnection(url,id,pw);//����
			stmt = con.createStatement();//���۰�ü 
			// Ŀ���� �ۼ�
			String sql = "INSERT INTO book(book_id, book_name,book_loc)";
					sql += "VALUES(BOOK_SEQ.NEXTVAL,'" + name+ "','"+loc+"')";
		    int result = stmt.executeUpdate(sql);//Ŀ���� ���� 
		    
		    if(result == 1) {// �μ�Ʈ���̹Ƿ� ������ �Ǿ����� 1�� ����
		    	out.print("INSERT success!!");//Ȯ�ν� ���� ���
		    } else {
		    	out.print("INSERT fail!!");	//���н� ����
		    }
		    
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
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
