package chatbot;

public class ChatbotJi implements Topic{
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	public ChatbotJi() {
		String[] temp = {"college", "university", "school", "program", "degree", "reach", "safety", "match", "income", "application"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "scholarship";
		response = "";
	}

	public void talk(String response) {
		ChatbotMain.print("By any chance, are you interested in learning what colleges are available for you?");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) != -1);
		{
			if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0)
			{
				ChatbotMain.print("I love corgris so much! So cool.");
			}
			else
			{
				
				ChatbotMain.print("That's cool but there are other cooler things");
				response = ChatbotMain.getInput();
			}
		}
		ChatbotMain.print("Well it was nice talking to you" + ChatbotMain.chatbot.getUsername() + "!");
		//ChatbotMain.chatbot.getJi().talk("");;
		ChatbotMain.chatbot.startChatting();
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
