package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CharacterMaker;
import model.apeIndexCalculator;

/**
 * Servlet implementation class calculateApeIndexServlet
 */
@WebServlet("/calculateApeIndexServlet")
public class calculateApeIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calculateApeIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int height =  Integer.parseInt(request.getParameter("height"));
		int wingspan= Integer.parseInt(request.getParameter("wingspan"));
		
		apeIndexCalculator newApe = new apeIndexCalculator(height, wingspan);
		
		request.setAttribute("apeResults", newApe);
		
		getServletContext().getRequestDispatcher("/apeResults.jsp").forward(request, response);
	
	}

}
