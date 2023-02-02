<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.cjc.crudapp.app.model.User" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
<form action="update.do">
<% User u = (User)session.getAttribute("user"); %>
<pre>
	     <input type="hidden" name="userid" value="<%=u.getId()%>">
	     
Name:    <input type="text" name="name" value="<%=u.getName()%>">
Username:<input type="text" name="username" value="<%=u.getUsername()%>">
Password:<input type="text" name="password" value="<%=u.getPassword()%>">
<input type="submit"value="UPDATE">
</pre>

</form>
</body>
</html>