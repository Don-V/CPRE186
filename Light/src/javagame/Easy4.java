package javagame;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

//Every screen inherits from BasicGameState. Extends = inherits
public class Easy4 extends BasicGameState{
	Image gameBoard;

	public Easy4(int state){ 
		
	}
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		gameBoard = new Image("res/backgrounds/puzzle_background1(1080x720).png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Methods.currentStateNum = 14;
		gameBoard.draw(0,0);
		Methods.blankTiles();
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		Input input = gc.getInput();
		//Go to Menu state
		if((xPos>890 && xPos<1074) && (yPos<720 && yPos > 655)){
			if(input.isMouseButtonDown(0)){
				Play.canGoOn = false;
				sbg.enterState(0);
			}
		}
	}
	
	
	public int getID(){
		return 14;
	}
}
