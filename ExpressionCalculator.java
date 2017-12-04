//package problem_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
* This class creates the GUI frame and interface for the calculator.
*
* @author Alexander Wong
* @version 1.0
**/


public class ExpressionCalculator extends JFrame implements ActionListener {


	private JTextField screen_output;
	
	/**
	* This is a constructor method that instantiates an Expression calculator object using
	* swing. Creates the gui of the calculator.
	*/
	public ExpressionCalculator() 
	{
		setTitle("Expression Calculator");
		addWindowListener(new WindowDestroyer());
		setSize(350,275);
		Container content = getContentPane();
		content.setLayout(new BorderLayout());
		
		JPanel screenPanel = new JPanel();
		screenPanel.setLayout(new FlowLayout());
		
		screen_output = new JTextField(18);
	
		screen_output.setEditable(false);
		Font text_size = new Font("Arial",Font.BOLD,20);
		screen_output.setFont(text_size);
		screenPanel.add(screen_output);
		content.add(screenPanel, BorderLayout.NORTH);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		JButton zero = new JButton("0");
		zero.addActionListener(this);
		JButton one = new JButton("1");
		one.addActionListener(this);
		JButton two = new JButton("2");
		two.addActionListener(this);
		JButton three = new JButton("3");
		three.addActionListener(this);
		JButton four = new JButton("4");
		four.addActionListener(this);
		JButton five = new JButton("5");
		five.addActionListener(this);
		JButton six = new JButton("6");
		six.addActionListener(this);
		JButton seven = new JButton("7");
		seven.addActionListener(this);
		JButton eight = new JButton("8");
		eight.addActionListener(this);
		JButton nine = new JButton("9");
		nine.addActionListener(this);
		JButton dot = new JButton(".");
		dot.addActionListener(this);
		JButton addition = new JButton("+");
		addition.addActionListener(this);
		JButton subtract = new JButton("-");
		subtract.addActionListener(this);
		JButton multiply = new JButton("x");
		multiply.addActionListener(this);
		JButton divide = new JButton("/");
		divide.addActionListener(this);
		JButton clear = new JButton("Clear");
		clear.addActionListener(this);
		JButton right_p = new JButton(")");
		right_p.addActionListener(this);
		JButton left_p = new JButton("(");
		left_p.addActionListener(this);
		JButton negative = new JButton("(-)");
		negative.addActionListener(this);
		JButton equal = new JButton("=");
		equal.addActionListener(this);
		JButton backspace = new JButton("<--");
		backspace.addActionListener(this);
		
		screen_output.setHorizontalAlignment(SwingConstants.RIGHT);
		
		buttonPanel.add(backspace);
		buttonPanel.add(negative);
		buttonPanel.add(left_p);
		buttonPanel.add(right_p);
		buttonPanel.add(seven);
		buttonPanel.add(eight);
		buttonPanel.add(nine);
		buttonPanel.add(multiply);
		buttonPanel.add(four);
		buttonPanel.add(five);
		buttonPanel.add(six);
		buttonPanel.add(subtract);
		buttonPanel.add(one);
		buttonPanel.add(two);
		buttonPanel.add(three);
		buttonPanel.add(addition);
		buttonPanel.add(zero);
		buttonPanel.add(dot);
	
		buttonPanel.add(equal);
		buttonPanel.add(divide);
		content.add(buttonPanel, BorderLayout.CENTER);
		
		JPanel clearPanel = new JPanel();
		clearPanel.setLayout(new FlowLayout());
		Dimension d = new Dimension(200,30);
		clear.setPreferredSize(d);
		clearPanel.add(clear);
		content.add(clearPanel, BorderLayout.SOUTH);
		
	}

	/**
	* This method performs the actions that sets the text in the text window of the calculator.
	* 
	* @param ActionEvents from components inititated in the constructor.
	*/
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("0")) {
			screen_output.setText(screen_output.getText()+Integer.toString(0));
		}
		else if(e.getActionCommand().equals("1")) {
			screen_output.setText(screen_output.getText()+Integer.toString(1));
		}
		else if(e.getActionCommand().equals("2")) {
			screen_output.setText(screen_output.getText()+Integer.toString(2));
		}
		else if(e.getActionCommand().equals("3")) {
			screen_output.setText(screen_output.getText()+Integer.toString(3));
		}
		else if(e.getActionCommand().equals("4")) {
			screen_output.setText(screen_output.getText()+Integer.toString(4));
		}
		else if(e.getActionCommand().equals("5")) {
			screen_output.setText(screen_output.getText()+Integer.toString(5));
		}
		else if(e.getActionCommand().equals("6")) {
			screen_output.setText(screen_output.getText()+Integer.toString(6));
		}
		else if(e.getActionCommand().equals("7")) {
			screen_output.setText(screen_output.getText()+Integer.toString(7));
		}
		else if(e.getActionCommand().equals("8")) {
			screen_output.setText(screen_output.getText()+Integer.toString(8));
		}
		else if(e.getActionCommand().equals("9")) {
			screen_output.setText(screen_output.getText()+Integer.toString(9));
		}
		else if(e.getActionCommand().equals("Clear")) {
			screen_output.setText("");
		}
		else if(e.getActionCommand().equals(".")) {
			screen_output.setText(screen_output.getText()+".");
		}
		else if(e.getActionCommand().equals("+")) {
			screen_output.setText(screen_output.getText()+"+");
		}
		else if(e.getActionCommand().equals("-")) {
			screen_output.setText(screen_output.getText()+"-");
		}
		else if(e.getActionCommand().equals("/")) {
			screen_output.setText(screen_output.getText()+"/");
		}
		else if(e.getActionCommand().equals("x")) {
			screen_output.setText(screen_output.getText()+"*");
		}
		else if(e.getActionCommand().equals("(-)")) {
			screen_output.setText(screen_output.getText()+"-");
		}
		else if(e.getActionCommand().equals("(")) {
			screen_output.setText(screen_output.getText()+"(");
		}
		else if(e.getActionCommand().equals(")")) {
			screen_output.setText(screen_output.getText()+")");
		}
		else if(e.getActionCommand().equals("<--")) {
			int length = screen_output.getText().length();
			int new_length = length - 1;
			
			if(length>0) 
			{
				String new_text = "";
				for(int i = 0; i < new_length; i++) {
					new_text = new_text + screen_output.getText().charAt(i);
				}
				screen_output.setText(new_text);
			}
			
		}
		else if(e.getActionCommand().equals("=")) 
		{
			String answer = screen_output.getText();
			answer = answer.replaceAll("\\s+","");
			ExpressionSolver expression = new ExpressionSolver(answer);
			try {
				double solution = expression.paranthesis();
				screen_output.setText(Double.toString(solution));
			}catch(Exception a) {
				screen_output.setText(a.getMessage());
			}
	
			
		}
		else
			screen_output.setText("Error in code.");
	}
}
