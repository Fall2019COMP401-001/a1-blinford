package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int numItems = scan.nextInt();
		int numItemsBought, quantity;
		
		String name;
		
		double totalCost;
		
		String[][] items = new String[numItems][2];
		//items[x][0] name of x
		//items[x][1] price of x
		
		//populates items array
		for(int i = 0; i < numItems; i++)
		{
			items[i][0] = scan.next();
			items[i][1] = scan.next();
		}
		
		int numCustomers = scan.nextInt();
		
		String[][] customers = new String[numCustomers][3];
		//customers[x][0] first name of customer x
		//customers[x][1] last name of customer x
		//customers[x][2] total cost for customer x
		
		//populates customers array
		for(int i = 0; i < numCustomers; i++)
		{
			customers[i][0] = scan.next();
			customers[i][1] = scan.next();
			
			numItemsBought = scan.nextInt();
			
			totalCost = 0;
			
			//finds the cost by finding the sum of each individual item's cost
			for(int j = 0; j < numItemsBought; j++)
			{
				quantity = scan.nextInt();
				name = scan.next();
				
				totalCost += quantity * getCost(items,name);
			}
			
			customers[i][2] = ""+totalCost;
		}
		
		String max = String.format("%.2f", max(customers));
		String maxName = nameOfMax(customers);
		
		String min = String.format("%.2f", min(customers));
		String minName = nameOfMin(customers);
		
		String average = String.format("%.2f",average(customers));
		
		
		//prints out the formatted values
		System.out.println("Biggest: "+maxName+" ("+max+")");
		System.out.println("Smallest: "+minName+" ("+min+")");
		System.out.println("Average: "+average);
	}
	
	
	// Returns the cost of the object assigned in the items array.
	public static double getCost(String[][] items,String name)
	{
		for(String[] a : items)
		{
			if(a[0].equals(name))
				return Double.parseDouble(a[1]);
		}
		
		return 0.0;
	}
	
	public static double max(String[][] customers)
	{
		double max = Double.parseDouble(customers[0][2]);
		
		for(String[] a : customers)
		{
			if(Double.parseDouble(a[2]) > max)
			{
				max = Double.parseDouble(a[2]);
			}
		}
		
		return max;
	}
	
	public static String nameOfMax(String[][] customers)
	{
		double max = Double.parseDouble(customers[0][2]);
		String name = customers[0][0] + " " + customers[0][1];
		
		for(String[] a : customers)
		{
			if(Double.parseDouble(a[2]) > max)
			{
				name = a[0]+" "+a[1];
				max = Double.parseDouble(a[2]);
			}
		}
		
		return name;
	}
	
	public static double min(String[][] customers)
	{
		double min = Double.parseDouble(customers[0][2]);
		
		for(String[] a : customers)
		{
			if(Double.parseDouble(a[2]) < min)
			{
				min = Double.parseDouble(a[2]);
			}
		}
		
		return min;
	}
	
	public static String nameOfMin(String[][] customers)
	{
		double min = Double.parseDouble(customers[0][2]);
		String name = customers[0][0] + " " + customers[0][1];
		
		for(String[] a : customers)
		{
			if(Double.parseDouble(a[2]) < min)
			{
				name = a[0]+" "+a[1];
				min = Double.parseDouble(a[2]);
			}
		}
		
		return name;
	}
	
	public static double average(String[][] customers)
	{
		double total = 0;
		
		for(String[] a : customers)
		{
			total += Double.parseDouble(a[2]);
		}
		
		return total/customers.length;
	}
}
