//package com.thortech.aspectratioexplained
package com.thortech.aspectratioexplained;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.thortech.aspectratioexplained.AspectRatioExplained;
import com.thortech.aspectratioexplained.PlatformSpecificAndroid;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		PlatformSpecificAndroid platformSpecific = new PlatformSpecificAndroid();

		initialize(new AspectRatioExplained(platformSpecific), config);
	}
}

