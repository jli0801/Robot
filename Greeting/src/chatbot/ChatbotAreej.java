package chatbot;

public class ChatbotAreej implements Topic{
	private String[] keywords;
	private String[] kwords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String[] worryingFactors;
	private String[] worried;
	private int worry;
	
	public ChatbotAreej() {
		String[] temp = {"grades", "scores", "classes", "gpa", "program"};
		String[] worryingFactors = {"bad", "low", "wrong"};
		String[] worried = {"You may need some extra help", "Is there anything I can do?"};
		keywords = temp;
		kwords= worryingFactors;
		goodbyeKeyword = "bye";
		//secretKeyword = "program";
		response = "";
		worry = 0;
	}

	public void talk(String response) {
		ChatbotMain.print("Hm I see, what would you like to know? ");
		response = ChatbotMain.getInput();
	
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) != -1);
		{
				if (response.equals(kwords[0]) || response.equals(kwords[1]) || response.equals(kwords[2]))
				{
					ChatbotMain.print("oh no, what can i do to help?");
					response = ChatbotMain.getInput();
				}
				else
				{
					
					//ChatbotMain.print("");
					response = ChatbotMain.getInput();
				} 
				
		}
		
		ChatbotMain.print("Well it was nice talking to you, see you around " + ChatbotMain.chatbot.getUsername() + "!");
		//ChatbotMain.chatbot.getAreej().talk("");;
		ChatbotMain.chatbot.startChatting();
	}
	

	//reference to college here
	
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
