

public class Main{
	/**
	 * ENSE 374 Lab 3
	 * Mason Lane 200376573
	 * 2019-10-18
	 * Account Selector
	 * This program will help a user choose their most ideal bank account, based on a sequence of questions and a scoring system 
	 */	
/**
 * 	
 * @param args
 * 
 * The Main class simply starts our program, greeting the user and preparing the user class. It will use the AskQuestion and GetResults 
 * functions to query the user and extrapolate an answer from the scored results
 * SavingsAccountEx bank is used to provide the user with an idea of what a savings account might behave like. I suspect I've made a 
 * a math error for biweekly
 */
	

	
	
	public static void main(String[] args)					
	{
		User user = new User();												//new user class
		System.out.println("Welcome, this program will do its best to discover the most optimal bank account for a user's unique circumstance" +"\n");	
		System.out.println("To begin, we will ask the following questions:" + "\n");	
		
		
			
		user.AskQuestion();													//ask series of questions
			
		
		user.GetResults();													//see results
			
		SavingsAccountEx bank = new SavingsAccountEx();					    //interest calculator
		
		
	}
	
	
}