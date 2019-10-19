/*
 * ENSE 374 Lab 3
 * Mason Lane 200376573
 * 2019-10-18
 * Account Selector
 * This program will help a user choose their most ideal bank account, based on a sequence of questions and a scoring system 
 */



public class MoneyMarketAccount{
	/**
	 * 
	 * @author Mason
	 * 
	 * This class contains all the scoring values based on a user's answer for a given question. 
	 * Based on a user's input, Answer(x,y) will add the scoring value of its associated question. 
	 * Ex: question[1][0] relates to question [1], answer [0].
	 * Specifically, these answers and score results are for Money Markets
	 */
	
	
	private double[][] question;			//array of question values
	private double score;					//score based on answers

	public MoneyMarketAccount()
	{
		question = new double[10][3];		//initialize our array size and score
		score = 0;

		//we fill our answer values
		//Does interest matter to you?
		question[0][0] = 1;				//high need
		question[0][1] = 0.5;				//medium
		question[0][2] = 0.25;					//low
		//Variable? interest?
		question[1][0] = 1;					//yes variable
		question[1][1] = 0;			   		//no variable
		question[1][2] = 0;			   		//I do not care
		//Do you want it to be most accessible?
		question[2][0] = 0.25;				//most accessible
		question[2][1] = 0.5;				//slightly
		question[2][2] = 1;					
		//Do you want to withdraw?
		question[3][0] = 0.25;				//often withdraw
		question[3][1] = 0.5;				//sometimes
		question[3][2] = 1;					//
		//Do you need a debit card?
		question[4][0] = 0;						
		question[4][1] = 1;					//need debit card	
		question[4][2] = 0;					//dont care
		//Do you need checks?
		question[5][0] = 0.25;				//yes
		question[5][1] = 0.5;				//a little
		question[5][2] = 1;					//no checks
		//Do you need to pay bills?
		question[6][0] = 1;					
		question[6][1] = 0;					//need to pay bills
		question[6][2] = 1;					//dont care
		//Do you mind minimum balance fees?
		question[7][0] = 1;				//I assume I would have them
		question[7][1] = 0.5;				//I do not mind
		question[7][2] = 0.25;					//I do not want large minimum balance fees
		//Is this long term savings?
		question[8][0] = 1;				//interest matters more
		question[8][1] = 0.5;				//yes
		question[8][2] = 0.25;					//no
		//Do you mind having a minimum opening balance?
		question[9][0] = 1;				//I assumed I'd need a large one
		question[9][1] = 0.5;				//I do not care
		question[9][2] = 0.25;					//I do not want a large minimum opening balance
		
	/*	question[10][0] = 0.25;				this was a question intended for fees, 
		question[10][1] = 0.5;				but i do not know which acc has more fees
	 	question[10][2] = 1;    */
		
	}
	
	public void Answer(int x, int y)
	{
		score = score + question[x][y];		//add to score based on answer associated with array
	}
	public double GetScore()
	{
		return score;						//display the score
	}
	
}