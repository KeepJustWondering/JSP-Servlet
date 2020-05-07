package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ST")
public class student extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("s_name");
		String age=request.getParameter("s_age");
		String major=request.getParameter("s_major");
		String[] hobby=request.getParameterValues("s_hobby");
		
		
		
		
		out.println("이름 : " + name+"<br>");
		out.println("나이 : "+age+"<br>");
		out.println("전공 : "+major+"<br>");
		out.println("취미 : ");
		for(int i=0;i<hobby.length;i++) {
			out.print(hobby[i]+" ");
			
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
