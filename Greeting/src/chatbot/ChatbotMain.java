package chatbot;

import java.util.Scanner;

public class ChatbotMain {

	public static final Chatbot chatbot = new Chatbot();
	private static Scanner inputSource = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		chatbot.startChatting();
	}




		//copied from class notes - utilities class

		

		public static String getInput(){
			return inputSource.nextLine();
		}

		public static void print(String s){
			multiLinePrint(s);
		}

		public static void multiLinePrint(String s){
			String printString = "";
			int cutoff = 55;
			//this while loop last as long as there are words left in the original String
			while(s.length() > 0){

				String currentCut = "";
				String nextWord = "";

				//while the current cut is still less than the line length 
				//AND there are still words left to add
				while(currentCut.length()+nextWord.length() < cutoff && s.length() > 0){

					//add the next word
					currentCut += nextWord;

					//remove the word that was added from the original String
					s = s.substring(nextWord.length());

					//identify the following word, exclude the space
					int endOfWord = s.indexOf(" ");

					//if there are no more spaces, this is the last word, so add the whole thing
					if(endOfWord == -1) {
						endOfWord = s.length()-1;//subtract 1 because index of last letter is one les than length
					}

					//the next word should include the space
					nextWord = s.substring(0,endOfWord+1);
				}

				printString +=currentCut+"\n";

			}
			System.out.print(printString);
		}

		public static int getIntegerInput() {
			print("Please enter an integer.");
			String integerString = getInput();
			boolean isInteger = false;
			int value = 0;
			while(!isInteger){
				try{
					value = Integer.parseInt(integerString);
					//will not continue if an error above is thrown
					isInteger = true;//exits loop if entry is valid
				}catch(NumberFormatException e){
					print("You must enter an integer. You better try again.");
					integerString = getInput();
				}
			}
			return value;
		}

	
//importedfrom Greeting Class 
public static final String[] gRes = {"That's good to hear.","Great!",
		"Wow. Tell me more.","I'm glad it went well.", "That's amazing!"};
public static final String[] bRes = {"That's bad news.","I'm so sorry.",
		"Would you like to talk more about it?",
		"That's too bad. ", "Your day will get better."};
private String userInput;
 
private int helloCount;

public void Hello()
{
 helloCount = 0;
}

//index of keyword after startpsn is isolated, has no negation or -1 otherwise
public static int findKeyword (String searchString, String keyword, int startPsn)
{
	//makes lowercase
	searchString = searchString.toLowerCase();
	keyword = keyword.toLowerCase();
	
	int psn = searchString.indexOf(keyword, startPsn);
	
	while (psn >= 0)
	{
		if(keywordIsIsolated(psn, keyword, searchString) && noNegations(searchString, psn))
		{
			return psn;
		}
		else
		{
			psn = searchString.indexOf(keyword, psn+1); //next keyword 
		}
	}
	return -1;
}

public static boolean keywordIsIsolated(int position ,String keyword ,String s)

{
	boolean keywordIso; 
	int numofS = s.indexOf(keyword);
	
	for (int i = 0; i < s.length() - 1; i++)
	{
		String letterOne = keyword.substring(0,1);
		String letterTwo = s.substring(i+1, i+2);
		keywordIso = false; 
		if(letterOne.equals(letterTwo) && !keywordIso && numofS > -1) //if the first letter matches with any of the first 
			//letters of the word
		{
			if(s.substring(i-1, i).equals(" "))
			{
				//if there's a space before it 
				if(s.substring(s.length(),s.length() +1 ).compareTo("a") < 0)
				{
					//any punctuation 
					return true; 
				}
			
			}
		}
		
	}
	return false; 
	//check
	
}
//importedfrom Greeting Class 
public static boolean noNegations(String s, int psn)
{
	/*returns true if there isn't a negation ("no", "not") immediately in front of psn.
	 * returns false if there is a negation immediately in front of psn
	 * PRECONDITION : s is lowercase, psn is within bounds
	 * EXAMPLES: 
	 * nN("I am not Great, but I am okay", 9) -> false
	 * nN("I am not great, but I am Okay", 25) -> true
	 * nN("okay", 0) -> true
	 */
	
	int negation = s.indexOf("no"); //find if there is "no" in the string - it gives a value besides -1 if there is "no" or "not"
	
	if ( negation == -1)
	{
		return true; // if "no" or "not" is not identified, return true ; there is no negation
	} else // if "no" or "not" IS  identified, execute code
	{
		//find out if word is no or not
		if (s.substring(negation+2, negation+3).compareTo("t") == 0) 
			//determines if there is a t at the end of the identified word 'no'
		{
			//the word is not
			if (negation + 4 == psn)// it is +4 because not has three letters and a space is included
			{
				return false; // there is a not (negation) right immediately b4 psn
						
			} else
			{
				return true;// there are no negations right immediately b4 psn
			}
		}else
		{
			//the word is no
			if (negation + 3 == psn)
			{
				return false; // there is a no (negation) right immediately b4 psn.
						
			} else
			{
				return true;// there are no negations right immediately b4 psn
			}
		}
	}
}


}
