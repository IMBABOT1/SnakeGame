package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Snake {

    private float cellX;
    private float cellY;

    private TextureRegion texture;

    private int score;
    private StringBuilder builder;
    private GameScreen gameScreen;


    private boolean isDPressed;
    private boolean isSPressed;
    private boolean isWPressed;
    private boolean isAPressed;

    private float speed;

    public Snake(GameScreen gameScreen){
        this.gameScreen = gameScreen;
        this.cellX = 0;
        this.cellY = 0;
        this.texture = Assets.getInstance().getAtlas().findRegion("Snake");
        this.score = 0;
        this.builder = new StringBuilder();
        this.isDPressed = false;
        this.isAPressed = false;
        this.isSPressed = false;
        this.isWPressed = false;
        this.speed = 0.1f;

    }

    public void render(SpriteBatch batch){
        batch.draw(texture, cellX * gameScreen.getGameMap().getCellSize(), cellY * gameScreen.getGameMap().getCellSize());
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
        if (isDPressed && cellX < gameScreen.getGameMap().getCellsX()){
            cellX += speed;
        }
        if (isAPressed && cellX > 0){
            cellX -= speed;
        }
        if (isWPressed && cellY < gameScreen.getGameMap().getCellsY()){
            cellY += speed;
        }
        if (isSPressed && cellY > 0){
            cellY -= speed;
        }
    }
}
