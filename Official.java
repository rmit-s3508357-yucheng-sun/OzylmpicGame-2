/*
 * @author YI YANG s3520987
 */

import java.util.ArrayList;

public class Official extends Participant {
	//constructor
	Official(String ID, String name, int age, String state) {
		super(ID, name, age, state);
	}

	/*
	 * call the time list of every athlete,and return a int[i]
	 * i is the length of the ArrayList
	 * the top store the index of the first,second,thrid...Athlete
	 */
	public static int[] summarise(ArrayList<Double> list){
		int i = 0;
		ArrayList<Double> copy = new ArrayList<Double>();
		for(double b : list){
			copy.add(b);
			i++;
		}
		int[] top = new int[i];
		copy.sort(null);
		
		for(int j = 0; j < i ;j++){
			top[j] = list.indexOf(copy.get(j));
		}
				
		return top;
	}
	
}
