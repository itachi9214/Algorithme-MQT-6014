package tp3;

import java.util.ArrayList;

public class Salle {

  private double sumOfAverage = 0.0;
  private double sumOfVariance = 0.0;
  private double deviation = 0.0;
  private ArrayList<Operation> listOperations;

  public double getSumOfAverage() {
    for (int i = 0; i < listOperations.size(); i++)
      sumOfAverage += listOperations.get(i).getAverage();
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

}
