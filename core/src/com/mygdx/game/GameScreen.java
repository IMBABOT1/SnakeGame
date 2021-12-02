package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    private SpriteBatch batch;
    private Snake snake;
    private Apple apple;
    private BitmapFont font32;
    private GameMap gameMap;
    private TextureAtlas atlas;


    public GameScreen(SpriteBatch batch){
        this.batch = batch;
    }


    public GameMap getGameMap() {
        return gameMap;
    }


    @Override
    public void show() {
        this.atlas = new TextureAtlas("game.pack");
        this.snake = new Snake(atlas, this);
        this.apple = new Apple(atlas, this);
        this.font32 = new BitmapFont(Gdx.files.internal("font32.fnt"));
        this.gameMap = new GameMap(atlas);
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


    public void update(float dt){
        snake.update(dt);
//		if (snake.getPosition().dst(apple.getPosition()) < 40){
//			apple.setActive(false);
//			snake.addScore(10);
//			snake.setSize(1);
//		}
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }
}
