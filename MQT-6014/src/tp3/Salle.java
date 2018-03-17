package tp3;

import java.util.ArrayList;

public class Salle {
	
  private double capacity;	
  private int identity;
  private double sumOfAverage = 0.0;
  private double sumOfVariance = 0.0;
  private double deviation = 0.0;
  private ArrayList<Operation> listOperations;
  
  public Salle(int identity, double capacity){
	  this.identity = identity;
	  this.capacity = capacity;
  }

  public double getEsperance() {
    for (int i = 0; i < listOperations.size(); i++)
      sumOfAverage += listOperations.get(i).getAverage();
    return sumOfAverage;
  }
  
  public double getEsperanceAjout(Operation operation) {
	    for (int i = 0; i < listOperations.size(); i++)
	      sumOfAverage += listOperations.get(i).getAverage();
	    sumOfAverage = sumOfAverage + operation.getAverage();
	    return sumOfAverage;
	  }

  public void setSumOfAverage(double sumOfAverage) {
    this.sumOfAverage = sumOfAverage;
  }

  public double getSumOfVariance() {
    for (int i = 0; i < listOperations.size(); i++)
      sumOfVariance += listOperations.get(i).getVariance();
    return sumOfVariance;
  }

  public void setSumOfVariance(double sumOfVariance) {
    this.sumOfVariance = sumOfVariance;
  }

  public double getDeviation() {
    deviation = Math.sqrt(sumOfVariance);
    return deviation;
  }

  public void setDeviation(double deviation) {
    this.deviation = deviation;
  }
  
  public double getEsperanceTempsSupp(){
	  return 0;
  }
  
  public double getEsperanceTempsAjout(Operation operation){
	  return 0;
  }
  
  public double getProbabiliteTempsSupp(){
	  return 0;
  }
  
  public double getProbabiliteTempsSuppAjout(Operation operation){
	  return 0;
  }
  
  public void ajouter(Operation operation){
	  listOperations.add(operation);
	  sumOfAverage = getEsperanceAjout(operation);
	  sumOfVariance = getSumOfVariance() + operation.getVariance();
	  
  }
  
  public String toString(){
	  return "Moyenne = "+sumOfAverage+" Variance = "+sumOfVariance+" probabilites de temps supplementaire = "+getProbabiliteTempsSupp()+"Esperance de tamps supplementaire = "+getEsperanceTempsSupp(); 
  }

}
