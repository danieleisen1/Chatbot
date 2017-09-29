package chatbot;

public class Chatbot {

	private String username;
	private boolean chatting;
	private Topic DanielE;
		
	public Chatbot() {
		DanielE = new ChatbotDanielE();
		username = "Unknown User";
		chatting = true; 
	}
	
	public String getUsername() {
		return username;
	}
	
	public Topic getDanielE() {
		return DanielE;
	}
	
	public void startChatting() {
		//whenever you print or get input, use these methods
		ChatbotMain.print("Hi! I am an intelligent machine that cna respond to your input. Tell me your name.");
		username = ChatbotMain.getInput();
		
		while(chatting) {
			ChatbotMain.print("What would you like to talk about");
			String response = ChatbotMain.getInput();
			
			if(DanielE.isTriggered(response)) {
				chatting = false; //exit the while loop. IMPORTANT TO KNOW BECAUSE YOU NEED TO EXIT WHILE LOOPS
				DanielE.talk(response);
			}else {
				ChatbotMain.print("I'm sorry. I don't understand. I never said I was perfect.");
			}
		}
	}

}
