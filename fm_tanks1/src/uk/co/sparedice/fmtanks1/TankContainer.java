/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that gives game world objects a way of communicating with each other
 * @author Michael
 */
public class TankContainer implements IWorld {
	
    private ArrayList<Actor> actors = new ArrayList<Actor>();
    private ArrayList<Tank> tanks = new ArrayList<Tank>();
    private Tank selectedTank;
    private Stage stage;

    public TankContainer(Stage stage) {
        this.stage = stage;
        tanks = new ArrayList<Tank>();
    }

    public void addTank(Tank t){
        tanks.add(t);
    }

    public ArrayList<Tank> getTanks() {
        return tanks;
    }

    public void forAllTanks(TankTask tct){
        for(int i = 0; i < tanks.size(); i++){
            tct.task(tanks.get(i));
        }
    }

    public void forAllTanksBut(Tank tank, TankTask tct){
        for(int i = 0; i < tanks.size(); i++){
            if(!tanks.get(i).equals(tank)){
                tct.task(tanks.get(i));
            }
        }
    }



    public void setSelectedTank(Tank selectedTank){
        this.selectedTank = selectedTank;
        selectedTank.isSelected(true);
        for(int i = 0; i < tanks.size(); i++){
            if(!tanks.get(i).equals(selectedTank)){
                tanks.get(i).isSelected(false);
            }
        }
    }

    public Tank getSelectedTank() {
            return selectedTank;
    }

    @Override
    public List<Actor> getActors() {
        return actors;
    }

    @Override
    public boolean removeTank(Tank t) {
        return tanks.remove(t);
    }

    @Override
    public void forAll(ActorTask act) {
        for(int i = 0; i < actors.size(); i++){
            act.task(actors.get(i));
        }
    }

    @Override
    public void forAllBut(Actor actor, ActorTask tct) {
        for(int i = 0; i < tanks.size(); i++){
            if(!actors.get(i).equals(actor)){
                tct.task(tanks.get(i));
            }
        }
    }

    @Override
    public Tank getTankAt(float x, float y) {
        for(int i = 0; i < tanks.size(); i++){
            Tank t = tanks.get(i);
            if(t.getBounds().contains(x, y)){
                return t;
            }
        }
        return null;
    }

    @Override
    public void removeObject(Actor a) {
        actors.remove(a);
		stage.getRoot().removeActor(a);
    }

    @Override
    public void addObject(Actor a) {
        actors.add(a);
		stage.getRoot().addActor(a);
    }

    @Override
    public void addObject(Actor a, float x, float y) {
		a.setPosition(x, y);
        actors.add(a);
		stage.getRoot().addActor(a);
    }

	@Override
	public ITerrain getTerrain() {
		return null;
	}

	@Override
	public void setTerrain(ITerrain terrain) {
		//
	}
	
}
