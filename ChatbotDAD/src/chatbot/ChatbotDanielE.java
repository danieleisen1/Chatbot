package chatbot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ChatbotDanielE implements Topic {

	private String[] introKeywords;
	private String[] pathKeywords;
	private String terminateKeyword;
	
	private String oldResponse;
	private String newResponse;

	private boolean beginChat;
	
	private String[] hiWords; 
	private String[] answerArrayToHello;
	private String response;
	private String introKeyword;
	
	public ChatbotDanielE() {
		pathKeywords = new String[] {"coursework","classwork","course","class","classes"};
		introKeywords = new String[] {"class size","degrees","degree"};
		terminateKeyword = "bye";
        oldResponse = "";
        beginChat = true;
		
		
		hiWords = new String[] {"hi","hello"};
		response = "nothing";
	}

	public void talk(String response) {
		if(beginChat == true) {
			ChatbotMain.print("Hey " + ChatbotMain.chatbot.getUsername() + ". I am the coursework bot. Unlike my emotional counterpart bots, I am nice unless you annoy me with the same question.  If you want to terminate me, please say 'bye'. Otherwise I can give general information or answer any questions you have. Ask about our average class sizes, freedom of degrees and concentrations, or fun facts!");
			beginChat = false; 
		}
		else if(response.equals("")) {
			ChatbotMain.print("Can you ask me something else?");
		}
		response = ChatbotMain.getInput();
		newResponse = response.toLowerCase();
		while(ChatbotMain.findKeyword(response, terminateKeyword,0) == -1) {
			if(isTriggered(response, introKeywords)) {
				if((ChatbotMain.findKeyword(response, "class sizes",0) >= 0) || (ChatbotMain.findKeyword(response, "class size",0) >= 0)) {
					ChatbotMain.print("Our student:faculty ratio is 7:1 with an average class of under 40 students");
					
				}
				else if ((ChatbotMain.findKeyword(response, "degree",0) >= 0)||(ChatbotMain.findKeyword(response, "degrees",0) >= 0)) {
				
				
			}
			else {
				ChatbotMain.print("Sorry I did not understand your input you wrote: " + newResponse + ". Ironically, I am still a dumb Harvard bot.");
				talk("");
			}
			}
		ChatbotMain.print("Well, it was nice talking to you, "+ ChatbotMain.chatbot.getUsername() + "!");
		}
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
	
	public boolean isTriggered(String response) {
		return isTriggered(response, pathKeywords);
	}
	
	
	public void checkIfRepeat(String oldResponse, String newResponse) {
		String[] allOldWords = oldResponse.split(" ");
		String[] allNewWords = newResponse.split(" ");
		int count = 0;
		for(int i = 0; i < allNewWords.length; i++) {
			for(int x = 0; i < allOldWords.length; i++) {
				if(allOldWords[x].equals(allNewWords[i])){
					count = count + 1;
				}
			}
		}
		if(count > (allNewWords.length + allOldWords.length) / 3) {
			ChatbotMain.print("Please enter something else. Your last input is very similar to this one.");
		}
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
