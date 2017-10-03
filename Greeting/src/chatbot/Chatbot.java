package chatbot;

public class Chatbot {
	private String username;
	private static int grade;
	private boolean chatting;
	private Topic jessica;
	private Topic areej;
	private Topic vickie;
	private Topic ji;
	private int helloCount; //irritated when repeated

	public String getUsername ()
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
		grade = 0;
	}

	public void startChatting() {
		
		ChatbotMain.print("Hi! I am a guidance counselor, and here to help you through your years at high school! What is your name?");
		username = ChatbotMain.getInput();
		/*ChatbotMain.print("What grade are you in?");
		
		while(grade == 0)
		{
			String stringWithGrade = ChatbotMain.getInput();
			Chatbot.getGrade(stringWithGrade);	//
		}
		*/
		
		
		
		
		while (chatting)
		{
			ChatbotMain.print("Hi " + ChatbotMain.chatbot.getUsername() + ", what would you like to talk about?");
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
	}
	
	/*private static void getGrade(String stringWithGrade) {
		String gradeTen = "10";
		String gradeNine = "9";
		String gradeEleven = "11";
		String gradeTwelve = "12";
		
		for (int i = 0; i>stringWithGrade.length()-2; i++)
			{
				String possibleGradeNum = stringWithGrade.substring(i,i+2);
			//	String possibleGradeWord = stringWithGrade.substring(i,i+3);
				
				
				if (possibleGradeNum.equals(gradeTen)) // || possibleGradeNum.equals("ten") || possibleGradeNum.equals("tenth"))
				{
					grade = 10;
				}
				if (possibleGradeNum.equals(gradeNine))
				{
					grade = 9;
				}
				if (possibleGradeNum.equals(gradeEleven))
				{
					grade = 11;
				}
				if (possibleGradeNum.equals(gradeTwelve))
				{
					grade = 12;
				}
				
			}
			System.out.println("Sorry, what is your grade?");
			ChatbotMain.chatbot.startChatting();
				*/
	}
	

		

	
	

