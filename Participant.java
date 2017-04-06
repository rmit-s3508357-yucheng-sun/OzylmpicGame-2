public abstract class Participant {
	private String ID;
	private String name;
	private int age;
	private String state;
	
	/*constructor*/
	Participant(String ID,String name,int age,String state){
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.state = state;
	}
	/*override the method of toString*/
	public String toString(){
		return ID + "\t" + name + "\t" + age + "\t" + state ;
	}
	
	/*the methods of setter and getter*/
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
