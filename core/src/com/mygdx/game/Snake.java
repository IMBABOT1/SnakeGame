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
    private Vector2 position;

    private float velocity;

    private int offset;


    public Snake(TextureAtlas atlas){
        this.position = new Vector2(100, 100);
        this.texture = atlas.findRegion("Snake");
        this.velocity = 10;
        this.offset = 45;
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, position.x - offset, position.y - offset, 10, 10, 40, 40, 2, 2, 1);
    }

    public void update(float dt){
        System.out.println(position.x);
        checkCollisions();
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
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
        if (position.x > 600){
            position.x = 600;
        }
        if (position.x < 0 + offset){
            position.x = 0 + offset;
        }
        if (position.y > 600){
            position.y = 600;
        }
        if (position.y < 0 + offset){
            position.y = 0 + offset;
        }
    }
}
