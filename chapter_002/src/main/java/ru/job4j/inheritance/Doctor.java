package ru.job4j.inheritance;

public class Doctor extends Profession {
    private Diagnose diagnose;

    public Diagnose heal(Patient patient) {
        return patient.getDiagnose();
    }

    public void treat(Patient patient) {
        patient.setDiagnose(diagnose);
    }
}
