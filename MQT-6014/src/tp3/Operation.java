package tp3;

public class Operation implements Comparable<Operation> {

  private int identity;
  private double average;
  private double deviation;
  private int roomNumber;

  public Operation(int identity, double average, double deviation) {
    this.identity = identity;
    this.average = average;
    this.deviation = deviation;
  }

  public int getIdentity() {
    return identity;
  }

  public void setIdentity(int identity) {
    this.identity = identity;
  }

  public double getAverage() {
    return average;
  }

  public void setAverage(double average) {
    this.average = average;
  }

  public double getDeviation() {
    return deviation;
  }

  public void setDeviation(double deviation) {
    this.deviation = deviation;
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
  }

  public double getVariance() {
    return Math.pow(deviation, 2);
  }

  @Override
  public String toString() {
    return "Operation [identity=" + identity + ", average=" + average + ", deviation=" + deviation
        + ", roomNumber=" + roomNumber + "]";
  }

  @Override
  public int compareTo(Operation operation) {
    if (this.average < operation.average)
      return 1;
    else if (this.average == operation.average) {
      if (this.deviation < operation.deviation)
        return 1;
      else if (this.deviation == operation.deviation)
        return 0;
      else
        return -1;
    } else
      return -1;
  }

}
