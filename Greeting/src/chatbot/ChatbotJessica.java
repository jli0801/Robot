 package chatbot;

public class ChatbotJessica implements Topic {

	boolean endOfJess;
	
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response; 
	//private String[]calmResArr;
	
	private String[] upsetResArr;
	private String[] angryResArr;
  	private String[] jokesArr;
  	private String[] jokesAns;
  	private String[] jokesWrong;
 // 	private String[] gamesArr; 
 	
 	int gamesAns;
 	private String[] gamesWrong;
 	
 //	private String[] puns;
 	private boolean firstPlay;
 	private boolean firstPlayG;
 	
 	private int numChancesJ;
 	private int numChancesG;
 	private int moodIncrease;
 	private int level;
 	
 	private boolean gotCorrectJ;
 	private boolean gotCorrectG;
 	private boolean answersCorrectly;
 	
 	private boolean doneJoke;
 	private boolean doneGame;
 	private boolean saidYesJoke;
 	private boolean saidYesGame;
  	
  	public ChatbotJessica() {
 		String[] triggerM = {"joke", "game", "pun"};
 		
 		//in charge of entertainment
  		keywords = triggerM;
  	/*	String[] calmRes = {"Please answer my question.", "I don't think you get this. "
 				,"I don't understand.", "Come on! Just answer me!"};
 			
  		calmResArr = calmRes;*/
  		String[] upsetRes = {"I can't understand you if you won't be specific. ", "Please explain further. "
  				,"I need more details. ", "Do you really understand? ", "Please answer my question.", "I don't think you get this. "
 				,"I don't understand.", "Come on! Just answer me!"};
  		upsetResArr = upsetRes;
		String[] angryRes = {"Wow, you don't get it?", "Wasn't that a good pun!?", 
				     "Fine, we can go back to serious business if you don't enjoy this."};
		angryResArr = angryRes;
 		//determines mood/emotion
  		String[] jokes = {"What type of clothing does a house wear?"};
  		jokesArr = jokes;
	
 		String[] answerJ = {"Get it? Address!", "Address! It's a play on words!"
 				, "It's a combination of \"a\" and dress so it's address!"};	
  		jokesAns = answerJ;
 		goodbyeKeyword = "bye";
 		
 		String[] answerWrongJ = {"Noo! Guess again.", "Are you even trying?", 
 				"Come on! What type of clothing does a house wear?", "The answer is one word!",
 				"The answer was address! Gosh, you're such a stick in the mud."};
 		jokesWrong = answerWrongJ;
 		//ended jokes now onto games
		
  	
 		
 		String[] answerWrongG = {"Nope! Try again!", "Are you even trying?", 
 				"The answer is too low.", "Come on! You got to try harder than that.",
 				  "Your answer is too high.", "Try something lower than that." ,
				 "Come on! The game can't last forever.", "Guess again!"};
 		gamesWrong = answerWrongG;
 		
 	//	String[] puns = {"You came at an eggcellent time!", "Isn't this egglastic?", "Aren't you being a but eggtreme?"
	//	+ "");
 		
 		goodbyeKeyword = "bye";
 		secretKeyword = "funny"; 
  		response = "";
 		moodIncrease = 0;
 		numChancesJ = 0;
 		numChancesG = 0;
 		
 		gotCorrectG = false;
 		answersCorrectly = false;
 		firstPlay = false;
 		firstPlayG= false;
 		
 		endOfJess = false;
 		
 		saidYesJoke = false;
 		saidYesGame = false;
 		doneJoke = true;
 		doneGame = true;
 		level = 1;
  	}
  
  	
 		
  		
  public void talk(String response) {
	  		
			
				while (ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1)
				{
					if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0)
					{
						ChatbotMain.print("I'm glad you find me funny! What else would you like to hear? We can play a game, " +
								 "tell puns or jokes?");
		
						response = ChatbotMain.getInput();
					}
					else
  				{
  			
 							
 							if (ChatbotMain.findKeyword(response, keywords[0], 0) >= 0 || saidYesJoke) //saidYestJoke
 							{
 								while(doneJoke)
 								{
 								tellAJoke(response);
 								
	 								if(gotCorrectJ)
	 								{
	 									doneJoke = false;
	 									ChatbotMain.print("You got the answer! " + 	
	 									jokesAns[(int) (Math.random()*3)] + " Let's play a game!");

	 									saidYesGame = true;
	 								
	 									
	 								//	ChatbotMain.chatbot.startChatting();  //idk if this works
	 									
	 								}
	 								else
	 								{
	 									ChatbotMain.print(jokesWrong[(int) (Math.random()*3)]); 
	 								}
 								}
 								
 							}
 							
 							if (ChatbotMain.findKeyword(response, keywords[1], 0) >= 0 || saidYesGame)//use same method for JOKE 
 								{
	 								while(doneGame)
	 								{
	 									if(isInteger(response))
	 									{
	 										tellAGame(response, level);
	 									}
	 									else
	 									{
	 										ChatbotMain.print("You must enter an integer. Play the game correctly!");
	 									}
	 									
		 									if(gotCorrectG)
		 									{
		 									doneGame = false;
		 									ChatbotMain.print("Do you want to play again with a harder level?");
		 										
		 										if(saidYes(response))
		 										{
		 											level++;
		 											if(isInteger(response))
		 		 									{
		 			 									tellAGame(response, level);
		 			 									
		 		 									}
		 		 									else
		 		 									{
		 		 										
		 		 										ChatbotMain.print("You must enter an integer. Play the game correctly!");
		 		 									}
		 											
		 										}		
		 										else
		 										{
		 											ChatbotMain.print("Fine! We can talk about college, personal stuff, academics, or other"
		 													+ " boring stuff.");
		 											ChatbotMain.chatbot.startChatting(); 
		 										}
		 									}
	 									}
	 									
	 								}
 								}
 								
 						/*	if (ChatbotMain.findKeyword(response, keywords[3], 0) >= 0 )
 							{
 								ChatbotMain.print("I'll tell you a great " + keywords[3]+ ". ");
 								tellAPun(response);
 								
 								if(answersCorrectly)
 								{
 									continuePun();
 								}
 								else
 								{
 									ChatbotMain.print(angryResArr[(int) (Math.random()*3)]); 
 								}
 								
 							}*/
 							
 						}
 					
 						
  						
  					
				endOfJess = true;
				ChatbotMain.chatbot.startChatting(); 
 }
				
  				
  	public boolean saidYes(String response)
  	{
  		return (ChatbotMain.findKeyword(response, "yes", 0) >= 0) || (ChatbotMain.findKeyword(response, "yeah", 0) >= 0 ||
  				ChatbotMain.findKeyword(response, "sure", 0) >= 0);
  	}
	public boolean isInteger(String response) {

			 try { 
			        Integer.parseInt(response); 
			    } catch(NumberFormatException e) { 
			        return false; 
			    } catch(NullPointerException e) {
			        return false;
			    }
			    // only got here if we didn't return false
			    return true;
			
	}
	public int getInteger(String response)
	{
			int responseInt;
			responseInt = 0;
			return responseInt = Integer.parseInt(response);
	}	

	public void tellAJoke(String response)
	{
		gotCorrectJ = false;
		firstPlay = false;
		if(!firstPlay)
		{
			
			ChatbotMain.print("Yes of course. I'll tell you a great joke!");
			ChatbotMain.print(jokesArr[0]);
		}
		
			while(!gotCorrectJ)
			{
				
				response = ChatbotMain.getInput();
				firstPlay = true;
				
				
				if(testAnsTrue(response))
				{
					gotCorrectJ = true;
					
				}
				else
				{
					if(ChatbotMain.findKeyword(response, "dress", 0) >= 0)
					{
						ChatbotMain.print("No, don't be silly! They can't wear a dress!");
					}
					
				
					
					numChancesJ++;
					if(numChancesJ > 5 )
					{
					gotCorrectJ = true;	
					ChatbotMain.print(jokesAns[(int) (Math.random()*3)]);
					}
					else
					{
					ChatbotMain.print(upsetResArr[(int) (Math.random()*6)]);
					}
				}
				
				}
				
				
	}


	public void tellAGame(String response , int level) //currently stuck after you give an integer
	{
		
			int responseI = getInteger(response);
			ChatbotMain.print("You are on level: " + level +"." + "Give me a number!");
			gamesAns = (int) (Math.random()*(level*25)); //range increases
			firstPlayG = false;
			
			if(!firstPlayG)
			{
				ChatbotMain.print("Oh, I heard the word game! Would you like to play with me?" );
					response = ChatbotMain.getInput();
					if (saidYes(response)) //check
					{
						ChatbotMain.print("It's a number guessing game. Give me a random number!");
						response = ChatbotMain.getInput();
						
						if(isInteger(response))
						{
							tellAGame(response, level);
						}
						else
						{
							
							ChatbotMain.print("You must enter an integer. Play the game correctly!");
						}
					}
					else
					{
						ChatbotMain.chatbot.startChatting();
					}
			
			}
			
			while(!gotCorrectG) 
			{
				firstPlayG = true;
				if(responseI > gamesAns) //less than
				{
					gotCorrectG = false;
					numChancesG++;
					ChatbotMain.print(gamesWrong[(int) (Math.random()*4)]); //first four
				}
				
				if(responseI < gamesAns) //more than
				{
					gotCorrectG = false;
					numChancesG++;
					ChatbotMain.print(gamesWrong[(int) (Math.random()*4)+4]); //last four	
				}
				
				if(responseI == gamesAns)
				{
					gotCorrectG = true;
					
					ChatbotMain.print("You did it! You answered within" + numChancesG + "tries!");
				}
				
				
			}
				
				
	}
	
/*	public void tellAPun(String response)
	{

	}
	*/


 
  
	public void continueJokeConvo()
	{
		ChatbotMain.print(jokesAns[(int) (Math.random()*3)]);
		//check if answer is acceptable; could contain funny, make an array of "good words" 
		
	}
	
	public boolean testAnsTrue(String response)
	{
		if(ChatbotMain.findKeyword(response, "address", 0) >= 0 || ChatbotMain.findKeyword(response, "Address", 0) >= 0)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++)
		{
			//IMPORTANT (one the rubric) only if keyword is used
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0)
			{
				return true;
			}
		}
		return false;
  	
 	
  
		}
	
 }
  		

