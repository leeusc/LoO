package model.Staff;

import model.User;

public abstract class Staff extends User {

    private String NIK;

    public Staff( String NIK ) {
        this.NIK = NIK;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK( String NIK ) {
        this.NIK = NIK;
    }

    @Override
    public String toString() {
        return super.toString () +
                "NIK: " + getNIK ();
    }
}
