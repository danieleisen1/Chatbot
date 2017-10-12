package chatbot;

public class ChatbotDanielE implements Topic {

	private String[] introKeywords;
	
	private String[] pathKeywords;
	
	private String terminateKeyword;
	
	private String oldResponse;
	
	private String newResponse;

	private boolean beginChat;
	
	private int intResponse;
	
	private String[] classSizeKeys;

	private String[] degreeKeys;

	
	public ChatbotDanielE() {
		
		pathKeywords = new String[] {"coursework","classwork","course","class","classes"};
		
		introKeywords = new String[] {"class size","degrees","degree"};
		
		terminateKeyword = "bye";
		
        oldResponse = "";
        
        beginChat = true;
        
        classSizeKeys = new String[] {"class size","class sizes","ratio","students"};
        
        degreeKeys = new String[] {"degree","degrees","major","concentration","majors","minor","minors"};
        
	}

	public void talk(String response) {
		
		if(beginChat == true) {
			
			ChatbotMain.print("Hey " + ChatbotMain.chatbot.getUsername() + ". I am the coursework bot. Unlike my emotional counterpart bots, I am usually nice and I love to play trivia games. If you want to terminate me, please say 'bye'. Otherwise, ask about our average class sizes, freedom of degrees and concentrations, or fun facts!");
			beginChat = false; 
			newResponse = ChatbotMain.getInput();
			continueTalk(newResponse);
			
		}
		else if(response.equals("")) {
			
			ChatbotMain.print("Can you ask me something else?");
			newResponse = ChatbotMain.getInput();
			checkIfRepeat(oldResponse, newResponse);
			continueTalk(newResponse);
			
		}
		else {
			
			ChatbotMain.print("Well, it was nice talking to you, "+ ChatbotMain.chatbot.getUsername() + "!" + "To go back to the main menu, type 'back'");
			response = ChatbotMain.getInput();
			
			if(response.toLowerCase().equals("back")){
				
				ChatbotMain.chatbot.startChatting();
				
			}
			
		}
		
		
	}
	public void continueTalk(String newResponse) {
		
		if(ChatbotMain.findKeyword(newResponse, terminateKeyword,0) == -1) {
			
			if(isTriggered(newResponse, introKeywords)) {
				
				if(isTriggered(newResponse, classSizeKeys)) {
					
					ChatbotMain.print("Our student:faculty ratio is 7:1. Game Time !!! Try to guess how many students the average class has at Harvard.");
					intResponse = ChatbotMain.getIntegerInput();
					
					if(intResponse < 40) {
						
						ChatbotMain.print("Sorry you are too low. The answer is 40 students.");
						
					}
					
					else if (intResponse > 40) {
						
						ChatbotMain.print("Sorry you are too high. The answer is 40 students.");
					}
					
					else if (intResponse == 40) {
						
						ChatbotMain.print("Congrats " + ChatbotMain.chatbot.getUsername() + "the answer is 40 students.");
					
					}
				
				}
				else if (isTriggered(newResponse, degreeKeys)) {
					
					if((ChatbotMain.findKeyword(newResponse,degreeKeys[0], 0) >=0) || (ChatbotMain.findKeyword(newResponse,degreeKeys[1], 0) >=0)) {
						
						ChatbotMain.print("Harvard offers graduate and undergraduate degree programs.");
					
					}
					else {
						
						ChatbotMain.print("Fun fact: Harvard does not use the term major. Instead it uses concentrations and minors");
						ChatbotMain.print("Harvard features tons of majors varying from computer science, to biology, to humanities!");
					
					}
				
				}
				else {
					
					ChatbotMain.print("Sorry I did not understand your input you wrote: " + newResponse + ". Ironically, I am still a dumb Harvard bot.");
					oldResponse = newResponse;
					talk("");
			
				
				}
			}
			
		}
		
		else {
		
			ChatbotMain.print("I'm sorry you had to say bye. Now I must terminate :(");
			System.exit(0);
		}
			
	}
	
		
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
}
	
