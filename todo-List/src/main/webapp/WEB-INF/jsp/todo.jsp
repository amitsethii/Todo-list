<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
<div class="container">
ADD TODO ${name} 
 <br>
<form method="post">
<fieldset class="form-group">
  <label>Description:</label><br>
  <input type="text" name="desc" class="form-control" required="required"/>
  </fieldset>
   <button type="submit" class="btn btn-primary">ADD</button>
</form> 
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	 </div>   
</body>
</html>