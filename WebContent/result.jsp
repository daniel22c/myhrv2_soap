<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hi ${emp.name}, your information is 
<%
	
String resp=(String)session.getAttribute("result");
		out.println(resp);
%>
 
<!-- comment -->
</body>
</html>