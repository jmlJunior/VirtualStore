package accessinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import design.CashRegister;
import design.ClientRegisterPanel;
import design.LoginPanel;
import design.ProductRegisterPanel;
import design.StockControl;
import design.UserRegisterPanel;

/**
 * Este JFrame cria a base principal que suporta todas as abas/(tabbedPanes) do programa
 **/

public class UserInterface extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public static JTabbedPane tabbedPane;
	
	private JPanel mainTab;
	LoginPanel login = new LoginPanel();
	UserRegisterPanel user = new UserRegisterPanel();
	ClientRegisterPanel client = new ClientRegisterPanel();
	ProductRegisterPanel product = new ProductRegisterPanel();
	StockControl stock = new StockControl();
	CashRegister cash = new CashRegister();

	/**
	 * Launch the application.
	 **/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 **/
	
	public UserInterface() {
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		setBounds(325, 0, 1295, 990);
		mainTab = new JPanel();
		mainTab.setLayout(new GridLayout());
		setContentPane(mainTab);
		mainTab.setRequestFocusEnabled(isResizable());
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		mainTab.add(tabbedPane, BorderLayout.CENTER);
		
		/**
		 * abas/(tabbedPanes) do programa
		 **/
		
		tabbedPane.addTab("Login do Usuário", null, login.getUserPage(), BorderLayout.CENTER);
		tabbedPane.addTab("Cadastro de Usuários", null, user.getUserRegistration(), BorderLayout.CENTER);
		tabbedPane.addTab("Cadastro de Clientes", null, client.getClientRegister(), BorderLayout.CENTER);
		tabbedPane.addTab("Controle de CAIXA", null, cash.getCashRegister(), BorderLayout.CENTER);
		tabbedPane.addTab("Cadastro de Produtos", null, product.getProductRegistration(), BorderLayout.CENTER);
		tabbedPane.addTab("Controle de Estoque", null, stock.getControl(), BorderLayout.CENTER);
		
		/**
		 * O bloco abaixo desabilita todas as abas do programa mantendo somente a aba 'Login do Usuário' aberta/visível		
		 **/
		tabbedPane.setEnabledAt(1, false); 
		tabbedPane.setEnabledAt(2, false);
		tabbedPane.setEnabledAt(3, false);
		tabbedPane.setEnabledAt(4, false);
		tabbedPane.setEnabledAt(5, false);

		//Este bloco de teste (abaixo) deverá ser apagado após a finalização do projeto pois ele habilita todas as abas
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setEnabledAt(2, true);
		tabbedPane.setEnabledAt(3, true);
		tabbedPane.setEnabledAt(4, true);
		tabbedPane.setEnabledAt(5, true);
	}
	
	/**
	 *Todas as abas possuem um botão SAIR que irá executar esta função trazendo o usuário para a Página de Login mantendo todas as demais abas bloqueadas
	 *Ao terminar de usar o programa o usuário poderá sair do sistema deixando o mesmo bloqueado na Página de Login uma vez que cada usuário possui privilégios diferenciados
	 **/
	public static void InitialScreen() {
		tabbedPane.setSelectedIndex(0);
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setEnabledAt(1, false);
		tabbedPane.setEnabledAt(2, false);
		tabbedPane.setEnabledAt(3, false);
		tabbedPane.setEnabledAt(4, false);
		tabbedPane.setEnabledAt(5, false);
	}

	public static void ManagerScreen() {
		tabbedPane.setEnabledAt(0, false);
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setEnabledAt(2, true);
		tabbedPane.setEnabledAt(3, true);
		tabbedPane.setEnabledAt(4, true);
		tabbedPane.setEnabledAt(5, true);
		tabbedPane.setSelectedIndex(1);
	}
	
	public static void SellerScreen() {
		tabbedPane.setEnabledAt(0, false);
		tabbedPane.setEnabledAt(1, false);
		tabbedPane.setEnabledAt(2, true);
		tabbedPane.setEnabledAt(3, true);
		tabbedPane.setEnabledAt(4, false);
		tabbedPane.setEnabledAt(5, false);
		tabbedPane.setSelectedIndex(3);
	}
}
