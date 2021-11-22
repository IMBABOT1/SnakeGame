package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameMap {
    public static final int CELLS_X = 10;
    public static final int CELLS_Y = 10;
    public static final int CELL_SIZE = 64;
    private byte[][] data;
    private TextureRegion groundTexture;




    public GameMap(TextureAtlas atlas){
        this.data = new byte[CELLS_X][CELLS_Y];
        this.groundTexture = atlas.findRegion("BackGround");
    }


    public void render(SpriteBatch batch){
        for (int i = 0; i < CELLS_X ; i++) {
            for (int j = 0; j < CELLS_Y ; j++) {
                batch.draw(groundTexture, i * CELL_SIZE, j * CELL_SIZE);
            }
        }
    }

    public void update(float dt){
        
    }
}
