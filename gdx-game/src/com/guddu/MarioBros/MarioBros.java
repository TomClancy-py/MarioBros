package com.guddu.MarioBros;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.guddu.MarioBros.Screens.*;

public class MarioBros extends Game
{
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 280;
	public SpriteBatch batch;
	

	@Override
	public void render()
	{
		// TODO: Implement this method
		super.render();
	}

	@Override
	public void create()
	{
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));		
	}

	@Override
	public void dispose()
	{
	}

}
