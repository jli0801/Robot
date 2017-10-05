 package chatbot;

public class ChatbotJessica implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response; 
	//private String[]calmResArr;
	
	private String[] upsetResArr;
  	private String[] jokesArr;
  	private String[] jokesAns;
  	private String[] jokesWrong;
  	private String[] gamesArr; 
 	
 	int gamesAns;
 	private String[] gamesWrong;
 	private String[] gamesRight;
 	private int numChances;
 	private int moodIncrease;
 	
 	private boolean gotCorrectJ;
 	private boolean gotCorrectG;
  	
  	public ChatbotJessica() {
 		String[] triggerM = {"joke", "game"};
 		
 		//in charge of entertainment
  		keywords = triggerM;
  	/*	String[] calmRes = {"Please answer my question.", "I don't think you get this. "
 				,"I don't understand.", "Come on! Just answer me!"};
 			
  		calmResArr = calmRes;*/
  		String[] upsetRes = {"I can't understand you if you won't be specific. ", "Please explain further. "
  				,"I need more details. ", "Do you really understand? ", "Please answer my question.", "I don't think you get this. "
 				,"I don't understand.", "Come on! Just answer me!"};
  		upsetResArr = upsetRes;
 		//determines mood/emotion
  		String[] jokes = {"What makes oil boil?", ""};
  		jokesArr = jokes;
	
 		String[] answerJ = {"Get it? The letter B!", "It's a play on words!"
 				, "Well, technically a play on letters!"};	
  		jokesAns = answerJ;
 		goodbyeKeyword = "bye";
 		
 		String[] answerWrongJ = {"Noo! Guess again.", "Are you even trying?", 
 				"Come on! What makes oil boil?", "The answer is one letter!!",
 				"The answer was B! Gosh, you're such a stick in the mud."};
 		jokesWrong = answerWrongJ;
 		//ended jokes now onto games
		String[] games1 = {"Let's play, GUESS THAT NUMBER!"}; //thinking of a number from 1 to 100. guess it to win~
  		gamesArr = games1;
 		gamesAns =(int) (Math.random()*100);
 		
 		String[] answerWrongG = {"Noo!", "Are you even trying?", 
 				"You use it all the time!", "You've asked more than 20 questions now! The answer was computer!"};
 		gamesWrong = answerWrongG;
 		String[] answerRightG = {"Yes, you're getting closer.", "You're almost there!", 
 				"You did it! You answered within" + numChances + "questions!"};
 		gamesRight = answerRightG;
 		goodbyeKeyword = "bye";
 		secretKeyword = "funny";
  		response = "";
 		moodIncrease = 0;
 		numChances = 0;
 		gotCorrectJ = false;
  	}
  
  	
 		//are you with ?
  		//is with ?
  		
  public void talk(String response) {
	  		
			
				while (ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1)
				{
					if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0)
					{
						ChatbotMain.print("I'm glad you find me funny! Would you like to here another joke?");
		
						response = ChatbotMain.getInput();
					}
					else
  				{
  				
 						
 						for (int i = 0; i < keywords.length; i++)
  						{
 							
 							if (ChatbotMain.findKeyword(response, keywords[i], 0) >= 0 )
 							{
 								ChatbotMain.print("Yes of course. I'll tell you a " + keywords[i]+ ". ");
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
 								else //use same method for JOKE 
 								{
 									ChatbotMain.print("Oh, I heard the word game! Would you like to play with me?" );
 									response = ChatbotMain.getInput();
 									if (ChatbotMain.findKeyword(response, "yes", 0) >= 0) //check
 									{
 									ChatbotMain.print(gamesArr[0]);
 									}
 									else
 									{
 									ChatbotMain.chatbot.startChatting(); //be more sassy before you let user go	
 									}
 								}
 								
 								
 							}
 						}
 					
 						
  						
  					}
  				}
				
  				
  				
public void tellAJoke (String response)
{
		boolean continueJoke;
		continueJoke = false;
		ChatbotMain.print(jokesArr[0]);
		while(!gotCorrectJ)
		{
			
			response = ChatbotMain.getInput();
			
			if(ChatbotMain.findKeyword(response, "heat", 0) >= 0)
			{
				ChatbotMain.print("No! You're being too literal!");
			}
			if(ChatbotMain.findKeyword(response, "bees", 0) >= 0)
			{
				ChatbotMain.print("You're getting close! Try again.");
			}
			
			if(testAnsTrue(response))
			{
				gotCorrectJ = true;
			}
			else
			{
				numChances++;
				if(numChances > 5 )
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
		
	//	ChatbotMain.print(jokesWrong[(int) (Math.random()*3)]); //gradually gets worse 
	/*	moodIncrease++;
		if(moodIncrease > 20)
		{
			ChatbotMain.print(upsetResArr[(int) (Math.random()*3)]);
		}
		else
		{
			ChatbotMain.print(calmResArr[(int) (Math.random()*3)]);
		}*/

 
  
	public void continueJokeConvo()
	{
		ChatbotMain.print(jokesAns[(int) (Math.random()*3)]);
		response = ChatbotMain.getInput();
	}
	
	public boolean testAnsTrue(String response)
	{
		//for(int i = 0; i < response.length(); i++)
	//	{
		if(ChatbotMain.findKeyword(response, " b", 0) >= 0 )
		{
			return true;
		}
		
	//	}
		return false;
	}
	/*moodIncrease++;
		if(moodIncrease > 20)
		{
			ChatbotMain.print(upsetResArr[(int) (Math.random()*3)]);
		}
		else
		{
			ChatbotMain.print(calmResArr[(int) (Math.random()*3)]);
		}*/
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
  		

