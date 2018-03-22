package tp3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	
	public void charger(String fileName) throws IOException{
		listOfOperations.clear();
		listOfSalle.clear();
		listOfOperations = new ArrayList<>();
		listOfSalle = new ArrayList<>();
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = bufferedReader.readLine();
		while(line!= null){
			String [] lines = line.split("");
			if(lines.length==4){
				
			}
		}
			
	}
	
	public double getTotalTempsSupp(){
		double TSE = 0;
		for (int i = 0;i<listOfSalle.size();i++)
			TSE = TSE + listOfSalle.get(i).getEsperanceTempsSupp()*listOfSalle.get(i).getProbabiliteTempsSupp();
		return TSE;
	}
	
	
}
