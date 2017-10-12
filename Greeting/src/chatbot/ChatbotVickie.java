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

	private String [] anythingElse;
	
	private boolean beginning;
	
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
		String[] trigger = {"home", "life", "me", "bullying", "safety", "family", "stress", "died", "death", "personal"};
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
			
		//String[] shortResponsePlz = {"Sorry, can you shorten your response and identify the immediate problem? Being concise will also help in school and in communication", "Please 	
		goodbyeKeyword = "bye";
		secretKeyword = "family"; //death // died
		respond = ""; //s
		beginning = true;
	}

	public void talk(String response)
	{
		if(beginning == true)
		{	ChatbotMain.print("What personal things do you want to talk about? How do you feel about it? "); //What about it?? Can you elaborate more on your problem?
								//how do you feel about it and why do you feel this way?
			respond = ChatbotMain.getInput();
			conciseStr(respond);
			beginning = false;
		}
		
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
			if (ChatbotMain.findKeyword(respond, secretKeyword, 0) >= 0) // if the secret keyword is triggered
			{
				ChatbotMain.print("Sometimes family can be a pain, but communication is key to making it work out!"); // death 
				respond = ChatbotMain.getInput();
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
					reasonPos = positiveFeelings[i];
					reasonBehindEmotion(response);
					posEmotions++;
					
					if (posEmotions >= 3)
					{
						ChatbotMain.print("You don't seem to have many problems - let's talk about something else: grades, colleges, or maybe a joke? ");
						ChatbotMain.chatbot.startChatting();
					}
					else
					{
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
							reasonNeg = negativeFeelings[n];
							
							reasonBehindEmotion(response);
							negEmotions = negEmotions + 1;
							System.out.println(negEmotions);
								if (negEmotions == 3)
								{
									ChatbotMain.print("I'm concerned " + ChatbotMain.chatbot.getUsername() + ". I am going to refer you to a therapist, since you are " + reasonNeg + " because" + reasonWhy + ".");
								
									ChatbotMain.print("So lets talk about something else: Do you want to talk about your academics, colleges, or a joke?");
									//respond = ChatbotMain.getInput();
									ChatbotMain.chatbot.startChatting();//respond in parameter or even make my own function
								}
								else
								{
									ChatbotMain.print("Sorry to hear that you are " + negativeFeelings[n] + "!");
									ChatbotMain.print( anythingElse[(int) Math.floor(Math.random() * 3)]);
									//is there anything else you want to take off your chest? what else do you want to mention?
									respond = ChatbotMain.getInput();
									//reasonNeg = response;
									//System.out.println(negEmotions);
									if (respond.length() > 50)
									{
										conciseStr(respond);
									}
									else
									{
										talk(respond);
									}
								
								}
						}
					}
				}
			}
			
			annoyed++;
			if (annoyed > 5)
			{
				ChatbotMain.print(annoyedComments[(int) Math.floor(Math.random() * 3)]);
			}
			else 
			{
				ChatbotMain.print("Sorry, I don't understand. Please rephrase your response - what are you feeling and why do you feel this way?");
			}
			
			respond = ChatbotMain.getInput();
			talk(respond);
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
							
							reasonBehindEmotion(response);
							negEmotions++;
							reasonNeg = "not" + positiveFeelings[i];
							
							if (negEmotions == 3)
							{
								ChatbotMain.print("I'm concerned " + ChatbotMain.chatbot.getUsername() + ". I am going to refer you to a therapist, since you are " + reasonNeg + " because " + reasonWhy + ".");
								ChatbotMain.chatbot.startChatting();
							} 
							
							if (negEmotions<3)
							{
							
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
										ChatbotMain.chatbot.startChatting();
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
			 reasonBehindEmotion(reason);//fix
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
	
	public boolean isTriggered(String response) 
	{
		for(int i = 0; i < keywords.length; i++)
		{
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0)
			{
				return true;
			}
		}
		return false;

	}
}