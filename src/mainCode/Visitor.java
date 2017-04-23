package mainCode;

public class Visitor {
	
	private String name;
	private int money;

	public Visitor(String name, int money) {
		this.name = name;
		this.money = money;
	}

	public String getName() {
		return this.name;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public boolean buyTicket(int price){
		if(price < money){
			money -= price;
			return true;
		}
		
		return false;
	}

}
