package mainCode;

public class Visitor extends Animal implements Edible {
	
	private String name;
	private int money;
	
	
	public Visitor(String name, String gender, boolean maturity, int money) {
		super(name, gender, maturity);
		this.name = name;
		this.money = money;
		this.strength = 100;
		this.nutritionalValue = 150;
	}

	public String getName() {
		return this.name;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public boolean beEaten(int strength){
		if(strength >= this.strength){
			die();
			return true;
		}
		else return false;
	}
	public boolean buyTicket(int price){
		if(price < money){
			money -= price;
			return true;
		}
		
		return false;
	}
	
	public int getNutritionalValue() {
		return nutritionalValue;
	}

}
