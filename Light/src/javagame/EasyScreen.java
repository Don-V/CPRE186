package javagame;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

//Every screen inherits from BasicGameState. Extends = inherits
public class EasyScreen extends BasicGameState{
	public String mouse = "No input yet";
	public boolean canGoOn;
	
	Image easyLevels;
	public EasyScreen(int state){ 
		
	}
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		easyLevels = new Image("res/menus/easy_levels(1080x720).png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		easyLevels.draw(0,0);
		g.drawString(mouse, 50, 50);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		mouse = "Mouse Position x: " + xPos + " y: " + yPos;
		
		Input input = gc.getInput();
		//Go to play state
		if((xPos>460 && xPos<625) && (yPos<280 && yPos > 245)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(1);
			}
		}
		if(!input.isMouseButtonDown(0)){
			canGoOn = true;
		}
		//Go to level 1 state
		if(canGoOn &&(xPos>225 && xPos<300) && (yPos<470 && yPos > 400)){
			if(input.isMouseButtonDown(0)){
				canGoOn = false;
				sbg.enterState(11);
			}
		}
		//Go to level 2 state
		if((xPos>367 && xPos<430) && (yPos<470 && yPos > 400)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(12);
			}
		}
		//Go to level 3 state
		if((xPos>507 && xPos<575) && (yPos<470 && yPos > 400)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(13);
			}
		}
		//Go to level 4 state
		if((xPos>645 && xPos<715) && (yPos<470 && yPos > 400)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(14);
			}
		}
		//Go to level 5 state
		if((xPos>786 && xPos<860) && (yPos<470 && yPos > 400)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(15);
			}
		}
	}
	
	
	public int getID(){
		return 10;
	}
}
