package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import java.util.ArrayList;
import uk.co.sparedice.fmtanks1.TankContainer.TCT;

public class Tank extends PhysicsActor {
	
	/* The angle of the tank main body. The tank will go forward in this direction */
	private float bodyAngle = 0f; 
	
	/* The angle of the turret/gun. The tank will fire weapons in this direction */
	private float turretAngle = 0f;
	
	/* The angle of the selector circle */
	private float selectorAngle = 0f;
	
	public static final int TEAM_PLAYER = 0; // Human controlled tanks in single player
	public static final int TEAM_ENEMY = 1; // AI controlled tanks in single player
	public static final int TEAM_RED = 2; // Red Team in multiplayer
	public static final int TEAM_BLUE = 3; // Blue Team in multiplayer
	
	/* The team ID of the tank. Defines who it can damage and who can damage it */
	protected int team = TEAM_PLAYER;
	
	private static Texture bodyTexture, turretTexture, selectorTexture;
	
	protected Sprite bodySprite, turretSprite, selectorSprite;
	private TankContainer container;
	private boolean selected;
	
	private boolean moving = false;
	private float aimX, aimY;
	private float bodyAngleAim = 0f;
	private float tankSpeed = 6;
	private boolean aboutToMove;
	
	public Tank(TankContainer container) {
		this.container = container;
		container.addTank(this);
		posX = 200;
		posY = 200;
		bodySprite = new Sprite(bodyTexture);
		turretSprite = new Sprite(turretTexture);
		selectorSprite = new Sprite(selectorTexture);
		setWidth(bodySprite.getWidth());
		setHeight(bodySprite.getHeight());
		addOnClickListener();
	}
	
	public static void loadStatic (){
		bodyTexture = new Texture(Gdx.files.internal("tank_body_1.png"));
		turretTexture = new Texture(Gdx.files.internal("tank_turret_1.png"));
		selectorTexture = new Texture(Gdx.files.internal("selector_3.png"));
	}
	
	@Override
	public void draw(SpriteBatch sb, float parentAlpha) {
		bodySprite.setRotation(bodyAngle);
		bodySprite.setPosition(posX, posY);
		bodySprite.draw(sb);
		turretSprite.setRotation(turretAngle);
		turretSprite.setPosition(posX, posY);
		turretSprite.draw(sb);
		if(selected){
			selectorSprite.setRotation(selectorAngle);
			selectorSprite.setPosition(posX-14, posY-14);
			selectorSprite.draw(sb);
		}
	}
	
	public void act(float delta){
		turretAngle += 3;
		
		if(aboutToMove){
			if(Math.abs(bodyAngle - bodyAngleAim) > 5){
			bodyAngle -= (bodyAngle - bodyAngleAim) * 0.1;
			aboutToMove = true;
			} else 
				aboutToMove = false;
				moving = true;
		}
		
		//Apply engine force
		if(moving){
			if(!aboutToMove){
				bodyAngle = (float) Math.toDegrees(Math.atan2(aimY - posY, aimX - posX));
			}
			velX = (float) (tankSpeed * Math.cos(Math.toRadians(bodyAngle)));
			velY = (float) (tankSpeed * Math.sin(Math.toRadians(bodyAngle)));
		}
		
		//Keep moving until within 10 pixels
		if(within(20,aimX,aimY)){
			moving = false;
			velX = 0;
			velY = 0;
		}
		
		applyPhysics();
		if(selected){
			selectorAngle -= 1;
		}
		
		//Search and Wave
		container.forAllBut(this,new TCT() {
			public void task(Tank tank){
				if(tank.getTeam() == TEAM_PLAYER){
					if(within(300,tank.getX(), tank.getY())){
						//Point gun at it
						turretAngle = (float) Math.toDegrees(Math.atan2(tank.getX() - posY, tank.getY() - posX));
					}
				}
			}
		});
	}

	@Override
	protected void onClick(InputEvent event, float x, float y) {
		container.setSelectedTank(this);
	}
	
	public void isSelected(boolean s){
		selected = s;
	}
	
	public boolean isSelected(){
		return selected;
	}
	
	/**
	 * The tank will try to move towards this position in the game world.
	 * @param x X-Coordinate of target location.
	 * @param y Y-Coordinate of target location
	 */
	public void setTargetLocation(float x, float y){
		aimX = x;
		aimY = y;
		aboutToMove = true;
		bodyAngleAim = (float) Math.toDegrees(Math.atan2(aimY - posY, aimX - posX));
	}

	private boolean within(int range, float x, float y) {
		float dx = posX - x;
		float dy = posY - y;
		if(Math.abs(dx) < range && Math.abs(dy) < range){
			return true;
		} else {
			return false;
		}
	}

	public int getTeam() {
		return team;
	}
	
}
