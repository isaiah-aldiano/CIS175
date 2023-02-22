package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.climbingGear;

/**
 * Servlet implementation class editItemServlet
 */
@WebServlet("/editItemServlet")
public class editItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path = "/viewAllItemsServlet";
		
		ClimbingGearHelper dao = new ClimbingGearHelper();
		
		String manufacturer = request.getParameter("newManufacturer");
		String item = request.getParameter("newItem");
		String cost = request.getParameter("newCost");
		int id = Integer.parseInt(request.getParameter("id"));
		
		float newCost = Float.parseFloat(cost.replaceAll("[^0-9.]", "")) ;
		newCost = Float.parseFloat(String.format("%.2f", newCost));	
		
		climbingGear toUpdate = dao.searchById(id);
		toUpdate.setManufacturer(manufacturer);
		toUpdate.setItem(item);
		toUpdate.setCost(newCost);
		
		dao.updateItem(toUpdate);
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
