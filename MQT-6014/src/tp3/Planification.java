package tp3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Planification {
	
	
	
	private double prorbabilityMax;
	private double capacityMax;
	private double additionnalTime;
	private double numberOfOperations;
	private ArrayList<Operation> listOfOperations;
	private ArrayList<Salle> listOfSalle;
	
	public Salle ajouterSalle(){
		int identity = listOfSalle.size()+1;
		Salle salle = new Salle(identity,capacityMax);
		listOfSalle.add(salle);
		return salle;
	}
	
	public void charger(String fileName) throws IOException{
		listOfOperations.clear();
		listOfSalle.clear();
		listOfOperations = new ArrayList<>();
		BufferedReader bufferedReader;
		FileReader fileReader = new FileReader(fileName);
		bufferedReader = new BufferedReader(fileReader);
		String line = bufferedReader.readLine();
		boolean firstLine = true;
		while(line!= null){
			String [] lines = line.split("");
			if(firstLine){
				numberOfOperations = Double.parseDouble(lines[0]);
				capacityMax = Double.parseDouble(lines[1]);
				additionnalTime = Double.parseDouble(lines[2]);
				prorbabilityMax = Double.parseDouble(lines[3]);
				firstLine = false;
				bufferedReader.readLine();
			}else{
				double average = Double.parseDouble(lines[0]);
				double deviation = Double.parseDouble(lines[1]);
				int identity = listOfOperations.size() + 1;
				Operation operation = new Operation(identity, average, deviation);
				
				listOfOperations.add(operation);
				bufferedReader.readLine();	
			}
		}
		bufferedReader.close();	
	}
	
	public double getTotalTempsSupp(){
		double TSE = 0;
		for (int i = 0;i<listOfSalle.size();i++)
			TSE = TSE + listOfSalle.get(i).getEsperanceTempsSupp()*listOfSalle.get(i).getProbabiliteTempsSupp();
		return TSE;
	}
	
	
}
