package model;

import java.util.Date;

public abstract class User {

   private String nama;
    private String alamat;
    private TTL ttl;
    private String telepon;


    public String getNama() {
        return nama;
    }

    public void setNama( String nama ) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat( String alamat ) {
        this.alamat = alamat;
    }

    public TTL getTtl() {
        return ttl;
    }

    public void setTtl( TTL ttl ) {
        this.ttl = ttl;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon( String telepon ) {
        this.telepon = telepon;
    }

    @Override
    public String toString() {

        String s = String.format
                ("Name: %s\nAlamat: %s\nTTl: %s\nTelepone %s\n",
                getNama (), getAlamat (), getTtl (), getTelepon ());
        return s;
    }
}

