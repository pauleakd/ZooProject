package mainCode;

import java.util.ArrayList;
import java.util.HashMap;



public class Enclosure {
	
	
	
	private HashMap<String, Animal> animals;
	private Integer plotSize;
	private BIOME biome;
	
	public Enclosure(int plotSize, BIOME biome){
		animals = new HashMap<String, Animal>();
		this.plotSize = plotSize;
		this.biome = biome;
	}
	
	public HashMap<String, Animal> getAnimals(){
		return animals;
	}
	
	public BIOME getBiome(){
		return this.biome;
	}
	
	public boolean addAnimal(Animal animal){
		if (animal.getBiome() == biome && animal.getPlotSize() < plotSize){
			animals.put(animal.getName(), animal);
			plotSize -= animal.getPlotSize();
			return true;
		}
		return false;
	}

	public int getPlotSize() {
		return plotSize;
	}

	public void removeAnimal(Animal animal) {
		animals.remove(animal.getName());
	}
}
