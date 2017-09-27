
package greeting;

public class GreetingClass {

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
	
	public static boolean keywordIsIsolated(int position ,String keyword ,String s)
	{
		int numofS = s.indexOf(keyword);
		
		for (int i = 0; i < s.length(), i++)
		{
			String letterOne = keyword.substring(0,1);
			String letterTwo = s.substring(i, i+1);
			keywordIso = false; 
			if(letterOne.contentEquals(letterTwo) && !keywordIso && numofS > -1) //if the first letter matches with any of the first 
				//letters of the word
			{
				if(s.substring(i-1, i).equals(" "))
				{
					//if there's a space before it 
					if(s.substring(s.length(),s.length() +1 ).compareTo("a") < 0))
					{
						//any puncuation 
						return true; 
					}
				
				}
			}
			
		}
		return false; 
		//check
		
	}
	
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
		
		//if String s == "not" || "no"
		/*if (//no negation in front of psn)
		{
			return true;
		}*/
		
		int negation = s.indexOf("no"); //find if there is "no" in the string - it gives a value besides -1 if there is "no" or "not"
		
		if ( negation == -1)
		{
			return true; // if "no" or "not" is not identified, return true
		} else // if "no" or "not" IS  identified, execute code
		{
			//find out if word is no or not
			if (s.substring(negation+2, negation+3).compareTo("t") == 0) 
			{
				//the word is not
				if (negation + 4 == psn)// it is +4 and not +3 b/c i included the space
				{
					return false;
							
				} else
				{
					return true;
				}
			}else
			{
				//the word is no
				if (negation + 3 == psn)
				{
					return false;
							
				} else
				{
					return true;
				}
			}
		}
	}
}
