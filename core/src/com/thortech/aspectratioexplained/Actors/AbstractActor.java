package com.thortech.aspectratioexplained.Actors;

import com.badlogic.gdx.math.Vector3;
import com.thortech.aspectratioexplained.AspectRatioExplained;

/**
 * Created by ToHj on 28-02-2016.
 */
public abstract class AbstractActor {

	protected AspectRatioExplained game;
	protected static String objName;
	protected static int objNumber = 0;

	public AbstractActor(AspectRatioExplained game) {
		this.game = game;
	}

	public abstract void changePos(Vector3 v3, boolean center);
	public abstract void render(float dt);

	public abstract void dispose();
}