package experiment02_mouse;

import java.awt.*;
import java.awt.event.*;

public class MouseEventHandling extends WindowAdapter implements MouseListener {
	
	Frame f;
	TextArea ta;
	Label l1, l2;
	private static final Font Font = null;
	
	public MouseEventHandling() {
		f = new Frame();
		f.setVisible(true);
		f.setSize(400,400);
		f.setLayout(null);
		f.setTitle("Mouse Event Handling");
		
		init();
		addComponents();
		register();
	}
	
	public void init() {
		ta = new TextArea();
		l1 = new Label("");
		l2 = new Label("");
		ta.setBounds(50,100,150,150);
		l1.setBounds(25,25,25,100);
		l2.setBounds(50,50, 250, 25);
		l2.setFont(new Font("Arial", Font.ITALIC, 14)); // adding font style to label l2
	}
	
	public void addComponents() {
		f.add(ta);
		f.add(l1);
		f.add(l2);
	}
	
	public void register() {
		f.addWindowListener(this);
		ta.addMouseListener(this);
	}
	
	public void windowClosing(WindowEvent e) {
		f.dispose();
	}
	
	public void mouseEntered(MouseEvent e) {
		l2.setText("Mouse ENTERED the text area");
		l2.setForeground(Color.BLUE);
		ta.setBackground(Color.BLACK);
	}
	
	public void mouseClicked(MouseEvent e) {
		l2.setText("Mouse CLICKED the text area");
		l2.setForeground(Color.CYAN);
		ta.setBackground(Color.RED);
	}
	
	public void mousePressed(MouseEvent e) {
		l2.setText("Mouse PRESSED the text area");
		l2.setForeground(Color.GRAY);
		ta.setBackground(Color.ORANGE);
	}
	
	public void mouseExited(MouseEvent e) {
		l2.setText("Mouse EXITED the text area");
		l2.setForeground(Color.DARK_GRAY);
		ta.setBackground(Color.YELLOW);
	}
	
	public void mouseReleased(MouseEvent e) {
		l2.setText("Mouse RELEASED the text area");
		l2.setForeground(Color.GREEN);
		ta.setBackground(Color.MAGENTA);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MouseEventHandling obj = new MouseEventHandling();

	}

}
