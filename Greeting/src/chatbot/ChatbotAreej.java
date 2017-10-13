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
	private int gpa;
	//private String[] annoyed;
	//private int annoyedNum;
	//private String[] annoyers;
	//private String[] classes;
	//private String[] clases;
	//private double result;

	public ChatbotAreej() {
		
		
		String[] temp = {"school stuff", "academic things", "classes", "transcript", "academics"};
		tempW = temp;
		String[] hardClasses = {"ap", "honors","ap's", "honor"};
		hc = hardClasses;
		String[] affirmative = {"ok", "k", "okay", "fine", "mhm", "thanks for the help", "thanks for the advice", "i think i will", "i'll go", "yes",
				"thanks","yeah", "okay thanks","please"};
		af = affirmative;
		goodbyeKeyword = "bye";
		response = "";
		gpa = 0;
		//String[] isAnnoyed = {"Stop wasting my time", "You know, I have other people who need my help", "I'm not going to listen to you talk like this all day", "No need to be rude"};
		//annoyed = isAnnoyed;
		//annoyedNum = 3;
		//String[] annoyingThings = {"you're not very helpful","can you give me anything","why aren't you giving me a straight answer", "why can't you give me what i need"
		//		, "why can't you give me what i want","unhelpful", "annoying"};
		//annoyers = annoyingThings;
		//String[] classes = {"Calculus", "English", "Oracle", "AP Java", "Physics"};
		//clases = classes;
		//result = 0;
	
	}

	public void talk(String response) {
		ChatbotMain.print("I see, what would you like to know about: your transcript or ap's? ");
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
						ChatbotMain.print("So you need a copy of your transcript?" );
						response = ChatbotMain.getInput();
						transcript(response);
						
						
				}
			//honors classes
				for(int i = 0; i < hc.length; i ++) {
					if (ChatbotMain.findKeyword(response, hc[i], 0) >= 0 )
					{
						ChatbotMain.print("Oh so you're interested in taking some advanced classes? What is your gpa?");
						response = ChatbotMain.getInput();
						recHonors(response);
						
					}					
				}
		ChatbotMain.print("Well it was nice talking to you, see you around " + ChatbotMain.chatbot.getUsername() + "!");
		//ChatbotMain.chatbot.getAreej().talk("");;
		ChatbotMain.chatbot.omgTriggers();
		}
	}
	

	/*private void assignTranscript() {
		
		String s = "";
		
		for(int i = 0; i < clas.length; i++) {
			int avr = (int) ((Math.random() * 50) + 50);
			s+= clas[i]+ "     "+ avr + "\n";
		}
		System.out.println(s);

	}
	
	private void generateGPA() {
		double avr = 0;
		for(int i = 0; i < clas.length; i++) {
			avr = ((Math.random() * 50) + 50);
		}
		result = divide(avr + gpa, clas.length*4.1);
		System.out.println(result);
	}
*/
	private void transcript(String res) {

		for(int i = 0; i < af.length; i++) {
		if(res.equals(af[i])) {
			//these are too specific
			//ChatbotMain.print("Here you go!");
			//assignTranscript();
			ChatbotMain.print("Ok, the Internet is down right now but I'll get it to you by the end of the day");
			
			response = ChatbotMain.getInput();
			reply(response);
		
		}
		}
		ChatbotMain.print("Ok, then how about let's talk about something else");
		//+ "Do you want to talk about something personal, colleges, or do you want to hear a joke?"); 
		ChatbotMain.chatbot.omgTriggers();	

	}
	
	private void recHonors(String response) {
		if (isDouble(response))
		{
			double num = getDouble(response);
			if(num < 3.0)
			{
			ChatbotMain.print("I don't recommend you take honors classes. In fact, I'm worried about how you're doing, I really recommend you go to tutoring.");
			response = ChatbotMain.getInput();
			reply(response);
			discussedGrades = true;
			
			}
			
			else
			{
			discussHonorsAsNeeded();
			response = ChatbotMain.getInput();
			advanced= true;
			discussedGrades = true;
			}
			}
		
		ChatbotMain.print("I need a number please");
		response = ChatbotMain.getInput();
		recHonors(response);
		
	}

	private void program(String r) {
		
		for(int i = 0; i < r.length()-7; i++) {
			
		if(r.substring(i, i + 6).equals("change"))
		{
			ChatbotMain.print("What would you like to change?");
			response = ChatbotMain.getInput();
			
			ChatbotMain.print("Ok, I'll see what I can do. Now, let's talk about something else");
					//+ "Do you want to talk about something personal, colleges, or do you want to hear a joke?"); 
			ChatbotMain.chatbot.omgTriggers();
		}
		}
		
		for(int i = 0; i < r.length()-9; i++) {
			
			if(r.substring(i, i + 8).equals("transfer"))
			{
				ChatbotMain.print("I'm not sure, but I'll get back to you ASAP. Now, let's talk about something else");
						//+ "Do you want to talk about something personal, colleges, or do you want to hear a joke?"); 
						ChatbotMain.chatbot.omgTriggers();	
			}
		}
		
	}


	private void discussHonorsAsNeeded() {
		if(ChatbotMain.chatbot.getJi().hasDiscussedHonors()) {
			//credentials for honors
			//method for ji
			//needs same method 
			ChatbotMain.print("I think you'll do very well in an advanced class if you choose to take one. Now, let's talk about something else");
					//+ "Do you want to talk about something personal, colleges, or do you want to hear a joke?");
			ChatbotMain.chatbot.omgTriggers();

		}
	}

	
	public void reply(String s) {
		for(int i = 0; i < af.length; i ++) {
			
			if (ChatbotMain.findKeyword(s, af[i], 0) >= 0 )
			{
				ChatbotMain.print("No problem! I'm here if you need anything else. Now, let's talk about something else");
						//+ "Do you want to talk about something personal, colleges, or hear a joke?");
				ChatbotMain.chatbot.omgTriggers();
				
			}					
		}
		ChatbotMain.print("Up to you, I'm only trying to help. Now, let's talk about something else");
				//+ "Do you want to talk about something personal, colleges, or do you want to hear a joke?");
		ChatbotMain.chatbot.omgTriggers();

		
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
		    return true;
		
}
	public double getDouble(String response)
	{
		double rd;
		rd = 0;
		return rd = Double.parseDouble(response);
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
/*	public void reaction(String response2) {
		
		if (annoyedNum <= 1) { 
			ChatbotMain.print(annoyed[(int) Math.floor(Math.random() * 3)]);
		}

		if(annoyedNum == -1) {
			ChatbotMain.print("You know what, come back later, I'm not dealing with this attitude.");
		}
	}

	public void annoyers(String pon) {
		for(int i = 0; i < annoyers.length; i ++)
		if (pon.equals(annoyers[i])) {
			annoyedNum--;
		} 
		reaction(pon);
		
	}
	*/
}
	/*public double divide(double dividend, double divisor) {

		int sum = 0, count = -1;

		while(sum <= dividend) {

		sum += divisor;

		count++;

		}
		return count;
}*/
	
