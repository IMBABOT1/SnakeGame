package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Snake {



    private TextureRegion texture;
    private Vector2 position;
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

    private float speed;

    private float bound;

    public void setSize(int size) {
        this.size += size;
    }

    private int size;
    public Vector2 getPosition() {
        return position;
    }


    public Snake(TextureAtlas atlas){
        this.position = new Vector2(100, 100);
        this.texture = atlas.findRegion("Snake");
        this.speed = 300;
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
        batch.draw(texture, position.x - offset, position.y - offset);
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
        System.out.println(size);

    }

    private void movement(float dt){
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

        position.x += velocityRight * dt;
        position.x -= velocityLeft * dt;
        position.y += velocityUp * dt;
        position.y -= velocityDown * dt;
    }



    private void checkBounds(){
        if (position.x > right - offset){
            position.x = right - offset;
        }
        if (position.x < left + offset - bound){
            position.x = left + offset - bound;
        }
        if (position.y > top - offset - bound){
            position.y = top - offset - bound;
        }
        if (position.y < bottom + offset - bound){
            position.y = bottom + offset - bound;
        }
    }
}