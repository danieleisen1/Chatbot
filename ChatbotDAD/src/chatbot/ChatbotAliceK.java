package chatbot;

//

public class ChatbotAliceK implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;

	private String[] footballGame;
	//	private String[] footballPositive;
	//private String[] footballNegative;

	private String[] places;
	//private String[] placePositive;
	//private String[] placeNegative;

	private String[] food;
	//private String[] foodPositive;
	//private String[] foodNegative;

	private String[] generalTerms;

	private String[] positive;
	private String[] negative;

	private int emotionCounter;

	private int emotion;

	private String[] footballEmotions;


	private String[] firstWord;

	//private String[] responses;

	public ChatbotAliceK() {

		//sort through keywords, if a word is in keywords, go to the other array that its in 
		keywords = new String[] {"yes" , "okay" , "sure" , "ok" , "student life" , "3" , "sure" , "ok" , "okay", "no" , "nah" , "na",  "studentlife" , "life" ,  "boston" , "cambridge" , "annenberg" , "restaurant" , "cafe" , "go harvard" , "go yale" , "go crimson" , 



				"yale sucks", "harvard sucks" , "harvard vs yale football game" , "harvard always win" , "yale will win" , "yale always wins" , "john harvard" , "annenberg" , "food" , "charles river" , "boston" , "cambridge" ,  "go crimson" , "crimson" , "don't have greek life" , "no greek life" , "greek life" , "which house is the best" , "party" , "parties" ,  "stuff","things","whatever", "nothing" , " " };
		//responses = new String[] {"Did you mean Harvard? Yeah go Harvard! " , "What's good with you? You mispelled Crimson." , "Right on!!!" , "You've been brainwashed to epic proportions " , " " ,  };



		footballGame = new String[] {"yes" , "football" , "football game" , "crimson" , "bulldogs", "Bulldogs", "harvard crimson" , "yale bulldogs"};

		positive = new String[] {"good", "great", "amazing", "terrific" , "go" ,"go crimson" , "beautiful", "amazing", "fun", "pretty" , "delicious", "scrumptious", "yummy", "yum"};

		negative = new String[] {"go bulldogs" , "go yale", "awful", "horrible", "bad" , "sucks", "ugly", "horrible", "disgusting", "gross"};


		places = new String[] {"Boston", "Cambridge"};



		food = new String[] {"Annenberg" , "Restaurant" , "Cafe"};

		footballEmotions = new String[] { "I can't speak to imbeciles like you anymore" ,
				"you're dumb harvard finesses in all that you do" ,
				"The Harvard vs Yale football game is a longstanding tradition. Harvard wins almost every year because Yale sucks at football, just like they do everything else. What's your opinion on how Harvard is at football? " , "harvard may not be the best at football but at least we're better than yale", 
				"harvard is great at football" }; 


		//firstWord = new String[] {  "3"};



		goodbyeKeyword= "bye";
		secretKeyword= "pug";
		response = "";

		emotion = 0;

		emotionCounter = 0;
	}

	public int getEmotion(){

		return emotion;

	}

	public void setEmotion(int x) {

		emotion = x;

	}
	
	protected boolean isFootballGame( String response ) {
		for(int i=0 ; i <footballGame.length ; i++ ) {
			System.out.println("DEBUG in footballGame for loop ");
			
			// if(response.equals(footballGame[i])) {
			if( findWordInString( response, footballGame[i] )) {

				System.out.println(" DEBUG in first if");
			
				System.out.println("DEBUG printing response after first if  " + response);
				
				System.out.println("DEBUG printing footballGame[i] after first if  " + footballGame[i]);
				
				//	System.err.println("it's working");
				
				System.out.println("DEBUG about to print football emotionCounter = " + emotionCounter );
				ChatbotMain.print( footballEmotions[ emotionCounter+2 ] );  
				
				return true;
			}
		}
		System.out.println("DEBUG exited footbgallgame loop");
		return false;
	}
	
	boolean findWordInString( String searchString, String key ) {
		return searchString.contains( key );
	}
	
	private boolean isPositiveEmotions( String response ) {
		for(int i=0 ; i <positive.length ; i++ ) {
			// if(response.equals(footballGame[i])) {
			System.out.println(" DEBUG in postiive for loop ");

			/** THIS SHOULD WORK WELL ON 'harvard good' but doesn't.  Experimenting with S.contains() below.
			if( ChatbotMain.findKeyword( response, positive[i], 0 ) >= 0 &&
				ChatbotMain.findKeyword( response, "harvard", 0 ) >= 0 ) {
				*/
			
			/** and S.contains of course works */
			if( findWordInString( response, positive[i] ) &&
					findWordInString( response, "harvard" )) {	
			
				emotionCounter++;
				
				System.out.println("trying to find the emotioncounter" + emotionCounter);
				ChatbotMain.print( footballEmotions[emotionCounter+2 ] );
				return true;
			}

			if( findWordInString( response, positive[i] ) &&
				findWordInString( response, "yale" )) {
				emotionCounter--;
				
				System.out.println("trying to find the emotioncounter" + emotionCounter);
				ChatbotMain.print( footballEmotions[emotionCounter+2 ] );
				return true;
			}

	
		}
		return false;
	}
	
	private boolean isNegativeEmotions( String response ) {
		for(int i=0 ; i <negative.length ; i++ ) {
			// if(response.equals(footballGame[i])) {
			System.out.println(" DEBUG in negative for loop");

			if( findWordInString( response, negative[i] ) &&
					findWordInString( response, "harvard" )) {
				emotionCounter--;
				
				System.out.println("trying to find the emotioncounter" + emotionCounter);

				ChatbotMain.print( footballEmotions[emotionCounter+2 ] );
				return true;
			}

			if( findWordInString( response, negative[i] ) &&
					findWordInString( response, "yale" )) {
				emotionCounter++;
				System.out.println("trying to find the emotioncounter" + emotionCounter);

				ChatbotMain.print( footballEmotions[emotionCounter+2 ] );
				return true;
			}

		}
		return false;
	}
	

	/**
	 @param response in order to avoid hijacking of conversations by individual chatbot, each chatbot will do only ONE request/response and will hand over control to the main loop
	 in Chatbot.java.
	 userRequest is the string that user enters, and it is read ONLY in main loop in Chatbot.java.
	 The objective of talk( String userRequest ) is to identify the keywords present in userRequest and based on them,  print response and exit talk() method immediately.
	 This way the next userRequest will come in soon, as new call to this talk() method.
	 */
	public void talk(String response) {
		
		System.out.println("DEBUG Welcome to AliceK talk()");

		if( isPositiveEmotions( response )) {
			System.out.println( "DEBUG isPositive returned true, leaving talk()" );
			return;
		}
		
		if( isNegativeEmotions( response )) {
			System.out.println( "DEBUG isNegative returned true, leaving talk()" );
			return;
		}
		
		if( isFootballGame( response )) {
			System.out.println( "DEBUG isFootball returned true, leaving talk()" );
			return;
		}

		System.out.println("DEBUG justbefore keywords");
		for( String s : keywords ) {
			
			System.out.println("DEBUG in first for");

			if( findWordInString(response, s ))  {
				if(s.equals("student life") || s.equals("3") || s.equals("student") || s.equals("life")) {
					ChatbotMain.print("I am the expert of student life at Harvard. The annual Harvard vs Yale game is coming up. Type in whoever you're rooting for, Harvard Crimson or Yale Bulldogs.");
					return;
				}
				else if(s.equals("yes") || s.equals("sure") || s.equals("ok") || s.equals("okay")  ) {
					ChatbotMain.print("The Harvard vs. Yale football game is a longstanding tradition. Harvard wins every year though, of course. ");
					return;
				}
				else if(s.equalsIgnoreCase("no") || s.equalsIgnoreCase("na") || s.equalsIgnoreCase("nah")) {
					ChatbotMain.print("Okay, well in that case I am of no use. Type in '2' for admissions advice.");
					//	System.out.println( "DEBUG inside the no" );
					return;
				}
				System.out.println( "before checking if in football game" );
				System.out.println("DEBUGjust got out of for");
	
				switch( s ) {
				case "stuff": ChatbotMain.print(" What kind of stuff? Food? ");  return;
				case "whatever": ChatbotMain.print(" Talk more specifically, not just whatever"); return;
				case "go yale" : ChatbotMain.print(" Did you mean Harvard? Yeah go Harvard!"); return;
				case "go bulldogs" : ChatbotMain.print("What's good with you? You mispelled Crimson."); return;
				case "yale sucks" : ChatbotMain.print("Right on!!!"); return;
				//case "harvard   sucks" : ChatbotMain.print("You've been brainwashed to epic proportions"); break;
				//	case "harvard is bad" : ChatbotMain.print("If bad means good then totally! Harvard is bad."); break;
				//	case "harvard sucks at football" : ChatbotMain.print("At least our students get into graduate school"); break;
				//	case "harvard is bad at footbal" : ChatbotMain.print("Not like you're any better"); break;
				case "john harvard" : ChatbotMain.print("John Harvard did not actually found Harvard! There are three main myths about John Harvard's statue in the Harvard Yard. 1) It isn't actually John Harvard 2) John Harvard isn't the founder of Harvard, even though 'founder' is engraved on the statue 3) Harvard was founded in 1636, not 1638, as the engraving on the statue claims."); break;
				// 	case "annenberg is great" : ChatbotMain.print("Not like you're any better"); break;
				case "go crimson" : ChatbotMain.print("Yeah!!!! GO CRIMSON"); return;
				//	case "go harvard" : ChatbotMain.print("Yeah!!!! GO HARVARD"); break;
				case "which house is the best": ChatbotMain.print("Yeah!!!! GO CRIMSON"); return;
				case "party" : ChatbotMain.print("Party?!!! Yeah don't worry we have those. "); return;
				case "parties" : ChatbotMain.print("Party?!!! Yeah don't worry we have those. "); return;
				case "harvard" : ChatbotMain.print("The greatest school in the world, what would you like to talk about regarding Harvard? "); return;
				}
			}
		}
		
		System.out.println( "DEBUG  leaving talk() and did absolutely NOTHING" );
	}




	public boolean findWordInArray( String word, String[] array ) {
		for( String s : array ) {
			if( word.equals( s )) {
				return true;
			}
		}
		return false;
	}


	public boolean isTriggered(String response)
	{
		System.out.println( "DEBUG Welcome to AliceK.isTriggered() response=" + response);

		for(int i =0;i< keywords.length;i++) 
		{
			if(findWordInString(response, keywords[i] ))
			{
				System.out.println( "Returning TRUE from AliceK.isTriggered()");
				return true;
			}
		}
		
		for(int i =0;i< positive.length;i++) 
		{
			if(findWordInString(response, positive[i] ))
			{
				System.out.println( "Returning TRUE from AliceK.isTriggered()");
				return true;
			}
		}
		
		for(int i =0;i< negative.length;i++) 
		{
			if(findWordInString(response, negative[i] ))
			{
				System.out.println( "Returning TRUE from AliceK.isTriggered()");
				return true;
			}
		}
		
		for(int i =0;i< footballGame.length;i++) 
		{
			if( findWordInString( response, footballGame[i] ))
			{
				System.out.println( "Returning TRUE from AliceK.isTriggered()");
				return true;
			}
		}
		
		System.out.println( "Returning false from AliceK.isTriggered()");
		return false;

		/*


		String[] toks = response.split( " " );
		for( String currentTok : toks ) {
			for( String keyword : this.keywords ) {
			}
		}
		 */

		//

	}





}


/**
for(int i=0 ; i <negative.length ; i++ ) {
	// if(response.equals(footballGame[i])) {
	if(ChatbotMain.findKeyword( response, negative[i], 0 ) >= 0) {

		System.out.println("in first if");
	
		System.out.println("printing response after first if  " + response);
		
		System.out.println("printing footballGame[i] after first if  " + footballGame[i]);
		
		// response="go harvard"
		// find( "harvardgo harvard" )
		

		
		//	System.err.println("it's working");
		
		//System.out.println("DEBUG  " + footballEmotions[emotionCounter + 2 ]);
		  
		
	}
}
*/
