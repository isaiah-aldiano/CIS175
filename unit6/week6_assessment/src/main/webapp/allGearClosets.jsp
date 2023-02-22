<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Gear Closets</title>
<style>
	body {
		display: flex;
		align-items: center;
		justify-content: center;
		background-color: darkgrey;
		font-family: 'Courier New', monospace;
		height: 90vh;
	}

	.closet-form {
		max-width: 500px;
		margin: 2rem auto;
		border: 2px solid black;
		padding: 2rem;
		display: block;
	}
	
	.closet-form, label {
		display: block;
		text-transform: uppercase;
		
	}
	
	.closet-form, input {
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
</head>
<body>
	<form action="gearClosetNavigationServlet" class="closet-form" method="post">
		<table>
			<tr>
				<th style="width:10%"></th>
				<th style="width:66%"></th>
				<th	style="width: 100%"></th>
			</tr>
			
			<c:forEach items="${requestScope.allClosets}" var="currentCloset">
				
				<tr>
					<tr>
						<td ><input type="radio" value="${currentCloset.id}" name="id"></td>
						<td ><h3>${currentCloset.closetName}</h3></td>
						<td ><h4>ID: ${currentCloset.someClimber.id} <br> Name: ${currentCloset.someClimber.name}</h4></td>
					</tr>
					<tr>
						<td></td>
						<td colspan="2">
							<table>
								<c:forEach items="${currentCloset.closetContents}" var="closetContent">
									<script> console.log("yo")</script>
										<tr >
											<td>${closetContent.manufacturer}: ${closetContent.item} - $${closetContent.cost}</td>
										</tr>
								</c:forEach>
							</table>
						</td>
					</tr>
				</tr>
			</c:forEach>
		</table>
		<input id="submit" type="submit" value ="edit" name="doThisToList">
		<input id="submit" type="submit" value="delete" name="doThisToList">
		<input id="submit" type="submit" value="add" name="doThisToList"> <br>
		<a href="index.html"><input type="button" value="Add Items" id="submit"></a>
	</form>
	
</body>
</html>