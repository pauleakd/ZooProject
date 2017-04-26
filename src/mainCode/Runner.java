package mainCode;

public class Runner {

	public static void main(String[] args){
		Zoo zoo1 = new Zoo();
		Zoo zoo2 = new Zoo();
		zoo2.setBudget(1000);
		
		
		Animal dragon = new FireDragon("Fluffy", "male", true);
		Animal unicorn = new Unicorn("Helleborine", "female", true);
		Animal phoenix = new Phoenix("Felix", "male", true);
		Animal babyPhoenix = new Phoenix("Dusty", "female", false);
		Animal seaSerpent = new SeaSerpent("Kraken", "female", true);
		Visitor visitor = new Visitor("Tony", "male", true, 200);
		

		
		zoo1.placeAnimalInEnclosure(dragon);
		zoo1.placeAnimalInEnclosure(unicorn);
		zoo1.placeAnimalInEnclosure(phoenix);
		zoo1.placeAnimalInEnclosure(babyPhoenix);
		zoo1.placeAnimalInEnclosure(seaSerpent);
		
		
		zoo1.sellTicket(visitor);
		
		zoo1.sellBabyAnimal(babyPhoenix.getName(), zoo2);
		
		zoo1.findAnimalInEnclosures(dragon.getName()).eat(unicorn);
		
		zoo1.removeDeadAnimalsFromZoo();
		
		zoo1.findAnimalInEnclosures(seaSerpent.getName()).rampage();
		
		zoo1.returnAnimalToCageFromUnplacedAnimals();
			
		
	}
	
	
	
	
}
