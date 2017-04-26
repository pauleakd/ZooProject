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
	
	public boolean sellTicket(Visitor visitor){
		if(visitor.buyTicket(ticketPrice) == true){
			budget += ticketPrice;
			visitors.add(visitor);
			System.out.println(visitor.getName() + " bought a ticket");
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
	
	private boolean animalExistsInEnclosure(Enclosure enclosure, String name){
		if (enclosure.getAnimals().get(name) != null) return true;
		
		else return false;
	}
	
	public Animal findAnimalInEnclosures(String name){
		Animal foundAnimal = null;
		for(Enclosure enclosure : enclosures){
			if(animalExistsInEnclosure(enclosure, name)){
					foundAnimal = enclosure.getAnimals().get(name);
					break;
				}
			}
		return foundAnimal;
	}
	
	public Animal findUnplacedAnimal(String name){
		Animal foundAnimal = null;
		foundAnimal = unplacedAnimals.get(name);
		return foundAnimal;
	}
	
	public boolean sellBabyAnimal(String name, Zoo buyingZoo){
		Animal animalToSell = findAnimalInEnclosures(name);
		if (buyingZoo.checkCanAffordAnimal(animalToSell) && animalToSell.beSold() == true) {
			budget += animalToSell.getPrice();
			removeAnimal(animalToSell);
			buyingZoo.buyBabyAnimal(animalToSell);
			System.out.println(animalToSell.name + " was sold to another zoo :( ");
			return true;
		}
		else return false;
	}

	private void buyBabyAnimal(Animal animal) {
		budget -= animal.getPrice();
		placeAnimalInEnclosure(animal);
	}

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
	
	public void addEnclosure(Enclosure enclosure){
		enclosures.add(enclosure);
	}
	
	public void createSuitableEnclosure(Animal animal){
		Enclosure enclosure = new Enclosure(animal.getPlotSize(), animal.getBiome());
		enclosure.addAnimal(animal);
		animal.setZoo(this);
		enclosures.add(enclosure);
	}

	public void placeAnimalInEnclosure(Animal animal) {
		for(Enclosure enclosure : enclosures){
			if (enclosure.getBiome() == animal.getBiome()){
				if(enclosure.getPlotSize()>= animal.getPlotSize()){
					enclosure.addAnimal(animal);
					animal.setZoo(this);
					return;
				}
				else {
					enclosure.expand(animal.getPlotSize() - enclosure.getPlotSize());
					enclosure.addAnimal(animal);
					animal.setZoo(this);
					return;
				}
			}
				
			}
		createSuitableEnclosure(animal);
		}
		
	
	public void removeDeadAnimalsFromZoo(){
		for(Enclosure enclosure : enclosures){
			ArrayList<String> animalToRemoveKeys = new ArrayList<String>();
			
			HashMap<String, Animal> animals = enclosure.getAnimals();
			
			for(String animalName : animals.keySet()) {
				
				Animal animal = animals.get(animalName);

				if(animal.getIsDead() == true) {
					animalToRemoveKeys.add(animalName);
				}
			}
			for(String animalToRemoveName : animalToRemoveKeys) {
				animals.remove(animalToRemoveName);
			}			
		}
	}
	
	public void returnAnimalToCageFromUnplacedAnimals(){
		for(Animal animal : unplacedAnimals.values()){
			this.placeAnimalInEnclosure(animal);
			System.out.println(animal.getName() + " was returned to the cage");
		}
		
		unplacedAnimals.clear();
	}
}
