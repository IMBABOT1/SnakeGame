package com.mygdx.game.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameScreen;
import com.mygdx.game.screens.utils.Assets;

public class Snake {


    private TextureRegion texture;


    private int score;
    private StringBuilder builder;
    private GameScreen gameScreen;


    private boolean isDPressed;
    private boolean isSPressed;
    private boolean isWPressed;
    private boolean isAPressed;

    private float speed;
    private Vector2 position;


    public Snake(GameScreen gameScreen){
        this.gameScreen = gameScreen;
        this.position = new Vector2(0, 0);
        this.texture = Assets.getInstance().getAtlas().findRegion("Snake");
        this.score = 0;
        this.builder = new StringBuilder();
        this.isDPressed = false;
        this.isAPressed = false;
        this.isSPressed = false;
        this.isWPressed = false;
        this.speed = 0.1f;
    }


    public Vector2 getPosition() {
        return position;
    }


    public void render(SpriteBatch batch){
        batch.draw(texture, position.x * gameScreen.getGameMap().getCellSize(), position.y * gameScreen.getGameMap().getCellSize());
    }


    public void addScore(int amount){
        score += amount;
    }

    public void renderGUI(SpriteBatch batch, BitmapFont font) {
        builder.setLength(0);
        builder.append("Score: ").append(score).append("\n");
        font.draw(batch, builder, 10, 700);
    }

    public void update(float dt){
        isPressed();
        movement(dt);
        eatApple();
    }

    private void eatApple(){
        if (position.dst(gameScreen.getApple().getPosition()) < 0.5f){
            gameScreen.getApple().setActive(false);
            addScore(10);
        }
    }

    private void isPressed(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.D)){
            isDPressed = true;
            isAPressed = false;
            isSPressed = false;
            isWPressed = false;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)){
            isDPressed = false;
            isAPressed = false;
            isSPressed = false;
            isWPressed = true;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.S)){
            isDPressed = false;
            isAPressed = false;
            isSPressed = true;
            isWPressed = false;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.A)){
            isDPressed = false;
            isAPressed = true;
            isSPressed = false;
            isWPressed = false;
        }
    }

    private void movement(float dt){
        if (isDPressed && position.x < gameScreen.getGameMap().getCellsX()){
            position.x += speed;
        }
        if (isAPressed && position.x > 0){
            position.x -= speed;
        }
        if (isWPressed && position.y < gameScreen.getGameMap().getCellsY()){
            position.y += speed;
        }
        if (isSPressed && position.y > 0){
            position.y -= speed;
        }
    }
}