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

        addListener(new InputListener() {
                        @Override
                        public boolean keyDown(InputEvent event, int keycode) {
                            LogHelper.Log(TAG, event.toString()+ keycode, Application.LOG_INFO);
                            switch (keycode) {
                                case Input.Keys.LEFT:
                                    LogHelper.Log(TAG + "-LibGdxActor Left " + Input.Keys.LEFT, event.toString(), Application.LOG_INFO);
                                    MoveByAction mbaLeft = new MoveByAction();
                                    mbaLeft.setAmount(-100f, 0f);
                                    mbaLeft.setDuration(1f);
                                    LibGdXActor.this.addAction(mbaLeft);
                                    //((LibGdXActor) event.getTarget()).moveLeft = true;
                                    break;
                                case Input.Keys.RIGHT:
                                    LogHelper.Log(TAG + "-LibGdxActor RIGHT" + Input.Keys.LEFT, event.toString(), Application.LOG_INFO);
                                    MoveByAction mbaRight = new MoveByAction();
                                    mbaRight.setAmount(100f, 0f);
                                    mbaRight.setDuration(1f);
                                    LibGdXActor.this.addAction(mbaRight);
                                    //((LibGdXActor) event.getTarget()).moveRight = true;
                                    break;
                                case Input.Keys.UP:
                                    LogHelper.Log(TAG + "-LibGdxActor UP", event.toString(), Application.LOG_INFO);
                                    MoveByAction mbaUp = new MoveByAction();
                                    mbaUp.setAmount(0f, 100f);
                                    mbaUp.setDuration(1f);
                                    LibGdXActor.this.addAction(mbaUp);
                                    //((LibGdXActor) event.getTarget()).moveUp = true;
                                    break;
                                case Input.Keys.DOWN:
                                    LogHelper.Log(TAG + "-LibGdxActor DOWN", event.toString(), Application.LOG_INFO);
                                    MoveByAction mbaDown = new MoveByAction();
                                    mbaDown.setAmount(0f, -100f);
                                    mbaDown.setDuration(1f);
                                    LibGdXActor.this.addAction(mbaDown);
                                    //((LibGdXActor) event.getTarget()).moveDown = true;
                                    break;
                                default:
                                    LogHelper.Log(TAG + "-LibGdxActor No key catched", event.toString(), Application.LOG_INFO);
                                    break;
                            }
                            return true;
                        }
            });
        }
/*
           @Override

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
  */

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