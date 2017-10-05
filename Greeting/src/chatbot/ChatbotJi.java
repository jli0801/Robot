package chatbot;

public class ChatbotJi implements Topic{
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String[] happy;
	private String[] mild;
 	private String[] annoyed;
 	private int numAnnoyed = 5;
	//if numAnnoyed reaches 3, will turn to mild reaction 
	//else when reach to 1, will turn to annoyed reaction
	//store previous reponse and current
	
	//link keyword such as grade/scores
	//
	
	public ChatbotJi() {
		String[] temp = {"college", "university", "school", "application", "essay", "a", "b"}; //first three links to college chatbot
		String[] happy = {"I'm glad you asked me for help.", "Thanks for showing your interest.", "Your future is bright."};
 		String[] mild = {"Be more specific.", "Something else you want to say?", "I think we have gone over that. Let's talk about something else."};
		String[] annoyed = {"If you aren't here for college help, might as well google it.", "I have other students who need help, come back when you have prepared reasonable questions.", "I don't have all day."};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "scholarship";
		response = "";
	}

	public void talk(String response) {
		ChatbotMain.print("By any chance, are you interested in applying for college? If so, what?");
		response = ChatbotMain.getInput();
		
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) != -1);
		{
			if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0)
			{
				ChatbotMain.print("If you are lacking financially, applying for scholarships are very crucial in your application process!");
				//mention income, grades
			}
			else
			{
				if (ChatbotMain.findKeyword(response, keywords[4], 0) >= 0) { //colleges
 					ChatbotMain.print("Would you like to have advice on writing your essay?");
					if(ChatbotMain.findKeyword(response, "yes", 0) >= 0) {
						ChatbotMain.print("Great! What are you struggling with?"); 
						//
					} else {
						if(ChatbotMain.findKeyword(response, "no", 0) >= 0) {
							ChatbotMain.print("Well.. if you need help, you can always me.");
						}
					}
 				} else if (ChatbotMain.findKeyword(response, keywords[6], 0) >= 0) { //link scores/gpa
 					ChatbotMain.print("According to your scores, your eligibility is determined by the percentage your college accepts based on your score ranges.");
					//essay
					//extracurriculars
 				} else if (ChatbotMain.findKeyword(response, keywords[3], 0) >= 0) { //assist with college app
 					ChatbotMain.print("What part of the college app do you need help with?");
					
 				} else {
	 				ChatbotMain.print("I'm not quite sure what you need help with. Would you mind rephrasing your question?");
 				}
				
				response = ChatbotMain.getInput();
			}
		}
		ChatbotMain.print(ChatbotMain.chatbot.getUsername() + ", if you need more help about college, ask away!");
		//ChatbotMain.chatbot.getJi().talk("");;
		ChatbotMain.chatbot.startChatting();
	}
	
	//private void getBotReaction { //processes when a user repeats similar thing many times
	//	if (numAnnoyed > 1 && < 4) { //mild
			//generate random mild response
	//	}
	
	//	if (numAnnoyed <= 1) { //annoyed
			//generate random annoyed response
	//	}
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
