package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Calculator implements ActionListener {

	JFrame frame;
	JTextField textfield;
	JButton[] numberButton = new JButton[10];
	JButton[] functionButton = new JButton[9];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton,delButton,equButton,clrButton,negButton;
	JPanel panel;
	
	Font myFont= new Font("Ink Free",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	char operation;
	
	Calculator(){
		frame =new JFrame("calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		
		textfield =new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");
		
		functionButton[0] = addButton;
		functionButton[1] = subButton;
		functionButton[2] = mulButton;
		functionButton[3] = divButton;
		functionButton[4] = decButton;
		functionButton[5] = equButton;
		functionButton[6] = delButton;
		functionButton[7] = clrButton;
		functionButton[8] = negButton;
		
		for(int i=0;i<9;i++)
		{
			functionButton[i].addActionListener(this);
			functionButton[i].setFont(myFont);
			functionButton[i].setFocusable(false);
			
		}
		
		for(int i=0;i<10;i++)
		{
			numberButton[i] =new JButton(String.valueOf(i));
			numberButton[i].addActionListener(this);
			numberButton[i].setFont(myFont);
			numberButton[i].setFocusable(false);
			
		}
		
		negButton.setBounds(50,430,100,50);
		delButton.setBounds(150,430,100,50);
		clrButton.setBounds(250,430,100,50);
		
		panel =new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(Color.GRAY);
		
		panel.add(numberButton[1]);
		panel.add(numberButton[2]);
		panel.add(numberButton[3]);
		panel.add(addButton);
		panel.add(numberButton[4]);
		panel.add(numberButton[5]);
		panel.add(numberButton[6]);
		panel.add(subButton);
		panel.add(numberButton[7]);
		panel.add(numberButton[8]);
		panel.add(numberButton[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButton[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		
		
		frame.add(negButton);
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Calculator calc= new Calculator();
		
	}
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButton[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operation ='+';
			textfield.setText("");
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operation ='-';
			textfield.setText("");
		}
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operation ='*';
			textfield.setText("");
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operation ='/';
			textfield.setText("");
		}
		if(e.getSource() == equButton) {
			num2 = Double.parseDouble(textfield.getText());
			
			switch(operation) {
			case'+':
				result =num1+num2;
				break;
			case'-':
				result =num1-num2;
				break;
			case'*':
				result =num1*num2;
				break;
			case'/':
				result =num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource() == clrButton) {
			textfield.setText("");
		}
		if(e.getSource() == delButton) {
			String string =textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource() == negButton) {
			
			 double temp = Double.parseDouble(textfield.getText());
			 temp*=-1;
			 textfield.setText(String.valueOf(temp));
			 
		}
		
	}
}
