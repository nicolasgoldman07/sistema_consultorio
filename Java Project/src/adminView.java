import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.ComponentOrientation;

public class adminView extends JFrame {

	private JPanel contentPane;
	private JButton backButton;
	private JPanel panel_1;
	private JScrollPane scrollPacientes;
	private DefaultTableModel tableDModel;
	private JTable tablePacientes;

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
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(82, 0, 1288, 77);
		panel.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administración");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 502, 71);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 48));
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 84, 77);
		panel_1.setBackground(SystemColor.activeCaption);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		backButton = new JButton("ATRAS");
		backButton.setIcon(new ImageIcon(adminView.class.getResource("/images/espalda.png")));
		backButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 11));
		backButton.setForeground(SystemColor.activeCaptionText);
		backButton.setBackground(SystemColor.activeCaption);
	    backButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	    backButton.setHorizontalTextPosition(SwingConstants.CENTER);
		//backButton.setIcon(new ImageIcon(AgendaDeTurnos.class.getResource("/images/espalda.png")));
		backButton.setBounds(0, 0, 84, 77);
		panel_1.add(backButton);
		
		JLabel lblAtras = new JLabel("ATRAS");
		lblAtras.setBounds(0, 63, 62, 14);
		panel_1.add(lblAtras);
		lblAtras.setForeground(SystemColor.desktop);
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.inactiveCaption);
		tabbedPane.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		tabbedPane.setBounds(240, 113, 1120, 576);
		contentPane.add(tabbedPane);
		
		JPanel asist = new JPanel();
		tabbedPane.addTab("Asistencia", null, asist, null);
		
		JPanel posCons = new JPanel();
		tabbedPane.addTab("Posicion Consolidada", null, posCons, null);
		posCons.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 40, 1095, 95);
		posCons.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label = new JLabel("$");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 75));
		label.setBounds(0, 0, 100, 95);
		panel_3.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("16.000");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 75));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(100, 0, 1015, 95);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 0, 270, 40);
		posCons.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Saldo");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 35));
		lblNewLabel_3.setBounds(25, 0, 245, 40);
		panel_4.add(lblNewLabel_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 145, 1095, 40);
		posCons.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Tratamiento");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(0, 0, 925, 40);
		panel_5.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Monto");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(925, 0, 150, 40);
		panel_5.add(lblNewLabel_5);
		
		
		JPanel impr = new JPanel();
		tabbedPane.addTab("Impresion", null, impr, null);
		
		tableDModel = new DefaultTableModel();// definimos el objeto tableModel
		tablePacientes = new JTable();
		tablePacientes.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		tablePacientes.setRowHeight(25);
		tablePacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePacientes.setSelectionBackground(SystemColor.menu);
		tablePacientes.setBackground(SystemColor.inactiveCaption);
		tablePacientes.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		tablePacientes.setModel(tableDModel);
		tableDModel.addColumn("Nombre");
		tableDModel.addColumn("Apellido");
		tablePacientes.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tablePacientes.getTableHeader().setReorderingAllowed(false);
		
		/*JTable table = new JTable();
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

		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 144, 227, 545);
		contentPane.add(scrollPane);
		*/
		
		scrollPacientes = new JScrollPane();
		scrollPacientes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPacientes.setBounds(10, 164, 220, 525);
		mostrarNombre();// mostramos la tabla
		getContentPane().add(scrollPacientes);
		
		
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

			private static final long serialVersionUID = 1L;
			
			
			boolean[] columnEditables = new boolean[] {
				false
				};
			
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table2.getColumnModel().getColumn(0).setPreferredWidth(850);
				
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		//DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		//leftRenderer.setHorizontalAlignment(JLabel.LEFT);
		//table2.getColumnModel().getColumn(0).setHeaderRenderer(leftRenderer);
		//table2.getColumnModel().getColumn(1).setHeaderRenderer(leftRenderer);
		table2.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				
		
		JScrollPane scrollPane_1 = new JScrollPane(table2);
		scrollPane_1.setBounds(10, 185, 1095, 345);
		posCons.add(scrollPane_1);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 101, 227, 37);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Pacientes");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 27));
		lblNewLabel_1.setBounds(0, 0, 227, 37);
		panel_2.add(lblNewLabel_1);
		//scrollPane.setViewportView(table);
	}
	
	void addBackListener (ActionListener backListener) {
		backButton.addActionListener(backListener);
	}
	
	
	private void mostrarNombre() {
		PacienteDAO pacienteDao = new PacienteDAO();
		pacienteDao.buscarNombreUsuarios(tableDModel);
		scrollPacientes.setViewportView(tablePacientes);
	}
	
}
