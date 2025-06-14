package com.gdx.game.Scenes;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class ParallaxLayer {
    public TextureRegion region ;
    public Vector2 parallaxRatio;
    public Vector2 startPosition;
    public Vector2 padding ;
    public ParallaxLayer(TextureRegion region, Vector2 parallaxRatio, Vector2 padding){
        this(region, parallaxRatio, new Vector2(0,0),padding);
    }

    public ParallaxLayer(TextureRegion region, Vector2 parallaxRatio, Vector2 startPosition, Vector2 padding){
        this.region  = region;
        this.parallaxRatio = parallaxRatio;
        this.startPosition = startPosition;
        this.padding = padding;
    }
}
