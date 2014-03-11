package com.me.snowfall;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2;

public class Snowfall extends Game {


	Map<String, Screen> screens = new HashMap<String, Screen>();
	

	
	public Screen findScreen(String name){
		return screens.get(name);
	}
	
	ResourceManager manager;
	
	public ResourceManager getManager(){
		return manager;
	}
	
	@Override
	public void create() {

		manager = new ResourceManager();

		

				
		screens.put("main",   new MainMenuScreen(this));
		screens.put("game",   new GameScreen(this));
		screens.put("nofree",   new NoFreeScreen(this));
		screens.put("choice",   new ChoiceScreen(this));
		
		
		setScreen(findScreen("main"));
	}

	@Override
	public void dispose () {
		super.dispose();		
		manager.dispose();
	}
	
	public void setScreen (Screen screen) {
		super.setScreen(screen);
		Gdx.input.setInputProcessor(((AbstractScreen)screen).getStage());
	}
	
	
	public static void main(String[] argc){
		pack();
	}
	
	public static void pack(){

    	String []dirs = {"snowfall"};    	 
  
    	for(String dir : dirs){
    		TexturePacker2.process("D:\\topack\\"+dir, "D:\\topack\\"+dir+"\\packed", dir+".pack");
    	}
    }

	
}
