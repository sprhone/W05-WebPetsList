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
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet(name = "editListDetailsServlet", urlPatterns = { "/editListDetailsServlet" })
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		PetsListHelper plh = new PetsListHelper();
		LoreHelper lh = new LoreHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = ldh.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String loreName = request.getParameter("loreName");
		//find our add the new lore?
		Lore newLore = lh.findLore(loreName);
		
		try {
			//items are selected in list to add
			String[] selectedItems = request.getParameterValues("allPetsToAdd");
			List<PetsList> selectedPetsInList = new ArrayList<PetsList>();
			
			for (int i = 0; i < selectedItems.length; i++) {
				System.out .println(selectedItems[i]);
				PetsList pl = plh.searchForPetById(Integer.parseInt(selectedItems[i]));
				selectedPetsInList.add(pl);
				}
		
				listToUpdate.setListOfPets(selectedPetsInList);
			
			} catch (NullPointerException ex) {
				// no items selected in list - set to an empty list
				List<PetsList> selectedPetsInList = new ArrayList<PetsList>();
			listToUpdate.setListOfPets(selectedPetsInList);
			}
			
			listToUpdate.setListName(newListName);
			listToUpdate.setLore(newLore);
			ldh.updateList(listToUpdate);
			
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}

}
