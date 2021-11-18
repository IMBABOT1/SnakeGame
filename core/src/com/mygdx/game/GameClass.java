package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameClass extends ApplicationAdapter {
	private SpriteBatch batch;
	private Snake snake;

	public TextureAtlas getAtlas() {
		return atlas;
	}

	private TextureAtlas atlas;


	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.atlas = new TextureAtlas("main.pack");
		this.snake = new Snake(atlas);
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);
		ScreenUtils.clear(0, 1, 0, 1);
		batch.begin();
		snake.render(batch);
		batch.end();
	}

	public void update(float dt){
		snake.update(dt);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
