package mainCode;

public class Rabbit extends Animal {

	
	
	public Rabbit(String name, String gender, boolean maturity){
		super(name, gender, maturity);
		biome = BIOME.GRASSLANDS;
		plotSize = 20;
		carnivoreStatus = false;
		nutritionalValue = 70;
		strength = 50;
	}
	
	@Override
	public boolean eat(Animal food){
			System.out.println("Rabbit " + name +" is still hungry");
			return false;	
		}

	@Override 
	public boolean eat(Plant food){
		super.eat(food);
		System.out.println("Rabbit " + name + " " + "ate " + food.getName());
		return true;
		}
	
	

}
