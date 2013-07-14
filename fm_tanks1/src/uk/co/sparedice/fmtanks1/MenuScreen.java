package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MenuScreen implements Screen {
	
	private FMTanks1GDX game;
	private Stage stage;
	private SpriteBatch batch;
	private final static float BUTTON_WIDTH = Gdx.graphics.getWidth()/2, BUTTON_HEIGHT = 80; 
	
	public MenuScreen(FMTanks1GDX game) {
		this.game = game;
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
		if (stage == null)
			stage = new Stage(width, height, true);
		stage.clear();
		Gdx.input.setInputProcessor(stage);

		TextureRegion up = new TextureRegion(new Texture(Gdx.files.internal("textBtn.png")));
//		TextureRegion down = new TextureRegion(new Texture(Gdx.files.internal("buttonpressed.png")));
		BitmapFont btnFont = new BitmapFont();
		TextButtonStyle style = new TextButtonStyle();
		style.up = new TextureRegionDrawable(up);
		style.down = new TextureRegionDrawable(up);
		style.font = btnFont;
		
		TextButton newGameBtn = new TextButton("New Game", style);
		newGameBtn.setWidth(BUTTON_WIDTH);
		newGameBtn.setHeight(BUTTON_HEIGHT);
		newGameBtn.setX(Gdx.graphics.getWidth() / 2 - BUTTON_WIDTH / 2);
		newGameBtn.setY(Gdx.graphics.getHeight() / 2 - BUTTON_HEIGHT / 2);
		newGameBtn.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("newGameBtn clicked");
			}
		});
		stage.addActor(newGameBtn);
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
	}

	@Override
	public void dispose() {
		batch.dispose();
		stage.dispose();
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

}
