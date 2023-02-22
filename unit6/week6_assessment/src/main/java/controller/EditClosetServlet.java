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
 * Servlet implementation class EditClosetServlet
 */
@WebServlet("/editClosetServlet")
public class EditClosetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditClosetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = "/viewAllClosetsServlet";
		
		GearClosetHelper gch = new GearClosetHelper();
		ClimberHelper ch = new ClimberHelper();
		ClimbingGearHelper cgh = new ClimbingGearHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		gearCloset toEdit = gch.searchClosetById(tempId);
		
		String owner = request.getParameter("owner");
		String closetName = request.getParameter("closetName");
		
		climber someClimber = ch.searchClimbersByName(owner);
		
		try {
			String[] selectedItems = request.getParameterValues("selectItems");
			List<climbingGear> selectedItemsInList = new ArrayList<climbingGear>();
			
			for (String item : selectedItems) {
				selectedItemsInList.add(cgh.searchById(Integer.parseInt(item)));
			}
			
			toEdit.setClosetContents(selectedItemsInList);
		} catch (NullPointerException e) {
			List<climbingGear> selectedItemsInList = new ArrayList<climbingGear>();

			toEdit.setClosetContents(selectedItemsInList);
		}
		
		toEdit.setSomeClimber(someClimber);
		toEdit.setClosetName(closetName);
		
		gch.updateCloset(toEdit);
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
