package chatbot;

public class Chatbot {
	private String username;
	private boolean chatting;
	private Topic jessica;
	private ChatbotAreej areej;
	private Topic vickie;
	private ChatbotJi ji;
	
	private boolean endOfJess;
	private boolean endOfVickie;
	private boolean endOfAreej;
	private boolean endOfJi;
	
	private boolean noRepeat;

	private String[] upsetResArr;
	
	
	public String getUsername ()
	{
		return username;
	}
	public Topic getJessica()
	{
		return jessica;
	}
	public ChatbotAreej getAreej()
	{
		return areej;
	}
	public Topic getVickie()
	{
		return vickie;
	}
	public ChatbotJi getJi()
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
		noRepeat = true;
	
		endOfJess = false;
		endOfVickie = false;
		endOfAreej = false;
		endOfJi = false;
		String[] upsetRes = {"We already said Hi.", "Let's move on. What do you want to speak about?" 
				,"Please stop saying hi. ", "Do you really understand? ", "You have to say something else!"};
		upsetResArr = upsetRes;
	

	}

	public void startChatting() {
		
		if (noRepeat == true)
		{
			ChatbotMain.print("Hi! I am a guidance counselor, and here to help you through your years at high school! What is your name?");
			username = ChatbotMain.getInput();
			noRepeat = false; 
			ChatbotMain.print("Hi, " + getUsername() + ". What would you like to talk about? Classes, colleges, any personal things, or a joke?");
		}
			

			while (chatting)
			{
				
				String response = ChatbotMain.getInput();

				if(jessica.isTriggered(response) && !endOfJess)
				{
					chatting = false; //exits the while loop IMPORTANT
					endOfJess = true;
					jessica.talk(response);
				}
				else if(areej.isTriggered(response))
				{
					chatting = false; //exits the while loop IMPORTANT.
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
					//if((ChatbotMain.findKeyword(response, "hello" , 0) >= 0) || (ChatbotMain.findKeyword(response, "hi" , 0) >= 0))
					if(response.indexOf("hello") >= 0|| response.indexOf("hi") >= 0)
					{
					
						ChatbotMain.print(upsetResArr[(int) (Math.random()*3)]);	
					
					}
					else 
					{
						ChatbotMain.print("I'm sorry. I don't understand. Do you want to talk about classes, colleges, any personal things, "
						+ "or maybe even a joke?");
					}
				}
			}
		}
	
}