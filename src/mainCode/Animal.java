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
	protected int price;
	protected boolean isDead; 
	protected Zoo zoo;
	
	public Animal(String name, String gender, boolean maturity) {
		this.name = name;
		this.gender = gender;
		this.maturity = maturity;
		happiness = 50;
		hunger = 50;
		belly = new ArrayList<Edible>();
		isDead = false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void growUp(){
		this.maturity = true;
	}
	
	public boolean getIsDead(){
		return this.isDead;
	}
	
	public void die(){
		isDead = true;
	}
	
	public boolean isAdult(){
		return this.maturity;
	}
	
	public int checkHunger(){
		return hunger;
	}
	
	public void beActive(){
		hunger -=20;
		happiness += 10;
	}
	
	public boolean eat(Animal food){
		boolean result = food.beEaten(strength);
		if(result == true){
		belly.add(food);
		int value = food.getNutritionalValue();
		hunger += value;
		return true;}
		else return false;
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
	
	public boolean beEaten(int strength) {
		if(this.strength > strength){
			return false;}
		else {
			die();
			return true;
		}
	}
	
	public boolean beSold(){
		if(maturity == false){
			return true;
		}
		else return false;
	}

	public int getPrice() {
		return price;
	}
	
	public Zoo getZoo(){
		return this.zoo;
	}

	public void setZoo(Zoo zoo) {
		this.zoo = zoo;
	}	
	
	public void rampage(){
		System.out.println( this.getClass().getSimpleName() + " " + name + " going on RAMPAGE!");
		zoo.removeAnimal(this);
		zoo.addAnimalToZoo(this);
		Visitor visitor2 = zoo.getVisitors().get(0);
		eat(visitor2);
	}
}
