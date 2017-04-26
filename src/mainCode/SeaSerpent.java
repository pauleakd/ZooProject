package mainCode;

public class SeaSerpent extends Animal {
	public SeaSerpent(String name, String gender, boolean maturity){
		super(name, gender, maturity);
		biome = BIOME.OCEAN;
		plotSize = 200;
		carnivoreStatus = true;
		nutritionalValue = 500;
		strength = 400;
		price = 500;
	}
	
	@Override
	public boolean eat(Plant food){
		boolean result = super.eat(food);
		if (result==true){
			System.out.println("SeaSerpent " + name + " " + "ate " + food.getName());
			return true;}
		else return false;
		}

	@Override 
	public boolean eat(Animal food){
		boolean result = super.eat(food);
		if (result==true){
			System.out.println("SeaSerpent " + name + " " + "ate " + food.getName());
			return true;}
		else return false;
		}
}
