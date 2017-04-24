package mainCode;

import java.util.ArrayList;

public abstract class Animal implements Edible {
	protected String name;
	protected String gender;
	protected boolean maturity;
	protected Integer happiness;
	protected Integer hunger;
	protected ArrayList<Edible> belly;
	protected BIOME biome;
	protected int plotSize;
	protected boolean carnivoreStatus;
	protected int nutritionalValue;
	protected int strength;
	
	public Animal(String name, String gender, boolean maturity) {
		this.name = name;
		this.gender = gender;
		this.maturity = maturity;
		happiness = 50;
		hunger = 50;
		belly = new ArrayList<Edible>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void growUp(){
		this.maturity = true;
	}
	
	public boolean isAdult(){
		return this.maturity;
	}
	
	public int checkHunger(){
		return hunger;
	}
	
	public boolean eat(Animal food){
		belly.add(food);
		int value = food.getNutritionalValue();
		hunger += value;
		return true;
	}
	
	public boolean eat(Plant edible){
		belly.add(edible);
		int value = edible.getNutritionalValue();
		hunger += value;
		return true;
		
	}

	public BIOME getBiome() {
		return biome;
	}
	
	public int getPlotSize(){
		return plotSize;
	}
	
	public boolean getCarvinoreStatus(){
		return carnivoreStatus;
	}
	
	public int getNutritionalValue(){
		return nutritionalValue;
	}
}
