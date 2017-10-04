package chatbot;

public class ChatbotJi implements Topic{
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String[] calm;
	private String[] annoyed;
	private int numAnnoyed = 0;
	
	public ChatbotJi() {
		String[] temp = {"college", "university", "school", "reach", "safety", "match", "application"};
		String[] happy = {"I'm glad you asked me for help.", "Thanks for showing your interest.", "Your future is bright."};
		String[] annoyed = {"If you aren't here for college help, might as well google it.", "I have other students who need help, come back when you have prepared reasonable questions.", "I don't have all day."};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "scholarship";
		response = "";
	}
	

	public void talk(String response) {
		ChatbotMain.print("By any chance, are you interested in learning what colleges are available for you? If so, what?");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) != -1);
		{
			if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0)
			{
				ChatbotMain.print("If you are lacking financially, applying for scholarships are very crucial in your application process!");
			}
			else
			{
				if ((ChatbotMain.findKeyword(response, keywords[0], 0) >= 0) || (ChatbotMain.findKeyword(response, keywords[1], 0) >= 0) || (ChatbotMain.findKeyword(response, keywords[2], 0) >= 0)) { //colleges
					ChatbotMain.print("What specific aspect of college do you have a question about?");
					
				}
				
				if (ChatbotMain.findKeyword(response, keywords[3], 0) >= 0) { //based on user scores, can see how much can go for reach schools
					ChatbotMain.print("According to your scores, your eligibility is determined by the percentage your college accepts based on your score ranges.");
				}
				
				if (ChatbotMain.findKeyword(response, keywords[6], 0) >= 0) { //assist with college app
					ChatbotMain.print("What part of the college app do you need help with?");
				}
				
				
				
				ChatbotMain.print("Let me know any college related query.");
				response = ChatbotMain.getInput();
			}
			//reference to academic if find keywords
			//info on gpa/sat
			
			//annoyed if asks questions about keyword 5x
			//after 6x quits conversation
		}
		ChatbotMain.print( ChatbotMain.chatbot.getUsername() + ", if you need more help about college, ask away!");
		//ChatbotMain.chatbot.getJi().talk("");;
		ChatbotMain.chatbot.startChatting();
	}
	
	private void //helper method for annoyed/happy reactions
	
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
