package com.cjc.crudapp.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cjc.crudapp.app.model.User;
import com.cjc.crudapp.app.servicei.ServiceI;
import com.cjc.crudapp.app.serviceiimpl.UserServiceiImpl;

@WebServlet(urlPatterns = "/register.do")
public class RegisterController extends HttpServlet {
	
	ServiceI s = new UserServiceiImpl();
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session=req.getSession(false);
				
		User u = new User();
		u.setName(req.getParameter("name"));
		u.setUsername(req.getParameter("username"));
		u.setPassword(req.getParameter("password"));
		
		s.saveUser(u);
		
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, res);		
	}
}
