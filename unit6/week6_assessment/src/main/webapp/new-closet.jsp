<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Closet</title>
<style>
	body {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		background-color: darkgrey;
		font-family: 'Courier New', monospace;
		height: 90vh;
	}

	.new-closet-form {
		max-width: 500px;
		margin: 2rem auto;
		border: 2px solid black;
		padding: 2rem;
		display: block;
	}
	
	.new-closet-form, label {
		display: block;
		text-transform: uppercase;
		
	}
	
	.new-closet-form, input {
		width: 95%;
		padding: .5rem;
		margin: .25rem 0 ;
		border-radius: 5px;
		border: 1px solid black;
	}
	
	.new-closet-form, select {
		font-family: 'Courier New', monospace;
		border-radius: 5px;
	}
	select, option {
		padding-bottom: .25rem;
		font-weight: 600;
	}

	#submit {
		width: auto;
		margin: 1px;
		background-color: green;
		cursor: pointer;
		color: white;
		text-transform: uppercase;
		transition: .4s background ease;
		transition: .4s color ease;
	}
	
	#submit:hover {
		background-color: lightblue;
		color: black;
	}
</style>
</head>
<body>
	<form class="new-closet-form" action="addNewClosetServlet" method="post">
		<label for="owner">Owner</label>
		<input name="owner" type="text" required>
		
		<label for="name">Closet Name</label>
		<input name="name" type="text" required>
		
		<label for="gearCloset">Closet Items</label>
		<select name="gearCloset" multiple size="5">
			<c:forEach items="${requestScope.allItems}" var="currentItem">
				<option value="${currentItem.id}">${currentItem.manufacturer}: ${currentItem.item} - $${currentItem.cost}</option>
			</c:forEach>
		</select>
		<br>
		
		<input id="submit" type="submit" value="submit">
		<a href="viewAllClosetsServlet"><input type="button" value="cancel" id="submit"></a>
	</form>
</body>
</html>