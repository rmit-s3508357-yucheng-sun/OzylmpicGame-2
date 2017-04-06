/*abstract class Athlete,extends the class Participant*/
public abstract class Athlete extends Participant {
	//denfine the scores,which will be added when the Athlete reach the top 3
	private int scores;
	
	Athlete(String ID, String name, int age, String state) {
		super(ID, name, age, state);
		this.scores = 0;
	}
   
	//declare the abstract method compete
	public abstract double compete(String s);

	/*the method of set/get*/
	public int getScores() {
		return scores;
	}
	public void addScores(int scores) {
		this.scores += scores;
	}
	
}
