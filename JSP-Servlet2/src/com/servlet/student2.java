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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		PrintWriter out = response.getWriter();
		String number = getServletConfig().getInitParameter("s_number");
		String language = getServletConfig().getInitParameter("p_language");
		
		String food = getServletContext().getInitParameter("food");
		String phone = getServletContext().getInitParameter("phone");
		

		out.print("�����ϴ����� : "+food+"<br>");
		out.print("�޴��� ��� ���� : "+phone+"<br>");
		
		out.print("�й� : "+number+"<br>");
		out.print("�ַ� ����ϴ� ��� : "+language+"<br>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
