package rectangleGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RectangleGUI extends JFrame implements ActionListener{

	
	JTextField lengthTF, widthTF, areaTF, perimeterTF;
	public RectangleGUI(){
		//Labels
		JLabel lengthL = new JLabel("Enter the length:", SwingConstants.RIGHT);
		JLabel widththL = new JLabel("Enter the width:", SwingConstants.RIGHT);
		JLabel areaL = new JLabel("Area:", SwingConstants.RIGHT);
		JLabel perimeterL = new JLabel("Perimeter:", SwingConstants.RIGHT);
		
		//Text Fields
		lengthTF = new JTextField(10);
		widthTF = new JTextField(10);
		areaTF = new JTextField(10);
		perimeterTF = new JTextField(10);
		
		//Buttons
		//calculate
		JButton calculateB = new JButton("Calculate");
		//listener
		calculateB.addActionListener(this);
		//calculateB.addActionListener(this);
		
		//Exit
		JButton exitB = new JButton("Exit");
		exitB.addActionListener(this);
		
		//Set the title of the window
		setTitle("Area");
		
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(5,2,10,10));
		pane.add(lengthL);
		pane.add(lengthTF);
		pane.add(widththL);
		pane.add(widthTF);
		pane.add(areaL);
		pane.add(areaTF);
		pane.add(perimeterL);
		pane.add(perimeterTF);
		
		
		pane.add(calculateB);
		pane.add(exitB);
		
		//set the size of window and display it
		setSize(400, 300);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Calculate")) {
			
			Rectangle rectangle = new Rectangle(Double.parseDouble(widthTF.getText()),Double.parseDouble(lengthTF.getText()));
			areaTF.setText(""+rectangle.area());
			perimeterTF.setText(""+rectangle.perimeter());
		}
		else if(e.getActionCommand().equals("Exit")) {
			setVisible(false);
			dispose();
		}
	}
}
