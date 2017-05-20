/*
 * @author YI YANG s3520987
 */

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OzalympicGame {
	public static int selectedGame = 0;
	public static int selectedAthlete = 0;
	private static ArrayList<Game> games = new Generate().generateGames();
	
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
	
	public static void menu() throws Exception{
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
	private static void displayGameResult() throws Exception {
		int[][] top = new int[6][3];
		for(Game game:games){
			top[games.indexOf(game)] = game.getReferee().summarise(game.getTimeOfAthletes());
		}
		
		try {
            if (top[selectedGame-1][0] == (selectedAthlete - 1) ){
            	System.out.println("Congratulations!You get the right answer!");
            }else{
            	System.out.println("You are wrong!");
            }
        } catch (Exception e) {
        }
		for(int i = 0;i < 6;i++){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Game g = games.get(i);
			System.out.println(g.getID() + "\t" + g.getType() + "\t");
//			WriteFileUtils.writeFile(g.getID() + "\t" + g.getReferee().getID() + "\t" + df.format(new Date()) + "\r\n");
			System.out.println("First :" + g.getAthletesOfGame().get(top[i][0]));
//			WriteFileUtils.writeFile("First :" + g.getAthletesOfGame().get(top[i][0]) + "\r\n");
			g.getAthletesOfGame().get(top[i][0]).addScores(5);
			System.out.println("Second :" + g.getAthletesOfGame().get(top[i][1]));
//			WriteFileUtils.writeFile("Second :" + g.getAthletesOfGame().get(top[i][1]) + "\r\n");
			g.getAthletesOfGame().get(top[i][1]).addScores(3);
			System.out.println("Thrid :" + g.getAthletesOfGame().get(top[i][2]));
//			WriteFileUtils.writeFile("Thrid :" + g.getAthletesOfGame().get(top[i][2]) + "\r\n");
			g.getAthletesOfGame().get(top[i][2]).addScores(1);
		}
		 StringBuilder sb = new StringBuilder();
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
	        for (int i = 0; i < 6; i++) {
	            if (i == selectedGame) {
	                Game g = games.get(i);
	                ArrayList<Double> timeOfAthletes = g.getTimeOfAthletes();

	                sb.append(g.getID() + "," + g.getReferee().getID() + "," + df.format(new Date()) + "\n");
	                for (int j = 0; j < 6; j++) {
	                    Athlete athlete = g.getAthletesOfGame().get(top[i][j]);
	                    sb.append(athlete.getID() + "," + String.format("%.1f", timeOfAthletes.get(j)) + "," + athlete.getScores() + "\n");
	                }
	            }
	        }
	        sb.append("\n");
	        try {
	            WriteFileUtils.writeFile(sb.toString());
	        } catch (Exception ex) {
	            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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

	
	
	public static void main(String[] args) throws Exception {
		menu();
	}
	
}
