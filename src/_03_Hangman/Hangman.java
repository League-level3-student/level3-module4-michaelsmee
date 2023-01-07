package _03_Hangman;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {

	String input = JOptionPane.showInputDialog("Enter a number");
	int val = Integer.parseInt(input);
	
	Stack<String>Words = new Stack<String>();
	
	for(int i = 0; i<val; i++) {
		Words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
	}
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	
	
	frame.add(panel);
	frame.add(label);
	for(int i = 0; i<)
}
}
