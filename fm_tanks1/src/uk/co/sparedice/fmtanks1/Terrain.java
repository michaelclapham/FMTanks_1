package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Terrain {
	
	private short tileData[][];
	private int width = 40;
	private int height = 40;
	private int tileSize = 20;
	private Texture grassTexture;
	
	public Terrain(){
		tileData = new short[width][height];
		grassTexture = new Texture(Gdx.files.internal("grass1.png"));
	}
	
	public void drawTerrain(SpriteBatch batch){
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				if(tileData[i][j] == 0){
					batch.draw(grassTexture, i*tileSize, j*tileSize, tileSize, tileSize);
				}
			}
		}
	}

}
