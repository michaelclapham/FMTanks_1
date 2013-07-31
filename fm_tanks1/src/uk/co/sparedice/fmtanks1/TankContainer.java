/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.sparedice.fmtanks1;

import java.util.ArrayList;

/**
 * Class that gives tanks a way of communicating with each other
 * @author Michael
 */
public class TankContainer {
	
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
	
	public void forAll(TCT tct){
		for(int i = 0; i < tanks.size(); i++){
			tct.task(tanks.get(i));
		}
	}
	
	public void forAllBut(Tank tank, TCT tct){
		for(int i = 0; i < tanks.size(); i++){
			if(!tanks.get(i).equals(tank)){
				tct.task(tanks.get(i));
			}
		}
	}

	/*
	 * Tank Container Task. Small encapsulator for method to be passed as parameter
	 */
	public interface TCT {
		
		public void task(Tank tank);
		
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
	
}
