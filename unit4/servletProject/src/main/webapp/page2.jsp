<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	String formattedDate = dateFormat.format(now);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	body {
		background-color: darkgrey;
	}
</style>
<title>Form 2</title>
</head>
<body>
	<h1>This is page 2</h1>
	
	<a href="index.jsp">Home</a>
	
	<p>Todays date: <%= formattedDate %></p>
	
	
	<form action="calculateApeIndexServlet" method="post">
		<h2>How big is your ape index!?</h2>
		<label for="height">Height
		<input type="text" placeholder="Height in inches" name="height" required></label><br>
		
		<label for="wingspan">Wingspan
		<input type="text" placeholder="Wingspan in inches" name="wingspan" required></label><br>
		
		<input type="submit" value="Calculate ape index">
	</form>
</body>
</html>