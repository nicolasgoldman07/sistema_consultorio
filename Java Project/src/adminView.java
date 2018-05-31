import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class adminView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminView frame = new adminView();
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
	public adminView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		
        //Contenedor/Panel General
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Panel titulo
		JPanel panel = new JPanel();
		panel.setBounds(82, 0, 1288, 77);
		panel.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Etiqueta de titulo
		JLabel lblNewLabel = new JLabel("Administración");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 502, 71);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 48));
		
		//Panel boton "Atras"
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 84, 77);
		panel_1.setBackground(SystemColor.activeCaption);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//Boton "Atras"
		JButton backButton = new JButton("ATRAS");
		backButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 11));
		backButton.setForeground(SystemColor.activeCaptionText);
		backButton.setBackground(SystemColor.activeCaption);
	    backButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	    backButton.setHorizontalTextPosition(SwingConstants.CENTER);
		backButton.setIcon(new ImageIcon(adminView.class.getResource("/images/espalda.png")));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		backButton.setBounds(0, 0, 84, 77);
		panel_1.add(backButton);
		
		//Etiqueta "Atras"
		JLabel lblAtras = new JLabel("ATRAS");
		lblAtras.setBounds(0, 63, 62, 14);
		panel_1.add(lblAtras);
		lblAtras.setForeground(SystemColor.desktop);
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		//Panel de pestañas
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.inactiveCaption);
		tabbedPane.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		tabbedPane.setBounds(240, 113, 1120, 576);
		contentPane.add(tabbedPane);
		
		/*//Pestaña "Asistencia"
		JPanel asist = new JPanel();
		tabbedPane.addTab("Asistencia", null, asist, null);
		*/
		
		//Pestaña "Posicion Consolidada"
		JPanel posCons = new JPanel();
		tabbedPane.addTab("Posicion Consolidada", null, posCons, null);
		posCons.setLayout(null);
		
		//Panel general de la pestaña "Posicion Consolidada"
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 40, 1095, 95);
		posCons.add(panel_3);
		panel_3.setLayout(null);
		
		//Etiqueta "$"
		JLabel label = new JLabel("$");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 75));
		label.setBounds(0, 0, 100, 95);
		panel_3.add(label);
		
		//Texto de Saldo final
		JLabel lblNewLabel_2 = new JLabel("16.000");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 75));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(100, 0, 795, 95);
		panel_3.add(lblNewLabel_2);
		
		//Panel para etiqueta "Saldo"
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 0, 270, 40);
		posCons.add(panel_4);
		panel_4.setLayout(null);
		
		//Etiqueta "Saldo"
		JLabel lblNewLabel_3 = new JLabel("Saldo");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 35));
		lblNewLabel_3.setBounds(25, 0, 245, 40);
		panel_4.add(lblNewLabel_3);
		
		//Panel para Headers de la tabla
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 145, 895, 40);
		posCons.add(panel_5);
		panel_5.setLayout(null);
		
		//Header "Tratamiento"
		JLabel lblNewLabel_4 = new JLabel("Tratamiento");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(0, 0, 725, 40);
		panel_5.add(lblNewLabel_4);
		
		//Header "Importe"
		JLabel lblNewLabel_5 = new JLabel("Importe");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(725, 0, 150, 40);
		panel_5.add(lblNewLabel_5);
		
		//Tabla para tratamiento e importe
		JTable table2 = new JTable();
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table2.setRowSelectionAllowed(false);
		table2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		table2.setBackground(SystemColor.activeCaption);
		table2.setModel(new DefaultTableModel(
			new Object[][] {
				{new String ("Extracción Premolar"), new Integer(-2500)},
				{new String ("Limpieza bucal"), new Integer(-500)},
				{new String ("Depósito"), new Integer(10000)}, 
				{null, null},
				{null, null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				
			},
			new String[] {"", ""}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			
			boolean[] columnEditables = new boolean[] {
				false
				};
			
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table2.getColumnModel().getColumn(0).setPreferredWidth(650);
				
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table2.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				
		//Panel con scroll para la tabla de tratamientos e importe
		JScrollPane scrollPane_1 = new JScrollPane(table2);
		scrollPane_1.setBounds(10, 185, 895, 345);
		posCons.add(scrollPane_1);
		Color b = UIManager.getLookAndFeel().getDefaults().getColor( "Panel.background");
		
		//Panel Botonera
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(935, 481, 170, 50);
		posCons.add(panel_6);
		panel_6.setLayout(null);
		
		
		//Boton Agregar
		JButton btnAdd = new JButton("");
		btnAdd.setBounds(0, 0, 50, 50);
		panel_6.add(btnAdd);
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(b.getRed(), b.getGreen(), b.getBlue()));
		btnAdd.setHorizontalAlignment(SwingConstants.LEADING);
		btnAdd.setIcon(new ImageIcon(adminView.class.getResource("/images/add.png")));
		
		//Boton Quitar
		JButton btnSub = new JButton("");
		btnSub.setBounds(120, 0, 50, 50);
		panel_6.add(btnSub);
		btnSub.setIcon(new ImageIcon(adminView.class.getResource("/images/subtract.png")));
		btnSub.setHorizontalAlignment(SwingConstants.LEADING);
		btnSub.setBorder(null);
		btnSub.setBackground(SystemColor.menu);
		
		//Boton Edit
		JButton btnEdit = new JButton("");
		btnEdit.setBounds(60, 0, 50, 50);
		panel_6.add(btnEdit);
		btnEdit.setIcon(new ImageIcon(adminView.class.getResource("/images/edit.png")));
		btnEdit.setHorizontalAlignment(SwingConstants.LEADING);
		btnEdit.setBorder(null);
		btnEdit.setBackground(SystemColor.menu);
		
		
		
		//Pestaña "Impresion"
		JPanel impr = new JPanel();
		tabbedPane.addTab("Impresion", null, impr, null);
		impr.setLayout(null);
		

		//Tabla de Pacientes
		JTable table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		table.setBackground(SystemColor.activeCaption);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{new String ("Arce Giacobbe, Alejandro")},
				{new String ("Drudi, Leandro")},
				{new String ("Goldman, Nicolas")},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				
			},
			new String[] {""}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			
			boolean[] columnEditables = new boolean[] {
				false
				};
			
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		DefaultTableCellRenderer rendere = new DefaultTableCellRenderer();
		rendere.setToolTipText("Doble click para seleccionar paciente");
		table.getColumnModel().getColumn(0).setCellRenderer(rendere);

		//Panel con scroll para Pacientes
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 144, 227, 545);
		contentPane.add(scrollPane);
		
		//Panel para etiqueta Pacientes		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 101, 227, 37);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		//Etiqueta "Pacientes"
		JLabel lblNewLabel_1 = new JLabel("Pacientes");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 27));
		lblNewLabel_1.setBounds(0, 0, 227, 37);
		panel_2.add(lblNewLabel_1);
	}
}
