package experiment01_key;

import java.awt.*;
import java.awt.event.*;

public class KeyEventHandling extends WindowAdapter implements KeyListener {
	
	Frame f;
	TextArea ta;
	Label l1;
	Label l2;
	
	public KeyEventHandling() {
		f = new Frame();
		f.setSize(400,400);
		f.setLayout(null);
		f.setTitle("KeyBoard Event Handling");
		f.setVisible(true);
		f.addWindowListener(this);
		init();
		addComponents();
	}
	
	public void init() {
		l1 = new Label("");
		ta = new TextArea();
		l2 = new Label("");
		ta.setBounds(50,100,200,200);
		l1.setBounds(25,25,25,100);
		l2.setBounds(50,50,100,25);
		ta.addKeyListener(this);
	}
	
	public void addComponents() {
		f.add(ta);
		f.add(l1);
		f.add(l2);
	}
	
	public void windowClosing(WindowEvent e) {
		f.dispose();
	}
	
	public void keyPressed(KeyEvent e) {
		l2.setText("Key Pressed: " + e.getKeyChar());
	}
	
	public void keyReleased(KeyEvent e) {
		l2.setText("Key Released: " + e.getKeyChar());
	}
	
		
	public void keyTyped(KeyEvent e) {
		l2.setText("Key Typed: " + e.getKeyChar());
	}
	
	public static void main(String[] args) {
		KeyEventHandling obj = new KeyEventHandling();
	}
}