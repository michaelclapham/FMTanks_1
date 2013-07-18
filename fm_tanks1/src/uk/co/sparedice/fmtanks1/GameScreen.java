package uk.co.sparedice.fmtanks1;

import java.util.Timer;
import java.util.TimerTask;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen {

	private SpriteBatch batch;
	private FMTanks1GDX tankGame;
	private BitmapFont font;
	private Terrain terrain;
	private Tank testTank;
	private Stage stage;
	
	public GameScreen(FMTanks1GDX game) {
		tankGame = game;
		batch = new SpriteBatch();
		font = new BitmapFont();
		terrain = new Terrain();
		stage = new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),false);
		Tank.loadStatic();
		testTank = new Tank();
		Timer t = new Timer("Update Timer Thread");
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				stage.act();
			}
		}, 40, 40);
	}
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
				
		batch.begin();
		{
			//font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			//font.draw(batch, "HAHA NOTHING IS HERE YET. TROLALOLOLOLOL", 10, Gdx.graphics.getHeight() / 2);
			//Curly braces not strictly necessary, but it helps to separate code out
			//Do the rendering
			terrain.drawTerrain(batch);
			testTank.draw(batch,1f);
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
