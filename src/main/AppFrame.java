package main;

import java.awt.FlowLayout;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import stateManagement.StateManager;

public class AppFrame extends JPanel
				implements Runnable{

	StateManager SM = new StateManager(this);
	
	Graphics2D g2d;
	
	String threadName;
	Thread t;
	boolean running;

	public AppFrame(String name) {
		setLayout(new FlowLayout());
		threadName = name;
	}

	private void init() {
		g2d = (Graphics2D) g2d;
		running = true;
	}

	public void run() {
		//Initialize appFrame
		init();

		//Start update loop
		while (running == true) {
			SM.update();
			SM.draw();
		}
	}

	public void start() {
		if (t== null) {
			t = new Thread(this, threadName);
			t.setPriority(Thread.MAX_PRIORITY);
			t.start();
		}
	}
}
