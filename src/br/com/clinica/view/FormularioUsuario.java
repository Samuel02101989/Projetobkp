package br.com.clinica.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.com.clinica.dao.UsuarioDao;
import br.com.clinica.model.Usuario;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class FormularioUsuario extends JFrame {
	JComboBox cboUserUsuario = new JComboBox();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtnomeuser;
	private JTextField txtprofisao;
	private JTextField txtcpfuser;
	private JTextField txtloginuser;
	private JTextField txtsenhauser;
	private JTextField txdId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioUsuario frame = new FormularioUsuario();
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
	public FormularioUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioUsuario.class.getResource("/br/com/clinica/image/hospital.png")));
		setBounds(new Rectangle(0, 0, 799, 499));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 799, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false) ;
		contentPane.setLayout(null);
		
		JLabel lblnomeuser = new JLabel("Nome:");
		lblnomeuser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblnomeuser.setBounds(155, 136, 46, 14);
		contentPane.add(lblnomeuser);
		
		JLabel lblprofuser = new JLabel("Profiss\u00E3o:");
		lblprofuser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblprofuser.setBounds(156, 186, 65, 14);
		contentPane.add(lblprofuser);
		
		JLabel lblcpfuser = new JLabel("CPF:");
		lblcpfuser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblcpfuser.setBounds(155, 235, 46, 14);
		contentPane.add(lblcpfuser);
		
		JLabel lbltipouser = new JLabel("TipoUser:");
		lbltipouser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbltipouser.setBounds(398, 235, 65, 14);
		contentPane.add(lbltipouser);
		
		JLabel lblloginuser = new JLabel("Login:");
		lblloginuser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblloginuser.setBounds(155, 291, 46, 14);
		contentPane.add(lblloginuser);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(302, 30, 177, 27);
		contentPane.add(lblNewLabel);
		
		txtnomeuser = new JTextField();
		txtnomeuser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				String CpfKey = "0987654321";
				if(CpfKey.contains(ev.getKeyChar()+"")){
					ev.consume();
				}
				
			}
		});
		txtnomeuser.setBounds(211, 134, 321, 20);
		contentPane.add(txtnomeuser);
		txtnomeuser.setColumns(10);
		
		txtprofisao = new JTextField();
		txtprofisao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent eve) {
				String CpfKey = "0987654321";
				if(CpfKey.contains(eve.getKeyChar()+"")){
					eve.consume();
				}
				
			}
		});
		txtprofisao.setBounds(211, 184, 321, 20);
		contentPane.add(txtprofisao);
		txtprofisao.setColumns(10);
		
		txtcpfuser = new JTextField();
		txtcpfuser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String CpfKey = "0987654321";
				if(!CpfKey.contains(e.getKeyChar()+"")){
					e.consume();
				}
				
			}
		});
		txtcpfuser.setBounds(211, 233, 177, 20);
		contentPane.add(txtcpfuser);
		txtcpfuser.setColumns(10);
		
		txtloginuser = new JTextField();
		txtloginuser.setBounds(211, 289, 177, 20);
		contentPane.add(txtloginuser);
		txtloginuser.setColumns(10);
		
		JLabel lbliduser = new JLabel("Id:");
		lbliduser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbliduser.setBounds(155, 102, 15, 14);
		contentPane.add(lbliduser);
		
		txdId = new JTextField();
		txdId.setText("Gerado Automatico");
		txdId.setEnabled(false);
		txdId.setEditable(false);
		txdId.setBounds(210, 100, 110, 20);
		contentPane.add(txdId);
		txdId.setColumns(10);
		
		JButton btnpesquisauser = new JButton("");
		btnpesquisauser.setIcon(new ImageIcon("C:\\Users\\Samuel\\Desktop\\CLinicaIcon\\Icone\\imagens projeto learn java brazil\\procurar.png"));
		btnpesquisauser.setToolTipText("Pesquisar");
		btnpesquisauser.setBounds(600, 250, 60, 40);
		contentPane.add(btnpesquisauser);
		
		JButton btnnovouser = new JButton("");
		btnnovouser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clearfieldsNew();
			}

		});
		btnnovouser.setIcon(new ImageIcon("C:\\Users\\Samuel\\Desktop\\CLinicaIcon\\new.png"));
		btnnovouser.setToolTipText("Novo");
		btnnovouser.setBounds(600, 100, 60, 40);
		contentPane.add(btnnovouser);
		
		JButton btnsaveuser = new JButton("");
		btnsaveuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Salvando um usuario
				try {
					Usuario usuario = saveUser();
					
					//Validaçao obrigatoria dos campos
					if (fieldsValidationUser()){
						
						JOptionPane.showMessageDialog(null, "*Preencha todos os dados Obrigatorios!!");
						
					} else {
						UsuarioDao.getInstance().merge(usuario);
						JOptionPane.showMessageDialog(null, "Salvo com sucesso");
						
                        //limpando campos
						clearFieldsUser();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

			
		});
		btnsaveuser.setIcon(new ImageIcon("C:\\Users\\Samuel\\Desktop\\CLinicaIcon\\save2.png"));
		btnsaveuser.setToolTipText("Salvar");
		btnsaveuser.setBounds(600, 150, 60, 40);
		contentPane.add(btnsaveuser);
		
		JButton btnatualizauser = new JButton("");
		btnatualizauser.setIcon(new ImageIcon("C:\\Users\\Samuel\\Desktop\\CLinicaIcon\\uptade.png"));
		btnatualizauser.setToolTipText("Atualizar");
		btnatualizauser.setBounds(600, 200, 60, 40);
		contentPane.add(btnatualizauser);
		
	
		ImageIcon icone = new ImageIcon(this.getClass().getResource("/br/com/clinica/image/useruser.jpg"));
		Image image = icone.getImage();
		JDesktopPane dskusuario = new JDesktopPane(){
			public void paintComponent(Graphics grafics){
				grafics.drawImage(image, 0, 0, getWidth(),getHeight(),this );
			}
		};	
		dskusuario.setBackground(new Color(245, 255, 250));
		
		dskusuario.setBorder(new TitledBorder(null, "CadastroUsuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dskusuario.setBounds(0, 0, 793, 470);
		contentPane.add(dskusuario);
		
		
		JLabel lblfoto = new JLabel("");
		lblfoto.setBounds(26, 23, 46, 68);
		dskusuario.add(lblfoto);
		lblfoto.setIcon(new ImageIcon(FormularioUsuario.class.getResource("/br/com/clinica/image/usuario.png")));
		
		JLabel lblsenhauser = new JLabel("Senha:");
		lblsenhauser.setBounds(408, 289, 46, 14);
		dskusuario.add(lblsenhauser);
		lblsenhauser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtsenhauser = new JTextField();
		txtsenhauser.setBounds(460, 287, 75, 20);
		dskusuario.add(txtsenhauser);
		txtsenhauser.setColumns(10);	
		
		cboUserUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboUserUsuario.getSelectedItem().equals("ADM")){
					JOptionPane.showMessageDialog(null, "Sou o Boss nessa porra!!");
				}else{
					JOptionPane.showMessageDialog(null, "Sou Apenas usuario!!");
				}
				
			}
		});
		
		
		cboUserUsuario.setModel(new DefaultComboBoxModel(new String[] {"ADM", "USER"}));
		cboUserUsuario.setBounds(460, 232, 75, 20);
		dskusuario.add(cboUserUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("*Campos Obrigatorios");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblNewLabel_1.setBounds(532, 39, 118, 14);
		dskusuario.add(lblNewLabel_1);
		
		JLabel lblcamposComRestricoes = new JLabel("**Campos Com restricoes de numero e letras");
		lblcamposComRestricoes.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblcamposComRestricoes.setBounds(522, 23, 229, 14);
		dskusuario.add(lblcamposComRestricoes);
	}
	
	//METODOS RELACIONADOS AO ESCOPO DO PROGRAMA
	
	private void clearFieldsUser() {
		//Limpando campos
		txtnomeuser.setText(null);
		txtcpfuser.setText(null);
		txtprofisao.setText(null);
		txtloginuser.setText(null);
		txtsenhauser.setText(null);
		
		//Desativando os campos
		txtnomeuser.setEditable(false);
		txtcpfuser.setEditable(false);
		txtprofisao.setEditable(false);
		txtloginuser.setEditable(false);
		txtsenhauser.setEditable(false);
	}

	private boolean fieldsValidationUser() {
		return txtnomeuser.getText().isEmpty() || (txtcpfuser.getText().isEmpty() 
		|| (txtprofisao.getText().isEmpty())) || (txtloginuser.getText().isEmpty() 
		|| (txtsenhauser.getText().isEmpty()));
	}

	private Usuario saveUser() {
		Usuario usuario = new Usuario();
		usuario.setNomeUsuario(txtnomeuser.getText());
		usuario.setTipoUsuario(cboUserUsuario.getSelectedItem().toString());
		usuario.setCpfUsuario(txtcpfuser.getText());
		usuario.setProfissaoUsuario(txtprofisao.getText());
		usuario.setLoginUsuario(txtloginuser.getText());
		usuario.setSenhaUsuario(txtsenhauser.getText());
		return usuario;
	}
	private void clearfieldsNew() {
		//Ativando os campos
		txtnomeuser.setEditable(true);
		txtcpfuser.setEditable(true);
		txtprofisao.setEditable(true);
		txtloginuser.setEditable(true);
		txtsenhauser.setEditable(true);
	}
}
