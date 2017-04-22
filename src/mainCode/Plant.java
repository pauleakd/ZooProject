package mainCode;
public class Plant implements Edible {
	
	private String name;
	private int nutritionalValue;
	
	
	public Plant(String name, int nutritionalValue){
		this.name = name;	
		this.nutritionalValue = nutritionalValue;
	}

	public boolean beEaten(int strength) {
		return true;
	}
	
	public int getNutritionalValue() {
		return nutritionalValue;
	}
	
	

}

	
