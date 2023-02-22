<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gear Closet</title>
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

	.nav-item-form {
		max-width: 500px;
		margin: 2rem auto;
		border: 2px solid black;
		padding: 2rem;
		display: block;
	}
	
	.nav-item-form, label {
		display: block;
		text-transform: uppercase;
		
	}
	
	.nav-item-form, input {
		width: 95%;
		padding: .5rem;
		margin: .25rem 0 ;
		border-radius: 5px;
		border: 1px solid black;
	}
	
	.gear-table {
		table-layout: auto;
	}
	
	td {
		font-size: 20px;
		padding: .25rem;
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
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<form method="post" action="navigationServlet" class="nav-item-form">
		<table class="gear-table">
			<c:forEach items="${requestScope.allItems}" var="currentItem">
				<tr>
					<td><input type="radio" name="id" value="${currentItem.id}"></td>
					<td  colspan="3">${currentItem.manufacturer}</td>
					<td  colspan="3">${currentItem.item}</td>
					<td  colspan="3">$${currentItem.cost}</td>
				</tr>
			</c:forEach>
		</table>
		
		<input type="submit" value="Edit Item" name="doThis" id="submit">
		<input type="submit" value="Add Item" name="doThis" id="submit">
		<input type="submit" value="Delete Item" name="doThis" id="submit">
	</form>
	
	<h2>${requestScope.noItemsSelected}</h2>
</body>
</html>