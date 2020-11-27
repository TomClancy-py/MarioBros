package com.guddu.MarioBros.Screens;
import com.badlogic.gdx.*;
import com.guddu.MarioBros.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.utils.viewport.*;
import com.guddu.MarioBros.Scenes.*;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.*;
import com.badlogic.gdx.math.*;

import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.maps.objects.*;
import com.badlogic.gdx.maps.*;public class PlayScreen implements Screen
{
	private MarioBros game;
	private OrthographicCamera gamecam;
	private Viewport gameport;
	private Hud hud;
	
	//Tiles map variables
	private TmxMapLoader maploader;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	
	//Box2d variables
	private World world;
	private Box2DDebugRenderer b2dr;
	
	
	
	
	public PlayScreen(MarioBros game){
		this.game = game;
		gamecam = new OrthographicCamera();
		gameport = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT, gamecam);
		hud = new Hud(game.batch);
		maploader = new TmxMapLoader();
		map = maploader.load("level1.txm");	//enter the name of the map in the android assests folder
		renderer = new OrthogonalTiledMapRenderer(map);
		gamecam.position.set(gameport.getWorldWidth()/2, gameport.getWorldHeight()/2, 0);
		//box2d physics
		world = new World(new Vector2(0, 0), true);
		b2dr = new Box2DDebugRenderer();
		
		BodyDef bdef = new BodyDef();
		PolygonShape shape = new PolygonShape();
		FixtureDef fdef = new FixtureDef();
		Body body;
		
		for(MapObject object : map.getLayers().get(/*enter the object layer number from bottom to top and count from 0*/2).getObjects().getByType(RectangleMapObject.class)){
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			
			bdef.type = BodyDef.BodyType.StaticBody;
			bdef.position.set(rect.getX() + rect.getWidth() /2, rect.getY()+ rect.getHeight() /2);
			
			body = world.createBody(bdef);
			
			shape.setAsBox(rect.getWidth()/2, rect.getHeight()/2);
			fdef.shape = shape;
			body.createFixture(fdef);
			//static bodies not get affected by forces of the game but are affected by the player force 
			//Dynamic bodies are affected by all the forecs and player forces
			//Kinematic bodies are bodies which do no get affected by anu force but can move on their own.
			//do this for every body but set theri own classes
		}
		
	}
	

	public void update(float dt){
		handleInput();
		gamecam.update();
		renderer.setView(gamecam);
		
		}
	
	@Override
	public void render(float delta)
	{
		update(delta);
		
		
		//clear screen with black
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.render();
		
		//renderer our Box2DDebugLines
		b2dr.render(world, gamecam.combined);
		//draw what HUD camera sees
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
	public void handleInput(){
		if (Gdx.input.isTouched()){
			gamecam.position.x += 100;
			
		}

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