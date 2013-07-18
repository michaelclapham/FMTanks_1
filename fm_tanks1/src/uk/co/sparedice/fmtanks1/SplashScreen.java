package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class SplashScreen implements Screen {

	private FMTanks1GDX tankGame;
	private Stage stage;
	private SpriteBatch batch;
	private Texture splashTexture;
	float ratio;
	private Image splashImage;
	private float time;
	private float maxTime = 5;
	
	public SplashScreen(FMTanks1GDX game) {
		tankGame = game;
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		Gdx.input.setInputProcessor(stage);
		batch = new SpriteBatch();
		splashTexture = new Texture(Gdx.files.internal("splash.png"));
		ratio = (float)splashTexture.getWidth() / (float)splashTexture.getHeight();
		splashImage = new Image(splashTexture);
		stage.addActor(splashImage);
		time = 0;
	}
	
	@Override
	public void render(float delta) {
		if(Gdx.input.justTouched())
			tankGame.showMenu();
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		batch.begin();
		{
			stage.draw();
		}
		batch.end();
		
		time += delta;
		if (time > maxTime)
			tankGame.showMenu();
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("Screen resized to " + width + " by " + height);
		stage.setViewport(width, height, false);
		stage.clear();
		
		splashImage = new Image(splashTexture);
		if (width < splashTexture.getWidth() || height < splashTexture.getHeight()) {
			float newRatio = (float)width / (float)height;
			System.out.println("ratio=" + ratio + ", newRatio=" + newRatio);
			if (newRatio < ratio) {
				//Screen too high, so maximise width
				splashImage.setWidth(width);
				//Adjust height to keep aspect ratio of splashTexture
				splashImage.setHeight((float)width / (float)splashTexture.getWidth() * splashTexture.getHeight());
				splashImage.setX(0);
				splashImage.setY(height/2 - splashImage.getHeight()/2);
			} else {
				//Screen too wide, so maximise height
				splashImage.setHeight(height);
				//Adjust width to keep aspect ratio of splashTexture
				splashImage.setWidth((float)height / (float)splashTexture.getHeight() * splashTexture.getWidth());
				splashImage.setY(0);
				splashImage.setX(width/2 - splashImage.getWidth()/2);
			}
		} else {
			splashImage.setWidth(splashTexture.getWidth());
			splashImage.setHeight(splashTexture.getHeight());
			splashImage.setX(width/2 - splashTexture.getWidth()/2);
			splashImage.setY(height/2 - splashTexture.getHeight()/2);
		}
		System.out.println("resizing splashImage to " + splashImage.getWidth() + "," + splashImage.getHeight());
		stage.addActor(splashImage);
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
		stage.dispose();
		batch.dispose();
		splashTexture.dispose();
	}

}
