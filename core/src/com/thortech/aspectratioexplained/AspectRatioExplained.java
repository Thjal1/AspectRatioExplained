package com.thortech.aspectratioexplained;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thortech.aspectratioexplained.Screens.*;


public class AspectRatioExplained extends Game {

	private static final String TAG = AspectRatioExplained.class.getName();
	public static PlatformSpecific platformSpecific;

	//Define the screens to be used in the game
	public static Screen screenLoad;
	public static Screen screenMenu;
	public static Screen screenPreference;
	public static Screen screenCredits;
	public static Screen screenGameStretch;
	public static Screen screenGameExtend;
	public static Screen screenGameFill;
	public static Screen screenGameFit;
	public static Screen screenGameScale;
	public static Screen screenGameScreen;
	public static Screen screenGameNoViewport;
	public static Screen screenGameStageOnly;

	public SpriteBatch batch;

	public AspectRatioExplained(PlatformSpecific platformSpecific){
		AspectRatioExplained.platformSpecific = platformSpecific;
	}

	@Override
	public void create () {
		try {
			batch = new SpriteBatch();
			Settings.instance.init();

			Settings.setScreenHeightPixels(Gdx.graphics.getHeight());
			Settings.setScreenWidthPixels(Gdx.graphics.getWidth());

			screenLoad = new ScreenLoad(this);
			screenMenu = new ScreenMenu(this);
			screenPreference = new ScreenPreferences(this);
			screenCredits = new ScreenCredits(this);

			screenGameExtend = new ScreenGameExtend(this);
			screenGameFill = new ScreenGameFill(this);
			screenGameFit = new ScreenGameFit(this);
			screenGameScale = new ScreenGameScale(this);
			screenGameStretch = new ScreenGameStretch(this);
			screenGameNoViewport = new ScreenGameNoViewPort(this);
			screenGameStageOnly = new ScreenGameStageOnly(this);

			setScreen(screenLoad);				//Testing

			if(platformSpecific.isDebug())
				Gdx.app.log(TAG, "Created OK");

		}
		catch (final Exception ex) {
			Gdx.app.log(TAG, "create() failed", ex);
			//TODO: Code for handling exceptions and/or exit the game OK.
		}
	}

	@Override
	public void resize(int width, int height) {
		getScreen().resize(width, height);
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	public void dispose(){
		batch.dispose();
	}
}