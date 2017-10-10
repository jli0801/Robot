package chatbot;

import chatbot.ChatbotMain;
import chatbot.Topic;

public class ChatbotVickie implements Topic
{ //personal life

	private String[] keywords;
	private String[] negativeFeelings;
	private String[] positiveFeelings;
	
	private String[] annoyedComments; //can correspond with annoyed
	private String[] positiveComments;
	
	//private String[] positiveFeedback;
	//private String[] negativeFeedback;
	
	private String [] anythingElse;
	
	//private boolean concise;
	private boolean beginning;
	
	//private String[] concise;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String respond;
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
		String[] goodEmotions = {"happy", "great", "excited", "relaxed", "good", "fine", "wonderful", "terrific"};//find more synonyms
			positiveFeelings = goodEmotions;
			
		String[] negComments = {"JUST STATE WHAT YOU FEEL AND WHY YOU FEEL THAT WAY!!", "!!! STATE.YOUR.FEELING.AND.WHY.", "IN YOUR ANSWER INCLUDE YOUR FEELING AND WHY YOU FEEL THAT WAY! "};
			annoyedComments = negComments;
		String[] posComments = {"That's good ", "How wonderful ", "It's great ", "It makes me happy "};
			positiveComments = posComments;
			
		String [] more = {"What else do you want to mention?", "What else do you want to take off your chest?", "Tell me more about your feelings."};
			anythingElse = more;
			
		conciseResponse = 0;
		negEmotions = 0; 
		posEmotions = 0;
		
			
	
			
		//make string of everybody's array keywords so if triggered, it can do to their class
			
		//String[] shortResponsePlz = {"Sorry, can you shorten your response and identify the immediate problem? Being concise will also help in school and in communication", "Please 	
		goodbyeKeyword = "bye";
		secretKeyword = "family"; //death // died
		respond = ""; //s
		beginning = true;
	}

	public void talk(String response)
	{
		if(beginning == true)
		{	ChatbotMain.print("What about it? How do you feel about it? "); //What about it?? Can you elaborate more on your problem?
								//how do you feel about it and why do you feel this way?
			respond = ChatbotMain.getInput();
			conciseStr(respond);
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
		
		if(ChatbotMain.findKeyword(respond, goodbyeKeyword, 0) == 0) 
		{
			ChatbotMain.print("Well it was nice talking to you " + ChatbotMain.chatbot.getUsername() + "!");
			
			if(conciseResponse >= 3)
			{
				ChatbotMain.print("And btw, you really ought to work on your responses. Remember, being short and to the point is key to wonderful conversations! ");
			}
		}
		while(ChatbotMain.findKeyword(respond, goodbyeKeyword, 0) != -1 && beginning == false);
		{
			if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) // if the secret keyword is triggered
			{
				ChatbotMain.print("Sometimes family can be a pain, but communication is key to making it work out!"); // death 
				response = ChatbotMain.getInput();
				talk(respond);
			}
			else
			{
				emotionTriggers(respond);
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
					ChatbotMain.print( anythingElse[(int) Math.floor(Math.random() * 3)]);
					respond = ChatbotMain.getInput();
					conciseStr(respond);
					//reasonPos = response;
					//talk( respond);
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
							reasonBehindEmotion(response);
							if (negEmotions == 3)
							{
								ChatbotMain.print("I'm concerned " + ChatbotMain.chatbot.getUsername() + ". I am going to refer you to a therapist, since you are " + reasonNeg + " because " + reasonWhy + ".");
								//trigger function
							}else
							{
								
								System.out.println(negEmotions);
								ChatbotMain.print("Sorry to hear that you are " + negativeFeelings[n] + "!");
								ChatbotMain.print( anythingElse[(int) Math.floor(Math.random() * 3)]);
							//is there anything else you want to take off your chest? what else do you want to mention?
								respond = ChatbotMain.getInput();
							//reasonNeg = response;
							//System.out.println(negEmotions);
								conciseStr(respond);
								//talk(respond);
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
							reasonBehindEmotion(response);
							reasonNeg = "not" + positiveFeelings[i];
							if (negEmotions >= 3)
							{
								ChatbotMain.print("I'm concerned " + ChatbotMain.chatbot.getUsername() + ". I am going to refer you to a therapist, since you are " + reasonNeg + " because " + reasonWhy + ".");
								//trigger function..
							} else {
							
							ChatbotMain.print("Sorry to hear that you are not happy!");
							ChatbotMain.print( anythingElse[(int) Math.floor(Math.random() * 3)]);
							//is there anything else you want to take off your chest?
							respond = ChatbotMain.getInput();
							conciseStr(respond);
							//talk(respond);
							}
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
									ChatbotMain.print( anythingElse[(int) Math.floor(Math.random() * 3)]);
									//is there anything else you want to take off your chest?
									respond = ChatbotMain.getInput();
									conciseStr(respond);
									//reasonNeg = response;
							
									//talk(respond);}
								}
							}
						}
					}
				}
			}
			
		//add count everytime this is triggered
		//if it reaches a certain count, then it will get increasingly annoyed
			annoyed++;
			if (annoyed > 5)
			{
				ChatbotMain.print(annoyedComments[(int) Math.floor(Math.random() * 3)]);
			}else 
			{
			ChatbotMain.print("Sorry, I don't understand - can you rephrase it?");
			ChatbotMain.print("Say what you feel and why you feel that way.");// CHECK SPELLING!
			}
			respond = ChatbotMain.getInput();
			conciseStr(respond);
			}
			//talk(respond); //do i really need this?
	}
	
	public void conciseStr(String response)
	{	
		if (response.length() > 50)
		{
			conciseResponse++;
			ChatbotMain.print("Hold on, hold on, hold on. Your response is toooo long. You are going to have to be concise in college so why not start now? Please respond CONCISELY!");
			respond = ChatbotMain.getInput();
			talk(respond);
		}
			//keep track of how often they trigger this function;
		
	}
	
	public void reasonBehindEmotion(String response)
	{
		int bec = response.indexOf("because");
		
		if(bec == -1)
		{
			annoyed++;
			//print response
			if (annoyed > 5)
			{
				ChatbotMain.print(annoyedComments[(int) Math.floor(Math.random() * 3)]);
			}else
			{
			ChatbotMain.print("Why do u feel this way? What's your reason behind feeling this way?");
			}
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