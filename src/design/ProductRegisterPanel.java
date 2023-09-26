package design;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import accessinterface.UserInterface;

import javax.swing.JTextField;

import application.ProductRegistration;

public class ProductRegisterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton enter, clear, out;
	
	private JLabel title, subTitle;
	
	StockBackImage productRegistration;
	private JLabel idNumber, name, lblDescr, lblQtdeEstoque, lblPreoDaUnidade;
	public static JTextField insertProdCod, insertProdName, insertQtde, insertPrice;
	public static JTextArea insertProdDesc;
	
	/**
	 * Create the panel.
	 */
	public ProductRegisterPanel() {
		
		title = new JLabel("VIRTUAL STORE");
		title.setFont(new Font("Bodoni MT Black", Font.BOLD, 100));
		title.setForeground(new Color(153, 0, 51));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(0, 0, 1250, 118);
		
		productRegistration = new StockBackImage();
		productRegistration.setLayout(null);
		productRegistration.add(title);
		
		subTitle = new JLabel("CADASTRO DE PRODUTOS:");
		subTitle.setForeground(new Color(153, 0, 51));
		subTitle.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 50));
		subTitle.setBounds(178, 150, 786, 41);
		productRegistration.add(subTitle);
		
		idNumber = new JLabel("C\u00F3digo do Produto:");
		idNumber.setForeground(new Color(153, 0, 51));
		idNumber.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		idNumber.setBounds(178, 242, 234, 40);
		productRegistration.add(idNumber);
		
		insertProdCod = new JTextField();
		insertProdCod.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insertProdCod.setBounds(178, 290, 230, 34);
		productRegistration.add(insertProdCod);
		
		name = new JLabel("Nome:");
		name.setForeground(new Color(153, 0, 51));
		name.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		name.setBounds(178, 376, 213, 40);
		productRegistration.add(name);
		
		insertProdName = new JTextField();
		insertProdName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insertProdName.setBounds(178, 420, 461, 34);
		productRegistration.add(insertProdName);
		
		lblDescr = new JLabel("Descri\u00E7\u00E3o:");
		lblDescr.setForeground(new Color(153, 0, 51));
		lblDescr.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		lblDescr.setBounds(178, 477, 213, 40);
		productRegistration.add(lblDescr);
		
		insertProdDesc = new JTextArea();
		insertProdDesc.setLineWrap(true);
		insertProdDesc.setWrapStyleWord(true);
		insertProdDesc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insertProdDesc.setBounds(178, 521, 959, 100);
		productRegistration.add(insertProdDesc);
		
		lblQtdeEstoque = new JLabel("Qtde Estoque:");
		lblQtdeEstoque.setForeground(new Color(153, 0, 51));
		lblQtdeEstoque.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		lblQtdeEstoque.setBounds(178, 654, 213, 40);
		productRegistration.add(lblQtdeEstoque);
		
		insertQtde = new JTextField();
		insertQtde.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insertQtde.setBounds(178, 698, 162, 34);
		productRegistration.add(insertQtde);
		
		lblPreoDaUnidade = new JLabel("Pre\u00E7o da Unidade:");
		lblPreoDaUnidade.setForeground(new Color(153, 0, 51));
		lblPreoDaUnidade.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		lblPreoDaUnidade.setBounds(419, 654, 220, 40);
		productRegistration.add(lblPreoDaUnidade);
		
		insertPrice = new JTextField();
		insertPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insertPrice.setBounds(419, 698, 215, 34);
		productRegistration.add(insertPrice);
		
		enter = new JButton("CADASTRAR");
		enter.setForeground(new Color(0, 100, 0));
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductRegistration.Register();
			}
		});
		enter.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		enter.setBounds(178, 802, 150, 41);
		productRegistration.add(enter);
		
		clear = new JButton("LIMPAR");
		clear.setForeground(new Color(204, 102, 0));
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertProdCod.setText("");
				insertProdName.setText("");
				insertProdDesc.setText("");
				insertQtde.setText("");
				insertPrice.setText("");
			}
		});
		clear.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		clear.setBounds(346, 802, 122, 41);
		productRegistration.add(clear);
		
		out = new JButton("SAIR");
		out.setForeground(new Color(178, 34, 34));
		out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInterface.InitialScreen();
				LoginPanel.textField.setText("");
				LoginPanel.passwordField.setText("");
			}
		});
		out.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		out.setBounds(1015, 802, 122, 41);
		productRegistration.add(out);
	}

	public StockBackImage getProductRegistration() {
		return productRegistration;
	}

	public void setProductRegistration(StockBackImage productRegistration) {
		this.productRegistration = productRegistration;
	}
}
