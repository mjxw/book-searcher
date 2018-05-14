import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book = request.getParameter("book");
		
        try {
        	// Hit the Apple API and feed it the book title 
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet getRequest = new HttpGet("https://itunes.apple.com/search?term=" + book + "&media=ebook");
            HttpResponse getResponse = client.execute(getRequest); 
            
            // Stream reading...
            BufferedReader rd = new BufferedReader(new InputStreamReader(getResponse.getEntity().getContent()));
           
            // Use GSON to parse stream and convert it to Java object with all the fields we are interested in
            Gson gson = new GsonBuilder().create();
            SearchResponse searchData = gson.fromJson(rd, SearchResponse.class);
            
            // Create a list of SearchResults (object containing all the fields needed *only* for search results)
            // Create a list for BookResults (object containing all the fields needed *only* for book details)
            ArrayList<SearchResult> searchList = new ArrayList<SearchResult>();
            ArrayList<BookResult> detailsList = new ArrayList<BookResult>();
            
            for(SearchResult result : searchData.getResults()) {
            	searchList.add(result.getSearchResult());
            	detailsList.add(result.getBookResult());
            }
     
            // Convert our JSON object back into a string and write the response to front-end
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();			
			String searchResultJson = new Gson().toJson(searchList);
			
					
			ServletContext context = request.getSession().getServletContext();
			context.setAttribute("DetailsList", detailsList);
			out.append(searchResultJson);
			out.close();
			

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }				
	}

}
