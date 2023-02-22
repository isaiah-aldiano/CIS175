package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.gearCloset;

/**
 * Servlet implementation class GearClosetNavigationServlet
 */
@WebServlet("/gearClosetNavigationServlet")
public class GearClosetNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GearClosetNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GearClosetHelper gch = new GearClosetHelper();
		ClimbingGearHelper cgh = new ClimbingGearHelper();
		
		String path = "/viewAllClosetsServlet";
		
		String act = request.getParameter("doThisToList");
		
		if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				gearCloset toDelete = gch.searchClosetById(tempId);
				gch.deleteCloset(toDelete);
			} catch (NumberFormatException e) {
				System.out.println("Please select list");
			} 
		} else if (act.equals("add")) {
			request.setAttribute("allItems", cgh.showAll());
			path = "/new-closet.jsp";
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				gearCloset toEdit = gch.searchClosetById(tempId);
				request.setAttribute("id", tempId);
				
				request.setAttribute("owner", toEdit.getSomeClimber());
				request.setAttribute("closetName", toEdit.getClosetName());
				
				request.setAttribute("allItems", cgh.showAll());
				
				if(cgh.showAll().isEmpty()) {
					request.setAttribute("allItems", " ");
				}
				path = "/edit-closet.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Please select list");
			}
		}
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
