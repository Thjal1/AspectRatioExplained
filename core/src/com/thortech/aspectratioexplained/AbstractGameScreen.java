package com.thortech.aspectratioexplained;

/**
 * Created by ToHj on 18-01-2016.
 */

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class AbstractGameScreen extends Stage implements Screen {

    //    protected Assets assets;
    protected AspectRatioExplained game;
    //protected Viewport viewport;
    //protected Camera camera;

    public AbstractGameScreen(AspectRatioExplained _game) {
        game = _game;
    }

    public abstract void render (float deltaTime);
    public abstract void resize (int width, int height);
    public abstract void show ();
    public abstract void hide ();
    public abstract void pause ();
    public abstract void resume ();
    public abstract void dispose ();
}
