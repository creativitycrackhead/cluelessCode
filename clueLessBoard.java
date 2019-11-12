import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.math.*;
import java.util.Random;

public class clueLessBoard {

	static Scanner in = new Scanner(System.in);
	static String[] playerNames= new String[]{"zero","Player One","Player Two","Player Three","Player Four","Player Five","Player Six"};
	static String[] weapons = new String[] {"Kitchen Knife","Candle Stand","Revolver Gun","Syringe","Decorative Sword","Grenade"};
	static String[] roomsForDeckCreation = new String[] {"Study","Hall","Lounge","Library","Billiard Room","Dining Room","Conservatory","Ball Room","Kitchen"};
	
	
	static String[] [] rooms = new String[][] {{"Study","Hall","Lounge"},{"Library","Billiard Room","Dining Room"},{"Conservatory","Ball-Room","Kitchen"}};
	static String[] [] playableSpaces = new String[][] {{"Study","HallwaySH","Hall","HallwayHL","Lounge"},{"HallwaySL","NOTHING","HallwayHB","NOTHING","HallwayLD"},{"Library","HallwayLB","Billiard Room","HallwayBD","Dining Room"},{"HallwayLC","NOTHING","HallwayBB","NOTHING","HallwayDK"},{"Conservatory","HallwayCB","Ball-Room","HallwayBK","Kitchen"}};	
	static String[] characters = new String[] {"Miss Scarlet","Professor Plum","Col. Mustard","Mrs. Peacock","Mr. Green","Mrs. White"};
	static String[] takenPlayerNames = new String[] {"","","","","",""};
	static String[] solution = new String[] {"who","what","where"};
	static String[][] dealtHands = new String [6][7];
	static String[] playableDeck = new String [21];
	static int[][] playerPosition = new int[][] {{},{},{},{},{},{}};
	
	
	public static void main(String [] args) {
		
		
		int numPlayers = 0;
		numPlayers = establishPlayers();
		System.out.println("The number of players is :"+numPlayers);
		//String input;
		
		//input=in.nextLine();
		//playGame(numPlayers);
		
		
		/*
		System.out.println("Input numbers...");
		int j,k,l,m;
		j=in.nextInt();
		k=in.nextInt();
		l=in.nextInt();
		m=in.nextInt();
		boolean q = legalDistance(j,k,l,m);
		System.out.println("\n"+q+"\n");
		*/
		

		
		establishSolution(solution);
		for(int i=0;i<3;i++)
		{
			System.out.println(" "+solution[i]+" ");
		}
		System.out.println("\n\n\n");
		
		
		
		System.out.println("\n\n\n");
		 initPlayDeck();


		/* 
		for(int i=0;i<20;i++)
		{
			System.out.println(playableDeck[i]+"\n");
		}
		*/
	
		System.out.println("\n\n\n\n");
		
		playGame(numPlayers);
		//makeHands(numPlayers);
		//printHands(numPlayers);
		

	}
	

	


//Establishes how many players there are by asking the host
static int establishPlayers() {
	System.out.println("Please input the number of players...\n\tNumber of players should be between 3 - 6\n");
	int x = in.nextInt();
	return x;
	  
}

//Takes the location plot points to test the distance from one space to another to test how far it is
//to see if moving from one space to another is legal
static boolean legalDistance(int w, int x,int y,int z) {
	int u=0;
	u=Integer.valueOf((int) Math.ceil(Math.sqrt((Math.pow((w-y),2))+(Math.pow((x-z),2)))));
	if (u < 2)
		return true;
	else
		return false;
}

//establishes the solution in the "solution" array
//array defaults to {"who","what",where"}
static void establishSolution(String[] x) {
	Random random = new Random();
	random.setSeed(System.currentTimeMillis());
	
	double randomDouble = 0;
	int randomInteger = 0;
	
	while (randomDouble ==0)
		{
		//System.out.println(Math.random());
		randomDouble=(Math.round((Math.floor((Math.random()*10))%6)));
		}
	randomInteger=(int)randomDouble;
	x[0] = characters[randomInteger];
	
	
	randomDouble=(Math.round((Math.floor((Math.random()*10))%6)));
	randomInteger=(int)randomDouble;
	x[1] = weapons[randomInteger];
	
	randomDouble=(Math.round((Math.floor((Math.random()*10))%6)));
	randomInteger=(int)randomDouble;
	x[2] = rooms[(int)(Math.round((Math.floor((Math.random()*10))%3)))][(int)(Math.round((Math.floor((Math.random()*10))%3)))];
	
	
	
}

static void showBoard() {
	for (int i=0;i<5;i++)
	{
		{for(int j=0;j<5;j++)
		System.out.print(playableSpaces[i][j]+"\t\t");
	}System.out.println("\n");
	}
}

//this is the function that will run the game
// x will be the numPlayers
/*static void playGame(int x) {
	boolean gameBeingPlayed = true;
	String input;
	establishSolution(solution);
	int currentTurn=0;
	while(gameBeingPlayed == true) {
		if (currentTurn<1 || (currentTurn >x))
		currentTurn=1;
	
		System.out.println(playerNames[currentTurn]+"'s Turn");
		input=in.nextLine();
		currentTurn++;
	
	
	}
}
*/

static boolean inARoom(String roomName)
{	
	boolean isInARoom=false;
	boolean match=false;
	//while() {};
	
	return isInARoom;
}

static void initPlayDeck() {
	String [] temp = new String[] {};
	//init deck to " "
	for(int i=0;i<6;i++)
	{
		Arrays.asList(playableDeck).set(i, characters[i]);
	}
	
	for(int i=6;i<12;i++)
	{
		//Arrays.asList(playableDeck).set(i, " ");
		Arrays.asList(playableDeck).set(i, weapons[i-6]);
	}
	
	for(int i=12;i<21;i++)
	{
		Arrays.asList(playableDeck).set(i, roomsForDeckCreation[i-12]);
	}

	temp = RandomizeArray(playableDeck);
	System.arraycopy(temp, 0, playableDeck, 0, 21);
	
}
	
public static String[] RandomizeArray(String[] array){
	Random rgen = new Random();  // Random number generator			

	for (int i=0; i<array.length; i++) {
	    int randomPosition = rgen.nextInt(array.length);
	    String temp = array[i];
	    array[i] = array[randomPosition];
	    array[randomPosition] = temp;
	}

	return array;
}

static void makeHands(int numOfPlayers) {
	int cardCount=21;
	for(int j = 0;j<18/numOfPlayers;j++)
	
	{
		if((cardCount>=0) && (cardCount<22))
		{
			for(int i=0;i<numOfPlayers;i++)
			{
				while(cardCount>=21)
					cardCount--;
				if((cardCount>=0) && (cardCount<21))
				while(((Arrays.asList(solution)).contains(playableDeck[cardCount])))
				{
					cardCount--;
				}
				if(cardCount>=0) {
					dealtHands[i][j] = playableDeck[cardCount];
				cardCount--;
				}
				}
			}
		}
	
	if(cardCount>=0)
	for(int i=0;i<18%numOfPlayers;i++)
	{
		if(cardCount>=0)
		{
		while(Arrays.asList(solution).contains(playableDeck[cardCount]))
			cardCount--;
		if(cardCount>=0) {
		dealtHands[i][18/numOfPlayers] = playableDeck[cardCount];
		cardCount--;
		}
		}
	}
	
}

static void printHands(int numOfPlayers)
{
	System.out.println("Player Hands:\n");
	for(int i=0;i<numOfPlayers;i++)
	{
		System.out.println(playerNames[i+1]+":");
		for(int j=0;j<18/numOfPlayers+1;j++)
		{
			if(dealtHands[i][j]!=null)
			System.out.println(dealtHands[i][j]);
		}
		System.out.println("\n");

	}
}

	
static void playGame(int playerNum)
{
	makeHands(playerNum);
	while(true)
	{
		System.out.println("Enter action...");
		System.out.println("  1 - Show Board");
		System.out.println("  2 - Show Hands");
		System.out.println("  3 - Show Solution\n");

		int x = in.nextInt();
		System.out.println("\n");
		switch (x)
		{
		case 1:
			showBoard();
			break;
		case 2:
			printHands(playerNum);
			break;
		case 3:
			for(int i=0;i<3;i++)
			{
				System.out.println(" "+solution[i]+" ");
			}
			System.out.println("\n\n\n");
			break;
		default:
			break;
		}	
			System.out.println("\n");
			}	
	}
}