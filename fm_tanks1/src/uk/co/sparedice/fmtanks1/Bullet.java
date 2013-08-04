/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 *
 * @author michael
 */
public class Bullet extends Actor {
    
    private double angleRads;
    
    private float speed = 4f;
    
    private float damage = 4f;
    
    private float posX, posY;
    
    private int team;
    
    private int maxAge = 100;
    
    private int age = 0;
    
    private WorldContainer wc;

    public Bullet(WorldContainer wc, int team, float angleDegrees, float posX, float posY) {
        this.wc = wc;
        this.team = team;
        this.angleRads = Math.toRadians(angleDegrees);
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public void act(float delta) {
        posX += Math.sin(angleRads) * speed;
        posY += Math.cos(angleRads) * speed;
        setPosition(posX, posY);
    }
    
}
