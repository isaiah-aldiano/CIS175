<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Closet</title>
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

	.edit-closet-form {
		max-width: 500px;
		margin: 2rem auto;
		border: 2px solid black;
		padding: 2rem;
		display: block;
	}
	
	.edit-closet-form, label {
		display: block;
		text-transform: uppercase;
		
	}
	
	.edit-closet-form, input {
		width: 95%;
		padding: .5rem;
		margin: .25rem 0 ;
		border-radius: 5px;
		border: 1px solid black;
	}
	
	.edit-closet-form, select {
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
	<form method="post" action="editClosetServlet" class="edit-closet-form">
		<label for="owner">Owner</label>
		<input name="owner" type="text" value="${owner.name}">
		
		<label for="closetName">Closet Name</label>
		<input name="closetName" type="text" value="${closetName}">
		
		<select name="selectItems" multiple size="5">
			<c:forEach items="${allItems}" var="closetContent">
				<option value="${closetContent.id}">${closetContent.manufacturer}: ${closetContent.item} - $${closetContent.cost}</option>
			</c:forEach>
		</select>
		<br>
		
		<input type="hidden" name="id" value="${id}">
		<input id="submit" type="submit" value="submit">
		<a href="viewAllClosetsServlet"><input type="button" value="cancel" id="submit"></a>
	</form>
</body>
</html>