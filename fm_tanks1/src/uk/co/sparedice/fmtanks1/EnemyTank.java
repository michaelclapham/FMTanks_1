/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 *
 * @author Michael
 */
public class EnemyTank extends Tank {
	
	private static Texture bodyTexture, turretTexture, selectorTexture;

	public EnemyTank(TankContainer container) {
		super(container);
		team = TEAM_ENEMY;
		bodySprite = new Sprite(bodyTexture);
		turretSprite = new Sprite(turretTexture);
		selectorSprite = new Sprite(selectorTexture);
	}
	
	public static void loadStatic(){
		bodyTexture = new Texture(Gdx.files.internal("tank_body_2.png"));
		turretTexture = new Texture(Gdx.files.internal("tank_turret_2.png"));
		selectorTexture = new Texture(Gdx.files.internal("selector_3.png"));
	}
			
	
}
