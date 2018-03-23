package tp3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Planification {
	
	
	
	private double prorbabilityMax;
	private double capacityMax;
	private double additionnalTime;
	private double numberOfOperations;
	private ArrayList<Operation> listOfOperations;
	private ArrayList<Salle> listOfSalle;
	
	public Planification(){
		listOfOperations = new ArrayList<>();
		listOfSalle = new ArrayList<>();
	}
	
	public Salle ajouterSalle(){
		int identity = listOfSalle.size()+1;
		Salle salle = new Salle(identity,capacityMax);
		listOfSalle.add(salle);
		return salle;
	}
	
	public void charger(String fileName) throws IOException{
		if(listOfOperations!=null)
			listOfOperations.clear();
		if(listOfSalle!=null)
			listOfSalle.clear();
		listOfOperations = new ArrayList<>();
		BufferedReader bufferedReader;
		FileReader fileReader = new FileReader(fileName);
		bufferedReader = new BufferedReader(fileReader);
		boolean firstLine = true;
		String line = bufferedReader.readLine();
		
		while(line!= null){
			String [] lines = line.split(" ");
			if(firstLine){
				numberOfOperations = Double.parseDouble(lines[0]);
				capacityMax = Double.parseDouble(lines[1]);
				additionnalTime = Double.parseDouble(lines[2]);
				prorbabilityMax = Double.parseDouble(lines[3]);
				firstLine = false;
			}else{
				double average = Double.parseDouble(lines[0]);
				double deviation = Double.parseDouble(lines[1]);
				int identity = listOfOperations.size() + 1;
				Operation operation = new Operation(identity, average, deviation);
				listOfOperations.add(operation);
			}
			line = bufferedReader.readLine();	
		}
		bufferedReader.close();	
	}
	
	public void viewRoomList(){
		for(int i = 0; i < listOfSalle.size(); i++)
			listOfSalle.get(i).toString();
	}
	
	public double getTotalTempsSupp(){
		double TSE = 0;
		for (int i = 0;i<listOfSalle.size();i++)
			TSE = TSE + listOfSalle.get(i).getEsperanceTempsSupp()*listOfSalle.get(i).getProbabiliteTempsSupp();
		return TSE;
	}
	
	public double getProbabiliteTempsSupp(){
		return 0;
	}
	
	public String toString (){
		
		return "Nombre de salle: "+listOfSalle.size()+" Esperance du temps Supplementaire: "+getTotalTempsSupp()+" Probabilite du temps supplementaire: "+getProbabiliteTempsSupp()+" "+listOfSalle;
	}
	
	public void affecter (){
		double meilleur_cout;
		Salle meilleure_salle ;
		double cout;
		double probabilityExtraTimeAdded;
		double expectationAdded;
		double maximalTime = capacityMax+additionnalTime;
		if(listOfSalle!=null)
			listOfSalle.clear();
		Collections.sort(listOfOperations);
		for(int i = 0; i < listOfOperations.size(); i++){
			meilleur_cout = Double.MAX_VALUE;
			meilleure_salle = null;
			for(int j = 0; j < listOfSalle.size(); j++){
				cout = listOfSalle.get(j).getEsperanceTempsSuppAjout(listOfOperations.get(i));
				probabilityExtraTimeAdded = listOfSalle.get(j).getProbabiliteTempsSuppAjout(listOfOperations.get(i));
				expectationAdded = listOfSalle.get(j).getEsperanceAjout(listOfOperations.get(i));
				
				if((cout < meilleur_cout)&&(probabilityExtraTimeAdded < prorbabilityMax)&&(expectationAdded < maximalTime)){
					meilleur_cout = cout;
					meilleure_salle = listOfSalle.get(j);
				}
			}
			if(meilleure_salle == null)
				meilleure_salle = ajouterSalle();
			meilleure_salle.ajouter(listOfOperations.get(i));
		}
	}
}
