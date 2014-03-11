package com.me.snowfall;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
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
		
		Table table = new Table();
		Label label = new Label("В бесплатной версии недоступно\nПриобретайте платную версию и играйте", getSnowfall().getManager().getSkin());
		TextButton back = new TextButton("Назад", getSnowfall().getManager().getSkin(), "menu");
		back.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x, float y) {
				Snowfall sf = GameScreen.this.getSnowfall();
				sf.setScreen(sf.findScreen("menu"));
			}

		});
		
		table.defaults().pad(2);
		table.add(label).row();
		table.add(back);
		
		table.pack();
		
		getStage().addActor(table);
	}
	
	
	
}
