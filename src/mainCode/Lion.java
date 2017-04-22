package mainCode;

public class Lion extends Animal {
	
	public Lion(String name, String gender, boolean maturity){
		super(name, gender, maturity);
	}
	
	public String eat(Edible food){
		belly.add(food);
		int value = food.getNutritionalValue();
		hunger += value;
		return "Lion " + name + " " + "ate " + food.getName(); 
	}
}
