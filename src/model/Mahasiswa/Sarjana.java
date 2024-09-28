package model.Mahasiswa;

import model.matakuliah.MatKulAmbil;

import java.util.List;

public class Sarjana extends Mahasiswa{

    private List<MatKulAmbil> matKulAmbils;

    public Sarjana(String nim, String jurusan, List<MatKulAmbil> matKulAmbils) {
        super(nim, jurusan);
        this.matKulAmbils = matKulAmbils;
    }

    @Override
    public String printData() {
        StringBuilder sb = new StringBuilder("SARJANA\n");
        sb.append("NIM: ").append(getNim()).append("\n");

        sb.append("Jurusan: ").append(getJurusan()).append("\n");

        sb.append("Nama: ").append(getNama()).append("\n");

        sb.append("Alamat: ").append(getAlamat()).append("\n");

        sb.append("TTL: ").append(getTtl()).append("\n");

        sb.append("Telepone: ").append(getTelepon()).append("\n");

        //sb.append("List MatkulAmbil: ").append(getMatKulAmbils()).append("\n");
        return sb.toString();
    }

    public double print_NilaiAkhir(String kode){

        for (MatKulAmbil ma : getMatKulAmbils()){
            if (ma.getMataKuliah().getKode().equals(kode)){
                return ma.NA();
            }
        }
        return 0;
    }

    public String printPresensi(){
        StringBuilder sb = new StringBuilder();
        sb.append("NIK: " + getNik()).append(", Nama: " + getNama()).append("\n");
        sb.append(getMatKulAmbils() +"\n");
        sb.append("Total Presensi: " + getTotalPresensi());
        return sb.toString();
    }

    private int getTotalPresensi(){
        int totalPresensiHadir = 0;
        for (MatKulAmbil matKulAmbil : getMatKulAmbils()){
            totalPresensiHadir += matKulAmbil.getUnits();
        }
        return totalPresensiHadir;
    }























    public List<MatKulAmbil> getMatKulAmbils() {
        return matKulAmbils;
    }

    public void setMatKulAmbils(List<MatKulAmbil> matKulAmbils) {
        this.matKulAmbils = matKulAmbils;
    }

    @Override
    public String toString() {
        return "Sarjana{" +
                "matKulAmbils=" + matKulAmbils +
                '}';
    }
}
