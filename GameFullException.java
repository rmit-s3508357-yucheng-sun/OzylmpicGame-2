/*
 * @author YI YANG s3520987
 */

public class GameFullException extends Exception{
	
	public GameFullException(){
		super("There are more than 8 athletes in the game");
	}
	
	public GameFullException(String msg){
		super(msg);
	}
	
	@Override
	public String toString(){
		return super.toString();
	}

}
