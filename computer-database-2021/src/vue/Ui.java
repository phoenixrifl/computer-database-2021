package vue;

import java.util.Scanner;

public class Ui {

    private static Scanner sc;

    public static int demande() {
        sc = new Scanner(System.in);
        System.out.println("Liste des ordinateurs, tapez 1");
        System.out.println("Liste des compagnies, tapez 2");
        System.out.println("Détails d'un ordinateur, tapez 3");
        System.out.println("Créer un ordinateur, tapez 4");
        System.out.println("Mettre à jour un ordinateur, tapez 5");
        System.out.println("Supprimer un ordinateur, tapez 6");

        int input = sc.nextInt();

        return input;

    }

    public static Long demandeId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Donnez l'id");
        long input = sc.nextInt();
        return input;
    }

    public static String demandeCreate() {
        String computer = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Donnez un nom");
        String name = sc.nextLine();
        System.out.println("Donnez une date du format AAAA-MM-DD");
        String introduced = sc.nextLine();
        System.out.println("Donnez une date du format AAAA-MM-DD");
        String discontinued = sc.nextLine();
        System.out.println("Donnez l'id d'une compagnie");
        String company_id = sc.nextLine();
        computer += name + "," + introduced + "," + discontinued + "," + company_id;
        System.out.println(computer);
        return computer;
    }

    public static void afficher(Object obj) {
        System.out.println(obj);

    }
}
