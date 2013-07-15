package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SplashScreen implements Screen {

	private FMTanks1GDX tankGame;
	private SpriteBatch batch;
	private Texture splash;
	private float x, y;
	private float time;
	private float maxTime = 5;
	
	public SplashScreen(FMTanks1GDX game) {
		tankGame = game;
		batch = new SpriteBatch();
		splash = new Texture(Gdx.files.internal("splash.png"));
		time = 0;
	}
	
	@Override
	public void render(float delta) {
		if(Gdx.input.justTouched())
			tankGame.showMenu();
		
		batch.begin();
		batch.draw(splash, x, y, splash.getWidth(), splash.getHeight());
		batch.end();
		
		time += delta;
		if (time > maxTime)
			tankGame.showMenu();
	}

	@Override
	public void resize(int width, int height) {
		x = Gdx.graphics.getWidth()/2 - splash.getWidth()/2;
		y = Gdx.graphics.getHeight()/2 - splash.getHeight()/2;
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

	}

}
