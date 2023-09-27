package design;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import application.ClientRegister;

import javax.swing.JButton;
//import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ClientRegisterPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	UserBackImage clientRegister;
	
	private JLabel name, title, subTitle, document, 
	               clienteCode, position, houseNumber, 
	               complement, phone, eMail;
	
	public static JTextField insertName, insertDocNumber, insertClientCode, 
	                         insertPosition, insertNumber, insertCoplement,
	                         insertPhoneNumber, mail;
	
	public static JTable table;
	public static JScrollPane scroll;
	
	public ClientRegisterPanel() {

		title = new JLabel("VIRTUAL STORE");
		title.setFont(new Font("Bodoni MT Black", Font.BOLD, 100));
		title.setForeground(new Color(153, 0, 51));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(0, 0, 1250, 118);
		
		clientRegister = new UserBackImage();
		clientRegister.setLayout(null);
		clientRegister.add(title);
		
		subTitle = new JLabel("CADASTRO DE CLIENTES:");
		subTitle.setForeground(new Color(153, 0, 51));
		subTitle.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 50));
		subTitle.setBounds(117, 151, 786, 41);
		clientRegister.add(subTitle);
		
		name = new JLabel("Nome:");
		name.setForeground(new Color(153, 0, 51));
		name.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		name.setBounds(676, 233, 213, 40);
		clientRegister.add(name);
		
		insertName = new JTextField();
		insertName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insertName.setBounds(676, 275, 461, 34);
		clientRegister.add(insertName);
		
		document = new JLabel("Documento / RG:");
		document.setForeground(new Color(153, 0, 51));
		document.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		document.setBounds(396, 227, 220, 40);
		clientRegister.add(document);
		
		insertDocNumber = new JTextField();
		insertDocNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insertDocNumber.setBounds(396, 275, 220, 34);
		clientRegister.add(insertDocNumber);
		
		clienteCode = new JLabel("Código do Cliente:");
		clienteCode.setForeground(new Color(153, 0, 51));
		clienteCode.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		clienteCode.setBounds(117, 233, 220, 40);
		clientRegister.add(clienteCode);
		
		insertClientCode = new JTextField();
		insertClientCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insertClientCode.setBounds(117, 275, 220, 34);
		clientRegister.add(insertClientCode);
		
		position = new JLabel("Endere\u00E7o (Rua/P\u00E7/Av:)");
		position.setForeground(new Color(153, 0, 51));
		position.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		position.setBounds(117, 328, 461, 40);
		clientRegister.add(position);
		
		insertPosition = new JTextField();
		insertPosition.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insertPosition.setBounds(117, 372, 743, 34);
		clientRegister.add(insertPosition);
		
		houseNumber = new JLabel("Número:");
		houseNumber.setForeground(new Color(153, 0, 51));
		houseNumber.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		houseNumber.setBounds(917, 328, 220, 41);
		clientRegister.add(houseNumber);
		
		insertNumber = new JTextField();
		insertNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insertNumber.setBounds(917, 372, 220, 34);
		clientRegister.add(insertNumber);
		
		complement = new JLabel("Complemento:");
		complement.setForeground(new Color(153, 0, 51));
		complement.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		complement.setBounds(117, 429, 461, 40);
		clientRegister.add(complement);
		
		insertCoplement = new JTextField();
		insertCoplement.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insertCoplement.setBounds(117, 473, 743, 34);
		clientRegister.add(insertCoplement);
		
		phone = new JLabel("Telefone c/ DDD:");
		phone.setForeground(new Color(153, 0, 51));
		phone.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		phone.setBounds(917, 429, 220, 41);
		clientRegister.add(phone);
		
		insertPhoneNumber = new JTextField();
		insertPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insertPhoneNumber.setBounds(917, 473, 220, 34);
		clientRegister.add(insertPhoneNumber);
		
		JButton enter = new JButton("CADASTRAR");
		enter.setForeground(new Color(0, 100, 0));
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientRegister.Register();
				
				ClientRegister.insertClientCode.setText("");
				ClientRegister.insertDocNumber.setText("");
				ClientRegister.insertName.setText("");
				ClientRegister.insertPosition.setText("");
				ClientRegister.insertNumber.setText("");
				ClientRegister.insertCoplement.setText("");
				ClientRegister.insertPhoneNumber.setText("");
				ClientRegister.mail.setText("");
			}
		});
		enter.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		enter.setBounds(690, 577, 150, 41);
		clientRegister.add(enter);
		
		JButton clear = new JButton("LIMPAR");
		clear.setForeground(new Color(204, 102, 0));
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		clear.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		clear.setBounds(859, 577, 122, 41);
		clientRegister.add(clear);
		
		JButton out = new JButton("SAIR");
		out.setForeground(new Color(174, 34, 34));
		out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		out.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		out.setBounds(1015, 802, 122, 41);
		clientRegister.add(out);
		
		eMail = new JLabel("E-mail:");
		eMail.setForeground(new Color(153, 0, 51));
		eMail.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		eMail.setBounds(117, 533, 213, 40);
		clientRegister.add(eMail);
		
		mail = new JTextField();
		mail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mail.setBounds(117, 575, 499, 34);
		clientRegister.add(mail);
		
		JButton search = new JButton("PESQUISAR");
		search.setForeground(new Color(0, 100, 0));
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientRegister.Search();
			}
		});
		search.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		search.setBounds(987, 227, 150, 41);
		clientRegister.add(search);
		
        table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Código", "Nome", "Documento", "Endereço", "Telefone"
			}
		));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(300);			
		
		scroll = new JScrollPane();
		scroll.setBounds(117, 638, 864, 205);
		clientRegister.add(scroll);
		scroll.add(table);
		scroll.setViewportView(table);

	}
	
	
	public UserBackImage getClientRegister() {
		return clientRegister;
	}
	
	public void setClientRegister(UserBackImage clientRegister) {
		this.clientRegister = clientRegister;
	}
}
