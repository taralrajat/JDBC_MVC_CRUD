
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

</head>
<body>

<form action="login">

<%String msg = (String)request.getAttribute("msg");

if(msg!=null)
{
out.print(msg);
}
%>

<!-- //if(msg!=null){      /// starting login   msg=null
//out.print(msg);		//  (msg = String)  only in this condition print String
//} -->



<pre>
Username:<input type="text" name="username">
Password:<input type="text" name="password">
<input type="submit"value="Login">
<a href="register.jsp">Register</a>
</pre>

</form>

</body>
</html>