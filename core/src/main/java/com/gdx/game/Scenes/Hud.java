package com.gdx.game.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class Hud implements Disposable {
    public Stage stage;
    public ExtendViewport viewport;
    public Table table;
    private Integer worldTimer;
    private float timeCount;
    public int score;
    private Label countdownLabel;
    static Label scoreLabel;
    private Label timeLabel;
    private Label levelLabel;
    private Label worldLabel;
    private Label marioLabel;
    private BitmapFont white;

    public Hud(SpriteBatch sb){
        worldTimer = 60;
        timeCount = 0;
        score = 0;

        viewport = new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
        stage = new Stage(viewport, sb);

        table = new Table();
        table.top();
        table.setFillParent(true);


        white = new BitmapFont(Gdx.files.internal("font/white16.fnt"), false);
        Label.LabelStyle labelStyle = new Label.LabelStyle(white, Color.WHITE);

        countdownLabel = new Label(String.format("%03d", worldTimer), labelStyle);
        scoreLabel = new Label(String.format("%06d", score), labelStyle);
        timeLabel = new Label("TIME", labelStyle);
        levelLabel = new Label("WASTE LAND", labelStyle);
        worldLabel = new Label("ROUND 1", labelStyle);
        marioLabel = new Label("SCORE:", labelStyle);

        table.add(marioLabel).expandX().padTop(10); // This expand X makes everything in the row share the row equally
        table.add(worldLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);

        table.row();
        table.add(scoreLabel).expandX();
        table.add(levelLabel).expandX();
        table.add(countdownLabel).expandX();


        stage.addActor(table);

    }

    public void update(float dt) {
        timeCount += dt;
        if(timeCount >= 1){
            worldTimer--;
            countdownLabel.setText(String.format("%03d", worldTimer));
            timeCount = 0;
        }
    }

    public  void addScore(int value){
        score += value;
        scoreLabel.setText(String.format("%06d", score));
    }
    public int getScore(){

      return score;
    }

    public Integer getTime(){
        return worldTimer;
    }

    @Override
    public void dispose() {
        stage.dispose();
    }


}

