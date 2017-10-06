package chatbot;

public class ChatbotDanielE implements Topic {

	private String mainKeyword;
	private String[] introKeywords;
	private String goodbyeKeyword;
	private String[] hiWords; 
	private String[] answerArrayToHello;
	private String response;
	private String introKeyword;
	
	public ChatbotDanielE() {
		mainKeyword = "coursework";
		//introKeywords = new String[] {"admission","admissions"}
		//introKeyword = {"classes","class","course","programs","foreign","medicine", "medical","computer",""};
		answerArrayToHello = new String[] {"Hi, we have already met", "YES! HELLOOOOO","Seriously, you are getting annoying.", "bye" +"."};
		goodbyeKeyword = "bye";
		hiWords = new String[] {"hi","hello"};
		response = "nothing";
	}

	public void talk(String response) {
		
		ChatbotMain.print("Hey. I am the coursework bot. Unlike my counterpart Admissions Bot, I am nice unless you get on my bad side.  If you want to terminate me, please say 'bye'. Otherwise I can give general information or answer any questions you have.");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword,0) == -1) {
			if(ChatbotMain.findKeyword(response, "Hi",0) >= 0) {
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
		for(int i = 0; i < hiWords.length; i++) {
			//IMPORTANT (on the rubric)
			if(ChatbotMain.findKeyword(response, hiWords[i],0) >= 0){
				return false;
			}
		}
		return false;
	}
	
	public boolean pathTriggered(String response) {
		for(int i = 0; i < introKeywords.length; i++) {
			//IMPORTANT (on the rubric)
			if(ChatbotMain.findKeyword(response, introKeywords[i],0) >= 0){
				return false;
			}
		}
		return false;
	}
	
	public void toSameCase(String x) {
		x = ChatbotMain.getInput(); 
		x = x.toLowerCase();
	}
	
	//public boolean helloTooMuch(String response) {
//		for(int i=0; i < hiWords.length; i++) {
			
	//	}
	}
	
	/*public boolean danielEisTriggered() {
		
	}
	
	public int askHowWasHighSchool() {
		ChatbotMain.print("How );
	}
*/
//}
