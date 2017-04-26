package mainCode;

import java.util.ArrayList;
import java.util.HashMap;

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
		
		ArrayList<Enclosure> enclosures = zoo1.getEnclosures();
		
		for(Enclosure enclosure : enclosures){
			HashMap<String, Animal> animals = enclosure.getAnimals();
			System.out.println("This enclosure is " + enclosure.getBiome());
			System.out.println(animals);
//			for( Animal currentAnimal : animals.values()){
//				
//				String animalDetails = currentAnimal.class.getSimpleName();
//				System.out.println("This enclosure has " + animalDetails);
//			}
		}
		
		zoo1.sellTicket(visitor);
		
		zoo1.sellBabyAnimal(babyPhoenix.getName(), zoo2);
		
		zoo1.findAnimalInEnclosures(dragon.getName()).eat(unicorn);
		
		zoo1.removeDeadAnimalsFromZoo();
		
		zoo1.findAnimalInEnclosures(seaSerpent.getName()).rampage();
		
		zoo1.returnAnimalToCageFromUnplacedAnimals();
			
		
	}
	
	
	
	
}
