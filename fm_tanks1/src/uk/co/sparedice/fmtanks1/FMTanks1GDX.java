package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.Game;

public class FMTanks1GDX extends Game {
	
	private MenuScreen menu;
	private GameScreen game;
	private LevelChooserScreen arcadeMenu;
	private CreditsScreen credits;
	
	@Override
	public void create() {		
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose() {
		
	}
		
	public void showMenu() {
		menu = new MenuScreen(this);
		setScreen(menu);
	}
	
	public void startGame() {
		game = new GameScreen(this);
		setScreen(game);
	}
	
	public void showArcadeMenu() {
		String[] levels = {"red-level", "green-level"};
		arcadeMenu = new LevelChooserScreen(this, levels);
		setScreen(arcadeMenu);
	}
	
	public void startArcadeGame(String levelName) {
		
	}
	
	public void showCredits() {
		credits = new CreditsScreen(this);
		setScreen(credits);
	}
}
