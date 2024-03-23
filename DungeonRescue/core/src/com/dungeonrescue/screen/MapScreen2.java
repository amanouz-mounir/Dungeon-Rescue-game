package com.dungeonrescue.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.GL20;
import com.dungeonrescue.player.Player;

public class MapScreen2 implements Screen {
    private SpriteBatch batch;
    private Sprite map;
    private OrthographicCamera camera;

    @Override
    public void show() {
        batch = new SpriteBatch();
        Texture mapTexture = new Texture("samplemap.png");
        map = new Sprite(mapTexture);
        map.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //Initialisation de la camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false,30,20);
    }

    @Override
    public void render(float v) {
        //RESET de l'écran
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        map.draw(batch);;
        batch.end();
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

    @Override
    public void dispose() {

    }
}
