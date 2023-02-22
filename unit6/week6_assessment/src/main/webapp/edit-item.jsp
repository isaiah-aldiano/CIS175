<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	body {
		display: flex;
		align-items: center;
		justify-content: center;
		background-color: darkgrey;
		font-family: 'Courier New', monospace;
		height: 90vh;
	}

	.edit-item-form {
		max-width: 500px;
		margin: 2rem auto;
		border: 2px solid black;
		padding: 2rem;
		display: block;
	}
	
	.edit-item-form, label {
		display: block;
		text-transform: uppercase;
		
	}
	
	.edit-item-form, input {
		width: 95%;
		padding: .5rem;
		margin: .25rem 0 ;
		border-radius: 5px;
		border: 1px solid black;
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
<title>Edit Item Form</title>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	
	<form action="editItemServlet" method="post" class="edit-item-form">
		<label>Manufacturer</label>
		<input type="text" name="newManufacturer" value="${itemToEdit.manufacturer}">
	
		<label>Item</label>
		<input type="text" name="newItem" value="${itemToEdit.item}">
		
		<label>Cost</label>
		<input type="text" name="newCost" value="$${itemToEdit.cost}"> 
		
		<input type="hidden" value="${itemToEdit.id}" name="id"> 
		<input type="submit" value="save item" id="submit">
	</form>	
	
</body>
</html>