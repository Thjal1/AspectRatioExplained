package com.thortech.aspectratioexplained.Screens;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.thortech.aspectratioexplained.AbstractGameScreen;
import com.thortech.aspectratioexplained.Settings;
import com.thortech.aspectratioexplained.AspectRatioExplained;

import static com.badlogic.gdx.Gdx.*;


//TODO: change screen resolution in to "Potato units"
public class ScreenMenu extends AbstractGameScreen {

    private static final String TAG = ScreenLoad.class.getName();

    private OrthographicCamera camera;
    private FillViewport viewport;
    private Stage stage;

    //Table filling the entire screen
    private Table rootTable;
    private Pixmap pixmap;

    //Buttons etc. for the screen
    private Button btnPreferences;
    private Button btnGameStretched;
    private Button btnGameFill;
    private Button btnGameExtend;
    private Button btnGameFit;
    private Button btnGameScale;
    private Button btnGameScreen;
    private Button btnNoViewPort;
    private Button btnStageOnly;

    //TODO ADD BUTTONS and stuff

    private TextButton.TextButtonStyle buttonStyle;


    public ScreenMenu(AspectRatioExplained _game) {
        super(_game);

        stage  = new Stage();
        stage.clear();
        input.setInputProcessor(stage); //** stage is responsive **//

        pixmap = new Pixmap(1,1, Pixmap.Format.RGB565);
        pixmap.setColor(Settings.skin.getColor("tan"));       //Use the color made in the uiskin.json file
        pixmap.fill();

        //create and set the rootTable
        rootTable = new Table(Settings.skin);
        stage.addActor(rootTable);
        rootTable.setFillParent(true);
        //Set the background of the rootTable to use pixmap.
        rootTable.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture(pixmap))));

        if (AspectRatioExplained.platformSpecific.isDebug()){
            rootTable.setDebug(true);   //Turn on all debug lines - if only tables own lines are needed do: rootTable.debugTable(true);
        }

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Settings.PHYSICALWIDTH, Settings.PHYSICALHEIGHT);
        viewport = new FillViewport(Settings.PHYSICALWIDTH, Settings.PHYSICALHEIGHT, camera);
        viewport.apply();
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

        camera.update();

        this.create();

        rootTable.add(btnPreferences).colspan(2).width(250);
        rootTable.row();
        rootTable.add(btnNoViewPort).colspan(2).width(250);
        rootTable.row();
        rootTable.add(btnGameExtend).colspan(2).width(250);
        rootTable.row();
        rootTable.add(btnGameFill).colspan(2).width(250);
        rootTable.row();
        rootTable.add(btnGameFit).colspan(2).width(250);
        rootTable.row();
        rootTable.add(btnGameScale).colspan(2).width(250);
        rootTable.row();
        rootTable.add(btnGameScreen).colspan(2).width(250);
        rootTable.row();
        rootTable.add(btnGameStretched).colspan(2).width(250);
        rootTable.row();
        rootTable.add(btnStageOnly).colspan(2).width(250);
    }

    @Override
    public void render(float delta) {
        gl.glClearColor(0, 0.2f, 0, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        //Draw all the actors offset 0,0 is lower left corner. camera.viewportWidth, camera.viewportHeight is upper right corner.
        game.batch.end();

        stage.act(Math.min(graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void show() {
        input.setInputProcessor(stage); //** stage is responsive **//
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
        stage.dispose();
    }

    private void create(){
        buttonStyle = new TextButton.TextButtonStyle(Settings.skin.get(TextButton.TextButtonStyle.class));

        btnPreferences = new TextButton("Preferences", Settings.skin, "toggle");
        btnGameExtend = new TextButton("Extend", buttonStyle);
        btnGameFill = new TextButton("Fill", buttonStyle);
        btnGameFit = new TextButton("Fit", buttonStyle);
        btnGameScale = new TextButton("Scale", buttonStyle);
        btnGameScreen = new TextButton("Screen", buttonStyle);
        btnGameStretched = new TextButton("Stretched", buttonStyle);
        btnNoViewPort = new TextButton("No Viewport", buttonStyle);
        btnStageOnly = new TextButton("Stage Only", buttonStyle);

        btnPreferences.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(AspectRatioExplained.screenPreference);
                //dispose();
            }
        });

        btnNoViewPort.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(AspectRatioExplained.screenGameNoViewport);
                dispose();
            }
        });

        btnGameStretched.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(AspectRatioExplained.screenGameStretch);
                dispose();
            }
        });

        btnGameFill.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(AspectRatioExplained.screenGameFill);
                dispose();
            }
        });


        btnGameExtend.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(AspectRatioExplained.screenGameExtend);
                dispose();
            }
        });

        btnGameScale.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(AspectRatioExplained.screenGameScale);
                dispose();
            }
        });


        btnGameScreen.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(AspectRatioExplained.screenGameScreen);
                dispose();
            }
        });

        btnGameFit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(AspectRatioExplained.screenGameFit);
                dispose();
            }
        });

        btnStageOnly.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(AspectRatioExplained.screenGameStageOnly);
                dispose();
            }
        });
    }
}
