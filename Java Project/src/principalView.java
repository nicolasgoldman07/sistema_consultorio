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
import java.awt.FlowLayout;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

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
		setResizable(false);
		Color c = UIManager.getLookAndFeel().getDefaults().getColor( "Panel.background");
		Color b = UIManager.getLookAndFeel().getDefaults().getColor( "Panel.background");
		Color a = UIManager.getLookAndFeel().getDefaults().getColor( "Panel.background");
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 215, 371);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAgenda = new JButton("");
		btnAgenda.setBounds(32, 96, 151, 151);
		panel.add(btnAgenda);
		btnAgenda.setOpaque(true);
		btnAgenda.setBorder(new LineBorder(new Color(51, 51, 204), 6, true));
		btnAgenda.setPressedIcon(new ImageIcon(principalView.class.getResource("/images/agendaPress.png")));
		btnAgenda.setBackground(Color.WHITE);
		btnAgenda.setIcon(new ImageIcon(principalView.class.getResource("/images/agenda.png")));
		btnAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel = new JLabel("Agenda de Turnos");
		lblNewLabel.setBounds(0, 258, 215, 22);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(215, 0, 215, 296);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnHistoria = new JButton("");
		btnHistoria.setForeground(SystemColor.activeCaption);
		btnHistoria.setBounds(32, 96, 151, 151);
		panel_1.add(btnHistoria);
		btnHistoria.setOpaque(true);
		btnHistoria.setBorder(new LineBorder(new Color(255, 51, 0), 6, true));
		btnHistoria.setPressedIcon(new ImageIcon(principalView.class.getResource("/images/historiaPress.png")));
		btnHistoria.setBackground(new Color(255, 51, 0));
		btnHistoria.setHorizontalAlignment(SwingConstants.LEADING);
		btnHistoria.setIcon(new ImageIcon(principalView.class.getResource("/images/historia.png")));
		btnHistoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblHistoriaClinica = new JLabel("Historia Clinica");
		lblHistoriaClinica.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistoriaClinica.setBounds(0, 258, 215, 22);
		panel_1.add(lblHistoriaClinica);
		lblHistoriaClinica.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(432, 0, 215, 371);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		JButton btnAdmin = new JButton("");
		btnAdmin.setForeground(SystemColor.activeCaption);
		btnAdmin.setBounds(32, 96, 151, 151);
		panel_2.add(btnAdmin);
		btnAdmin.setOpaque(true);
		btnAdmin.setBorder(new LineBorder(new Color(102, 204, 102), 6, true));
		btnAdmin.setPressedIcon(new ImageIcon(principalView.class.getResource("/images/adminPress.png")));
		btnAdmin.setBackground(new Color(c.getRed(), c.getGreen(), c.getBlue()));
		btnAdmin.setIcon(new ImageIcon(principalView.class.getResource("/images/admin.png")));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdmin.setBackground(new Color(a.getRed(), a.getGreen(), a.getBlue()));
		
		JLabel lblAdministracion = new JLabel("Administracion");
		lblAdministracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministracion.setBounds(0, 258, 215, 22);
		panel_2.add(lblAdministracion);
		lblAdministracion.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		
		logoutButton = new JButton("Log Out");
		logoutButton.setBounds(251, 317, 144, 31);
		contentPane.add(logoutButton);
		logoutButton.setBackground(SystemColor.inactiveCaption);
		logoutButton.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	
	void addLogoutListener(ActionListener listenLogout){
		logoutButton.addActionListener(listenLogout);
	}
}
