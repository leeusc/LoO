package model.Staff;

import model.presensi.PresensiStaff;

import java.util.List;

public class Karyawan extends Staff {

    private double salary;
    private List<PresensiStaff> presensiStaffs;

    public Karyawan( String NIK ) {
        super (NIK);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary( double salary ) {
        this.salary = salary;
    }

    public List <PresensiStaff> getPresensiStaffs() {
        return presensiStaffs;
    }

    public void setPresensiStaffs( List <PresensiStaff> presensiStaffs ) {
        this.presensiStaffs = presensiStaffs;
    }

    @Override
    public String toString() {
        return super.toString () +
                "Salary: " + salary +
                "\nPresensiStaff: " + presensiStaffs;
    }
}
