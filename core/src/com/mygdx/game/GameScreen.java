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


    public Apple getApple() {
        return apple;
    }


    @Override
    public void show() {
        this.gameMap = new GameMap();
        this.snake = new Snake( this);
        this.apple = new Apple( this);
        this.font32 = Assets.getInstance().getAssetManager().get("fonts/font32.ttf");
    }

    @Override
    public void render(float delta) {
        update(delta);
        ScreenUtils.clear(1, 1, 1, 1);
        batch.begin();
        gameMap.render(batch);
        apple.render(batch);
        snake.render(batch);
        snake.renderGUI(batch, font32);
        batch.end();
    }


    public void update(float dt) {
        snake.update(dt);
    }
}