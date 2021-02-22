package classes.main;

public class ClassesMain {

    /* Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(),
    getТип(), toString(). Определить дополнительно  методы в классе, создающем массив объектов.
    Задать критерий выбора данных и вывести эти данные на консоль. В каждом классе, обладающем информацией,
    должно быть объявлено несколько конструкторов.

    Patient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Номер медицинской карты, Диагноз.
        Создать массив объектов. Вывести:
        a) список пациентов, имеющих данный диагноз;
        b) список пациентов, номер медицинской карты которых находится в заданном интервале. */

    public static void main(String[] args) {
        Patient patient1 = new Patient("Smith", "John", "1883 Geneva Street",
                "617-555-0154",109_467_103, "pneumonia");
        Patient patient2 = new Patient("Doe", "Erica","4233 Geraldine Lane",
                "617-555-0148",100_400_131, "pneumonia");
        Patient patient3 = new Patient("Maren", "Julie", "4864 Pretty View Lane",
                "617-555-0127",100_400_132, "pneumonia");
        Patient patient4 = new Patient("Osborn", "Norman", "4094 Bicetown Road",
                "617-555-0177",100_400_133, "pneumonia");
        Patient patient5 = new Patient("Parker", "Peter", "20 Ingram Street",
                "617-555-0188",300_168_466, "bronchial asthma");
        Patient patient6 = new Patient("Watson", "Mary", "2747 Hoffman Avenue",
                "617-555-0165",300_168_541, "flu");
        Patient patient7 = new Patient("Osborn", "Harry", "748 Small Street",
                "617-555-1333",100_400_134, "pneumonia");

        Patient[] patients = {patient1, patient2, patient3, patient4, patient5, patient6, patient7};
        PatientList patientList = new PatientList(patients);

        patientList.printPatientByDiagnosis("pneumonia");
        patientList.printPatientBySpecifiedInterval(105_000_000, 400_000_000);
    }

}
