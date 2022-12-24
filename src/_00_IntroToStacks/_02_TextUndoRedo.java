package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class _02_TextUndoRedo implements KeyListener {
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	
	Stack<Character>values = new Stack<Character>();
	Stack<Character>redo = new Stack<Character>();
	
	public void run() {
	
	frame.setVisible(true);
	frame.add(panel);
	panel.add(label);
	
	frame.pack();
	frame.setVisible(true);
	
	frame.addKeyListener(this);
	frame.setSize(300,300);
	
}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
}
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		String val = "";
		char KeyChar = e.getKeyChar();
		
		System.out.println(e.getKeyCode());
		if(e.getKeyCode() != 8 && e.getKeyCode() != 10) {
			
			label.setText(label.getText()+KeyChar);
			values.push(e.getKeyChar());
		
	}
		if(e.getKeyCode() == 8 && values.isEmpty() == false) {
			label.setText(label.getText().substring(0, label.getText().length()-1));
			char recent = values.pop();
			redo.push(recent);
		}
		if(e.getKeyCode() == 10 && redo.isEmpty() == false) {
			char new1 = redo.pop();
			label.setText(label.getText() + new1);
			
			values.push(new1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
