package com.thortech.aspectratioexplained.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.thortech.aspectratioexplained.AbstractGameScreen;
import com.thortech.aspectratioexplained.Actors.Board;
import com.thortech.aspectratioexplained.AspectRatioExplained;
import com.thortech.aspectratioexplained.Settings;

/**
 * Created by ToHj on 31-01-2020.
 *
 */
public class ScreenGameFill extends AbstractGameScreen {

    private static final String TAG = ScreenGameFill.class.getName();

    private Board backgroundBoard = new Board(game);
    private Board upperLeft = new Board(game, "UpperLeft.jpg");
    private Board upperRight = new Board(game, "UpperRight.jpg");
    private Board lowerLeft = new Board(game, "LowerLeft.jpg");
    private Board lowerRight = new Board(game, "LowerRight.jpg");

    private OrthographicCamera cameraGame;      //For the game play

    private Viewport viewPort;

    public ScreenGameFill(AspectRatioExplained _game) {
	    super(_game);
        cameraGame = new OrthographicCamera(Settings.PHYSICALWIDTH, Settings.PHYSICALHEIGHT);
        cameraGame.position.set(cameraGame.viewportWidth / 2, cameraGame.viewportHeight / 2, 0);

        viewPort = new FillViewport(cameraGame.viewportWidth, cameraGame.viewportHeight, cameraGame);
        viewPort.apply(true);

        placeActors();

    }

    public void placeActors()
    {
        backgroundBoard.changeSize(1, 1, false);
        backgroundBoard.changePos(new Vector3(Settings.PHYSICALWIDTH / 2,Settings.PHYSICALHEIGHT / 2,0), true);

        lowerRight.changePos(new Vector3(Settings.PHYSICALWIDTH - lowerRight.getSize().x, 0, 0), false);
        lowerLeft.changePos(new Vector3(0, 0,0), false);
        upperRight.changePos(new Vector3(Settings.PHYSICALWIDTH - upperRight.getSize().x / 2, Settings.PHYSICALHEIGHT - upperRight.getSize().y / 2, 0), true);
        upperLeft.changePos(new Vector3(0, Settings.PHYSICALHEIGHT - upperLeft.getSize().y, 0), false);
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

        //Let the fun begin
        cameraGame.update();
        //viewPort.apply();

        game.batch.setProjectionMatrix(cameraGame.combined);
        game.batch.begin();
        //Render the board
        backgroundBoard.render(delta);
        upperLeft.render(delta);
        upperRight.render(delta);
        lowerLeft.render(delta);
        lowerRight.render(delta);
        game.batch.end();
    }

    @Override
    //Input in pixels
    public void resize(int width, int height) {
        Settings.resizeScreenPixels(width, height);
        viewPort.update(width, height, true);
        //cameraGame.position.set(cameraGame.viewportWidth / 2, cameraGame.viewportHeight / 2, 0);
    }

    @Override
    public void show() {
        //resize(Settings.getScreenWidthPixels(), Settings.getScreenHeightPixels());
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
        //todo: dispose all the actors!
        backgroundBoard.dispose();
        upperLeft.dispose();
        upperRight.dispose();
        lowerLeft.dispose();
        lowerRight.dispose();
    }
}