package model.Mahasiswa;

import controller.DataController;
import controller.UserController;
import model.User;
import model.matakuliah.MatKulAmbil;

import java.util.ArrayList;
import java.util.List;

public abstract class Mahasiswa extends User {

    private String nim;
    private String jurusan;

    public Mahasiswa(String nim, String jurusan) {
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    static public double printrata_rata(String kode){

        double total = 0;
        int count = 0;
        for (User sm : DataController.user){
            if (sm instanceof  Sarjana){
                for (MatKulAmbil m : sm.getMatKulAmbils()){
                    if (m.getMataKuliah().getKode().equals(kode)){
                        total += m.NA();
                        count += 1;
                    }
                }
            }else if (sm instanceof Master){
                for (MatKulAmbil m : sm.getMatKulAmbils()){
                    if (m.getMataKuliah().getKode().equals(kode)){
                        total += m.NA();
                        count += 1;
                    }
                }
            }
        }
        return count > 0 ? total/count : -1;
    }

    static public String printTidakLulus(String kode){
        int totalTidakLulus = 0;
        int mahasiswa = 0;
        for (User user : DataController.user){
            if (user instanceof Sarjana || user instanceof Master) {
                for (MatKulAmbil ma : user.getMatKulAmbils()) {
                    if (ma.getMataKuliah().getKode().equals(kode) && ma.NA() < 56){
                        totalTidakLulus += 1;
                    }
                }
                mahasiswa += 1;
            }
        }

        return totalTidakLulus + " dari " + mahasiswa + " Tidak Lulus MataKuliah";
    }


    public List<MatKulAmbil> getSarjana(Sarjana sarjana){
        return sarjana.getMatKulAmbils();
    }

    public List<MatKulAmbil> getMaster(Master master){
        return master.getMatKulAmbils();
    }

}
