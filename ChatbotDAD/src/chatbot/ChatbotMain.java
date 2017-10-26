package chatbot;

import java.util.Scanner;

public class ChatbotMain {
	
	public static final Chatbot chatbot = new Chatbot();
	public static Scanner inputSource = new Scanner(System.in);
	
	public static void main(String[] args) {

			chatbot.startChatting();
		
	}
	
	//Copied from class notes Utility Class
	/*
	 * 
	 * @param searchString
	 * @param keyword
	 * @param startPsn
	 * @return the index of the keyword after startPsn that is isolated and has no negations or -1 otherwise
	 *  
	 */
	
	public static int findKeyword(String searchString, String keyword, int startPsn) {
		//make lowercase
		
		//System.out.println( "DEBUG in findkeyword: searchString=" + searchString + " keyword=" + keyword );
		
		searchString = searchString.toLowerCase();
		keyword = keyword.toLowerCase();		
		
		int psn = searchString.indexOf(keyword, startPsn);
		
		while(psn >= 0) {
			if(keywordIsIsolated(psn,keyword,searchString) && (noNegations(searchString, psn) || searchString.equalsIgnoreCase("no"))) {
				//System.out.println( "DEBUG findKeyword found!");
				return psn;
			}else {
				psn=searchString.indexOf(keyword, psn+1);//returns the index of the NEXT keyword
				// System.out.println( "DEBUG inside else response" +  searchString.indexOf(keyword, psn+1) );
			}
		}
		
	//	System.out.println( "DEBUG findKeyword NOT NOT NOT NOT NOT NOT found!");
		
		return -1;
				
	}
		
		
	
	public static boolean keywordIsIsolated(int psn, String keyword, String s){
		if(psn + keyword.length() == s.length())
			return true;
		
		else if(s.substring(psn + keyword.length()+1).compareTo("a") < 0)
			return true;
		
		else if(s.substring(psn + keyword.length() + 1).equals(keyword + " "))
			return true;   
		
		return false;
	}
	
	 public static boolean noNegations(String s, int psn){
		 
		 if(chatbot.getWorkFlow() != 1 && chatbot.getWorkFlow() != 2 ) {
			 
			 return noNegationsAlice(s, psn);
			 
		 }
		 
		  return danielNoNegation(s, psn);
	  }

	private static boolean danielNoNegation(String s, int psn) {
		String not = "not";
		  String no = "no";
		  if(psn == 0) {
			  return true;
		  }
		  if(psn > 3 && not.equals(s.substring(psn-4,psn-1)) || no.equals(s.substring(psn-3, psn-1))) {
			  return false;
		  }
		  return true;
	}

	public static boolean noNegationsAlice(String s, int psn){
		String [] tokens = s.split(" ");
		for (String token : tokens) {
			if (token.toUpperCase().equals("NO") || token.toUpperCase().equals("NOT")) {
				return false;
			}
		}
		return true;
	} 


	public static String getInput(){
		return inputSource.nextLine().trim();
	}

	public static void print(String s){
		multiLinePrint(s);
	}

	public static void multiLinePrint(String s){
		String printString = "";
		int cutoff = 150;
		//this while loop last as long as there are words left in the original String
		while(s.length() > 0){

			String currentCut = "";
			String nextWord = "";

			//while the current cut is still less than the line length 
			//AND there are still words left to add
			while(currentCut.length()+nextWord.length() < cutoff && s.length() > 0){

				//add the next word
				currentCut += nextWord;

				//remove the word that was added from the original String
				s = s.substring(nextWord.length());

				//identify the following word, exclude the space
				int endOfWord = s.indexOf(" ");

				//if there are no more spaces, this is the last word, so add the whole thing
				if(endOfWord == -1) {
					endOfWord = s.length()-1;//subtract 1 because index of last letter is one les than length
				}

				//the next word should include the space
				nextWord = s.substring(0,endOfWord+1);
			}

			printString +=currentCut+"\n";

		}
		System.out.print(printString);
	}

	public static int getIntegerInput() {
		//print("Please enter an integer.");
		String integerString = getInput();
		boolean isInteger = false;
		int value = 0;
		while(!isInteger){
			try{
				value = Integer.parseInt(integerString);
				//will not continue if an error above is thrown
				isInteger = true;//exits loop if entry is valid
			}catch(NumberFormatException e){
				print("You must enter an integer. You better try again.");
				integerString = getInput();
			}
		}
		return value;
	}

}


