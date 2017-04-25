package mainCode;

import java.util.ArrayList;
import java.util.HashMap;

public class Zoo {
	private ArrayList<Visitor> visitors;
	private int ticketPrice;
	private ArrayList<Enclosure> enclosures;
	private int budget;
	private HashMap<String, Animal> unplacedAnimals;
	
	public Zoo(){
		visitors = new ArrayList<Visitor>();
		ticketPrice = 20;
		enclosures = new ArrayList<Enclosure>();
		unplacedAnimals = new HashMap<String, Animal>();
		budget = 100;	
	}
	
	public ArrayList<Visitor> getVisitors(){
		return new ArrayList<Visitor>(visitors);
	}
	
	public ArrayList<Enclosure> getEnclosures(){
		return new ArrayList<Enclosure>(enclosures);
	}
	
	public int getTicketPrice(){
		return ticketPrice;
	}
	
	public void setTicketPrice(int newPrice){
		ticketPrice = newPrice;
	}
	
	public void addEnclosure(Enclosure enclosure){
		enclosures.add(enclosure);
	}
	
	public void createSuitableEnclosure(Animal animal){
		Enclosure enclosure = new Enclosure(animal.getPlotSize(), animal.getBiome());
		enclosures.add(enclosure);
		enclosure.addAnimal(animal);
	}
	
//	public boolean addToExistingEnclosure(Animal animal) {
//		
//	}
	
	public boolean sellTicket(Visitor visitor){
		if(visitor.buyTicket(ticketPrice) == true){
		budget += ticketPrice;
		visitors.add(visitor);
		return true;
		}
		else return false;
		}

	public int getBudget() {
		return budget;
	}
	
	public void removeAnimal(Animal animal){
		for(Enclosure enclosure : enclosures){
			enclosure.removeAnimal(animal);
		}
	}
	
	public void addAnimalToZoo(Animal animal){
		unplacedAnimals.put(animal.getName(),animal);
	}
	
	public Animal findAnimalInEnclosures(String name){
		Animal foundAnimal = null;
		for(Enclosure enclosure : enclosures){
			foundAnimal = enclosure.getAnimals().get(name);
		}
		return foundAnimal;
	}
	
	public Animal findUnplacedAnimal(String name){
		Animal foundAnimal = null;
		foundAnimal = unplacedAnimals.get(name);
		return foundAnimal;
	}
	
	
	
//	public boolean sellBabyAnimal(Animal animal, Zoo buyingZoo){
//		if (buyingZoo.buyBabyAnimal(animal) && animal.beSold() == true) {
//			budget += animal.getPrice();
//			removeAnimal(animal);
//			return true;
//			buyingZoo.buyBabyAnimal(animal);
//			
//		}
//		else return false;
//	}

	public void setBudget(int amount) {
		budget = amount;
		
	}

	public boolean checkCanAffordAnimal(Animal animal) {
		if(budget >= animal.getPrice()) return true;
		else return false;
	}

	public HashMap<String, Animal> getUnplacedAnimals() {
		
		return unplacedAnimals;
	}

	public void placeAnimalInEnclosure(Animal animal) {
		for(Enclosure enclosure : enclosures){
			if (enclosure.getBiome() == animal.getBiome()){
				if(enclosure.getPlotSize()>= animal.getPlotSize()){
					enclosure.addAnimal(animal);
				}
				else {
					enclosure.expand(animal.getPlotSize());
					enclosure.addAnimal(animal);
				}
			}
			else {
				createSuitableEnclosure(animal);
			}
		}
	}
}
