package com.me.snowfall;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.IntAction;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class Timer extends Group{
	boolean started;
	Label labelMinutes;
	Label labelSeconds;
	
	
	int initialValue = 300;
	int currentValue=0;
	Sound tick;
	public Timer(Snowfall sf, int initialVal){
		initialValue = initialVal;
		currentValue = initialValue;
		Table t = new Table();
		labelMinutes = new Label("00", sf.getManager().getSkin(), "big");
		labelSeconds = new Label("00", sf.getManager().getSkin(), "big");

		t.defaults().pad(2);
		t.add(labelMinutes);
		t.add(labelSeconds);
		t.pack();
		addActor(t);
		
		tick = sf.getManager().getAssetManager().get("data/tick.wav");		
		this.setSize(t.getWidth(), t.getHeight());
		renderTime(initialValue);
		started = false;
		
	
	}
	
	public void stop(){
		started = false;
		
		List<Action> rm = new ArrayList<Action>(getActions().size);
		for(Action a : getActions()){
			rm.add(a);
		}
		
		for(Action a: rm){
			removeAction(a);
		}
		
	}
	
	public void start(){
		if(started){
			return;
		}
		
		started = true;
	

		final IntAction action = new IntAction();
		action.setStart(initialValue);
		action.setEnd(0);
		action.setDuration(initialValue);
		addAction(action);
		
		currentValue = action.getValue();
		
		addAction(forever(run(new Runnable() {
			
			@Override
			public void run() {
				int value = action.getValue();
				if(value!=currentValue){
					tick.play();
					currentValue = value;
				}
				renderTime(value);
				
			}
			
		})));
		
	}
	
	public boolean isStarted(){
		return started;
	}
	
	public void reset(){
		stop();
		if(started){			
			start();
		}
		else{
			currentValue = initialValue;
			renderTime(initialValue);
		}
	}
	
	void renderTime(int value){
		Date date = new Date(value*1000);

		DateFormat dfm = new SimpleDateFormat("mm");
		DateFormat dfs = new SimpleDateFormat("ss");		

		
		labelMinutes.setText(dfm.format(date));
		labelSeconds.setText(dfs.format(date));
	}
	
	public int getValue(){
	
			return currentValue;
		
	}
	
	static String formatValue(int value){
		DateFormat df = new SimpleDateFormat("mm ss");
		Date date = new Date(value*1000);
		return df.format(date);
	}

}
