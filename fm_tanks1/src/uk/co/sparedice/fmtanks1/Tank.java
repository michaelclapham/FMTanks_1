package uk.co.sparedice.fmtanks1;

public class Tank extends Updatable {
	
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

}
