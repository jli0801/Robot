package chatbot;

public class ChatbotVickie implements Topic{ //personal life


	private String[] keywords;
	private String[] negativeFeelings;
	private String[] positiveFeelings;
	private String[] negativeComments;
	private String[] positiveComments;
	private String[] positiveFeedback;
	private String[] negativeFeedback;
	
	//private String[] concise;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	public ChatbotVickie() {
		String[] temp = {"home", "life", "me", "bullying", "safety", "family", "stress"}; // worried?
			keywords = temp;
		String[] badEmotions = {"sad", "stressed", "tired", "frustrated"};
			negativeFeelings = badEmotions;
		String[] goodEmotions = {"happy", "great"};
			positiveFeelings = goodEmotions;
			
		//make string of everybody's array keywords so if triggered, it can do to their class
			
		//String[] shortResponsePlz = {"Sorry, can you shorten your response and identify the immediate problem? Being concise will also help in school and in communication", "Please 	
		goodbyeKeyword = "bye";
		secretKeyword = "family";
		response = "";
	}

	public void talk(String response) {
		ChatbotMain.print("Can you elaborate more on your problem? How do you feel about it? ");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) != -1);
		{
			if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0)
			{
				ChatbotMain.print("Sometimes family can be a pain, but communication is key to making it work out!");
			}
			else
			{
				// WRITE ALL CODE HERE!!! // maybe make concise function
				// find out what the emotion is in response : compare it to the pos||neg Array and reply apporopriately
				if(positiveemotion) // mayb use while?
				{
					ChatbotMain.print("That's good to hear!");
					response = ChatbotMain.getInput();
				}
				
				if (negemotion)
				{
					ChatbotMain.print("Sorry to hear that!");
					response = ChatbotMain.getInput();
				} else
				{
					ChatbotMain.print("What other words are synonymous to your emotion?");
					response = ChatbotMain.getInput();
				}
			}
		}
		ChatbotMain.print("Well it was nice talking to you" + ChatbotMain.chatbot.getUsername() + "!");
		//ChatbotMain.chatbot.getVickie().talk("");;
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