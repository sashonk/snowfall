package com.me.snowfall;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class ResourceManager {
	
	static String CHARS	= "\u0401\u0402\u0403\u0404\u0405\u0406\u0407\u0408\u0409\u040A\u040B\u040C" +
			"\u040D\u040E\u040F\u0410\u0411\u0412\u0413\u0414\u0415\u0416\u0417\u0418\u0419\u041A\u041B\u041C" +
			"\u041D\u041E\u041F\u0420\u0421\u0422\u0423\u0424\u0425\u0426\u0427\u0428\u0429\u042A\u042B\u042C" +
			"\u042D\u042E\u042F\u0430\u0431\u0432\u0433\u0434\u0435\u0436\u0437\u0438\u0439\u043A\u043B\u043C" +
			"\u043D\u043E\u043F\u0440\u0441\u0442\u0443\u0444\u0445\u0446\u0447\u0448\u0449\u044A\u044B\u044C" +
			"\u044D\u044E\u044F\u0450\u0451\u0452\u0453\u0454\u0455\u0456\u0457\u0458\u0459\u045A\u045B\u045C" +
			"\u045D\u045E\u045F\u0460\u0461\u0462\u0463\u0464\u0465\u0466\u0467\u0468\u0469\u046A\u046B\u046C" +
			"\u046D\u046E\u046F\u0470\u0471\u0472\u0473\u0474\u0475\u0476\u0477\u0478\u0479\u047A\u047B\u047C" +
			"\u047D\u047E\u047F\u0480\u0481\u0482\u0483\u0484\u0485\u0486\u0487\u0488\u0489\u048A\u048B\u048C" +
			"\u048D\u048E\u048F\u0490\u0491\u0492\u0493\u0494\u0495\u0496\u0497\u0498\u0499\u049A\u049B\u049C" + 
			"\u049D\u049E\u049F\u04A0\u04A1\u04A2\u04A3\u04A4\u04A5\u04A6\u04A7\u04A8\u04A9\u04AA\u04AB\u04AC" +
			"\u04AD\u04AE\u04AF\u04B0\u04B1\u04B2\u04B3\u04B4\u04B5\u04B6\u04B7\u04B8\u04B9\u04BA\u04BB\u04BC" +
			"\u04BD\u04BE\u04BF\u04C0\u04C1\u04C2\u04C3\u04C4\u04C5\u04C6\u04C7\u04C8\u04C9\u04CA\u04CB\u04CC" +
			"\u04CD\u04CE\u04CF\u04D0\u04D1\u04D2\u04D3\u04D4\u04D5\u04D6\u04D7\u04D8\u04D9\u04DA\u04DB\u04DC" +
			"\u04DD\u04DE\u04DF\u04E0\u04E1\u04E2\u04E3\u04E4\u04E5\u04E6\u04E7\u04E8\u04E9\u04EA\u04EB\u04EC" +
			"\u04ED\u04EE\u04EF\u04F0\u04F1\u04F2\u04F3\u04F4\u04F5\u04F6\u04F7\u04F8\u04F9\u04FA\u04FB\u04FC" +
			"\u04FD\u04FE\u04FF";
	
	AssetManager assetManager;
	Skin skin;
	TextureAtlas atlas;
	
	public AssetManager getAssetManager(){
		return assetManager;
	}
	public Skin getSkin(){
		return skin;
	}
	
	public TextureAtlas getAtlas(){
		return atlas;
	}
	
	
	
	public ResourceManager(){
		assetManager = new AssetManager();
		assetManager.load("data/snowfall.pack", TextureAtlas.class);
		assetManager.load("data/beep.wav", Sound.class);
		assetManager.load("data/tick.wav", Sound.class);
		assetManager.finishLoading();
		
		
		
		atlas = assetManager.get("data/snowfall.pack");
		
		skin = new Skin(); 				
		TextureAtlas atlas = assetManager.get("data/snowfall.pack");
		skin.add("button", new NinePatch(atlas.findRegion("button"), 16,16,16,16)) ;
		skin.add("button_down",  new NinePatch(atlas.findRegion("button_down"), 16,16,16,16));
		
		NinePatch patch = new NinePatch(atlas.findRegion("clock"), 16,16,16,16);
		skin.add("clock", patch);
		
		FreeTypeFontGenerator menuFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("data/main.ttf"));
		BitmapFont menuFont18 = menuFontGenerator.generateFont(18, FreeTypeFontGenerator.DEFAULT_CHARS.concat(CHARS), false);
		BitmapFont menuFont36 = menuFontGenerator.generateFont(36, FreeTypeFontGenerator.DEFAULT_CHARS.concat(CHARS), false);
		BitmapFont menuFont72 = menuFontGenerator.generateFont(72, FreeTypeFontGenerator.DEFAULT_CHARS.concat(CHARS), false);

		menuFontGenerator.dispose();
		skin.add("menu", menuFont36);
		skin.add("default", menuFont18);
		skin.add("big", menuFont72);

		TextButtonStyle tbMenuStyle = new TextButtonStyle();
		tbMenuStyle.up = skin.getDrawable("button");
		tbMenuStyle.down = skin.getDrawable("button_down");
		tbMenuStyle.overFontColor = Color.YELLOW.cpy();
		tbMenuStyle.font = skin.getFont("menu");
		tbMenuStyle.fontColor = Color.WHITE.cpy();
		tbMenuStyle.pressedOffsetX =2;
		tbMenuStyle.pressedOffsetY = -2;
		skin.add("menu", tbMenuStyle);
	
		
		LabelStyle lStyleMenu = new LabelStyle();
		lStyleMenu.font = skin.getFont("big");
		lStyleMenu.fontColor = Color.BLACK.cpy();
		lStyleMenu.background = skin.getDrawable("clock");
		skin.add("big", lStyleMenu);
		
		LabelStyle lStyle = new LabelStyle();
		lStyle.font = skin.getFont("default");
		lStyle.fontColor = Color.WHITE.cpy();
		

		
		skin.add("default", lStyle);

	}
	
	public void dispose(){
		skin.dispose();
		assetManager.dispose();
		
	}
}
