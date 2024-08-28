package model.matakuliah;

import model.presensi.Presensi;
import model.presensi.PresensiStaff;

import java.util.List;

public class MatkulAjar {

    private MataKuliah mataKuliah;
    private List<PresensiStaff> staffList;

    public MatkulAjar( MataKuliah mataKuliah,List <PresensiStaff> staffList ) {
        this.mataKuliah = mataKuliah;
        this.staffList = staffList;
    }

    public void setMataKuliahkode( String kode){
        this.mataKuliah.setKode (kode);
    }
    public String getMataKuliahkode(){
        return mataKuliah.getKode ();
    }

    public void setMKsks(int sks){
        this.mataKuliah.setSks (sks);
    }

    public int getMKsks(){
        return mataKuliah.getSks ();
    }

    public void setMKnama(String nama){
        this.mataKuliah.setNama (nama);
    }

    public String getMknama(){
        return mataKuliah.getNama ();
    }

    public List <PresensiStaff> getStaffList() {
        return staffList;
    }

    public void setStaffList( List <PresensiStaff> staffList ) {
        this.staffList = staffList;
    }

    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah( MataKuliah mataKuliah ) {
        this.mataKuliah = mataKuliah;
    }

    @Override
    public String toString() {
        return "Mata Kuliah Ajar: "+ getMataKuliah() +
                "\n Presensi Staff: " + staffList;
    }
}
