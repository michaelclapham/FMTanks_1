package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.Game;

public class FMTanks1GDX extends Game {
	
	private MenuScreen menu;
	private GameScreen game;
	private CreditsScreen credits;
	
	@Override
	public void create() {		
		menu = new MenuScreen(this);
		setScreen(menu);
	}

	@Override
	public void dispose() {
		
	}
	
	public void startGame() {
		game = new GameScreen(this);
		setScreen(game);
	}
	
	public void showCredits() {
		credits = new CreditsScreen(this);
		setScreen(credits);
	}
}
