import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Toolkit;

public class principalView extends JFrame {

	private JPanel contentPane;
	private JButton logoutButton;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principalView frame = new principalView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public principalView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(principalView.class.getResource("/images/dientesin200.png")));
		setTitle("Odontolog");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 650, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{43, 130, 214, 130, 0};
		gbl_contentPane.rowHeights = new int[]{0, 86, 0, 73, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		setResizable(false);
		
		
		JButton btnAdmin = new JButton("");
		btnAdmin.setOpaque(true);
		btnAdmin.setBorder(null);
		btnAdmin.setPressedIcon(new ImageIcon(principalView.class.getResource("/images/adminPress.png")));
		Color c = UIManager.getLookAndFeel().getDefaults().getColor( "Panel.background");
		btnAdmin.setBackground(new Color(c.getRed(), c.getGreen(), c.getBlue()));
		btnAdmin.setIcon(new ImageIcon(principalView.class.getResource("/images/admin.png")));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnHistoria = new JButton("");
		btnHistoria.setOpaque(true);
		btnHistoria.setBorder(null);
		btnHistoria.setPressedIcon(new ImageIcon(principalView.class.getResource("/images/historiaPress.png")));
		Color b = UIManager.getLookAndFeel().getDefaults().getColor( "Panel.background");
		btnHistoria.setBackground(new Color(b.getRed(), b.getGreen(), b.getBlue()));
		btnHistoria.setHorizontalAlignment(SwingConstants.LEADING);
		btnHistoria.setIcon(new ImageIcon(principalView.class.getResource("/images/historia.png")));
		btnHistoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnAgenda = new JButton("");
		btnAgenda.setOpaque(true);
		btnAgenda.setBorder(null);
		btnAgenda.setPressedIcon(new ImageIcon(principalView.class.getResource("/images/agendaPress.png")));
		Color a = UIManager.getLookAndFeel().getDefaults().getColor( "Panel.background");
		btnAdmin.setBackground(new Color(a.getRed(), a.getGreen(), a.getBlue()));
		btnAgenda.setBackground(new Color(255, 255, 255));
		btnAgenda.setIcon(new ImageIcon(principalView.class.getResource("/images/agenda.png")));
		btnAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnAgenda = new GridBagConstraints();
		gbc_btnAgenda.fill = GridBagConstraints.BOTH;
		gbc_btnAgenda.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgenda.gridx = 1;
		gbc_btnAgenda.gridy = 1;
		contentPane.add(btnAgenda, gbc_btnAgenda);
		GridBagConstraints gbc_btnHistoria = new GridBagConstraints();
		gbc_btnHistoria.insets = new Insets(0, 0, 5, 5);
		gbc_btnHistoria.gridx = 2;
		gbc_btnHistoria.gridy = 1;
		contentPane.add(btnHistoria, gbc_btnHistoria);
		GridBagConstraints gbc_btnAdmin = new GridBagConstraints();
		gbc_btnAdmin.fill = GridBagConstraints.BOTH;
		gbc_btnAdmin.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdmin.gridx = 3;
		gbc_btnAdmin.gridy = 1;
		contentPane.add(btnAdmin, gbc_btnAdmin);
		
		logoutButton = new JButton("Log Out");
		logoutButton.setBackground(SystemColor.inactiveCaption);
		logoutButton.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel = new JLabel("Agenda de Turnos");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblHistoriaClinica = new JLabel("Historia Clinica");
		lblHistoriaClinica.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		GridBagConstraints gbc_lblHistoriaClinica = new GridBagConstraints();
		gbc_lblHistoriaClinica.insets = new Insets(0, 0, 5, 5);
		gbc_lblHistoriaClinica.gridx = 2;
		gbc_lblHistoriaClinica.gridy = 2;
		contentPane.add(lblHistoriaClinica, gbc_lblHistoriaClinica);
		
		JLabel lblAdministracion = new JLabel("Administracion");
		lblAdministracion.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		GridBagConstraints gbc_lblAdministracion = new GridBagConstraints();
		gbc_lblAdministracion.insets = new Insets(0, 0, 5, 0);
		gbc_lblAdministracion.gridx = 3;
		gbc_lblAdministracion.gridy = 2;
		contentPane.add(lblAdministracion, gbc_lblAdministracion);
		GridBagConstraints gbc_logoutButton = new GridBagConstraints();
		gbc_logoutButton.insets = new Insets(0, 0, 0, 5);
		gbc_logoutButton.gridx = 2;
		gbc_logoutButton.gridy = 4;
		contentPane.add(logoutButton, gbc_logoutButton);
	}
	
	void addLogoutListener(ActionListener listenLogout){
		logoutButton.addActionListener(listenLogout);
	}
}
