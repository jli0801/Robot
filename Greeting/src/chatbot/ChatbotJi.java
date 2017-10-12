package chatbot;

public class ChatbotJi implements Topic {
	
	private ChatbotJessica jessica;
	private ChatbotAreej areej;		
	private ChatbotVickie vickie;
	private ChatbotJi ji;
	
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	// private String[] happy;
	private boolean startedEssay = false;
	private String[] mild = { "Be more specific.", "Something else you want to say?",
	"What do you mean?" };
	private String[] annoyed = { "If you aren't here for college help, might as well google it.",
			"I have other students who need help, come back when you have prepared reasonable questions.",
			"I don't have all day." };
	public boolean discussedHonors = false;
	private int numAnnoyed = 5;
	
	private boolean askedInitial = false;
	// if numAnnoyed reaches 3, will turn to mild reaction
	// else when reach to 1, will turn to annoyed reaction

	// connect essay = true sat = true etc
	private String[] negWords = { "stop", "bad", "unhelpful" };

	public ChatbotJi() {
		String[] temp = { "college", "university", "school", "essay", "honors" }; // first three links to college

		// String[] happy = {"I'm glad you asked me for help.", "Thanks for showing your
		// interest.", "Your future is bright.", "No problem."}; 
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "scholarship";
		response = "";
	}

	public void talk(String response) {
		if (askedInitial == false) {
			askedInitial = true;
			ChatbotMain.print("By any chance, are you interested in applying for college? If so, what step in the application do you want help with?");
			response = ChatbotMain.getInput();
			findNegWords();
		}
		else {
			ChatbotMain.print("What else do you want to know?");
			response = ChatbotMain.getInput();
			findNegWords();
		}

		while (ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {

			if (ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				//ChatbotMain.print("Are you applying for scholarships? Applying for them may come in handy in your application process!!!");
				adviseScholarship();
			} else if (ChatbotMain.findKeyword(response, keywords[3], 0) >= 0) { //essay
				adviseEssay();
			} else if (ChatbotMain.findKeyword(response, keywords[4], 0) >= 0) { //honors
				adviseHonors();
			} else if (ChatbotMain.findKeyword(response, "other", 0) >= 0) {
				ChatbotMain.print("Do you want to talk about other stuff?");
				response = ChatbotMain.getInput();
				findNegWords();
				if (ChatbotMain.findKeyword(response, "yes", 0) >= 0) {
					ChatbotMain.print("What do you want to talk about?");
					response = ChatbotMain.getInput();
					triggerOtherClasses(response);
				} else {
					ChatbotMain.print("Ok then let's keep talking about college.");
				}
				
			} else {
				ChatbotMain.print("I'm not quite sure what you need help with. Would you mind rephrasing your question?");
			}

			response = ChatbotMain.getInput();
			findNegWords();
		}

		ChatbotMain.print(ChatbotMain.chatbot.getUsername() + ", ask away if you have more questions!");
		// ChatbotMain.chatbot.getJi().talk("");;
		ChatbotMain.chatbot.startChatting();
	}

	//

	public void adviseScholarship() {
		ChatbotMain.print("Are you applying for scholarships? Applying for them may come in handy in your application process!!!");
		response = ChatbotMain.getInput();
		findNegWords();
		if (ChatbotMain.findKeyword(response, "yes", 0) >= 0) {
			if (ChatbotMain.chatbot.getAreej().isAdvanced()) {
				ChatbotMain.print("Great! You are on your way to getting a scholarship due to your academic achievements!");
				if (startedEssay == true) {
					ChatbotMain.print("Not only that, you also started your essay. Kudos to you.");
				}
			} else {
				ChatbotMain.print("You'll have better chances when you take rigorous courses.");
			}
		} else if (ChatbotMain.findKeyword(response, "no", 0) >= 0) {
			//findNegWords();
			ChatbotMain.print("You should.");
		} else {
			ChatbotMain.print("If you haven't, you should.");
		}
	}

	public void adviseEssay() {

		// findNegWords();
		ChatbotMain.print("Have you started on your college essay?");
		response = ChatbotMain.getInput();
		findNegWords();
		if (ChatbotMain.findKeyword(response, "yes", 0) >= 0) {
			startedEssay = true;
			ChatbotMain.print("Would you like to have advice on writing your essay?");
			response = ChatbotMain.getInput();
			findNegWords();
			if (ChatbotMain.findKeyword(response, "yes", 0) >= 0) {
				// findNegWords();
				ChatbotMain.print("Great! What are you struggling with?");
				response = ChatbotMain.getInput();
				findNegWords();
				if (ChatbotMain.findKeyword(response, "topic", 0) >= 0) {
					// findNegWords();
					ChatbotMain.print("Think about moments that impacted your personality or characteristic you highly value. If you are still stuck, try looking at the essay prompts. Hopefully an idea will spark!");
					response = ChatbotMain.getInput();
					findNegWords();
					if (ChatbotMain.findKeyword(response, "thanks", 0) >= 0) {
						// findNegWords();
						ChatbotMain.print("No problem.");
					}
				}

			} else if (ChatbotMain.findKeyword(response, "no", 0) >= 0) {
				// findNegWords();
				ChatbotMain.print("Well.. if you need help, you can always contact me.");
			}
		} else {
			ChatbotMain.print("The sooner you start, the better your progress.");
		}
	}

	public void adviseHonors() {
		// findNegWords();
			ChatbotMain.print("Are you taking honors or AP classes?");
			response = ChatbotMain.getInput();
			findNegWords();
			if (ChatbotMain.findKeyword(response, "yes", 0) >= 0) {
				ChatbotMain.print("That's good. You are taking a big step towards college.");
				hasDiscussedHonors();
			} 
			else if (ChatbotMain.findKeyword(response, "no", 0) >= 0) {
				ChatbotMain.print("You should, it prepares you for college.");
				hasDiscussedHonors();
			} else {
			ChatbotMain.print("No..? Oh, make sure you try to.");
			}
		}
	

	public void getBotReaction() {
		if ((numAnnoyed > 1) && (numAnnoyed < 4)) { // mild
			ChatbotMain.print(mild[(int) Math.floor(Math.random() * 2)]);
		}

		if (numAnnoyed <= 1) { // annoyed
			ChatbotMain.print(annoyed[(int) Math.floor(Math.random() * 2)]);
		}

		// if -1 end discussion?
	}

	public void findNegWords() {
		if (response.contains(negWords[0])) {
			numAnnoyed--;

		} 
		else if (response.contains(negWords[1])) {
			numAnnoyed--;

		} 
		else if (response.contains(negWords[2])) {
			numAnnoyed--;
		}
		getBotReaction();
	}

	public boolean hasDiscussedHonors() {
		discussedHonors = true;
		return discussedHonors;
	}

	public void triggerOtherClasses(String response) {
		if(jessica.isTriggered(response))
		{

			jessica.talk(response);
		}
		else if(vickie.isTriggered(response))
		{

			vickie.talk(response);
		}
		else if(areej.isTriggered(response))
		{

			areej.talk(response);
		}
		else if(ji.isTriggered(response)) {

			ji.talk(response);
		} else
		{
			ChatbotMain.print("Pick one: Classes, colleges, or a joke?");
			response = ChatbotMain.getInput();
			triggerOtherClasses(response);
		}
	}
	
	//public void setJessica(ChatbotJessica jessica) {
	//	this.jessica = jessica;
	//}
	
	//public void setVickie(ChatbotVickie vickie) {
	//	this.vickie = vickie;
	//}
	
	//public void setAreej(ChatbotAreej areej) {
	//	this.areej = areej;
	//}

	public boolean isTriggered(String response) {
		for (int i = 0; i < keywords.length; i++) {
			// IMPORTANT (one the rubric) only if keyword is used
			if (ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;

	}
}
