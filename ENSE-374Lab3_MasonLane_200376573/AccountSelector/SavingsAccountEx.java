/*Mason Lane            200376573            2019-09-26*/
/*ENSE 374 Lab 1 - Compound interest savings calculator*/

/*uncomment and then comment either line, or type in the number for the package you need */

import SavingsTool1.SavingsTool1;   
import SavingsTool2.SavingsTool2;
import java.util.Scanner;		/* user input */
import java.math.RoundingMode;		/* for rounding */
import java.text.DecimalFormat;

public class SavingsAccountEx{

	/**
	 * 
	 * @author Mason
	 * 
	 * This is an old class from a previous lab used to calculate biweekly/monthly compounding interest. 
	 * This file and its associated classes  have been modified to accommodate monthly deposits
	 * 
	 * The tool very simply calculates biweekly/monthly interest over 12 months
	 * User input for initial savings and interest is required. 
	 */
	public SavingsAccountEx()
		{	
			Scanner in = new Scanner(System.in);  /*for user input */
			DecimalFormat df = new DecimalFormat("0.00");  /*for rounding */
			float x = 0;			      /*variable initialization */
			float y = 0;
			float z = 0;
			float quit = 1;
			


			SavingsTool1 saver1;		      /* creating our class instances*/
			SavingsTool2 saver2;
			System.out.println("\n" + "If you chose a savings account, you could expect the following: " + "\n");

			System.out.println("Monthly compounding balance: ");
			x = in.nextFloat();
			System.out.println("\n");
			System.out.println("Biweekly compounding balance: ");
			y = in.nextFloat();
			


		        saver1 = new SavingsTool1(x);		/* using the balances, we create a new class w/constructor  */
		        saver2 = new SavingsTool2(y);

			System.out.println("\n");		/* user types in interest */
			System.out.println("Interest rate: ");
			z = in.nextFloat();
			saver1.modifyAnnualInterestRate(z);     /* fxn call to modify interest rate. should affect both class */
		
					saver1.interestCalculator();   /* calculates our interest - monthly or biweekly */
					saver2.interestCalculator();

				
	
			x=saver1.getValue();	/* we grab our new values and replace x and y */

			y=saver2.getValue();


			System.out.println("savings account after 12 months compounding monthly, with $500 monthly deposits: ");	/*show user their new balance */
			System.out.println("$ " + df.format(x));
			System.out.println("\n");
			System.out.println("savings account after 12 months compounding biweekly, with $500 monthly deposits: ");
			System.out.println("$ " + df.format(y));

			System.out.println("\n");			/* user can quit or continue with new balances and rate */


			
			

		}
		

	

	
}


