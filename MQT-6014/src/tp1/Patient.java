package tp1;

public class Patient {

  private int age;
  private String nom;
  private String prenom;
  private String operation;
  private double duree;
  private int no_salle;

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public double getDuree() {
    return duree;
  }

  public void setDuree(double duree) {
    this.duree = duree;
  }

  public int getNo_salle() {
    return no_salle;
  }

  public void setNo_salle(int no_salle) {
    this.no_salle = no_salle;
  }

  public Patient(int age, String nom, String prenom, String operation, double duree) {
    this.age = age;
    this.nom = nom;
    this.prenom = prenom;
    this.operation = operation;
    this.duree = duree;
    this.no_salle = -1;
  }

  public String toString() {
    return "Patient [age=" + age + ", nom=" + nom + ", prenom=" + prenom + ", operation="
        + operation + ", duree=" + duree + ", no_salle=" + no_salle + "]";
  }

}
