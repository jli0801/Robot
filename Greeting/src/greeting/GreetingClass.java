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
		for (int i = 0; i < s.length(), i++)
		{
			String letterOne = keyword.substring(0,1);
			String letterTwo = s.substring(i, i+1);
			
		}
	}
	
	public static boolean noNegations(String s, int psn)
	{
		
	}
}
