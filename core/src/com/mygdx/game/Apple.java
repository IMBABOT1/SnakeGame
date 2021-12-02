package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Apple {

    private TextureRegion texture;
    private int cellX;
    private int cellY;

    public void setActive(boolean active) {
        isActive = active;
    }

    private boolean isActive;
    private GameScreen gameScreen;



    public Apple(TextureAtlas atlas, GameScreen gameScreen){
        this.gameScreen = gameScreen;
        this.texture = atlas.findRegion("Apple");
        this.cellX = MathUtils.random(0, 9);;
        this.cellY = MathUtils.random(0, 9);;
        this.isActive = true;
    }

    public void render(SpriteBatch batch){
        if (isActive) {
            batch.draw(texture, cellX * gameScreen.getGameMap().getCellSize(), cellY * gameScreen.getGameMap().getCellSize());
        }else {
            //position.set(MathUtils.random(0, 600), MathUtils.random(0, 600));
            cellX = MathUtils.random(0, 9);
            cellY = MathUtils.random(0, 9);
            isActive = true;
        }
    }

    public void update(float dt){

    }
}
