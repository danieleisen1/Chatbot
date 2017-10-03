package chatbot;

public class ChatbotAliceK implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	//private String[] responses;

	public ChatbotAliceK() {
		keywords = new String[] { "go yale" , "go bulldogs" , "yale sucks" , "harvard sucks" , "harvard is bad" ,"harvard sucks at football" , "harvard is bad at football" , "harvard vs yale football game" , "football game" , "yale vs harvard football game" , "harvard yale football game" , "yale harvard football game" , "harvard will win" , "harvard always win" , "yale will win" , "yale always wins" , "john harvard" , "annenberg" , "annenberg is great" , "food" , "charles river" , "cambridge is beautiful" , "boston is beautiful" , "boston" , "cambridge" ,  "go crimson" , "crimson" , "don't have greek life" , "no greek life" , "greek life" , "which house is the best" , "party" , "parties" ,  "stuff","things","whatever", "nothing" , " " };
		//responses = new String[] {"Did you mean Harvard? Yeah go Harvard! " , "What's good with you? You mispelled Crimson." , "Right on!!!" , "You've been brainwashed to epic proportions " , " " ,  };
		goodbyeKeyword= "bye";
		secretKeyword= "pug";
		response = "";
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
		
		
		for( String keyword : keywords ) {
			if( response.contains( secretKeyword ))
			{
				ChatbotMain.print("I cant even. I love pugs so much. Wow. You are so cool.");
			}
			else if( response.contains( keyword )) {
				switch( keyword ) {
				case "stuff": ChatbotMain.print(" Yeah, some stuff man");  break;
				case "whatever": ChatbotMain.print(" Talk more specifically, not just whatever"); break;
				case "go yale" : ChatbotMain.print(" Did you mean Harvard? Yeah go Harvard!"); break;
				case "go bulldogs" : ChatbotMain.print("What's good with you? You mispelled Crimson."); break;
				case "yale sucks" : ChatbotMain.print("Right on!!!"); break;
				case "harvard   sucks" : ChatbotMain.print("You've been brainwashed to epic proportions"); break;
				case "harvard is bad" : ChatbotMain.print("If bad means good then totally! Harvard is bad."); break;
				case "harvard sucks at football" : ChatbotMain.print("At least our students get into graduate school"); break;
				case "harvard is bad at footbal" : ChatbotMain.print("Not like you're any better"); break;
				case "john harvard" : ChatbotMain.print("John Harvard did not actually found Harvard! There are three main myths about John Harvard's statue in the Harvard Yard. 1) It isn't actually John Harvard 2) John Harvard isn't the founder of Harvard, even though 'founder' is engraved on the statue 3) Harvard was founded in 1636, not 1638, as the engraving on the statue claims."); break;
				case "annenberg is great" : ChatbotMain.print("Not like you're any better"); break;
				case "go crimson" : ChatbotMain.print("Yeah!!!! GO CRIMSON"); break;
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
