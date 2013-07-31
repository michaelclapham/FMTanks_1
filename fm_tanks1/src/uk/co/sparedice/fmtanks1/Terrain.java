package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Terrain object as Actor. Loads images and tiles them together to make background terrain
 * @author Michael
 */

public class Terrain extends Actor {
	
	private int tileData[][];
	private int width = 40;
	private int height = 40;
	private int tileSize = 80;
	
	//Basic Textures
	private Texture grassTexture;
	private int grassColor;
	private Texture desertTexture;
	private int desertColor;
	
	//Tank Container
	private TankContainer tankContainer;
	
	public Terrain(TankContainer tankContainer){
		this.tankContainer = tankContainer;
		tileData = new int[width][height];
		grassTexture = new Texture(Gdx.files.internal("grass1.png"));
		desertTexture = new Texture(Gdx.files.internal("desert1.png"));
		
		//Add click listener
		setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		addListener(new ClickListener(){

			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Terrain)event.getTarget()).onClick(event,x,y);
			}
			
		});
		
		tileData[1][1] = 1;
		tileData[1][2] = 1;
		tileData[2][3] = 1;
	}
	
	public void draw(SpriteBatch batch, float parentAlpha){
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
	
	private void loadFromBitmap(String path){
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
	
	/**
	 * Returns if a position in the game world is an obstacle.
	 * Does not vary depending upon camera position. Does vary depending on 
	 * tile size.
	 * @param x
	 * @param y
	 * @return 
	 */
	public boolean isObstable(float x, float y){
		return false;
	}

	private void onClick(InputEvent event, float x, float y) {
		Tank t = tankContainer.getSelectedTank();
		if(t != null){
			t.setTargetLocation(x-50, y-50);
		}
	}

}
