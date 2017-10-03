package chatbot;

public class ChatbotAliceK implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	private String[] footballGame;
	private String[] footballPositive;
	private String[] footballNegative;
	
	private String[] places;
	private String[] placePositive;
	private String[] placeNegative;
	
	private String[] food;
	private String[] foodPositive;
	private String[] foodNegative;
	
	private String[] generalTerms;
	private String[] positiveGeneral;
	private String[] negativeGeneral;
	
	private int emotion;
	
	
	//private String[] responses;

	public ChatbotAliceK() {
		
		//sort through keywords, if a word is in keywords, go to the other array that its in 
		keywords = new String[] { "football game" , "boston" , "cambridge" , "annenberg" , "restaurant" , "cafe" , "go harvard" , "go yale" , "go crimson" , "go bulldogs", 
				
			
				
			"yale sucks", "harvard sucks" , "harvard vs yale football game" , "football game" , "yale vs harvard football game" , "harvard yale football game" , "yale harvard football game" , "harvard will win" , "harvard always win" , "yale will win" , "yale always wins" , "john harvard" , "annenberg" , "food" , "charles river" , "boston" , "cambridge" ,  "go crimson" , "crimson" , "don't have greek life" , "no greek life" , "greek life" , "which house is the best" , "party" , "parties" ,  "stuff","things","whatever", "nothing" , " " };
		//responses = new String[] {"Did you mean Harvard? Yeah go Harvard! " , "What's good with you? You mispelled Crimson." , "Right on!!!" , "You've been brainwashed to epic proportions " , " " ,  };
		
		
		
		footballGame = new String[] {"Harvard", "yale", "football game" , "crimson" , "bulldogs"};
		footballPositive = new String[] {"good", "great", "amazing", "terrific" , "go yale" , "go harvard" ,"go crimson" , "go bulldogs"};
		footballNegative = new String[] {"awful", "horrible", "bad" , "sucks" };
		
		places = new String[] {"Boston", "Cambridge"};
		placePositive = new String[] {"beautiful", "amazing", "fun", "pretty," , "great"};
		placeNegative = new String[] {"ugly", "disgusting", "bad", "gross" };
		
		food = new String[] {"Annenberg" , "Restaurant" , "Cafe"};
		foodPositive = new String[] {"great", "good", "delicious", "scrumptious", "yummy", "yum"};
		foodNegative = new String[] {"horrible", "disgusting", "bad", "gross"};
		
		generalTerms = new String[] {};
		positiveGeneral = new String[] {};
		negativeGeneral = new String[] {};
		
		goodbyeKeyword= "bye";
		secretKeyword= "pug";
		response = "";
		
		emotion = 0;
	}

	public int getEmotion(){
		
		return emotion;
		
	}
	
	public void setEmotion(int x) {
		
		emotion = x;
		
	}
	
	public void talk(String response)
	{
		
		/**
		ChatbotMain.print("Hey! So you want to talk about generic boring things, huh? I love talking about that. So tell me something.");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1)
		{
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >=0)
			{
				ChatbotMain.print("I cant even. I love pugs so much. Wow. You are so cool.");
			}else
			{
				ChatbotMain.print("Yeah. Thats pretty cool. But there are thins I like even more. Tell me something else.");
			}
		}
		ChatbotMain.print("Well , it was nice talking to you, "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
		*/
		
		
		A: for( String keyword : keywords ) {

			if(ChatbotMain.findKeyword(response, keyword,0 ) >= 0) {
				switch( keyword ) {
				case "stuff": ChatbotMain.print(" What kind of stuff? Food? ");  break A;
				case "whatever": ChatbotMain.print(" Talk more specifically, not just whatever"); break A;
				case "go yale" : ChatbotMain.print(" Did you mean Harvard? Yeah go Harvard!"); break A;
				case "go bulldogs" : ChatbotMain.print("What's good with you? You mispelled Crimson."); break;
				case "yale sucks" : ChatbotMain.print("Right on!!!"); break;
				//case "harvard   sucks" : ChatbotMain.print("You've been brainwashed to epic proportions"); break;
			//	case "harvard is bad" : ChatbotMain.print("If bad means good then totally! Harvard is bad."); break;
			//	case "harvard sucks at football" : ChatbotMain.print("At least our students get into graduate school"); break;
			//	case "harvard is bad at footbal" : ChatbotMain.print("Not like you're any better"); break;
				case "john harvard" : ChatbotMain.print("John Harvard did not actually found Harvard! There are three main myths about John Harvard's statue in the Harvard Yard. 1) It isn't actually John Harvard 2) John Harvard isn't the founder of Harvard, even though 'founder' is engraved on the statue 3) Harvard was founded in 1636, not 1638, as the engraving on the statue claims."); break;
			// 	case "annenberg is great" : ChatbotMain.print("Not like you're any better"); break;
				case "go crimson" : ChatbotMain.print("Yeah!!!! GO CRIMSON"); break;
			//	case "go harvard" : ChatbotMain.print("Yeah!!!! GO HARVARD"); break;
				case "which house is the best": ChatbotMain.print("Yeah!!!! GO CRIMSON"); break;
				case "party" : ChatbotMain.print("Party?!!! Yeah don't worry we have those. "); break;
				case "parties" : ChatbotMain.print("Party?!!! Yeah don't worry we have those. "); break;
				case "harvard" : ChatbotMain.print("The greatest school in the world, what would you like to talk about regarding Harvard? "); break;

				}
				
			}
		}
	
	
		
	}
	
	public boolean isTriggered(String response)
	{
		
		for(int i =0;i< keywords.length;i++) 
		{
			if(ChatbotMain.findKeyword(response, keywords[i], 0)>=0)
			{
				return true;
			}
		}
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
