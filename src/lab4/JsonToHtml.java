package lab4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.owlike.genson.Genson;

import Lab1.DataCollection;
import Lab1.DataCollectionBuilder;
import Lab1.DataSource;
import Lab1.MatchedDataPair;
import Lab1.Resolution;
import workshop.FootballGoalsSource;
import workshop.TemperatureSource;

/**
 * Servlet implementation class JsonToHtml
 */
@WebServlet("/JsonToHtml")
public class JsonToHtml extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DataSource footballGoals;
	private DataSource temperature;
	private DataCollectionBuilder dataCollectionBuilder;
	private DataCollection datacollection;
	private Map<String, MatchedDataPair> map;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		footballGoals = new FootballGoalsSource("Strömvallen");
		temperature = new TemperatureSource();
		footballGoals.getData();
		temperature.getData();
		dataCollectionBuilder = new DataCollectionBuilder(footballGoals, temperature, Resolution.DAY);
		String jsonString = new Genson().serialize(dataCollectionBuilder.getResult());
		
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String pretty = request.getParameter("pretty");
            
            out.println("Ok");
           // System.out.println(jsonString);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
