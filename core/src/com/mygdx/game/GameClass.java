package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameClass extends ApplicationAdapter {
	private SpriteBatch batch;
	private Snake snake;
	private Apple apple;
	private BitmapFont font32;
	private GameMap gameMap;
	private TextureAtlas atlas;


	public TextureAtlas getAtlas() {
		return atlas;
	}


	public GameMap getGameMap() {
		return gameMap;
	}


	@Override
	public void create () {
		batch = new SpriteBatch();
		atlas = new TextureAtlas("game.pack");
		snake = new Snake(atlas, this);
		apple = new Apple(atlas, this);
		font32 = new BitmapFont(Gdx.files.internal("font32.fnt"));
		gameMap = new GameMap(atlas);
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);
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
	public void dispose () {
		batch.dispose();
	}
}