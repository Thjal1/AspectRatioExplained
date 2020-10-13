package com.thortech.aspectratioexplained.Actors;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.thortech.aspectratioexplained.Helpers.LogHelper;

public class LibGdXActor extends Actor {

    private static final String TAG = Board.class.getName();

    private Vector3 centerV3;
    private Texture texture;
    private Sprite sprite; // = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));

    private boolean moveRight = false;
    private boolean moveLeft = false;


    public LibGdXActor(){
        texture = new Texture(Gdx.files.internal("badlogic.jpg"));
        sprite = new Sprite(texture);
        centerV3 = new Vector3(sprite.getX(),sprite.getY(),0);
        setBounds(centerV3.x, centerV3.y, sprite.getWidth(), sprite.getHeight());

        setTouchable(Touchable.enabled);

        addListener(new InputListener(){

            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                switch (keycode) {
                    case Input.Keys.A:
                        LogHelper.Log(TAG + "-LibGdxActor LEFT", event.toString(), Application.LOG_INFO);
                        MoveByAction mba = new MoveByAction();
                        mba.setAmount(-100f, 0f);
                        mba.setDuration(10f);
                        LibGdXActor.this.addAction(mba);
                        ((LibGdXActor) event.getTarget()).moveLeft = true;
                }
                return true;
            }

           @Override
           //public boolean keyDown(InputEvent event, int keycode){
           public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
               LogHelper.Log(TAG + "-LibGdxActor 2", event.toString(), Application.LOG_INFO);
            //   if(keycode == Input.Keys.RIGHT){
                   MoveByAction mba = new MoveByAction();
                   mba.setAmount(100f, 0f);
                   mba.setDuration(10f);

                   LibGdXActor.this.addAction(mba);

                   ((LibGdXActor)event.getTarget()).moveRight = true;
              // }
               return true;
           }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture,this.getX(), this.getY());// centerV3.x, centerV3.y);
    }
}
/* NOT NEEDED
    @Override
    public void act(float delta) {
        if(moveRight && centerV3.x < 100){
            centerV3.x+=5;
        }
        super.act(delta);
    }

    @Override
    protected void positionChanged(){
        sprite.setPosition(getX(),getY());
        super.positionChanged();
    }
*/