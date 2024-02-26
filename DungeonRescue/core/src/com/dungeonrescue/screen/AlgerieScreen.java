package com.dungeonrescue.screen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * AlgerieView est un exemple de classe de vue qui permet de gérer la vue d'un élément du jeu
 * Cette classe est caractérisée par les informations suivantes :
 * <ul>
 * <li> Lot de Sprite pour les animations
 * <li> Sprites des différente animations
 * </ul>
 * </p>
 * Description des principales fonctionnalités de la classe
 * Description complémentaire, sur les attributs statiques par exemple
 * </p>
 * @author Younes
 * @version 0.0.0.0
 */
public class AlgerieScreen extends ShapeRenderer implements Screen {

    /**
     * Papier à sprite
     */
    private SpriteBatch batch;
    /**
     * Sprite associer à une Image
     */
    private Sprite algerie;
    /**
     * Papier à dessin
     */
    private ShapeRenderer shapeRenderer;


    @Override
    public void show() {
        //Initialisation de l'instance
        batch = new SpriteBatch();
        Texture algerieTexture = new Texture("algerie.png");
        algerie = new Sprite(algerieTexture);
        shapeRenderer = new ShapeRenderer();

        algerie.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

    }

    @Override
    public void render(float v) {
        //RESET de l'arriére plan
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        //Dessin du sprite algerie sur le Papier
        algerie.draw(batch);
        batch.end();

        shapeRenderer.begin(ShapeType.Filled);

        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.circle(625,360,50);

        shapeRenderer.rect(10,10,10,10,20,20,1,1,45,Color.BLUE,Color.RED,Color.CYAN,Color.CORAL);
        shapeRenderer.end();
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
