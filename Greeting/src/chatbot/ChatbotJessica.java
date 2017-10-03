package chatbot;

public class ChatbotJessica implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String[] calmRes;
	private String[] upsetRes;
	
	
	public ChatbotJessica() {
		String[] triggerM = {"joke", "fun", "", "", "game"};
		keywords = triggerM;
		String[] calmRes = {"Please answer my question.", "I don't think you get this. "
				,"I don't understand.", "I don't think I can help you with that."};
		String[] upsetRes = {"I can't understand you if you won't be specific. ", "Please explain further. "
				,"I need more details. ", "Do you really understand? "};
		
		
		goodbyeKeyword = "bye";
		secretKeyword = "funny";
		response = "";
	}

	
	public void talk(String response) {
		
		ChatbotMain.print("");
		response = ChatbotMain.getInput();
		while (ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1)
		{
			if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0)
			{
				ChatbotMain.print("I'm glad you find ");
				response = ChatbotMain.getInput();
			}else
			{
				ChatbotMain.print("");
				response = ChatbotMain.getInput();
			}
		}
		
		//access variables from other classes
		ChatbotMain.print("Well, it was nice talking to you," +ChatbotMain.chatbot.getUsername() + ". Come by again!");
		
		ChatbotMain.chatbot.startChatting();
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

}

