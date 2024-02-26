package com.dungeonrescue.game;

import com.badlogic.gdx.Game;
import com.dungeonrescue.screen.AlgerieScreen;
import com.dungeonrescue.screen.MapScreen2;

/**
 * DungeonRescue est la classe qui permet de gérer le jeu
 * Cette classe est caractérisée par les informations suivantes :
 * <ul>
 * <li>Description fonctionnelle de l'attribut 1</li>
 * <li>Description fonctionnelle de l'attribut 2</li>
 * </ul>
 * </p>
 * Description des principales fonctionnalités de la classe
 * Description complémentaire, sur les attributs statiques par exemple
 * </p>
 * @author nom de l'auteur
 * @version numéro de version
 */
public class DungeonRescue extends Game {

	public static final String TITLE = "Dungeon Rescue", VERSION = "0.0.0.0" ;
	public MapScreen2 map = new MapScreen2();
	@Override
	public void create () {
		setScreen(map);
	}

	@Override
	public void render () {
		map.render(1);
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width,height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
