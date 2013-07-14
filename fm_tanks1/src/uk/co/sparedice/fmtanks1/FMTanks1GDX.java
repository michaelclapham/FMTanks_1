package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.Game;

public class FMTanks1GDX extends Game {
	
	MenuScreen menu;
	
	@Override
	public void create() {		
		menu = new MenuScreen(this);
		setScreen(menu);
	}

	@Override
	public void dispose() {
		
	}
}
