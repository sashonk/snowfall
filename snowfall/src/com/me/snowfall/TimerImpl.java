package com.me.snowfall;

import java.util.Collection;
import java.util.LinkedList;


public class TimerImpl  implements ITimer{
	float _initialValue;
	float _targetValue;
	float _currentValue;
	float _prevValue;
	boolean _started;
	boolean reverse;
	boolean elapsed;
	//int scale = 1000;
	float _speed;
	Collection<ITimerListener> _listeners = new LinkedList<ITimerListener>();
	
	public TimerImpl(int initialValue, int targetValue){
		this(initialValue, targetValue, 1f);
	}


	public TimerImpl(int initialValue, int targetValue, float speed /* > 1 to speed up */){
		_initialValue = initialValue;
		_targetValue = targetValue;
		_started = false;
		_currentValue = _initialValue;
		_prevValue = _currentValue;
		reverse = _targetValue < _initialValue;
		_speed = speed;
		elapsed = false;
	}

	public boolean isOut(){
		return elapsed;
	}

	public void act(float delta) {
		if(_started){
			
			if(!elapsed){
					_currentValue+=delta*_speed * (reverse ? (-1): 1);
				
				
				boolean tickEvent = false;
				boolean timeOutEvent = false;
				if(reverse){
					if(_currentValue<=_targetValue){
						timeOutEvent = true;
					}
				}
				else{
					if(_currentValue>=_targetValue){
						timeOutEvent = true;
					}				
				}
				
				if(getValue(_prevValue)!=getValue(_currentValue)){
					tickEvent = true;
					_prevValue = _currentValue;
				}
				
				
				if(tickEvent){
					for(ITimerListener listener: _listeners){
						listener.timeChanged();
					}
				}
				if(timeOutEvent){
			
					for(ITimerListener listener: _listeners){
						listener.timeOut();
					}	
					elapsed = true;
					//_started = false;
				}
			}


		}
	}
	
	private  int getValue(float v){
		return Math.round(v);
	}

	@Override
	public void start() {
		
		_started = true;
	}

	@Override
	public void stop() {
		_started = false;
		
	}

	@Override
	public void reset() {
		elapsed = false;
		
		boolean fire = getValue(_currentValue)!=getValue(_initialValue);
		_currentValue = _initialValue;
		_prevValue = _currentValue;
		
		if(fire)
		for(ITimerListener listener: _listeners){
			listener.timeChanged();
		}
	}

	@Override
	public int getValue() {
		return getValue(_currentValue);
	}

	@Override
	public void registerListener(ITimerListener listener) {
		if(!_listeners.contains(listener))
		_listeners.add(listener);
	}
	

	@Override
	public boolean isStarted() {
		return _started;
	}
 
	public static void main(String[] argc) throws InterruptedException{
		
		
		final ITimer t = new TimerImpl(20, 10, 4);
		
		t.registerListener(new ITimerListener() {
			
			@Override
			public void timeOut() {
				System.out.println("OUT!!");
				
			}
			
			@Override
			public void timeChanged() {
				System.out.println("tick="+t.getValue());
				
				
			}
		});
		
		t.start();
		
		while(true){
			t.act(0.02f);
			Thread.sleep(20);
			
			
			
		
		}
	}


}
