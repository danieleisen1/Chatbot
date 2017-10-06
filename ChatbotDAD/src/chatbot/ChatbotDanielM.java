package chatbot;

public class ChatbotDanielM implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private int actScore;
	private int satScore;
	private int currentEmotion;

	public ChatbotDanielM() {
		String[] temp = {"ACT","SAT","GPA", "grades","essays","essay", "supplement","financial aid","acceptance rate","regular admissions","early admission" };
		keywords = temp;
		goodbyeKeyword= "bye";
		secretKeyword= "pug";
		response = "";
	
	
	}

	public void talk(String response)
	{
		/**ChatbotMain.print("Hey! So you want to talk about generic boring things, huh? I love talking about that. So tell me something.");
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
		ChatbotMain.print("Hey, this is the admission bot and I have a few questions for you about getting into Harvard. First, Did you take an ACT test or SAT test?");
		response = ChatbotMain.getInput();
		if(response.equals("ACT") || response.equals("act"))
		{
			ChatbotMain.print("What is your ACT score");

				actScore = ChatbotMain.getIntegerInput();
			
			if(actScore<=30)

			{
				ChatbotMain.print("HAHAHAHA, You are the worst. Retake it immediatly if you wanna go to Harvard");
			}
			if(actScore>=30)
			{
				ChatbotMain.print("You are on the right track to get into harvard " +ChatbotMain.chatbot.getUsername()+", but what is your GPA ");
			}
		}	
		if(response.equals("SAT") || response.equals("sat"))
		{
			ChatbotMain.print("What is your SAT score");
				satScore = ChatbotMain.getIntegerInput();

			
			if(satScore<=1400)
			{
				ChatbotMain.print("HAHAHAHA, You are the worst. Retake it immediatly if you wanna go to Harvard");
			}
			if(satScore>=30)
			{
				ChatbotMain.print("You are on the right track to get into harvard, but what is your GPA ");
			}
		}
			
			for( String keyword : keywords ) {
		if(ChatbotMain.findKeyword(response,keyword, 0) >=0) {
				switch( keyword ) {
				case "stuff": ChatbotMain.print(" ");  break;
				case "whatever": ChatbotMain.print("");  break;
				}

			}
		}
			int currentEmotion=ChatbotMain.chatbot.getAliceK().getEmotion();
			//ChatbotMain.chatbot.getAliceK().setEmotion(1);   
		
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
	}

}
