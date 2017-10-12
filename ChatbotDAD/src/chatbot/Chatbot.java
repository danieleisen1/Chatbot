package chatbot;

public class Chatbot {

	private String username;
	private boolean chatting;
	private ChatbotDanielE danielE;
	private ChatbotDanielM danielM;
	private ChatbotAliceK aliceK;
	private static int workflow = 0;
	// 1=danielE 2=danielM 3-aliceK
		
	public Chatbot() {
		danielE = new ChatbotDanielE();
		danielM = new ChatbotDanielM();
		aliceK = new ChatbotAliceK();
		username = "Unknown User";
		setChatting(true); 
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
		
		while( chatting ) {
			System.out.println( "DEBUG Chatbot main event loop -- about to read user's string" );
			String response = ChatbotMain.getInput();
			
			workflow = 0;
			
			
			if(danielE.pathTriggered(response) || response.equals( "1" )) {

				workflow=1;
				
				System.out.println( "DEBUG going into DanielE talk() ");
				
				setChatting(false); //exit the while loop. IMPORTANT TO KNOW BECAUSE YOU NEED TO EXIT WHILE LOOPS

				danielE.talk(response);
				
			}
			else if(danielM.isTriggered(response) || response.equals( "2") ) {
				workflow=2;
				System.out.println( "DEBUG going into DanielM talk() ");
				setChatting(false); //exit the while loop. IMPORTANT TO KNOW BECAUSE YOU NEED TO EXIT WHILE LOOPS

				danielM.talk(response);
				
			}
			else if(aliceK.isTriggered(response) || response.equals( "3" )) {

			//else if(aliceK.isTriggered(response)) {
				
				System.out.println( "DEBUG going into AliceK talk() ");
				
				workflow =3;
				
				setChatting( true );

				aliceK.talk(response);
				
			}
			else {
					ChatbotMain.print("I see you may not know how to spell. Please enter 1 for coursework, 2 for admissions, 3 for student life.");
					continue;
				
			}
		}
		
	}



	public static int getWorkFlow() {
		return workflow;
	}



	public boolean isChatting() {
		return chatting;
	}



	public void setChatting(boolean chatting) {
		this.chatting = chatting;
	}

}
