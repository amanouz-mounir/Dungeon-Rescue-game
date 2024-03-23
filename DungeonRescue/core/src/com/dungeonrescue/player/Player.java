package com.dungeonrescue.player;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.dungeonrescue.enemy.Enemy;
import com.dungeonrescue.item.Sword;
/**
 * Classe gérant le joueur principale
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
public class Player {

    private float x, y;
    private float size;
    private Color color;
    private boolean hasSword;
    private Sword sword; // Ajout de l'instance de Sword
    private float velocity;

    public Player(float x, float y, float size, Color color,float velocity) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.hasSword = false;
        this.sword = new Sword(x + size, y, 10, 10, Color.BLUE); // Position initiale de l'épée
        this.velocity = velocity;

    }

    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(x, y, size, size);
        shapeRenderer.end();

        // Dessiner l'épée si le joueur l'a
        if (hasSword) {
            sword.render(shapeRenderer);
        }
    }


    public void move(float deltaX, float deltaY) {
        x += deltaX;
        y += deltaY;

        // Mettez à jour la position de l'épée en fonction du joueur
        sword.setX(x + size);
        sword.setY(y);
    }
    public void setVelocity(float velocity){this.velocity = velocity;}

    public boolean hasSword() {
        return hasSword;
    }

    public void setHasSword(boolean hasSword) {
        this.hasSword = hasSword;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }

    // Ajoutez d'autres méthodes selon les besoins
    public void attackEnemy(Enemy enemy) {
        if (hasSword && getBounds().overlaps(enemy.getBounds())) {
            enemy.takeDamage(10); // À ajuster selon vos besoins
        }
    }

    public void tryPickupSword(Sword sword) {
        // Ramasser l'épée si elle est à proximité
        if (sword.getBounds().overlaps(getBounds())) {
            setHasSword(true);
            // Mise à jour la position de l'épée pour qu'elle suive le joueur
            sword.setX(x + size);
            sword.setY(y);
        }
    }

    public Rectangle getSwordBounds() {
        return sword.getBounds();
    }

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public float getVelocity(){return velocity;}
    public void displayPosition(){
        System.out.println("Player Position : "+x+", "+y);
    }

}
