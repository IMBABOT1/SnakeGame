package com.mygdx.game.logic;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.screens.ScreenManager;

public class GameClass extends Game {
	private SpriteBatch batch;

	public void create () {
		batch = new SpriteBatch();
		ScreenManager.getInstance().init(this, batch);
		ScreenManager.getInstance().changeScreen(ScreenManager.ScreenType.GAME);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		float dt = Gdx.graphics.getDeltaTime();
		getScreen().render(dt);
	}

	public void update(float dt){

	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}