import java.util.List;

// This class represents the general API json response returned from Apple API
public class SearchResponse {
	private int resultCount;
	private List<SearchResult> results;	
	
	public List<SearchResult> getResults() {
		return results;
	}
}
