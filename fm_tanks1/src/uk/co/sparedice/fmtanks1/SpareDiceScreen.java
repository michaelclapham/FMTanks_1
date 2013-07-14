package uk.co.sparedice.fmtanks1;

import java.util.Timer;
import java.util.TimerTask;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpareDiceScreen implements Screen {

	private SpriteBatch batch;
	private FMTanks1GDX game;
	private Texture splashTexture;
	private static final int SPLASH_TIME = 1500;
	
	public SpareDiceScreen(FMTanks1GDX game) {
		this.game = game;
		batch = new SpriteBatch();
		splashTexture = new Texture(Gdx.files.internal("spare_dice_splash1.png"));
		
		Timer t = new Timer("sparedice_delay");
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}, SPLASH_TIME);
	}
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
				
		batch.begin();
		{
			batch.draw(splashTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
	
}
