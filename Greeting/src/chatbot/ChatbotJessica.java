 package chatbot;

public class ChatbotJessica implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response; 
	private String[]calmResArr;
	
	private String[] upsetResArr;
  	private String[] jokesArr;
  	private String[] jokesAns;
  	private String[] jokesWrong;
  	private String[] gamesArr; 
 	
 	private String[] gamesAns;
 	private String[] gamesWrong;
 	private String[] gamesRight;
 	private int numChances;
 	private int moodIncrease;
  	
  	public ChatbotJessica() {
 		String[] triggerM = {"joke", "game"};
 		
 		//in charge of entertainment
  		keywords = triggerM;
  		String[] calmRes = {"Please answer my question.", "I don't think you get this. "
 				,"I don't understand.", "Come on! Just answer me!"};
 			
  		calmResArr = calmRes;
  		String[] upsetRes = {"I can't understand you if you won't be specific. ", "Please explain further. "
  				,"I need more details. ", "Do you really understand? "};
  		upsetResArr = upsetRes;
 		//determines mood/emotion
  		String[] jokes = {"What makes oil boil?", ""};
  		jokesArr = jokes;
	
 		String[] answerJ = {"Get it? The letter B!", "It's a play on words!"
 				, "Well, technically a play on letters!"};	
  		jokesAns = answerJ;
 		goodbyeKeyword = "bye";
 		String[] games = {};
 		String[] answerWrongJ = {"Noo! Guess again.", "Are you even trying?", 
 				"Come on! What makes oil boil?", "The answer is one letter!!",
 				"The answer was B! Gosh, you're such a stick in the mud."};
 		jokesWrong = answerWrongJ;
 		//ended jokes now onto games
		String[] games1 = {"Let's play 20 questions! I'm thinking of something.. Guess it!"};
  		gamesArr = games1;
 		String[] answerG = {"Computer"};	
 		gamesAns = answerG;
 		String[] answerWrongG = {"Noo! Guess again.", "Are you even trying?", 
 				"You use it all the time!", "You've asked more than 20 questions now! The answer was computer!"};
 		gamesWrong = answerWrongG;
 		String[] answerRightG = {"Yes, you're getting closer.", "You're almost there!", 
 				"You've got " + numChances + " left.", "You did it! You answered within 20 questions!"};
 		gamesRight = answerRightG;
 		goodbyeKeyword = "bye";
 		secretKeyword = "funny";
  		response = "";
 		moodIncrease = 0;
 		numChances = 0;
  	}
  
  	
 		
  		
  		
  public void talk(String response) {
	  		ChatbotMain.print("Great! You came to the right place.");
			response = ChatbotMain.getInput();
			
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
 								
 								
 								if (i == 0 )
 								{
 									ChatbotMain.print(jokesArr[0]);
 									response = ChatbotMain.getInput();
 									
 									if(ChatbotMain.findKeyword(response, "heat", 0) >= 0)
 									{
 										ChatbotMain.print("No! You're being to literal!");
 									}
 									
 									if(ChatbotMain.findKeyword(response, "B", 0) >= 0)
 									{
 										ChatbotMain.print(jokesAns[(int) (Math.random()*4)]);
 									}
 									else
 									{
 										ChatbotMain.print(jokesWrong[(int) (Math.random()*4)]); //gradually gets worse 
 									}
 									
 									moodIncrease++;
 									if(moodIncrease > 20)
 									{
 										ChatbotMain.print(upsetResArr[(int) (Math.random()*4)]);
 									}
 									else
 									{
 										ChatbotMain.print(calmResArr[(int) (Math.random()*4)]);
 									}
 									
 								}
 								else
 								{
 									ChatbotMain.print(gamesArr[0]);
 									response = ChatbotMain.getInput();
 									
 								}
 								
 								
 							}
 						}
 					
 						
  						
  					}
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
  		

