package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CharacterMaker;

/**
 * Servlet implementation class makeCharacterServlet
 */
@WebServlet("/makeCharacterServlet")
public class makeCharacterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public makeCharacterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String animal = request.getParameter("animal");
		String charName = request.getParameter("characterName");
		String ability = request.getParameter("abilitySelect");
		
		CharacterMaker newChar = new CharacterMaker(charName, animal, ability);
		
		request.setAttribute("userCharacter", newChar);
		
		getServletContext().getRequestDispatcher("/newCharacter.jsp").forward(request, response);
		
	}

}
