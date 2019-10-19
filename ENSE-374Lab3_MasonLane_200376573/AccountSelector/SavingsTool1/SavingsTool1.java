/*
 * ENSE 374 Lab 3
 * Mason Lane 200376573
 * 2019-10-18
 * Account Selector
 * This program will help a user choose their most ideal bank account, based on a sequence of questions and a scoring system 
 */




package SavingsTool1;						/*package for our tool*/


public class SavingsTool1{

/**
 * 
 * @author Mason
 * 
 * This is an old class from a previous lab used to calculate monthly interest. It has been modified to accomodate
 * monthly deposits.
 * 
 * The tool very simply calculates monthly interest over 12 months, with various functions for adjusting initial value and interest
 */
	private static float annualInterestRate;		/*our interest*/
	private float savingsBalance;				/*$ balance*/
	public static void modifyAnnualInterestRate(float x)
		{
			annualInterestRate = x;			/*fxn to change %*/
		}
	public void interestCalculator()
		{
		    	for(int i = 0; i<12; i++)  		/*monthy compounded, 12 months +500 monthly*/
				{
		    savingsBalance = savingsBalance + (savingsBalance * (annualInterestRate/100)/12);
		    savingsBalance = savingsBalance + 500;
				}
	            
		}
	public SavingsTool1()
		{
			annualInterestRate = 0;			/*default constructor*/
		}
	public SavingsTool1(float y)
		{
			savingsBalance = y;			/* constructor */
		}
	public float getValue()
		{
			return(savingsBalance);			/*method to get  a user's balance */
		}


}
