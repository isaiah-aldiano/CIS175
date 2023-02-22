package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.climber;
import model.climbingGear;
import model.gearCloset;

/**
 * Servlet implementation class AddNewClosetServlet
 */
@WebServlet("/addNewClosetServlet")
public class AddNewClosetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewClosetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = "/viewAllClosetsServlet";
		
		ClimbingGearHelper cgh = new ClimbingGearHelper();
		GearClosetHelper gch = new GearClosetHelper();
		ClimberHelper ch = new ClimberHelper();
		
		String owner = request.getParameter("owner");
		String closet = request.getParameter("name");
		
		String[] select = request.getParameterValues("gearCloset");
		List<climbingGear> selectedGear = new ArrayList<climbingGear>();
		
		if (select != null && select.length > 0) {
			for(String gear : select) {
				System.out.println(gear);
				climbingGear item = cgh.searchById(Integer.parseInt(gear));
				selectedGear.add(item);
			}
		}
		
		climber closetOwner = ch.searchClimbersByName(owner);
		
		gearCloset newGC = new gearCloset(closet, closetOwner, selectedGear);
		
		gch.createCloset(newGC);
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
	
}
