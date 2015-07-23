package com.vnp.shotballons;

import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.input.touch.TouchEvent;

import com.vnp.andengine.AndEnginePortGameActivty;
import com.vnp.andengine.AndEngineSprise;

public class MainActivity extends AndEnginePortGameActivty {
	private AndEngineSprise bg = new AndEngineSprise();
	private AndEngineSprise balls = new AndEngineSprise();

	@Override
	public void onLoadResources() {
		super.onLoadResources();
		bg.onCreateResources(mEngine, this, "bg.png", 1, 1);
		balls.onCreateResources(getEngine(), this, "balls.png", 6, 1);
	}

	@Override
	public Scene onLoadScene() {
		Scene s = super.onLoadScene();
		bg.onCreateScene(s);
		balls.onCreateScene(s);
		return s;
	}

	@Override
	public boolean onSceneTouchEvent(Scene arg0, TouchEvent arg1) {
		return false;
	}

	@Override
	public void onLoadComplete() {
		getMainScene().attachChild(bg.getSprCat(), 0);
		AnimatedSprite sprite = new AnimatedSprite(10, 10, balls.getRegCat().deepCopy());
		getMainScene().attachChild(sprite, 1);
		sprite.animate(300);
	}
}