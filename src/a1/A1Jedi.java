package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int reportLength = scan.nextInt();
		
		String[][] report = new String[reportLength][4];
		//report[x][0] name of x
		//report[x][1] total number bought
		//report[x][2] number of customers who bought x
		//report[x][3] names of customers who bought x
		
		//populates report array
		for(int i = 0; i < reportLength; i++)
		{
			report[i][0] = scan.next();
			scan.next();
			
			//assigns starting values to each (null would be an invalid start)
			report[i][1] = "0";
			report[i][2] = "0";
			report[i][3] = "";
		}
		
		int numCustomers = scan.nextInt();
		int numItems, numBought;
		
		String itemBought, name;
		
		//assigns correct values to report array
		for(int i = 0; i < numCustomers; i++)
		{
			name = scan.next() + " " + scan.next();
			
			numItems = scan.nextInt();
			
			//loops through each set of items
			for(int j = 0; j < numItems; j++)
			{
				numBought = scan.nextInt();
				itemBought = scan.next();
				
				for(int a = 0; a < report.length; a++)
				{
					if(report[a][0].equals(itemBought))
					{
						report[a][1] = (numBought+Integer.parseInt(report[a][1]))+"";
						
						//if the customer has not previously purchased the same item,
						//then the name will be added to the list
						if(!report[a][3].contains(name))
						{
							report[a][2] = (1+Integer.parseInt(report[a][2]))+"";
							
							report[a][3] = report[a][3] + " " + name;
						}
					}
				}
			}
		}
		
		//prints out values in correct format
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
