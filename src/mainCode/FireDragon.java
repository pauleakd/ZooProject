package mainCode;

public class FireDragon extends Animal {
	
	public FireDragon(String name, String gender, boolean maturity){
		super(name, gender, maturity);
		biome = BIOME.SAVANNAH;
		plotSize = 50;
		carnivoreStatus = true;
		nutritionalValue = 200;
		strength = 300;
		price = 200;
	}
	
	@Override
	public boolean eat(Plant food){
			System.out.println("Fire Dragon " + name +" spits out the " + food.getName());
			return false;	
		}

	@Override 
	public boolean eat(Animal food){
		boolean result = super.eat(food);
		if (result==true){
			System.out.println("Fire Dragon " + name + " " + "ate " + food.getName());
			return true;}
		else return false;
		}

	
	}	
