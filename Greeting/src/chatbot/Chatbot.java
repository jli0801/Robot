package chatbot;

public class Chatbot {
	private String username;
	private boolean chatting;
	private Topic jessica;

	public String getUsername ()
	{
		return username;
	}
	public Topic getJessicaL()
	{
		return jessica;
	}
	public Chatbot() {
		jessica = new ChatbotJessicaL();
		username = "Unknown User";
		chatting = true;
	}

	public void startChatting() {
		
		ChatbotMain.print("Hi! I am an intelligence machiene that can respond to your input.");
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
			else
			{
				ChatbotMain.print("I'm sorry. I don't understand. I never said I was perfect.");
			}
		}
	}

}
