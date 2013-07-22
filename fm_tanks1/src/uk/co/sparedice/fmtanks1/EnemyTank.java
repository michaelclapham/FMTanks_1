/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 *
 * @author Michael
 */
public class EnemyTank extends Tank {

	public EnemyTank(TankContainer container) {
		super(container);
		team = TEAM_ENEMY;
	}
	
	public static void loadStatic(){
		bodyTexture = new Texture(Gdx.files.internal("tank_body_2.png"));
		turretTexture = new Texture(Gdx.files.internal("tank_turret_2.png"));
		selectorTexture = new Texture(Gdx.files.internal("selector_3.png"));
	}
			
	
}
