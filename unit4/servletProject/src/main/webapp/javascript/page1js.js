/**
 * 
 */

 let abilityList = ['', 'Lazer Eyes', 'Flight', 'Invisibility', 'Super Speed']

 let abilitySelect = document.querySelector("#abilites")
 
 abilityList.forEach((item) => {
	 let newOption = document.createElement("option")
	 newOption.innerText = item
	 abilitySelect.appendChild(newOption)
 })
 
 
 
 