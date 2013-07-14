package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class CreditsScreen implements Screen {

	private FMTanks1GDX game;
	private SpriteBatch batch;
	private BitmapFont font;
	private Stage stage;
	private Text[] creditsText;
	
	private String[] credits = { "Developer & Artist - Michael Clapham", "Developer - Fraser Elliott", "more people maybe", "yet more people possible", "really, we're only 2, this is just a test. seriously." };
	
	public CreditsScreen(FMTanks1GDX game) {
		this.game = game;
		batch = new SpriteBatch();
		font = new BitmapFont();
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		Gdx.input.setInputProcessor(stage);
		
		creditsText = new Text[credits.length];
		
		for (int i=0; i<credits.length; i++) {
			creditsText[i] = new Text(credits[i], font);
			stage.addActor(creditsText[i]);
		}
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		batch.begin();
		{
			stage.draw();
		}
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("Screen resized to " + width + " by " + height);
		stage.setViewport(width, height, false);
		
		float spacing = 5;
		float firstY = height/2 + (credits.length-2)*font.getBounds("W").height/2;
		
		for (int i=0; i<credits.length; i++) {
			creditsText[i].setX(width/2 - font.getBounds(credits[i]).width/2);
			creditsText[i].setY(firstY - font.getBounds("W").height*i - spacing*i);
		}
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
