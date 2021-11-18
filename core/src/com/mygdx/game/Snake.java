package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
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
    private float velocity;
    private int offset;

    private int left;
    private int bottom;
    private int right;
    private int top;

    private int score;



    public Snake(TextureAtlas atlas){
        this.position = new Vector2(100, 100);
        this.texture = atlas.findRegion("Snake");
        this.velocity = 10;
        this.offset = 45;
        this.left = 0;
        this.bottom = 0;
        this.right = 600;
        this.top = 600;
        this.score = 0;
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, position.x - offset, position.y - offset, 10, 10, 40, 40, 2, 2, 1);
    }

    public void addScore(int amount){
        score += amount;
    }

    public void update(float dt){
        checkCollisions();
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            position.x -= velocity;
        }else if (Gdx.input.isKeyPressed(Input.Keys.D)){
            position.x += velocity;
        }else if (Gdx.input.isKeyPressed(Input.Keys.S)){
            position.y -= velocity;
        }else if (Gdx.input.isKeyPressed(Input.Keys.W)){
            position.y += velocity;
        }
    }


    private void checkCollisions(){
        if (position.x > right){
            position.x = right;
        }
        if (position.x < left + offset){
            position.x = left + offset;
        }
        if (position.y > top){
            position.y = top;
        }
        if (position.y < bottom + offset){
            position.y = bottom + offset;
        }
    }
}
