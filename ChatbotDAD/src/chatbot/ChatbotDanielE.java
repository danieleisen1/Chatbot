package chatbot;

public class ChatbotDanielE implements Topic {

	private String[] introKeywords;
	private String[] pathKeywords;
	private String terminateKeyword;
	
	private String[] keyArray;
	
	
	private String[] hiWords; 
	private String[] answerArrayToHello;
	private String response;
	private String introKeyword;
	
	public ChatbotDanielE() {
		pathKeywords = new String[] {"coursework","classwork","course","class","classes"};
		introKeywords = new String[] {"class size","degrees","degree"};
		terminateKeyword = "bye";
		
		//introKeyword = {"classes","class","course","programs","foreign","medicine", "medical","computer",""};
		
		hiWords = new String[] {"hi","hello"};
		response = "nothing";
	}

	public void talk(String response) {
		
		ChatbotMain.print("Hey. I am the coursework bot. Unlike my counterpart Admissions Bot, I am nice unless you get on my bad side.  If you want to terminate me, please say 'bye'. Otherwise I can give general information or answer any questions you have. Ask about our average class sizes, freedom of degrees and concentrations, or fun facts!");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, terminateKeyword,0) == -1) {
			if(isTriggered(response, introKeywords)) {
				if((ChatbotMain.findKeyword(response, "class size",0) >= 0)) {
					ChatbotMain.print("Our student:faculty ratio is 7:1 with an average class of under 40 students");
					
				}
				else if ((ChatbotMain.findKeyword(response, "degree",0) >= 0)||(ChatbotMain.findKeyword(response, "degrees",0) >= 0)) {
					
				}
				
				
				
				response = ChatbotMain.getInput();
			}
			else {
				ChatbotMain.print("Sorry I did not understand your question. Ironically, I am a dumb Harvard bot. Please say - restart - to reboot me.");
				response = ChatbotMain.getInput().toLowerCase();
				if(ChatbotMain.findKeyword(response, "restart", 0) >= 0) {
					
				}
				else {
					ChatbotMain.print("type restart");
				}
			}
		}
		ChatbotMain.print("Well, it was nice talking to you, "+ ChatbotMain.chatbot.getUsername() + "!");
	}
		
	// int currentEmotion=ChatbotMain.chatbot.getAliceK().getEmotion(); CREATING A COPY OF EMOTION
	//ChatbotMain.chatbot.getAliceK().setEmotion(1);     CHANGING THE EMOTION
	public boolean isTriggered(String response, String[] keyArray) {
		for(int i = 0; i < keyArray.length; i++) {
			//IMPORTANT (on the rubric)
			if(ChatbotMain.findKeyword(response, keyArray[i],0) >= 0){
				return true;
			}
		}
		return false;
	}
	
	public boolean pathTriggered(String response) {
		response = response.toLowerCase();
		return isTriggered(response, pathKeywords);
	}
	
	public void toSameCase(String x) {
		x = ChatbotMain.getInput(); 
		x = x.toLowerCase();
	}

	@Override
	public boolean isTriggered(String response) {
		return isTriggered(response, pathKeywords);
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
