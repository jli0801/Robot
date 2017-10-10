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
	
	private String reasonWhy;
	
	private int conciseResponse;
	private int negEmotions;
	private int posEmotions;
	private int annoyed;
	
	public ChatbotVickie() 
	{
		String[] trigger = {"home", "life", "me", "bullying", "safety", "family", "stress", "died", "death", "personal"}; // worried?
			keywords = trigger;
			
		String[] badEmotions = {"sad", "stressed", "tired", "frustrated", "exhausted", "horrible", "terrible", "bad", "scared", "terrified", "worried"};
			negativeFeelings = badEmotions;
		String[] goodEmotions = {"happy", "great", "excited", "relaxed","good"};//find more synonyms
			positiveFeelings = goodEmotions;
			
		String[] negComments = {"Come on, stop whining", "You're annoying, stop talking to me", "Sorry "};
			negativeComments = negComments;
		String[] posComments = {"That's good ", "How wonderful ", "It's great "};
			positiveComments = posComments;
			
		conciseResponse = 0;
		negEmotions = 0; //if more than 3, say ur worried and ask if they'd like to 
		posEmotions = 0;
		
			
	
			
		//make string of everybody's array keywords so if triggered, it can do to their class
			
		//String[] shortResponsePlz = {"Sorry, can you shorten your response and identify the immediate problem? Being concise will also help in school and in communication", "Please 	
		goodbyeKeyword = "bye";
		secretKeyword = "family"; //death // died
		response = ""; //s
		beginning = true;
	}

	public void talk(String response)
	{
		if(beginning == true)
		{	ChatbotMain.print("What about it? How do you feel about it? "); //What about it?? Can you elaborate more on your problem?
								//how do you feel about it and why do you feel this way?
			response = ChatbotMain.getInput();
			conciseStr(response);
			beginning = false;
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
				emotionTriggers(response);
			}
		}
	}
	
	public void emotionTriggers(String response)
	{
		int no = response.indexOf("no"); 
		System.out.println(no);
		if (no == -1)
		{
			for(int i = 0; i < positiveFeelings.length; i++)
			{
				if(ChatbotMain.findKeyword(response, positiveFeelings[i], 0) >= 0)
				{
					posEmotions++;
					reasonPos = positiveFeelings[1];
					if (posEmotions >= 3)
					{
						ChatbotMain.print("You don't seem to have many problems - let's talk about something else: grades, colleges, or maybe a joke? ");
						//trigger function
					}else
					{
					reasonBehindEmotion(response);
					ChatbotMain.print( positiveComments[(int) Math.floor(Math.random() * 3)] + "to hear that you are " + positiveFeelings[i] + "!");
					response = ChatbotMain.getInput();
					//reasonPos = response;
					talk( response);
					}
				}
				else
				{
					for(int n = 0; n < negativeFeelings.length; n++)
					{
						if(ChatbotMain.findKeyword(response, negativeFeelings[n], 0) >= 0)
						{
							negEmotions++;
							reasonNeg = negativeFeelings[n];
							if (negEmotions == 3)
							{
								ChatbotMain.print("I'm concerned " + ChatbotMain.chatbot.getUsername() + ". I am going to refer you to a therapist, since you are " + reasonNeg + " because " + reasonWhy + ".");
								//trigger function
							}else
							{
								reasonBehindEmotion(response);
								System.out.println(negEmotions);
								ChatbotMain.print("Sorry to hear that you are " + negativeFeelings[n] + "!");
							//is there anything else you want to take off your chest? what else do you want to mention?
								response = ChatbotMain.getInput();
							//reasonNeg = response;
							//System.out.println(negEmotions);
								talk( response);
							}
						}
					}
				}
			}
		}
			else
			{
				if (no >= 0) 
				{
					String newResponse = response.substring(no+1,response.length());
					for(int i = 0; i < positiveFeelings.length; i++) 
					{
						if (ChatbotMain.findKeyword(newResponse, positiveFeelings[i], 0) >= 0)
						{
							negEmotions++;
							reasonNeg = "not" + positiveFeelings[i];
							if (negEmotions >= 3)
							{
								ChatbotMain.print("I'm concerned " + ChatbotMain.chatbot.getUsername() + ". I am going to refer you to a therapist, since you are " + reasonNeg + " because " + reasonWhy + ".");
								//trigger function
							} else {
							reasonBehindEmotion(response);
							ChatbotMain.print("Sorry to hear that you are not happy!");
							//is there anything else you want to take off your chest?
							response = ChatbotMain.getInput();
							talk( response);}
						} else
						{
							for(int n = 0; n < negativeFeelings.length; n++)
							{
								if(ChatbotMain.findKeyword(newResponse, negativeFeelings[n], 0) >= 0)
								{
									posEmotions++;
									reasonPos = "not" + positiveFeelings[1];
									if (posEmotions >= 3)
									{
										ChatbotMain.print("You don't seem to have many problems because you are " + reasonPos + " - let's talk about something else: grades, colleges, or maybe a joke? ");
										//trigger function
									} else {
									reasonBehindEmotion(response);
									ChatbotMain.print("Good to hear that you are okay!");
									//is there anything else you want to take off your chest?
									response = ChatbotMain.getInput();
							
									//reasonNeg = response;
							
									talk( response);}
								}
							}
						}
					}
				}
			}
			
		//add count everytime this is triggered
		//if it reaches a certain count, then it will get increasingly annoyed
		annoyed++;
			ChatbotMain.print("Sorry, I don't understand - can you rephrase it?");// CHECK SPELLING!
			response = ChatbotMain.getInput();
			talk(response);
	}
	
	public void conciseStr(String response)
	{	
		if (response.length() > 50)
		{
			conciseResponse++;
			ChatbotMain.print("Hold on, hold on, hold on. Your response is toooo long. You are going to have to be concise in college so why not start now? Please respond CONCISELY!");
			response = ChatbotMain.getInput();
			talk(response);
		}
			//keep track of how often they trigger this function;
		
	}
	
	public void reasonBehindEmotion(String response)
	{
		int bec = response.indexOf("because");
		
		if(bec == -1)
		{
			//print response
			ChatbotMain.print("Why do u feel this way? What's your reason behind feeling this way?");
			 String reason = ChatbotMain.getInput();
			 emotionTriggers(reason);//fix
		}else
		{
			//reason
			int reasLength = response.length();
			
			if (response.substring(reasLength-1, reasLength).compareTo("a") < 0) //punctuation
			{
				 reasonWhy = response.substring(bec + 7, reasLength-1);
			}else
			{
				 reasonWhy = response.substring(bec + 7, reasLength);
				//String respond = ChatbotMain.getInput();
			}
		}
	}
	
	//public otherTopicTrigger()
	
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
}