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
        font.draw(batch, builder, 10, 620);
    }

    public void update(float dt){
        checkBounds();
        movement(dt);
    }

    private void movement(float dt){
        if (Gdx.input.isKeyJustPressed(Input.Keys.D) && cellX < game.getGameMap().getCellsX()){
           cellX++;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.A) && cellX > 0){
            cellX--;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.W) && cellY < game.getGameMap().getCellsY()){
            cellY++;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.S) && cellY > 0){
            cellY--;
        }

          cellX += velocityRight;
//        cellX += velocityLeft;
//        cellY += velocityUp;
//        cellY += velocityDown;
    }



    private void checkBounds(){
//        if (position.x > right - offset){
//            position.x = right - offset;
//        }
//        if (position.x < left + offset - bound){
//            position.x = left + offset - bound;
//        }
//        if (position.y > top - offset - bound){
//            position.y = top - offset - bound;
//        }
//        if (position.y < bottom + offset - bound){
//            position.y = bottom + offset - bound;
//        }
    }
}