

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


public class RetrieveDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RetrieveDetailsServlet() {
        super();
    }


    // Gets the book details 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");		
		
        ArrayList<BookResult> details = new ArrayList<BookResult>();

		ServletContext context = request.getSession().getServletContext();
		details = (ArrayList<BookResult>) context.getAttribute("DetailsList");
		
		BookResult result = new BookResult();
		for (int i = 0; i < details.size(); i++) {
			if (id.equals(details.get(i).getTrackId())) {
				result = details.get(i);
			}
		}
				
		context.setAttribute("BookDetails", result);
		String bookDetailsJson = new Gson().toJson(result);
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();						
		out.append(bookDetailsJson);
		out.close();
	}
}
