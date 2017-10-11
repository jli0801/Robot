package chatbot;

public class ChatbotAreej implements Topic{
	private String[] tempW;
	private String[] hc;
	private String goodbyeKeyword;
	private String response;
	private String[] affirmative;
	private String[] af;
	private boolean advanced;
	private boolean discussedGrades;
	
	
	public ChatbotAreej() {
		String[] temp = {"school stuff", "academic things", "classes", "transcript"};
		tempW = temp;
		String[] hardClasses = {"ap", "honors","ap's", "honor"};
		hc = hardClasses;
		String[] affirmative = {"ok", "fine", "mhm", "thanks for the help", "thanks for the advice", "i think i will", "i'll go", ""};
		af = affirmative;
		goodbyeKeyword = "bye";
		response = "";
	}

	public void talk(String response) {
		ChatbotMain.print("I see, what would you like to know? ");
		response = ChatbotMain.getInput();
	
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) != -1);
		{
			//regular classes
				if (ChatbotMain.findKeyword(response, tempW[2], 0) >= 0 )
				{
					ChatbotMain.print("Hm let me see");
					program(response);
					
				}
			//transcript	
				if (ChatbotMain.findKeyword(response, tempW[3], 0) >= 0 )
				{
						ChatbotMain.print("Do you need a copy of your transcript?" );
						transcript(response);
						
				}
			//honors classes
				for(int i = 0; i < hc.length; i ++) {
					if (ChatbotMain.findKeyword(response, hc[i], 0) >= 0 )
					{
						ChatbotMain.print("Oh so you're interested in taking some advanced classes? What is your gpa?");
						response = ChatbotMain.getInput();
						honors(response);
						
					}					
				}
		ChatbotMain.print("Well it was nice talking to you, see you around " + ChatbotMain.chatbot.getUsername() + "!");
		//ChatbotMain.chatbot.getAreej().talk("");;
		ChatbotMain.chatbot.startChatting();
		}
	}
	
	private void honors(String response) {
		if (isDouble(response))
		{
			double num = getDouble(response);
			if(num < 3.0)
			{
			ChatbotMain.print("I don't recommend you take honors classes");
			helpingOut();
			response = ChatbotMain.getInput();
			
			}
			
			else
			{
			discussHonorsAsNeeded();
			response = ChatbotMain.getInput();
			advanced= true;
			}
			}
		discussedGrades = true;
		ChatbotMain.print("I need a number please");
		response = ChatbotMain.getInput();
	}

	private void helpingOut() {
		
		ChatbotMain.print("In fact, I'm worried about how you're doing, I really recommend you go to tutoring.");
		response = ChatbotMain.getInput();
		reply(response);
		
	}

	private void transcript(String re) {
		
		for(int i = 0; i < re.length()-5; i++) {
		if(re.substring(i, i + 3).equals("yes") ||re.substring(i, i + 4).equals("yeah") || re.substring(i, i + 10).equals("yes please")) {
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
			ChatbotMain.print("I see you're interested in taking honor classes");
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
	
	private boolean isDouble(String response) {

		 try { 
		        Double.parseDouble(response); 
		    } catch(NumberFormatException e) { 
		        return false; 
		    } catch(NullPointerException e) {
		        return false;
		    }
		    // only got here if we didn't return false
		    return true;
		
}
	public double getDouble(String response)
	{
		double rd;
		rd = 0;
		return rd = Double.parseDouble(response);
	}	
	
	public void reply(String s) {
		for(int i = 0; i < af.length; i ++) {
			
			if (ChatbotMain.findKeyword(s, af[i], 0) >= 0 )
			{
				ChatbotMain.print("Goodluck! I'm here if you need anything else.");
				response = ChatbotMain.getInput();
				
			}					
		}
		ChatbotMain.print("Up to you, I'm only trying to help");
		response = ChatbotMain.getInput();
		
	}

}