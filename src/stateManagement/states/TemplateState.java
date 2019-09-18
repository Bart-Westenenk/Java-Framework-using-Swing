package stateManagement.states;

import java.awt.Color;

import javax.swing.JPanel;

import main.ApplicationMain;
import stateManagement.*;

public class TemplateState extends AppState {

	StateManager SM;
	JPanel panel;
	
	public TemplateState(StateManager stateManager) {
		super(stateManager);
		SM = stateManager;
	}

	public void init(JPanel panel) {
		this.panel = panel;
		
		//Setup properties of the window and clean window of previous state. The components should be removed inside the Disable method of the previous state.
		panel.setBackground(Color.white); //Set the color of the background to white.
		
		//This method accesses the highest
		ApplicationMain.windowFrame.setTitle("Template view"); //Set the name of the window, displayed on the top of window, besides the icon of your app, the close and minimize button.
		ApplicationMain.windowFrame.setSize(1900, 1200); //Set the size of the window.
		ApplicationMain.windowFrame.setResizable(true); //Set resizeablity
		
		//Setup layout
		//If required, add your own container panels to create a custom layout
	}


	public void update() {
		
	}


	public void draw(JPanel panel) {
		
	}

	//Remove all listeners and remove components for the next state.
	public void disable() {
		//Remove listeners
		
		//Remove components like buttons and labels.
	}

}
