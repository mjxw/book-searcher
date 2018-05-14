var url = new URL('http://localhost:8080/BookApp/RetrieveDetailsServlet')
var id = localStorage.getItem('id');

var params = {id:id}; 
url.search = new URLSearchParams(params);


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
          loadDetails(data);
    });
  }
)
.catch(function(err) {
  console.log('Fetch Error :', err);
});

function loadDetails(data) {
	var book = JSON.parse(data);	
	var details = document.getElementById("details");
	
	var card = document.createElement("div");
	card.className = "card mb-3";
	
	// Book image section
	var img = document.createElement("img");
	img.className = "card-img-top detail-image";
	img.src = book.artworkUrl60;
	
	var cardBody = document.createElement("div");
	cardBody.className = "card-body";
	
	// Book title section
	var cardTitle = document.createElement("div");
	cardTitle.className = "card-title text-center";
	var cardTitleText = document.createTextNode(book.trackName);
	cardTitle.appendChild(cardTitleText);
	
	// Author section
	var cardText1 = document.createElement("p");
	cardText1.className = "card-text";
	var text1 = document.createTextNode("Author: " + book.artistName);
	cardText1.appendChild(text1);
	
	// Genre section
	var cardText2 = document.createElement("p");
	cardText2.className = "card-text";
	var genres = book.genres;
	var text2 = document.createTextNode("Genres: " + genres.toString());
	cardText2.appendChild(text2);
	
	// Description section
	var cardText3 = document.createElement("p");
	cardText3.className = "card-text";
	var text3 = document.createTextNode("Summary: " + book.description);
	cardText3.appendChild(text3);
	
	// Buy button 
	var buyButton = document.createElement("button");
	buyButton.className = "btn btn-success";
	buyButton.type = "button";
	var text4 = document.createTextNode(book.formattedPrice);
	buyButton.appendChild(text4);
	
	// Redirect client to buy book 
	buyButton.addEventListener("click", function(){
		location.href= book.trackViewUrl;
	});

	card.appendChild(img);
	card.appendChild(cardBody);
	card.appendChild(cardTitle);
	card.appendChild(cardText1);
	card.appendChild(cardText2);
	card.appendChild(cardText3);
	card.appendChild(buyButton);
	
	details.appendChild(card);
}