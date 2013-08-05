/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.scenes.scene2d.Actor;
import java.util.List;

/**
 *
 * @author michael
 */
public interface WorldContainer {
    
    	/*
	 * Container Task. Small encapsulator for method on an actor to be passed as parameter
	 */
	public interface CT {
		
		public void task(Actor actor);
		
	}
        
        /*
	 * Tank Container Task. Small encapsulator for method on a tank to be passed as parameter
	 */
        public interface TCT {
            
            public void task(Tank tank);
            
        }
        
        /*
         * Gets a list of all actors in the game world.
         */
        public List<Actor> getActors();
        
        
        /*
         * Adds a tank to the game world
         */
        public void addTank(Tank t);
        
        /*
         * Gets all tanks in the game world
         */
        public List<Tank> getTanks();
        
        
        /*
         * Removes a tank from the game world
         */
        public boolean removeTank(Tank t);
        
        
        /*
         * Carrys out an operation on all tanks execept a given tank
         */
        public void forAllTanksBut(Tank tank, TCT tct);
        
        
        /*
         * Carrys out an operation on all tanks
         */
        public void forAllTanks(TCT tct);
        
        
        /*
         * Carrys out an operation on all tanks execept a given tank
         */
        public void forAll(CT act);
        
        
        /*
         * Carrys out an operation on all tanks execept a given tank
         */
        public void forAllBut(Actor actor, CT tct);
        
        /*
         * Returns one tank that intersects with the point
         */
        public Tank getTankAt(float x, float y);
    
}
