package com.cjc.crudapp.app.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cjc.crudapp.app.dao.Daoi;
import com.cjc.crudapp.app.daoiimpl.Daoimpl;


@WebServlet(urlPatterns = "/edit.do")
public class EditServlet extends HttpServlet{
	
	Daoi d = new Daoimpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		HttpSession session=request.getSession(false);
		
		int userid = Integer.parseInt(request.getParameter("userid"));
		
		session.setAttribute("user",d.edit(userid));
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

}
