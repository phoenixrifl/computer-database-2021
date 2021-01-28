package controller;

import service.CompanyService;
import service.ComputerService;
import vue.Ui;

public class Controller {

    private ComputerService computerService = ComputerService.getInstance();
    private CompanyService companyService = CompanyService.getInstance();
    public void action() {

        int choix = Ui.demande();
        switch(choix) {
            case 1:
                Ui.afficher(computerService.findAll());
                break;
            case 2:
                Ui.afficher(companyService.findAll());
                break;
            case 3:
                Long id = Ui.demandeId();
                Ui.afficher(computerService.findOne(id));
                break;
            case 4:
                computerService.createDTO(Ui.demandeCreate());
                break;
            case 5:
                id = Ui.demandeId();
                computerService.createComputerDtoWithId(id, Ui.demandeCreate());
                break;
            case 6:
                computerService.delete(Ui.demandeId()); //à faire
                break;
            default:
                System.out.println();
        }
    }
}
