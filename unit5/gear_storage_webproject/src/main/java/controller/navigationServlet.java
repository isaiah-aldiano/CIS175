package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.climbingGear;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String toDo = request.getParameter("doThis");
		String path = "/viewAllItemsServlet";
		
		ClimbingGearHelper dao = new ClimbingGearHelper();
		
		if(toDo.equals("Edit Item")) {
			
			try {
				int tempId = Integer.parseInt(request.getParameter("id"));
				climbingGear itemToEdit = dao.searchById(tempId);
				request.setAttribute("itemToEdit", itemToEdit);
				path = "/edit-item.jsp";
			} catch (Exception e) {
				request.setAttribute("noItemsSelected", " * No items were selected * ");
			}
		} else if (toDo.equals("Add Item")) {
			path = "/index.html";
		} else if (toDo.equals("Delete Item")) {
			try {
				int tempId = Integer.parseInt(request.getParameter("id"));
				dao.deleteItem(dao.searchById(tempId));
			} catch (Exception e) {
				request.setAttribute("noItemsSelected", " * No items were selected * ");
			}
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
