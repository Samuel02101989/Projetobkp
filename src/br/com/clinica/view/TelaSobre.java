package br.com.clinica.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Font;

public class TelaSobre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSobre frame = new TelaSobre();
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
	public TelaSobre() {
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSobre.class.getResource("/br/com/clinica/image/icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(0, 0, 641, 373);
		contentPane.add(desktopPane);
		
		JLabel lblNewLabel_1 = new JLabel("Sistema de Gerenciamento Clinico");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(80, 37, 293, 40);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblNovembro = new JLabel("Novembro 2017");
		lblNovembro.setForeground(Color.BLACK);
		lblNovembro.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNovembro.setBounds(535, 322, 96, 40);
		desktopPane.add(lblNovembro);
		
		JLabel label = new JLabel("Desenvolvido por @SFTechnology Systems");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.ITALIC, 12));
		label.setBounds(80, 197, 254, 40);
		desktopPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(442, 0, 150, 252);
		desktopPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(TelaSobre.class.getResource("/br/com/clinica/image/GNU icon.png")));
		
		JLabel lblSamuelOliveira = new JLabel("Responsavel: Samuel Oliveira");
		lblSamuelOliveira.setForeground(Color.BLACK);
		lblSamuelOliveira.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblSamuelOliveira.setBounds(80, 126, 232, 40);
		desktopPane.add(lblSamuelOliveira);
		
		JLabel lblSobLincenaGpl = new JLabel("Sob Lincen\u00E7a GPL");
		lblSobLincenaGpl.setForeground(Color.BLACK);
		lblSobLincenaGpl.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblSobLincenaGpl.setBounds(80, 162, 232, 40);
		desktopPane.add(lblSobLincenaGpl);
	}
}
