package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class LevelChooserListener extends ClickListener {
	
	private String levelName;
	private FMTanks1GDX game;
	
	public LevelChooserListener(String levelName) {
		this.levelName = levelName;
	}
	
	@Override
	public void clicked(InputEvent event, float x, float y) {
		System.out.println(levelName + " clicked");
		game.startArcadeGame(levelName);
	}

}
