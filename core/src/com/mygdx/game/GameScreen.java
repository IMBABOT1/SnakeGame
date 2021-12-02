package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen extends AbstractScreen {
    private Snake snake;
    private Apple apple;
    private BitmapFont font32;
    private GameMap gameMap;


    public GameScreen(SpriteBatch batch) {
        super(batch);
    }


    public GameMap getGameMap() {
        return gameMap;
    }


    @Override
    public void show() {
        this.snake = new Snake( this);
        this.apple = new Apple( this);
        this.font32 = Assets.getInstance().getAssetManager().get("fonts/font32.ttf");
        this.gameMap = new GameMap();
    }

    @Override
    public void render(float delta) {
        update(delta);
        ScreenUtils.clear(1, 1, 1, 1);
        batch.begin();
        gameMap.render(batch);
        snake.render(batch);
        apple.render(batch);
        snake.renderGUI(batch, font32);
        batch.end();
    }


    public void update(float dt) {
        snake.update(dt);
//		if (snake.getPosition().dst(apple.getPosition()) < 40){
//			apple.setActive(false);
//			snake.addScore(10);
//			snake.setSize(1);
//		}
    }
}