package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Apple {

    private TextureRegion texture;
    private Vector2 position;

    public void setActive(boolean active) {
        isActive = active;
    }

    private boolean isActive;


    public Vector2 getPosition() {
        return position;
    }

    public Apple(TextureAtlas atlas){
        this.texture = atlas.findRegion("Apple");
        this.position = new Vector2(MathUtils.random(0, 550), MathUtils.random(0, 550));
        this.isActive = true;
    }

    public void render(SpriteBatch batch){
        if (isActive) {
            batch.draw(texture, position.x - 30, position.y - 30);
        }else {
            position.set(MathUtils.random(0, 600), MathUtils.random(0, 600));
            isActive = true;
        }
    }

    public void update(float dt){

    }
}
