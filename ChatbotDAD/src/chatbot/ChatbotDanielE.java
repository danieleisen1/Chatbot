package chatbot;

public class ChatbotDanielE implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	public ChatbotDanielE() {
		String[] temp = {"dane_stuff","dane_things","dane_whatever","dane_nothing"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "pug";
		response = "nothing";
	}

	public void talk(String response) {
		ChatbotMain.print("Hey. So you want to talk about generic boring things, huh? I love talking about that. So tell me something.");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword,0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword,0) >= 0) {
				ChatbotMain.print("I can't even. I love pugs so much. Wow. You are so cool.");
				response = ChatbotMain.getInput();
			}else {
				ChatbotMain.print("Yeah. That's pretty cool. But there are things I like even more. Tell me something else.");
			}
		}
		ChatbotMain.print("Well, it was nice talking to you, "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
	}
		
	
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			//IMPORTANT (on the rubric)
			if(ChatbotMain.findKeyword(response, keywords[i],0) >= 0){
				return true;
			}
		}
		return false;
	}

}
