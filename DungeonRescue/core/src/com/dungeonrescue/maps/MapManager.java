package com.dungeonrescue.maps;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class MapManager  {
    public final float UNITSCALE= 1/32f;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;


    public MapManager(String levelPath){
        //Chargement de la carte
        map = new TmxMapLoader().load(levelPath);

        //Initialisation du rendu de la carte
        renderer = new OrthogonalTiledMapRenderer(map);

    }

    public void render() {
        // Logique de mise à jour et de rendu
        renderer.render();
    }

    //TODO: Methodes pour gérer les collisions
    public void resize(int i, int i1) {

    }

    public void pause() {

    }

    public void resume() {

    }

    public void hide() {

    }

    public void dispose() {
        map.dispose();
        renderer.dispose();
    }
}
