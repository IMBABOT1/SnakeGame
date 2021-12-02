package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Snake {

    private int cellX;
    private int cellY;

    private TextureRegion texture;
    private float velocityRight;
    private float velocityLeft;
    private float velocityUp;
    private float velocityDown;
    private int offset;

    private float left;
    private float bottom;
    private float right;
    private float top;

    private int score;
    private StringBuilder builder;
    private GameClass game;


    private float bound;

    public void setSize(int size) {
        this.size += size;
    }

    private int size;


    private boolean isDPressed;
    private boolean isSPressed;
    private boolean isWPressed;
    private boolean isAPressed;

    public Snake(TextureAtlas atlas, GameClass game){
        this.game = game;
        this.cellX = 0;
        this.cellY = 0;
        this.texture = atlas.findRegion("Snake");
        this.velocityRight = 0;
        this.velocityLeft = 0;
        this.velocityUp = 0;
        this.velocityDown = 0;
        this.bound = 6;
        this.offset = 32;
        this.left = 0;
        this.bottom = 0;
        this.right = 640;
        this.top = 640;
        this.score = 0;
        this.builder = new StringBuilder();
        this.size = 0;
        this.isDPressed = false;
        this.isAPressed = false;
        this.isSPressed = false;
        this.isWPressed = false;

    }

    public void render(SpriteBatch batch){
        batch.draw(texture, cellX * game.getGameMap().getCellSize(), cellY * game.getGameMap().getCellSize());
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
        if (Gdx.input.isKeyJustPressed(Input.Keys.D) && is  game.getGameMap().isCellPossible(cellX + 1, cellY)){
            cellX++;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.A) &&  game.getGameMap().isCellPossible(cellX - 1, cellY)){
            cellX--;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.W) && game.getGameMap().isCellPossible(cellX, cellY + 1)){
            cellY++;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.S) && game.getGameMap().isCellPossible(cellX, cellY - 1)){
            cellY--;
        }
    }
}
