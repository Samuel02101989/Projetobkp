package br.com.clinica.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.clinica.dao.AgendaDao;
import br.com.clinica.dao.MedicoDao;
import br.com.clinica.dao.PacienteDao;
import br.com.clinica.model.Agenda;
import br.com.clinica.model.Medico;
import br.com.clinica.model.Paciente;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class FormularioAgenda extends JFrame {
	//JRadioButton rdbtnNao = new JRadioButton("nao");
	//JRadioButton rdbtnSim = new JRadioButton("sim");

	JComboBox cboStress = new JComboBox();
	JComboBox cboTratMedicoAtual = new JComboBox();
	JComboBox cboMedicaUso = new JComboBox();
	JComboBox cboAlgumDoenca = new JComboBox();
	JComboBox cboDiabetes = new JComboBox();
	JComboBox cboOconlogia = new JComboBox();
	JComboBox cboAlterPsicoPsiqui = new JComboBox();
	JComboBox cboEpilepsiaConv = new JComboBox();
	JComboBox cboDisturbio = new JComboBox();
	JComboBox cboHipoHiper = new JComboBox();
	JComboBox cboAlterCardiacos = new JComboBox();
	JComboBox cboMarcapasso = new JComboBox();
	/**
	 * 
	 */
	private static final long serialVersionUID = -3093394448746887438L;
	private JPanel contentPane;
	private JTextField txtFichaNome;
	private JTextField txtNomeAgenda;
	private JTextField txtNomeMaeAgenda;
	private JTextField txtNomePaiAgenda;
	private JTextField txtDataNascAgenda;
	private JTextField txtRuaAgenda;
	private JTextField txtCidadeAgenda;
	private JTextField txtTelAgenda;
	private JTextField textcrmteste;
	private JTextField txtNomeMedicoF;
	private JTextField txtEspecMedico;
	private JTextField txtPrecoMedico;
	private JTextField txtTratMeAtual;
	private JTextField txtMedicamUso;
	private JTextField txtPortaMarcapasso;
	private JTextField txtAlterCardi;
	private JTextField txtHipertensao;
	private JTextField txtDisturbio;
	private JTextField txtEpilepConvul;
	private JTextField txtAlterPsicoPsiquia;
	private JTextField txtStress;
	private JTextField txtCancerAnte;
	private JTextField txtDiabetes;
	private JTextField txtAlgumDoenca;
	private JTextField txtCpfMedicoAgenda;
	private JTextField txtNomeMaeMedicoAgenda;
	private JTextField txtRuaMedicoAgenda;
	private JTextField txtCidadeMedicoAgenda;
	private JTextField txtTelMedicoAgenda;
	private JTextField txtIdPaciente;
	private JTextField txtIdMedico;
	private JTextField txtNumAgenda;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioAgenda frame = new FormularioAgenda();
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
	public FormularioAgenda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Samuel\\Desktop\\CLinicaIcon\\ficha.png"));
		setBounds(new Rectangle(0, 0, 499, 799));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 799, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false) ;
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setBounds(10, 23, 773, 457);
		contentPane.add(tabbedPane);
		
		JPanel panelpaciente = new JPanel(){
          
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
		};
		panelpaciente.setBackground(Color.CYAN);
		panelpaciente.setForeground(new Color(0, 0, 0));
		tabbedPane.addTab("1 - Paciente", null, panelpaciente, null);
		panelpaciente.setLayout(null);
		
		JLabel lblnomeficha = new JLabel("*Nome do Paciente:");
		lblnomeficha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblnomeficha.setBounds(10, 95, 146, 14);
		panelpaciente.add(lblnomeficha);
		
		txtFichaNome = new JTextField();
		txtFichaNome.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent events) {
				String CpfKey = "0987654321";
				if(!CpfKey.contains(events.getKeyChar()+"")){
					events.consume();
				}
				
			}
		});
		txtFichaNome.setBounds(48, 34, 266, 20);
		panelpaciente.add(txtFichaNome);
		txtFichaNome.setColumns(10);

		//metodo pesquisar
		JButton btnfichanome = new JButton("");
		btnfichanome.setBackground(new Color(240, 248, 255));
		btnfichanome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			PacienteDao dao = new PacienteDao();
			Paciente paciente = new Paciente();
			paciente = dao.getByCpf(txtFichaNome.getText().toString());
			
			setDadosPaciente(paciente);
			
			}

		});
		btnfichanome.setIcon(new ImageIcon("C:\\Users\\Samuel\\Desktop\\CLinicaIcon\\Icone\\imagens projeto learn java brazil\\procurar.png"));
		btnfichanome.setBounds(343, 34, 89, 23);
		panelpaciente.add(btnfichanome);
		
		JLabel lblcpfagenda = new JLabel("*CPF:");
		lblcpfagenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblcpfagenda.setBounds(10, 34, 46, 14);
		panelpaciente.add(lblcpfagenda);
		
		txtNomeAgenda = new JTextField();
		txtNomeAgenda.setEditable(false);
		txtNomeAgenda.setBounds(144, 93, 288, 20);
		panelpaciente.add(txtNomeAgenda);
		txtNomeAgenda.setColumns(10);
		
		JLabel lblnomemaeagenda = new JLabel("*Nome Mae:");
		lblnomemaeagenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblnomemaeagenda.setBounds(10, 131, 114, 14);
		panelpaciente.add(lblnomemaeagenda);
		
		JLabel lblnomepaiagenda = new JLabel("*Nome Pai: ");
		lblnomepaiagenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblnomepaiagenda.setBounds(10, 156, 114, 14);
		panelpaciente.add(lblnomepaiagenda);
		
		JLabel lbldatanascimento = new JLabel("*Data Nascimento: ");
		lbldatanascimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbldatanascimento.setBounds(10, 181, 139, 14);
		panelpaciente.add(lbldatanascimento);
		
		JLabel lblruaagenda = new JLabel("*Rua:");
		lblruaagenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblruaagenda.setBounds(10, 206, 46, 14);
		panelpaciente.add(lblruaagenda);
		
		JLabel lblcidadeagenda = new JLabel("*Cidade:");
		lblcidadeagenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblcidadeagenda.setBounds(10, 237, 65, 14);
		panelpaciente.add(lblcidadeagenda);
		
		JLabel lbltelefoneagenda = new JLabel("*Telefone/Celular:");
		lbltelefoneagenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbltelefoneagenda.setBounds(10, 262, 114, 14);
		panelpaciente.add(lbltelefoneagenda);
		
		txtNomeMaeAgenda = new JTextField();
		txtNomeMaeAgenda.setEditable(false);
		txtNomeMaeAgenda.setBounds(102, 129, 330, 20);
		panelpaciente.add(txtNomeMaeAgenda);
		txtNomeMaeAgenda.setColumns(10);
		
		txtNomePaiAgenda = new JTextField();
		txtNomePaiAgenda.setEditable(false);
		txtNomePaiAgenda.setBounds(102, 156, 330, 20);
		panelpaciente.add(txtNomePaiAgenda);
		txtNomePaiAgenda.setColumns(10);
		
		txtDataNascAgenda = new JTextField();
		txtDataNascAgenda.setEditable(false);
		txtDataNascAgenda.setBounds(144, 179, 288, 20);
		panelpaciente.add(txtDataNascAgenda);
		txtDataNascAgenda.setColumns(10);
		
		txtRuaAgenda = new JTextField();
		txtRuaAgenda.setEditable(false);
		txtRuaAgenda.setBounds(58, 206, 374, 20);
		panelpaciente.add(txtRuaAgenda);
		txtRuaAgenda.setColumns(10);
		
		txtCidadeAgenda = new JTextField();
		txtCidadeAgenda.setEditable(false);
		txtCidadeAgenda.setBounds(68, 235, 230, 20);
		panelpaciente.add(txtCidadeAgenda);
		txtCidadeAgenda.setColumns(10);
		
		txtTelAgenda = new JTextField();
		txtTelAgenda.setEditable(false);
		txtTelAgenda.setBounds(124, 260, 308, 20);
		panelpaciente.add(txtTelAgenda);
		txtTelAgenda.setColumns(10);
		
		JButton btnagendar = new JButton("");
		btnagendar.setBackground(new Color(240, 248, 255));
		btnagendar.setToolTipText("Save/Continue");
		btnagendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnagendar.setIcon(new ImageIcon(FormularioAgenda.class.getResource("/br/com/clinica/image/next.png")));
		btnagendar.setBounds(600, 50, 60, 40);
		panelpaciente.add(btnagendar);
		
		JButton btncancelar = new JButton("");
		btncancelar.setToolTipText("Update");
		btncancelar.setBackground(new Color(240, 248, 255));
		btncancelar.setIcon(new ImageIcon(FormularioAgenda.class.getResource("/br/com/clinica/image/uptade.png")));
		btncancelar.setBounds(600, 100, 60, 40);
		panelpaciente.add(btncancelar);
		
		JLabel lblNewLabel = new JLabel("*Campos Obrigatorios");
		lblNewLabel.setBounds(284, 11, 148, 14);
		panelpaciente.add(lblNewLabel);
		
		JButton btnRemovePaciente = new JButton("remove");
		btnRemovePaciente.setBackground(new Color(240, 248, 255));
		btnRemovePaciente.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Paciente p = new Paciente();
				PacienteDao dao = new PacienteDao();
				
				dao.remove(Long.parseLong(txtIdPaciente.getText()));
				
				cleanFields();
				
			}
		});
		
		btnRemovePaciente.setBounds(571, 203, 89, 23);
		panelpaciente.add(btnRemovePaciente);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblId.setBounds(20, 65, 34, 14);
		panelpaciente.add(lblId);
		
		txtIdPaciente = new JTextField();
		txtIdPaciente.setEditable(false);
		txtIdPaciente.setBounds(48, 64, 60, 20);
		panelpaciente.add(txtIdPaciente);
		txtIdPaciente.setColumns(10);
		
		JLabel lblN = new JLabel("N\u00B0:");
		lblN.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblN.setBounds(308, 238, 24, 14);
		panelpaciente.add(lblN);
		
		txtNumAgenda = new JTextField();
		txtNumAgenda.setEditable(false);
		txtNumAgenda.setBounds(346, 235, 86, 20);
		panelpaciente.add(txtNumAgenda);
		txtNumAgenda.setColumns(10);
		
		JPanel painelmedico = new JPanel();
		painelmedico.setBackground(Color.CYAN);
		tabbedPane.addTab("2 - Medico", null, painelmedico, null);
		painelmedico.setLayout(null);
		
		JLabel lblcrmagenda = new JLabel("CRM:");
		lblcrmagenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblcrmagenda.setBounds(10, 37, 46, 14);
		painelmedico.add(lblcrmagenda);
		
		textcrmteste = new JTextField();
		textcrmteste.setBounds(66, 34, 121, 20);
		painelmedico.add(textcrmteste);
		textcrmteste.setColumns(10);
		
		JButton btnpesquisarmedico = new JButton("");
		btnpesquisarmedico.setBackground(new Color(240, 248, 255));
		btnpesquisarmedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MedicoDao medicoDao = new MedicoDao();
                Medico medico = new Medico();
				medico = medicoDao.getByCrm(textcrmteste.getText());
                
				setDadosMedico(medico);	
                
			}

		});
		btnpesquisarmedico.setIcon(new ImageIcon("C:\\Users\\Samuel\\Desktop\\CLinicaIcon\\Icone\\imagens projeto learn java brazil\\procurar.png"));
		btnpesquisarmedico.setBounds(197, 34, 89, 23);
		painelmedico.add(btnpesquisarmedico);
		
		JLabel lblnomemedicoagenda = new JLabel("Nome:");
		lblnomemedicoagenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblnomemedicoagenda.setBounds(10, 96, 81, 14);
		painelmedico.add(lblnomemedicoagenda);
		
		txtNomeMedicoF = new JTextField();
		txtNomeMedicoF.setEditable(false);
		txtNomeMedicoF.setBounds(66, 95, 362, 20);
		painelmedico.add(txtNomeMedicoF);
		txtNomeMedicoF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Especializa\u00E7ao:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 135, 89, 14);
		painelmedico.add(lblNewLabel_1);
		
		txtEspecMedico = new JTextField();
		txtEspecMedico.setEditable(false);
		txtEspecMedico.setBounds(101, 130, 196, 20);
		painelmedico.add(txtEspecMedico);
		txtEspecMedico.setColumns(10);
		
		JLabel lblpreçoagenda = new JLabel("Pre\u00E7o:");
		lblpreçoagenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblpreçoagenda.setBounds(307, 135, 46, 14);
		painelmedico.add(lblpreçoagenda);
		
		txtPrecoMedico = new JTextField();
		txtPrecoMedico.setEditable(false);
		txtPrecoMedico.setBounds(363, 130, 66, 20);
		painelmedico.add(txtPrecoMedico);
		txtPrecoMedico.setColumns(10);
		
		JButton btnnextmedico = new JButton("");
		btnnextmedico.setBackground(new Color(240, 248, 255));
		btnnextmedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnnextmedico.setIcon(new ImageIcon(FormularioAgenda.class.getResource("/br/com/clinica/image/next.png")));
		btnnextmedico.setBounds(600, 50, 60, 40);
		painelmedico.add(btnnextmedico);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 165, 46, 14);
		painelmedico.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nome da Mae:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 200, 98, 14);
		painelmedico.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Rua:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 235, 46, 14);
		painelmedico.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cidade:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 270, 46, 14);
		painelmedico.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telefone/Celular:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 305, 130, 14);
		painelmedico.add(lblNewLabel_6);
		
		txtCpfMedicoAgenda = new JTextField();
		txtCpfMedicoAgenda.setEditable(false);
		txtCpfMedicoAgenda.setColumns(10);
		txtCpfMedicoAgenda.setBounds(66, 165, 299, 20);
		painelmedico.add(txtCpfMedicoAgenda);
		
		txtNomeMaeMedicoAgenda = new JTextField();
		txtNomeMaeMedicoAgenda.setEditable(false);
		txtNomeMaeMedicoAgenda.setColumns(10);
		txtNomeMaeMedicoAgenda.setBounds(101, 200, 264, 20);
		painelmedico.add(txtNomeMaeMedicoAgenda);
		
		txtRuaMedicoAgenda = new JTextField();
		txtRuaMedicoAgenda.setEditable(false);
		txtRuaMedicoAgenda.setColumns(10);
		txtRuaMedicoAgenda.setBounds(66, 235, 299, 20);
		painelmedico.add(txtRuaMedicoAgenda);
		
		txtCidadeMedicoAgenda = new JTextField();
		txtCidadeMedicoAgenda.setEditable(false);
		txtCidadeMedicoAgenda.setColumns(10);
		txtCidadeMedicoAgenda.setBounds(66, 270, 299, 20);
		painelmedico.add(txtCidadeMedicoAgenda);
		
		txtTelMedicoAgenda = new JTextField();
		txtTelMedicoAgenda.setEditable(false);
		txtTelMedicoAgenda.setColumns(10);
		txtTelMedicoAgenda.setBounds(142, 305, 223, 20);
		painelmedico.add(txtTelMedicoAgenda);
		
		txtIdMedico = new JTextField();
		txtIdMedico.setEditable(false);
		txtIdMedico.setBounds(66, 65, 33, 20);
		painelmedico.add(txtIdMedico);
		txtIdMedico.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Id:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(10, 71, 46, 14);
		painelmedico.add(lblNewLabel_7);
		
		//Controle dos RadioButton
		
		JPanel painelinfor = new JPanel();
		ButtonGroup g1 = new ButtonGroup();
		
		painelinfor.setBackground(Color.CYAN);
		tabbedPane.addTab("3 - Historico Clinico", null, painelinfor, null);
		painelinfor.setLayout(null);
		
		JLabel lbltratmedico = new JLabel("Tratamento medico atual:");
		lbltratmedico.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbltratmedico.setBounds(46, 10, 168, 14);
		painelinfor.add(lbltratmedico);
		
		JLabel lblmedicsuso = new JLabel("Medicamento em uso:");
		lblmedicsuso.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblmedicsuso.setBounds(46, 40, 155, 14);
		painelinfor.add(lblmedicsuso);
		
		JLabel lblDiabetes = new JLabel("Diabetes:");
		lblDiabetes.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiabetes.setBounds(46, 310, 67, 14);
		painelinfor.add(lblDiabetes);
		
		JLabel lblmarcapasso = new JLabel("Portador de Marcapasso:");
		lblmarcapasso.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblmarcapasso.setBounds(46, 70, 155, 14);
		painelinfor.add(lblmarcapasso);
		
		JLabel lblaltcardiaca = new JLabel("Altera\u00E7oes Cardiacas:");
		lblaltcardiaca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblaltcardiaca.setBounds(46, 100, 155, 14);
		painelinfor.add(lblaltcardiaca);
		
		JLabel lblprensaoh = new JLabel("Hipo/Hipertensao Arterial:");
		lblprensaoh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblprensaoh.setBounds(46, 130, 178, 14);
		painelinfor.add(lblprensaoh);
		
		JLabel lbldisturbio = new JLabel("Algun tipo de Distubio?");
		lbldisturbio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbldisturbio.setBounds(46, 160, 155, 14);
		painelinfor.add(lbldisturbio);
		
		JLabel lblepilepconvul = new JLabel("Epilepsia-Convulsoes:");
		lblepilepconvul.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblepilepconvul.setBounds(46, 190, 155, 14);
		painelinfor.add(lblepilepconvul);
		
		JLabel lblpsicopsiqo = new JLabel("Altera\u00E7oes Psicologica/Psiquiatricas:");
		lblpsicopsiqo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblpsicopsiqo.setBounds(46, 220, 226, 14);
		painelinfor.add(lblpsicopsiqo);
		
		JLabel lblStress = new JLabel("Stress:");
		lblStress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStress.setBounds(46, 250, 58, 14);
		painelinfor.add(lblStress);
		
		JLabel lbloncologico = new JLabel("Antecendentes Oconlogicos:");
		lbloncologico.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbloncologico.setBounds(46, 280, 189, 14);
		painelinfor.add(lbloncologico);
		
		JLabel lblAlgumTipoDe = new JLabel("Algum tipo de Doen\u00E7a:");
		lblAlgumTipoDe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAlgumTipoDe.setBounds(46, 340, 155, 14);
		painelinfor.add(lblAlgumTipoDe);
		
		JLabel lblQuais = new JLabel("Quais:");
		lblQuais.setBounds(334, 11, 41, 14);
		painelinfor.add(lblQuais);
		
		
		//PARTE DO CODIGO ONDE SE ENCONTRA VARIAVEIS DA FICHA MEDICA
		
		txtTratMeAtual = new JTextField();
		txtTratMeAtual.setEnabled(false);
		txtTratMeAtual.setBounds(381, 8, 367, 20);
		painelinfor.add(txtTratMeAtual);
		txtTratMeAtual.setColumns(10);
		
		
		txtMedicamUso = new JTextField();
		txtMedicamUso.setEnabled(false);
		txtMedicamUso.setColumns(10);
		txtMedicamUso.setBounds(381, 40, 367, 20);
		painelinfor.add(txtMedicamUso);
		
		JLabel label = new JLabel("Quais:");
		label.setBounds(337, 43, 41, 14);
		painelinfor.add(label);
		
		txtPortaMarcapasso = new JTextField();
		txtPortaMarcapasso.setEnabled(false);
		txtPortaMarcapasso.setColumns(10);
		txtPortaMarcapasso.setBounds(419, 70, 329, 20);
		painelinfor.add(txtPortaMarcapasso);
		
		JLabel lblTempoDeUso = new JLabel("Tempo de Uso:");
		lblTempoDeUso.setBounds(315, 71, 94, 14);
		painelinfor.add(lblTempoDeUso);
		
		txtAlterCardi = new JTextField();
		txtAlterCardi.setEnabled(false);
		txtAlterCardi.setColumns(10);
		txtAlterCardi.setBounds(381, 101, 367, 20);
		painelinfor.add(txtAlterCardi);
		
		JLabel label_2 = new JLabel("Quais:");
		label_2.setBounds(337, 104, 41, 14);
		painelinfor.add(label_2);
		
		txtHipertensao = new JTextField();
		txtHipertensao.setEnabled(false);
		txtHipertensao.setColumns(10);
		txtHipertensao.setBounds(381, 130, 367, 20);
		painelinfor.add(txtHipertensao);
		
		JLabel label_3 = new JLabel("Quais:");
		label_3.setBounds(334, 133, 41, 14);
		painelinfor.add(label_3);
		
		txtDisturbio = new JTextField();
		txtDisturbio.setEnabled(false);
		txtDisturbio.setColumns(10);
		txtDisturbio.setBounds(381, 160, 367, 20);
		painelinfor.add(txtDisturbio);
		
		JLabel label_4 = new JLabel("Quais:");
		label_4.setBounds(334, 163, 41, 14);
		painelinfor.add(label_4);
		
		txtEpilepConvul = new JTextField();
		txtEpilepConvul.setEnabled(false);
		txtEpilepConvul.setColumns(10);
		txtEpilepConvul.setBounds(381, 190, 367, 20);
		painelinfor.add(txtEpilepConvul);
		
		JLabel label_5 = new JLabel("Quais:");
		label_5.setBounds(334, 193, 41, 14);
		painelinfor.add(label_5);
		
		txtAlterPsicoPsiquia = new JTextField();
		txtAlterPsicoPsiquia.setEnabled(false);
		txtAlterPsicoPsiquia.setColumns(10);
		txtAlterPsicoPsiquia.setBounds(419, 220, 329, 20);
		painelinfor.add(txtAlterPsicoPsiquia);
		
		JLabel label_6 = new JLabel("Quais:");
		label_6.setBounds(372, 223, 41, 14);
		painelinfor.add(label_6);
		
		txtStress = new JTextField();
		txtStress.setEnabled(false);
		txtStress.setColumns(10);
		txtStress.setBounds(381, 250, 367, 20);
		painelinfor.add(txtStress);
		
		JLabel label_7 = new JLabel("Quais:");
		label_7.setBounds(334, 253, 41, 14);
		painelinfor.add(label_7);
		
		txtCancerAnte = new JTextField();
		txtCancerAnte.setEnabled(false);
		txtCancerAnte.setColumns(10);
		txtCancerAnte.setBounds(381, 280, 367, 20);
		painelinfor.add(txtCancerAnte);
		
		JLabel label_8 = new JLabel("Quais:");
		label_8.setBounds(347, 281, 50, 14);
		painelinfor.add(label_8);
		
		txtDiabetes = new JTextField();
		txtDiabetes.setEnabled(false);
		txtDiabetes.setColumns(10);
		txtDiabetes.setBounds(381, 310, 367, 20);
		painelinfor.add(txtDiabetes);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(334, 311, 33, 14);
		painelinfor.add(lblTipo);
		
		txtAlgumDoenca = new JTextField();
		txtAlgumDoenca.setEnabled(false);
		txtAlgumDoenca.setColumns(10);
		txtAlgumDoenca.setBounds(381, 340, 367, 20);
		painelinfor.add(txtAlgumDoenca);
		
		JLabel label_10 = new JLabel("Quais:");
		label_10.setBounds(334, 343, 41, 14);
		painelinfor.add(label_10);
		
		//METODO DE AGENDAR A CONSULTA
		JButton btnAgendarconsulta = new JButton("");
		
		//DEIXANDO BOTAO TRANSPARENTE
		//btnAgendarconsulta.setBorderPainted(true);
		//btnAgendarconsulta.setContentAreaFilled(false);
		//btnAgendarconsulta.setFocusPainted(true);
		btnAgendarconsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Agenda agenda = new Agenda();
					//paciente.setPlanosaude((String)cboplanosaude.getSelectedItem());
					saveConsultaDba(agenda);
					AgendaDao.getInstance().merge(agenda);
					
					JOptionPane.showMessageDialog(null, "Consulta Agendada com Sucesso!!");
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao agendar consulta!!");
				}
			}

			
			
		});
		btnAgendarconsulta.setBackground(new Color(240, 248, 255));
		btnAgendarconsulta.setIcon(new ImageIcon(FormularioAgenda.class.getResource("/br/com/clinica/image/if_f-check_256_282474.png")));
		btnAgendarconsulta.setBounds(257, 367, 166, 33);
		painelinfor.add(btnAgendarconsulta);
		
		cboMarcapasso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboMarcapasso.getSelectedItem().equals("SIM")){
					txtPortaMarcapasso.setEnabled(true);
					txtPortaMarcapasso.setText(null);
				}else{
					if(cboMarcapasso.getSelectedItem().equals("NAO")){
					txtPortaMarcapasso.setText("Nada declarar");
					txtPortaMarcapasso.setEnabled(false);
					}else{
						txtPortaMarcapasso.setText("Escolha uma opcao.");
						txtPortaMarcapasso.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Escolha, SIM ou NAO!!");
					}
				}
			}
		});
		
		
		cboMarcapasso.setBackground(new Color(240, 248, 255));
		cboMarcapasso.setModel(new DefaultComboBoxModel(new String[] {"OPC", "SIM", "NAO"}));
		cboMarcapasso.setBounds(224, 68, 65, 20);
		painelinfor.add(cboMarcapasso);
		
		cboAlterCardiacos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboAlterCardiacos.getSelectedItem().equals("SIM")){
					txtAlterCardi.setEnabled(true);
					txtAlterCardi.setText(null);
				  }else{
					  if(cboAlterCardiacos.getSelectedItem().equals("NAO")){
					  txtAlterCardi.setText("Nada a declarar.");
					  txtAlterCardi.setEnabled(false);
					  }else{
						  txtAlterCardi.setText("Escolha uma opcao.");
						  txtAlterCardi.setEnabled(false);
						  JOptionPane.showMessageDialog(null, "Escolha, SIM ou NAO!!");
					  }
				       }
			  }
		});
		
		
		cboAlterCardiacos.setBackground(new Color(240, 248, 255));
		cboAlterCardiacos.setModel(new DefaultComboBoxModel(new String[] {"OPC", "SIM", "NAO"}));
		cboAlterCardiacos.setBounds(224, 98, 65, 20);
		
		painelinfor.add(cboAlterCardiacos);
		cboHipoHiper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboHipoHiper.getSelectedItem().equals("SIM")){
					txtHipertensao.setEnabled(true);
					txtHipertensao.setText(null);
				}else{
					if(cboHipoHiper.getSelectedItem().equals("NAO")){
					txtHipertensao.setText("False");
					txtHipertensao.setEnabled(false);
					}else{
						txtHipertensao.setText("Escolha uma opçao.");
						txtHipertensao.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Escolha, SIM ou NAO!!");
						
					}
				}
			}
		});
		
		
		cboHipoHiper.setBackground(new Color(240, 248, 255));
		cboHipoHiper.setModel(new DefaultComboBoxModel(new String[] {"OPC", "SIM", "NAO"}));
		cboHipoHiper.setBounds(224, 128, 65, 20);
		painelinfor.add(cboHipoHiper);
		cboDisturbio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboDisturbio.getSelectedItem().equals("SIM")){
					txtDisturbio.setEnabled(true);
					txtDisturbio.setText(null);
				}else{
					if(cboDisturbio.getSelectedItem().equals("NAO")){
					txtDisturbio.setText("Nada a declara.");
					txtDisturbio.setEnabled(false);
					}else{
						txtDisturbio.setText("Escolha uma opcao.");
						txtDisturbio.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Escolha, SIM ou NAO!!");
					}
				}
			}
		});
		
		
		cboDisturbio.setBackground(new Color(240, 248, 255));
		cboDisturbio.setModel(new DefaultComboBoxModel(new String[] {"OPC", "SIM", "NAO"}));
		cboDisturbio.setBounds(224, 158, 65, 20);
		painelinfor.add(cboDisturbio);
		
		cboEpilepsiaConv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboEpilepsiaConv.getSelectedItem().equals("SIM")){
					txtEpilepConvul.setEnabled(true);
					txtEpilepConvul.setText(null);
				}
				else{
					if(cboEpilepsiaConv.getSelectedItem().equals("NAO")){
					txtEpilepConvul.setText("Nada a declarar.");
					txtEpilepConvul.setEnabled(false);
					}else{
						txtEpilepConvul.setText("Escolha uma opcao");
						txtEpilepConvul.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Escolha, SIM ou NAO!!");
					}
				}
			}
		});
		
		
		cboEpilepsiaConv.setBackground(new Color(240, 248, 255));
		cboEpilepsiaConv.setModel(new DefaultComboBoxModel(new String[] {"OPC", "SIM", "NAO"}));
		cboEpilepsiaConv.setBounds(224, 188, 65, 20);
		painelinfor.add(cboEpilepsiaConv);
		
		cboAlterPsicoPsiqui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboAlterPsicoPsiqui.getSelectedItem().equals("SIM")){
					txtAlterPsicoPsiquia.setEnabled(true);
					txtAlterPsicoPsiquia.setText(null);
				}else{
					if(cboAlterPsicoPsiqui.getSelectedItem().equals("NAO")){
					txtAlterPsicoPsiquia.setText("Nada a declarar.");
					txtAlterPsicoPsiquia.setEnabled(false);
					}else{
						txtAlterPsicoPsiquia.setText("Escolha uma opcao");
						txtAlterPsicoPsiquia.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Escolha, SIM ou NAO!!");
						
					}
				}
			}
		});
		
		
		cboAlterPsicoPsiqui.setBackground(new Color(240, 248, 255));
		cboAlterPsicoPsiqui.setModel(new DefaultComboBoxModel(new String[] {"OPC", "SIM", "NAO"}));
		cboAlterPsicoPsiqui.setBounds(276, 218, 65, 20);
		painelinfor.add(cboAlterPsicoPsiqui);
		
		cboStress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboStress.getSelectedItem().equals("SIM")){
					txtStress.setEnabled(true);
					txtStress.setText(null);
				}else{
					if(cboStress.getSelectedItem().equals("NAO")){
					txtStress.setText("Nada a declarar.");
					txtStress.setEnabled(false);
					}else{
						txtStress.setText("Escolha outra opcao");
						txtStress.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Escolha, SIM ou NAO!!");
						
					}
				}
			}
		});
		
		
		cboStress.setBackground(new Color(240, 248, 255));
		cboStress.setModel(new DefaultComboBoxModel(new String[] {"OPC", "SIM", "NAO"}));
		cboStress.setBounds(224, 244, 65, 20);
		painelinfor.add(cboStress);
		
		cboOconlogia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboOconlogia.getSelectedItem().equals("SIM")){
					txtCancerAnte.setEnabled(true);
					txtCancerAnte.setText(null);
				}else{
					if(cboOconlogia.getSelectedItem().equals("NAO")){
					txtCancerAnte.setText("Nada a declarar.");
					txtCancerAnte.setEnabled(false);
					}else{
						txtCancerAnte.setText("Escolha outra opcao");
						txtCancerAnte.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Escolha, SIM ou NAO!!");
					}
				}
			}
		});
		
		
		cboOconlogia.setBackground(new Color(240, 248, 255));
		cboOconlogia.setModel(new DefaultComboBoxModel(new String[] {"OPC", "SIM", "NAO"}));
		cboOconlogia.setBounds(224, 278, 65, 20);
		painelinfor.add(cboOconlogia);
		
		cboDiabetes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboDiabetes.getSelectedItem().equals("SIM")){
					txtDiabetes.setEnabled(true);
					txtDiabetes.setText(null);
				}else{
					if(cboDiabetes.getSelectedItem().equals("NAO")){
					txtDiabetes.setText("Nada a declarar.");
					txtDiabetes.setEnabled(false);
					}else{
						txtDiabetes.setText("Escolha outra opcao");
						txtDiabetes.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Escolha, SIM ou NAO!!");
					}
				}
			}
		});
		
		
		cboDiabetes.setBackground(new Color(240, 248, 255));
		cboDiabetes.setModel(new DefaultComboBoxModel(new String[] {"OPC", "SIM", "NAO"}));
		cboDiabetes.setBounds(224, 308, 65, 20);
		painelinfor.add(cboDiabetes);
		
		cboAlgumDoenca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboAlgumDoenca.getSelectedItem().equals("SIM")){
					txtAlgumDoenca.setEnabled(true);
					txtAlgumDoenca.setText(null);
				}else{
					if(cboAlgumDoenca.getSelectedItem().equals("NAO")){
						txtAlgumDoenca.setText("Nada a declarar.");
						txtAlgumDoenca.setEnabled(false);
					}else{
						txtAlgumDoenca.setText("Escolha uma opcao");
						txtAlgumDoenca.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Escolha, SIM ou NAO!!");
					}
				
				}
			}
		});
		
		
		cboAlgumDoenca.setBackground(new Color(240, 248, 255));
		cboAlgumDoenca.setModel(new DefaultComboBoxModel(new String[] {"OPC", "SIM", "NAO"}));
		cboAlgumDoenca.setBounds(224, 338, 65, 20);
		painelinfor.add(cboAlgumDoenca);
		
		cboMedicaUso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cboMedicaUso.getSelectedItem().equals("SIM")){
					txtMedicamUso.setEnabled(true);
					txtMedicamUso.setText(null);
				}else{
					if(cboMedicaUso.getSelectedItem().equals("SIM")){
					txtMedicamUso.setText("False");
					txtMedicamUso.setEnabled(false);
					}else{
						txtMedicamUso.setText("Escolha uma opçao.");
						txtMedicamUso.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Escolha, SIM ou NAO!!");
					}
				}
			}
		});

		cboMedicaUso.setModel(new DefaultComboBoxModel(new String[] {"OPC", "SIM", "NAO"}));
		cboMedicaUso.setBackground(new Color(240, 248, 255));
		cboMedicaUso.setBounds(224, 38, 65, 20);
		painelinfor.add(cboMedicaUso);
		
		//controle do combox
		cboTratMedicoAtual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboTratMedicoAtual.getSelectedItem().equals("SIM")){
					txtTratMeAtual.setEnabled(true);
					txtTratMeAtual.setText(null);
				}else{
					if(cboTratMedicoAtual.getSelectedItem().equals("NAO")){
					txtTratMeAtual.setText("Nada a declarar");
					txtTratMeAtual.setEnabled(false);
					
					}else{
						txtTratMeAtual.setText("Escolha uma opçao.");
						txtTratMeAtual.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Escolha, SIM ou NAO!!");
					}
				}
			}
		});
		
		
		cboTratMedicoAtual.setModel(new DefaultComboBoxModel(new String[] {"OPC", "SIM", "NAO"}));
		cboTratMedicoAtual.setBackground(new Color(240, 248, 255));
		cboTratMedicoAtual.setBounds(224, 8, 65, 20);
		painelinfor.add(cboTratMedicoAtual);
		

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.activeCaptionText);
		tabbedPane.addTab("New tab", null, desktopPane, null);
		
		ImageIcon icone = new ImageIcon(this.getClass().getResource("/br/com/clinica/image/useruser.jpg"));
		Image img = icone.getImage();
		JDesktopPane deskfundoAgenda = new JDesktopPane(){;
		/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics grafics){
			grafics.drawImage(img, 0, 0, getWidth(),getHeight(),this);
		}
	};
		deskfundoAgenda.setBackground(Color.WHITE);
		deskfundoAgenda.setBounds(0, 0, 793, 485);
		contentPane.add(deskfundoAgenda);
		
		JLabel lblFichaDeAtendimento = new JLabel("Ficha de Atendimento");
		lblFichaDeAtendimento.setBounds(319, 0, 162, 26);
		deskfundoAgenda.add(lblFichaDeAtendimento);
		lblFichaDeAtendimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_8 = new JLabel("*OPC = Op\u00E7ao de escolha");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_8.setBounds(539, 8, 148, 14);
		deskfundoAgenda.add(lblNewLabel_8);
	}
	
	private void setDadosMedico(Medico medico) {
		txtIdMedico.setText(medico.getIdMedico().toString());
		txtNomeMedicoF.setText(medico.getNome());
		txtEspecMedico.setText(medico.getEspecialidade());
		txtCpfMedicoAgenda.setText(medico.getCpfMedico());
		txtNomeMaeMedicoAgenda.setText(medico.getNomeMaeMedico());
		txtRuaMedicoAgenda.setText(medico.getNomeRuaMedico());
		txtCidadeMedicoAgenda.setText(medico.getNomeCidade());
		txtTelMedicoAgenda.setText(medico.getTelefone());
	}
	
	private void setDadosPaciente(Paciente paciente) {
		txtIdPaciente.setText(paciente.getIdpaciente().toString());
		txtNomeAgenda.setText(paciente.getNomepaciente());
		txtNomeMaeAgenda.setText(paciente.getNomemae());
		txtNomePaiAgenda.setText(paciente.getNomepai());
		txtNumAgenda.setText(paciente.getNumeroCasa());
		txtDataNascAgenda.setText(paciente.getDatanascimento());
		txtRuaAgenda.setText(paciente.getRua());
		txtCidadeAgenda.setText(paciente.getCidade());
		txtTelAgenda.setText(paciente.getFone());
	}
	
	private void cleanFields() {
		//Limpando campos
		txtIdPaciente.setText(null);
		txtFichaNome.setText(null);
		txtNomeAgenda.setText(null);
		txtNomePaiAgenda.setText(null);
		txtNomeMaeAgenda.setText(null);
		txtDataNascAgenda.setText(null);
		txtRuaAgenda.setText(null);
		txtCidadeAgenda.setText(null);
		txtTelAgenda.setText(null);

	}
	private void saveConsultaDba(Agenda agenda) {
		
		//seta combobox
		agenda.setTratamentomedico(cboTratMedicoAtual.getSelectedItem().toString());
		agenda.setMedicamentouso(cboMedicaUso.getSelectedItem().toString());
		agenda.setMarcapasso(cboMarcapasso.getSelectedItem().toString());
		agenda.setAlteracaocardio(cboAlterCardiacos.getSelectedItem().toString());
		agenda.setHiparterial(cboHipoHiper.getSelectedItem().toString());
		agenda.setAlgumdisturbio(cboDisturbio.getSelectedItem().toString());
		agenda.setEpilepsia(cboEpilepsiaConv.getSelectedItem().toString());
		agenda.setPsicpsiqui(cboAlterPsicoPsiqui.getSelectedItem().toString());
		agenda.setStress(cboStress.getSelectedItem().toString());
		agenda.setOncologo(cboOconlogia.getSelectedItem().toString());
		agenda.setDiabete(cboDiabetes.getSelectedItem().toString());
		agenda.setAlgumdoenca(cboAlgumDoenca.getSelectedItem().toString());
		//seta campos
		agenda.setCampoTratamentoMedico(txtTratMeAtual.getText());
		agenda.setCampoMedicamentoUso(txtMedicamUso.getText());
		agenda.setCampomMarcapasso(txtPortaMarcapasso.getText());
		agenda.setCampoAlteracaoCardio(txtAlterCardi.getText());
		agenda.setCampoHipArterial(txtHipertensao.getText());
		agenda.setCampoAlgumDisturbio(txtDisturbio.getText());
		agenda.setCampoepilepsia(txtEpilepConvul.getText());
		agenda.setCampoPsicPsiqui(txtAlterPsicoPsiquia.getText());
		agenda.setCampoStress(txtStress.getText());
		agenda.setCampoOncologo(txtCancerAnte.getText());
		agenda.setCampoDiabete(txtDiabetes.getText());
		agenda.setCampoAlgumDoenca(txtAlgumDoenca.getText());

	
	}
}
