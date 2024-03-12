package com.dungeonrescue.maps;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class MapManager implements Screen {
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    private OrthographicCamera camera;

    public MapManager(String levelPath){
        //Chargement de la carte
        map = new TmxMapLoader().load(levelPath);

        //Initialisation du rendu de la carte
        renderer = new OrthogonalTiledMapRenderer(map);

        //Initialisation de la caméra
        camera = new OrthographicCamera();
        camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

    }

    @Override
    public void show() {

    }

    public void render(float delta) {
        // Logique de mise à jour et de rendu
        renderer.setView(camera);
        renderer.render();
    }


    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    public void dispose() {
        map.dispose();
        renderer.dispose();
    }
}
