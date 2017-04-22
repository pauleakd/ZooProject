package mainCode;

public class Lion extends Animal {
	
	public Lion(String name, String gender, boolean maturity){
		super(name, gender, maturity);
		biome = BIOME.SAVANAH;
		plotSize = 50;
	}
	
	@Override
	public String eat(Edible food){
		belly.add(food);
		int value = food.getNutritionalValue();
		hunger += value;
		return "Lion " + name + " " + "ate " + food.getName(); 
	}
	
	@Override
	public BIOME getBiome() {
		return biome;
	}
	
	@Override
	public int getPlotSize() {
		return plotSize;
	}
}
