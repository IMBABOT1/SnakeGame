package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Snake {

    private TextureRegion texture;

    public Vector2 getPosition() {
        return position;
    }

    private Vector2 position;
    private float velocityRight;
    private float velocityLeft;
    private float velocityUp;
    private float velocityDown;
    private int offset;

    private int left;
    private int bottom;
    private int right;
    private int top;

    private int score;
    private StringBuilder builder;

    private int speed;



    public Snake(TextureAtlas atlas){
        this.position = new Vector2(100, 100);
        this.texture = atlas.findRegion("Snake");
        this.speed = 5;
        this.velocityRight = 0;
        this.velocityLeft = 0;
        this.velocityUp = 0;
        this.velocityDown = 0;
        this.offset = 20;
        this.left = 0;
        this.bottom = 0;
        this.right = 600;
        this.top = 600;
        this.score = 0;
        this.builder = new StringBuilder();

    }

    public void render(SpriteBatch batch){
        batch.draw(texture, position.x - offset, position.y - offset, offset, offset, 40, 40, 2, 2, 0);
    }

    public void addScore(int amount){
        score += amount;
    }

    public void renderGUI(SpriteBatch batch, BitmapFont font) {
        builder.setLength(0);
        builder.append("Score: ").append(score).append("\n");
        font.draw(batch, builder, 10, 580);
    }

    public void update(float dt){
        checkBounds();
        movement();

    }


    private void movement(){
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            velocityRight = speed;
            velocityLeft = 0;
            velocityUp = 0;
            velocityDown = 0;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            velocityRight = 0;
            velocityLeft = speed;
            velocityUp = 0;
            velocityDown = 0;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            velocityDown = 0;
            velocityUp = speed;
            velocityLeft = 0;
            velocityRight = 0;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            velocityDown = speed;
            velocityUp = 0;
            velocityRight = 0;
            velocityLeft = 0;
        }
        position.x += velocityRight;
        position.x -= velocityLeft;
        position.y += velocityUp;
        position.y -= velocityDown;
    }



    private void checkBounds(){
        if (position.x > right){
            position.x = right;
        }
        if (position.x < left + offset){
            position.x = left + offset;
        }
        if (position.y > top - offset){
            position.y = top - offset;
        }
        if (position.y < bottom + offset){
            position.y = bottom + offset;
        }
    }
}
