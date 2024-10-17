package clientGraphicHelloREST;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.function.Consumer;


import javax.swing.*;



public class HelloRESTGUI extends JFrame implements ActionListener {

	JTextField  userNameTF,empIdTF, empNameTF, empSalaryTF;
	JEditorPane hihiJSONEP, hihiHTMLEP, hihiTextEP, hihiSpicifyUserEP, hihiEmployeeEP;

	public HelloRESTGUI() {
		
		JLabel userNameL = new JLabel("Enter UserName:", SwingConstants.CENTER);
		JLabel empIdL = new JLabel("Param EmpID:", SwingConstants.CENTER);
		JLabel empNameL = new JLabel("Param EmpName:", SwingConstants.CENTER);
		JLabel empSlaryL = new JLabel("Param EmpSalary:", SwingConstants.CENTER);
		
		
		userNameTF = new JTextField();
		empIdTF = new JTextField();
		empNameTF = new JTextField();
		empSalaryTF = new JTextField();
		
		hihiJSONEP = new JEditorPane();
		hihiHTMLEP = new JEditorPane();
		hihiTextEP = new JEditorPane();
		hihiSpicifyUserEP = new JEditorPane();
		hihiEmployeeEP = new JEditorPane();

		
		JButton hihiJSONB = new JButton("HiHi JSON");
		hihiJSONB.addActionListener(this);
		
		JButton hihiHTMLB = new JButton("HiHi HTML");
		hihiHTMLB.addActionListener(this);
		
		JButton hihiTextB = new JButton("HiHi Text");
		hihiTextB.addActionListener(this);
		
		JButton hihiSpecifyUserB = new JButton("Path User");
		hihiSpecifyUserB.addActionListener(this);
		
		JButton hihiEmployeeB = new JButton("HiHi Employee");
		hihiEmployeeB.addActionListener(this);
		
		setTitle("Graphic-based Hello REST App");
		setSize(400, 300);
		setVisible(true);
		
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(9,2,10,10));
		
		pane.add(hihiJSONB);
		pane.add(hihiJSONEP);
		
		pane.add(hihiHTMLB);
		pane.add(hihiHTMLEP);
		
		pane.add(hihiTextB);
		pane.add(hihiTextEP);
		
		pane.add(userNameL);
		pane.add(userNameTF);
		
		pane.add(hihiSpecifyUserB);
		pane.add(hihiSpicifyUserEP);
		
		pane.add(empIdL);
		pane.add(empIdTF);
		
		pane.add(empNameL);
		pane.add(empNameTF);
		
		pane.add(empSlaryL);
		pane.add(empSalaryTF);
		
		pane.add(hihiEmployeeB);
		pane.add(hihiEmployeeEP);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		HashMap <String, Consumer<Request>> buttonsMap = new HashMap<>();
		buttonsMap.put("HiHi JSON", request -> {hihiJSONEP.setContentType("application/json");
												hihiJSONEP.setText(request.hihiJSONResponse());});
		
		buttonsMap.put("HiHi HTML", request -> {hihiHTMLEP.setContentType("text/html");
												hihiHTMLEP.setText(request.hihiHTMLResponse());});
		
		buttonsMap.put("HiHi Text", request -> {hihiTextEP.setContentType("text/plain");
												hihiTextEP.setText(request.hihiTextResponse());});
		
		buttonsMap.put("Path User", request -> {if (!userNameTF.getText().isEmpty()) {
												hihiSpicifyUserEP.setContentType("text/html");
												hihiSpicifyUserEP.setText(request.hihiSpicifyUserResponse(userNameTF.getText()));}
												else {
													JOptionPane.showMessageDialog(null, "Please enter user name", "Error", JOptionPane.ERROR_MESSAGE);
												}});			
		
		buttonsMap.put("HiHi Employee", request -> {if (!(empIdTF.getText().isEmpty() || empNameTF.getText().isEmpty() || empSalaryTF.getText().isEmpty())) {
													hihiEmployeeEP.setContentType("text/html");
													hihiEmployeeEP.setText(request.hihiEmployeeResponse(empIdTF.getText(), empNameTF.getText(), Double.parseDouble(empSalaryTF.getText())));}
													else {
														JOptionPane.showMessageDialog(null, "Please enter employee ID, name and salary", "Error", JOptionPane.ERROR_MESSAGE);
													}});	
		
		buttonsMap.get(e.getActionCommand()).accept(new Request());;
	}

}
