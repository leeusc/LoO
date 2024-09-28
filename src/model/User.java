package model;

import model.matakuliah.MatKulAmbil;

import java.util.ArrayList;
import java.util.List;


// User as abstract class use a blueprint or template
public abstract class User {

    private String nama;
    private String alamat;
    private String ttl;
    private String telepon;


    public abstract String printData();

    public double print_NilaiAkhir(String kode){
        return 0;
    }

    public double print_NilaiAkhir_Dokter(){
        return 0;
    }

    public String printNgajar(){
        return "";
    }

    public double getGaji(){
        return 0;
    }

    public String printPresensi(){
        return "";
    }

    public List<MatKulAmbil> getMatKulAmbils() {
        return new ArrayList<>();
    }

    public String getNim(){
        return "NIM";
    }
    public String getNik() {
        return "NIK";
    }
























    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    @Override
    public String toString() {
        return "User{" +
                "nama='" + nama + '\'' +
                ", alamat='" + alamat + '\'' +
                ", ttl='" + ttl + '\'' +
                ", telepon='" + telepon + '\'' +
                '}';
    }
}
