package chatbot;

public class ChatbotJessica implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	
	public ChatbotJessica() {
		String[] temp = {"joke", "dumb", "smart", "life", "childhood"};
		keywords = temp;
		
		goodbyeKeyword = "bye";
		secretKeyword = "family";
		response = "";
	}

	
	public void talk(String response) {
		
		ChatbotMain.print("Hey! So you want to talk about generic boring things, huh? I love talking about that. So tell me something");
		response = ChatbotMain.getInput();
		while (ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1)
		{
			if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0)
			{
				ChatbotMain.print("");
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

