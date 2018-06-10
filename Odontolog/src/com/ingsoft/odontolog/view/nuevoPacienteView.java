package com.ingsoft.odontolog.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class nuevoPacienteView extends JFrame {

	private JPanel contentPane;
	private JTextField nombreField;
	private JTextField apellidoField;
	private JTextField dniField;
	private JTextField direccionField;
	private JTextField medicoCabeceraField;
	private JTextField alturaField;
	private JTextField obraSocialField;
	private JTextField mailField;
	private JTextField numOSField;
	private JTextField telefonoField;
	private JTextField pesoField;
	private JComboBox factorSang;
	private JButton btnAgregar;
	private JButton btnCancelar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nuevoPacienteView frame = new nuevoPacienteView();
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
	public nuevoPacienteView() {
		setTitle("Agregar Paciente");
		this.setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(nuevoPacienteView.class.getResource("/images/dientesin200.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 811, 597);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblAgregarNuevoPaciente = new JLabel("Agregar nuevo paciente");
		lblAgregarNuevoPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarNuevoPaciente.setBackground(new Color(100, 149, 237));
		lblAgregarNuevoPaciente.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		panel.add(lblAgregarNuevoPaciente, BorderLayout.CENTER);
		
		JPanel panelNombre = new JPanel();
		panelNombre.setBackground(SystemColor.activeCaption);
		panelNombre.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNombres = new JLabel("Nombre/s:");
		panelNombre.add(lblNombres, BorderLayout.WEST);
		
		nombreField = new JTextField();
		panelNombre.add(nombreField, BorderLayout.SOUTH);
		nombreField.setColumns(10);
		
		JPanel panelApellido = new JPanel();
		panelApellido.setBackground(SystemColor.activeCaption);
		panelApellido.setLayout(new BorderLayout(0, 0));
		
		JLabel lblApellidos = new JLabel("Apellido/s:");
		panelApellido.add(lblApellidos, BorderLayout.WEST);
		
		apellidoField = new JTextField();
		apellidoField.setColumns(10);
		panelApellido.add(apellidoField, BorderLayout.SOUTH);
		
		JPanel panelDNI = new JPanel();
		panelDNI.setBackground(SystemColor.activeCaption);
		panelDNI.setLayout(new BorderLayout(0, 0));
		
		JLabel lblId = new JLabel("ID:");
		panelDNI.add(lblId, BorderLayout.WEST);
		
		dniField = new JTextField();
		dniField.setColumns(10);
		panelDNI.add(dniField, BorderLayout.SOUTH);
		
		JPanel panelDireccion = new JPanel();
		panelDireccion.setBackground(SystemColor.activeCaption);
		panelDireccion.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDireccion = new JLabel("Direccion:");
		panelDireccion.add(lblDireccion, BorderLayout.WEST);
		
		direccionField = new JTextField();
		direccionField.setColumns(10);
		panelDireccion.add(direccionField, BorderLayout.SOUTH);
		
		JPanel panelNacimiento = new JPanel();
		panelNacimiento.setBackground(SystemColor.activeCaption);
		panelNacimiento.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		panelNacimiento.add(lblFechaDeNacimiento, BorderLayout.WEST);
		
		JPanel panelMedico = new JPanel();
		panelMedico.setBackground(SystemColor.activeCaption);
		panelMedico.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTelefono = new JLabel("Medico de cabecera:");
		panelMedico.add(lblTelefono, BorderLayout.WEST);
		
		medicoCabeceraField = new JTextField();
		medicoCabeceraField.setColumns(10);
		panelMedico.add(medicoCabeceraField, BorderLayout.SOUTH);
		
		JPanel panelAltura = new JPanel();
		panelAltura.setBackground(SystemColor.activeCaption);
		panelAltura.setLayout(new BorderLayout(0, 0));
		
		JLabel lblAltura = new JLabel("Altura:");
		panelAltura.add(lblAltura, BorderLayout.WEST);
		
		alturaField = new JTextField();
		alturaField.setColumns(10);
		panelAltura.add(alturaField, BorderLayout.SOUTH);
		
		JPanel panelOS = new JPanel();
		panelOS.setBackground(SystemColor.activeCaption);
		panelOS.setLayout(new BorderLayout(0, 0));
		
		JLabel lblObraSocial = new JLabel("Obra Social:");
		panelOS.add(lblObraSocial, BorderLayout.WEST);
		
		obraSocialField = new JTextField();
		obraSocialField.setColumns(10);
		panelOS.add(obraSocialField, BorderLayout.SOUTH);
		
		JPanel panelMail = new JPanel();
		panelMail.setBackground(SystemColor.activeCaption);
		panelMail.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMail = new JLabel("Mail:");
		panelMail.add(lblMail, BorderLayout.WEST);
		
		mailField = new JTextField();
		mailField.setColumns(10);
		panelMail.add(mailField, BorderLayout.SOUTH);
		
		JPanel panelNumOS = new JPanel();
		panelNumOS.setBackground(SystemColor.activeCaption);
		panelNumOS.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNmeroDeObra = new JLabel("N\u00FAmero de obra social:");
		panelNumOS.add(lblNmeroDeObra, BorderLayout.WEST);
		
		numOSField = new JTextField();
		numOSField.setColumns(10);
		panelNumOS.add(numOSField, BorderLayout.SOUTH);
		
		JPanel panelFoto = new JPanel();
		panelFoto.setBackground(SystemColor.inactiveCaption);
		
		JPanel panelTelefono = new JPanel();
		panelTelefono.setBackground(SystemColor.activeCaption);
		panelTelefono.setLayout(new BorderLayout(0, 0));
		
		JPanel panelAgregar = new JPanel();
		panelAgregar.setBackground(SystemColor.inactiveCaption);
		
		JPanel panelCancelar = new JPanel();
		panelCancelar.setBackground(SystemColor.inactiveCaption);
		panelCancelar.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPeso = new JPanel();
		panelPeso.setBackground(SystemColor.activeCaption);
		panelPeso.setLayout(new BorderLayout(0, 0));
		
		JPanel panelFactor = new JPanel();
		panelFactor.setBackground(SystemColor.activeCaption);
		panelFactor.setLayout(new BorderLayout(0, 0));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(panelNombre, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
											.addComponent(panelApellido, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
											.addComponent(panelDireccion, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
											.addComponent(panelDNI, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
										.addComponent(panelNacimiento, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
									.addComponent(panelOS, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
								.addComponent(panelMedico, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelNumOS, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelFoto, GroupLayout.PREFERRED_SIZE, 252, Short.MAX_VALUE)
						.addComponent(panelTelefono, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
						.addComponent(panelMail, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelAltura, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(panelPeso, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panelFactor, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
					.addGap(35)
					.addComponent(panelAgregar, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelCancelar, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(129))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(602, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelAgregar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelCancelar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(panelNombre, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(panelApellido, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(panelDireccion, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(panelDNI, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(panelNacimiento, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(panelOS, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(panelFoto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(panelMail, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(panelMedico, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addComponent(panelAltura, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addComponent(panelPeso, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addComponent(panelFactor, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(panelTelefono, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addComponent(panelNumOS, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))))
					.addGap(18))
		);
		
		JLabel lblPeso_1 = new JLabel("Peso:");
		panelPeso.add(lblPeso_1, BorderLayout.WEST);
		
		pesoField = new JTextField();
		pesoField.setColumns(10);
		panelPeso.add(pesoField, BorderLayout.SOUTH);
		
		JLabel lblPeso = new JLabel("Factor:");
		panelFactor.add(lblPeso, BorderLayout.WEST);
		
		factorSang = new JComboBox();
		panelFactor.add(factorSang, BorderLayout.SOUTH);
		factorSang.setModel(new DefaultComboBoxModel(new String[] {"0-", "0+", "A-", "A+", "B-", "B+", "AB-", "AB+"}));
		
		btnCancelar = new JButton("");
		panelCancelar.add(btnCancelar, BorderLayout.CENTER);
		btnCancelar.setBounds(120, 0, 50, 50);
		btnCancelar.setIcon(new ImageIcon(adminView.class.getResource("/images/subtract.png")));
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(SystemColor.inactiveCaption);
		
		JLabel lblCancelar = new JLabel("Cancelar");
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		lblCancelar.setBackground(SystemColor.activeCaption);
		panelCancelar.add(lblCancelar, BorderLayout.SOUTH);
		panelAgregar.setLayout(new BorderLayout(0, 0));
		
		btnAgregar = new JButton("");
		panelAgregar.add(btnAgregar, BorderLayout.CENTER);
		btnAgregar.setBounds(0, 0, 50, 50);
		btnAgregar.setBorder(null);
		btnAgregar.setIcon(new ImageIcon(adminView.class.getResource("/images/add.png")));
		btnAgregar.setBackground(SystemColor.inactiveCaption);
		
		JLabel lblAgregar = new JLabel("Agregar");
		lblAgregar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregar.setBackground(SystemColor.activeCaption);
		panelAgregar.add(lblAgregar, BorderLayout.SOUTH);
		lblAgregar.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		
		JLabel lblMedicoDeCabecera = new JLabel("Telefono:");
		panelTelefono.add(lblMedicoDeCabecera, BorderLayout.WEST);
		
		telefonoField = new JTextField();
		telefonoField.setColumns(10);
		panelTelefono.add(telefonoField, BorderLayout.SOUTH);
		panelFoto.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panelFoto.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnFoto = new JButton("Agregar Foto");
		btnFoto.setEnabled(false);
		panel_2.add(btnFoto);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(nuevoPacienteView.class.getResource("/images/profilePic.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//lblNewLabel.setIcon(new ImageIcon(nuevoPacienteView.class.getResource("/images/fotoPerfil.png")));
		panelFoto.add(lblNewLabel, BorderLayout.NORTH);
		
		JDateChooser dateChooser = new JDateChooser();
		panelNacimiento.add(dateChooser, BorderLayout.SOUTH);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void addNuevoPacienteListener (ActionListener nuevoPacienteListener) {
		btnAgregar.addActionListener(nuevoPacienteListener);
		btnCancelar.addActionListener(nuevoPacienteListener);
	}
	
//	public void addCancelListener (ActionListener cancelListener) {
//		btnCancelar.addActionListener(cancelListener);
//	}
	
	public JButton getAddButton(){
		return btnAgregar;
	}
	public JButton getCancelButton(){
		return btnCancelar;
	}
	
	public String getNombre() {
		return nombreField.getText();
	}
	
	public String getApellido() {
		return apellidoField.getText();
	}
	
	public String getDni() {
		return dniField.getText();
	}
	
	public String getDireccion() {
		return direccionField.getText();
	}
	
	public String getMedicoCabecera() {
		return medicoCabeceraField.getText();
	}
	
	public String getAltura() {
		return alturaField.getText();
	}
	
	public String getObraSocial() {
		return obraSocialField.getText();
	}
	
	public String getMail() {
		return mailField.getText();
	}
	
	public String getNumOSi() {
		return numOSField.getText();
	}
	
	public String getTelefono() {
		return telefonoField.getText();
	}
	
	public String getPeso() {
		return pesoField.getText();
	}
	
	public String getFactor() {
		return factorSang.getSelectedItem().toString();
	}
	
}

