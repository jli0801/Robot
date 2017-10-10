package chatbot;

public class ChatbotJi implements Topic{
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	//private String[] happy;
	private String[] mild;
 	private String[] annoyed;
 	private boolean discussedHonors;
 	private int numAnnoyed = 5;
	//if numAnnoyed reaches 3, will turn to mild reaction 
	//else when reach to 1, will turn to annoyed reaction
	
	private String[] negWords;

	public ChatbotJi() {
		String[] temp = {"college", "university", "school", "scores", "essay"}; //first three links to college chatbot
		String[] negWords = {"stop", "bad", "unhelpful"};
		//String[] happy = {"I'm glad you asked me for help.", "Thanks for showing your interest.", "Your future is bright.", "No problem."};
 		String[] mild = {"Be more specific.", "Something else you want to say?", "I think we have gone over that. Let's talk about something else."};
		String[] annoyed = {"If you aren't here for college help, might as well google it.", "I have other students who need help, come back when you have prepared reasonable questions.", "I don't have all day."};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "scholarship";
		response = "";
	}

	public void talk(String response) {
		ChatbotMain.print("By any chance, are you interested in applying for college? If so, what step in the application do you want help with?");
		response = ChatbotMain.getInput();
		
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) != -1);
		{
			if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0)
			{
				findNegWords();
				ChatbotMain.print("If you are lacking financially, applying for scholarships are very crucial in your application process!!!");
				response = ChatbotMain.getInput();
				findNegWords();
				if(ChatbotMain.findKeyword(response, "yes", 0) >= 0) {
					response = ChatbotMain.getInput();
					ChatbotMain.print("Research your college and see what requirements are needed to be eligible.");
					//cont
				}
				
				if(ChatbotMain.findKeyword(response, "no", 0) >= 0) {
					findNegWords();
					ChatbotMain.print("Let me know if you need anything else.");
					//cont
				}

			}
			else
			{
				if (ChatbotMain.findKeyword(response, keywords[4], 0) >= 0) { //colleges
					findNegWords();
 					ChatbotMain.print("Would you like to have advice on writing your essay?");
 					response = ChatbotMain.getInput();
					findNegWords();
					if(ChatbotMain.findKeyword(response, "yes", 0) >= 0) {
						findNegWords();
						ChatbotMain.print("Great! What are you struggling with?"); 
						response = ChatbotMain.getInput();
						findNegWords();
						if(ChatbotMain.findKeyword(response, "topic", 0) >= 0) {
							findNegWords();
							ChatbotMain.print("Think about moments that impacted your personality or characteristic you highly value. If you are still stuck, try looking at the essay prompts. Hopefully an idea will spark!");
							if(ChatbotMain.findKeyword(response, "thanks", 0) >= 0) {
								findNegWords();
								ChatbotMain.print("No problem.");
							}
						}		
					} else if (ChatbotMain.findKeyword(response, "no", 0) >= 0) {
							findNegWords();
							ChatbotMain.print("Well.. if you need help, you can always contact me.");
							//continue chat
				} else if (ChatbotMain.findKeyword(response, keywords[3], 0) >= 0) {
					findNegWords();
					ChatbotMain.print("What kind of scores are you looking to have help with?");
					response = ChatbotMain.getInput();
					findNegWords();
					
					if((ChatbotMain.findKeyword(response, "gpa", 0) >= 0) || (ChatbotMain.findKeyword(response, "grades", 0) >= 0)) {
						//link
					}
						
				} else {
				 	ChatbotMain.print("I'm not quite sure what you need help with. Would you mind rephrasing your question?");
				 	//continue chat	
 				}
				
				response = ChatbotMain.getInput();
				}
			}
		}
		ChatbotMain.print(ChatbotMain.chatbot.getUsername() + ", if you need more help about college, ask away!");
		//ChatbotMain.chatbot.getJi().talk("");;
		ChatbotMain.chatbot.startChatting();
	}
	
	private void getBotReaction() {
		if (numAnnoyed > 1 && < 4) { //mild
			ChatbotMain.print(mild[(int) Math.floor(Math.random()* 4)]);
		}
	
		if (numAnnoyed <= 1) { //annoyed
			ChatbotMain.print(annoyed[(int) Math.floor(Math.random()* 3)]);
		}
		
		//if -1 end
	}
	
	private void findNegWords() {
		if (response.contains(negWord[0]) {
			numAnnoyed--;
			
		} else if (response.contains(negWord[1]) {
			numAnnoyed--;
			
		} else if (response.contains(negWord[2]) {
			numAnnoyed--;
		}
		getBotReaction();
	}
	
	//private void generateHappy {
		
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
