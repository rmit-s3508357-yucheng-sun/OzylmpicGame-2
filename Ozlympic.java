import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Ozlympic {
	public static int selectedGame = 0;
	public static int selectedAthlete = 0;
	private static ArrayList<Game> games = new Generate().generateGames();
	
	/*display the menu of the game*/
	public static void displayMainMenu(){
		System.out.println("Ozlympic Game");
		System.out.println("============================");
		System.out.println("1. Select a game to run");
		System.out.println("2. Predict the winner of the game");
		System.out.println("3. Start the game");
		System.out.println("4. Display the final results of all games");
		System.out.println("5. Display the points of all athletes");
		System.out.println("6. Exit");
		System.out.println();
		System.out.print("Enter an option:");
	}
	
	public static void menu(){
		displayMainMenu();
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		switch(input){
		case 1:selectAGame();
		       menu();
		case 2:selectAAthlete();
			   menu();
		case 3:start();
		       menu();
		case 4:displayGameResult();
		       menu();
		case 5:displayAthleteResult();
				menu();
		case 6:System.exit(0);
		}
	}
	/* switch 5*/
	 private static void displayAthleteResult() {
		 System.out.println("The scores of every Athletes!");
		 System.out.println("ID" + "\t" + "name" + "\t" + "age" + "\t" + "state" + "\t" + "scorse");
		for(Game game : games){
			for(Athlete athlete:game.getAthletesOfGame()){
				System.out.println(athlete +"\t" + Integer.toString(athlete.getScores()));
			}
		}
		
	}
    /* switch 4*/
	private static void displayGameResult() {
		int[][] top = new int[6][8];
		for(Game game:games){
			top[games.indexOf(game)] = game.getReferee().summarise(game.getTimeOfAthletes());
		}
		
		if (top[selectedGame-1][0] == (selectedAthlete - 1) ){
			System.out.println("Congratulations!You get the right answer!");
		}else{
			System.out.println("You are wrong!");
		}
		for(int i = 0;i < 6;i++){
			Game g = games.get(i);
			System.out.println(g.getID() + "\t" + g.getType() + "\t");
			g.getAthletesOfGame().get(top[i][0]).addScores(5);
			g.getAthletesOfGame().get(top[i][1]).addScores(3);
			g.getAthletesOfGame().get(top[i][2]).addScores(1);
			for(int j = 0;j < g.getAthletesOfGame().size();j++){
				System.out.println((j + 1) + " ) " + g.getAthletesOfGame().get(top[i][j]));
			}
			
		}
	}
    /*switch 3*/
	private static void start() {
		for(Game game : games){
			game.start();
		}	
		System.out.println("All the games have fiished!");
	}
    
	/*switch 2*/
	private static void selectAAthlete() {
		int indexGame = selectedGame -1;
		Game selectedGame = games.get(indexGame);
		System.out.println(selectedGame.getID() + " the Athlete of the game: ");
		int j = 1;
		for(Athlete p : selectedGame.getAthletesOfGame()){
			System.out.println( (j++) + " ) " + p);
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Select an Athlete:");
		selectedAthlete = scanner.nextInt();
		System.out.println("Your choice is : " + selectedGame.getAthletesOfGame().get(selectedAthlete-1));
	}

	/*switch 1*/
	private static void selectAGame() {
		int i = 1;
		for(Game g : games){
			System.out.println(i++ + " ) " + g.getID() + "\t" + g.getType() );
		}
		System.out.println("Please Select a game: ");
		Scanner scanner = new Scanner(System.in);
		selectedGame = scanner.nextInt();
		System.out.println("Your choice is : " + games.get(selectedGame - 1).getID() );
	}

	
	
	public static void main(String[] args) {
		menu();
	}
	
}
