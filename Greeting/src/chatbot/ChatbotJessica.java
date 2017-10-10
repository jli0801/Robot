 package chatbot;

public class ChatbotJessica implements Topic {

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
 
 	private int numChancesJ;
 	private int numChancesG;
 	private int moodIncrease;
 	
 	private boolean gotCorrectJ;
 	private boolean gotCorrectG;
 	private boolean answersCorrectly;
  	
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
  		String[] jokes = {"What makes oil boil?", ""};
  		jokesArr = jokes;
	
 		String[] answerJ = {"Get it? The letter B!", "It's a play on words/letters!"
 				, "It's genius isn't it?"};	
  		jokesAns = answerJ;
 		goodbyeKeyword = "bye";
 		
 		String[] answerWrongJ = {"Noo! Guess again.", "Are you even trying?", 
 				"Come on! What makes oil boil?", "The answer is one letter!!",
 				"The answer was B! Gosh, you're such a stick in the mud."};
 		jokesWrong = answerWrongJ;
 		//ended jokes now onto games
		
  	
 		
 		String[] answerWrongG = {"Nope! Try again!", "Are you even trying?", 
 				"The answer is too low.", "Come on! You got to try harder than that."
 				+  "Your answer is too high.", "Try something lower than that."
				+ "Come on! The game can't last forever.", "Guess again!"};
 		gamesWrong = answerWrongG;
 		
 	//	String[] puns = {"You came at an eggcellent time!", "Isn't this egglastic?", "Aren't you being a but eggtreme?"
	//	+ "");
 		
 		goodbyeKeyword = "bye";
 		secretKeyword = "funny"; 
  		response = "";
 		moodIncrease = 0;
 		numChancesJ = 0;
 		numChancesG = 0;
 		gotCorrectJ = false;
 		gotCorrectG = false;
 		answersCorrectly = false;
  	}
  
  	
 		
  		
  public void talk(String response) {
	  		
			
				while (ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1)
				{
					if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0)
					{
						ChatbotMain.print("I'm glad you find me funny! What else would you like to hear? We can play a game, "
								+ "tell puns or jokes?");
		
						response = ChatbotMain.getInput();
					}
					else
  				{
  			
 							
 							if (ChatbotMain.findKeyword(response, keywords[0], 0) >= 0 )
 							{
 								ChatbotMain.print("Yes of course. I'll tell you a " + keywords[0]+ ". ");
 								tellAJoke(response);
 								
 								if(gotCorrectJ)
 								{
 									continueJokeConvo();
 								}
 								else
 								{
 									ChatbotMain.print(jokesWrong[(int) (Math.random()*3)]); 
 								}
 								
 							}
 							if (ChatbotMain.findKeyword(response, keywords[1], 0) >= 0 )//use same method for JOKE 
 								{
 									ChatbotMain.print("Oh, I heard the word game! Would you like to play with me?" );
 									response = ChatbotMain.getInput();
 									if ((ChatbotMain.findKeyword(response, "yes", 0) >= 0) || (ChatbotMain.findKeyword(response, "yeah", 0) >= 0)) //check
 									{
 									ChatbotMain.print("It's a number guessing game to play. You must type in an integer! ");
 									response = ChatbotMain.getInput();
	 									if(isInteger(response))
	 									{
										int numInt = getInteger(response);
										int level = 1;
	 									tellAGame(numInt, level);
											if(gotCorrectG)
											{
											level++;
											ChatbotMain.print("Do you want to play again with a harder level?");
											tellAGame(numInt, level);
											}		
	 									}
	 									else
	 									{
	 										
	 										ChatbotMain.print("You must enter an integer. Play the game correctly!");
	 									}
 									}
 									else //finds no
 									{
 									ChatbotMain.chatbot.startChatting(); //be more sassy before you let user go
									//should it go to main or jessica?	
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
 					
 						
  						
  					}
				
				ChatbotMain.chatbot.startChatting(); 
  				}
				
  				
  				
	private boolean isInteger(String response) {

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
			
			ChatbotMain.print(jokesArr[0]);
			while(!gotCorrectJ)
			{
				
				response = ChatbotMain.getInput();
				
				if(ChatbotMain.findKeyword(response, "heat", 0) >= 0)
				{
					ChatbotMain.print("No! You're being too literal!");
				}
				if((ChatbotMain.findKeyword(response, "bees", 0) >= 0)||(ChatbotMain.findKeyword(response, "bee", 0) >= 0) )
				{
					ChatbotMain.print("You're getting close! Try again.");
				}
				
				if(testAnsTrue(response))
				{
					gotCorrectJ = true;
				}
				else
				{
					numChancesJ++;
					if(numChancesJ > 5 )
					{
					ChatbotMain.print(jokesAns[(int) (Math.random()*3)]);
					}
					else
					{
					ChatbotMain.print(upsetResArr[(int) (Math.random()*6)]);
					}
				}
				
				}
				
				
	}


	public void tellAGame(int response , int level) //currently stuck after you give an integer
	{
			int responseInt;
			responseInt = getInteger(response);
			gamesAns = (int) (Math.random()*(level*20)); //range increases
			while(!gotCorrectG) 
			{
				
				if(responseInt > gamesAns)
				{
					numChancesG++;
					ChatbotMain.print(gamesWrong[(int) (Math.random()*4)]); //first four
					gotCorrectG = false;
				}
				
				if(responseInt < gamesAns)
				{
					numChancesG++;
					ChatbotMain.print(gamesWrong[(int) (Math.random()*4)+4]); //last four
					gotCorrectG = false;
				}
				
				if(responseInt == gamesAns)
				{
					ChatbotMain.print("You did it! You answered within" + numChancesG + "tries!");
					gotCorrectG = true;
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
		
		if(response.indexOf("b") >= 0 || response.indexOf("B") >= 0)
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
  		

