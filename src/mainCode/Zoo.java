package mainCode;

import java.util.ArrayList;

public class Zoo {
	private ArrayList<Visitor> visitors;
	private int ticketPrice;
	private ArrayList<Enclosure> enclosures;
	
	public Zoo(){
		visitors = new ArrayList<Visitor>();
		ticketPrice = 20;
		enclosures = new ArrayList<Enclosure>();
		
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
	}
}