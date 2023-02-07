<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ape results</title>
<style>
	img {
		max-height: 500px;
		max-width: 500px;
	}
	
	body {
		background-color: darkgrey;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		height: 60vh;
	}
	
	#results {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
</style>
</head>
<body>
	<h2>Ape index chart of various professional climbers</h2>
	<img src="images/apeIndexChar.jpeg" alt="Ape index chart of various professional climbers" id="apeChart">
		
	<div id="results">
		<h3>${apeResults.getApe()} </h3>
		
		<form action="page2.jsp" method="post">
			<input type="submit" value="Calculate new ape index">
		</form>
		
	</div>
</body>
</html>