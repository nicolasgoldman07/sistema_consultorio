import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;

import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Toolkit;


public class loginView extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField userField;
	private JTextField txtOdontolog;
	private JButton loginButton;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginView frame = new loginView();
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
	public loginView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(loginView.class.getResource("/images/dientesin200.png")));
		setResizable(false);
		setTitle("Odontolog");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 650, 400);								// los primeros dos son de ubicacion en pantalla
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 286, 214);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtOdontolog = new JTextField();
		txtOdontolog.setBackground(SystemColor.inactiveCaption);
		txtOdontolog.setText("ODONTOLOG");
		txtOdontolog.setBounds(92, 223, 141, 46);
		panel.add(txtOdontolog);
		txtOdontolog.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 286, 212);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(loginView.class.getResource("/images/dientesin200.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(285, 0, 382, 245);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(SystemColor.activeCaption);
		passwordField.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		passwordField.setBounds(22, 189, 208, 20);
		panel_1.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblPassword.setBounds(22, 158, 83, 20);
		panel_1.add(lblPassword);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.textHighlight);
		separator.setBounds(22, 209, 208, 2);
		panel_1.add(separator);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblUser.setBounds(22, 79, 46, 14);
		panel_1.add(lblUser);
		
		userField = new JTextField();
		userField.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		userField.setBackground(SystemColor.activeCaption);
		userField.setBounds(22, 104, 208, 20);
		panel_1.add(userField);
		userField.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.textHighlight);
		separator_1.setBounds(22, 123, 208, 2);
		panel_1.add(separator_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(285, 243, 359, 134);
		contentPane.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		loginButton = new JButton("Log In");
		loginButton.setBackground(SystemColor.inactiveCaption);
		loginButton.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.gridheight = 3;
		gbc_loginButton.gridwidth = 10;
		gbc_loginButton.insets = new Insets(0, 0, 0, 5);
		gbc_loginButton.gridx = 0;
		gbc_loginButton.gridy = 0;
		panel_2.add(loginButton, gbc_loginButton);

		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel_3.setBounds(0, 214, 286, 64);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ODONTOLOG");
		lblNewLabel_1.setForeground(SystemColor.window);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 286, 64);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.inactiveCaption);
		panel_4.setBounds(0, 278, 286, 99);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Dental Software");
		lblNewLabel_2.setForeground(SystemColor.desktop);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setBounds(0, 0, 286, 88);
		panel_4.add(lblNewLabel_2);
	}
	
	public String getUser(){
		return userField.getText();
	}
	
	public char[] getPass(){
		return passwordField.getPassword();
	}
	
	void addLoginListener(ActionListener listenLogin){
		loginButton.addActionListener(listenLogin);
		passwordField.addActionListener(listenLogin);
		userField.addActionListener(listenLogin);
	}
	
	void clearLogin(){
		userField.setText("");
		passwordField.setText("");
	}
	
	void displayErrorMessage(String msg){
		
		JOptionPane.showMessageDialog(this, msg);
		
	}
}
