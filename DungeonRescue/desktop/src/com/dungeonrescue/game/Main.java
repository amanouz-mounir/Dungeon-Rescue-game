package com.dungeonrescue.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.dungeonrescue.menu.Menu;

/**
 * La classe Main est responsable de lancer le jeu DungeonRescue.
 * Elle initialise le menu, affiche le menu, attend la sélection de l'utilisateur,
 * puis démarre le jeu principal en fonction de la sélection de l'utilisateur.
 *
 * Elle configure également la fenêtre de jeu en utilisant Lwjgl3.
 *
 * @Redwane Nom de l'auteur
 * @version Numéro de version
 */
public class Main {
	public static void main(String[] arg) {
		// Initialiser le menu
		Menu menu = new Menu();

		// Afficher le menu et attendre la sélection de l'utilisateur
		menu.showMenu();

		// Démarrer le jeu principal une fois que l'utilisateur a fait une sélection
		//GameMain game = new GameMain();
		//game.start();

		// Configuration de la fenêtre
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("DungeonRescue");
		config.setWindowedMode(1250, 720);

		// Lancer l'application avec la configuration
		new Lwjgl3Application(new DungeonRescue(), config);
	}
}
