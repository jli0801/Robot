package chatbot;

public class ChatbotVickie implements Topic //personal life
{
	
	private String[] keywords;
	private String[] negativeFeelings;
	private String[] positiveFeelings;
	
	private String[] annoyedComments;
	private String[] positiveComments;

	private String [] anythingElse;
	private String [] reasonQuestions;
	
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
	private int negate;
	
	public ChatbotVickie() 
	{
		String[] trigger = {"home", "life", "me", "bullying", "safety", "family", "stress", "died", "death", "personal"};
			keywords = trigger;
			
		String[] badEmotions = {"sad", "stressed", "tired", "frustrated", "exhausted", "horrible", "terrible", "bad", "scared", "terrified","mad", "worried"};
			negativeFeelings = badEmotions;
		String[] goodEmotions = {"happy", "great", "excited", "relaxed", "good", "fine", "wonderful", "terrific", "nice", "amazing", "awesome"};//find more synonyms
			positiveFeelings = goodEmotions;
			
		String[] negComments = {"JUST STATE WHAT YOU FEEL AND WHY YOU FEEL THAT WAY!!", "!!! STATE.YOUR.FEELING.AND.WHY.", "IN YOUR ANSWER INCLUDE YOUR FEELING AND WHY YOU FEEL THAT WAY! "};
			annoyedComments = negComments;
		String[] posComments = {"That's good ", "How wonderful ", "It's great ", "It makes me happy "};
			positiveComments = posComments;
			
		String [] more = {"What else do you want to mention?", "What else do you want to take off your chest?", "Tell me more about your feelings."};
			anythingElse = more;
		
		String [] curious = {"Why do u feel this way?", "What's your reason behind feeling this way?"};
			reasonQuestions = curious;
			
		conciseResponse = 0;
		negEmotions = 0; 
		posEmotions = 0;
			
		goodbyeKeyword = "bye";
		secretKeyword = "died"; 
		respond = ""; 
		beginning = true;
	}

	public void talk(String response)
	{
		if(beginning == true)
		{	
			ChatbotMain.print("What personal things do you want to talk about? How do you feel about it? "); 
			beginning = false;
			respond = ChatbotMain.getInput();
			conciseStr(respond);
		}
		
		if(ChatbotMain.findKeyword(respond, goodbyeKeyword, 0) == 0) //if 'bye' is used in respond
		{
			ChatbotMain.print("Well it was nice talking to you " + ChatbotMain.chatbot.getUsername() + "!");
			
			if(conciseResponse >= 3)
			{
				ChatbotMain.print("And btw, you really ought to work on your responses. Remember, being short and to the point is key to wonderful conversations! ");
			}
			//End of Program
		}
		while(ChatbotMain.findKeyword(respond, goodbyeKeyword, 0) != -1 && beginning == false);
		{
			if (ChatbotMain.findKeyword(respond, secretKeyword, 0) >= 0)
			{
				ChatbotMain.print("My condolences. Dealing with the death of someone close to you can be tough, but remember you have many friends you can rely on. How are you feeling?"); // death Sometimes family can be a pain, but communication is key to making it work out!
				respond = ChatbotMain.getInput();
				conciseStr(respond);			//Line 249
			}
			else
			{
					emotionTriggers(respond); //Line 98
			}
		}
	}
	
	public void emotionTriggers(String response)//figures out which emotion a user is typing in
	{
		negate = response.indexOf("not"); // tries to find "not"
		
		if (negate == -1) //if there is no "not" e.g. "good", "fine", "sad", "mad", find out if the emotion is positive or negative
		{
			noNegateEmotion(response); //Line 112
		}
		else
		{	//Line 179
			negateEmotion(response); //if there is a "not" e.g. "not good", "not fine", "not sad", "not mad", find out if the emotion is positive or negative
		}
	}
	
	public void noNegateEmotion(String response) // there's no "not"
	{
		for(int i = 0; i < positiveFeelings.length; i++) // search through positive array
		{
			if(ChatbotMain.findKeyword(response, positiveFeelings[i], 0) >= 0) // if there's a hit
			{
				reasonPos = positiveFeelings[i]; //the emotion is stored
				reasonBehindEmotion(response); //Line 273
				posEmotions++; //counter keeps track of user's emotions
				
				if (posEmotions == 3)
				{
					ChatbotMain.print("You don't seem to have many problems - let's talk about something else. ");
					beginning(); 
					ChatbotMain.chatbot.omgTriggers();//Call the other classes
				}
				else
				{
					ChatbotMain.print( positiveComments[(int) Math.floor(Math.random() * 3)] + "to hear that you are " + positiveFeelings[i] + "!");
					ChatbotMain.print( anythingElse[(int) Math.floor(Math.random() * 3)]);
					respond = ChatbotMain.getInput();
					conciseStr(respond);			//Line 249
				}
			}
			else
			{
				for(int n = 0; n < negativeFeelings.length; n++) //search through negative array
				{
					if(ChatbotMain.findKeyword(response, negativeFeelings[n], 0) >= 0)//if theres a hit
					{
						reasonNeg = negativeFeelings[n]; //stores negative Emotion
						
						reasonBehindEmotion(response); //Line 273
						negEmotions = negEmotions + 1; //counter keeps track
				
						if (negEmotions == 3)
						{
							ChatbotMain.print("I'm concerned " + ChatbotMain.chatbot.getUsername() + ". I am going to refer you to a therapist, since you are " + reasonNeg + " because" + reasonWhy + ". They can help you better than I can. So lets talk about something else.");
							beginning(); // Line 264
							ChatbotMain.chatbot.omgTriggers(); //Call the other classes
						}
						else
						{
							ChatbotMain.print("Sorry to hear that you are " + negativeFeelings[n] + "!"); //uses the stored info
							ChatbotMain.print( anythingElse[(int) Math.floor(Math.random() * 3)]);
							respond = ChatbotMain.getInput();
							conciseStr(respond); //Line 249
						}
					}
				}
			}
		}
		//if there's no hit in either arrays
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
		conciseStr(respond);		//Line 249
	}
	
	public void negateEmotion(String response)//theres a "not" in the response
	{
		String newResponse = response.substring(negate+1,response.length()); //after a "not" comes the emotions so we are just using the words after "not"
		
		for(int i = 0; i < positiveFeelings.length; i++) //searches through positive array
		{
			if (ChatbotMain.findKeyword(newResponse, positiveFeelings[i], 0) >= 0)//if there is a hit
			{
				reasonNeg = "not " + positiveFeelings[i]; //emotion is stored
				reasonBehindEmotion(response); //Line 273
				negEmotions++; //keep track of negative Emotions
				
				if (negEmotions == 3)
				{
					ChatbotMain.print("I'm concerned " + ChatbotMain.chatbot.getUsername() + ". I am going to refer you to a therapist, since you are " + reasonNeg + " because" + reasonWhy + ". They can help you better than I can. So lets talk about something else.");
					beginning(); // Line 264
					ChatbotMain.chatbot.omgTriggers(); //Call the other classes
				} 
				else
				{	
					ChatbotMain.print("Sorry to hear that you are not " + positiveFeelings[i] + "!");
					ChatbotMain.print( anythingElse[(int) Math.floor(Math.random() * 3)]);	
					//is there anything else you want to take off your chest?
					respond = ChatbotMain.getInput();
					conciseStr(respond);//Line 249
				}
			} 
			else
			{
				for(int n = 0; n < negativeFeelings.length; n++)//searches through negative array
				{
					if(ChatbotMain.findKeyword(newResponse, negativeFeelings[n], 0) >= 0)//if theres a hit
					{
						posEmotions++;//keep track of positive emotions
						reasonBehindEmotion(response);//Line 273
						reasonPos = "not " + negativeFeelings[n];//stores info
						
						if (posEmotions == 3)
						{
							ChatbotMain.print("You don't seem to have many problems because you are " + reasonPos + ". Let's talk about something else."); // uses the stored info
							beginning(); // Line 264
							ChatbotMain.chatbot.omgTriggers(); //Call the other classes
						} 
						else 
						{
							ChatbotMain.print("Good to hear that you are not " + negativeFeelings[n] + "!"); //uses the stored info
							ChatbotMain.print( anythingElse[(int) Math.floor(Math.random() * 3)]);
							//is there anything else you want to take off your chest?
							respond = ChatbotMain.getInput();
							conciseStr(respond);	//Line 249						
						}
					}
				}
			}
		}
		//if theres no hit in either array
		annoyed++;
		if (annoyed > 5)
		{
			ChatbotMain.print(annoyedComments[(int) Math.floor(Math.random() * 3)]);
		}
		else 
		{
			ChatbotMain.print("Sorry, I don't understand - can you rephrase it?");
			ChatbotMain.print("Say what you feel and why you feel that way.");// CHECK SPELLING!
		}
		respond = ChatbotMain.getInput();
		conciseStr(respond);//Line 247
	}
	
	public void conciseStr(String response)// determines whether a response is too long and asks for a shorter one
	{	
		if (respond.length() > 50)
		{
			conciseResponse++;
			ChatbotMain.print("Hold on, hold on, hold on. Your response is toooo long. You are going to have to be concise in college so why not start now? Please respond CONCISELY!");
			respond = ChatbotMain.getInput(); //asks for a new response
			talk(respond);
		}
		else
		{
			talk(respond);
		}
	}
	
	public void beginning() //return all fields to its initial value if user plans to use this 'chatbot' class again
	{
		conciseResponse = 0;
		negEmotions = 0; 
		posEmotions = 0;
		respond = ""; 
		beginning = true;
	}
	
	public void reasonBehindEmotion(String response) //Reason why someone feels a certain way
	{
		int bec = response.indexOf("because"); // determines if there is a 'because' in the response.
		
		if(bec == -1)//no 'because'
		{
			annoyed++;
			if (annoyed > 5)
			{
				ChatbotMain.print(annoyedComments[(int) Math.floor(Math.random() * 3)]);
			}else 
			{
				ChatbotMain.print(reasonQuestions[(int) Math.floor(Math.random() * 2)]);
			}
			
			 String reason = ChatbotMain.getInput();
			 reasonBehindEmotion(reason); //RECURSION!
		}else// found a "because" in response
		{
			int reasLength = response.length();
			//STORES INFORMATION
			if (response.substring(reasLength-1, reasLength).compareTo("a") < 0) //is there a punctuation?
			{
				 reasonWhy = response.substring(bec + 7, reasLength-1);// if yes, take the response after the 'because' w/o the punctuation
			}else
			{
				 reasonWhy = response.substring(bec + 7, reasLength);//if no, take the response after the 'because'.
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