package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int numCustomers = scan.nextInt();
		
		int numItems, quantity;
		
		double price, totalCost;
		
		// Creates an array to store the first initial, last name, and total cost.
		String[][] customers = new String[numCustomers][3];
		
		// Assigns values to customers array.
		for(int i = 0; i < numCustomers; i++)
		{
			String fName = scan.next();
			String lName = scan.next();
			
			// Stores first initial of first name and entire last name.
			customers[i][0] = fName.substring(0,1);
			customers[i][1] = lName;
			
			numItems = scan.nextInt();
			
			totalCost = 0;
			
			// Finds the total cost of the items by adding all individual item costs.
			for(int j = 0; j < numItems; j++)
			{
				quantity = scan.nextInt();
				
				scan.next();
				
				price = scan.nextDouble();
				
				totalCost += quantity * price;
			}
			
			customers[i][2] = ""+totalCost;
		}
		
		scan.close();
		
		// Prints out customers array in correct format.
		for(int i = 0; i < numCustomers; i++)
		{
			System.out.println(customers[i][0]+". "+customers[i][1]+": "+String.format("%.2f",customers[i][2]));
		}
	}
}
