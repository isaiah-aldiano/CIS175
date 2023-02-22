package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.climbingGear;

/**
 * Servlet implementation class addItermServlet
 */
@WebServlet("/addItemServlet")
public class addItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClimbingGearHelper dao = new ClimbingGearHelper();
		String path = "/index.html";
		
		String item = request.getParameter("item");
		String manufacturer = request.getParameter("manufacturer");
		String cost = request.getParameter("cost");
		
		float newCost = Float.parseFloat(cost.replaceAll("[^0-9.]", "")) ;
		newCost = Float.parseFloat(String.format("%.2f", newCost));	
		
		climbingGear newItem = new climbingGear(item, newCost, manufacturer);
		
		dao.insertItem(newItem); 
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
