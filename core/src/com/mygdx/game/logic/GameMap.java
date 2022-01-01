package com.mygdx.game.logic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.screens.utils.Assets;

public class GameMap {
    private static final int CELLS_X = 10;
    private static final int CELLS_Y = 10;
    private static final int CELL_SIZE = 64;
    private static final int CELLS = 10;


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

    public int getCells(){
        return CELLS;
    }




    public GameMap(){
        this.data = new byte[CELLS_X][CELLS_Y];
        this.groundTexture = Assets.getInstance().getAtlas().findRegion("BackGround");
    }


    public void render(SpriteBatch batch){
        for (int i = 0; i <= CELLS_X ; i++) {
            for (int j = 0; j <= CELLS_Y ; j++) {
                batch.draw(groundTexture, i * CELL_SIZE, j * CELL_SIZE);
            }
        }
    }

    public void update(float dt){
        
    }
}
