package com.me.snowfall;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenuScreen extends MenuScreen{

	public MainMenuScreen(Snowfall theGame) {
		super(theGame);
	}

	@Override
	public void show() {
	
		Table table = new Table();
		TextButton tbStart = new TextButton("Играть", getSnowfall().getManager().getSkin(), "menu");
		tbStart.addListener(new ClickListener(){
			public void clicked (InputEvent event, float x, float y) {
				Snowfall sf = MainMenuScreen.this.getSnowfall();
				sf.setScreen(sf.findScreen("nofree"));
			}
		});
		
		
		TextButton tbExit = new TextButton("Выход", getSnowfall().getManager().getSkin(), "menu");
		tbExit.addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.exit();
			}
		});

		table.defaults().pad(2);
		table.add(tbStart).row();		
		table.add(tbExit);
		table.pack();
		
		float x = (getStage().getWidth() - table.getWidth())/2;
		float y = (getStage().getHeight() - table.getHeight())/2;
		table.setPosition(x, y);
		
		getStage().addActor(table);
	}
	

}
