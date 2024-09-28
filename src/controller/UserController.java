package controller;

import model.Mahasiswa.Dokter;
import model.Mahasiswa.Master;
import model.Mahasiswa.Sarjana;
import model.User;
import view.UserView;

import java.util.Objects;

public class UserController implements Options {

    UserView view = new UserView();

    public UserController(){
        view.Portal();
        MainMenu();
    }

    public void MainMenu() {
        while (true) {
            switch (view.showMainMenu()) {
                case VIEWDATA:
                    String name = view.inputName();
                    User user = DataController.getByName(name);
                    if (user != null)
                        view.viewData(user);
                    else view.userIsNotFound();
                    break;

                case VIEWNILAIAKHIR:
                    view.Doktor_or_Mahasiswa();
                    String nim = view.inputNIM();
                    user = DataController.getByNIM(nim);
                    if ((user instanceof Sarjana || user instanceof Master)) {
                        String kode = view.inputKodeMK();
                        view.viewNA(user, kode);
                    }
                    else if (user instanceof Dokter){
                        view.viewNA_Dokter(user);
                    }
                    else view.userIsNotFound();
                    break;

                case VIEWRATARATA_NA:
                    String choice = view.Doktor_or_Mahasiswa();
                    if (Objects.equals(choice, "Dokter")){
                        view.viewRataRata_Dokter();
                    }else {
                        String kode = view.inputKodeMK();
                        view.viewRataRata(kode);
                    }
                    break;

                case VIEWTIDAKLULUS:
                    choice = view.Doktor_or_Mahasiswa();
                    if (Objects.equals(choice, "Dokter")){
                        view.viewTidakLulus_Dokter();
                    }
                    String kode = view.inputKodeMK();
                    view.viewTidakLulus(kode);
                    break;

                case VIEWTOTALPRESENSI:
                     nim = view.inputNIK();
                     user = DataController.getByNIM(nim);
                    if (user != null)
                        view.viewPresensi(user);
                    else view.userIsNotFound();
                    break;

                case VIEWJAM_NGAJAR:
                    String nik = view.inputNIK();
                    user = DataController.getByNIK(nik);
                    if (user != null)
                        view.ViewJamNgajar(user);
                    else view.userIsNotFound();
                    break;

                case VIEWGAJI:
                    nik = view.inputNIK();
                    user = DataController.getByNIK(nik);
                    if (user != null)
                        view.viewGaji(user);
                    else view.userIsNotFound();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new UserController();
    }

}
