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

	private FMTanks1GDX tankGame;
	
	//UI elements
	private Stage stage;
	private TextButton newGameBtn;
	TextButtonStyle btnStyle;
	
	private SpriteBatch batch;

	public MenuScreen(FMTanks1GDX game) {
		tankGame = game;
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		stage.clear();
		Gdx.input.setInputProcessor(stage);

		TextureRegion up = new TextureRegion(new Texture(Gdx.files.internal("textBtn.png")));
		// TextureRegion down = new TextureRegion(new Texture(Gdx.files.internal("buttonpressed.png")));
		BitmapFont btnFont = new BitmapFont();
		btnStyle = new TextButtonStyle();
		btnStyle.up = new TextureRegionDrawable(up);
		btnStyle.down = new TextureRegionDrawable(up);
		btnStyle.font = btnFont;

		newGameBtn = new TextButton("New Game", btnStyle);
		newGameBtn.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				tankGame.setScreen(new GameScreen(tankGame));
				System.out.println("newGameBtn clicked");
			}
		});
		stage.addActor(newGameBtn);
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
		
		float btnWidth = width/2;
		float btnHeight = 80;
		float btnX = (width - btnWidth) / 2;
		float btnY = (height - btnHeight) / 2;
		
		System.out.println("moving newGameBtn to (" + btnX + ", " + btnY + ") with dimensions (" + btnWidth + ", " + btnHeight + ")");
		newGameBtn.setWidth(btnWidth);
		newGameBtn.setHeight(btnHeight);
		newGameBtn.setX(btnX);
		newGameBtn.setY(btnY);
		newGameBtn.setText("New Game");
		newGameBtn.setStyle(btnStyle);
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