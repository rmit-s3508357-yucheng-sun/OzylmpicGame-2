/*
 * @author YI YANG s3520987
 */

public class WrongTypeException extends Exception{
	
	public WrongTypeException(){
		super("You should not add an athlete to a wrong type of game.");
	}
	
	public WrongTypeException(String msg){
		super(msg);
	}
	
	@Override
	public String toString(){
		return super.toString();
	}

}
