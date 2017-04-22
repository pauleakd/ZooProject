package mainCode;

import java.util.ArrayList;

public abstract class Animal {
	protected String name;
	protected String gender;
	protected boolean maturity;
	protected Integer happiness;
	protected Integer hunger;
	protected ArrayList<Edible> belly;
	protected BIOME biome;
	
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
	
	public String eat(Edible edible){
		return null;
	}

	public BIOME getBiome() {
		// TODO Auto-generated method stub
		return null;
	}
}
