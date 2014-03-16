package com.me.snowfall;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GameScreen extends AbstractScreen{
	public GameScreen(Snowfall theGame) {
		super(theGame);
		// TODO Auto-generated constructor stub
	}


	Stage stage;
	@Override
	public void show() {
		
		Image img = new Image(findRegion("mountain"));
		img.setBounds(0, 0, getStage().getWidth(), getStage().getHeight());
		getStage().addActor(img);
		
		final int initialValue = 300;
		final Timer2 timer = new Timer2(getSnowfall(), initialValue);
		timer.setPosition(400, 300);
	
		
		getStage().addActor(timer);
	}
	
	
	
}
