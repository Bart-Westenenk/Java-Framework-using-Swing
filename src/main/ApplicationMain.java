package main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javafx.application.*;

public class ApplicationMain {
	
	public static int WIDTH = 960;
	public static int HEIGHT = 720;
	
	public static JFrame windowFrame;
	
	public static void main(String[] args) {
		
		
		
		windowFrame = new JFrame();
		AppFrame panel = new AppFrame("Login");
		
		windowFrame.setContentPane(panel);
		
		windowFrame.setTitle("Login");
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowFrame.setSize(WIDTH, HEIGHT);
		windowFrame.setResizable(false);
		windowFrame.pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = windowFrame.getSize();
		windowFrame.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		windowFrame.setVisible(true);
		
		panel.start();
	}

}

/*
 * Application main --> Windowmanager (JFrame)
 * 
 * 
 * 
 * 
*/
