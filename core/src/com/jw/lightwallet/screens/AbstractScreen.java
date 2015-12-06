package com.jw.lightwallet.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.jw.lightwallet.LightWallet;

public class AbstractScreen implements Screen {
	protected 		 	LightWallet game;
	protected 		 	BitmapFont font;
	protected float 	w;
	protected float 	h;
	protected float 	aspect;
	protected long 		screenShowTime;
	
	public AbstractScreen (LightWallet game) {
		this.game = game;
		this.font = new BitmapFont(Gdx.files.internal("fonts/bauchaomaicha.fnt"));
		this.w = Gdx.graphics.getWidth();
		this.h = Gdx.graphics.getHeight();
		this.aspect = w/h;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}