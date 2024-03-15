package com.dungeonrescue.boss;

import com.dungeonrescue.enemy.Enemy;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Boss extends Enemy {

    private int health;
    private BitmapFont font;
    private Batch batch;

    public Boss(float centerX, float centerY, float width, float height, int health, BitmapFont font, Batch batch) {
        super(centerX, centerY, width, height,font);
        this.health = health;
        this.font = font;
        this.batch = batch;
    }

    @Override
    public void update() {
        super.update();
        // Logique de mise à jour spécifique au boss (mouvement, attaques, etc.)
    }

    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(getX(), getY(), getWidth(), getHeight());
        shapeRenderer.end();
    }
    public void renderHealth(ShapeRenderer shapeRenderer, BitmapFont font, Batch batch) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(getX(), getY() - 10, getWidth() * (health / 100.0f), 5); // Barre de vie rouge
        shapeRenderer.end();

        // Commencez le dessin avec le lot (batch) avant d'utiliser la référence de BitmapFont
        batch.begin();
        font.draw(batch, String.valueOf(health), getX(), getY() - 15); // Affiche les points de vie au-dessus du boss
        batch.end(); // Terminez le dessin avec le lot (batch)
    }




    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            // Le boss a été vaincu, implémentez les actions nécessaires ici
        }
    }
}
