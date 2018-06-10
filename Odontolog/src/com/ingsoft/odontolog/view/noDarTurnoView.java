package com.ingsoft.odontolog.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class noDarTurnoView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					noDarTurnoView frame = new noDarTurnoView();
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
	public noDarTurnoView() {
		setTitle("No dar turno");
		this.setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(nuevoPacienteView.class.getResource("/images/dientesin200.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {30, 30, 100, 100, 100, 50, 50, 20, 30, 0, 30, 30, 30};
		gbl_contentPane.rowHeights = new int[] {50, 30, 50, 20, 50, 50, 30, 30, 30};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(SystemColor.textHighlight);
		GridBagConstraints gbc_panelTitulo = new GridBagConstraints();
		gbc_panelTitulo.gridwidth = 13;
		gbc_panelTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_panelTitulo.fill = GridBagConstraints.BOTH;
		gbc_panelTitulo.gridx = 0;
		gbc_panelTitulo.gridy = 0;
		contentPane.add(panelTitulo, gbc_panelTitulo);
		panelTitulo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitulo = new JLabel("No dar turnos");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		panelTitulo.add(lblTitulo, BorderLayout.CENTER);
		
		JPanel panelFecha = new JPanel();
		panelFecha.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_panelFecha = new GridBagConstraints();
		gbc_panelFecha.gridwidth = 3;
		gbc_panelFecha.insets = new Insets(0, 0, 5, 5);
		gbc_panelFecha.fill = GridBagConstraints.BOTH;
		gbc_panelFecha.gridx = 0;
		gbc_panelFecha.gridy = 2;
		contentPane.add(panelFecha, gbc_panelFecha);
		panelFecha.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
		lblFecha.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		panelFecha.add(lblFecha, BorderLayout.NORTH);
		
		JDateChooser dateChooser = new JDateChooser();
		panelFecha.add(dateChooser, BorderLayout.SOUTH);
		
		JSeparator separator = new JSeparator();
		panelFecha.add(separator, BorderLayout.CENTER);
		
		JPanel panelCausa = new JPanel();
		panelCausa.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_panelCausa = new GridBagConstraints();
		gbc_panelCausa.gridheight = 3;
		gbc_panelCausa.fill = GridBagConstraints.BOTH;
		gbc_panelCausa.gridwidth = 5;
		gbc_panelCausa.insets = new Insets(0, 0, 5, 5);
		gbc_panelCausa.gridx = 0;
		gbc_panelCausa.gridy = 4;
		contentPane.add(panelCausa, gbc_panelCausa);
		panelCausa.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("205px:grow"),
				ColumnSpec.decode("61px"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblDetalles = new JLabel("Detalles:");
		lblDetalles.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		panelCausa.add(lblDetalles, "1, 2, 2, 1, left, top");
		
		JSeparator separator_1 = new JSeparator();
		panelCausa.add(separator_1, "1, 4, 2, 1");
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.inactiveCaptionBorder);
		panelCausa.add(textPane, "1, 6, 2, 1, fill, fill");
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setIcon(new ImageIcon(noDarTurnoView.class.getResource("/images/unable.png")));
		button.setVerticalAlignment(SwingConstants.BOTTOM);
		button.setHorizontalAlignment(SwingConstants.LEADING);
		button.setBorder(null);
		button.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.VERTICAL;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 6;
		gbc_button.gridy = 5;
		contentPane.add(button, gbc_button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(noDarTurnoView.class.getResource("/images/espalda.png")));
		button_1.setBorder(null);
		button_1.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.BOTH;
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 8;
		gbc_button_1.gridy = 5;
		contentPane.add(button_1, gbc_button_1);
		
		JLabel lblConfirmar = new JLabel("Confirmar");
		lblConfirmar.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		GridBagConstraints gbc_lblConfirmar = new GridBagConstraints();
		gbc_lblConfirmar.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblConfirmar.anchor = GridBagConstraints.NORTH;
		gbc_lblConfirmar.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmar.gridx = 6;
		gbc_lblConfirmar.gridy = 6;
		contentPane.add(lblConfirmar, gbc_lblConfirmar);
		
		JLabel lblCancelar = new JLabel("Cancelar");
		lblCancelar.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCancelar = new GridBagConstraints();
		gbc_lblCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCancelar.anchor = GridBagConstraints.NORTH;
		gbc_lblCancelar.insets = new Insets(0, 0, 5, 0);
		gbc_lblCancelar.gridx = 8;
		gbc_lblCancelar.gridy = 6;
		contentPane.add(lblCancelar, gbc_lblCancelar);
	}

}
