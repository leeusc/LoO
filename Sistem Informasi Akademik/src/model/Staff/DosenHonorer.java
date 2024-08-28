package model.Staff;

public class DosenHonorer extends Dosen{

    private double perSKS;

    public DosenHonorer( String NIK ) {
        super (NIK);
    }

    public double getPerSKS() {
        return perSKS;
    }

    public void setPerSKS( double perSKS ) {
        this.perSKS = perSKS;
    }

    @Override
    public String toString() {
        return super.toString () + "\nHonor Per SKS : " + getPerSKS ();
    }
}
