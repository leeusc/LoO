
package controller;

import model.Mahasiswa.Dokter;
import model.Mahasiswa.Mahasiswa;
import model.Mahasiswa.Master;
import model.Mahasiswa.Sarjana;
import model.Staff.*;
import model.User;
import model.matakuliah.MatKulAmbil;
import model.matakuliah.MatKulPilihan;
import model.matakuliah.MataKulAjar;
import model.matakuliah.MataKuliah;
import model.presensi.Presensi;
import model.presensi.PresensiStaff;
import model.presensi.Status;

import java.util.ArrayList;
import java.util.List;

// class to control all primary objects
public class DataController {

    // Set User as polymorphism
    static public List<User> user = new ArrayList<>();
    // why static? static has global access and being called without instantiate at the beginning

    static {

        user.add(master());
        user.add(master_2());
        user.add(sarjana());
        user.add(sarjana_2());
        user.add(dokter_2());
        user.add(dokter());
        user.add(karyawan());
        user.add(dosenTetap());
        user.add(dosenHonorer());
    }

    // run O(n), since the data of the list has few objects, it is practically efficient to iterate through all users
    static public User getByName(String name){
        for (User user : user){
            if (user.getNama().equals(name)){
                return user;
            }
        }
        return null;
    }

    static public User getByNIM(String nim){
        for (User user : user){
            if (user instanceof Mahasiswa)
                if (user.getNim().equals(nim)){
                    return user;
            }
        }
        return null;
    }

    static public User getByNIK(String nik){
        for (User user : user){
            if (user instanceof Staff){
                if (user.getNik().equals(nik)){
                    return user;
                }
            }
        }
    return null;
    }


    static Mahasiswa sarjana(){
        Sarjana sarjana = new Sarjana("S1", "IT",
                DataController.matKulAmbils(MataKuliah.AppliedMath(), MatKulPilihan.DSA(),
                        100, 100, 50));
        sarjana.setNama("Salsa");
        return sarjana;
    }

    static Mahasiswa sarjana_2(){
        Sarjana sarjana = new Sarjana("S2", "Physics",
                DataController.matKulAmbils(MataKuliah.Physics(), MataKuliah.AppliedMath(),
                50, 50, 50));
        sarjana.setNama("Sandy");
        return sarjana;
    }

    static Mahasiswa master(){
        Master master = new Master("M1", "IT", "Network",
                DataController.matKulAmbils(MataKuliah.AppliedMath(), MataKuliah.FurtherMath(),
                        100, 90, 90));
        master.setNama("Mario");
        return master;
    }

    static Mahasiswa master_2(){
        Master master = new Master("M2", "IT", "Cloud",
                DataController.matKulAmbils(MataKuliah.AppliedMath(), MatKulPilihan.OOP(),
                90, 90, 90));
        master.setNama("Mike");
        return master;
    }

    // template MatKulAmbil(2 subjects with each Present)
    static List<MatKulAmbil> matKulAmbils(MataKuliah mA, MataKuliah mB, double n1, double n2, double n3){
        MatKulAmbil m1 = new MatKulAmbil(mA, DataController.presensis(Status.HADIR, Status.HADIR, Status.HADIR), n1, n2, n3);
        MatKulAmbil m2 = new MatKulAmbil(mB, DataController.presensis(Status.HADIR, Status.HADIR, Status.ALPHA), n1, n2, n3);
        List<MatKulAmbil> list = new ArrayList<>(); list.add(m1); list.add(m2);
        return list;
    }

    // template Present's record
    static List<Presensi> presensis(Status s1, Status s2, Status s3){
        Presensi p1 = new Presensi("20 September", s1);
        Presensi p2 = new Presensi("21 September", s2);
        Presensi p3 = new Presensi("22 September", s3);
        List<Presensi> list = new ArrayList<>(); list.add(p1); list.add(p2); list.add(p3);
        return list;
    }


    static Dokter dokter(){
        Dokter dokter = new Dokter("1D", "Mathematics", "Quantum", 100, 100, 100);
        dokter.setNama("Debby");
        return dokter;
    }

    static Dokter dokter_2(){
        Dokter dokter = new Dokter("2D", "Mathematics", "Quantum", 100, 50, 10);
        dokter.setNama("Dean");
        return dokter;
    }

    static Dosen dosenHonorer(){
        DosenHonorer dh = new DosenHonorer("DH1", "Computer Science", 5000);
        dh.setNama("Della");
        dh.setMataKulAjars(mataKulAjars(MatKulPilihan.DSA(), MatKulPilihan.OOP(), Status.HADIR, Status.HADIR, Status.ALPHA));
        return dh;
    }

    static Dosen dosenTetap(){
        DosenTetap dt = new DosenTetap("DT1", "Mathematics", 150000);
        dt.setNama("Darren");
        dt.setMataKulAjars(mataKulAjars(MataKuliah.AppliedMath(), MataKuliah.FurtherMath(), Status.HADIR, Status.HADIR, Status.HADIR));
        return dt;
    }

    static Karyawan karyawan(){

        Karyawan k = new Karyawan("K1", 80000, DataController.ps(Status.HADIR, Status.HADIR, Status.HADIR));
        k.setNama("Kale");
        return k;
    }

    static List<MataKulAjar> mataKulAjars(MataKuliah ma, MataKuliah mb, Status s1, Status s2, Status s3){
        MataKulAjar m1 = new MataKulAjar(ma, DataController.ps(s1, s2, s3));
        MataKulAjar m2 = new MataKulAjar(mb, DataController.ps(s1, s2,s3));
        List<MataKulAjar> mlist = new ArrayList<>();
        mlist.add(m1);
        mlist.add(m2);
        return mlist;
    }

    static List<PresensiStaff> ps(Status s1, Status s2, Status s3){

        PresensiStaff p1 = new PresensiStaff("17 April 2018", s1, 3);
        PresensiStaff p2 = new PresensiStaff("18 April 2018", s2, 3);
        PresensiStaff p3 = new PresensiStaff("19 April 2018", s3, 3);
        List<PresensiStaff> list = new ArrayList<>(); list.add(p1); list.add(p2); list.add(p3);
        return list;
    }


}
