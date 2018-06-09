package com.ingsoft.odontolog.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JSpinner;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.ingsoft.odontolog.model.ListModelPaciente;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class historiaClinicaView extends JFrame {

	private JPanel contentPane;
	private JTextField textsearch;
	private JList listaNombres;
	private JButton odontoButton;
	private JScrollPane	scrollPacientes;
	private JTable tablaDatos;

	public historiaClinicaView() {
		setTitle("Historia Clinica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(600, 300));
		//setBounds(100, 100, 1280, 720);
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		this.setMaximizedBounds(env.getMaximumWindowBounds());
        //this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        //this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{204, 17, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 33, 445, 45, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_back = new JPanel();
		panel_back.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_panel_back = new GridBagConstraints();
		gbc_panel_back.insets = new Insets(0, 10, 5, 5);
		gbc_panel_back.fill = GridBagConstraints.BOTH;
		gbc_panel_back.gridx = 0;
		gbc_panel_back.gridy = 0;
		contentPane.add(panel_back, gbc_panel_back);
		GridBagLayout gbl_panel_back = new GridBagLayout();
		gbl_panel_back.columnWidths = new int[]{189, 0};
		gbl_panel_back.rowHeights = new int[]{59, 0};
		gbl_panel_back.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_back.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_back.setLayout(gbl_panel_back);
		
		//Boton "Atras"
		JButton backButton = new JButton("ATRAS");
		backButton.setIcon(new ImageIcon(adminView.class.getResource("/images/espalda.png")));
		backButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 11));
		backButton.setForeground(SystemColor.activeCaptionText);
		backButton.setBackground(SystemColor.activeCaption);
		backButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		backButton.setHorizontalTextPosition(SwingConstants.CENTER);
		backButton.setBounds(0, 0, 84, 77);
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.anchor = GridBagConstraints.WEST;
		gbc_backButton.fill = GridBagConstraints.VERTICAL;
		gbc_backButton.gridx = 0;
		gbc_backButton.gridy = 0;
		panel_back.add(backButton, gbc_backButton);
		
		
		//Panel Titulo y Titulo
		JPanel panel_titulo = new JPanel();
		panel_titulo.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_panel_titulo = new GridBagConstraints();
		gbc_panel_titulo.weightx = 0.5;
		gbc_panel_titulo.fill = GridBagConstraints.BOTH;
		gbc_panel_titulo.insets = new Insets(0, 0, 5, 0);
		gbc_panel_titulo.gridx = 2;
		gbc_panel_titulo.gridy = 0;
		contentPane.add(panel_titulo, gbc_panel_titulo);
		GridBagLayout gbl_panel_titulo = new GridBagLayout();
		gbl_panel_titulo.columnWidths = new int[]{1, 0};
		gbl_panel_titulo.rowHeights = new int[]{1, 0};
		gbl_panel_titulo.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_titulo.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_titulo.setLayout(gbl_panel_titulo);
		
		JLabel lblNewLabel = new JLabel("Historia Clinica");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 48));
		lblNewLabel.setBackground(SystemColor.inactiveCaption);
		panel_titulo.add(lblNewLabel);
		
		JPanel panel_tabs = new JPanel();
		GridBagConstraints gbc_panel_tabs = new GridBagConstraints();
		gbc_panel_tabs.fill = GridBagConstraints.BOTH;
		gbc_panel_tabs.insets = new Insets(0, 0, 5, 10);
		gbc_panel_tabs.weightx = 0.3;
		gbc_panel_tabs.gridx = 2;
		gbc_panel_tabs.gridy = 2;
		contentPane.add(panel_tabs, gbc_panel_tabs);
		GridBagLayout gbl_panel_tabs = new GridBagLayout();
		gbl_panel_tabs.columnWidths = new int[] {1200};
		gbl_panel_tabs.rowHeights = new int[] {449};
		gbl_panel_tabs.columnWeights = new double[]{1.0};
		gbl_panel_tabs.rowWeights = new double[]{1.0};
		panel_tabs.setLayout(gbl_panel_tabs);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridheight = 0;
		gbc_tabbedPane.gridwidth = 0;
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		panel_tabs.add(tabbedPane, gbc_tabbedPane);
		
		JPanel datos = new JPanel();
		tabbedPane.addTab("Datos", null, datos, null);
		GridBagLayout gbl_datos = new GridBagLayout();
		gbl_datos.columnWidths = new int[]{1, 0};
		gbl_datos.rowHeights = new int[]{1, 0};
		gbl_datos.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_datos.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		datos.setLayout(gbl_datos);
		
		tablaDatos = new JTable();
		tablaDatos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tablaDatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaDatos.setRowSelectionAllowed(false);
		tablaDatos.setModel(new DefaultTableModel(
			new Object[][] {
				{new String("ALGO"), new String("ALGO")},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"", ""
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		GridBagConstraints gbc_tablaDatos = new GridBagConstraints();
		gbc_tablaDatos.fill = GridBagConstraints.BOTH;
		gbc_tablaDatos.gridx = 0;
		gbc_tablaDatos.gridy = 0;
		datos.add(tablaDatos, gbc_tablaDatos);
		
		
		
		textsearch = new JTextField();
		textsearch.setText("\"B\u00FAsqueda\"");
		textsearch.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 15));
		GridBagConstraints gbc_txtnombre = new GridBagConstraints();
		gbc_txtnombre.fill = GridBagConstraints.BOTH;
		gbc_txtnombre.anchor = GridBagConstraints.WEST;
		gbc_txtnombre.insets = new Insets(0, 10, 5, 5);
		gbc_txtnombre.gridx = 0;
		gbc_txtnombre.gridy = 1;
		contentPane.add(textsearch, gbc_txtnombre);
		//txtnombre.setColumns(1);
		
		odontoButton = new JButton("Ver Odontograma");
		GridBagConstraints gbc_odontoButton = new GridBagConstraints();
		gbc_odontoButton.insets = new Insets(0, 0, 5, 0);
		gbc_odontoButton.gridx = 2;
		gbc_odontoButton.gridy = 1;
		contentPane.add(odontoButton, gbc_odontoButton);
		
//		scrollPacientes = new JScrollPane();
//		listaNombres = new JList();
//		scrollPacientes.setViewportView(listaNombres);
//		listaNombres.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		listaNombres.setVisibleRowCount(10);
//		GridBagConstraints gbc_list = new GridBagConstraints();
//		gbc_list.insets = new Insets(0, 0, 5, 5);
//		listaNombres.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
//		gbc_list.fill = GridBagConstraints.BOTH;
//		gbc_list.weighty = 2.5;
//		gbc_list.gridx = 1;
//		gbc_list.gridy = 3;
//		contentPane.add(listaNombres, gbc_list);
		
		scrollPacientes = new JScrollPane();
		listaNombres = new JList();
		scrollPacientes.setViewportView(listaNombres);
		scrollPacientes.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		//listaNombres.setVisibleRowCount(10);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 10, 5, 5);
		listaNombres.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.weighty = 2.5;
		gbc_list.gridx = 0;
		gbc_list.gridy = 2;
		contentPane.add(scrollPacientes, gbc_list);
		
		JPanel panel_botones = new JPanel();
		GridBagConstraints gbc_panel_botones = new GridBagConstraints();
		gbc_panel_botones.insets = new Insets(0, 10, 5, 5);
		gbc_panel_botones.fill = GridBagConstraints.BOTH;
		gbc_panel_botones.gridx = 0;
		gbc_panel_botones.gridy = 3;
		contentPane.add(panel_botones, gbc_panel_botones);
		panel_botones.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton addButton = new JButton("");
		addButton.setIcon(new ImageIcon(adminView.class.getResource("/images/add.png")));
		addButton.setBorder(null);
		addButton.setBackground(SystemColor.menu);
		panel_botones.add(addButton);
		
		JPanel panel_2 = new JPanel();
		panel_botones.add(panel_2);
		
		JButton rmButton = new JButton("");
		rmButton.setIcon(new ImageIcon(adminView.class.getResource("/images/subtract.png")));
		rmButton.setBorder(null);
		rmButton.setBackground(SystemColor.menu);
		panel_botones.add(rmButton);
	}
	
	public void iniciarLista(ListModel modelo){
		listaNombres.setModel(modelo);
	}
	
	/*public void	addOdontoListener(ActionListener listenOdonto){
		odontoButton.addActionListener(listenOdonto);
	}*/
	
	public void addBusquedaListener(MouseListener listenMouse, ActionListener listenAction){
		textsearch.addMouseListener(listenMouse);
		textsearch.addActionListener(listenAction);
		odontoButton.addActionListener(listenAction);
		listaNombres.addMouseListener(listenMouse);
	}
	
	public JTable getTablaDatos(){
		return tablaDatos;
	}
	
	public JButton getOdontoButton(){
		return odontoButton;
	}
	
	public JList getListaDeNombres(){
		return listaNombres;
	}
	
	public JTextField getBusquedaField(){
		return textsearch;
	}
}
