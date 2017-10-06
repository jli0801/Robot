package chatbot;

public class ChatbotVickie implements Topic{ //personal life


	private String[] keywords;
	private String[] negativeFeelings;
	private String[] positiveFeelings;
	
	private String[] negativeComments;
	private String[] positiveComments;
	
	private String[] positiveFeedback;
	private String[] negativeFeedback;
	
	//private boolean concise;
	private boolean beginning;
	
	//private String[] concise;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	public ChatbotVickie() {
		String[] temp = {"home", "life", "me", "bullying", "safety", "family", "stress", "died", "death", "personal"}; // worried?
			keywords = temp;
			
		String[] badEmotions = {"sad", "stressed", "tired", "frustrated"};
			negativeFeelings = badEmotions;
		String[] goodEmotions = {"happy", "great", "excited", "relaxed"};
			positiveFeelings = goodEmotions;
			
		String[] negComments = {"Come on, stop whining", "You're annoying, stop talking to me"};
			negativeComments = negComments;
		String[] posComments = {""};
			positiveComments = posComments;
			
		//make string of everybody's array keywords so if triggered, it can do to their class
			
		//String[] shortResponsePlz = {"Sorry, can you shorten your response and identify the immediate problem? Being concise will also help in school and in communication", "Please 	
		goodbyeKeyword = "bye";
		secretKeyword = "family"; //death // died
		response = "";
	}

	public void talk(String response) {
		ChatbotMain.print("What about it? How do you feel about it? "); //What about it?? Can you elaborate more on your problem?
		response = ChatbotMain.getInput();
		
		beginning = true;
		
		if (response.length() > 40)
		{
			conciseStr();
			//concise = true;
		}
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) != -1 && beginning == false);
		{
			if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) // if the secret keyword is triggered
			{
				ChatbotMain.print("Sometimes family can be a pain, but communication is key to making it work out!"); // death 
			}
			else
			{
				// WRITE ALL CODE HERE!!! // maybe make concise function
				// find out what the emotion is in response : compare it to the pos||neg Array and reply apporopriately
				/*if(positiveemotion) // mayb use while?
				{
					ChatbotMain.print("That's good to hear!");
					response = ChatbotMain.getInput();
				}*/
								
				/*if (negemotion)
				{
					ChatbotMain.print("Sorry to hear that!");
					response = ChatbotMain.getInput();
				} else
				{
					ChatbotMain.print("What other words are synonymous to your emotion?");
					response = ChatbotMain.getInput();
				}*/////
			}
		}
		ChatbotMain.print("Well it was nice talking to you " + ChatbotMain.chatbot.getUsername() + "!");
		//ChatbotMain.chatbot.getVickie().talk("");;
		//ChatbotMain.chatbot.startChatting();
	}
	
	public void emotionTriggers(String response)
	{
		for(int i = 0; i < positiveFeelings.length; i++)
		{
			//IMPORTANT (one the rubric) only if keyword is used
			if(ChatbotMain.findKeyword(response, positiveFeelings[i], 0) >= 0)
			{
				ChatbotMain.print("That's good to hear!");
				response = ChatbotMain.getInput();
			} else
			{
				//
			}
		}
		//return false;
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
	public void conciseStr(){
		
			ChatbotMain.print("Hold on, hold on, hold on. Your response is toooo long. You are going to have to be concise in college so why not start now? Please respond CONCISELY!");
			response = ChatbotMain.getInput();
			beginning = false;
			
			//keep track of how often they trigger this function
		
	}
}