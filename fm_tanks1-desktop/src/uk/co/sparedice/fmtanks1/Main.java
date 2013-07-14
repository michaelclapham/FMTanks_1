package uk.co.sparedice.fmtanks1;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "fm_tanks1";
		cfg.useGL20 = true;
		cfg.width = 480;
		cfg.height = 320;
		cfg.vSyncEnabled = true;
		
		new LwjglApplication(new FMTanks1GDX(), cfg);
	}
}
