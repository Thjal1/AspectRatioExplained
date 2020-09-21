package com.thortech.aspectratioexplained.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.thortech.aspectratioexplained.AbstractGameScreen;
import com.thortech.aspectratioexplained.Actors.Board;
import com.thortech.aspectratioexplained.Actors.LibGdXActor;
import com.thortech.aspectratioexplained.AspectRatioExplained;
import com.thortech.aspectratioexplained.Settings;

/**
 * Created by ToHj on 31-01-2020.
 *
 */
public class ScreenGameStageOnly extends AbstractGameScreen {

    private static final String TAG = ScreenGameFill.class.getName();

    private OrthographicCamera cameraGame;      //For the game play
    private Viewport viewPort;
    private Stage stage;

    public ScreenGameStageOnly(AspectRatioExplained _game) {
        super(_game);
        cameraGame = new OrthographicCamera(Settings.PHYSICALWIDTH, Settings.PHYSICALHEIGHT);
        cameraGame.position.set(cameraGame.viewportWidth / 2, cameraGame.viewportHeight / 2, 0);

        viewPort = new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), cameraGame);
        viewPort.apply(true);

        stage = new Stage(viewPort);
        Gdx.input.setInputProcessor(stage);

        placeActors();
    }

    public void placeActors()
    {
        LibGdXActor actor = new LibGdXActor();
        actor.setTouchable(Touchable.enabled);
        stage.addActor(actor);
        //stage.setKeyboardFocus(stage.getActors().first());
    }

    public void handleInput(float dt) {
    }

    public void update(float dt) {
        handleInput(dt);

    }

    @Override
    public void render(float delta) {

        if (AspectRatioExplained.platformSpecific.isDebug()) {
            delta = 0.01f;
        }

        update(delta);

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Gdx.gl.glEnable(GL20.GL_BLEND);

        stage.act(delta);
        stage.draw();

        //Let the fun begin
        cameraGame.update();
        //viewPort.apply();
        game.batch.setProjectionMatrix(cameraGame.combined);
        game.batch.begin();
        //Render sprites
        game.batch.end();
    }

    @Override
    //Input in pixels
    public void resize(int width, int height) {
        Settings.resizeScreenPixels(width, height);
        viewPort.update(width, height);
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {

    }
}