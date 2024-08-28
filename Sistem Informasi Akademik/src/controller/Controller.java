package controller;

import model.Staff.DosenTetap;
import model.Staff.Karyawan;
import model.Staff.Staff;
import model.TTL;
import model.User;
import model.mahasiwa.Doktor;
import model.mahasiwa.Master;
import model.mahasiwa.Sarjana;
import model.matakuliah.MataKulPilihan;
import model.matakuliah.MataKuliah;
import model.matakuliah.MatkulAjar;
import model.matakuliah.MatkulAmbil;
import model.presensi.Presensi;
import model.presensi.PresensiStaff;
import model.presensi.Status;
import view.displayview;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    public Controller() {

        controller ();
        // controller class has functions to update, edit, remove and display data
    }

    public void controller() {

        // instantiate view class
        displayview view = new displayview ();

        // arraylist to hold objects subclasses of User
        ArrayList <User> users = new ArrayList <> ();
//
        // create objects from subclasses
        Sarjana sarjana1 = retrievedataSarjana1 ();
        Master master1 = retrievedataMaster1 ();
        Doktor doktor1 = retrievedataDoktor1 ();
        DosenTetap dosenTetap1 = retrievedataDosenTetap ();
        Karyawan karyawan1 = retrievedataKaryawan1 ();
        Karyawan karyawan2 =  retrievedataKaryawan2 ();

        Staff staff = retrievedataDosenTetap (); // dosen tetap belongs to super class(Staff)
        // before
        view.displayKaryawan (karyawan1);
        karyawan1.setNama ("Mindy");
        // after edit new name

        // add subclasses to most parent class, which is User, to ArrayList<User>
        users.add (sarjana1);
        users.add (master1);
        users.add (dosenTetap1);
        users.add (doktor1);
        users.add (karyawan1);
        users.add (karyawan2);

        // remove staff(in instance)
        users.remove (karyawan2);

        // use instance of if some of them belong to their parent
        for ( User u : users ){
            if (u instanceof  Karyawan){
                view.displayKaryawan ((Karyawan) u);
            }
        }

    }
        // the rest of code create new data of objects------------------------

    public Sarjana retrievedataSarjana1() {
        Sarjana sarjana = new Sarjana ("12345","Teknik Informatika");
        sarjana.setNama ("Andi");
        sarjana.setAlamat ("12 Sunday Park");
        sarjana.setTtl (new TTL ("Bandung",LocalDate.of (2001,1,1)));
        sarjana.setTelepon ("0896345631234");

        // Presensi
        Presensi p1 = new Presensi (LocalDate.of (2024,8,8),Status.Hadir);
        Presensi p2 = new Presensi (LocalDate.of (2024,7,1),Status.Absen);
        List <Presensi> p = new ArrayList <> ();
        p.add (p1);
        p.add (p2);


        MatkulAmbil m1 = new MatkulAmbil (new MataKuliah ("123",2,"OOP"),p,90,80,70);
        ArrayList <MatkulAmbil> m = new ArrayList <> ();
        m.add (m1);
        sarjana.setMatkulAmbils (m);

        return sarjana;
    }

    public Master retrievedataMaster1() {
        Master master1 = new Master ("2314/432","Ekonomi");
        master1.setNama ("Brian");
        master1.setAlamat ("13 Highway");
        master1.setTtl (new TTL ("Jakarta",LocalDate.of (1995,12,27)));
        master1.setTelepon ("0874-4324-5678");
        master1.setJudulTesis ("Ekonomi Pembangunan Negara");

        Presensi p1 = new Presensi (LocalDate.of (2024,5,2),Status.Absen);
        Presensi p2 = new Presensi (LocalDate.of (2024,6,3),Status.Hadir);
        Presensi p3 = new Presensi (LocalDate.of (2024,7,8),Status.Hadir);
        List <Presensi> p = new ArrayList <> ();
        p.add (p1);
        p.add (p2);
        p.add (p3);

        Presensi pp1 = new Presensi (LocalDate.of (2024,8,19),Status.Hadir);
        List <Presensi> pp = new ArrayList <> ();
        pp.add (pp1);

        MatkulAmbil m1 = new MatkulAmbil (new MataKulPilihan ("453",3,"Macro Economic",10),p,90,100,100);
        MatkulAmbil m2 = new MatkulAmbil (new MataKuliah ("342",1,"Ekonomi International"),pp,32,11,23);
        ArrayList<MatkulAmbil> ma = new ArrayList<> ();
        ma.add (m1);
        ma.add (m2);

        master1.setMatkulAmbils (ma);

        return master1;
    }

    public Doktor retrievedataDoktor1(){
        Doktor doktor = new Doktor ("234/123", "Theoretical Physics");
        doktor.setNama ("Sandy");
        doktor.setJuduldisertasi ("Dark Matter");
        doktor.setSidang1 (90);
        doktor.setSidang2 (100);
        doktor.setSidang3 (100);

        return doktor;
    }

    public DosenTetap retrievedataDosenTetap(){
        DosenTetap dosenTetap1 = new DosenTetap ("//433/222");
        dosenTetap1.setNama ("Professor Jim");

        dosenTetap1.setSalary (120000);
        dosenTetap1.setDepartmen ("Physics");

        PresensiStaff ps1 = new PresensiStaff (LocalDate.of (2024, 5, 12), Status.Hadir,LocalTime.parse ("12:00"));
        PresensiStaff ps2 = new PresensiStaff (LocalDate.of (2024, 6, 7), Status.Hadir,LocalTime.parse ("12:00"));
        List<PresensiStaff> p = new ArrayList<> ();
        p.add (ps1); p.add (ps2);

        MatkulAjar m1 = new MatkulAjar (new MataKuliah ("321", 2, "Hydrogen"), p);
        ArrayList<MatkulAjar> m = new ArrayList<> ();
        m.add (m1);
        dosenTetap1.setMatkulAjars (m);

        return dosenTetap1;
    }

    public Karyawan retrievedataKaryawan1(){
        Karyawan karyawan1 = new Karyawan ("/234/331");
        karyawan1.setSalary (850000);

        PresensiStaff ps1 = new PresensiStaff (LocalDate.of (2024, 12, 2), Status.Hadir, LocalTime.parse ("06:00"));
        List<PresensiStaff> p = new ArrayList<> ();
        p.add (ps1);
        karyawan1.setPresensiStaffs (p);

        return karyawan1;
    }


    public Karyawan retrievedataKaryawan2(){
        Karyawan karyawan2 = new Karyawan ("/234/331");
        karyawan2.setNama ("Manny");

        karyawan2.setSalary (850000);

        PresensiStaff ps1 = new PresensiStaff (LocalDate.of (2024, 12, 2), Status.Hadir, LocalTime.parse ("06:00"));
        List<PresensiStaff> p = new ArrayList<> ();
        p.add (ps1);
        karyawan2.setPresensiStaffs (p);

        return karyawan2;
    }
}
