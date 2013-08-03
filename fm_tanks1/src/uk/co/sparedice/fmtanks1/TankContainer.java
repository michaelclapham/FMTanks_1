/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.scenes.scene2d.Actor;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that gives game world objects a way of communicating with each other
 * @author Michael
 */
public class TankContainer implements WorldContainer {
	
	private ArrayList<Tank> tanks = new ArrayList<Tank>();
	private Tank selectedTank;

	public TankContainer() {
		tanks = new ArrayList<Tank>();
	}
	
	public void addTank(Tank t){
		tanks.add(t);
	}

	public ArrayList<Tank> getTanks() {
		return tanks;
	}
	
	public void forAllTanks(TCT tct){
		for(int i = 0; i < tanks.size(); i++){
			tct.task(tanks.get(i));
		}
	}
	
	public void forAllTanksBut(Tank tank, TCT tct){
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
        return new ArrayList<>(1);
    }

    @Override
    public boolean removeTank(Tank t) {
        return false;
    }

    @Override
    public void forAll(CT act) {
        //
    }

    @Override
    public void forAllBut(Actor actor, CT tct) {
        //
    }
	
}
