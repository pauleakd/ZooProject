package mainCode;

import java.util.ArrayList;
import java.util.HashMap;

public class Runner {
	
	public static void printZooStatus(Zoo zoo){
		ArrayList<Enclosure> enclosures = zoo.getEnclosures();
		
		for(Enclosure enclosure : enclosures){
			HashMap<String, Animal> animals = enclosure.getAnimals();
			
			System.out.println("This enclosure is " + enclosure.getBiome());
			
			if(animals.size() == 0){
				System.out.println("There are no animals here");
			}
			
			for(Animal currentAnimal : animals.values()){
				String animalDetails = currentAnimal.getClass().getSimpleName();
				System.out.println("The " + enclosure.getBiome() + " enclosure has " + animalDetails + " " + currentAnimal.getName());
			}
		}
		
	}

	public static void main(String[] args){
		Zoo zoo1 = new Zoo();
		Zoo zoo2 = new Zoo();
		zoo2.setBudget(1000);
		
		zoo2.addEnclosure(new Enclosure(100, BIOME.GRASSLANDS));
		
		Animal dragon = new FireDragon("Fluffy", "male", true);
		Animal unicorn = new Unicorn("Sparkles", "female", true);
		Animal phoenix = new Phoenix("Felix", "male", true);
		Animal babyPhoenix = new Phoenix("Dusty", "female", false);
		Animal seaSerpent = new SeaSerpent("Kraken", "female", true);
		Visitor visitor = new Visitor("Tony", "male", true, 200);
		Plant carrot = new Plant("Carrot", 5);
		

		
		zoo1.placeAnimalInEnclosure(dragon);
		zoo1.placeAnimalInEnclosure(unicorn);
		zoo1.placeAnimalInEnclosure(phoenix);
		zoo1.placeAnimalInEnclosure(babyPhoenix);
		zoo1.placeAnimalInEnclosure(seaSerpent);
		
	
		
		System.out.println("This is what is in Zoo1:");
		printZooStatus(zoo1);
		System.out.println("----------------------");
		
		System.out.println("This is what is in Zoo2:");
		printZooStatus(zoo2);
		
		System.out.println("----------------------");
		
		zoo1.sellTicket(visitor);
		
		zoo1.sellBabyAnimal(babyPhoenix.getName(), zoo2);
		
		zoo1.findAnimalInEnclosures(dragon.getName()).eat(carrot);
		
		zoo1.findAnimalInEnclosures(dragon.getName()).eat(unicorn);
		
		zoo1.removeDeadAnimalsFromZoo();
		
		zoo1.findAnimalInEnclosures(seaSerpent.getName()).rampage();
		
		zoo1.returnAnimalToCageFromUnplacedAnimals();
		
		System.out.println("----------------------");
		
		System.out.println("This is what is left in Zoo1:");
		
		printZooStatus(zoo1);
		
		System.out.println("----------------------");
		
		System.out.println("This is what is in Zoo2:");
		
		printZooStatus(zoo2);
		
		
	}
	
	
	
	
	
}
