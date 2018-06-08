package com.ingsoft.odontolog.view;
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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.JTableHeader;

import com.ingsoft.odontolog.model.sql.PacienteDAO;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class adminView extends JFrame {

	private JPanel contentPane;
	private JButton backButton;
	private JPanel panel_atras;
	private JScrollPane scrollPacientes;
	private DefaultTableModel tableDModel;
	private JTable tablePacientes;
	private JList listaPacientes;
	private JButton btnAdd;


//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					adminView frame = new adminView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */


	public adminView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		
        //Contenedor-Panel General
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{77, 37, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		

		//Panel boton "Atras"
		panel_atras = new JPanel();
		panel_atras.setBackground(SystemColor.activeCaption);
		GridBagConstraints gbc_panel_atras = new GridBagConstraints();
		gbc_panel_atras.weightx = 0.05;
		gbc_panel_atras.fill = GridBagConstraints.BOTH;
		gbc_panel_atras.insets = new Insets(0, 0, 5, 5);
		gbc_panel_atras.gridx = 0;
		gbc_panel_atras.gridy = 0;
		contentPane.add(panel_atras, gbc_panel_atras);
		panel_atras.setLayout(null);
		
		//Boton "Atras"
		backButton = new JButton("ATRAS");
		backButton.setIcon(new ImageIcon(adminView.class.getResource("/images/espalda.png")));
		backButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 11));
		backButton.setForeground(SystemColor.activeCaptionText);
		backButton.setBackground(SystemColor.activeCaption);
		backButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		backButton.setHorizontalTextPosition(SwingConstants.CENTER);
		backButton.setBounds(0, 0, 84, 77);
		panel_atras.add(backButton);
		
		//Etiqueta "Atras"
		JLabel lblAtras = new JLabel("ATRAS");
		lblAtras.setBounds(0, 63, 62, 14);
		panel_atras.add(lblAtras);
		lblAtras.setForeground(SystemColor.desktop);
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Panel titulo
		JPanel panel_titulo = new JPanel();
		panel_titulo.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_panel_titulo = new GridBagConstraints();
		gbc_panel_titulo.weightx = 0.5;
		gbc_panel_titulo.fill = GridBagConstraints.BOTH;
		gbc_panel_titulo.insets = new Insets(0, 0, 5, 0);
		gbc_panel_titulo.gridx = 1;
		gbc_panel_titulo.gridy = 0;
		contentPane.add(panel_titulo, gbc_panel_titulo);
		panel_titulo.setLayout(null);
		
		//Etiqueta de titulo
		JLabel lblNewLabel = new JLabel("Administraci\u00F3n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 502, 71);
		panel_titulo.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 48));
		
		//Panel para etiqueta Pacientes		
		JPanel panel_pacientes = new JPanel();
		GridBagConstraints gbc_panel_pacientes = new GridBagConstraints();
		gbc_panel_pacientes.insets = new Insets(0, 0, 0, 5);
		gbc_panel_pacientes.fill = GridBagConstraints.BOTH;
		gbc_panel_pacientes.gridx = 0;
		gbc_panel_pacientes.gridy = 1;
		contentPane.add(panel_pacientes, gbc_panel_pacientes);
		GridBagLayout gbl_panel_pacientes = new GridBagLayout();
		gbl_panel_pacientes.columnWidths = new int[]{0, 0};
		gbl_panel_pacientes.rowHeights = new int[]{10, 652, 0};
		gbl_panel_pacientes.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_pacientes.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_pacientes.setLayout(gbl_panel_pacientes);
		
		scrollPacientes = new JScrollPane();
		GridBagConstraints gbc_scrollPacientes = new GridBagConstraints();
		gbc_scrollPacientes.insets = new Insets(0, 5, 10, 0);
		gbc_scrollPacientes.anchor = GridBagConstraints.WEST;
		gbc_scrollPacientes.fill = GridBagConstraints.BOTH;
		gbc_scrollPacientes.gridx = 0;
		gbc_scrollPacientes.gridy = 1;
		panel_pacientes.add(scrollPacientes, gbc_scrollPacientes);
		listaPacientes = new JList();
		listaPacientes.setFont(new Font("Tahoma", Font.BOLD, 15));
		listaPacientes.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPacientes.setViewportView(listaPacientes);
		
		//Etiqueta "Pacientes"
		JLabel lblNewLabel_1 = new JLabel("Pacientes");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 27));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 10, 5, 0);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_pacientes.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		
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
		
		
		JPanel panel_tabs = new JPanel();
		GridBagConstraints gbc_panel_tabs = new GridBagConstraints();
		gbc_panel_tabs.fill = GridBagConstraints.BOTH;
		gbc_panel_tabs.gridx = 1;
		gbc_panel_tabs.gridy = 1;
		contentPane.add(panel_tabs, gbc_panel_tabs);
		GridBagLayout gbl_panel_tabs = new GridBagLayout();
		gbl_panel_tabs.columnWidths = new int[]{623, 0};
		gbl_panel_tabs.rowHeights = new int[]{713, 0};
		gbl_panel_tabs.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_tabs.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_tabs.setLayout(gbl_panel_tabs);
		
		
		//Panel de pestanas
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		panel_tabs.add(tabbedPane, gbc_tabbedPane);
		tabbedPane.setBackground(SystemColor.inactiveCaption);
		tabbedPane.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		
		//Pestana "Posicion Consolidada"
		JPanel posCons = new JPanel();
		tabbedPane.addTab("Posicion Consolidada", null, posCons, null);
		GridBagLayout gbl_posCons = new GridBagLayout();
		gbl_posCons.columnWidths = new int[]{0, 0};
		gbl_posCons.rowHeights = new int[]{40, 95, 40, 346, 0};
		gbl_posCons.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_posCons.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		posCons.setLayout(gbl_posCons);
		
		//Panel para etiqueta "Saldo"
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		posCons.add(panel_4, gbc_panel_4);
		panel_4.setLayout(null);
		
		//Etiqueta "Saldo"
		JLabel lblNewLabel_3 = new JLabel("Saldo");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 35));
		lblNewLabel_3.setBounds(25, 0, 245, 40);
		panel_4.add(lblNewLabel_3);
		
		JPanel panel_tabla = new JPanel();
		GridBagConstraints gbc_panel_tabla = new GridBagConstraints();
		gbc_panel_tabla.insets = new Insets(0, 0, 10, 0);
		gbc_panel_tabla.fill = GridBagConstraints.BOTH;
		gbc_panel_tabla.gridx = 0;
		gbc_panel_tabla.gridy = 3;
		posCons.add(panel_tabla, gbc_panel_tabla);
		GridBagLayout gbl_panel_tabla = new GridBagLayout();
		gbl_panel_tabla.columnWidths = new int[]{0, 0, 0};
		gbl_panel_tabla.rowHeights = new int[]{0, 0};
		gbl_panel_tabla.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_tabla.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_tabla.setLayout(gbl_panel_tabla);
		
				
				//Tabla2 para tratamiento e importe
				JTable table2 = new JTable();
				table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table2.setRowSelectionAllowed(false);
				table2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
				table2.setBackground(SystemColor.activeCaption);
				table2.setModel(new DefaultTableModel(
					new Object[][] {
						{new String ("ExtracciÃ³n Premolar"), new Integer(-2500)},
						{new String ("Limpieza bucal"), new Integer(-500)},
						{new String ("DepÃ³sito"), new Integer(10000)}, 
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
					new String[] {"Tratamiento", "Importe"}
				) {
      
					private static final long serialVersionUID = 1L;
					
					
					boolean[] columnEditables = new boolean[] {
						false
						};
					
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				table2.getColumnModel().getColumn(0).setPreferredWidth(650);
				//table2.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				
		//Panel con scroll para la tabla de tratamientos e importe
		JScrollPane scrollPane_1 = new JScrollPane(table2);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel_tabla.add(scrollPane_1, gbc_scrollPane_1);
		
		
		//Panel Botonera
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 0, 10);
		gbc_panel_6.anchor = GridBagConstraints.EAST;
		gbc_panel_6.fill = GridBagConstraints.VERTICAL;
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 0;
		panel_tabla.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{51, 0, 0, 0, 0};
		gbl_panel_6.rowHeights = new int[]{51, 0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		//Boton Print
		JButton btnPrint = new JButton("");
		btnPrint.setIcon(new ImageIcon(adminView.class.getResource("/images/print.png")));
		GridBagConstraints gbc_btnPrint = new GridBagConstraints();
		gbc_btnPrint.gridx = 3;
		gbc_btnPrint.gridy = 1;
		btnPrint.setBorder(null);
		btnPrint.setBackground(SystemColor.menu);
		panel_6.add(btnPrint, gbc_btnPrint);
		
		//Boton Edit
		JButton btnEdit = new JButton("");
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.insets = new Insets(0, 0, 0, 5);
		gbc_btnEdit.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnEdit.gridx = 1;
		gbc_btnEdit.gridy = 1;
		panel_6.add(btnEdit, gbc_btnEdit);
		btnEdit.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEdit.setIcon(new ImageIcon(adminView.class.getResource("/images/edit.png")));
		btnEdit.setHorizontalAlignment(SwingConstants.LEADING);
		btnEdit.setBorder(null);
		btnEdit.setBackground(SystemColor.menu);
		
		//Boton Quitar
		JButton btnSub = new JButton("");
		GridBagConstraints gbc_btnSub = new GridBagConstraints();
		gbc_btnSub.insets = new Insets(0, 0, 0, 5);
		gbc_btnSub.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnSub.gridx = 2;
		gbc_btnSub.gridy = 1;
		panel_6.add(btnSub, gbc_btnSub);
		btnSub.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSub.setIcon(new ImageIcon(adminView.class.getResource("/images/subtract.png")));
		btnSub.setHorizontalAlignment(SwingConstants.LEADING);
		btnSub.setBorder(null);
		btnSub.setBackground(SystemColor.menu);
		
		//Boton Agregar
		JButton btnAdd = new JButton("");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 1;
		panel_6.add(btnAdd, gbc_btnAdd);
		btnAdd.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAdd.setBorder(null);
		btnAdd.setHorizontalAlignment(SwingConstants.LEADING);
		btnAdd.setIcon(new ImageIcon(adminView.class.getResource("/images/add.png")));
		btnAdd.setBackground(SystemColor.menu);
		
		//Panel general de la pestaÃ±a "Posicion Consolidada"
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		posCons.add(panel_3, gbc_panel_3);
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
		
				
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
	}
	
	public void addBackListener (ActionListener backListener) {
		backButton.addActionListener(backListener);
	}
	
	public void iniciarLista(ListModel modelo){
		listaPacientes.setModel(modelo);
	}
}
