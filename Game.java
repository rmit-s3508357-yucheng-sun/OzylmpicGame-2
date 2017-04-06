import java.util.ArrayList;
/*class of Game,it is abstract as we can not new Game();which game we don't it's type*/
public abstract class Game {
	//a ArrayList to store athlete of one game.
	private ArrayList<Athlete> athletesOfGame = new ArrayList<Athlete>();
	//a ArrayList to store athlete's time in the copete of one game.
	private ArrayList<Double> timesOfAthletes = new ArrayList<Double>();
	private String ID;
	private String type;
	private Official referee;    //a referee which is Official
	
	/*start the game,make the double create 
	 * by every athlete's compete method store in the ArrayList
	 */
	public void  start(){
		for(Athlete a : athletesOfGame){
			timesOfAthletes.add(a.compete(type));
		}
		System.out.println("********" + getID() + "******");
		System.out.println("ID\tName\tTime");
		for(int i = 0; i < athletesOfGame.size(); i++){
			System.out.println(athletesOfGame.get(i).getID() + "\t" + athletesOfGame.get(i).getName() 
					           + "\t" + timesOfAthletes.get(i));
		}
		System.out.println();
	}
	
	/*the methods of get/set*/
	public ArrayList<Double> getTimeOfAthletes() {
		return timesOfAthletes;
	}
	public ArrayList<Athlete> getAthletesOfGame() {
		return athletesOfGame;
	}
	public void setAthletesOfGame( ArrayList<Athlete> athletesOfGame) {
		this.athletesOfGame = athletesOfGame;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Official getReferee() {
		return referee;
	}
	public void setReferee(Official referee) {
		this.referee = referee;
	}
	
}	
