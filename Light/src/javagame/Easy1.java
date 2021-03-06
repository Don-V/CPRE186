package javagame;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;

//Every screen inherits from BasicGameState. Extends = inherits
public class Easy1 extends BasicGameState{
	public static boolean shoot;
	public static boolean refresh;
	Image gameBoard;
	public String mouse = "No input yet";

	public static boolean rotate;
	public int numRotates =0;
	public static boolean isButtonUp;

	
	
	public Easy1(int state){ 
		
	}
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		gameBoard = new Image("res/backgrounds/puzzle_background1(1080x720).png");
		numRotates = 0;
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Methods.currentStateNum = 11;
		gameBoard.draw(0,0);
		g.drawString(mouse, 50, 50);
		Methods.blankTiles();

			
		if(numRotates <=1){
			Methods.generateBoard();
			
		}
		else if(numRotates > 1){
			Methods.generateBoardRotated();
		}
		
		if(shoot){
			Methods.shoot();
		}
		 if(refresh){
			shoot = false;
			refresh = false;
			numRotates = 1;
			Methods.list = new ArrayList<>();
		}
		 if(rotate){
			numRotates++;
			
			Methods.changeLocation= true;
			rotate = false;
			Methods.rotateMirrorOnce = true;

		}


		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		int xPos = Mouse.getX(); //gets the x position
		int yPos = Mouse.getY(); //gets the y position
		mouse = "Mouse Position x: " + xPos + " y: " + yPos;
		Input input = gc.getInput();
		//Go to Menu state
		if((xPos>890 && xPos<1074) && (yPos<720 && yPos > 655)){
			if(input.isMouseButtonDown(0)){
				Play.canGoOn = false;
				refresh = true;
				sbg.enterState(0);
			}
		}
		//Added ALL OF THIS  for game
		if((xPos>260 && xPos<820)&&(yPos>80 && yPos<640)){
			if(input.isMouseButtonDown(0)){
				//ADDED THIS FOR ROTATES
				isButtonUp = true;		
			}
		}
		if(isButtonUp){
			if(!input.isMouseButtonDown(0)){
				rotate = true;
				isButtonUp = false;
				Methods.xRotate =  Methods.findXRotate(xPos-260);
				Methods.yRotate = Methods.findYRotate(yPos-80);
				Methods.locationBool[Methods.xRotate][Methods.yRotate] = false;
				//System.out.println("x: " +Methods.xRotate + "y: "+ Methods.yRotate + Methods.locationBool[Methods.xRotate][Methods.yRotate]);
			}
		}
		if((xPos<986 && xPos>820)&&(yPos>88&&yPos<130)){
			if(input.isMouseButtonDown(0)){
				shoot = true;
			}
		}
		if(!input.isMouseButtonDown(0)){
			Play.canContinue=true;
		}
		
		if((xPos<311 && xPos>279)&&(yPos>16&&yPos<61)){
			if(Play.canContinue&&(input.isMouseButtonDown(0))){
				Play.canContinue = false;
				refresh = true;
				sbg.enterState(10);
			}
		}
		
		if((xPos<802 && xPos>770)&&(yPos>16&&yPos<61)){
			if(Play.canContinue&&(input.isMouseButtonDown(0))){
				Play.canContinue = false;
				Easy2.numRotates ++;
				//Methods.list = new ArrayList<>();
				refresh = true;
				sbg.enterState(12);
			}
		}
		if((xPos>524 && xPos<556) && (yPos<57 && yPos > 18)){
			if(input.isMouseButtonDown(0)){
				refresh = true;
				
			}
		}

	}
	
	public int getID(){
		return 11;
	}
}
