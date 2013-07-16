package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class CreditsScreen implements Screen {

	private FMTanks1GDX tankGame;
	private SpriteBatch batch;
	private Stage stage;
	private LabelStyle labelStyle;
	private Label[] creditsLabel;
	private TextButton backBtn;
	private TextButtonStyle btnStyle;
	
	private String[] credits = { "Developer & Artist - Michael Clapham", "Developer - Fraser Elliott", "Graphics Library - LibGDX by Bad Logic Games" };
	
	public CreditsScreen(FMTanks1GDX game) {
		tankGame = game;
		batch = new SpriteBatch();
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		Gdx.input.setInputProcessor(stage);
		
		labelStyle = new LabelStyle();
		labelStyle.font = new BitmapFont();
		labelStyle.fontColor = Color.WHITE;
		
		creditsLabel = new Label[credits.length];
		
		for (int i=0; i<credits.length; i++) {
			creditsLabel[i] = new Label(credits[i], labelStyle);
			stage.addActor(creditsLabel[i]);
		}
		
		TextureRegion up = new TextureRegion(new Texture(Gdx.files.internal("textBtn.png")));
		btnStyle = new TextButtonStyle();
		btnStyle.up = new TextureRegionDrawable(up);
		btnStyle.down = new TextureRegionDrawable(up);
		btnStyle.font = new BitmapFont();
		
		backBtn = new TextButton("Back", btnStyle);
		backBtn.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("backBtn clicked");
				tankGame.showMenu();
			}
		});
		stage.addActor(backBtn);
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
		//Need to make it scroll possibly, but we can deal with that when it comes to it
		System.out.println("Screen resized to " + width + " by " + height);
		stage.setViewport(width, height, false);
				
		float btnWidth = width/2;
		float btnHeight = 40;
		float btnX = width/2 - btnWidth/2;
		
		backBtn.setWidth(btnWidth);
		backBtn.setHeight(btnHeight);
		backBtn.setX(btnX);
		backBtn.setY(20);
		backBtn.setText("Back");
		backBtn.setStyle(btnStyle);
		
		float spacing = 5;
		float firstY = height/2 + (credits.length-2)*labelStyle.font.getBounds("W").height/2 + btnHeight;
		
		for (int i=0; i<credits.length; i++) {
			creditsLabel[i].setX(width/2 - labelStyle.font.getBounds(credits[i]).width/2);
			creditsLabel[i].setY(firstY - labelStyle.font.getBounds("W").height*i - spacing*i);
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
