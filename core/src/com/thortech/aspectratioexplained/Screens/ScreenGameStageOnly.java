package com.thortech.aspectratioexplained.Screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
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
    private LibGdXActor libGdXActor1 = new LibGdXActor();

    private static class TestActor extends Actor {
        private boolean touched;
        private Texture texture = new Texture(Gdx.files.internal("badlogic.jpg"));


        private TestActor() {
            setBounds(100, 100, 600, 600);

            addListener(new InputListener() {
                @Override
                public boolean keyDown(InputEvent event, int keycode) {
                    touched = true;
                    return true;
                }

                @Override
                public boolean keyUp(InputEvent event, int keycode) {
                    touched = false;
                    return true;
                }

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    touched = true;
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    touched = false;
                }
            });
        }

        public void act(float delta) {
            super.act(delta);
        }

        @Override
        public void draw(Batch batch, float parentAlpha) {
            super.draw(batch, parentAlpha);

            batch.setColor(touched ? Color.GREEN : Color.RED);
            batch.draw(texture, getX(), getY(), getWidth(), getHeight());
        }
    }

    private final Stage ui = new Stage(new ExtendViewport(1920, 1080));

    public ScreenGameStageOnly(AspectRatioExplained _game) {
        super(_game);
        create();
    }

    protected void create() {
        Gdx.input.setInputProcessor(ui);
        ui.setDebugAll(true);
        ui.addActor(new TestActor());
        ui.addActor(libGdXActor1);
    }

    public void show() {
        Gdx.input.setInputProcessor(ui);
        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        ui.setKeyboardFocus(libGdXActor1);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.706f, 0.851f, 0.847f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        ui.getViewport().apply();
        ui.act(delta);
        ui.draw();
    }

    @Override
    public void resize(int width, int height) {
        ui.getViewport().update(width, height, true);
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void pause() {
    }

    public void resume() {
    }
}
    /*
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
        placeActors();

        Gdx.input.setInputProcessor(stage);
        stage.setDebugAll(true);
    }

    public void placeActors()
    {
        LibGdXActor actor = new LibGdXActor();
        actor.setTouchable(Touchable.enabled);
        stage.addActor(actor);
        stage.setKeyboardFocus(stage.getActors().first());

        LogHelper.Log(TAG, "placeActors called", Application.LOG_INFO);
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

        Gdx.gl.glClearColor(0, 0, 0.7f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Gdx.gl.glEnable(GL20.GL_BLEND);

        //Let the fun begin
        cameraGame.update();
        //viewPort.apply();
        game.batch.setProjectionMatrix(cameraGame.combined);
        game.batch.begin();
        //Render sprites
        game.batch.end();

        stage.act(delta);
        stage.draw();
    }

    @Override
    //Input in pixels
    public void resize(int width, int height) {
        Settings.resizeScreenPixels(width, height);
        viewPort.update(width, height);
    }

    @Override
    public void show() {
        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
*/

