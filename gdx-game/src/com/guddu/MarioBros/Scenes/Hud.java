package com.guddu.MarioBros.Scenes;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.utils.viewport.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.guddu.MarioBros.*;
import com.badlogic.gdx.graphics.*;

// hud is place where score, level, player name etc shows up
public class Hud
{
	public Stage stage;
	private Viewport viewport;
	
	private  Integer worldTimer;
	private float timeCount;
	private Integer score;
	
	Label countdownLabel;
	Label scoreLabel;
	Label timeLabel;
	Label levelLabel;
	Label worldLabel;
	Label marioLable;
	public Hud(SpriteBatch sb){
		worldTimer = 300;
		timeCount = 0;
		score = 0;
		
		viewport = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT, new OrthographicCamera());
		stage = new Stage(viewport, sb);

		// creating tables so that screen ratio of different devices does'nt mess up with logos and buttons
		Table table = new Table();
		table.top();
		table.setFillParent(true);
		
		countdownLabel = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE)); 
		scoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		timeLabel = new Label("Time", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		levelLabel = new Label("1-1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		worldLabel = new Label("World", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		marioLable =  new Label("Mario", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		table.add(marioLable).expandX().padTop(10);
		table.add(worldLabel).expandX().padTop(10);
		table.add(timeLabel).expandX().padTop(10);
		table.row();
		table.add(scoreLabel).expandX();
		table.add(levelLabel).expandX();
		table.add(countdownLabel).expandX();
		
		stage.addActor(table);
	}
}
