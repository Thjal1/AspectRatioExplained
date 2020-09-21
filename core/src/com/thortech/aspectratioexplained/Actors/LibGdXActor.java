package com.thortech.aspectratioexplained.Actors;

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

public class LibGdXActor extends Actor {

    private static final String TAG = Board.class.getName();

    private Vector3 centerV3;
    private Texture texture;
    private Sprite sprite = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));

    public boolean started = false;


    public LibGdXActor(){
        texture = new Texture(Gdx.files.internal("badlogic.jpg"));
        sprite = new Sprite(texture);
        centerV3 = new Vector3(sprite.getX(),sprite.getY(),0);
        //setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        setBounds(centerV3.x, centerV3.y, sprite.getWidth(), sprite.getHeight());

        setTouchable(Touchable.enabled);

        addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                ((LibGdXActor)event.getTarget()).started = true;
                return true;
            }

           @Override
           public boolean keyDown(InputEvent event, int keycode){
               if(keycode == Input.Keys.RIGHT){
                   MoveByAction mba = new MoveByAction();
                   mba.setAmount(100f, 0f);
                   mba.setDuration(5f);

                   LibGdXActor.this.addAction(mba);


                   ((LibGdXActor)event.getTarget()).started = true;
               }
               return true;
           }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
        //batch.draw(texture,centerV3.x, centerV3.y);
    }

    @Override
    public void act(float delta) {
        if(started){
            centerV3.x+=5;
        }
        super.act(delta);
    }

    @Override
    protected void positionChanged(){
        sprite.setPosition(getX(),getY());
        super.positionChanged();
    }
}
