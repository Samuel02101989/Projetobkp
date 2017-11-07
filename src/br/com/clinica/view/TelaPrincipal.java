package br.com.clinica.view;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import br.com.clinica.jasperClass.Relatorios;
import br.com.clinica.model.Paciente;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.Font;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/br/com/clinica/image/hospital.png")));
		setTitle("Clinica Santa Maria");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		setVisible(true);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSobre = new JMenu("Cadastro");
		menuBar.add(mnSobre);
		
		JMenuItem mntmMedico = new JMenuItem("Medico");
		mntmMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormularioMedico medico = new FormularioMedico();
				medico.setVisible(true);
			}
		});
		mnSobre.add(mntmMedico);
		
		JMenuItem mntmPaciente = new JMenuItem("Paciente");
		mntmPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormularioPaciente paciente = new FormularioPaciente();
				paciente.setVisible(true);
			}
		});
		mnSobre.add(mntmPaciente);
		
		JMenuItem mntmUsuario = new JMenuItem("Usuario");
		mntmUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormularioUsuario usuario = new FormularioUsuario();
				usuario.setVisible(true);
			}
		});
		
		mnSobre.add(mntmUsuario);
		
		JMenuItem mntmAgenda = new JMenuItem("Agenda");
		mntmAgenda.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				FormularioAgenda agenda = new FormularioAgenda();
				agenda.setVisible(true);
			}
		});
		mnSobre.add(mntmAgenda);
		
		JMenu mnRelarotio = new JMenu("Relatorio");
		menuBar.add(mnRelarotio);
		
		JMenuItem mntmDiario = new JMenuItem("Medicos");
		mnRelarotio.add(mntmDiario);
		
		JMenuItem mntmMensal = new JMenuItem("Pacientes");
		mntmMensal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int conf;
				conf = JOptionPane.showConfirmDialog(null, "Gerar relatorio?", "Atençao", JOptionPane.YES_NO_OPTION);
				if(conf == JOptionPane.YES_OPTION){
					
				try {
					
					List<Paciente> pacientes = new ArrayList<Paciente>();
					
					Relatorios relatorio = new Relatorios();
					relatorio.imprimir(pacientes);
					
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e);
				}
				
				}else{
					JOptionPane.showMessageDialog(null, "erro");
				}
			
		  }
		});
		mnRelarotio.add(mntmMensal);
		
		JMenuItem mntmAnual = new JMenuItem("Usuarios");
		mnRelarotio.add(mntmAnual);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenu mnSobre_1 = new JMenu("Sobre");
		menuBar.add(mnSobre_1);
		
		JMenuItem mntmSistemaclinica = new JMenuItem("O Sistema");
		mntmSistemaclinica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaSobre sobre = new TelaSobre();
				sobre.setVisible(true);
				
			}
		});
		mnSobre_1.add(mntmSistemaclinica);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
			}
		});
		mnSobre_1.add(mntmSair);
		getContentPane().setLayout(null);
		
//		mundando background do desktoppainel e redimessionando todo espaço
		
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/br/com/clinica/image/java.jpg"));
		Image img = icon.getImage();
		JDesktopPane desktopPane = new JDesktopPane(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				g.drawImage(img, 0, 0, getWidth(),getHeight(),this);
			}
		};
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(0, 0, 1400, 800);
		getContentPane().add(desktopPane);
		
		
		JLabel lbllogo = new JLabel("");
		lbllogo.setFocusable(false);
		lbllogo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/clinica/image/LogoClinica.PNG")));
		lbllogo.setBounds(465, 252, 418, 212);
		desktopPane.add(lbllogo);
		
		JCalendar calendar = new JCalendar();
		calendar.setDecorationBackgroundColor(Color.WHITE);
		calendar.setBackground(new Color(135, 206, 250));
		calendar.setBounds(1165, 0, 200, 153);
		desktopPane.add(calendar);
		
		JLabel lblNewLabel = new JLabel("Calendario atualizado");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(1190, 180, 148, 31);
		desktopPane.add(lblNewLabel);
	}
	}


