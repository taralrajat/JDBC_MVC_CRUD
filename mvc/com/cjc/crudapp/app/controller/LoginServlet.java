package com.cjc.crudapp.app.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cjc.crudapp.app.model.User;
import com.cjc.crudapp.app.servicei.ServiceI;
import com.cjc.crudapp.app.serviceiimpl.UserServiceiImpl;
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet{
	
	ServiceI s = new UserServiceiImpl();
	
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
//----------------------------------------------------------------------------------------------			
		HttpSession session = request.getSession();
		
		if(session!=null)
		{
			session.invalidate();
			session=request.getSession();
		}
//----------------------------------------------------------------------------------------------	
		if(username.equals("admin") && password.equals("admin"))
		{			
				session.setAttribute("data",s.getAllUser());
				request.getRequestDispatcher("success.jsp").forward(request, response);
		}	
		
		else
		{
				List<User> userList = s.loginUser(username, password);
				
				if(userList.isEmpty()){
					request.setAttribute("msg", "You entered wrong username or password..!!!");
					request.getRequestDispatcher("login.jsp").forward(request, response);	
				}
				else
				{
					session.setAttribute("data", userList);
					request.getRequestDispatcher("success.jsp").forward(request, response);		
				}
		}
	}
}
