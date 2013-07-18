package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class PhysicsActor extends Actor {
	
	protected float posX, posY, velX, velY, accX, accY;
	protected float width, height;
	
	/* Constant acceleration */
	protected float cacX, cacY;
	
	public void thrust (float x, float y){
		accX += x;
		accY += y;
	}
	
	public void applyPhysics(){
		velX = velX + accX + cacX;
		velY = velY + accY + cacY;
		accX = 0;
		accY = 0;
		posX += velX;
		posY += velY;
		setPosition(posX, posY);
		setBounds(posX, posY, width, height);
	}

}
