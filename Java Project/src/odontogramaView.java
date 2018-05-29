import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class odontogramaView extends JFrame {

	private JPanel contentPane;
	private ImageIcon caraCentral;
	private ImageIcon caraLate;
	private ImageIcon caraSup;
	private ImageIcon esquinaSR;
	private ImageIcon esquinaSL;
	private ImageIcon esquinaIR;
	private ImageIcon esquinaIL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					odontogramaView frame = new odontogramaView();
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
	public odontogramaView() {
		
		caraCentral = new ImageIcon(odontogramaView.class.getResource("/raw/CaraCentral.png"));
		caraLate = new ImageIcon(odontogramaView.class.getResource("/raw/CaraLat.png"));
		caraSup = new ImageIcon(odontogramaView.class.getResource("/raw/CaraSuperior.png"));
		esquinaSR = new ImageIcon(odontogramaView.class.getResource("/raw/EsquinaSupR.png"));
		esquinaSL = new ImageIcon(odontogramaView.class.getResource("/raw/EsquinaSupI.png"));
		esquinaIR = new ImageIcon(odontogramaView.class.getResource("/raw/EsquinaInfR.png"));
		esquinaIL = new ImageIcon(odontogramaView.class.getResource("/raw/EsquinaInfI.png"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		JSeparator separator1 = new JSeparator();
		GridBagConstraints gbc_separator1 = new GridBagConstraints();
		gbc_separator1.insets = new Insets(0, 50, 5, 50);
		gbc_separator1.gridx = 0;
		gbc_separator1.gridy = 5;
		contentPane.add(separator1, gbc_separator1);
		
		ArrayList<JButton> botones = new ArrayList<JButton>();
		ArrayList<JLabel> esquinas = new ArrayList<JLabel>();
		
		GridBagConstraints gbc_izq = new GridBagConstraints();
		gbc_izq.ipady = -5;
		gbc_izq.ipadx = -30;
		gbc_izq.insets = new Insets(0, 0, 0, 0);
		
		GridBagConstraints gbc_esq = new GridBagConstraints();
		gbc_esq.insets = new Insets(0, 0, 0, 0);
		gbc_esq.anchor = GridBagConstraints.WEST;
		
		GridBagConstraints gbc_entre = new GridBagConstraints();
		gbc_entre.ipady = -5;
		gbc_entre.ipadx = -30;
		gbc_entre.insets = new Insets(0, 0, 0, 15);
	
		
		for(int j=0; j<1; j++){
	
			for(int i=0; i<8*3; i++){
				
				esquinas.add(new JLabel(""));
				esquinas.get(esquinas.size()-1).setIcon(esquinaIL);
				gbc_esq.gridx = 1+i;
				gbc_esq.gridy = 3;
				contentPane.add(esquinas.get(esquinas.size()-1), gbc_esq);
				
				botones.add(new JButton(""));
				botones.get(botones.size()-1).setIcon(caraLate);		
				gbc_izq.gridx = 1+i;
				gbc_izq.gridy = 2;
				contentPane.add(botones.get(botones.size()-1), gbc_izq);
				
				esquinas.add(new JLabel(""));
				esquinas.get(esquinas.size()-1).setIcon(esquinaSL);
				gbc_esq.gridx = 1+i;
				gbc_esq.gridy = 1;
				contentPane.add(esquinas.get(esquinas.size()-1), gbc_esq);
				
				i++;
				
				botones.add(new JButton(""));
				botones.get(botones.size()-1).setIcon(caraSup);	
				gbc_izq.gridx = 1+i;
				gbc_izq.gridy = 1;
				contentPane.add(botones.get(botones.size()-1), gbc_izq);
				
				botones.add(new JButton(""));
				botones.get(botones.size()-1).setIcon(caraCentral);		
				gbc_izq.gridx = 1+i;
				gbc_izq.gridy = 2;
				contentPane.add(botones.get(botones.size()-1), gbc_izq);
				
				
				
				botones.add(new JButton(""));
				botones.get(botones.size()-1).setIcon(caraSup);		
				gbc_izq.gridx = 1+i;
				gbc_izq.gridy = 3;
				contentPane.add(botones.get(botones.size()-1), gbc_izq);
				
				i++;
				
				esquinas.add(new JLabel(""));
				esquinas.get(esquinas.size()-1).setIcon(esquinaIR);
				esquinas.get(esquinas.size()-1).setHorizontalAlignment(SwingConstants.LEFT);
				gbc_esq.gridx = 1+i;
				gbc_esq.gridy = 3;
				contentPane.add(esquinas.get(esquinas.size()-1), gbc_esq);
				
				botones.add(new JButton(""));
				botones.get(botones.size()-1).setIcon(caraLate);		
				gbc_entre.gridx = 1+i;
				gbc_entre.gridy = 2;
				contentPane.add(botones.get(botones.size()-1), gbc_entre);
				
				esquinas.add(new JLabel(""));
				esquinas.get(esquinas.size()-1).setIcon(esquinaSR);
				esquinas.get(esquinas.size()-1).setHorizontalAlignment(SwingConstants.LEFT);
				gbc_esq.gridx = 1+i;
				gbc_esq.gridy = 1;
				contentPane.add(esquinas.get(esquinas.size()-1), gbc_esq);
				
				
			}
		
		}
		
		JSeparator separator2 = new JSeparator();
		GridBagConstraints gbc_separator2 = new GridBagConstraints();
		gbc_separator2.insets = new Insets(50, 0, 5, 0);
		gbc_separator2.gridx = 50;
		gbc_separator2.gridy = 0;
		contentPane.add(separator2, gbc_separator2);
		
		
		/*JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 12;
		gbc_btnNewButton.gridy = 12;
		contentPane.add(btnNewButton, gbc_btnNewButton);*/
		
		/*for(int j=0; j<2; j++){
			
			for(int i=0; i<8; i++){
				botones.add(new JButton(""));
				botones.get(botones.size()-1).setIcon(caraCentral);		
				gbc_izq.gridx = 51+i;
				gbc_izq.gridy = 3+j;
				contentPane.add(botones.get(botones.size()-1), gbc_izq);
			}
		}*/
		
		
	}

}
