package com.guddu.MarioBros.Screens;
import com.badlogic.gdx.*;
import com.guddu.MarioBros.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.utils.viewport.*;
import com.guddu.MarioBros.Scenes.*;

public class PlayScreen implements Screen
{
	private MarioBros game;
	private OrthographicCamera gamecam;
	private Viewport gameport;
	private Hud hud;
	
	public PlayScreen(MarioBros game){
		this.game = game;
		gamecam = new OrthographicCamera();
		gameport = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT, gamecam);
		hud = new Hud(game.batch);
		
	}
	

	@Override
	public void render(float p1)
	{
		game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
		hud.stage.draw();
		
	}

	@Override
	public void resize(int width, int height)
	{
		gameport.update(width, height);
		
	}

	@Override
	public void show()
	{
	}

	@Override
	public void hide()
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}

	@Override
	public void dispose()
	{
	}

	
}
