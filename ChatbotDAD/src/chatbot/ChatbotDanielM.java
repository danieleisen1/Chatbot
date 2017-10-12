package chatbot;

public class ChatbotDanielM implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private int actScore;
	private int satScore;
	private int gpa;
	private int currentEmotion;
	

	public ChatbotDanielM() {
		String[] temp = {"admissions", "admission","SAT","GPA", "grades","essays","essay", "supplement","financial aid","acceptance rate","regular admissions","early admission" };
		keywords = temp;
		goodbyeKeyword= "bye";
		secretKeyword= "pug";
		response = "";


	}

	public void talk(String response)
	{
		/**ChatbotMain.print("Hey! So you want to talk about generic boring things, huh? I love talking about that. So tell me something.");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1)
		{
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >=0)
			{
				ChatbotMain.print("I cant even. I love pugs so much. Wow. You are so cool.");
			}else
			{
				ChatbotMain.print("Yeah. Thats pretty cool. But there are thins I like even more. Tell me something else.");
			}
		}
		ChatbotMain.print("Well , it was nice talking to you, "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
		 */
		
		ChatbotMain.print("Hey, this is the admission bot and I have a few questions for you about getting into Harvard. First, Did you take an ACT test or SAT test?");
		ChatbotMain.print("Say bye if you dont want to talk anymore");
		response = ChatbotMain.getInput();
		if(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1)
		{
			if(ChatbotMain.findKeyword(response,"act", 0) >=0)
			{
				ChatbotMain.print("What is your ACT score");
				actScore = ChatbotMain.getIntegerInput();
				if(actScore>=0 && actScore<=36)
				{
					testScore(actScore,30, 36,"HAHAHAHA, thats terrible, Retake it immediatly if you wanna go to Harvard would you apply early or regular "+ChatbotMain.chatbot.getUsername()+",but what is your GPA", "You are on the right track to get into harvard " +ChatbotMain.chatbot.getUsername()+", would you apply early or regular");
					gpa = ChatbotMain.getIntegerInput();
					testScore(gpa,90,100,"HAHAHAHA, thats terrible, Retake it immediatly if you wanna go to Harvard would you apply early or regular", "You are on the right track to get into harvard " +ChatbotMain.chatbot.getUsername()+", would you apply early or regular");	
				}
				else
				{
					ChatbotMain.print("Please enter a number between 0 and 36");
					actScore = ChatbotMain.getIntegerInput();
					testScore(actScore,30, 36,"HAHAHAHA, thats terrible, Retake it immediatly if you wanna go to Harvard "+ChatbotMain.chatbot.getUsername()+",would you apply early or regular", "You are on the right track to get into harvard " +ChatbotMain.chatbot.getUsername()+", would you apply early or regular");
					gpa = ChatbotMain.getIntegerInput();
					testScore(gpa,90,100,"HAHAHAHA, thats terrible, Retake it immediatly if you wanna go to Harvard, would you apply early or regular", "You are on the right track to get into harvard " +ChatbotMain.chatbot.getUsername()+", but what is your essay");	
				}
			}	
				if(ChatbotMain.findKeyword(response,"sat", 0) >=0)
				{
					ChatbotMain.print("What is your SAT score");
					satScore = ChatbotMain.getIntegerInput();
					if(satScore>=0 && satScore<=1600)
					{
						testScore(satScore,1400, 1600,"HAHAHAHA, thats terrible, Retake it immediatly if you wanna go to Harvard "+ChatbotMain.chatbot.getUsername()+",would you apply early or regular", "You are on the right track to get into harvard " +ChatbotMain.chatbot.getUsername()+", would you apply early or regular");
						gpa = ChatbotMain.getIntegerInput();
						testScore(gpa,90,100,"HAHAHAHA, thats terrible, Retake it immediatly if you wanna go to Harvard, would you apply early or regular", "You are on the right track to get into harvard " +ChatbotMain.chatbot.getUsername()+", but what is your essay");
					}
					else
					{
						ChatbotMain.print("Please enter a number between 0 and 36");
						satScore = ChatbotMain.getIntegerInput();
						testScore(satScore,1400, 1600,"HAHAHAHA, thats terrible, Retake it immediatly if you wanna go to Harvard "+ChatbotMain.chatbot.getUsername()+",would you apply early or regular", "You are on the right track to get into harvard " +ChatbotMain.chatbot.getUsername()+", would you apply early or regular");
						gpa = ChatbotMain.getIntegerInput();
						testScore(gpa,90,100,"HAHAHAHA, thats terrible, Retake it immediatly if you wanna go to Harvard, would you apply early or regular", "You are on the right track to get into harvard " +ChatbotMain.chatbot.getUsername()+", would you apply early or regular");	
					}	
					
				}
				
				
				
			



				for( String keyword : keywords ) {
					if(ChatbotMain.findKeyword(response,keyword, 0) >=0) {
						switch( keyword ) {
						case "stuff": ChatbotMain.print(" ");  break;
						case "whatever": ChatbotMain.print("");  break;
						}

					}
				}
				int currentEmotion=ChatbotMain.chatbot.getAliceK().getEmotion();
				//ChatbotMain.chatbot.getAliceK().setEmotion(1);   
				if(currentEmotion==-3)
				{
					ChatbotMain.print("Since you hate it so much you are not getting, try for other schools");
				}
				if(currentEmotion==3)
				{
					ChatbotMain.print("Since you like it so much, I think you should apply");
				}
			}
		else {	
		ChatbotMain.print("Thanks for the talk "+ChatbotMain.chatbot.getUsername());
			ChatbotMain.chatbot.startChatting();
		}
		}
	
		public void testScore(int test,int scoreLow, int scoreHigh, String botResponse,String botResponse2)//Helper Method
		{
			if(test<=scoreLow)

			{
				ChatbotMain.print(botResponse);
			}
			if(test>=scoreLow && test<=scoreHigh)
			{
				ChatbotMain.print(botResponse2);
			}
		}

		public boolean isTriggered(String response)
		{
			for(int i =0;i< keywords.length;i++) 
			{
				if(ChatbotMain.findKeyword(response, keywords[i], 0)>=0)
				{
					return true;
				}
			}
			return false;
		}

	}
