package chatbot;

public class ChatbotAreej implements Topic{
	private String[] keywords;
	//private String[] kwords;
	private String[] hc;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	//private String[] worryingFactors;
	private boolean advanced;
	private boolean discussedGrades;
	//private int worry;
	
	public ChatbotAreej() {
		String[] temp = {"grades", "gpa", "classes"};
		keywords = temp;
		String[] hardClasses = {"ap", "honors"};
		hc = hardClasses;
		
		goodbyeKeyword = "bye";
		secretKeyword = "program";
		response = "";
		//String[] worryingFactors = {"bad", "low", "wrong"};
		//kwords= worryingFactors;
		//worry = 0;
	}

	public void talk(String response) {
		ChatbotMain.print("Hm I see, what would you like to know? ");
		response = ChatbotMain.getInput();
	
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) != -1);
		{
			if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0)
			{
				ChatbotMain.print("Ah so you need a program change?");
				response = ChatbotMain.getInput();
				
				for(int i = 0; i < response.length()-3; i ++) {
					if(response.substring(i, i+3).equals("yes")) {
						ChatbotMain.print("Ok, would you like to change classes or the period you end?");
						response = ChatbotMain.getInput();
					}
					}
				ChatbotMain.print("So what do you need?");
				response = ChatbotMain.getInput();
				}
			}

				/*if (response.equals(kwords[0]) || response.equals(kwords[1]) || response.equals(kwords[2]))
				{
					ChatbotMain.print("oh no, what can i do to help?");
					response = ChatbotMain.getInput();
				}
				else
				{
					discussHonorsAsNeeded();
					//ChatbotMain.print("");
					response = ChatbotMain.getInput();
				} 
				*/
			

		
		ChatbotMain.print("Well it was nice talking to you, see you around " + ChatbotMain.chatbot.getUsername() + "!");
		//ChatbotMain.chatbot.getAreej().talk("");;
		ChatbotMain.chatbot.startChatting();
	}
	

	private void discussHonorsAsNeeded() {
		if(ChatbotMain.chatbot.getJi().hasDiscussedHonors()) {
			//credentials for honors
			//method for ji
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
//
}
	
	public boolean isAdvanced() {
		return advanced;
		
	}
	
	public boolean isDiscussed() {
		return discussedGrades;
	}
}
