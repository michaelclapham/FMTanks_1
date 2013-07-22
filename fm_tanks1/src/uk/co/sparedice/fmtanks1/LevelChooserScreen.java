package uk.co.sparedice.fmtanks1;

import java.util.HashMap;
import java.util.Map.Entry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class LevelChooserScreen implements Screen {

	private FMTanks1GDX tankGame;
	private SpriteBatch batch;
	private Stage stage;
	private HashMap<String, Image> images;
	private float imgWidth = 200f;
	private float imgHeight = 50f;
	
	public LevelChooserScreen(FMTanks1GDX game, String[] levelNames) {
		tankGame = game;
		batch = new SpriteBatch();
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		Gdx.input.setInputProcessor(stage);
		images = new HashMap<String, Image>();
		for(String levelName : levelNames) {
			addLevel(levelName);
		}
	}
	
	public void addLevel(String levelName) {
		images.put(levelName, new Image(new TextureRegion(new Texture(Gdx.files.internal(levelName + ".png")))));
		images.get(levelName).addListener(new LevelChooserListener(levelName));
		stage.addActor(images.get(levelName));
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
		int i = 0;
		float x = width/2 - imgWidth/2;
		float spacing = 10;
		
		for(Entry<String, Image> entry : images.entrySet()) {
		    Image value = entry.getValue();
		    value.setX(x);
		    value.setY(spacing*(i+1) + imgHeight*i);
		    value.setWidth(imgWidth);
		    value.setHeight(imgHeight);
		    i++;
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
