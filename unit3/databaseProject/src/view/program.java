/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Feb 2, 2023
 */
package view;

import java.util.List;
import java.util.Scanner;


import controller.ClimbingGearHelper;
import model.climbingGear;

public class program {

	static Scanner user = new Scanner(System.in);
	static ClimbingGearHelper cgh = new ClimbingGearHelper();
	
	private static void viewGearList() {
		List<climbingGear> allItems = cgh.showAll();
		
		System.out.print("\n");
		
		if (!allItems.isEmpty()) {
			for(climbingGear item : allItems) {
				System.out.println(item.getGearSummary());
			}
		} else {
			System.out.println("* No Items Found *");
		}
		
		System.out.print("\n");
	}
	
	private static void addGear() {
		System.out.print("Manufacturer: ");
		String manufac = user.nextLine();
		System.out.print("Item: ");
		String item = user.nextLine();
		System.out.print("Cost: $");
		float cost = user.nextFloat();
		cost = (float) (Math.round(cost * 100.0) / 100.0);
		
		climbingGear newItem = new climbingGear(item, cost, manufac);
		
		cgh.insertItem(newItem);
	}
	
	private static void deleteGear() {
		System.out.print("Enter manufacturer to delete: ");
		String delManufac = user.nextLine();
		System.out.print("Enter item to delete: ");
		String delItem = user.nextLine();
		
		cgh.deleteItem(new climbingGear(delItem, delManufac));
	}
	
	private static void editGear() {
		int search;
		try {
			System.out.println("Search by:");
			System.out.println("1. Manufacturer");
			System.out.println("2. Item");
			System.out.print("* Choice: ");
			search = user.nextInt();
			user.nextLine();
		} catch (Exception e) {
			System.out.println("* Invalid input *");
			user.nextLine();
			return;
		}
		List<climbingGear> foundItems = null;
		boolean edit = true;
		while (edit) {
			if (search == 1) {
				System.out.print("Enter manufacturer to search: ");
				String editManufac = user.nextLine();
				
				foundItems = cgh.searchByManufacturer(editManufac);
				edit = false;
			} else if (search == 2) {
				System.out.print("Enter item to search: ");
				String editItem = user.nextLine();
				
				foundItems = cgh.searchByItem(editItem);
				edit = false;
			} else {
				System.out.println("Invalid input. Try again");
				search = user.nextInt();
				user.nextLine();
			}
		}
		
		if (!foundItems.isEmpty()) {
			System.out.println("* Items Found *\n");
			for (climbingGear item : foundItems) {
				System.out.println(item.getId() + ": " + item.getGearSummary());
			}
			System.out.print("\nWhich ID to edit: ");
			int idToEdit = user.nextInt();
			
			climbingGear toEdit = cgh.searchById(idToEdit);
			System.out.println("Retrieved gear: " + toEdit.getGearSummary());
			System.out.println("1. Edit manufacturer");
			System.out.println("2. Edit Item and Price");
			System.out.print("* To update: ");
			
			try {
				int update = user.nextInt();
				user.nextLine();
				
				if(update == 1) {
					System.out.print("New manufacturer: ");
					String newMan = user.nextLine();
					toEdit.setManufacturer(newMan);
				} else {
					System.out.print("New item: ");
					String newItem = user.nextLine();
					toEdit.setItem(newItem);
					
					System.out.print("New price: $");
					float newPrice = user.nextFloat();
					toEdit.setCost(newPrice);
				}
				
				cgh.updateItem(toEdit);
			} catch (Exception e) {
				System.out.println("* Invalid Input *");
				user.nextLine();
			}
			
		} else {
			System.out.println("* No results found * ");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		boolean goes = true;
		System.out.println("Welcome to the Climbing Gear vault");
		while(goes) {
			System.out.println("-- Select an action: ");
			System.out.println("-- 1. Add gear");
			System.out.println("-- 2. Delete gear");
			System.out.println("-- 3. Update gear");
			System.out.println("-- 4. View gear");
			System.out.println("-- 5. Quit");
			System.out.print("Action selection: ");
			int choice = user.nextInt();
			user.nextLine();
			
			switch(choice) {
			case 1:
				addGear();
				break;
			case 2:
				deleteGear();
				break;
			case 3:
				editGear();
				break;
			case 4:
				viewGearList();
				break;
			default: 
				System.out.println("Thank you!");
				cgh.cleanUp();
				goes = false;
				break;
			}
		}
	}
}
