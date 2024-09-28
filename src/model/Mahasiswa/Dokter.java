package model.Mahasiswa;

public class Dokter extends Mahasiswa{

    private String disertasi;
    private double n1, n2, n3;

    public Dokter(String nim, String jurusan, String disertasi, double n1, double n2, double n3) {
        super(nim, jurusan);
        this.disertasi = disertasi;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

    @Override
    public String printData() {

        StringBuilder sb = new StringBuilder("DOKTER\n");
        sb.append("NIM: ").append(getNim()).append("\n");

        sb.append("Jurusan: ").append(getJurusan()).append("\n");

        sb.append("Nama: ").append(getNama()).append("\n");

        sb.append("Alamat: ").append(getAlamat()).append("\n");

        sb.append("TTL: ").append(getTtl()).append("\n");

        sb.append("Telepone: ").append(getTelepon()).append("\n");

        sb.append("Disertasi: ").append(getDisertasi()).append("\n");

        sb.append("N1: ").append(getN1()).append("\n");
        sb.append("N2: ").append(getN2()).append("\n");
        sb.append("N3: ").append(getN3()).append("\n");
        return sb.toString();
    }

    // get average from 3 term grades
    public double print_NilaiAkhir(String kode){
        return Math.round((getN1() + getN2() + getN3())/3);
    }

    public double print_NilaiAkhir_Dokter(){
        return Math.round((getN1() + getN2() + getN3())/3);
    }




























    public String getDisertasi() {
        return disertasi;
    }

    public void setDisertasi(String disertasi) {
        this.disertasi = disertasi;
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
