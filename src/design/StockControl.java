package design;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import accessinterface.UserInterface;
import application.ProductUpdate;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;

public class StockControl extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton enter, clear, out;
	
	private JLabel title, subTitle;
	
	StockBackImage control;
	public static JTextField productCode, productName, productPrice, stockQty, actProdName, actProdPrice, actQtty;
	public static JCheckBox checkNameAct, checkPriceAct,checkStockAct,checkDescAct;
	public static JTextArea productDesc, changeProdDesc;

	/**
	 * Create the panel.
	 */
	public StockControl() {
		
		title = new JLabel("VIRTUAL STORE");
		title.setFont(new Font("Bodoni MT Black", Font.BOLD, 100));
		title.setForeground(new Color(153, 0, 51));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(0, 0, 1250, 118);
		
		control = new StockBackImage();
		control.setLayout(null);
		control.add(title);
		
		subTitle = new JLabel("CONSULTAR ESTOQUE:");
		subTitle.setForeground(new Color(153, 0, 51));
		subTitle.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 50));
		subTitle.setBounds(178, 150, 407, 41);
		control.add(subTitle);
		/**
		 * 
		**/
		
		enter = new JButton("PESQUISAR");
		enter.setForeground(new Color(0, 100, 0));
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductUpdate.checkProduct();
			}
		});
		enter.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		enter.setBounds(435, 253, 150, 41);
		control.add(enter);
		
		clear = new JButton("LIMPAR");
		clear.setForeground(new Color(204, 102, 0));
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productCode.setText("");
				productName.setText("");
				productPrice.setText("");
				stockQty.setText("");
				productDesc.setText("");
			}
		});
		clear.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		clear.setBounds(609, 253, 122, 41);
		control.add(clear);
		
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
		control.add(out);
		
		JLabel idNumber = new JLabel("C\u00F3digo do Produto:");
		idNumber.setForeground(new Color(153, 0, 51));
		idNumber.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		idNumber.setBounds(178, 212, 234, 40);
		control.add(idNumber);
		
		productCode = new JTextField();
		productCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		productCode.setBounds(178, 260, 230, 34);
		control.add(productCode);
		
		JLabel name = new JLabel("Nome:");
		name.setForeground(new Color(153, 0, 51));
		name.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		name.setBounds(178, 308, 213, 40);
		control.add(name);
		
		productName = new JTextField();
		productName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		productName.setBounds(178, 352, 407, 34);
		control.add(productName);
		
		productDesc = new JTextArea();
		productDesc.setWrapStyleWord(true);
		productDesc.setLineWrap(true);
		productDesc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		productDesc.setBounds(609, 352, 528, 123);
		control.add(productDesc);
		
		JLabel lblDescr = new JLabel("Descri\u00E7\u00E3o:");
		lblDescr.setForeground(new Color(153, 0, 51));
		lblDescr.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		lblDescr.setBounds(609, 308, 528, 40);
		control.add(lblDescr);
		
		JLabel lblEstoque = new JLabel("Estoque:");
		lblEstoque.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstoque.setForeground(new Color(153, 0, 51));
		lblEstoque.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		lblEstoque.setBounds(478, 397, 107, 40);
		control.add(lblEstoque);
		
		stockQty = new JTextField();
		stockQty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		stockQty.setBounds(489, 441, 96, 34);
		control.add(stockQty);
		
		JLabel lblPreoDaUnidade = new JLabel("Pre\u00E7o da Unidade:");
		lblPreoDaUnidade.setForeground(new Color(153, 0, 51));
		lblPreoDaUnidade.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		lblPreoDaUnidade.setBounds(178, 397, 220, 40);
		control.add(lblPreoDaUnidade);
		
		productPrice = new JTextField();
		productPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		productPrice.setBounds(178, 441, 215, 34);
		control.add(productPrice);
		
		JButton delet = new JButton("EXCLUIR");
		delet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object[] options = { "OK", "CANCELAR" };				
				var selection = JOptionPane.showOptionDialog(null,"Tem certeza que dezeja EXCLUIR o Catasdro deste Produto?",
						                                          "ATENÇÃO!!!", 
						                                          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						                                          null, 
						                                          options, 
						                                          options[0]);
				
				if (selection == 0) {		
					ProductUpdate.productDel();
					productCode.setText("");
					productName.setText("");
					productPrice.setText("");
					stockQty.setText("");
					productDesc.setText("");
					
					JOptionPane.showMessageDialog(null, "Produto EXCUÍDO com SUSSEÇO!!!");
				}
			}
		});
		delet.setForeground(Color.RED);
		delet.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		delet.setBounds(1015, 253, 122, 41);
		control.add(delet);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(153, 0, 51));
		separator.setBackground(new Color(153, 0, 51));
		separator.setBounds(178, 500, 959, 15);
		control.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(153, 0, 51));
		separator_1.setBackground(new Color(153, 0, 51));
		separator_1.setBounds(178, 503, 959, 15);
		control.add(separator_1);
		
		JLabel eliminate = new JLabel("Excluir Item:");
		eliminate.setForeground(new Color(153, 0, 51));
		eliminate.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		eliminate.setBounds(986, 212, 151, 40);
		control.add(eliminate);
		
		JLabel subTitle2 = new JLabel("ATUALIZAR ESTOQUE:");
		subTitle2.setForeground(new Color(153, 0, 51));
		subTitle2.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 50));
		subTitle2.setBounds(178, 536, 407, 41);
		control.add(subTitle2);
		
		JLabel actName = new JLabel("Nome:");
		actName.setForeground(new Color(153, 0, 51));
		actName.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		actName.setBounds(178, 595, 213, 40);
		control.add(actName);
		
		actProdName = new JTextField();
		actProdName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		actProdName.setBounds(178, 639, 407, 34);
		control.add(actProdName);
		
		actProdPrice = new JTextField();
		actProdPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		actProdPrice.setBounds(178, 728, 215, 34);
		control.add(actProdPrice);
		
		JLabel actPric = new JLabel("Pre\u00E7o da Unidade:");
		actPric.setForeground(new Color(153, 0, 51));
		actPric.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		actPric.setBounds(178, 684, 220, 40);
		control.add(actPric);
		
		JLabel actEstoque = new JLabel("Estoque:");
		actEstoque.setHorizontalAlignment(SwingConstants.RIGHT);
		actEstoque.setForeground(new Color(153, 0, 51));
		actEstoque.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		actEstoque.setBounds(478, 684, 107, 40);
		control.add(actEstoque);
		
		actQtty = new JTextField();
		actQtty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		actQtty.setBounds(489, 728, 96, 34);
		control.add(actQtty);
		
		JLabel actDescr = new JLabel("Descri\u00E7\u00E3o:");
		actDescr.setForeground(new Color(153, 0, 51));
		actDescr.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 36));
		actDescr.setBounds(609, 595, 528, 40);
		control.add(actDescr);
		
		changeProdDesc = new JTextArea();
		changeProdDesc.setWrapStyleWord(true);
		changeProdDesc.setLineWrap(true);
		changeProdDesc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		changeProdDesc.setBounds(609, 639, 528, 123);
		control.add(changeProdDesc);
		
		JButton actualizer = new JButton("ATUALIZAR");
		actualizer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductUpdate.productUpdate();
				actProdName.setText("");
				actProdPrice.setText("");
				actQtty.setText("");
				changeProdDesc.setText("");
				checkNameAct.setSelected(isDisplayable());
				checkPriceAct.setSelected(isDisplayable());
				checkStockAct.setSelected(isDisplayable());
				checkDescAct.setSelected(isDisplayable());
				productCode.setText("");
				productName.setText("");
				productPrice.setText("");
				stockQty.setText("");
				productDesc.setText("");
				
				JOptionPane.showMessageDialog(null, "Produto ATUALIZADO com ÊXITO!!!");
			}
		});
		actualizer.setForeground(new Color(0, 100, 0));
		actualizer.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		actualizer.setBounds(609, 802, 150, 41);
		control.add(actualizer);
		
		JButton clear_1 = new JButton("LIMPAR");
		clear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actProdName.setText("");
				actProdPrice.setText("");
				actQtty.setText("");
				changeProdDesc.setText("");
				checkNameAct.setSelected(isDisplayable());
				checkPriceAct.setSelected(isDisplayable());
				checkStockAct.setSelected(isDisplayable());
				checkDescAct.setSelected(isDisplayable());
			}
		});
		clear_1.setForeground(new Color(204, 102, 0));
		clear_1.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		clear_1.setBounds(783, 802, 122, 41);
		control.add(clear_1);
		
		checkNameAct = new JCheckBox("ATUALIZAR NOME");
		checkNameAct.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkNameAct.setBackground(Color.LIGHT_GRAY);
		checkNameAct.setBounds(178, 794, 183, 23);
		control.add(checkNameAct);
		
		checkPriceAct = new JCheckBox("ATUALIZAR PRE\u00C7O");
		checkPriceAct.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkPriceAct.setBackground(Color.LIGHT_GRAY);
		checkPriceAct.setBounds(178, 820, 183, 23);
		control.add(checkPriceAct);
		
		checkStockAct = new JCheckBox("ATUALIZAR ESTOQUE");
		checkStockAct.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkStockAct.setBackground(Color.LIGHT_GRAY);
		checkStockAct.setBounds(364, 820, 221, 23);
		control.add(checkStockAct);
		
		checkDescAct = new JCheckBox("ATUALIZAR DESCRI\u00C7\u00C3O");
		checkDescAct.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkDescAct.setBackground(Color.LIGHT_GRAY);
		checkDescAct.setBounds(364, 794, 221, 23);
		control.add(checkDescAct);
	}

	public StockBackImage getControl() {
		return control;
	}

	public void setControl(StockBackImage control) {
		this.control = control;
	}
}
