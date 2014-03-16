package com.me.snowfall;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Timer2 extends Group {
	boolean started;
	Label labelMinutes;
	Label labelSeconds;
	
	
	int initialValue = 300;
	int lastValue=0;
	Sound tick;
	ITimer timer;
	
	public Timer2(Snowfall sf, int initialVal){

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
		
		
		timer = new TimerImpl(initialVal, 280, 4);
		renderTime();
		
		this.addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				
				if(timer.isOut()){
					timer.stop();
					timer.reset();
				}else{
				timer.start();
				}
			
				return true;
			}
		});
		
		timer.registerListener(new ITimerListener() {
			
			@Override
			public void timeOut() {
				System.out.println("OUT!");
				
			}
			
			@Override
			public void timeChanged() {
				Timer2.this.renderTime();
			}
		});
	}
	
	@Override
	public void act(float delta){
		super.act(delta);
		timer.act(delta);
	}
	
	
	void renderTime(){
		Date date  = new Date(timer.getValue()*1000);
		DateFormat dfm = new SimpleDateFormat("mm");
		DateFormat dfs = new SimpleDateFormat("ss");		

		
		labelMinutes.setText(dfm.format(date));
		labelSeconds.setText(dfs.format(date));
	}



}
