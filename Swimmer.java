/*
 * @author YI YANG s3520987
 */

import java.util.Random;

/*swimer*/
class Swimmer extends Athlete {
	Swimmer(String ID, String name, int age, String state) {
		super(ID, name, age, state);
	}
	/*generate a double between 100 - 200*/
	@Override
	public double compete(String s) {
		double result =new Random().nextDouble() * 100 + 100;
		return result;
	}
}

/*cyclist*/
class Cyclist extends Athlete{

	Cyclist(String ID, String name, int age, String state) {
		super(ID, name, age, state);
	}
    /*generate a double between 500 - 800*/
	@Override
	public double compete(String s) {
		double result = new Random().nextDouble() * 300 + 500;
		return result;
	}
	
}

/*sprinter*/
class Sprinter extends Athlete{

	Sprinter(String ID, String name, int age, String state) {
		super(ID, name, age, state);
	}
	/*generate a double between 10 - 20*/
	@Override
	public double compete(String s) {
		double result = new Random().nextDouble() * 10 + 10;
		return result;
	}
}

/*superAthlete*/
class SuperAthlete extends Athlete{

	SuperAthlete(String ID, String name, int age, String state) {
		super(ID, name, age, state);
	}
	/*generate a double number depend on the String s*/
	@Override
	public double compete(String s) {
		
		if(s.equals("Swim")){
			return  new Random().nextDouble() * 100 + 100;
		}else if(s.equals("Clcly")){
			return  new Random().nextDouble() * 300 + 500;
		}else{
			return new Random().nextDouble() * 10 + 10;
		}
		
	}
	
}