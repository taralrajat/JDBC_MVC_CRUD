<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.cjc.crudapp.app.model.User" %>   
<%@page import="java.util.List" %>   
<!DOCTYPE html>
<html style="width: 729px; height: 5px; ">
<head>

<script type="text/javascript">
function del()
{
document.myform.action="delete.do";
document.myform.submit();
}
function edit()
{
document.myform.action="edit.do";
document.myform.submit();
}
function endSession()
{
document.myform.action="endSession.do";
document.myform.submit();
}

</script>

<meta charset="ISO-8859-1">
<title>Success Page</title>
</head>
<body>
<form name="myform">
	<table border="2">
		<tr>
			<th>Name</th>
			<th>Username</th>
			<th>Password</th>
		</tr>
		<% List<User> userList = (List<User>)session.getAttribute("data"); 
		for(User u:userList) { %>
		<tr>
			<td><%=u.getName() %></td>
			<td><%=u.getUsername() %></td>
			<td><%=u.getPassword() %></td>
			<td><input type="radio" name="userid" value="<%=u.getId()%>"><td>	
		</tr>
		<% } %>
		<tr>
			<td><input type="button" value="DELETE" onclick="del()"></td>
			<td><input type="button" value="EDIT" onclick="edit()"></td>
			<td><input type="button" value="End Session" onclick="endSession()"></td>
		</tr>
	</table>
</form>
</body>
</html>