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

@WebServlet(urlPatterns = "/delete.do")
public class DeleteController extends HttpServlet{
	
	Daoi d = new Daoimpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession(false);
		
		String id = request.getParameter("userid");
		int userid=Integer.parseInt(id);     //  Wrapper class  //
		
		d.deleteUser(userid);
			
		session.setAttribute("data",d.getAllUser());
		request.getRequestDispatcher("success.jsp").forward(request, response);

	}
}
