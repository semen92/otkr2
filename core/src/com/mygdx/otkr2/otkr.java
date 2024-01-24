package com.mygdx.otkr2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;

public class otkr extends ApplicationAdapter {
	static final int shd=540;
	static  final  int vd=960;
	SpriteBatch batch;
	Texture Snowstar;
	Texture snowground;
	Snowstar[]snowstars;


	@Override
	public void create() {
		batch = new SpriteBatch();
		Snowstar = new Texture("snowstar.png");
		snowground = new Texture("snowground.jpg");
		for (int i = 0; i <snowstars.length ; i++) {
			snowstars[i]=new Snowstar();
			snowstars[i].init();
		}


	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0.15f, 1);
		batch.begin();
		for (int i = 0; i <Snowstar.length ; i++){
			Snowstar[i].render(batch);


		batch.draw(snowground, 0, 0);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		snowground.dispose();
	}

	class Snowstar {

		float X,Y;
		float xv, yv;
		public void init() {
			X = MathUtils.random(0, shd);
			Y = MathUtils.random(0, vd);

		}
		public void render(SpriteBatch batch){
			batch.draw(Snowstar,X,Y);


		}








		public void snowupdate(float dt) {
			Y -= 100.0f * dt;
		}



		}
	}
