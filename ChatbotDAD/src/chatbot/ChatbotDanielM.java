package chatbot;

public class ChatbotDanielM implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;

	public ChatbotDanielM() {
		String[] temp = {"stuff","things","whatever", "nothing"};
		keywords = temp;
		goodbyeKeyword= "bye";
		secretKeyword= "pug";
		response = "";
	}

	public void talk(String response)
	{
		ChatbotMain.print("Hey! So you want to talk about generic boring things, huh? I love talking about that. So tell me something.");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findkeyword(response, goodbyeKeyword, 0) == -1)
		{
			if(ChatbotMain.findkeyword(response, secretKeyword, 0) >=0)
			{
				ChatbotMain.print("I cant even. I love pugs so much. Wow. You are so cool.");
			}else
			{
				ChatbotMain.print("Yeah. Thats pretty cool. But there are thins I like even more. Tell me something else.");
			}
		}
		ChatbotMain.print("Well , it was nice talking to you, "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
	}
	public boolean isTriggered(String response)
	{
		for(int i =0;i< keywords.length;i++) 
		{
			if(ChatbotMain.findkeyword(response, keywords[i], 0)>=0)
			{
				return true;
			}
		}
		return false;
	}

}