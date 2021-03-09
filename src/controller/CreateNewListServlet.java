package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.Lore;
import model.PetsList;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet(name = "createNewListServlet", urlPatterns = { "/createNewListServlet" })
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PetsListHelper plh = new PetsListHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: "+ listName);
		
		String loreName = request.getParameter("loreName");

		String[] selectedPets = request.getParameterValues("allPetsToAdd");
		List<PetsList> selectedPetsInList = new ArrayList<PetsList>();
		
		//make sure something was selected – otherwise we get a null pointer exception
		if (selectedPets != null && selectedPets.length > 0) {
			for(int i = 0; i<selectedPets.length; i++) {
				System.out.println(selectedPets[i]);
				PetsList pl = plh.searchForPetById(Integer.parseInt(selectedPets[i]));
				selectedPetsInList.add(pl);
				}
			}
		Lore lore = new Lore(loreName);
		ListDetails ld = new ListDetails(listName, lore);
		ld.setListOfPets(selectedPetsInList);
		ListDetailsHelper ldh = new ListDetailsHelper();
		ldh.insertNewListDetails(ld);

		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
