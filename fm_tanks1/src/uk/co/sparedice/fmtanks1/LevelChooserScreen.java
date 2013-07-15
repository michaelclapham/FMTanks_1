package uk.co.sparedice.fmtanks1;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class LevelChooserScreen implements Screen {

	private FMTanks1GDX tankGame;
	private SpriteBatch batch;
	private Stage stage;
	private HashMap<String, Image> buttons;
	
	public LevelChooserScreen(FMTanks1GDX game, String[] levelNames) {
		tankGame = game;
		batch = new SpriteBatch();
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		Gdx.input.setInputProcessor(stage);
		buttons = new HashMap<String, Image>();
		for(String levelName : levelNames) {
			addLevel(levelName);
		}
	}
	
	public void addLevel(String levelName) {
		buttons.put(levelName, new Image(new TextureRegion(new Texture(Gdx.files.internal(levelName + ".png")))));
		buttons.get(levelName).addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("level clicked");
			}
		});
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
