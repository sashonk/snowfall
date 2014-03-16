package com.me.snowfall;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ChoiceScreen extends MenuScreen{

	public ChoiceScreen(Snowfall theGame) {
		super(theGame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		
		Table table = new Table();
	
		TextButton back = new TextButton("Назад", getSnowfall().getManager().getSkin(), "menu");
		back.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x, float y) {
				Snowfall sf = ChoiceScreen.this.getSnowfall();
				sf.setScreen(sf.findScreen("main"));
			}

		});
		
		table.defaults().pad(2);
		table.add(back);
		
		table.pack();
		
		float x = (getStage().getWidth() - table.getWidth())/2;
		float y = (getStage().getHeight() - table.getHeight())/2;
		table.setPosition(x, y);
		getStage().addActor(table);
	}



}
