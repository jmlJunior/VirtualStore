package design;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import accessinterface.UserInterface;

public class StockControl extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton enter, clear, out;
	
	private JLabel title, subTitle;
	
	StockBackImage control;

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
		
		subTitle = new JLabel("CONTROLE DE ESTOQUE:");
		subTitle.setForeground(new Color(153, 0, 51));
		subTitle.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 50));
		subTitle.setBounds(178, 150, 786, 41);
		control.add(subTitle);
		/**
		 * 
		**/
		
		enter = new JButton("PESQUISAR");
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		enter.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		enter.setBounds(987, 750, 150, 41);
		control.add(enter);
		
		clear = new JButton("LIMPAR");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		clear.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		clear.setBounds(855, 750, 122, 41);
		control.add(clear);
		
		out = new JButton("SAIR");
		out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInterface.InitialScreen();
				LoginPanel.textField.setText("");
				LoginPanel.passwordField.setText("");
			}
		});
		out.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
		out.setBounds(723, 750, 122, 41);
		control.add(out);
	}

	public StockBackImage getControl() {
		return control;
	}

	public void setControl(StockBackImage control) {
		this.control = control;
	}
}
