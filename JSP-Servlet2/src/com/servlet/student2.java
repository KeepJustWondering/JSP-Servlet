package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class student2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html; charset=UTF-8");
		
		
		PrintWriter out = response.getWriter();
		String number = getServletConfig().getInitParameter("s_number");
		String language = getServletConfig().getInitParameter("p_language");
		
		String food = getServletContext().getInitParameter("food");
		String phone = getServletContext().getInitParameter("phone");
		

		out.print("좋아하는음식 : "+food+"<br>");
		out.print("휴대폰 사용 기종 : "+phone+"<br>");
		
		out.print("학번 : "+number+"<br>");
		out.print("주로 사용하는 언어 : "+language+"<br>");
		
		getServletContext().setAttribute("food", "rice cake");
		getServletContext().setAttribute("phone", "iPhone 11 Pro");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
