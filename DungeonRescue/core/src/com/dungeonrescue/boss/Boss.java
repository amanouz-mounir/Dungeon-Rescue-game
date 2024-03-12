package com.dungeonrescue.boss;

import com.dungeonrescue.enemy.Enemy;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Boss extends Enemy {

    private int health;

    public Boss(float centerX, float centerY, float width, float height, int health) {
        super(centerX, centerY, width, height);
        this.health = health;
    }

    @Override
    public void update() {
        super.update();
        // Logique de mise à jour spécifique au boss (mouvement, attaques, etc.)
    }

    @Override
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(getX(), getY(), getWidth(), getHeight());
        shapeRenderer.end();
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
