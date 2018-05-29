import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class adminView extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		//setBounds(600, 300, 650, 400);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		setSize(screenSize.width - getWidth(), screenSize.height - taskBarSize - getHeight());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(82, 0, 1268, 77);
		panel.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administración");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 502, 71);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new java.awt.Font("Yu Gothic UI Semilight", java.awt.Font.BOLD, 48));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 84, 77);
		panel_1.setBackground(SystemColor.activeCaption);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton backButton = new JButton("ATRAS");
		backButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", java.awt.Font.BOLD, 11));
		backButton.setForeground(SystemColor.activeCaptionText);
		backButton.setBackground(SystemColor.activeCaption);
	    backButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	    backButton.setHorizontalTextPosition(SwingConstants.CENTER);
		//backButton.setIcon(new ImageIcon(AgendaDeTurnos.class.getResource("/images/espalda.png")));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		backButton.setBounds(0, 0, 84, 77);
		panel_1.add(backButton);
		
		JLabel lblAtras = new JLabel("ATRAS");
		lblAtras.setBounds(0, 63, 62, 14);
		panel_1.add(lblAtras);
		lblAtras.setForeground(SystemColor.desktop);
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.inactiveCaption);
		tabbedPane.setFont(new java.awt.Font("Yu Gothic UI Semilight", java.awt.Font.PLAIN, 14));
		tabbedPane.setBounds(240, 113, 1100, 576);
		contentPane.add(tabbedPane);
		
		JPanel asist = new JPanel();
		tabbedPane.addTab("Asistencia", null, asist, null);
		
		JPanel posCons = new JPanel();
		tabbedPane.addTab("Posicion Consolidada", null, posCons, null);
		
		JPanel impr = new JPanel();
		tabbedPane.addTab("Impresion", null, impr, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 113, 227, 576);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new java.awt.Font("Yu Gothic UI Semilight", java.awt.Font.PLAIN, 16));
		table.setBackground(SystemColor.activeCaption);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
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
			new String[] {"Paciente"}
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
		/*table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);*/
		scrollPane.setViewportView(table);
	}
}
