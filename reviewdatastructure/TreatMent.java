import java.util.Arrays;

public class TreatMent {

    String treatmentName;
    int treatmentCost;

    public TreatMent( String treatmentName,int treatmentCost ) {
        this.treatmentName = treatmentName;
        this.treatmentCost = treatmentCost;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName( String treatmentName ) {
        this.treatmentName = treatmentName;
    }

    public int getTreatmentCost() {
        return treatmentCost;
    }

    public void setTreatmentCost( int treatmentCost ) {
        this.treatmentCost = treatmentCost;
    }

    @Override
    public String toString() {
        return "Treatment Type: " + treatmentName;
    }
}
