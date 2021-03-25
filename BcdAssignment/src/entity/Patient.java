
package entity;


public class Patient {
    private String diagnoses;
    private String treatmentPlans;
    private String medications;
    private String immunizations;
   
    public Patient(String diagnoses, String treatmentPlans, String medications, String immunizations){
        this.diagnoses = diagnoses;
        this.treatmentPlans = treatmentPlans;
        this.medications = medications;
        this.immunizations = immunizations;
    }

    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String getTreatmentPlans() {
        return treatmentPlans;
    }

    public void setTreatmentPlans(String treatmentPlans) {
        this.treatmentPlans = treatmentPlans;
    }
    
    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }
    
    public String getImmunizations() {
        return immunizations;
    }

    public void setImmunizations(String immunizations) {
        this.immunizations = immunizations;
    }

    @Override
    public String toString() {
        return  diagnoses + "|" + treatmentPlans + "|" + medications + "|" + immunizations;
    } 
}
