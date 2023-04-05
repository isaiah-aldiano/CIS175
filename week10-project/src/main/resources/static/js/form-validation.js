
 
 let publisher = document.querySelector("#publisher");
 
 let genre = document.querySelector("#genre");
 
 let viewAllButton = document.getElementById("viewAll");
 
 function sleep(ms) {
      return new Promise(resolve => setTimeout(resolve, ms));
   	 }
 
 function addListeners() {
	 
	 let addBookForm = document.querySelector("#addBookForm");
	 let title = document.querySelector("#title");
	 let firstName = document.querySelector("#firstName");
	 let lastNane = document.querySelector("#lastName");
	 let pubYear = document.querySelector("#pubYear");
 	 let pageCount = document.querySelector("#pageCount");
 	 let submit = document.querySelector("#submit");

	 let formItems = [title, firstName, lastNane, pubYear, pageCount]
	 function validateInputs() {

		 for(let i = 0; i < formItems.length; i++) {
			 if(formItems[i].value == '' || formItems[i].value == "0") {
				 formItems[i].setAttribute('class', 'error')
			 } else {
				 formItems[i].classList.remove('error')
			 }
		 }
 	 }

	 submit.addEventListener('click', function(event) {
		validateInputs()
 	 }) 	 
 }
 
 

 

