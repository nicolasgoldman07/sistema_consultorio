import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JSpinField;
import com.toedter.components.JLocaleChooser;
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JEditorPane;
import java.awt.List;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.border.LineBorder;

public class AgendaDeTurnos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaDeTurnos frame = new AgendaDeTurnos();
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
	public AgendaDeTurnos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		setSize(screenSize.width - getWidth(), screenSize.height - taskBarSize - getHeight());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(82, 0, 818, 77);
		panel.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agenda de Turnos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 502, 71);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 48));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 84, 77);
		panel_1.setBackground(SystemColor.activeCaption);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton backButton = new JButton("ATRAS");
		backButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 11));
		backButton.setForeground(SystemColor.activeCaptionText);
		backButton.setBackground(SystemColor.activeCaption);
	    backButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	    backButton.setHorizontalTextPosition(SwingConstants.CENTER);
		backButton.setIcon(new ImageIcon(AgendaDeTurnos.class.getResource("/images/espalda.png")));
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
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.inactiveCaption);
		panel_5.setBounds(916, 0, 1032, 1038);
		contentPane.add(panel_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBounds(0, 77, 900, 961);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setDecorationBackgroundColor(new Color(153, 204, 255));
		calendar.getDayChooser().getDayPanel().setBorder(null);
		calendar.setWeekOfYearVisible(false);
		calendar.setDecorationBordersVisible(true);
		calendar.setForeground(SystemColor.textText);
		calendar.getDayChooser().getDayPanel().setBackground(SystemColor.inactiveCaption);
		calendar.getDayChooser().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{calendar.getDayChooser().getDayPanel()}));
		calendar.setBounds(10, 47, 880, 580);
		panel_2.add(calendar);
		calendar.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{calendar.getMonthChooser(), calendar.getMonthChooser().getSpinner(), calendar.getMonthChooser().getComboBox(), calendar.getYearChooser(), calendar.getYearChooser().getSpinner(), calendar.getDayChooser(), calendar.getDayChooser().getDayPanel()}));
		
		JCalendar calendar_1 = new JCalendar();
		calendar_1.getDayChooser().getDayPanel().setBackground(SystemColor.inactiveCaption);
		calendar_1.setBounds(10, 679, 267, 223);
		panel_2.add(calendar_1);
		
		JLabel lblSiguienteMes = new JLabel("Siguiente Mes");
		lblSiguienteMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiguienteMes.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 18));
		lblSiguienteMes.setBounds(10, 644, 267, 24);
		panel_2.add(lblSiguienteMes);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel_3.setBounds(10, 0, 890, 45);
		panel_2.add(panel_3);
		
		JLabel lblMesActual = new JLabel("Mes Actual");
		panel_3.add(lblMesActual);
		lblMesActual.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 25));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_4.setBackground(SystemColor.inactiveCaption);
		panel_4.setBounds(303, 679, 364, 137);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Rojo: D\u00EDas sin disponibilidad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(27, 0, 279, 49);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u00B7");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblNewLabel_2.setToolTipText("");
		lblNewLabel_2.setBounds(10, 21, 17, 14);
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
		lblNaranjaDasCon.setBounds(27, 87, 323, 49);
		panel_4.add(lblNaranjaDasCon);
		
		JLabel label_3 = new JLabel("\u00B7");
		label_3.setForeground(Color.ORANGE);
		label_3.setToolTipText("");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 48));
		label_3.setBounds(10, 111, 17, 14);
		panel_4.add(label_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.activeCaption);
		panel_6.setBounds(897, 0, 19, 1011);
		contentPane.add(panel_6);
	
			
	
	}
}
