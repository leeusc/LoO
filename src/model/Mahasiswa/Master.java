package model.Mahasiswa;

import model.matakuliah.MatKulAmbil;

import java.util.List;

public class Master extends Mahasiswa {

    private String tesis;
    private List<MatKulAmbil> matKulAmbils;

    public Master(String nim, String jurusan, String tesis, List<MatKulAmbil> matKulAmbils) {
        super(nim, jurusan);
        this.tesis = tesis;
        this.matKulAmbils = matKulAmbils;
    }

    @Override
    public String printData() {

        StringBuilder sb = new StringBuilder("MASTER\n");
        sb.append("NIM: ").append(getNim()).append("\n");

        sb.append("Jurusan: ").append(getJurusan()).append("\n");

        sb.append("Nama: ").append(getNama()).append("\n");

        sb.append("Alamat: ").append(getAlamat()).append("\n");

        sb.append("TTL: ").append(getTtl()).append("\n");

        sb.append("Telepone: ").append(getTelepon()).append("\n");

        sb.append("Tesis: ").append(getTesis()).append("\n");

       // sb.append("List MatkulAmbil: ").append(getMatKulAmbils()).append("\n");
        return sb.toString();
    }

    public double print_NilaiAkhir(String kode){

        for (MatKulAmbil ma : getMatKulAmbils()){
            if (ma.getMataKuliah().getKode().equals(kode)){
                return ma.NA();
            }
        }
        return -1;
    }

    public String printPresensi(){
        StringBuilder sb = new StringBuilder();
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

























    public String getTesis() {
        return tesis;
    }

    public void setTesis(String tesis) {
        this.tesis = tesis;
    }

    public List<MatKulAmbil> getMatKulAmbils() {
        return matKulAmbils;
    }

    public void setMatKulAmbils(List<MatKulAmbil> matKulAmbils) {
        this.matKulAmbils = matKulAmbils;
    }

}
