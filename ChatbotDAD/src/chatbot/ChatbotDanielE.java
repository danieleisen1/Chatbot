package chatbot;

public class ChatbotDanielE implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	public ChatbotDanielE() {
		keywords = new String[] {"classes","class","course","programs","foreign","medicine", "medical","computer",""};
		
		goodbyeKeyword = "bye";
		secretKeyword = "pug";
		response = "nothing";
	}

	public void talk(String response) {
		
		ChatbotMain.print("Hey. I am the coursework bot. If you want to terminate me, please say 'bye'. Otherwise I can give general information or answer any questions you have.");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword,0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword,0) >= 0) {
				ChatbotMain.print("I can't even. I love pugs so much. Wow. You are so cool.");
				response = ChatbotMain.getInput();
			}else {
				ChatbotMain.print("Yeah. That's pretty cool. But there are things I like even more. Tell me something else.");
				response = ChatbotMain.getInput();
			}
		}
		ChatbotMain.print("Well, it was nice talking to you, "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
	}
		
	// int currentEmotion=ChatbotMain.chatbot.getAliceK().getEmotion(); CREATING A COPY OF EMOTION
	//ChatbotMain.chatbot.getAliceK().setEmotion(1);     CHANGING THE EMOTION
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			//IMPORTANT (on the rubric)
			if(ChatbotMain.findKeyword(response, keywords[i],0) >= 0){
				return false;
			}
		}
		return false;
	}
	
	/*public boolean danielEisTriggered() {
		
	}
	
	public int askHowWasHighSchool() {
		ChatbotMain.print("How );
	}
*/
}
