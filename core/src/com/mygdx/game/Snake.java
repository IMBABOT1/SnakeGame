package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Snake {

    private TextureRegion texture;
    private Vector2 position;


    public Snake(TextureAtlas atlas){
        this.position = new Vector2(100, 100);
        this.texture = atlas.findRegion("Snake");
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, position.x - 20, position.y-20, 10, 10, 80, 80, 1, 1, 1);
    }

    public void update(float dt){

    }
}
