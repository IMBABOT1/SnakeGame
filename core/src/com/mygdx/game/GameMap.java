package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameMap {
    private static final int CELLS_X = 10;
    private static final int CELLS_Y = 10;
    private static final int CELL_SIZE = 64;

    private final int TERRAIN_GRASS = 0;
    private final int TERRAIN_OBSTACLE = 1;



    private byte[][] data;
    private TextureRegion groundTexture;

    public int getCellsX() {
        return CELLS_X;
    }

    public int getCellsY() {
        return CELLS_Y;
    }

    public int getCellSize() {
        return CELL_SIZE;
    }


    public GameMap(TextureAtlas atlas){
        this.data = new byte[CELLS_X][CELLS_Y];
        this.groundTexture = atlas.findRegion("BackGround");
    }


    public void render(SpriteBatch batch){
        for (int i = 0; i <= CELLS_X ; i++) {
            for (int j = 0; j <= CELLS_Y ; j++) {
                batch.draw(groundTexture, i * CELL_SIZE, j * CELL_SIZE);
            }
        }
    }

    public boolean isCellPossible(int cellX, int cellY){
        if (cellX < 0 || cellX > getCellsX() || cellY > getCellsY() || cellY < 0){
            return false;
        }
        return true;
    }



    public void update(float dt){
        
    }
}
