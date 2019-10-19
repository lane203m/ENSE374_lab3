/*
 * ENSE 374 Lab 3
 * Mason Lane 200376573
 * 2019-10-18
 * Account Selector
 * This program will help a user choose their most ideal bank account, based on a sequence of questions and a scoring system 
 */


package SavingsTool2;						/*package for our tool*/


public class SavingsTool2{

/**
 * 
 * @author Mason
 * 
 * This is an old class from a previous lab used to calculate biweekly interest. It has been modified to accomodate
 * monthly deposits, though I believe an error exists in the math
 * 
 * The tool very simply calculates biweekly interest over 12 months, with various functions for adjusting initial value and interest
 */
	private static float annualInterestRate;		/*our interest*/
	private float savingsBalance;				/*$ balance*/
	public static void modifyAnnualInterestRate(float x)
		{
			annualInterestRate = x;			/*fxn to change %*/
		}
	public void interestCalculator()
		{
			int k =0;
		    	for(int i = 0; i<26; i++)  		/*compounded bi-weekly, 12 months. +500 monthly */
				{
		    savingsBalance = savingsBalance + (savingsBalance * (annualInterestRate/100)/26);
				if(k > 4.34)
				{
					savingsBalance = savingsBalance + 500;
					k=0;
				}
				k = k+2;
				}
	            
		}
	public SavingsTool2()
		{
			annualInterestRate = 0;			/*default constructor*/
		}
	public SavingsTool2(float y)
		{
			savingsBalance = y;			/* constructor */
		}
	public float getValue()
		{
			return(savingsBalance);			/*method to get  a user's balance */
		}


}
