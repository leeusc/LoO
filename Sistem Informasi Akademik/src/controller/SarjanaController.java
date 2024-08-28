package controller;


import model.TTL;
import model.mahasiwa.Sarjana;
import view.displayview;

//=========// unused class //==================


public class SarjanaController {
    Sarjana sarjana;
    displayview view;



    public SarjanaController(Sarjana sarjana, displayview view){
        this.sarjana = sarjana;
        this.view = view;

        Sarjana sarjana1 = new Sarjana ("ii", "11");
        sarjana1.setTelepon ("8291");
    }

    public void setNama(String nama){
        this.sarjana.setNama (nama);
    }

    public String getNama(){
        return sarjana.getNama ();
    }

    public void setAlamat(String alamat){
        this.sarjana.setAlamat (alamat);
    }

    public String getAlamat(){
        return sarjana.getAlamat ();
    }

    public void setTTL(TTL ttl){
        this.sarjana.setTtl (ttl);
    }

    public TTL getTTl(){
        return sarjana.getTtl ();
    }

    public void setTelepon(String telepon){
        this.sarjana.setTelepon (telepon);
    }

    public String getTelepon(){
        return sarjana.getTelepon ();
    }
}
