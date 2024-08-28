package model.matakuliah;

import model.presensi.Presensi;

import java.util.List;

public class MatkulAmbil {

    private MataKuliah mataKuliah;
    private List <Presensi> presensiList;
    private int n1, n2, n3;

    public MatkulAmbil( MataKuliah mataKuliah,List <Presensi> presensiList,int n1,int n2,int n3 ) {
        this.mataKuliah = mataKuliah;
        this.presensiList = presensiList;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

    public List <Presensi> getPresensiList() {
        return presensiList;
    }

    public void setPresensiList( List <Presensi> presensiList ) {
        this.presensiList = presensiList;
    }

    public void setKode(String kode){
        this.mataKuliah.setKode (kode);
    }

    public String kode(){
        return mataKuliah.getKode ();
    }

    public void setSKS(int sks){
        this.mataKuliah.setSks (sks);
    }
    public int getSks(){
        return mataKuliah.getSks ();
    }

    public void setNama(String nama){
        this.mataKuliah.setNama (nama);
    }

    public String getNama(){
        return mataKuliah.getNama ();
    }

    public int getN1() {
        return n1;
    }

    public void setN1( int n1 ) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2( int n2 ) {
        this.n2 = n2;
    }

    public int getN3() {
        return n3;
    }

    public void setN3( int n3 ) {
        this.n3 = n3;
    }

    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah( MataKuliah mataKuliah ) {
        this.mataKuliah = mataKuliah;
    }

    @Override
    public String toString() {
        return "\n\t\t" +
                mataKuliah +
                ", presensiList: " + presensiList +
                ", n1: " + n1 +
                ", n2: " + n2 +
                ", n3: " + n3 +
                '}';
    }
}
