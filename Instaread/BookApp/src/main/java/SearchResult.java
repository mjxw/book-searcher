// This class represents an object that contains the necessary fields we need from the API
// There are two methods to further narrow down the fields needed for each specific use case: search results & book details
public class SearchResult {	
	private String artworkUrl60;
	private String trackName;
	private String trackViewUrl;
	private String formattedPrice;
	private String artistName;
	private String[] genres;
	private String description;
	private String trackId;
	
	// Create a SearchResult object for search results so that payload is as concise as possible
	public SearchResult getSearchResult() {
		SearchResult result = new SearchResult();
		result.artworkUrl60 = this.artworkUrl60;
		result.trackName = this.trackName;
		result.artistName = this.artistName;
		result.description = this.description;
		result.trackId = this.trackId;
		
		return result;
	}
	
	// Create a BookResult object to represent book details. Will store this in cache
	public BookResult getBookResult() {
		BookResult result = new BookResult();
		result.setArtworkUrl60(this.artworkUrl60);
		result.setTrackName(this.trackName);
		result.setTrackViewUrl(this.trackViewUrl);
		result.setFormattedPrice(this.formattedPrice);
		result.setArtistName(this.artistName);
		result.setGenres(this.genres);
		result.setDescription(this.description);
		result.setTrackId(this.trackId);
		
		return result;
	}
}
