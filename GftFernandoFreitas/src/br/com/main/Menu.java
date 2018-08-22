package br.com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.model.Breakfast;
import br.com.model.Dinner;

public class Menu {

	static Scanner input = new Scanner(System.in);
	static int option;

	public static void menu() {
		System.out.println("Welcome to the diet simulator GFT Recruiter");
		System.out.println("Choose the options below: ");
		System.out.println("1. List all diet options available");
		System.out.println("2. Consult Diet:");
		System.out.println("Opcao:");
	}

	public static void consultDiet() {
		System.out.println(
				"To consult the diet correctly You must enter the time of day as 'Morning' or 'Night' and insert a comma-delimited list.\nEx: Morning,1,2,3");

		String chooseOption = input.next();
		String[] choose = chooseOption.split(",");
		List<Integer> index = new ArrayList<>();

		for (int i = 1; i < choose.length; i++) {
			index.add(Integer.parseInt(choose[i]));
		}

		if (choose[0].equals(Breakfast.MORNING)) {
			Breakfast.printConsultDiet(index);
		} else if (choose[0].equals(Dinner.NIGHT)) {
			Dinner.printConsultDiet(index);
		} else {
			System.out.println("invalid option.");
		}
	}

	public static void main(String[] args) {

		do {
			menu();
			option = input.nextInt();

			switch (option) {

			case 1:

				Breakfast.printBreakfast();
				Dinner.printDinner();
				break;

			case 2:
				consultDiet();
				break;

			default:
				System.out.println("invalid option.");
			}

		} while (option != 0);

	}
}
