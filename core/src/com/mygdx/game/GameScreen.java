package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.logic.Apple;
import com.mygdx.game.screens.AbstractScreen;
import com.mygdx.game.screens.utils.Assets;
import com.mygdx.game.logic.GameMap;
import com.mygdx.game.logic.Snake;

import java.awt.*;

public class GameScreen extends AbstractScreen {
    private Snake snake;
    private Apple apple;
    private BitmapFont font32;
    private GameMap gameMap;
    private ShapeRenderer shapeRenderer;

    private static final int SNAKE_SIZE = 32;


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
        this.shapeRenderer = new ShapeRenderer();
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
        snake.renderGUI(batch, font32);
        apple.render(batch);
   //     snake.render(batch);
        snake.drawHead(batch, shapeRenderer);
        batch.end();
    }


    public void update(float dt) {
        snake.update(dt);
    }
}