package mainCode;

public class Unicorn extends Animal {

	
	
	public Unicorn(String name, String gender, boolean maturity){
		super(name, gender, maturity);
		biome = BIOME.GRASSLANDS;
		plotSize = 20;
		carnivoreStatus = false;
		nutritionalValue = 70;
		strength = 50;
	}
	
	@Override
	public boolean eat(Animal food){
			System.out.println("Unicorn " + name +" is still hungry");
			return false;	
		}

	@Override 
	public boolean eat(Plant food){
		super.eat(food);
		System.out.println("Unicorn " + name + " " + "ate " + food.getName());
		return true;
		}
	
	

}
