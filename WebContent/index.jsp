<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>


	  <body bgcolor="#ffdedd">
  <h1> Employee Registration Form</h1>
  <form action="hr" method="post">
  		EMP ID: <input type="text" name="id" value=${emp.id}> <br/>
  		EMP NAME: <input type="text" name="name" value=${emp.name}> <br/>
  		EMP SALARY: <input type="number" name="salary" value=${emp.salary}> <br/>
  		DEPT ID: <input type="text" name="did" value="0"/> <br/>
  		<input type="submit" name="action" value="Insert"/>
  		<input type="submit" name="action" value="Update"/>
  		<input type="submit" name="action" value="Delete"/>
  		<input type="submit" name="action" value="Find"/>
  </form>

</body>
</html>