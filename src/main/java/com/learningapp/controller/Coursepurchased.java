package com.learningapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/coursepurchased")
public class Coursepurchased extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String courseName = request.getParameter("courseName");
		System.out.println(courseName);
		request.setAttribute("courseName", courseName);
        request.getRequestDispatcher("confirmation.jsp").forward(request, response);
	}

}
