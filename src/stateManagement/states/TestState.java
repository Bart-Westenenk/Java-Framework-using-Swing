package stateManagement.states;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import main.ApplicationMain;
import stateManagement.*;

public class TestState extends AppState{
	
	
	public TestState(StateManager stateManager) {
		super(stateManager);
		SM = stateManager;
	}
	
	JLabel testLabel;
	
	StateManager SM;
	JPanel mainPanel;	
	
	@Override
	public void init(JPanel panel) {

		mainPanel = new JPanel();
		BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(layout);

		testLabel = new JLabel("Test label for test state");

		mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(testLabel);
		ApplicationMain.windowFrame.setTitle("Test view");
		
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.blue);
		panel.add(mainPanel);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void draw(JPanel panel) {

	}
	
	@Override
	public void disable() {

	}
}
