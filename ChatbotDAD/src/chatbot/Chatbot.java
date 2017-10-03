package chatbot;

public class Chatbot {

	private String username;
	private boolean chatting;
	private Topic danielE;
	private Topic danielM;
	private Topic aliceK;
		
	public Chatbot() {
		danielE = new ChatbotDanielE();
		danielM = new ChatbotDanielM();
		aliceK = new ChatbotAliceK();
		username = "Unknown User";
		chatting = true; 
	}
	
	public String getUsername() {
		return username;
	}
	
	public Topic getDanielE() {
		return danielE;
	}
	public Topic getDanielM() {
		return danielM;
	}
	public Topic getAliceK() {
		return aliceK;
	}
	
	public void startChatting() {
		//whenever you print or get input, use these methods
		ChatbotMain.print("Hi! I am an intelligent Harvard machine that can respond to any questions you might have. Let's start off by introducting ourselves. I am the HarvardBot5000. What is your name?");
		username = ChatbotMain.getInput();
		
		while(chatting) {
			ChatbotMain.print("What would you like to talk about " + username + ". I specialize in Admissions, Coursework/Clubs, and Student Life!");
			String response = ChatbotMain.getInput();
			
			if(danielE.isTriggered(response)) {
				chatting = true; //exit the while loop. IMPORTANT TO KNOW BECAUSE YOU NEED TO EXIT WHILE LOOPS
				danielE.talk(response);
			}
			else if(danielM.isTriggered(response)) {
				chatting = true; //exit the while loop. IMPORTANT TO KNOW BECAUSE YOU NEED TO EXIT WHILE LOOPS
				danielM.talk(response);
			}
			else if(aliceK.isTriggered(response)) {
				chatting = true; //exit the while loop. IMPORTANT TO KNOW BECAUSE YOU NEED TO EXIT WHILE LOOPS
				aliceK.talk(response);
			}
			else {
				ChatbotMain.print("I'm sorry. I don't understand. I never said I was perfect.");
			}
		}
	}

}
