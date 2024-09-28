package model.Staff;

import model.matakuliah.MataKulAjar;

public class DosenTetap extends Dosen{

    private double salary;

    public DosenTetap(String nik, String Departemen, double salary) {
        super(nik, Departemen);
        this.salary = salary;
    }

    @Override
    public String printData() {
        StringBuilder sb = new StringBuilder("DOSEN TETAP\n");

        sb.append("NIK: ").append(getNik()).append("\n");

        sb.append("Nama: ").append(getNama()).append("\n");

        sb.append("Alamat: ").append(getAlamat()).append("\n");

        sb.append("TTL: ").append(getTtl()).append("\n");

        sb.append("Telepone: ").append(getTelepon()).append("\n");

        sb.append("Base Salary: ").append(getSalary()).append("\n");

        sb.append("Departemen: ").append(getDepartemen()).append("\n");

       // sb.append("List of MatkulAjar: ").append(getMataKulAjars()).append("\n");

//manajemen sebuah resturan UML // use and class diagram

        return sb.toString();
    }

    // get salary of DosenTetap
    public double getGaji(){
        int totalUnits = 0;
        for (MataKulAjar m : getMataKulAjars()){
            totalUnits += m.getUnits();
        }

        double baseSalary = getSalary();
        return Math.round(baseSalary + (totalUnits * 25000));
    }

































    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
