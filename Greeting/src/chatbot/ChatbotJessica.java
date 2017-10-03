package chatbot;

public class ChatbotJessica implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String[] calmResArr;
	private String[] upsetResArr;
	private String[] jokesArr;
	private String[] jokesAns;
	private String[] gamesArr; 
	
	public ChatbotJessica() {
		String[] triggerM = {"joke", "story", "game"};
		keywords = triggerM;
		String[] calmRes = {"Please answer my question.", "I don't think you get this. "
				,"I don't understand.", "I don't think I can help you with that."};
		calmResArr = calmRes;
		String[] upsetRes = {"I can't understand you if you won't be specific. ", "Please explain further. "
				,"I need more details. ", "Do you really understand? "};
		upsetResArr = upsetRes;
		String[] jokes = {"What makes oil boil?", ""};
		jokesArr = jokes;
		String[] answerJ = {"The letter B!", };		
		jokesAns = answerJ;
		goodbyeKeyword = "bye";
		String[] games = {};
		gamesArr = games;
		secretKeyword = "funny";
		response = "";
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
							
						}
						ChatbotMain.print("Yes of course. I'll tell you a " + keywords[i]+ ". ");
						
					}
				}

				response = ChatbotMain.getInput();
			}
		}
		
		//access variables from other classes
		ChatbotMain.print("Well, it was nice talking to you," +ChatbotMain.chatbot.getUsername() + ". Come by again!");
		
		ChatbotMain.chatbot.startChatting();
	}
	
	public String getJoke()
	{
		return jokesArr[]
	}

	public String getGame()
	{
		return gamesArr[]
	}

	public boolean isTriggered(String response) {
		
		for (int i = 0; i < keywords.length; i++)
		{
			//IMPORTANT (on the rubric)
			if (ChatbotMain.findKeyword(response, keywords[i], 0) >= 0)
			{
				return true;
			}
		}
		return false;
	}
	
	public String getKeyword(String response)
	{
		
	}

}

