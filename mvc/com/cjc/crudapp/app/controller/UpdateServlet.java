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
import com.cjc.crudapp.app.model.User;

@WebServlet(urlPatterns = "/update.do")
public class UpdateServlet extends HttpServlet{
	
	Daoi d = new Daoimpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		HttpSession session=request.getSession(false);
		
		User u = new User();
		u.setId(Integer.parseInt(request.getParameter("userid")));
		u.setName(request.getParameter("name"));
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		
		d.updateUser(u);
				
		session.setAttribute("data",d.getAllUser());
		request.getRequestDispatcher("success.jsp").forward(request, response);

	}
}
