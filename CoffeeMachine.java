package machine;

import java.util.Scanner;
import java.lang.*;

public class CoffeeMachine {

	public static int water = 400;
	public static int milk = 540;
	public static int coffee  = 120;
	public static int cups = 9;
	public static int money = 550;
	
	enum Machine {
		BUY,
		FILL,
		TAKE,
		REMAINING,
		EXIT
	};

    public static void main(String... args) {
    	Scanner scanner = new Scanner(System.in);
    	String choice = null;

    	System.out.println("write action (buy, fill, take, remaining, exit):");
		choice = scanner.next();

		CoffeeMachine coffeeMachine = new CoffeeMachine();
		coffeeMachine.displayData(choice); 
	}

	public void displayData(String choice) {
	
		if(Machine.BUY.toString().toLowerCase().equals(choice)) {

			new CoffeeMachine().callSell();
			System.out.println();
		
		} else if(Machine.FILL.toString().toLowerCase().equals(choice)) {

			new CoffeeMachine().callFill();
			System.out.println();
		
		} else if(Machine.TAKE.toString().toLowerCase().equals(choice)) {

			new CoffeeMachine().callTake();
			System.out.println();

		} else if(Machine.REMAINING.toString().toLowerCase().equals(choice)) {

			new CoffeeMachine().callRemaining();
			System.out.println();
		
		} else if(Machine.EXIT.toString().toLowerCase().equals(choice)) {

			new CoffeeMachine().callExit();
			System.out.println();
		}
	}

	public void callExit() {
		System.exit(0);
	}

	public void callTake() {

		System.out.println("I gave you "+money);
		money = 0;
		new CoffeeMachine().callBuy();
		System.out.println();
	}

	public void callRemaining() {

		System.out.println("The coffee machine has:");
		System.out.println(water+" of water");
		System.out.println(milk+" of milk");
		System.out.println(coffee+" of coffee beans");
		System.out.println(cups+" of disposable cups");
		System.out.println(money+" of money");
		new CoffeeMachine().callBuy();
		System.out.println();
	}

	public void callFill() {
		Scanner scanner = new Scanner(System.in);
		int waterToAdd = 0;
		int milkToAdd = 0;
		int coffeeToAdd = 0;
		int cupsToAdd = 0;

		System.out.println();
		System.out.println("Write how many ml of water do you want to add:");
		waterToAdd = scanner.nextInt();
		System.out.println("Write how many ml of milk do you want to add:");
		milkToAdd = scanner.nextInt();
		System.out.println("Write how many grams of coffee do you want to add:");
		coffeeToAdd = scanner.nextInt();
		System.out.println("Write how many disposable cups do you want to add:");
		cupsToAdd = scanner.nextInt();
		
		water += waterToAdd;
		milk += milkToAdd;
		coffee += coffeeToAdd;
		cups += cupsToAdd;

		new CoffeeMachine().callBuy();
		System.out.println();
	}

	public void callBuy() {
		Scanner scanner = new Scanner(System.in);
		String choice = null;
		System.out.println();
		System.out.println("write action (buy, fill, take, remaining, exit):");
		choice = scanner.next();
		System.out.println();

		if(choice.equals("buy")) {

			new CoffeeMachine().callSell();
			System.out.println();
		
		} else if(choice.equals("fill")) {

			new CoffeeMachine().callFill();
			System.out.println();
		
		} else if(choice.equals("take")) {

			new CoffeeMachine().callTake();
			System.out.println();

		} else if(choice.equals("remaining")) {

			new CoffeeMachine().callRemaining();
			System.out.println();
		
		} else if(choice.equals("exit")) {

			new CoffeeMachine().callExit();
			System.out.println();
		}
	}

	public void callSell() {
		Scanner scanner = new Scanner(System.in);
		String input = null;

		System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
		input = scanner.next();

		if(input.equals("1")) {

			new CoffeeMachine().callEspresso();
			System.out.println();

		} else if(input.equals("2")) {

			new CoffeeMachine().callLatte();
			System.out.println();
			
		} else if(input.equals("3")) {

			new CoffeeMachine().callCappuccino();
			System.out.println();

		} else if(input.startsWith("back")) {

			new CoffeeMachine().callBack();
			System.out.println();
		}
	}

	public void callBack() {
		Scanner scanner = new Scanner(System.in);
		String choice = null;

		System.out.println("write action (buy, fill, take, remaining, exit):");
		choice = scanner.next();
		
		if(choice.equals("buy")) {

			new CoffeeMachine().callSell();
			System.out.println();
		
		} else if(choice.equals("fill")) {

			new CoffeeMachine().callFill();
			System.out.println();
		
		} else if(choice.equals("take")) {

			new CoffeeMachine().callTake();
			System.out.println();

		} else if(choice.equals("remaining")) {

			new CoffeeMachine().callRemaining();
			System.out.println();
		
		} else if(choice.equals("exit")) {

			new CoffeeMachine().callExit();
			System.out.println();
		}	
	}

	public void callEspresso() {

		if(water >= 250 && coffee >= 12 && cups >= 1) {
		money += 4;
		water -= 250;
		milk -= 0;
		coffee -= 16;
		cups -= 1;

		System.out.println("I have enough resources, making you a coffee!");
		new CoffeeMachine().callBuy();

		} else if(water < 250) {

			System.out.println("Sorry, not enough water");
			System.out.println();
			new CoffeeMachine().callBuy();

		} else if(coffee < 16) {

			System.out.println("Sorry, not enough coffee");
			System.out.println();
			new CoffeeMachine().callBuy();

		} else if(cups < 1) {

			System.out.println("Sorry, not enough cups");
			System.out.println();
			new CoffeeMachine().callBuy();
		}

		System.out.println();
	}	

	public void callLatte() {

		if(water >= 350 && milk >= 75 && coffee >= 20 && cups >= 1) {
		money += 7;
		water -= 350;
		milk -= 75;
		coffee -= 20;
		cups -= 1;

		System.out.println("I have enough resources, making you a coffee!");
		new CoffeeMachine().callBuy();

		} else if(water < 350) {

			System.out.println("Sorry, not enough water");
			System.out.println();
			new CoffeeMachine().callBuy();

		} else if(coffee < 20) {

			System.out.println("Sorry, not enough coffee");
			System.out.println();
			new CoffeeMachine().callBuy();

		} else if(cups < 1) {

			System.out.println("Sorry, not enough cups");
			System.out.println();
			new CoffeeMachine().callBuy();
		} else if(milk < 75) {

			System.out.println("Sorry, not enough milk");
			System.out.println();
			new CoffeeMachine().callBuy();
		}

		System.out.println();
	}

	public void callCappuccino() {

		if(water >= 200 && milk >= 100 && coffee >= 12 && cups >= 1) {
		money += 6;
		water -= 200;
		milk -= 100;
		coffee -= 12;
		cups -= 1;

		System.out.println("I have enough resources, making you a coffee!");
		new CoffeeMachine().callBuy();

		} else if(water < 200) {

			System.out.println("Sorry, not enough water");
			System.out.println();
			new CoffeeMachine().callBuy();

		} else if(coffee < 12) {

			System.out.println("Sorry, not enough coffee");
			System.out.println();
			new CoffeeMachine().callBuy();

		} else if(cups < 1) {

			System.out.println("Sorry, not enough cups");
			System.out.println();
			new CoffeeMachine().callBuy();
		} else if(milk < 100) {

			System.out.println("Sorry, not enough milk");
			System.out.println();
			new CoffeeMachine().callBuy();
		}
		System.out.println();
	}
}