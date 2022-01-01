package com.mygdx.game.logic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameScreen;
import com.mygdx.game.screens.utils.Assets;

public class Apple {

    private TextureRegion texture;
    private Vector2 position;
    private boolean isActive;
    private GameScreen gameScreen;


    public Vector2 getPosition() {
        return position;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Apple(GameScreen gameScreen){
        this.gameScreen = gameScreen;
        this.texture = Assets.getInstance().getAtlas().findRegion("Apple");
        this.isActive = true;
        this.position = new Vector2(0, 0);
        this.position.x = MathUtils.random(0, gameScreen.getGameMap().getCells());
        this.position.y = MathUtils.random(0, gameScreen.getGameMap().getCells());
    }

    public void render(SpriteBatch batch){
        if (isActive) {
            batch.draw(texture, position.x * gameScreen.getGameMap().getCellSize(), position.y * gameScreen.getGameMap().getCellSize());
        }else {
            position.x = MathUtils.random(0, gameScreen.getGameMap().getCells());
            position.y = MathUtils.random(0, gameScreen.getGameMap().getCells());
            isActive = true;
        }
    }

    public void update(float dt){
    }
}
