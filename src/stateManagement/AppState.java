package stateManagement;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public abstract class AppState {

	StateManager SM;
	
	public AppState(StateManager stateManager) {
		SM = stateManager;
	}
	
	public abstract void init(JPanel panel);
	public abstract void update();
	public abstract void draw(JPanel panel);
	public abstract void disable();
	
	//Key methods / event handling;
}
