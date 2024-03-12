package com.dungeonrescue.menu;

import java.util.Scanner;

public class Menu {
    public void showMenu() {
        System.out.println("1. Nouvelle partie");
        System.out.println("2. Options");
        System.out.println("3. Quitter");

        // Lire la sélection de l'utilisateur
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        // Effectuer l'action en fonction de la sélection
        switch (choice) {
            case 1:
                System.out.println("Lancement d'une nouvelle partie...");
                break;
            case 2:
                System.out.println("Ouverture du menu des options...");
                break;
            case 3:
                System.out.println("Au revoir !");
                System.exit(0);
                break;
            default:
                System.out.println("Sélection invalide. Veuillez réessayer.");
        }
    }
}
