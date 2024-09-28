package model.Staff;

import model.User;

public abstract class Staff extends User {

    private String nik;

    public Staff(String nik) {
        this.nik = nik;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public abstract double getGaji();


}








