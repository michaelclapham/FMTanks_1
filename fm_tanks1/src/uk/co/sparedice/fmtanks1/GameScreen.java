package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen {

	private FMTanks1GDX tankGame;
	private SpriteBatch batch;
	private Stage stage;
	private BitmapFont font;
	
	public GameScreen(FMTanks1GDX game) {
		tankGame = game;
		batch = new SpriteBatch();
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		font = new BitmapFont();
	}
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.input.setInputProcessor(stage);
		
		batch.begin();
		{
			//Curly braces not strictly necessary, but it helps to separate code out
			font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			font.draw(batch, "HAHA NOTHING IS HERE YET. TROLALOLOLOLOL", Gdx.graphics.getWidth()/2 - font.getBounds("HAHA NOTHING IS HERE YET. TROLALOLOLOLOL").width/2, Gdx.graphics.getHeight()/2 - - font.getBounds("HAHA NOTHING IS HERE YET. TROLALOLOLOLOL").height/2);
			//Do the rendering
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
		stage.dispose();
	}
	
}
