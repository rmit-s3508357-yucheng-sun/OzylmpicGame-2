/*
 * @author YI YANG s3520987
 */

public class NoRefreeException extends Exception{
	
	public NoRefreeException(){
		super("There is no refree appointed.");
	}
	
	public NoRefreeException(String msg){
		super(msg);
	}

	@Override
	public String toString(){
		return super.toString();
	}
	
}
