package chatbot;

public class Chatbot {

	private String username;
	private boolean chatting;
	private ChatbotDanielE danielE;
	private ChatbotDanielM danielM;
	private ChatbotAliceK aliceK;
	
		
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
	
	public ChatbotDanielE getDanielE() {
		return danielE;
	}
	public ChatbotDanielM getDanielM() {
		return danielM;
	}
	public ChatbotAliceK getAliceK() {
		return aliceK;
	}
	
	public void startChatting() {
		//whenever you print or get input, use these methods
		ChatbotMain.print("Hi! I am an intelligent Harvard machine that can respond to any questions you might have. Let's start off by introducting ourselves. I am the HarvardBot5000. What is your name?");
		username = ChatbotMain.getInput();
		ChatbotMain.print("What would you like to talk about " + username + ". I specialize in coursework, admissions, and student life!");
		while(chatting) {
			
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
					ChatbotMain.print("I see you may not know how to spell. Please enter 1 for coursework, 2 for admissions, 3 for student life.");
					String responseCont = ChatbotMain.getInput();
						if(responseCont.equals("1")) {
							chatting= true;
							danielE.talk("");
						}
						else if(responseCont.equals("2")&& responseCont.equals("admissions") ) {
							chatting= true;
							danielM.talk("");
						}
						else if(responseCont.equals("3")) {
							chatting= true;
							aliceK.talk("");
						}
				
				
			}
		}
	}

}
