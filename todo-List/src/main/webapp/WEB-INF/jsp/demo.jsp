<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color="red">${err}</font>
<form method="post">
  <label for="name">First name:</label><br>
  <input type="text" id="name" name="name" ><br>
  <label for="lname">Pass:</label><br>
  <input type="text" id="password" name="password"><br><br>
  <input type="submit" value="Submit">
</form> 

</body>
</html>