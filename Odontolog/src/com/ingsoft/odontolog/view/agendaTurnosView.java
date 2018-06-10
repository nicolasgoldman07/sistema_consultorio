package com.ingsoft.odontolog.view;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import com.toedter.calendar.JDayChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.github.lgooddatepicker.components.CalendarPanel;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.optionalusertools.CalendarListener;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.optionalusertools.PickerUtilities;
import com.github.lgooddatepicker.zinternaltools.CalendarSelectionEvent;
import com.github.lgooddatepicker.zinternaltools.YearMonthChangeEvent;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.privatejgoodies.forms.factories.CC;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;
import java.awt.ComponentOrientation;
import javax.swing.SpringLayout;
import javax.swing.DebugGraphics;
import java.awt.Cursor;

public class agendaTurnosView extends JFrame{

	private JPanel contentPane;
	private JTable table;
	private JButton backButton;
	private JPanel panelBtnAtras;
	private JPanel panel_2;
	private Date mesSiguiente;
	private Calendar calendario1;
	private CalendarPanel calendarPanel;
	private static JTextField fechaSeleccion;
	private JButton agregarBtn;
	private JButton nodarBtn;
	private int rowz;
	//private Calendar calendario;
	//private JPanel panel;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agendaTurnosView frame = new agendaTurnosView();
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
	public agendaTurnosView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		this.setMaximizedBounds(env.getMaximumWindowBounds());
		this.setMinimumSize(new Dimension(720, 500));
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(77, 0, 834, 83);
		panelTitulo.setBackground(SystemColor.activeCaption);
		contentPane.add(panelTitulo);
		panelTitulo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agenda de Turnos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 502, 64);
		panelTitulo.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 48));
		
		panelBtnAtras = new JPanel();
		panelBtnAtras.setBounds(0, 0, 77, 83);
		panelBtnAtras.setBackground(SystemColor.activeCaption);
		contentPane.add(panelBtnAtras);
		panelBtnAtras.setLayout(null);
		
		backButton = new JButton("ATRAS");
		backButton.setHorizontalTextPosition(SwingConstants.CENTER);
		backButton.setHorizontalAlignment(SwingConstants.LEFT);
		backButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		backButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 11));
		backButton.setForeground(SystemColor.activeCaptionText);
		backButton.setBackground(SystemColor.activeCaption);
		backButton.setIcon(new ImageIcon(agendaTurnosView.class.getResource("/images/espalda.png")));
		backButton.setBounds(0, 0, 77, 84);
		panelBtnAtras.add(backButton);
		
		JPanel panel_5 = new JPanel();
		panel_5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_5.setBackground(SystemColor.inactiveCaption);
		panel_5.setBounds(910, 0, 1038, 1038);
		contentPane.add(panel_5);
		SpringLayout sl_panel_5 = new SpringLayout();
		panel_5.setLayout(sl_panel_5);
		
		fechaSeleccion = new JTextField();
		sl_panel_5.putConstraint(SpringLayout.EAST, fechaSeleccion, -597, SpringLayout.EAST, panel_5);
		panel_5.add(fechaSeleccion);
		fechaSeleccion.setEditable(false);
		fechaSeleccion.setBackground(SystemColor.inactiveCaption);
		fechaSeleccion.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 24));
		fechaSeleccion.setColumns(10);
        Date date = new Date();
		DateFormat df = new SimpleDateFormat("d '/' M '/' yyyy");
		fechaSeleccion.setText(df.format(date));

		
		
		JPanel panel_7 = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.SOUTH, fechaSeleccion, -7, SpringLayout.NORTH, panel_7);
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel_7, 82, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel_7, 29, SpringLayout.WEST, panel_5);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel_7, -56, SpringLayout.EAST, panel_5);
		panel_5.add(panel_7);
		panel_7.setBackground(SystemColor.inactiveCaption);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setRowHeight(27);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		table.setBackground(SystemColor.activeCaption);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"7:00", null, null, null, null},
				{"7:30", null, null, null, null},
				{"8:00", null, null, null, null},
				{"8:30", null, null, null, null},
				{"9:00", null, null, null, null},
				{"9:30", null, null, null, null},
				{"10:00", null, null, null, null},
				{"10:30", null, null, null, null},
				{"11:00", null, null, null, null},
				{"11:30", null, null, null, null},
				{"12:00", null, null, null, null},
				{"12:30", null, null, null, null},
				{"13:00", null, null, null, null},
				{"13:30", null, null, null, null},
				{"14:00", null, null, null, null},
				{"14:30", null, null, null, null},
				{"15:00", null, null, null, null},
				{"15:30", null, null, null, null},
				{"16:00", null, null, null, null},
				{"16:30", null, null, null, null},
				{"17:00", null, null, null, null},
				{"17:30", null, null, null, null},
				{"18:00", null, null, null, null},
				{"18:30", null, null, null, null},
				{"19:00", null, null, null, null},
				{"19:30", null, null, null, null},
				{"20:00", null, null, null, null},
				{"20:30", null, null, null, null},
				{"21:00", null, null, null, null},
				{"21:30", null, null, null, null},
				{"22:00", null, null, null, null},
				{"22:30", null, null, null, null},
			},
			new String[] {
				"Horario", "Paciente", "Arreglo", "Diente", "Odontologo"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		JTableHeader header = table.getTableHeader();
		panel_7.setLayout(new BorderLayout(0, 0));
		panel_7.add(table, BorderLayout.SOUTH);
		panel_7.add(header, BorderLayout.NORTH);
		
		JLabel labelDiaSeleccionado = new JLabel("Dia Seleccionado: ");
		sl_panel_5.putConstraint(SpringLayout.WEST, fechaSeleccion, 6, SpringLayout.EAST, labelDiaSeleccionado);
		sl_panel_5.putConstraint(SpringLayout.NORTH, labelDiaSeleccionado, 37, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.WEST, labelDiaSeleccionado, 37, SpringLayout.WEST, panel_5);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, labelDiaSeleccionado, -7, SpringLayout.NORTH, panel_7);
		sl_panel_5.putConstraint(SpringLayout.EAST, labelDiaSeleccionado, -782, SpringLayout.EAST, panel_5);
		labelDiaSeleccionado.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 24));
		panel_5.add(labelDiaSeleccionado);
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBounds(0, 82, 911, 956);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		calendario1 = new GregorianCalendar();
		mesSiguiente = new Date();
		System.out.println(mesSiguiente);
		calendario1.set(mesSiguiente.getYear()+1900, mesSiguiente.getMonth()+1, mesSiguiente.getDay());
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setToolTipText("");
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel_3.setBounds(10, 62, 881, 628);
		panel_2.add(panel_3);
		
		
		
		
		///////////Se crea el calendario y su panel/////////////
		DatePickerSettings settings = new DatePickerSettings();
		settings.setSizeDatePanelMinimumHeight(500);
		settings.setSizeDatePanelMinimumWidth(870);
		settings.setVisibleClearButton(false);
		//System.out.println(settings.getColorBackgroundWeekdayLabels());
		panel_3.setLayout(new BorderLayout(0, 0));
		calendarPanel = new CalendarPanel(settings);
		calendarPanel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		calendarPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendarPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		calendarPanel.setName("Schedule");
		calendarPanel.setBackground(SystemColor.inactiveCaption);
		calendarPanel.setForeground(SystemColor.inactiveCaptionText);
		calendarPanel.setSelectedDate(LocalDate.now());
		calendarPanel.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		
		panel_3.add(calendarPanel, BorderLayout.NORTH);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_4.setBackground(SystemColor.inactiveCaption);
		panel_4.setBounds(10, 732, 364, 137);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Rojo: D\u00EDas sin disponibilidad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(27, 2, 279, 49);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u00B7");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblNewLabel_2.setToolTipText("");
		lblNewLabel_2.setBounds(10, 23, 17, 14);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblVerdesDasCon = new JLabel("Verdes: D\u00EDas con disponibilidad amplia");
		lblVerdesDasCon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVerdesDasCon.setBounds(27, 38, 323, 49);
		panel_4.add(lblVerdesDasCon);
		
		JLabel label_1 = new JLabel("\u00B7");
		label_1.setForeground(Color.GREEN);
		label_1.setToolTipText("");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 48));
		label_1.setBounds(10, 62, 17, 14);
		panel_4.add(label_1);
		
		JLabel lblNaranjaDasCon = new JLabel("Naranja: D\u00EDas con disponibilidad limitada");
		lblNaranjaDasCon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNaranjaDasCon.setBounds(27, 77, 323, 49);
		panel_4.add(lblNaranjaDasCon);
		
		JLabel label_3 = new JLabel("\u00B7");
		label_3.setForeground(Color.ORANGE);
		label_3.setToolTipText("");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 48));
		label_3.setBounds(10, 101, 17, 14);
		panel_4.add(label_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(413, 732, 440, 121);
		panel_2.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {110, 110, 110, 110};
		gbl_panel.rowHeights = new int[] {20, 20};
		gbl_panel.columnWeights = new double[]{1.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		agregarBtn = new JButton("");
		GridBagConstraints gbc_agregarBtn = new GridBagConstraints();
		gbc_agregarBtn.insets = new Insets(0, 0, 5, 5);
		gbc_agregarBtn.gridx = 0;
		gbc_agregarBtn.gridy = 0;
		panel.add(agregarBtn, gbc_agregarBtn);
		agregarBtn.setIcon(new ImageIcon(agendaTurnosView.class.getResource("/images/add.png")));
		agregarBtn.setVerticalAlignment(SwingConstants.BOTTOM);
		agregarBtn.setHorizontalAlignment(SwingConstants.LEADING);
		agregarBtn.setBorder(null);
		agregarBtn.setBackground(SystemColor.menu);
		
		
		
		JButton quitarBtn = new JButton("");
		GridBagConstraints gbc_quitarBtn = new GridBagConstraints();
		gbc_quitarBtn.fill = GridBagConstraints.VERTICAL;
		gbc_quitarBtn.insets = new Insets(0, 0, 5, 5);
		gbc_quitarBtn.gridx = 1;
		gbc_quitarBtn.gridy = 0;
		panel.add(quitarBtn, gbc_quitarBtn);
		quitarBtn.setIcon(new ImageIcon(agendaTurnosView.class.getResource("/images/subtract.png")));
		quitarBtn.setVerticalAlignment(SwingConstants.BOTTOM);
		quitarBtn.setHorizontalAlignment(SwingConstants.LEADING);
		quitarBtn.setBorder(null);
		quitarBtn.setBackground(SystemColor.menu);
		
		JButton modificarBtn = new JButton("");
		GridBagConstraints gbc_modificarBtn = new GridBagConstraints();
		gbc_modificarBtn.insets = new Insets(0, 0, 5, 5);
		gbc_modificarBtn.gridx = 2;
		gbc_modificarBtn.gridy = 0;
		panel.add(modificarBtn, gbc_modificarBtn);
		modificarBtn.setIcon(new ImageIcon(agendaTurnosView.class.getResource("/images/edit.png")));
		modificarBtn.setVerticalAlignment(SwingConstants.BOTTOM);
		modificarBtn.setHorizontalAlignment(SwingConstants.LEADING);
		modificarBtn.setBorder(null);
		modificarBtn.setBackground(SystemColor.menu);
		
		nodarBtn = new JButton("");
		nodarBtn.setIcon(new ImageIcon(agendaTurnosView.class.getResource("/images/unable.png")));
		nodarBtn.setVerticalAlignment(SwingConstants.BOTTOM);
		nodarBtn.setHorizontalAlignment(SwingConstants.LEADING);
		nodarBtn.setBorder(null);
		nodarBtn.setBackground(SystemColor.menu);
		GridBagConstraints gbc_nodarBtn = new GridBagConstraints();
		gbc_nodarBtn.insets = new Insets(0, 0, 5, 0);
		gbc_nodarBtn.gridx = 3;
		gbc_nodarBtn.gridy = 0;
		panel.add(nodarBtn, gbc_nodarBtn);
		
		JLabel lblAgregarTurno = new JLabel("Agregar Turno");
		GridBagConstraints gbc_lblAgregarTurno = new GridBagConstraints();
		gbc_lblAgregarTurno.insets = new Insets(0, 0, 5, 5);
		gbc_lblAgregarTurno.gridx = 0;
		gbc_lblAgregarTurno.gridy = 1;
		panel.add(lblAgregarTurno, gbc_lblAgregarTurno);
		
		JLabel lblQuitarTurno = new JLabel("Quitar Turno");
		GridBagConstraints gbc_lblQuitarTurno = new GridBagConstraints();
		gbc_lblQuitarTurno.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuitarTurno.gridx = 1;
		gbc_lblQuitarTurno.gridy = 1;
		panel.add(lblQuitarTurno, gbc_lblQuitarTurno);
		
		JLabel lblModificarTurno = new JLabel("Modificar Turno");
		GridBagConstraints gbc_lblModificarTurno = new GridBagConstraints();
		gbc_lblModificarTurno.insets = new Insets(0, 0, 5, 5);
		gbc_lblModificarTurno.gridx = 2;
		gbc_lblModificarTurno.gridy = 1;
		panel.add(lblModificarTurno, gbc_lblModificarTurno);
		
		JLabel lblNoDarTurno = new JLabel("No Dar Turno");
		GridBagConstraints gbc_lblNoDarTurno = new GridBagConstraints();
		gbc_lblNoDarTurno.insets = new Insets(0, 0, 5, 0);
		gbc_lblNoDarTurno.gridx = 3;
		gbc_lblNoDarTurno.gridy = 1;
		panel.add(lblNoDarTurno, gbc_lblNoDarTurno);
		

		
		/*JButton b = new JButton("New button");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFormat df = new SimpleDateFormat("EE dd 'de' MMM 'de' yyyy");
				fecha.setText(df.format(calendar.getDate()));
			}
		});
		b.setBounds(142, 598, 89, 23);
		panel_5.add(b);*/
	}
	
//	public void addBackListener(ActionListener listenBack) {
//		backButton.addActionListener(listenBack);
//	}
//	
//	public void addAgregarTurnoListener (ActionListener listenAgregar) {
//		agregarBtn.addActionListener(listenAgregar);
//	}
	
	public void addAgendaListener(ActionListener listenAgenda){
		backButton.addActionListener(listenAgenda);
		agregarBtn.addActionListener(listenAgenda);
		nodarBtn.addActionListener(listenAgenda);
	}
	
	public void addCalendarListener(CalendarListener listenCalendario){
		calendarPanel.addCalendarListener(listenCalendario);
	}
	
	public JTable getTabla(){
		return table;
	} 
	
	public JTextField getFechaSeleccion(){
		return fechaSeleccion;
	}
	
	public JButton getAgregarButton(){
		return agregarBtn;
	}
	public JButton getBackButton(){
		return backButton;
	}
	
	public JButton getNoDarTurnoButton() {
		return nodarBtn;
	}
	
	public CalendarPanel getCalendario(){
		return calendarPanel;
	}
    

}
