package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Terrain {
	
	private int tileData[][];
	private int width = 40;
	private int height = 40;
	private int tileSize = 80;
	
	//Basic Textures
	private Texture grassTexture;
	private int grassColor;
	private Texture desertTexture;
	private int desertColor;
	
	public Terrain(){
		tileData = new int[width][height];
		grassTexture = new Texture(Gdx.files.internal("grass1.png"));
		desertTexture = new Texture(Gdx.files.internal("desert1.png"));
		tileData[1][1] = 1;
		tileData[1][2] = 1;
		tileData[2][3] = 1;
	}
	
	public Terrain(String pathToBitmap){
		loadFromBitmap(pathToBitmap);
	}
	
	public void drawTerrain(SpriteBatch batch){
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				if(tileData[i][j] == 0){
					batch.draw(desertTexture, i*tileSize, j*tileSize, tileSize, tileSize);
				}
				if(tileData[i][j] == 1){
					batch.draw(grassTexture, i*tileSize, j*tileSize, tileSize, tileSize);
				}
			}
		}
	}
	
	public void loadFromBitmap(String path){
		Texture tex = new Texture (Gdx.files.internal(path));
		width = tex.getWidth();
		height = tex.getHeight();
		tileData = new int[width][height];
		Pixmap data = tex.getTextureData().consumePixmap();
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				tileData[i][j] = data.getPixel(i,j);
			}
		}
	}
	
	

}
