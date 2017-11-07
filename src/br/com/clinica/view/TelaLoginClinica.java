package br.com.clinica.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.clinica.dao.UsuarioDao;
import java.awt.SystemColor;

public class TelaLoginClinica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5980547914283765652L;
	
	private JPanel contentPane;
	private JPasswordField passwordLogin;
	private JTextField txtTelaLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLoginClinica frame = new TelaLoginClinica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLoginClinica() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Samuel\\Desktop\\CLinicaIcon\\login.png"));
		setTitle("ClinicaLogin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 477);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setResizable(false) ;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon icone = new ImageIcon(this.getClass().getResource("/br/com/clinica/image/fmedico.jpg"));
		Image imag = icone.getImage();
		JDesktopPane dkpInternalframe = new JDesktopPane(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics gr){
				gr.drawImage(imag, 0, 0, getWidth(),getHeight(),this);
			}
		};
		dkpInternalframe.setBackground(Color.GRAY);
		dkpInternalframe.setBounds(0, 0, 1400, 800);
		contentPane.add(dkpInternalframe);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(535, 300, 51, 14);
		dkpInternalframe.add(lblSenha);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnExit = new JButton("");
		btnExit.setBounds(776, 342, 51, 29);
		dkpInternalframe.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnExit.setToolTipText("Sair");
		btnExit.setIcon(new ImageIcon("C:\\Users\\Samuel\\Desktop\\CLinicaIcon\\if_cross_16189.png"));
		
		// logar no sistema
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(602, 342, 89, 29);
		dkpInternalframe.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {  

				if ((!txtTelaLogin.getText().isEmpty() && !passwordLogin.getText().isEmpty())) {
					try {
						if (UsuarioDao.getInstance().getByLogo(txtTelaLogin.getText(), passwordLogin.getText())) {

							TelaPrincipal principal = new TelaPrincipal();
							principal.setVisible(true);
							dispose();

						} else {
							JOptionPane.showMessageDialog(null, "Campo de Login ou Senha vazio !!");
						}
					} catch (IndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(null, "Login ou senha Incorreto!!s");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Campo vazio!!");
				}
			}
			
		});
		
		
		btnLogin.setToolTipText("Logar");
		btnLogin.setIcon(new ImageIcon("C:\\Users\\Samuel\\Desktop\\CLinicaIcon\\if_login_173049.png"));
		
		
		JLabel lbllogo = new JLabel("");
		lbllogo.setBounds(678, 152, 64, 90);
		dkpInternalframe.add(lbllogo);
		lbllogo.setIcon(new ImageIcon(TelaLoginClinica.class.getResource("/br/com/clinica/image/userInicio.png")));
		
		passwordLogin = new JPasswordField();
		passwordLogin.setBounds(600, 299, 227, 20);
		dkpInternalframe.add(passwordLogin);
		
		txtTelaLogin = new JTextField();
		txtTelaLogin.setBounds(600, 253, 227, 20);
		dkpInternalframe.add(txtTelaLogin);
		txtTelaLogin.setSelectionColor(SystemColor.textHighlight);
		txtTelaLogin.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(535, 255, 51, 14);
		dkpInternalframe.add(lblNewLabel);
	}
}
