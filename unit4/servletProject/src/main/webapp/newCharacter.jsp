<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	body {
		background-color: darkgrey;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		height: 90vh;
	}
	
	#character {
		display: flex;
		flex-direction: column;
		align-items: center;
		max-width: 400px;
		text-align: center;
	}
</style>
<title>Insert title here</title>
<script>
</script>
<style>
	img {
		max-height: 400px;
		max-width: 400px;
	}
</style>
</head>
<body>

	<div id="charName"> 
		<h2>${userCharacter.getName()} the ${userCharacter.getAnimal()}</h2>
	</div>
	<div id="character">
		<img src="${userCharacter.getPicPath()}" alt="Picture of a ${userCharacter.getAnimal()}" id="characterImg">
		<p>Have no need to fear, ${userCharacter.getName()} is here! ${userCharacter.getName()} the ${userCharacter.getAnimal()} has the ability of ${userCharacter.getAbility()} and will fight the evil doers of this world!</p>
		
		<form action="page1.jsp">
			<input type="submit" value="Make a new character">
		</form>
	</div>
	
	
	
</body>
</html>