package br.com.clinica.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.toedter.calendar.JCalendar;

import br.com.clinica.dao.MedicoDao;
import br.com.clinica.model.Medico;

public class FormularioMedico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JTextField txtNomeMedico;
	private JTextField txtCrmMedico;
	private JTextField txtidMedico;
	private JTextField txtCpfMedico;
	private JTextField txtNomeMaeMedico;
	private JTextField txtNomeRuaMedico;
	private JTextField txtCidadeMedico;
	private JTextField txtTelCelularMedico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioMedico frame = new FormularioMedico();
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
	public FormularioMedico() {
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioMedico.class.getResource("/br/com/clinica/image/doctor.png")));
		setBounds(new Rectangle(0, 0, 499, 799));
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("Clinica Santa Maria");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 801, 494);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 490, 790));
		contentPane.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "CadastroMedico", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		setResizable(false) ;
		contentPane.setLayout(null);
		
		JLabel lblnomemedico = new JLabel("*Nome:");
		lblnomemedico.setBounds(31, 105, 46, 14);
		lblnomemedico.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblnomemedico);
		
		JLabel lblcrm = new JLabel("*Crm:");
		lblcrm.setBounds(31, 147, 46, 14);
		lblcrm.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblcrm);
		
		JLabel lblespecmedico = new JLabel("*Especializa\u00E7ao:");
		lblespecmedico.setBounds(342, 147, 101, 14);
		lblespecmedico.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblespecmedico);
		
		JLabel lblidmedico = new JLabel("Id:");
		lblidmedico.setBounds(415, 105, 33, 14);
		lblidmedico.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblidmedico);
		
		txtNomeMedico = new JTextField();
		txtNomeMedico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String nomeLetras="0987654321";
				if(nomeLetras.contains(e.getKeyChar()+"")){
					e.consume();
					
				}
			}
		});
		txtNomeMedico.setBounds(89, 103, 316, 20);
		contentPane.add(txtNomeMedico);
		txtNomeMedico.setColumns(10);
		
		txtCrmMedico = new JTextField();
		txtCrmMedico.addKeyListener(new KeyAdapter() {
			
		});
		txtCrmMedico.setBounds(88, 145, 244, 20);
		contentPane.add(txtCrmMedico);
		txtCrmMedico.setColumns(10);
		
		txtidMedico = new JTextField();
		txtidMedico.setBounds(458, 103, 86, 20);
		txtidMedico.setEnabled(false);
		txtidMedico.setEditable(false);
		contentPane.add(txtidMedico);
		txtidMedico.setColumns(10);
		
		JComboBox<Object> cboespecmedica = new JComboBox<Object>();
		cboespecmedica.setBounds(454, 145, 90, 20);
		cboespecmedica.setModel(new DefaultComboBoxModel<Object>(new String[] {"Psicologo", "Psiquiatra", "Clinico Geral", "NeuroCirugiao", "Obstetricia "}));
		contentPane.add(cboespecmedica);
		
		JLabel lblNamecadme = new JLabel("Cadastro Medico Clinico");
		lblNamecadme.setBounds(313, 29, 204, 14);
		lblNamecadme.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNamecadme);
		
		//adicionando novo medico
		JButton btnnew = new JButton("");
		btnnew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fieldsActivin();
			}

		});
		btnnew.setBounds(644, 108, 60, 40);
		btnnew.setIcon(new ImageIcon(FormularioMedico.class.getResource("/br/com/clinica/image/new.png")));
		btnnew.setToolTipText("Novo");
		contentPane.add(btnnew);
		
		//salvando dados
		JButton btnsaveMedico = new JButton("");
		btnsaveMedico.setBounds(644, 159, 60, 40);
		btnsaveMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Medico medico = new Medico();
					savingMedico(cboespecmedica, medico);
					
					//validacao dos campos obrigatorios
					
					if(fieldsValidation()){
						
						JOptionPane.showMessageDialog(null, "*Preencha todos os dados Obrigatorios!!");
					}else{
				     	MedicoDao.getInstance().merge(medico);
					    JOptionPane.showMessageDialog(null, "Salvo com sucesso");
					    
					    cleanFieldsEditableF();
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao salvar Medico");
				}
				
			}
	
		});
		
		btnsaveMedico.setIcon(new ImageIcon(FormularioMedico.class.getResource("/br/com/clinica/image/save2.png")));
		btnsaveMedico.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnsaveMedico.setToolTipText("Save");
		contentPane.add(btnsaveMedico);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(644, 210, 60, 40);
		btnNewButton_2.setIcon(new ImageIcon(FormularioMedico.class.getResource("/br/com/clinica/image/uptade.png")));
		contentPane.add(btnNewButton_2);
		
		JButton btnpesquisamedico = new JButton("");
		btnpesquisamedico.setBounds(644, 260, 60, 40);
		btnpesquisamedico.setToolTipText("Pesquisar");
		btnpesquisamedico.setIcon(new ImageIcon(FormularioMedico.class.getResource("/br/com/clinica/image/procurar.png")));
		contentPane.add(btnpesquisamedico);
		
	
		ImageIcon icone = new ImageIcon(this.getClass().getResource("/br/com/clinica/image/userfun.jpg"));
		Image imga = icone.getImage();
		
		JLabel lblNewLabel = new JLabel("*Nome da Mae:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(31, 211, 108, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("*Rua:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(31, 236, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("*Cidade:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(31, 266, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone/Celular:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(31, 301, 126, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("*CPF:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(31, 185, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		txtCpfMedico = new JTextField();
		txtCpfMedico.addKeyListener(new KeyAdapter() {
		
			@Override
			public void keyTyped(KeyEvent e) {
				String keyCpf = "0987654321";
				
				if(!keyCpf.contains(e.getKeyChar()+"")){
					e.consume();
					
				}
			}
		});
		txtCpfMedico.setColumns(10);
		txtCpfMedico.setBounds(89, 176, 244, 20);
		contentPane.add(txtCpfMedico);
		
		txtNomeMaeMedico = new JTextField();
		txtNomeMaeMedico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String maeMedico = "0987654321";
				if(maeMedico.contains(e.getKeyChar()+"")){
					e.consume();
					
				}
			}
		});
		txtNomeMaeMedico.setColumns(10);
		txtNomeMaeMedico.setBounds(135, 210, 409, 20);
		contentPane.add(txtNomeMaeMedico);
		
		txtNomeRuaMedico = new JTextField();
		txtNomeRuaMedico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String ruaMedico = "0987654321";
				if(ruaMedico.contains(e.getKeyChar()+"")){
					e.consume();
					
				}
			}
		});
		txtNomeRuaMedico.setColumns(10);
		txtNomeRuaMedico.setBounds(89, 236, 455, 20);
		contentPane.add(txtNomeRuaMedico);
		
		txtCidadeMedico = new JTextField();
		txtCidadeMedico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String cidMedico = "0987654321";
				if(cidMedico.contains(e.getKeyChar()+"")){
					e.consume();
				}
			}
		});
		txtCidadeMedico.setColumns(10);
		txtCidadeMedico.setBounds(145, 264, 399, 20);
		contentPane.add(txtCidadeMedico);
		
		txtTelCelularMedico = new JTextField();
		txtTelCelularMedico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				String  telCelular = "0987654321";
				if(!telCelular.contains(ev.getKeyChar() + "")){
					ev.consume();
				}
			}
		});
		txtTelCelularMedico.setColumns(10);
		txtTelCelularMedico.setBounds(145, 299, 399, 20);
		contentPane.add(txtTelCelularMedico);
		JDesktopPane deskMedico_1 = new JDesktopPane(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics gra){
				gra.drawImage(imga, 0, 0, getWidth(),getHeight(),this );
			}
		};
		deskMedico_1.setBackground(Color.WHITE);
		deskMedico_1.setBounds(0, 0, 795, 483);
		deskMedico_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "FormularioMedico", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(deskMedico_1);
		
		JLabel lblNewLabel_5 = new JLabel("**Campos com restri\u00E7oes de letras ou numero");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(538, 50, 227, 14);
		deskMedico_1.add(lblNewLabel_5);
		
		JLabel lblcamObrig = new JLabel("*Campos Obrigatorio");
		lblcamObrig.setBounds(538, 31, 108, 14);
		deskMedico_1.add(lblcamObrig);
		lblcamObrig.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblLogoMe = new JLabel("");
		lblLogoMe.setIcon(new ImageIcon(FormularioMedico.class.getResource("/br/com/clinica/image/medica.png")));
		lblLogoMe.setBounds(31, 31, 58, 63);
		deskMedico_1.add(lblLogoMe);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, lblnomemedico, lblcrm, lblespecmedico, lblidmedico, txtNomeMedico, txtCrmMedico, txtidMedico, cboespecmedica, lblNamecadme, lblcamObrig, btnnew, btnsaveMedico, btnNewButton_2, btnpesquisamedico, deskMedico_1}));
	}
	
	//METODOS RELACIONADOS ESCOPO DO PROGRAMA
	
	private void fieldsActivin() {
		//Ativando os campos
		txtNomeMedico.setEditable(true);
	    txtCrmMedico.setEditable(true);
	    txtCpfMedico.setEditable(true);
	    txtNomeMaeMedico.setEditable(true);
	    txtNomeRuaMedico.setEditable(true);
	    txtCidadeMedico.setEditable(true);
	    txtTelCelularMedico.setEditable(true);
	}
	private void cleanFieldsEditableF() {
		//Limpando campos 
		txtNomeMedico.setText(null);
		txtCrmMedico.setText(null);
		txtCpfMedico.setText(null);
		txtNomeMaeMedico.setText(null);
		txtNomeRuaMedico.setText(null);
		txtCidadeMedico.setText(null);
		txtTelCelularMedico.setText(null);
		
		//desativa os campos 
		txtNomeMedico.setEditable(false);
		txtCrmMedico.setEditable(false);
		txtCpfMedico.setEditable(false);
		txtNomeMaeMedico.setEditable(false);
		txtNomeRuaMedico.setEditable(false);
		txtCidadeMedico.setEditable(false);
		txtTelCelularMedico.setEditable(false);
	}
	
	//VALIDANDO CAMPOS

	private boolean fieldsValidation() {
		return (txtNomeMedico.getText().isEmpty()) || (txtCrmMedico.getText().isEmpty())
			|| (txtCpfMedico.getText().isEmpty()) || (txtNomeMaeMedico.getText().isEmpty()) 
			|| (txtNomeRuaMedico.getText().isEmpty()) || (txtCidadeMedico.getText().isEmpty()) 
			|| (txtTelCelularMedico.getText().isEmpty());
	}
	
	//SALVANDO MEDICO EM BANCO DE DADOS
	private void savingMedico(JComboBox<Object> cboespecmedica, Medico medico) {
		medico.setNome(txtNomeMedico.getText());
		medico.setCrm(txtCrmMedico.getText());
		medico.setEspecialidade((String)cboespecmedica.getSelectedItem());
		medico.setCpfMedico(txtCpfMedico.getText());
		medico.setNomeMaeMedico(txtNomeMaeMedico.getText());
		medico.setNomeRuaMedico(txtNomeRuaMedico.getText());
		medico.setNomeCidade(txtCidadeMedico.getText());
		medico.setTelefone(txtTelCelularMedico.getText());
	}
}
