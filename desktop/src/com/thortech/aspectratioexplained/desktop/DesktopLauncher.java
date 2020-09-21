package com.thortech.aspectratioexplained.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.thortech.aspectratioexplained.PlatformSpecificDesktop;
import com.thortech.aspectratioexplained.AspectRatioExplained;

public class DesktopLauncher {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();

		cfg.title = "AspectRatioExplained";
		cfg.width = 1200;
		cfg.height = 780;
		PlatformSpecificDesktop platformSpecific = new PlatformSpecificDesktop();
		new LwjglApplication(new AspectRatioExplained(platformSpecific), cfg);
	}
}
