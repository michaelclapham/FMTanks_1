package uk.co.sparedice.fmtanks1;

import java.awt.Font;

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
	private TextButton newGameBtn, creditsBtn, exitBtn;
	private TextButtonStyle btnStyle;
	
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
				System.out.println("newGameBtn clicked");
				tankGame.startGame();
			}
		});
		stage.addActor(newGameBtn);
		
		creditsBtn = new TextButton("Credits", btnStyle);
		creditsBtn.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("creditsBtn clicked");
				tankGame.showCredits();
			}
		});
		stage.addActor(creditsBtn);
		
		exitBtn = new TextButton("Exit", btnStyle);
		exitBtn.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("exitBtn clicked");
				Gdx.app.exit();
			}
		});
		stage.addActor(exitBtn);
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
		
		float spacing = 15;
		float btnWidth = width/2;
		float btnHeight = 80;
		float btnX = width/2 - btnWidth/2;
		float newGameY = height/2 - btnHeight/2 + btnHeight + spacing;
		float creditsY = height/2 - btnHeight/2;
		float exitY = height/2 - btnHeight/2 - btnHeight - spacing;
		
		newGameBtn.setWidth(btnWidth);
		newGameBtn.setHeight(btnHeight);
		newGameBtn.setX(btnX);
		newGameBtn.setY(newGameY);
		newGameBtn.setText("New Game");
		newGameBtn.setStyle(btnStyle);
		
		creditsBtn.setWidth(btnWidth);
		creditsBtn.setHeight(btnHeight);
		creditsBtn.setX(btnX);
		creditsBtn.setY(creditsY);
		creditsBtn.setText("Credits");
		creditsBtn.setStyle(btnStyle);
		
		exitBtn.setWidth(btnWidth);
		exitBtn.setHeight(btnHeight);
		exitBtn.setX(btnX);
		exitBtn.setY(exitY);
		exitBtn.setText("Exit");
		exitBtn.setStyle(btnStyle);
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