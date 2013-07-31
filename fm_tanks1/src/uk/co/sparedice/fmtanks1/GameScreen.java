package uk.co.sparedice.fmtanks1;

import java.util.Timer;
import java.util.TimerTask;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen {

	private FMTanks1GDX tankGame;
	private SpriteBatch batch;
	private BitmapFont font;
	private Terrain terrain;
	private Tank testTank;
	private Stage stage;
	private TankContainer tankContainer;
	private Camera camera;
	
	public GameScreen(FMTanks1GDX game) {
		tankGame = game;
		batch = new SpriteBatch();
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		font = new BitmapFont();
		tankContainer = new TankContainer();
		terrain = new Terrain(tankContainer);
		stage = new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),false);
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage.setCamera(camera);
		camera.translate(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 0);
		Tank.loadStatic();
		EnemyTank.loadStatic();
		testTank = new Tank(tankContainer);
		Timer t = new Timer("Update Timer Thread");
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				stage.act();
				if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
					camera.translate(10, 0, 0);
				}
				if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
					camera.translate(-10, 0, 0);
				}
				if(Gdx.input.isKeyPressed(Input.Keys.UP)){
					camera.translate(0, 10, 0);
				}
				if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
					camera.translate(0, -10, 0);
				}
			}
		}, 40, 40);
		stage.addActor(terrain);
		stage.addActor(testTank);
		Tank t2 = new Tank(tankContainer);
		t2.posX = 300;
		Tank t3 = new Tank(tankContainer);
		t3.posY = 400;
		stage.addActor(t2);
		stage.addActor(t3);
		Tank t4 = new EnemyTank(tankContainer);
		stage.addActor(t4);
	}
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.input.setInputProcessor(stage);
		
		
		batch.begin();
		{
			//font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			//font.draw(batch, "HAHA NOTHING IS HERE YET. TROLALOLOLOLOL", 10, Gdx.graphics.getHeight() / 2);
			//Curly braces not strictly necessary, but it helps to separate code out
			font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			font.draw(batch, "HAHA NOTHING IS HERE YET. TROLALOLOLOLOL", Gdx.graphics.getWidth()/2 - font.getBounds("HAHA NOTHING IS HERE YET. TROLALOLOLOLOL").width/2, Gdx.graphics.getHeight()/2 - - font.getBounds("HAHA NOTHING IS HERE YET. TROLALOLOLOLOL").height/2);
			//Do the rendering
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
		batch.dispose();
		stage.dispose();
	}
	
}
