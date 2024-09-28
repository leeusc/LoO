package model.Staff;

import model.matakuliah.MataKulAjar;

import java.util.List;

public abstract class Dosen extends Staff {

    private String departemen;
    private List<MataKulAjar> mataKulAjars;

    public Dosen(String nik, String departemen) {
        super(nik);
        this.departemen = departemen;
    }

    @Override
    public String printData() {
        return "";
    }

    public String printNgajar(){
        StringBuilder sb = new StringBuilder();
        sb.append("NIK: ").append(getNik()).append(", Nama: ").append(getNama()).append("\n");
        sb.append(getMataKulAjars()).append("\n");
        sb.append("Total Mengajar: ").append(getNgajar());

        return sb.toString();
    }

    public double getNgajar(){

        double totalHours = 0;
        for (MataKulAjar mataKulAjar : getMataKulAjars()){
            totalHours += mataKulAjar.totalPresensi();
        }
        return Math.round(totalHours);
    }


        // Gaji Dosen Honor : gaji = (unit * honorPerSKS





























    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public List<MataKulAjar> getMataKulAjars() {
        return mataKulAjars;
    }

    public void setMataKulAjars(List<MataKulAjar> mataKulAjars) {
        this.mataKulAjars = mataKulAjars;
    }

    @Override
    public abstract double getGaji();
}
