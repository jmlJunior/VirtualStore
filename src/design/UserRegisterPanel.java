package design;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import application.UserRegistration;
import accessinterface.UserInterface;
import javax.swing.JSeparator;

public class UserRegisterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton enter, clear, out, consult, consultClear, remove;
	
	private JLabel title, subTitle;
	
	UserBackImage userRegistration;
	private JLabel position, nickName;
	public static JTextField insertName, insertId, insertPosition, insertNick, idConsult, nameFunction;
	public static JPasswordField passwordField, passwordFieldConfirm;
	private JSeparator separator_1;
	
	/**
	 * Create the panel.
	 */
	public UserRegisterPanel() {
		
		title = new JLabel("VIRTUAL STORE");
		title.setFont(new Font("Bodoni MT Black", Font.BOLD, 100));
		title.setForeground(new Color(153, 0, 51));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(0, 0, 1250, 118);
		
		userRegistration = new UserBackImage();
		userRegistration.setLayout(null);
		userRegistration.add(title);
		
		subTitle = new JLabel("CADASTRO DE USU�RIOS:");
		subTitle.setForeground(new Color(153, 0, 51));
		subTitle.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 50));
		subTitle.setBounds(117, 151, 786, 41);
		userRegistration.add(subTitle);
		/**
		 * 
		**/
			
		JLabel name = new JLabel("Nome:");
		name.setForeground(new Color(153, 0, 51));
		name.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		name.setBounds(117, 233, 213, 40);
		userRegistration.add(name);
		
		insertName = new JTextField();
		insertName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insertName.setBounds(117, 271, 461, 34);
		userRegistration.add(insertName);
		
		JLabel idNumber = new JLabel("N\u00BA de Cadastro:");
		idNumber.setForeground(new Color(153, 0, 51));
		idNumber.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		idNumber.setBounds(924, 233, 220, 40);
		userRegistration.add(idNumber);
		
		insertId = new JTextField();
		insertId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insertId.setBounds(924, 271, 220, 34);
		userRegistration.add(insertId);
		
		position = new JLabel("Cargo:");
		position.setForeground(new Color(153, 0, 51));
		position.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		position.setBounds(117, 328, 213, 40);
		userRegistration.add(position);
		
		insertPosition = new JTextField();
		insertPosition.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insertPosition.setBounds(117, 372, 338, 34);
		userRegistration.add(insertPosition);
		
		nickName = new JLabel("Nome de Guerra:");
		nickName.setForeground(new Color(153, 0, 51));
		nickName.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		nickName.setBounds(640, 227, 220, 40);
		userRegistration.add(nickName);
		
		insertNick = new JTextField();
		insertNick.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insertNick.setBounds(640, 271, 220, 34);
		userRegistration.add(insertNick);
		
		JLabel passwordLabel = new JLabel("SENHA:");
		passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLabel.setForeground(new Color(153, 0, 51));
		passwordLabel.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		passwordLabel.setBounds(640, 331, 220, 41);
		userRegistration.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(640, 372, 220, 34);
		userRegistration.add(passwordField);
		
		JLabel passwordConfirm = new JLabel("Confirmar SENHA:");
		passwordConfirm.setHorizontalAlignment(SwingConstants.LEFT);
		passwordConfirm.setForeground(new Color(153, 0, 51));
		passwordConfirm.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		passwordConfirm.setBounds(924, 328, 220, 41);
		userRegistration.add(passwordConfirm);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldConfirm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordFieldConfirm.setBounds(924, 369, 220, 34);
		userRegistration.add(passwordFieldConfirm);
		
		enter = new JButton("CADASTRAR");
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserRegistration.Register();
			}
		});
		enter.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		enter.setBounds(994, 466, 150, 41);
		userRegistration.add(enter);
		
		clear = new JButton("LIMPAR");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertName.setText("");
				insertId.setText("");
				insertPosition.setText("");
				insertNick.setText("");
				passwordField.setText("");
				passwordFieldConfirm.setText("");
			}
		});
		clear.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		clear.setBounds(994, 414, 150, 41);
		userRegistration.add(clear);
		
		out = new JButton("SAIR");
		out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInterface.InitialScreen();
				LoginPanel.textField.setText("");
				LoginPanel.passwordField.setText("");
			}
		});
		out.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		out.setBounds(994, 784, 150, 41);
		userRegistration.add(out);
		
		consult = new JButton("CONSULTAR");
		consult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserRegistration.consultUser();				
			}
		});
		consult.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		consult.setBounds(381, 784, 145, 41);
		userRegistration.add(consult);
		
		consultClear = new JButton("LIMPAR");
		consultClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameFunction.setText("");
				idConsult.setText("");				
			}
		});
		consultClear.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		consultClear.setBounds(547, 784, 145, 41);
		userRegistration.add(consultClear);
		
		remove = new JButton("EXCLUIR");
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserRegistration.deleteUser();
				nameFunction.setText("");
				idConsult.setText("");				
			}
		});
		remove.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		remove.setBounds(715, 784, 145, 41);
		userRegistration.add(remove);
		
		JLabel lblConsultarRemover = new JLabel("CONSULTAR / REMOVER USU\u00C1RIOS:");
		lblConsultarRemover.setForeground(new Color(153, 0, 51));
		lblConsultarRemover.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 50));
		lblConsultarRemover.setBounds(117, 580, 786, 41);
		userRegistration.add(lblConsultarRemover);
		
		JLabel idCheck = new JLabel("N\u00BA de Cadastro:");
		idCheck.setForeground(new Color(153, 0, 51));
		idCheck.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		idCheck.setBounds(117, 658, 220, 40);
		userRegistration.add(idCheck);
		
		idConsult = new JTextField();
		idConsult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idConsult.setBounds(117, 699, 220, 34);
		userRegistration.add(idConsult);
		
		nameFunction = new JTextField();
		nameFunction.setHorizontalAlignment(SwingConstants.CENTER);
		nameFunction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameFunction.setBounds(381, 699, 479, 76);
		userRegistration.add(nameFunction);
		
		JLabel nfCheck = new JLabel("Nome / Cargo:");
		nfCheck.setForeground(new Color(153, 0, 51));
		nfCheck.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		nfCheck.setBounds(381, 658, 213, 40);
		userRegistration.add(nfCheck);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(153, 0, 51));
		separator.setBackground(new Color(153, 0, 51));
		separator.setBounds(117, 550, 1027, 15);
		userRegistration.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(new Color(153, 0, 51));
		separator_1.setBackground(new Color(153, 0, 51));
		separator_1.setBounds(117, 547, 1027, 15);
		userRegistration.add(separator_1);
	}

	public UserBackImage getUserRegistration() {
		return userRegistration;
	}

	public void setUserRegistration(UserBackImage userRegistration) {
		this.userRegistration = userRegistration;
	}
}