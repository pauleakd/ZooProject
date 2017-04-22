package mainCode;

import java.util.ArrayList;

public class Enclosure {
	private ArrayList<Animal> animals;
	private Integer plotSize;
	private BIOME biome;
	
	public Enclosure(int plotSize, BIOME biome){
		animals = new ArrayList<Animal>();
		this.plotSize = plotSize;
		this.biome = biome;
	}
	
	public ArrayList<Animal> getAnimals(){
		return animals;
	}
	
	public BIOME getBiome(){
		return this.biome;
	}
	
	public boolean addAnimal(Animal animal){
		if (animal.getBiome() == biome && animal.getPlotSize() < plotSize){
			animals.add(animal);
			plotSize -= animal.getPlotSize();
			return true;
		}
		return false;
	}

	public int getPlotSize() {
		// TODO Auto-generated method stub
		return plotSize;
	}
}
