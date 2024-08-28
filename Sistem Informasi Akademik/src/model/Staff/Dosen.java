package model.Staff;

import model.matakuliah.MatkulAjar;

import java.util.ArrayList;

public abstract class Dosen extends Staff{

    private String departmen;
    private ArrayList<MatkulAjar> matkulAjars;

    public Dosen( String NIK ) {
        super (NIK);
    }


    public String getDepartmen() {
        return departmen;
    }

    public void setDepartmen( String departmen ) {
        this.departmen = departmen;
    }

    public ArrayList <MatkulAjar> getMatkulAjars() {
        return matkulAjars;
    }

    public void setMatkulAjars( ArrayList <MatkulAjar> matkulAjars ) {
        this.matkulAjars = matkulAjars;
    }

    @Override
    public String toString() {
        return super.toString () + "\n" +
                "Departmen: " + getDepartmen () +
                "MataKuliah: " + getMatkulAjars ();
    }
}
