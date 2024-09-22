package controller;

import model.User;
import view.UserView;

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
                    String nim = view.inputNIM();
                    String kode = view.inputKodeMK();
                    user = DataController.getByNIM(nim);
                    if (user != null)
                        view.viewNA(user, kode);
                    else view.userIsNotFound();
                    break;

                case VIEWRATARATA_NA:
                    kode = view.inputKodeMK();
                    view.viewRataRata(kode);
                    break
                            ;
                case VIEWTIDAKLULUS:
                    kode = view.inputKodeMK();
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
