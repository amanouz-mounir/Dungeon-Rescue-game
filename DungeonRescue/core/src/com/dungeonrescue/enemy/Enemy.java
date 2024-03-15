package com.dungeonrescue.enemy;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Batch;



public class Enemy {

    private float x, y;
    private float width, height;
    private float angle = 0; // Angle pour le mouvement circulaire
    private float radius = 50; // Rayon du cercle
    private float centerX, centerY; // Coordonnées du centre du cercle
    private int health = 100; // Ajoutez cette ligne
    protected BitmapFont font; // Ajoutez cette ligne pour déclarer la police

    public Enemy(float centerX, float centerY, float width, float height, BitmapFont font) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.height = height;
        this.font = font;
    }

    public void update() {
        // Mettez à jour les coordonnées en fonction de l'angle et du centre du cercle
        x = centerX + (float) Math.cos(Math.toRadians(angle)) * radius;
        y = centerY + (float) Math.sin(Math.toRadians(angle)) * radius;

        // Augmentez l'angle pour que l'ennemi fasse un tour complet (360 degrés) en un certain temps
        angle += 2; // Ajustez la vitesse de rotation en changeant la valeur ici
        if (angle > 360) {
            angle -= 360; // Réinitialisez l'angle à 0 après un tour complet
        }
    }

    public void renderHealth(ShapeRenderer shapeRenderer, BitmapFont font, Batch batch) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(x, y - 10, width * (health / 100.0f), 5); // Barre de vie rouge
        shapeRenderer.end();

        batch.begin();
        font.draw(batch, String.valueOf(health), x, y - 15); // Affiche les points de vie au-dessus de l'ennemi
        batch.end();
    }

    public void render(ShapeRenderer shapeRenderer) {
        // Dessinez l'ennemi avec LibGDX
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE); // Utilisez la couleur blanche
        shapeRenderer.rect(x, y, width, height); // Dessinez un rectangle
        shapeRenderer.end();
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            // L'ennemi a été vaincu, implémentez les actions nécessaires ici
            reset(); // Réinitialisez l'ennemi (ou retirez-le de la liste, selon vos besoins)
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    private void reset() {
        // Réinitialisez les propriétés de l'ennemi (par exemple, remettez-le à sa position de départ)
        // angle = 0;
        // health = 100; // Remettez les points de vie à la valeur initiale
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getCenterX() {
        return centerX;
    }

    public void setCenterX(float centerX) {
        this.centerX = centerX;
    }

    public float getCenterY() {
        return centerY;
    }

    public void setCenterY(float centerY) {
        this.centerY = centerY;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}