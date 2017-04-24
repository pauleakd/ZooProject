package mainCode;

public class Lion extends Animal {
	
	public Lion(String name, String gender, boolean maturity){
		super(name, gender, maturity);
		biome = BIOME.SAVANAH;
		plotSize = 50;
		carnivoreStatus = true;
		nutritionalValue = 200;
		strength = 300;
		price = 200;
	}
	
	@Override
	public boolean eat(Plant food){
			System.out.println("Lion " + name +" is still hungry");
			return false;	
		}

	@Override 
	public boolean eat(Animal food){
		super.eat(food);
		System.out.println("Lion " + name + " " + "ate " + food.getName());
		return true;
		}

	
	}	
