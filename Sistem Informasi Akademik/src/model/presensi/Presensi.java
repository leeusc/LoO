package model.presensi;

import java.time.LocalDate;
import java.util.Date;

public class Presensi {

    private LocalDate date;
    private int status;

    public Presensi( LocalDate date,int status ) {
        this.date = date;
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate( LocalDate date ) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus( int status ) {
        this.status = status;
    }

    public String getStatusS(int i){
        if (Status.Absen == i){
            return "Absen";
        } else if (Status.Hadir == i){
            return "Hadir";
        }
        return "Tanpa Keterangan";
    }

    @Override
    public String toString() {
        return "Presensi:" +
                " date: " + getDate () +
                ", status=" + getStatusS (getStatus ())
                ;
    }
}
