public class Person {
	private int condition;
	private String name;
	
	public Person(String name, int condition){
		this.name = name;
		this.condition = condition;
	}
	
	public String toString(){
		return name + " " + condition;
	}
	
	public int getCondition() {
		return condition;
	}
	public String getName() {
		return name;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
