package tp3;

import java.util.ArrayList;

public class Planification {
	
	private double PorbabilityMax;
	private double capacity;
	private double additionnalTIme;
	private ArrayList<Operation> listOfOperations;
	private ArrayList<Salle> listOfSalle;
	
	public Salle ajouterSalle(){
		int identity = listOfSalle.size()+1;
		Salle salle = new Salle(identity,capacity);
		listOfSalle.add(salle);
		return salle;
	}
	
	public void charger(String fileName){
		
	}
	
	
}
