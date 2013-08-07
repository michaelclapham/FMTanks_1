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
public interface IWorld {
    
    /*
	 * Actor Task. Small encapsulator for method on an actor to be passed as parameter
	 */
	public interface ActorTask {
		
		public void task(Actor actor);
		
	}
        
        /*
	 * Tank Container Task. Small encapsulator for method on a tank to be passed as parameter
	 */
        public interface TankTask {
            
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
        public void forAllTanksBut(Tank tank, TankTask tct);
        
        
        /*
         * Carrys out an operation on all tanks
         */
        public void forAllTanks(TankTask tct);
        
        
        /*
         * Carrys out an operation on all tanks execept a given tank
         */
        public void forAll(ActorTask act);
        
        
        /*
         * Carrys out an operation on all tanks execept a given tank
         */
        public void forAllBut(Actor actor, ActorTask tct);
        
        /*
         * Returns one tank that intersects with the point
         */
        public Tank getTankAt(float x, float y);
        
        /*
         * Removes a given actor from the game world
         */
        public void removeObject(Actor a);
        
        /*
         * Adds an actor to the game world
         */
        public void addObject(Actor a);
        
        /*
         * Adds an actor to the game world at given coordiantes
         */
        public void addObject(Actor a, float x, float y);
		
		/*
		 * Get's the world terrain object
		 */
		public ITerrain getTerrain ();
		
		/*
		 * Sets the worlds terrain object
		 */
		public void setTerrain (ITerrain terrain);
		
		/*
		 * Sets the selected tank
		 */
		public void setSelectedTank(Tank tank);
    
}
