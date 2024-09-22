package model.Staff;

import model.presensi.Presensi;
import model.presensi.PresensiStaff;
import model.presensi.Status;

import java.util.List;

public class Karyawan extends Staff{

    private double salary;
    private List<PresensiStaff> presensiStaffs;

    public Karyawan(String nik, double salary, List<PresensiStaff> presensiStaffs) {
        super(nik);
        this.salary = salary;
        this.presensiStaffs = presensiStaffs;
    }


    @Override
    public String printData() {

        StringBuilder sb = new StringBuilder("KARYAWAN\n");

        sb.append("NIK: ").append(getNik()).append("\n");

        sb.append("Nama: ").append(getNama()).append("\n");

        sb.append("Alamat: ").append(getAlamat()).append("\n");

        sb.append("TTL: ").append(getTtl()).append("\n");

        sb.append("Telepone: ").append(getTelepon()).append("\n");

        sb.append("Base Salary: ").append(getSalary()).append("\n");

        sb.append("List of Presensi: ").append(getPresensiStaffs()).append("\n");

        return sb.toString();
    }

    public int getUnits(){
        int units = 0;
        for (PresensiStaff ps : getPresensiStaffs()){
            if (ps.getStatus().equals(Status.HADIR)){
                units += 1;
            }
        }
        return units;
    }

    // get salary of karyawan
    public double getGaji(){
        double baseSalary = getSalary();
        int units = getUnits();
        return Math.round((double) units /22 * baseSalary);
    }























    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<PresensiStaff> getPresensiStaffs() {
        return presensiStaffs;
    }

    public void setPresensiStaffs(List<PresensiStaff> presensiStaffs) {
        this.presensiStaffs = presensiStaffs;
    }
}
