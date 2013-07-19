/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.sparedice.fmtanks1;

import java.util.ArrayList;

/**
 * Class that gives tanks a way of communicating with eachother
 * @author Michael
 */
public class TankContainer {
	
	private ArrayList<Tank> tanks = new ArrayList<Tank>();

	public TankContainer() {
		tanks = new ArrayList<Tank>();
	}
	
	public void addTank(Tank t){
		tanks.add(t);
	}

	public ArrayList<Tank> getTanks() {
		return tanks;
	}
	
}
