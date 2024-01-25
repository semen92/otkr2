
package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Game.*;
import com.sun.tools.classfile.TypeAnnotation;

public class MYGdxGame extends ApplicationAdapter {


Snowstar[]snowstars;
	 @Override
	public void create() {

		batch = new SpriteBatch();
		Snowstar = new Texture("snowstar.png");
		snowground=new Texture("snowground.jpg");
		snowstars= new Snowstar[100];
		 for (int i = 0; i <snowstars.length ; i++) {
			 snowstars[i]=new Snowstar();
			 snowstars[i].init();
		 }









		}






	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);

		ScreenUtils.clear(0, 0, 0.15f, 1);
		batch.begin();

		for (int i = 0; i <snowstars.length ; i++) {
				snowstars[i].render(batch);
		}
		igrok = new Texture("ded3.png");
		Igrok santa = new Igrok();
		batch.draw(igrok,santa.localPos.x,santa.localPos.y);



		batch.draw(snowground,0,0);

		batch.end();
	}
	public void update(float dt){
		for (int i = 0; i <snowstars.length ; i++) {
			snowstars[i].snowupdate(dt);
		}

		Igrok santa = new Igrok();
		santa.move(dt);

	}


	@Override
	public void dispose () {
		batch.dispose();

	}

	static final  int shd =540;
	static  final int vd =960;
	static    int saveSOWSTARS;
	SpriteBatch batch;
	Texture Snowstar;

	Texture snowground;
	Texture igrok;




	class Snowstar {
		  float size;

		float X,Y;
		float xv,yv;
		public  void snowupdate(float dt)
		{ if (Y<-10){
			Y=vd;
		}
			Y-=100.0f*dt;
		}
		public void render(SpriteBatch batch){
			batch.draw(Snowstar ,X-8,Y-8,0,0,16,16);
			Igrok Samta = new Igrok();
			Samta.move(float dt);








		}
		public  void init(){
			X=MathUtils.random(0,  shd);
			Y=MathUtils.random(0,vd);
			size=MathUtils.random(0.4f,1.0f);










		}}
	class Igrok{
		float X,y,speed=10.0f ;

		Vector2 localPos= new Vector2();



		public Igrok(){
			//Position new Vector2
			// что есть vector2
			int X=120;
			int Y=190;
			localPos= new Vector2(X,Y);



		}
		public  void Render(SpriteBatch batch){
			batch.draw(igrok,localPos.x,localPos.y);



		}

		public  void  move(float dt){

			if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)){
				X+=dt*speed;
			}
			if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)){
				X-= dt *speed;
			}
			if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)){
				y+=dt*speed;
			}
			if (Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)){
				y-=dt*speed;

			}


		}

	}
}




