package model.presensi;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class PresensiStaff extends Presensi {

    private LocalTime hours;

    public PresensiStaff( LocalDate date,int status, LocalTime localTime ) {
        super (date,status);
        this.hours = localTime;
    }

    public LocalTime getHours() {
        return hours;
    }

    public void setHours( LocalTime hours ) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return super.toString () +
                ", Time: " + getHours () + "]";
    }
}
