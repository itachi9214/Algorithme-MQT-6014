package tp3;

import java.util.ArrayList;

public class Salle {

  private double capacityMax;
  private int identity;
  private double sumOfAverage = 0.0;
  private double sumOfVariance = 0.0;
  private double deviation = 0.0;
  private ArrayList<Operation> listOperations;

  public Salle(int identity, double capacityMax) {
    this.listOperations = new ArrayList<>();
    this.identity = identity;
    this.capacityMax = capacityMax;
  }

  public double getEsperance() {
    return sumOfAverage;
  }

  public double getEsperanceAjout(Operation operation) {
    return sumOfAverage + operation.getAverage();
  }

  public void setSumOfAverage(double sumOfAverage) {
    this.sumOfAverage = sumOfAverage;
  }

  public double getSumOfVariance() {
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

  public double getEsperanceTempsSupp() {
    double extraTime = 0;
    if (capacityMax < sumOfAverage)
      extraTime = Gaussian.leftTruncatedMean(sumOfAverage, getDeviation(), capacityMax)
          - capacityMax;
    return extraTime;
  }

  public double getEsperanceTempsSuppAjout(Operation operation) {
    double extraTime = 0;
    double expectationAfterAddOperation = getEsperanceAjout(operation);
    if (capacityMax < expectationAfterAddOperation)
      extraTime = Gaussian.leftTruncatedMean(expectationAfterAddOperation, getDeviation(),
          capacityMax) - capacityMax;
    return extraTime;
  }

  public double getProbabiliteTempsSupp() {
    double probability = Gaussian.cdf(capacityMax, getEsperance(), getDeviation());
    return 1 - probability;
  }

  public double getProbabiliteTempsSuppAjout(Operation operation) {
    double probability = Gaussian.cdf(capacityMax, getEsperanceAjout(operation), getDeviation());
    return 1 - probability;
  }

  public void ajouter(Operation operation) {
    listOperations.add(operation);
    sumOfAverage = getEsperanceAjout(operation);
    sumOfVariance = getSumOfVariance() + operation.getVariance();

  }

  public String toString() {
    return "[Salle : Moyenne = " + sumOfAverage + " Variance = " + sumOfVariance
        + " probabilites de temps supplementaire = " + getProbabiliteTempsSupp()
        + " Esperance de temps supplementaire = " + getEsperanceTempsSupp() + " ]\n";
  }

}
