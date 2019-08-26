package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int reportLength = scan.nextInt();
		
		String[][] report = new String[reportLength][4];
		
		for(int i = 0; i < reportLength; i++)
		{
			report[i][0] = scan.next(); //stores name of object
			scan.next();
			report[i][1] = "0"; //stores total number bought
			report[i][2] = "0"; //stores number of customers
			report[i][3] = ""; //stores names of customers
		}
		
		int numCustomers = scan.nextInt();
		int numItems, numBought;
		
		String itemBought, name;
		
		for(int i = 0; i < numCustomers; i++)
		{
			name = scan.next() + " " + scan.next();
			
			numItems = scan.nextInt();
			
			for(int j = 0; j < numItems; j++)
			{
				numBought = scan.nextInt();
				itemBought = scan.next();
				
				for(int a = 0; a < report.length; a++)
				{
					if(report[a][0].equals(itemBought))
					{
						report[a][1] = (numBought+Integer.parseInt(report[a][1]))+"";
						
						if(!report[a][3].contains(name))
						{
							report[a][2] = (1+Integer.parseInt(report[a][2]))+"";
							
							report[a][3] = report[a][3] + " " + name;
						}
					}
				}
			}
		}
		
		for(int i = 0; i < reportLength; i++)
		{
			if(report[i][1].equals("0"))
			{
				System.out.println("No customers bought "+report[i][0]);
			}
			else
			{
				System.out.println(report[i][2]+" customers bought "+report[i][1]+" "+report[i][0]);
			}
			
		}
	}
}
