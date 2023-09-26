package resources;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import design.LoginPanel;

public class ThreadClear extends Thread{
	
	JTextField nameClean = LoginPanel.textField;
	
	public String name;
	
	public ThreadClear(String name) {
		this.name = name;
	}
	
	public void run() {
		try {
			nameClean.getText();
			LoginPanel.passwordField.getPassword();
			nameClean.setText("");
			LoginPanel.passwordField.setText("");
		}
		catch (Exception e) {
			e.fillInStackTrace();
			JOptionPane.showMessageDialog(null, nameClean);
		}
	}
}
