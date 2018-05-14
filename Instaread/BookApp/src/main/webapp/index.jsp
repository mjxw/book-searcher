<html>
  <head>
    <link rel="icon" type="image/x-icon" href="https://instaread.co/favicon.ico">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <link rel="stylesheet" href="styles.css">
    <title>Instaread - Books</title>
  </head>
<body>

<!-- NAVBAR SECTION -->
<nav class="navbar navbar-expand-sm navbar-light bg-light fixed-top">
  <div class="container">
	<a class="navbar-brand"><img src="https://instaread.co/images/instaread_logo_grey.svg" alt="Instaread Logo"></a>
  	
  	<!-- Collapse-able search button -->
  	<button class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
  		<span class="navbar-toggler-icon"></span>
  	</button>
  	<div class="collapse navbar-collapse" id="navbarCollapse">
	  	<div class="navbar-nav ml-auto">
	  	  	<form class="form-inline" id="searchForm">
				<input class="form-control mr-sm-2" id="searchInput" name="book" type="search" placeholder="Search" aria-label="Search" >
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
	  	</div>
  	</div>
  </div>
  
</nav>

<div id="bookSection">
	<div class="container-fluid content-row">
		<div class="row">
			<div class="card-columns" id="columns">

			</div>
		</div>
	</div>
</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    <script src="searchScripts.js"></script>
</body>
</html>
