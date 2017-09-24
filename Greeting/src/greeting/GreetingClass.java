package greeting;

public class GreetingClass {

	public static final String[] gRes = {"That's good to hear.","Great!",
			"Wow. Tell me more.","I'm glad it went well.", "That's amazing!"};
	public static final String[] bRes = {"That's bad news.","I'm so sorry.",
			"Would you like to talk more about it?",
			"That's too bad. ", "Your day will get better."};
	private String userInput;
	 
	private int helloCount;
	
	public Hello()
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
		/*returns true if there is not a negation ("no", "not") immediately in front of psn.
		 * PRECONDITION : s is lowercase, psn is within bounds
		 */
	}
}
