package com.dungeonrescue.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.dungeonrescue.player.Player;

public class GameScreen implements Screen {
    public final float UNITSCALE = 1 / 32f;
    private TiledMap map;
    int mapWidth, mapHeight;
    private OrthogonalTiledMapRenderer renderer;

    private OrthographicCamera camera;
    float cameraX, cameraY;
    float cameraSpeed = 100f;
    float cameraHalfWidth, cameraHalfHeight;
    private Player player;


    public GameScreen(String levelPath, Player player) {
        //Chargement de la carte
        map = new TmxMapLoader().load(levelPath);
        mapWidth = map.getProperties().get("width", Integer.class) * map.getProperties().get("tilewidth", Integer.class);
        mapHeight = map.getProperties().get("height", Integer.class) * map.getProperties().get("tileheight", Integer.class);

        //Initialiser la caméra
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //Initialisation du rendu de la carte
        renderer = new OrthogonalTiledMapRenderer(map);

        this.player = player;

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        // Calcul de la position anticipée de la caméra
        cameraX = player.getX() + cameraSpeed;
        cameraY = player.getY() + cameraSpeed;

        // Limitez la position de la caméra pour qu'elle reste à l'intérieur des limites de la carte
        cameraHalfWidth = camera.viewportWidth * 0.5f;
        cameraHalfHeight = camera.viewportHeight * 0.5f;
        cameraX = MathUtils.clamp(cameraX, cameraHalfWidth, mapWidth - cameraHalfWidth);
        cameraY = MathUtils.clamp(cameraY, cameraHalfHeight, mapHeight - cameraHalfHeight);

        // Mettez à jour la position de la caméra
        camera.position.set(cameraX, cameraY, 0);
        camera.update();

        // Effacer l'écran
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Logique de mise à jour et de rendu
        renderer.setView(camera);
        renderer.render();

    }
    // Détermine si la caméra doit suivre le joueur en fonction de la distance entre eux
    private boolean shouldFollowPlayer() {
        // Retourne vrai si la distance est supérieure à la distance seuil
        boolean b = Math.abs(player.getX() - cameraX) > 100 || Math.abs(player.getY() - cameraY) > 100;
        return b;
    }
    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false,width,height);
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

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
    }
}

