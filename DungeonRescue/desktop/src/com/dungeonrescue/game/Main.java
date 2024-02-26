package com.dungeonrescue.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

/**
 * DeskopLauncher est la classe qui permet de lancer le jeu
 * Cette classe est caractérisée par les informations suivantes :
 * <ul>
 * <li>Description fonctionnelle de l'attribut 1</li>
 * <li>Description fonctionnelle de l'attribut 2</li>
 * </ul>
 * Description des principales fonctionnalités de la classe
 * </p>
 * Description complémentaire, sur les attributs statiques par exemple
 * </p>
 * @author nom de l'auteur
 * @version numéro de version
 */

public class Main {
	public static void main (String[] arg) {
		//Configuration de la fenêtre
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("DungeonRescue");
		config.setWindowedMode(1250,720);
		new Lwjgl3Application(new DungeonRescue(), config);
	}
}
