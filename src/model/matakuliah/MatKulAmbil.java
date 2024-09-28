package model.matakuliah;

import model.presensi.Presensi;
import model.presensi.PresensiStaff;
import model.presensi.Status;

import java.util.List;

public class MatKulAmbil {

    private MataKuliah mataKuliah;
    private List<Presensi> presensis;
    private double n1, n2, n3;

    public MatKulAmbil(MataKuliah mataKuliah, List<Presensi> presensis, double n1, double n2, double n3) {
        this.mataKuliah = mataKuliah;
        this.presensis = presensis;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

    public int getUnits(){
        int unit = 0;

        for (Presensi p : getPresensis()){
            if (p.getStatus().equals(Status.HADIR)){
                unit += 1;
            }
        }
        return unit;
    }

    // total avergae of NA
    public double NA(){
        double d =  Math.round((getN1() + getN2() + getN3())/3);
        return d;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(getMataKuliah()).append("\nPresensi" + getPresensis());
        sb.append(" N1: " + getN1() + ", ").append("N2: " + getN2() + ", ").append("N3: " + getN3() + "\n");
        return sb.toString();
    }

    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(MataKuliah mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public List<Presensi> getPresensis() {
        return presensis;
    }

    public void setPresensis(List<Presensi> presensis) {
        this.presensis = presensis;
    }

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public double getN3() {
        return n3;
    }

    public void setN3(double n3) {
        this.n3 = n3;
    }
}
