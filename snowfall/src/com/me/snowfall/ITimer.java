package com.me.snowfall;

public interface ITimer {
	
	public void act(float delta);
	
	public boolean isStarted();
	
	public void start();
	
	public void stop();
	
	public void reset();
	
	public int getValue(); //seconds
	
	public boolean isOut();
	
	public void registerListener(ITimerListener listener);
}
