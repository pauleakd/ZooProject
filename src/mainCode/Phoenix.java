package mainCode;

public class Phoenix extends Animal {
	public Phoenix(String name, String gender, boolean maturity){
		super(name, gender, maturity);
		biome = BIOME.SAVANNAH;
		plotSize = 10;
		carnivoreStatus = false;
		nutritionalValue = 30;
		strength = 100;
		price = 100;
	}
	
	@Override
	public boolean eat(Animal food){
			System.out.println("Phoenix " + name +" is still hungry");
			return false;	
		}

	@Override 
	public boolean eat(Plant food){
		super.eat(food);
		System.out.println("Phoenix " + name + " " + "ate " + food.getName());
		return true;
		}
}
