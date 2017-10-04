package chatbot;

public class ChatbotJi implements Topic{
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String[] mild;
 	private String[] annoyed;
 	private int numAnnoyed = 5;
	//if numAnnoyed reaches 3, will turn to mild reaction 
	//else when reach to 1, will turn to annoyed reaction
	
	//link keyword such as grade/scores
	//
	
	public ChatbotJi() {
		String[] temp = {"college", "university", "school", "application"};
		String[] mild = {"I'm glad you asked me for help.", "Thanks for showing your interest.", "Your future is bright."};
 		String[] annoyed = {"If you aren't here for college help, might as well google it.", "I have other students who need help, come back when you have prepared reasonable questions.", "I don't have all day."};
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
				ChatbotMain.print("If you are lacking financially, applying for scholarships are very crucial in your application process!");
			}
			else
			{
				if (ChatbotMain.findKeyword(response, keywords[0], 0) >= 0) { //colleges
 					ChatbotMain.print("What specific aspect of college do you have a question about?");
 					
 				}
 				
 				if (ChatbotMain.findKeyword(response, keywords[3], 0) >= 0) { 
 					ChatbotMain.print("According to your scores, your eligibility is determined by the percentage your college accepts based on your score ranges.");
 				}
 				
 				if (ChatbotMain.findKeyword(response, keywords[6], 0) >= 0) { //assist with college app
 					ChatbotMain.print("What part of the college app do you need help with?");
 				} else {
	 				ChatbotMain.print("I'm not quite sure what you need help with. Would you mind rephrasing it?");
 				}
				response = ChatbotMain.getInput();
			}
		}
		ChatbotMain.print(ChatbotMain.chatbot.getUsername() + ", if you need more help about college, ask away!");
		//ChatbotMain.chatbot.getJi().talk("");;
		ChatbotMain.chatbot.startChatting();
	}
	
	//private void getBotReaction { //processes when a user repeats similar thing many times
		
	//}
	
	
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
