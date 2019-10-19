/*
 * ENSE 374 Lab 3
 * Mason Lane 200376573
 * 2019-10-18
 * Account Selector
 * This program will help a user choose their most ideal bank account, based on a sequence of questions and a scoring system 
 */

import java.util.Scanner;

public class User{
	/**
	 * This is our largest class. It is responsible for initializing our account classes and managing our questions.
	 * It asks users questions, and prompts the various classes to increment their scores appropriately
	 * This class then uses the accumulated scores to select a winning account(s)
	 * In retrospect, I could have split this class into two more classes - a user and then questions/results class
	 */
	private String[] question;						//Our string array of questions
	private SavingsAccount savingsAccount;			//initialize each account and as such their answer values
	private CheckingAccount checkingAccount;
	private MoneyMarketAccount moneyMarketAccount;
	private String[] results;						//a string of the account names
	private Double[] score;							//final scores for testing
	private int answer;								//user answers
	public User()
	{
		question = new String[10];					//initialize our question size
		savingsAccount = new SavingsAccount();			//initialize our account classes
		checkingAccount = new CheckingAccount();
		moneyMarketAccount = new MoneyMarketAccount();
		results = new String[3];						//initialize their names
		results[0] = "Savings Account";
		results[1] = "Checking Account";
		results[2] = "Money Market Account";
		score = new Double[3];							//initialize score
		
		//filling our array of questions
		question[0]= "Is interest important to you? 1: Highly, 2: Slightly, 3: Barely";
		question[1]= "If you have interest, do you mind it being variable? 1: Yes, 2: No, 3: I do not care";
		question[2]= "Does this account need to be easily accecible? 1: Highly, 2: Slightly, 3: Barely";
		question[3]= "How often do you plan on making withdrawls? 1: Often, 2: Sometimes, 3: Almost never";
		question[4]= "Do you need a debit card? 1: Yes, 2: No, 3: I do not care";
		question[5]= "Do you need to make checks? 1: Often, 2: Sometimes, 3: Almost never";
		question[6]= "Do you need to pay bills? 1: Yes, 2: No, 3: I do not care";
		question[7]= "Do you mind minimum balance fees? 1: I assumed they would be large, 2: I do not mind, 3: I do not want large minimum balance fees";
		question[8]= "Is this long term savings? 1: Interest matters more, 2: Yes, 3: No";
		question[9]= "Do you mind having a minimum opening balance? 1: I assumed they would be large, 2: I do not care, 3: I do not want large minimum opening balances";
	}
	public void AskQuestion()
	{

		Boolean errorCheck = true; 					//to ensure proper input
		Scanner in = new Scanner(System.in);		//for input
		for (int i=0; i<10; i++)
		{
			System.out.println("\n"+ question[i]);	//display a question
		
		
			while(answer > 3 || answer < 1 || errorCheck)	//will repeat until a number between 1 and 3 is selected
			{
		
				try{
					System.out.println("\n"+ "please enter a # between 1 and 3" + "\n");
		
					answer = in.nextInt();			//a user is asked to enter an option between 1 and 3
					errorCheck = false;				//assume all was well 

				}
		  		catch(Exception e)
				{
					System.out.printf("only numbers are allowed");	//if all is not well, user has typed a char. exception. loop.
					in = new Scanner(System.in);

					errorCheck = true;
				}


			}
		errorCheck = true;							//reset error check for next question
		savingsAccount.Answer(i, answer-1);			//increment scores of each account based on the answer and question given
		checkingAccount.Answer(i, answer-1);
		moneyMarketAccount.Answer(i, answer-1);

		}
		
	}
	public void GetResults()						//compares our scores
	{
		int winner = 0;								//winner defaults to 0 (savingsAccount)
		boolean[] tie = new boolean[3];				//array to denote tied accounts
		score[0] = savingsAccount.GetScore();		//get the score of each account
		score[1] = checkingAccount.GetScore();
		score[2] = moneyMarketAccount.GetScore();
		
		
		System.out.println("\n"+ "Calculated scores: " + "\n");
		
		double max = score[0];						//display score of our first type of account	
		
		System.out.println(results[0]+": " + score[0] + "\n" + "\n");

		for(int i = 1; i<3; i++)
		{
			
			System.out.println(results[i]+": " + score[i] + "\n" + "\n");	//display the other two scores of the accounts
			
			if (score[i]>max)
			{
				max = score[i];												//while we display the accounts, we also find which of them 
				winner = i;													//has the greatest score
			}
			else if (score[i] == max)
			{
				tie[i] = true;												//if any two or more tie for highest, we fall into a tie state
				tie[winner] = true;
				
			}
			
		}
		
	
		
		
		if(tie[0] || tie[1] || tie[2])										//if one is tied, so must atleast one other
		{
			System.out.println("\n"+ "We have a tie, your suggested accounts are: " + "\n");
			for(int i = 0; i<3; i++)
			{
				if(tie[i])
				{
				System.out.println("\n"+ results[i] + "\n");				//display the scores and name of every tied account, suggesting both
				System.out.println("score: " + score[i] + "\n");
				}
			}
		}
		else
		{
			System.out.println("\n" + "You should choose the: "+ results[winner] + "\n");
			System.out.println("score: " + score[winner] + "\n");			//if we have only one winner, display score and name
		}
		
			
		
		
	}
}