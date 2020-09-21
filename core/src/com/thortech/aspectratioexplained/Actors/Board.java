package com.thortech.aspectratioexplained.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.thortech.aspectratioexplained.Settings;
import com.thortech.aspectratioexplained.AspectRatioExplained;

import java.util.Set;

/**
 * Created by ToHj on 28-02-2016.
 */
public class Board extends AbstractActor {
    private static final String TAG = Board.class.getName();

    private Vector3 centerV3;
    private Texture boardTexture;
    private Sprite boardSprite;

    private float elapsedTime = 0;

    private float physicalWidth = 2.5f;
    private float physicalHeight = 2.5f;

    private String file = "";

    public Board(AspectRatioExplained _game)
    {
        super(_game);
        create("");
    }
    public Board(AspectRatioExplained _game, String fileName)
    {
        super(_game);
        create(fileName);
    }

    private void create(String fileName)
    {
        centerV3 = new Vector3(0,0,0);

        if (fileName == "")
            file = "badlogic.jpg";
        else
            file = fileName;
        boardTexture = new Texture(Gdx.files.internal(file));
        boardSprite = new Sprite(boardTexture);

        boardSprite.setPosition(centerV3.x, centerV3.y);
        boardSprite.setSize(physicalWidth,physicalHeight);
    }

    @Override
    public void render (float dt)
    {
        elapsedTime += dt;

        game.batch.draw(boardSprite, centerV3.x, centerV3.y, physicalWidth, physicalHeight);
    }

    public Vector3 getPos(){
        return centerV3;
    }
    public void changePos(Vector3 v3, boolean center)
    {
        if (center == false){
            this.centerV3 = v3;
        }
        else{
            this.centerV3.y = v3.y - physicalWidth / 2;
            this.centerV3.x = v3.x - physicalHeight / 2;
        }
    }

    public void changeSize(float physicalWidth, float physicalHeight, boolean absoluteSize)
    {
        if(absoluteSize)
        {
            this.physicalWidth = physicalWidth;
            this.physicalHeight = physicalHeight;
        }
        else
        {
            this.physicalWidth = Settings.PHYSICALWIDTH * physicalWidth;
            this.physicalHeight = Settings.PHYSICALHEIGHT * physicalHeight;
        }
    }

    public Vector3 getSize()
    {
        return new Vector3(physicalWidth, physicalHeight, 0);
    }

    public void setState(String _state){

    }

    public void dispose() {
        boardSprite.getTexture().dispose();
        boardTexture.dispose();
    }
}
