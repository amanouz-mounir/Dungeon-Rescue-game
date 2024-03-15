package com.dungeonrescue.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.dungeonrescue.boss.Boss;
import com.dungeonrescue.enemy.Enemy;
import com.dungeonrescue.item.Sword;
import com.dungeonrescue.maps.MapManager;
import com.dungeonrescue.player.Player;
import com.dungeonrescue.screen.MapScreen2;
import com.badlogic.gdx.graphics.g2d.BitmapFont;


import java.util.ArrayList;
import java.util.List;



public class DungeonRescue extends Game {

    public static final String TITLE = "Dungeon Rescue";
    public static final String VERSION = "0.0.0.0";

    private List<Enemy> enemies;
    private ShapeRenderer shapeRenderer;
    private Player player;
    private Sword sword;
    private Sound attackSound;
    private Sound hitSound;

    private BitmapFont font;
    private Batch batch;


    @Override
    public void create() {
        // Initialisation des ennemis
        player = new Player(50, 50, 20, Color.WHITE);
        enemies = new ArrayList<>();
        enemies.add(new Enemy(100, 100, 20, 20, font)); // Ajouter un ennemi initial
        enemies.add(new Enemy(300, 300, 20, 20, font)); // Deuxième ennemi
        enemies.add(new Boss(100, 100, 20, 20, 100, font, batch)); // Ajouter un boss initial

        // Initialisation de l'épée
        sword = new Sword(200, 200, 10, 10, Color.BLUE);


        // Charger les sons
        attackSound = Gdx.audio.newSound(Gdx.files.internal("Sounds/swinging-staff-whoosh-strong-08-44658.mp3"));
        hitSound = Gdx.audio.newSound(Gdx.files.internal("Sounds/Roblox Death Sound (Oof) - Sound Effect (HD).mp3"));

        // Initialisation du ShapeRenderer
        shapeRenderer = new ShapeRenderer();

        // Initialisation du Batch
        batch = new SpriteBatch();

        // Initialisation de la police BitmapFont
        font = new BitmapFont();

        setScreen(new MapScreen2());
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1); // Définir la couleur de fond
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Effacer le tampon graphique

        handleInput();

        player.render(shapeRenderer); // Dessinez le joueur

        for (Enemy enemy : enemies) {
            enemy.update();
            enemy.render(shapeRenderer);
            enemy.renderHealth(shapeRenderer, font, batch); // Passer le Batch en tant que paramètre
        }

        if (!player.hasSword()) {
            sword.render(shapeRenderer);
        }
    }

    private void handleInput() {
        float speed = 5f;

        // Vérifiez quelles touches sont enfoncées et déplacez le joueur en conséquence
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.move(-speed, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.move(speed, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.move(0, speed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.move(0, -speed);
        }

        // Jouer le son d'attaque lorsque la touche d'attaque est enfoncée
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            attackSound.play();
            handleAttack(); // Nouvelle méthode pour gérer l'attaque
        }

        // Ramasser l'épée quand la touche E ou e est enfoncée
        if (Gdx.input.isKeyJustPressed(Input.Keys.E) || Gdx.input.isKeyPressed(69) || Gdx.input.isKeyPressed(69)) {
            System.out.println("E key pressed");
            if (!player.hasSword()) {
                player.tryPickupSword(sword); // Appel de la méthode pour ramasser l'épée
            }
        }

        // Jouer le son d'attaque lorsque le clic gauche de la souris est enfoncé
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            attackSound.play();
            handleAttack(); // Nouvelle méthode pour gérer l'attaque
        }
    }



    private void handleAttack() {
        for (Enemy enemy : enemies) {
            if (player.getBounds().overlaps(enemy.getBounds()) && player.hasSword()) {
                enemy.takeDamage(10);
                hitSound.play();
            }
        }
    }

    private void handlePickupSword() {
        System.out.println("Attempting to pick up sword"); // Débogage pour vérifier si la méthode est appelée
        for (Enemy enemy : enemies) {
            if (sword.getBounds().overlaps(enemy.getBounds())) {
                // Débogage pour vérifier les coordonnées des rectangles de collision de l'épée et du joueur
                System.out.println("Player bounds: " + player.getBounds());
                System.out.println("Sword bounds: " + sword.getBounds());

                player.setHasSword(true);
                System.out.println("Sword picked up successfully"); // Débogage pour vérifier si l'épée est ramassée
                break;
            }
        }
    }

    // Nouvelle méthode pour dessiner les dégâts
    private void drawDamageNumber(float x, float y, int damage) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(x, y, 30, 30); // Exemple : dessinez un rectangle rouge pour représenter les dégâts
        shapeRenderer.end();

        // Utilisez BitmapFont avec Batch pour dessiner le texte
        batch.begin();
        font.draw(batch, "-" + damage, x, y + 20);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        shapeRenderer.dispose();
        batch.dispose();
        font.dispose();
    }
}
