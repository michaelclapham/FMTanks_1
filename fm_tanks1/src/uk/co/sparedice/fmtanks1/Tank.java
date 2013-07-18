package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tank {
	
	/* The angle of the tank main body. The tank will go forward in this direction */
	private float bodyAngle = 0f; 
	
	/* The angle of the turret/gun. The tank will fire weapons in this direction */
	private float turretAngle = 0f;
	
	private static final int TEAM_PLAYER = 0; // Human controlled tanks in single player
	private static final int TEAM_ENEMY = 1; // AI controlled tanks in single player
	private static final int TEAM_RED = 2; // Red Team in multiplayer
	private static final int TEAM_BLUE = 3; // Blue Team in multiplayer
	
	/* The team ID of the tank. Defines who it can damage and who can damage it */
	private int team = TEAM_PLAYER;
	
	private static Texture bodyTexture, turretTexture;
	
	public static void loadStatic (){
		bodyTexture = new Texture(Gdx.files.internal("tank_body_1.png"));
		turretTexture = new Texture(Gdx.files.internal("tank_turret_1.png"));
	}
	
	public void draw(SpriteBatch sb){
		//sb.draw
	}

}
