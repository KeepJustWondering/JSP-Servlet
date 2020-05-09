package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SC")
public class studentCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		
		
		String food=(String)getServletContext().getAttribute("food");
		String phone=(String)getServletContext().getAttribute("phone");
		
		PrintWriter out = response.getWriter();
		out.print("<p>½È¾îÇÏ´Â À½½Ä : "+ food + "</p>");
		out.print("<p>Èñ¸Á ±âÁ¾ : "+phone + "</p>");
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
