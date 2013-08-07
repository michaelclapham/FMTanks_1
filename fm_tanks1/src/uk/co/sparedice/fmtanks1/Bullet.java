/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 *
 * @author michael
 */
public class Bullet extends Actor {
    
    private double angleRads;
    
    private float speed = 16f;
    
    private float damage = 4f;
    
    private float posX, posY;
    
    private int team;
    
    private int maxAge = 20;
    
    private int age = 0;
    
    private IWorld wc;
    
    private static Texture texture;
    
    private Sprite sprite;

    public Bullet(IWorld wc, int team, float angleDegrees, float posX, float posY) {
        this.wc = wc;
        this.team = team;
        this.angleRads = Math.toRadians(angleDegrees);
        this.posX = posX;
        this.posY = posY;
        sprite = new Sprite(texture);
        sprite.rotate(angleDegrees-90);
    }
    
    public static void loadStatic(){
        texture = new Texture(Gdx.files.internal("bullet_1.png"));
    }

    @Override
    public void act(float delta) {
        /* Trig to make bullet move at a given angle */
        posX += Math.sin(angleRads) * speed;
        posY += Math.cos(angleRads) * speed;
        setPosition(posX, posY);
        age++;
        
        /* Makes sure bullets disappear after a certain time/distance afer being fired */
        if(age > maxAge){
            wc.removeObject(this);
        }
        
        /* The tank we might have just hit */
        Tank justHit = wc.getTankAt(posX, posY);
        
        if(justHit != null){
            justHit.damage(damage);
            wc.removeObject(this);
        }
    }

    @Override
    public void draw(SpriteBatch batch, float parentAlpha) {
        sprite.setPosition(posX, posY);
        sprite.draw(batch);
    }
    
}
