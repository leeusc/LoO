package model.presensi;

public class PresensiStaff extends Presensi{

    private double jam;

    public PresensiStaff(String tanggal, Status status, double jam) {
        super(tanggal, status);
        this.jam = jam;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(getTanggal() + ", ").append(getStatus() + ", ").append(getJam());
        return sb.toString();
    }

    public double getJam() {
        return jam;
    }

    public void setJam(double jam) {
        this.jam = jam;
    }
}
