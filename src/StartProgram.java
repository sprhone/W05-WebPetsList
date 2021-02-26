// Program template provided: kjkleindorfer
// Customized for ConsolePetsList program by: sprhone

import java.util.List;
import java.util.Scanner;

import controller.PetsListHelper;
import model.PetsList;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static PetsListHelper plh = new PetsListHelper();

		private static void addAPet() {
			// TODO Auto-generated method stub
			System.out.print("Enter an owner: ");
			String owner = in.nextLine();
			System.out.print("Enter a type: ");
			String type = in.nextLine();
			System.out.print("Enter a name: ");
			String name = in.nextLine();
			
			PetsList toAdd = new PetsList(owner, type, name);
			plh.insertPet(toAdd);

		}

		private static void deleteAPet() {
			// TODO Auto-generated method stub
			System.out.print("Enter the owner to delete: ");
			String owner = in.nextLine();
			System.out.print("Enter the type to delete: ");
			String type = in.nextLine();
			System.out.print("Enter the name to delete: ");
			String name = in.nextLine();
			
			PetsList toDelete = new PetsList(owner, type, name);
			plh.deletePet(toDelete);

		}

		private static void editAPet() {
			// TODO Auto-generated method stub
			System.out.println("Enter number of search type: ");
			System.out.println("1 : Search by Owner");
			System.out.println("2 : Search by Type");
			System.out.println("3 : Search by Name");

			int searchBy = in.nextInt();
			in.nextLine();
			List<PetsList> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the owner name: ");
				String ownerName = in.nextLine();
				foundItems = plh.searchForPetByOwner(ownerName);
			} else if (searchBy == 2) {
				System.out.print("Enter the pet type: ");
				String typeName = in.nextLine();
				foundItems = plh.searchForPetByType(typeName);
			} else {
				System.out.print("Enter the pet name: ");
				String petName = in.nextLine();
				foundItems = plh.searchForPetByName(petName);
				

			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (PetsList p : foundItems) {
					System.out.println(p.getId() + " : " + p.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				PetsList toEdit = plh.searchForPetById(idToEdit);
				System.out.println("Retrieved pet " + toEdit.getName() + " owned by: " + toEdit.getOwner());
				System.out.println("1 : Update Owner");
				System.out.println("2 : Update Type");
				System.out.println("3 : Update Pet Name");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Owner: ");
					String newOwner = in.nextLine();
					toEdit.setOwner(newOwner);
				} else if (update == 2) {
					System.out.print("New Type: ");
					String newType = in.nextLine();
					toEdit.setType(newType);
				} else if (update == 3) {
					System.out.println("New Pet Name: ");
					String newPetName = in.nextLine();
					toEdit.setName(newPetName);
				}

				plh.updatePet(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to an interesting Pet / Owner list! ---");
			while (goAgain) {
				System.out.println("\n*  Select an option below:");
				System.out.println("\n*  1 -- Add a pet");
				System.out.println("*  2 -- Edit a pet");
				System.out.println("*  3 -- Delete a pet");
				System.out.println("*  4 -- View the list of pets");
				System.out.println("*  5 -- Exit (But you'll really be missing out!)");
				System.out.print("\n*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAPet();
				} else if (selection == 2) {
					editAPet();
				} else if (selection == 3) {
					deleteAPet();
				} else if (selection == 4) {
					viewTheList();
				} else {
					plh.cleanUp();
					System.out.println("\nHopefully you enjoyed the list!\nGoodbye!");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			
			List<PetsList> allItems = plh.showAllPets();
			for (PetsList singleItem : allItems) {
				System.out.println(singleItem.returnPetDetails());
			}

		}

	}
