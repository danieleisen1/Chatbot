package chatbot;

public class ChatbotDanielM implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;

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
		for( String keyword : keywords ) {
		if( response.contains( keyword )) {
				switch( keyword ) {
				case "stuff": ChatbotMain.print(" Alice: Yeah, some stuff man");  break;
				case "whatever": ChatbotMain.print("Alice: Talk more specifically, not just whatever");  break;
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
	}

}
