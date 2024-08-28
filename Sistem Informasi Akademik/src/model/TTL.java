package model;

import java.time.LocalDate;
import java.util.Date;

public class TTL{

    String tempat;
    LocalDate date;

    public TTL( String tempat,LocalDate date ) {
        this.tempat = tempat;
        this.date = date;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat( String tempat ) {
        this.tempat = tempat;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate( LocalDate date ) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder ();
        sb.append (getTempat ()).append (", ").append (getDate ());

        return sb.toString ();
    }
}
