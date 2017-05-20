/*
 * @author YI YANG s3520987
 */

public class TooFewAthleteException extends Exception{
	
	public TooFewAthleteException(){
		super("There is not enough athlete added to the game.");
	}
	
	public TooFewAthleteException(String msg){
		super(msg);
	}

	@Override
	public String toString(){
		return super.toString();
	}
	
}
