package com.ingsoft.odontolog.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JSpinner;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.ingsoft.odontolog.model.ListModelPaciente;

import java.awt.Color;
import javax.swing.JDesktopPane;

public class historiaClinicaView extends JFrame {

	private JPanel contentPane;
	private JTextField textsearch;
	private JList listaNombres;
	private JButton odontoButton;

	public historiaClinicaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		gbl_contentPane.columnWidths = new int[]{39, 204, 17, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 38, 33, 445, 45, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.weightx = 0.3;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {1200};
		gbl_panel.rowHeights = new int[] {449};
		gbl_panel.columnWeights = new double[]{0.0};
		gbl_panel.rowWeights = new double[]{0.0};
		panel.setLayout(gbl_panel);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_tabbedPane.anchor = GridBagConstraints.NORTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		panel.add(tabbedPane, gbc_tabbedPane);
		
		JPanel fichaMed = new JPanel();
		tabbedPane.addTab("Ficha Medica", null, fichaMed, null);
		fichaMed.setLayout(null);
		
		JPanel datos = new JPanel();
		tabbedPane.addTab("Datos", null, datos, null);
		datos.setLayout(null);
		
		
		textsearch = new JTextField();
		textsearch.setText("\"B\u00FAsqueda\"");
		textsearch.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 15));
		GridBagConstraints gbc_txtnombre = new GridBagConstraints();
		gbc_txtnombre.fill = GridBagConstraints.BOTH;
		gbc_txtnombre.anchor = GridBagConstraints.WEST;
		gbc_txtnombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtnombre.gridx = 1;
		gbc_txtnombre.gridy = 2;
		contentPane.add(textsearch, gbc_txtnombre);
		//txtnombre.setColumns(1);
		
		odontoButton = new JButton("Ver Odontograma");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(odontoButton, gbc_btnNewButton);
		
		listaNombres = new JList();
		listaNombres.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		listaNombres.setVisibleRowCount(10);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		listaNombres.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.weighty = 2.5;
		gbc_list.gridx = 1;
		gbc_list.gridy = 3;
		contentPane.add(listaNombres, gbc_list);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 4;
		contentPane.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton button = new JButton("+");
		panel_1.add(button);
		
		JButton btnM = new JButton("M");
		panel_1.add(btnM);
		
		JButton button_1 = new JButton("-");
		panel_1.add(button_1);
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
