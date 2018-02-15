package tp1;

public class Hopital {

  private static Patient patient_1;
  private static Patient patient_2;
  private static Patient patient_3;
  private static Patient patient_4;
  private static Patient patient_5;
  private static Patient patient_6;
  private static Salle salle_1;
  private static Salle salle_2;

  public static void main(String[] args) {
    initializePatients();
    initializeSalles();

    viewAllPatients();
    viewAllRooms();

    assignAllPatients();

    viewAllPatients();
    viewAllRooms();

  }

  private static void initializeSalles() {
    salle_1 = new Salle(1, 1, 8);
    salle_2 = new Salle(2, 2, 8);
  }

  public static void initializePatients() {
    patient_1 = new Patient(17, "papo", "pipo", "Operation_1", 2);
    patient_2 = new Patient(18, "papi", "pipo", "Operation_2", 3);
    patient_3 = new Patient(19, "pape", "pipo", "Operation_3", 4);
    patient_4 = new Patient(20, "papo", "pipu", "Operation_4", 2);
    patient_5 = new Patient(21, "papo", "pipi", "Operation_5", 3);
    patient_6 = new Patient(22, "papo", "pipe", "Operation_6", 4);
  }

  public static void assignAllPatients() {
    salle_1.assigner(patient_6);
    salle_1.assigner(patient_5);
    salle_1.assigner(patient_4);
    salle_2.assigner(patient_3);
    salle_2.assigner(patient_2);
    salle_2.assigner(patient_1);
  }

  private static void viewAllRooms() {
    System.out.println(salle_1.toString());
    System.out.println(salle_2.toString());
  }

  private static void viewAllPatients() {
    System.out.println(patient_1.toString());
    System.out.println(patient_2.toString());
    System.out.println(patient_3.toString());
    System.out.println(patient_4.toString());
    System.out.println(patient_5.toString());
    System.out.println(patient_6.toString());
  }

}
