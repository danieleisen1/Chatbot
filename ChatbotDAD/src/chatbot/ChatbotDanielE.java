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

	private String[] agreeKeys;

	
	public ChatbotDanielE() {
		
		pathKeywords = new String[] {"coursework","classwork","course","class","classes"};
		
		introKeywords = new String[] {"class size","class","classes","class sizes","degrees","degree","major","majors"};
		
		terminateKeyword = "bye";
		
        oldResponse = "";
        
        beginChat = true;
        
        classSizeKeys = new String[] {"class size","class", "average", "class sizes","ratio","students"};
        
        degreeKeys = new String[] {"degree","degrees","major","concentration","concentrations","majors","minor","minors"};
       
        agreeKeys = new String[] {"agreed","agree","sure","ok","fine","good","yes","okay"};
        
	}

	public void talk(String response) {
		
		if(beginChat == true) {
			
			ChatbotMain.print("Hey " + ChatbotMain.chatbot.getUsername() + ". I am the coursework bot. Unlike my emotional counterpart bots, I am usually nice and I love to play trivia games. If you want to terminate me, please say 'bye'. Otherwise, ask about our average class sizes and freedom of degrees and majors!");
			beginChat = false; 
			newResponse = ChatbotMain.getInput();
			continueTalk(newResponse);
			
		}
		else if(response.equals("")) {
			
			oldResponse = newResponse;
			ChatbotMain.print("Can you ask me something else?");
			newResponse = ChatbotMain.getInput().toLowerCase();
			
			if(checkIfRepeat(oldResponse, newResponse) == true) {
				
				ChatbotMain.print("Please enter something else. Your last input is very similar to this one.");
				talk("");
			}
			
			else{
				
				continueTalk(newResponse);
			}
			
		}
		else {
			
			ChatbotMain.print("Well, it was nice talking to you, "+ ChatbotMain.chatbot.getUsername() + "!" + "To go back to the main menu, type 'back'");
			response = ChatbotMain.getInput().toLowerCase();
			
			if(response.toLowerCase().equals("back")){
				
				ChatbotMain.chatbot.startChatting();
				
			}
			
		}
		
		
	}
	public void continueTalk(String newResponse) {
		
		this.newResponse = newResponse;
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
						
						ChatbotMain.print("Congrats " + ChatbotMain.chatbot.getUsername() + " the answer is 40 students.");
					
					}
					else if (ChatbotMain.findKeyword(newResponse, terminateKeyword,0) >= 0)
					{
						goodBye();
					}
					ChatbotMain.print("Would you like me to tell you about our degrees and majors?");
					newResponse = ChatbotMain.getInput().toLowerCase();
						if(isTriggered(newResponse, agreeKeys)) {
							continueTalk("degree");
						}
						else if(ChatbotMain.findKeyword(newResponse, terminateKeyword,0) >= 0) {
							
							goodBye();
						}
						else {
							ChatbotMain.print("Ok if you don't want to know about that, what would you like to talk about now?");
							newResponse = ChatbotMain.getInput().toLowerCase();
							continueTalk(newResponse);
						}
				
				}
				else if (isTriggered(newResponse, degreeKeys)) {
					
					if((ChatbotMain.findKeyword(newResponse,degreeKeys[0], 0) >=0) || (ChatbotMain.findKeyword(newResponse,degreeKeys[1], 0) >=0)) {
						
						ChatbotMain.print("Harvard offers graduate and undergraduate degree programs. Harvard University has 12 degree-granting schools in addition to the Radcliffe Institute for Advanced Study. The University has grown from nine students with a single master to an enrollment of more than 20,000 degree candidates including undergraduate, graduate, and professional students. Would you like to learn about our majors now?");
						newResponse = ChatbotMain.getInput().toLowerCase();
						if(isTriggered(newResponse, agreeKeys)) {
							continueTalk("major");
						}
						else if(ChatbotMain.findKeyword(newResponse, terminateKeyword,0) >= 0) {
							
							goodBye();
						}
					
					}
					else if(ChatbotMain.findKeyword(newResponse, terminateKeyword,0) >= 0) {
						
						goodBye();
					}
					else {
						
						ChatbotMain.print("Fun fact: Harvard does not use the term major. Instead it uses concentrations and minors");
						ChatbotMain.print("Harvard features tons of majors varying from computer science, to biology, to humanities! What interests you?");
						newResponse = ChatbotMain.getInput().toLowerCase();
						ChatbotMain.print("Surprisingly Harvard has: " + newResponse + ". In addition we have visual arts, african american studies, antrhopology, asian studies, economics, english, foreign language, history, literature, linguisitics, music studies, philosophy, psychology, political government, religious studies, women studies, biology, astronomy, chemistry, physics, natural sciences, engineering, and computer science.");
						ChatbotMain.print("Ok now that I have explained the majors, " + ChatbotMain.chatbot.getUsername() +  " ,what would you like to talk about now?");
						newResponse = ChatbotMain.getInput().toLowerCase();
						continueTalk(newResponse);
					}
				
				}
			}
				
			else {
					
					ChatbotMain.print("Sorry I did not understand your input you wrote: " + newResponse + ". Ironically, I am still a dumb Harvard bot.");
					talk("");
			
			}
			
			
		}
		else if(ChatbotMain.findKeyword(newResponse, terminateKeyword,0) >= 0) {
			
			goodBye();
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
	
	
	public boolean checkIfRepeat(String oldResponse, String newResponse) {
		
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
		
		if(count > (allNewWords.length + allOldWords.length) / 4) {
			
			return true;
		}
		else{
			
			return false;
		}
	}
	
	public void goodBye() {
		ChatbotMain.print("I'm sorry you had to say bye. Now I must terminate :(");
		System.exit(0);
	}
}
	
