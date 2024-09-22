package model.presensi;

public class Presensi {

    private String tanggal;
    private Status status;

    public Presensi(String tanggal, Status status) {
        this.tanggal = tanggal;
        this.status = status;
    }






    @Override
    public String toString() {
        return "[" +tanggal + " -> " + status + "]";
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
