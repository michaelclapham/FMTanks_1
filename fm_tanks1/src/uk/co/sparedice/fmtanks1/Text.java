package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Text extends Actor {

	private String text;
	private BitmapFont font;

	public Text() {
		
	}
	
	public Text(String text, BitmapFont font) {
		this.text = text;
		this.font = font;
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		font.draw(batch, text, 0, 0);
	}
}
