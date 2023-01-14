package _03_Hangman;

import java.awt.Label;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {

	//public static void main(String[] args) {
		
	//}
		
		public void start() {
			JFrame frame = new JFrame();
			JPanel panel = new JPanel();
			JLabel label = new JLabel();
			JLabel label2 = new JLabel();
		frame.setVisible(true);
		String input = JOptionPane.showInputDialog("Enter a number");
		int val = Integer.parseInt(input);

		Stack<String> words = new Stack<String>();

		for (int i = 0; i < val; i++) {
			words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		}
		
		frame.setSize(500,500);

		frame.add(panel);
		frame.add(label);
		//frame.add(label2);
		
		String newW = words.pop();
		//System.out.println(newW);
		char[]output = new char[newW.length()];
		
		for (int x = 0; x < newW.length(); x++) {
			output[x] = '_';
		}
		
		String result = result(output);
		
		label.setText(result);
		//label2.setText(guesses+"");
		boolean over = false;
		char input1 = ' ';
		double guesses = 5;
		System.out.println(guesses);
		
		while (over == false) {
			input = JOptionPane.showInputDialog("Enter a letter");
			for(int y = 0; y<newW.length(); y++) {
				int times = newW.length();
				for(int i =0; i<newW.length(); i++) {
					if(output[i] == '_'){
						over = false;
					}
					else {
						times --;
						
					}
					if(times == 0) {
						over = true;
					}
				}
				
				
				if(input.equals(newW.charAt(y)+"")) {
					output[y] = newW.charAt(y);
					result = result(output);
					label.setText(result);
				}
				
				
			}
			result = result(output);
			if(result.contains(input)==false) {
				guesses--;
				System.out.println("false");
				System.out.println(guesses);
			}
			if(guesses == 0) {
				over = true;
				String contin = JOptionPane.showInputDialog("Continue? - y for yes and n for no");
				if(contin.equals("y")) {
					start();
				}
			}
		
		}
	}
	public String result(char[] output) {
		String result = "";
		for(int z = 0; z<output.length; z++) {
			result += output[z];
		}
		return result;
	}
}
