<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	body {
		background-color: darkgrey;
	}
	
	#animal, label {
		display: block;
	}
</style>
<script src="javascript/page1js.js" async></script>
<title>Form 1</title>
</head>
<body >
	<h1>This is page 1</h1>
	
	<a href="index.jsp">Home</a>
	
	
		<form action="makeCharacterServlet" method="post">
			<h3>Choose an animal</h3>
			<div id="animal">
				<label for="animal">Dog
				<input type="radio" name="animal" value="dog"></label>
				
				<label for="animal">Cat
				<input type="radio" name="animal" value="cat"></label>

				<label for="animal">Capybara
				<input type="radio" name="animal" value="capybara"></label>
				
				<label for="animal">Zebra
				<input type="radio" name="animal" value="zebra" required></label>
			</div>
			
			<div>
				<h3>Choose an ability</h3>
				<select id="abilites" name="abilitySelect" required></select>
			</div>
			
			<div>
				<h3>Name your animal!</h3>
				<input type="text" size="20" maxlength="20" name="characterName" required>			
			</div>
			
			<input type="submit" value="Make character">
		</form>
	
</body>
</html>