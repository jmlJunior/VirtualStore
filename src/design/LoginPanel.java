package design;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import application.UserLogin;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton enter, clear, out;
	
	private JLabel title, subTitle, nameLabel, passwordLabel;
	public static JTextField textField;
	public static JPasswordField passwordField;
	//public static JFrame UserInterface;
	
	LoginBackImage userPage;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		
		title = new JLabel("VIRTUAL STORE");
		title.setFont(new Font("Bodoni MT Black", Font.BOLD, 100));
		title.setForeground(new Color(153, 0, 51));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(0, 0, 1250, 118);
		
		userPage = new LoginBackImage();
		userPage.setLayout(null);
		userPage.add(title);
		
		subTitle = new JLabel("LOGIN DE USU\u00C1RIO:");
		subTitle.setForeground(new Color(153, 0, 51));
		subTitle.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 50));
		subTitle.setBounds(178, 150, 316, 41);
		userPage.add(subTitle);
		
		nameLabel = new JLabel("Login:");
		nameLabel.setForeground(new Color(153, 0, 51));
		nameLabel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setBounds(723, 424, 95, 41);
		userPage.add(nameLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(723, 466, 461, 34);
		userPage.add(textField);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLabel.setForeground(new Color(153, 0, 51));
		passwordLabel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
		passwordLabel.setBounds(723, 577, 221, 41);
		userPage.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(723, 618, 461, 34);
		userPage.add(passwordField);
		
		enter = new JButton("ENTRAR");
		enter.setForeground(new Color(0, 100, 0));
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogin.GetAccess();
				textField.setText("");
				passwordField.setText("");
			}
		});
		enter.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		enter.setBounds(1062, 749, 122, 41);
		userPage.add(enter);
		
		clear = new JButton("LIMPAR");
		clear.setForeground(new Color(204, 102, 0));
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
			}
		});
		clear.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		clear.setBounds(930, 749, 122, 41);
		userPage.add(clear);
		
		out = new JButton("FECHAR");
		out.setForeground(new Color(178, 34, 34));
		out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		out.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		out.setBounds(798, 749, 122, 41);
		userPage.add(out);
		
	}

	public LoginBackImage getUserPage() {
		return userPage;
	}

	public void setUserPage(LoginBackImage userPage) {
		this.userPage = userPage;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		LoginPanel.textField = textField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		LoginPanel.passwordField = passwordField;
	}
}
