 package chatbot;

public class ChatbotJessica implements Topic {

	private ChatbotJessica jessica;
	private ChatbotAreej areej;		
	private ChatbotVickie vickie;
	private ChatbotJi ji;
	
/*	public ChatbotAreej getAreej()
	{
		return areej;
	}
	public ChatbotVickie getVickie()
	{
		return vickie;
	}
	public ChatbotJi getJi()
	{
		return ji;
	}
	*/
//	boolean endOfJess;
	
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
  	//	areej = new ChatbotAreej();
	//	vickie = new ChatbotVickie();
	//	ji = new ChatbotJi();
		
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
		
  	
 		
 		String[] answerWrongG = {"Too small! Try again.", "Larger number please!", 
 				"The answer is too low.", "You got to try harder than that. Give me a larger number.",
 				  "Your answer is too high.", "Try something lower than that." ,
				 "Come on! It's too high.", "Guess again! Think something lower next time!"};
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
 		
 	//	endOfJess = false;
 		
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
								 "tell jokes?");
		
						response = ChatbotMain.getInput();
					}
					
  			
 							
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
	 									tellAGame(response, level);
		 									if(gotCorrectG)
		 									{

		 									ChatbotMain.print("Would you like to play the game in a harder level?");
		 									response = ChatbotMain.getInput();	
		 									if(saidYes(response))
		 									{
	 											level++;
	 											firstPlayG = false; //so they can play again
	 			 								tellAGame(response, level);
	 			 								gotCorrectG = false;
		 									}
		 									else
		 									{
		 										ChatbotMain.print("We can talk about college, personal stuff, academics, or other"
	 													+ " boring stuff.");
	 											
	 											doneGame = false;
	 											response = ChatbotMain.getInput();	
	 											triggerOtherClasses(response);
		 									}
		 											
		 									}
		 									else
		 									{
		 									ChatbotMain.print("Do you want to try again?");
		 									response = ChatbotMain.getInput();	
		 									
		 									if(saidYes(response))
		 									{
	 											firstPlayG = false; //so they can play again
	 											gotCorrectG = false;
	 			 								tellAGame(response, level);
		 									}
		 									else
		 									{
		 										ChatbotMain.print("We can talk about college, personal stuff, academics, or other"
	 													+ " boring stuff.");
		 										response = ChatbotMain.getInput();	
	 											ChatbotMain.chatbot.startChatting(); 
	 											doneGame = false;
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
 							
 				
			//	endOfJess = true;
				ChatbotMain.print("Come back when you have a great joke!");
				ChatbotMain.chatbot.startChatting(); 
 }
				
  				
  	public boolean saidYes(String response)
  	{
  		return ChatbotMain.findKeyword(response, "yes", 0) >= 0 || ChatbotMain.findKeyword(response, "yeah", 0) >= 0 ||
  				ChatbotMain.findKeyword(response, "sure", 0) >= 0 || ChatbotMain.findKeyword(response, "okay", 0) >= 0;
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
	
			
			if(!firstPlayG)
			{
				firstPlayG = true;
				ChatbotMain.print("Oh, I heard the word game! Let's play, it'll be fun!" );
			
				ChatbotMain.print("It's a number guessing game. You're on level: " + level + ". Give me a random number!");
				
				response = ChatbotMain.getInput();
				
				tellAGame(response, level);
				
			}		
			else
			{
					/*	if(isInteger(response))
						{	
						//	response = ChatbotMain.getInput();
							int gamesAns = (int) (Math.random()*(level*25)); //range increases
							
							*/
				int gamesAns = (int) (Math.random()*(level*25)); //range increases
							while(!gotCorrectG) 
							{
								response = ChatbotMain.getInput();
								
								if(isInteger(response))
								{
								int responseI = getInteger(response); 
							//	response = ChatbotMain.getInput();
								if(responseI == gamesAns)
								{
									gotCorrectG = true;
									numChancesG++;
									ChatbotMain.print("You did it! You answered within " + numChancesG + " tries!");
								} 
								else
								{
									if(responseI < gamesAns) //less than
									{
										
										//doneGame = true;
										numChancesG++;
										ChatbotMain.print(gamesWrong[(int) (Math.random()*4)]); //first four
									//	ChatbotMain.print("needs to be higher" + gamesAns);
								//		response = ChatbotMain.getInput();
									}
									
									if(responseI > gamesAns) //more than
									{
										
										numChancesG++;
										ChatbotMain.print(gamesWrong[(int) (Math.random()*4)+4]); //last four	
								//		ChatbotMain.print("needs to be lower" + gamesAns);
								//		response = ChatbotMain.getInput();
									}
								
									
									if(numChancesG > 5)
									{
										ChatbotMain.print("You couldn't get the answer! It was " + gamesAns +".");
										ChatbotMain.print("Do you want to try again?");
	 									response = ChatbotMain.getInput();	
	 									
	 									if(saidYes(response))
	 									{
 											firstPlayG = false; //so they can play again
 											gotCorrectG = false;
 			 								tellAGame(response, level);
	 									}
	 									else
	 									{
	 										ChatbotMain.print("We can talk about college, personal stuff, academics, or other"
 													+ " boring stuff.");
	 										response = ChatbotMain.getInput();	
 											ChatbotMain.chatbot.startChatting(); 
 											doneGame = false;
	 									}
									}
								}
								
							} //ends while loop
								else
								{
									
									ChatbotMain.print("You must enter an integer. Play the game correctly!");
							//		response = ChatbotMain.getInput();
									tellAGame(response, level);
								}
						}
						}
					/*	else
						{
							
							ChatbotMain.print("You must enter an integer. Play the game correctly!");
							response = ChatbotMain.getInput();
							tellAGame(response, level);
						}*/
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
	
	public void triggerOtherClasses(String response)
	{
		if(vickie.isTriggered(response))
		{
			vickie.talk(response);
		}
		else if(areej.isTriggered(response))
		{
			areej.talk(response);
		}
		else if(ji.isTriggered(response))
		{
			ji.talk(response);
		}
		else 
		{
			ChatbotMain.print("Pick one: Classes, colleges, or a joke?");
			response = ChatbotMain.getInput();
			triggerOtherClasses(response);
		}
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
  		

