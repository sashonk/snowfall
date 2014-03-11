package com.me.snowfall;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class MenuScreen extends AbstractScreen{
	TextureRegion background;
	public MenuScreen(Snowfall theGame) {
		super(theGame);

		TextureAtlas atlas = getSnowfall().getManager().getAtlas();
		Image background = new Image(atlas.findRegion("background"));		
		background.setBounds(0, 0, getStage().getWidth(), getStage().getHeight());
		getStage().addActor(background);
	}
	


}
