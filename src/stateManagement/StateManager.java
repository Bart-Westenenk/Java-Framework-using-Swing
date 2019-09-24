package stateManagement;

import java.awt.Graphics;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import stateManagement.*;
import stateManagement.states.*;

public class StateManager {

	ArrayList<AppState> appStates;
	
	public final static int LOGINSTATE = 0;
	public final static int TESTSTATE = 1;
	public final static int TEMPLATESTATE = 2;
	
	private int currentState;
	
	JPanel mainPanel;
	Graphics graphics;
	
	public StateManager(JPanel panel) {
		mainPanel = panel;
		panel.add(graphics);
		
		//Initialize the arraylist
		appStates = new ArrayList<AppState>();
		
		//Add all the states
		appStates.add(new LoginState(this));
		appStates.add(new TestState(this));
		appStates.add(new TemplateState(this));
		
		//Set default state
		setState(LOGINSTATE);
	}
	
	public void setState(int state) {
		currentState = state;
		appStates.get(currentState).init(mainPanel);
	}
	
	public void update() {
		appStates.get(currentState).update();
	}
	
	public void draw() {
		appStates.get(currentState).draw(Graphics);	//Panel --> mainpanel? More bugproof?
	}
	
	public void changeState(int state) {
		appStates.get(currentState).disable();
		setState(state);
	}
}
