package classes.main;

public class PatientList {

    private final Patient[] patients;

    public PatientList(Patient[] patients) {
        this.patients = patients;
    }

    public void printPatientByDiagnosis(String diagnosis) {
        System.out.format("List of patient with %s.\n", diagnosis);
        System.out.format("+----+----------+----------+------------------------+--------------+----------------+--------------------+\n");
        System.out.format("| ID | Surname  | Name     | Address                | Phone        | Medical Card № | Diagnosis          |\n");
        System.out.format("+----+----------+----------+------------------------+--------------+----------------+--------------------+\n");
        for (Patient patient : patients) {
            if (patient.getDiagnosis().equalsIgnoreCase(diagnosis)) {
                System.out.println(patient);
            }
        }
        System.out.format("+----+----------+----------+------------------------+--------------+----------------+--------------------+\n");
    }

    public void printPatientBySpecifiedInterval(long from, long to) {
        System.out.format("List of patient whose medical record number is in the specified interval.\n");
        System.out.format("+----+----------+----------+------------------------+--------------+----------------+--------------------+\n");
        System.out.format("| ID | Surname  | Name     | Address                | Phone        | Medical Card № | Diagnosis          |\n");
        System.out.format("+----+----------+----------+------------------------+--------------+----------------+--------------------+\n");
        for (Patient patient : patients) {
            if (patient.getMedicalCardNumber() > from && patient.getMedicalCardNumber() < to) {
                System.out.println(patient);
            }
        }
        System.out.format("+----+----------+----------+------------------------+--------------+----------------+--------------------+\n");
    }
}
