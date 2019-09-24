package stateManagement.states;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.MenuBar;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.plaf.synth.*;

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
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Get the current screen Size
		System.out.print(screenSize);
		ApplicationMain.windowFrame.setSize((int) (screenSize.width * 0.8), (int) (screenSize.height * 0.8)); //Set the size of the window.
		Dimension frameSize = ApplicationMain.windowFrame.getSize();
		
		ApplicationMain.windowFrame.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		
		ApplicationMain.windowFrame.setResizable(true); //Set resizeablity
		//ApplicationMain.windowFrame.setMenuBar(); //Set a menubar, not used in this template.
		
		//From this point on it is on you to create a layout and add UI components
	}


	public void update() {
		
	}


	public void draw(Graphics graphics) {
		
	}

	//Remove all listeners and remove components for the next state.
	public void disable() {
		//Remove listeners
		
		//Remove components like buttons and labels.
	}

}
