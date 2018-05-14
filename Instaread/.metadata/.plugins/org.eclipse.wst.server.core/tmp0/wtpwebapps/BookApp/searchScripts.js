document.getElementById("searchForm").addEventListener("submit", function(event){
    event.preventDefault()
    var book = document.getElementById("searchInput").value;
    var url = new URL('http://localhost:8080/BookApp/BookServlet')

    var params = {book:book} 
    url.search = new URLSearchParams(params)
    
    // Using Fetch API for AJAX requirement 
    fetch(url) 
    .then(
      function(response) {
        if (response.status !== 200) {
          console.log('Looks like there was a problem. Status Code: ' +
            response.status);
          return;
        }

        // Examine the text in the response
        response.text().then(function(data) {
          loadBooks(data);
//          console.log(data);
        });
      }
    )
    .catch(function(err) {
      console.log('Fetch Error :', err);
    });
});


function loadBooks(data) {
	var columns = document.getElementById("columns");

	if (columns.innerHTML) {
		clear();
	}
	
	var json = JSON.parse(data);
		
	// generating HTML elements to be injected into DOM
	for (var i = 0; i < json.length; i++) {
			
		var card = document.createElement("div");
		card.className = "card h-200 search-card";
		
		// Book image section
		var img = document.createElement("img");
		img.className = "card-img-top";
		img.src = json[i].artworkUrl60;
		
		var cardBody = document.createElement("div");
		cardBody.className = "card-body";
		
		// Book title section
		var cardTitle = document.createElement("div");
		cardTitle.className = "card-title text-center";
		var cardTitleText = document.createTextNode(json[i].trackName);
		cardTitle.appendChild(cardTitleText);
		
		// Description section
		var cardText1 = document.createElement("p");
		cardText1.className = "card-text short text-center";
		var text1 = document.createTextNode(json[i].description);
		cardText1.appendChild(text1);
		
		// Author section
		var cardText2 = document.createElement("p");
		cardText2.className = "card-text text-center";
		var small = document.createElement("small");
		small.className = "text-muted";
		var text2 = document.createTextNode("By " + json[i].artistName);
		small.appendChild(text2);
		cardText2.appendChild(small);
		
		var hiddenId = document.createElement("p");
		hiddenId.className = "trackId";
		hiddenId.style.display = "none";
		var text = document.createTextNode(json[i].trackId);
		hiddenId.appendChild(text);
		
		card.appendChild(img);
		card.appendChild(cardBody);
		card.appendChild(cardTitle);
		card.appendChild(cardText1);
		card.appendChild(cardText2);
		card.appendChild(hiddenId);
		
		columns.appendChild(card);	
	}
	
	// Clicking on card will redirect to the details page
	var cards = document.getElementsByClassName("card");
	for (var i = 0; i < cards.length; i++) {
		cards[i].addEventListener('click', function(){
			setID(this.childNodes[5].innerText);
			location.href = "details.jsp";
		});
	}	
}

function setID(id) {
	localStorage.setItem('id', id);
}

function clear() {
	var columns = document.getElementById("columns");
	columns.innerHTML = "";
}