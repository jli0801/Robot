package chatbot;

public class Chatbot {
	private String username;
	private boolean chatting;
	private Topic jessica;
	private Topic areej;
	private Topic vickie;
	private Topic ji;

	/*public String getUsername ()
	{
		return username;
	}
	public Topic getJessica()
	{
		return jessica;
	}
	public Topic getAreej()
	{
		return areej;
	}
	public Topic getVickie()
	{
		return vickie;
	}
	public Topic getJi()
	{
		return ji;
	}
	public Chatbot() {
		jessica = new ChatbotJessica();
		areej = new ChatbotAreej();
		vickie = new ChatbotVickie();
		ji = new ChatbotJi();
		username = "Unknown User";
		chatting = true;
	}

	public void startChatting() {
		
		ChatbotMain.print("Hi! I am an intelligence machiene that can respond to your input. What is your name?");
		username = ChatbotMain.getInput();
		while (chatting)
		{
			ChatbotMain.print("What would you like to talk about?");
			String response = ChatbotMain.getInput();
			if(jessica.isTriggered(response))
			{
				chatting = false; //exits the while loop IMPORTANT
				jessica.talk(response);
			}
			else if(areej.isTriggered(response))
			{
				chatting = false; //exits the while loop IMPORTANT
				areej.talk(response);
			}
			else if(vickie.isTriggered(response))
			{
				chatting = false; //exits the while loop IMPORTANT
				vickie.talk(response);
			}
			else if(ji.isTriggered(response))
			{
				chatting = false; //exits the while loop IMPORTANT
				ji.talk(response);
			}
			else
			{
				ChatbotMain.print("I'm sorry. I don't understand. Please rephrase that.");
			}
		}
	}*/
	
	public testing{
		
		if( keywordIsIsolated(4,"good","i'm good") && keywordIsIsolated(0,"good","good. how are you?") 
				&& !keywordIsIsolated(4,"good","goodbye. i hope you feel good") && keywordIsIsolated(25,"good","goodbye. i hope you feel good")){
			print("You passed all the keywordIsIsolated tests.");
		}
		
		}

	

	public static boolean keywordIsIsolated(int position ,String keyword ,String s)//keywordIsIsolated(4,"good","i'm good")

	{
		//boolean keywordIso = false; 
		int numofS = s.indexOf(keyword); //4
		
		if (numofS == -1)
		{
			return false;
		}
		
		for (int i = 0; i < s.length() - 1; i++)
		{
			String letterOne = keyword.substring(0,1); //g
			String letterTwo = s.substring(i, i+1); //g if i = 4
			if(letterOne.equals(letterTwo) && numofS == 0) //if the first letter matches with any of the first 
				//letters of the word
			{
				int key = keyword.length();
				String restKeyword = keyword.substring(1,key);
				
				if (restKeyword.equals(s.substring(i+1, key)) && )
				{
					return true;
				}
				
				
			}
				else(s.substring(i-1, i).equals(" "))
				{
					//if there's a space before it 
					if(s.substring(s.length(),s.length() + 1 ).compareTo("a") < 0)
					{
						//any punctuation 
						return true; 
					}
					
					
				
				}
			}
			
		}
		return false; 
	}
	}

}
