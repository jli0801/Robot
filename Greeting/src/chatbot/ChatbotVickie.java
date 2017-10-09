package chatbot;

import chatbot.ChatbotMain;
import chatbot.Topic;

public class ChatbotVickie implements Topic
{ //personal life

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
	private String reasonPos;
	private String reasonNeg;
	
	private int conciseResponse;
	//private int negEmotions;
	//private int posEmotions;
	
	public ChatbotVickie() 
	{
		String[] temp = {"home", "life", "me", "bullying", "safety", "family", "stress", "died", "death", "personal"}; // worried?
			keywords = temp;
			
		String[] badEmotions = {"sad", "stressed", "tired", "frustrated", "exhausted", "horrible", "terrible"};
			negativeFeelings = badEmotions;
		String[] goodEmotions = {"happy", "great", "excited", "relaxed","good"};
			positiveFeelings = goodEmotions;
			
		String[] negComments = {"Come on, stop whining", "You're annoying, stop talking to me", "Sorry "};
			negativeComments = negComments;
		String[] posComments = {"That's good ", "How wonderful ", "It's great "};
			positiveComments = posComments;
			
		conciseResponse = 0;
		//negEmotions = 0; if more than 3, say ur worried and ask if they'd like to 
		//posEmtions = 0;
		
			
	
			
		//make string of everybody's array keywords so if triggered, it can do to their class
			
		//String[] shortResponsePlz = {"Sorry, can you shorten your response and identify the immediate problem? Being concise will also help in school and in communication", "Please 	
		goodbyeKeyword = "bye";
		secretKeyword = "family"; //death // died
		response = ""; //s
		beginning = true;
	}

	public void talk(String response)
	{//call this function beginning?
		if(beginning == true)
		{	ChatbotMain.print("What about it? How do you feel about it? "); //What about it?? Can you elaborate more on your problem?
								//how do you feel about it and why do you feel this way?
			response = ChatbotMain.getInput();
			beginning = false;
		}
		if (response.length() > 50)
		{
			conciseStr();
			//concise = true;
		}


	/* maybe make new function where if the number of emotions are triggered (possibly 3-5 times) in the last response, if there is a because, 
	 * determine whether there is a period, and then take the reason of sad emotion and say "since you are (negemotion) because of (reason) I will 
	 * recommend you to see a therapist"
	 * 
	 * And, b4 all this, you can ask "are you (negEmotion) bc of (reason)?
	 * 
	 * 
	 * For posEmtion, ask "Since it seems you dont have many problems, do you want to talk about (other three topics)
	 * and if yes, show options again and let it trigger
	 * 
	 * 
	 * reasons will only get response if there is a because
	 * 
	 * if because is not found, print why are you "neg/pos emotion)?
	*/	
		
		if(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == 0) 
		{
			ChatbotMain.print("Well it was nice talking to you " + ChatbotMain.chatbot.getUsername() + "!");
			
			if(conciseResponse >= 3)
			{
				ChatbotMain.print("And btw, you really ought to work on your responses. Remember, being short and to the point is key to wonderful conversations! ");
			}
		}
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) != -1 && beginning == false);
		{
			if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) // if the secret keyword is triggered
			{
				ChatbotMain.print("Sometimes family can be a pain, but communication is key to making it work out!"); // death 
				response = ChatbotMain.getInput();
				talk(response);
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
				
				emotionTriggers(response);
			}
		}
		
		//ChatbotMain.chatbot.getVickie().talk("");;
		//ChatbotMain.chatbot.startChatting();
	}
	
	public void emotionTriggers(String response)
	{
		for(int i = 0; i < positiveFeelings.length; i++)
		{
			if(ChatbotMain.findKeyword(response, positiveFeelings[i], 0) >= 0)
			{//because function here? determine if there is a because: maybe bolean helper method
				ChatbotMain.print( positiveComments[(int) Math.floor(Math.random() * 3)] + "to hear that you are " + positiveFeelings[i] + "!");
				response = ChatbotMain.getInput();
				
				reasonPos = response;
				
				talk( response);
			} else
			{
				for(int n = 0; n < negativeFeelings.length; n++)
				{
					if(ChatbotMain.findKeyword(response, negativeFeelings[n], 0) >= 0)
					{
						ChatbotMain.print("Sorry to hear that you are " + negativeFeelings[n] + "!");
						//is there anything else you want to take off your chest?
						response = ChatbotMain.getInput();
						
						reasonNeg = response;
						
						talk( response);
					}
				}
			}
			
		}
		//return false;
		ChatbotMain.print("Sorry, I don't understand - can you rephrase it?");
		response = ChatbotMain.getInput();
		talk(response);
	}
	public boolean isTriggered(String response) 
	{
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
	public void conciseStr()
	{
			conciseResponse++;
			ChatbotMain.print("Hold on, hold on, hold on. Your response is toooo long. You are going to have to be concise in college so why not start now? Please respond CONCISELY!");
			response = ChatbotMain.getInput();
			talk(response);
			
			//keep track of how often they trigger this function;
		
	}
}