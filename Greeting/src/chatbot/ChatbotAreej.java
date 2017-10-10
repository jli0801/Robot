package chatbot;

public class ChatbotAreej implements Topic{
	private String[] tempW;
	private String[] hc;
	private String goodbyeKeyword;
	//private String secretKeyword;
	private String response;
	//private String[] worryingFactors;
	//private String[] affirmative;
	private boolean advanced;
	private boolean discussedGrades;
	private String questionResponse;
	
	
	public ChatbotAreej() {
		String[] temp = {"school stuff", "academic things", "classes", "transcript"};
		tempW = temp;
		String[] hardClasses = {"ap", "honors"};
		hc = hardClasses;
		//String[] affirimative = {"yes", "please", "mhm"};
		questionResponse = "can you?";
		goodbyeKeyword = "bye";
		//secretKeyword = "program";
		response = "";
		//String[] worryingFactors = {"bad", "low", "wrong"};
	
	}

	public void talk(String response) {
		ChatbotMain.print("I see, what would you like to know? ");
		response = ChatbotMain.getInput();
	
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) != -1);
		{
			if (ChatbotMain.findKeyword(response, tempW[2], 0) >= 0 )
				{
					ChatbotMain.print("Hm let me see");
					program(response);
					
				}
				if (ChatbotMain.findKeyword(response, tempW[3], 0) >= 0 )
					{
						ChatbotMain.print("Do you need a copy of your transcript?" );
						transcript(response);
						
					}
		
			
			/*if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0)
			{
				ChatbotMain.print("Ah, what do you want to ");
				response = ChatbotMain.getInput();
				
				for(int i = 0; i < response.length()-3; i ++) {
					if(response.substring(i, i+3).equals("yes")) {
						discussProgram();
					}
					}
				ChatbotMain.print("So what do you need?");
				response = ChatbotMain.getInput();
				}
			}
			*/
				/*for(int i = 0; i < worryingFactors.length; i ++)
				
				  if (response.equals(worryingFactors[i]))
				{
					helpingOut();
					response = ChatbotMain.getInput();
				}
				else
				{
					discussHonorsAsNeeded();
					//ChatbotMain.print("");
					response = ChatbotMain.getInput();
				} 
				*/
		
		ChatbotMain.print("Well it was nice talking to you, see you around " + ChatbotMain.chatbot.getUsername() + "!");
		//ChatbotMain.chatbot.getAreej().talk("");;
		ChatbotMain.chatbot.startChatting();
		}
	}
	
	private void transcript(String re) {
		
		for(int i = 0; i < re.length()-5; i++) {
		if(re.substring(i, i + 3).equals("yes") ||re.substring(i, i + 4).equals("yeah")) {
			ChatbotMain.print("Ok, here you are!");
			response = ChatbotMain.getInput();
		}
		}
		
	}

	private void program(String r) {
		
		for(int i = 0; i < r.length()-7; i++) {
			
		if(r.substring(i, i + 6).equals("change"))
		{
			ChatbotMain.print("What would you like to change?");
			response = ChatbotMain.getInput();
			ChatbotMain.print("Ok I'll see what I can do");
			response = ChatbotMain.getInput();
		}
		}
		
		for(int i = 0; i < r.length()-9; i++) {
			
			if(r.substring(i, i + 8).equals("transfer"))
			{
				ChatbotMain.print("I'm not sure, but I'll get back to you ASAP");
				response = ChatbotMain.getInput();
			}
		}
		
	}


	private void discussHonorsAsNeeded() {
		if(ChatbotMain.chatbot.getJi().hasDiscussedHonors()) {
			//credentials for honors
			//method for ji
			//needs same method 
		}
		
	}
	
	public boolean isTriggered(String response) {
		for(int i = 0; i < tempW.length; i++)
		{
			//IMPORTANT (one the rubric) only if keyword is used
			if(ChatbotMain.findKeyword(response, tempW[i], 0) >= 0)
			{
				return true;
			}
		}
		return false;

}
	
	public boolean isAdvanced() {
		return advanced;
		
	}
	
	public boolean isDiscussed() {
		return discussedGrades;
	}
	
}
