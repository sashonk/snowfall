package com.me.snowfall;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class NoFreeScreen extends MenuScreen{

	public NoFreeScreen(Snowfall theGame) {
		super(theGame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		
		Table table = new Table();
		Label label = new Label("В бесплатной версии недоступно\nПриобретайте платную версию и играйте", getSnowfall().getManager().getSkin());
		TextButton back = new TextButton("Назад", getSnowfall().getManager().getSkin(), "menu");
		back.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x, float y) {
				Snowfall sf = NoFreeScreen.this.getSnowfall();
				sf.setScreen(sf.findScreen("main"));
			}

		});
		
		table.defaults().pad(2);
		table.add(label).row();
		table.add(back);
		
		table.pack();
		
		float x = (getStage().getWidth() - table.getWidth())/2;
		float y = (getStage().getHeight() - table.getHeight())/2;
		table.setPosition(x, y);
		getStage().addActor(table);
	}

}
