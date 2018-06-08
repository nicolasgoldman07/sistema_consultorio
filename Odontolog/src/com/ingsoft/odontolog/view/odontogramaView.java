package com.ingsoft.odontolog.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ingsoft.odontolog.model.Diente;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class odontogramaView extends JFrame{

	private JPanel contentPane;
	private ImageIcon caraCentral;
	private ImageIcon caraLateIzq;
	private ImageIcon caraLateDer;
	private ImageIcon caraSup;
	private ImageIcon caraInfe;
	private ImageIcon esquinaSR;
	private ImageIcon esquinaSL;
	private ImageIcon esquinaIR;
	private ImageIcon esquinaIL;
	
	final int ADULTO = 8*3;
	final int NENE = 5*3;
	
	private ArrayList<JLabel> esquinas;
	private ArrayList<JButton> botones;
	private JButton	exitButton;
	
	private HashMap<String, ImageIcon> mapaIconos;
	
	public odontogramaView() {
		setTitle("odontograma");
		
		//ICONOS
		caraCentral = new ImageIcon(odontogramaView.class.getResource("/raw/CaraCentral.png"));
		caraLateIzq = new ImageIcon(odontogramaView.class.getResource("/raw/BordeIzq.png"));
		caraLateDer = new ImageIcon(odontogramaView.class.getResource("/raw/BordeDer.png"));
		caraSup = new ImageIcon(odontogramaView.class.getResource("/raw/CaraSuperior.png"));
		caraInfe = new ImageIcon(odontogramaView.class.getResource("/raw/CaraInfe.png"));
		esquinaSR = new ImageIcon(odontogramaView.class.getResource("/raw/EsquinaSupR.png"));
		esquinaSL = new ImageIcon(odontogramaView.class.getResource("/raw/EsquinaSupI.png"));
		esquinaIR = new ImageIcon(odontogramaView.class.getResource("/raw/EsquinaInfR.png"));
		esquinaIL = new ImageIcon(odontogramaView.class.getResource("/raw/EsquinaInfI.png"));
		
		mapaIconos = new HashMap<String, ImageIcon>();
		
		//PONER BIEN LOS ICONOS QUE CORRESPONDAN/////////////////////////////////
		ImageIcon[] arregloIconos = new ImageIcon[(Diente.tratamientos.length)*(Diente.keys.length)];
		arregloIconos[0] = new ImageIcon(odontogramaView.class.getResource("/raw/BordeDer_trat.png"));
		arregloIconos[1] = new ImageIcon(odontogramaView.class.getResource("/raw/CaraSuperior_trat.png"));
		arregloIconos[2] = new ImageIcon(odontogramaView.class.getResource("/raw/CaraCentral_trat.png"));
		arregloIconos[3] = new ImageIcon(odontogramaView.class.getResource("/raw/CaraInfe_trat.png"));
		arregloIconos[4] = new ImageIcon(odontogramaView.class.getResource("/raw/BordeIzq_trat.png"));
		
		mapaIconos.put(Diente.tratamientos[0]+Diente.keys[0], arregloIconos[0]);
		mapaIconos.put(Diente.tratamientos[0]+Diente.keys[1], arregloIconos[1]);
		mapaIconos.put(Diente.tratamientos[0]+Diente.keys[2], arregloIconos[2]);
		mapaIconos.put(Diente.tratamientos[0]+Diente.keys[3], arregloIconos[3]);
		mapaIconos.put(Diente.tratamientos[0]+Diente.keys[4], arregloIconos[4]);
		/*for(int i=0; i<Diente.tratamientos.length; i++){
			arregloIconos[i] = new ImageIcon(odontogramaView.class.getResource("/raw/tratamiento.png"));
		}*/
		
		
		/*mapaIconos.put("", esquinaSL);
		
		for(int i=0; i<Diente.tratamientos.length; i++){
			mapaIconos.put(Diente.tratamientos[i], new ImageIcon(odontogramaView.class.getResource("/raw/tratamiento.png")));
		}*/
		////////////////////////////////////////////////////////////////////
		
		//CONFIGURACION
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1680, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		//gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		//gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		botones = new ArrayList<JButton>();
		esquinas = new ArrayList<JLabel>();
		
		exitButton = new JButton("EXIT");
		GridBagConstraints gbc_exitButton = new GridBagConstraints();
		gbc_exitButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_exitButton.insets = new Insets(30, 0, 0, 15);
		gbc_exitButton.gridx = 26;
		gbc_exitButton.gridy = 30;
		contentPane.add(exitButton, gbc_exitButton);
		
		//Insets(Top, Left, Bottom, Right)
		//SEPARADORES
		JSeparator separator5 = new JSeparator();
		GridBagConstraints gbc_separator5 = new GridBagConstraints();
		gbc_separator5.insets = new Insets(15, 0, 0, 15);
		gbc_separator5.gridx = 0;
		gbc_separator5.gridy = 24;
		contentPane.add(separator5, gbc_separator5);
		
		JSeparator separator2 = new JSeparator();
		GridBagConstraints gbc_separator2 = new GridBagConstraints();
		gbc_separator2.insets = new Insets(15, 0, 15, 0);
		gbc_separator2.gridx = 0;
		gbc_separator2.gridy = 9;
		contentPane.add(separator2, gbc_separator2);
		
		JSeparator separator3 = new JSeparator();
		GridBagConstraints gbc_separator3 = new GridBagConstraints();
		gbc_separator3.insets = new Insets(0, 30, 0, 30);
		gbc_separator3.gridx = 26;
		gbc_separator3.gridy = 9;
		contentPane.add(separator3, gbc_separator3);
		
		JSeparator separator4 = new JSeparator();
		GridBagConstraints gbc_separator4 = new GridBagConstraints();
		gbc_separator4.insets = new Insets(50, 0, 50, 0);
		gbc_separator4.gridx = 0;
		gbc_separator4.gridy = 15;
		contentPane.add(separator4, gbc_separator4);
		
		generarDentadura(8, 5);
		generarDentadura(5, 20);
	}
	
	//Agrego los Listeners
	public void addDienteListener(ActionListener listenDiente){
		for(int i=0; i<botones.size(); i++){
			botones.get(i).addActionListener(listenDiente);
		}
	}
	
	//Cambio los iconos de acuerdo al tratamiento que recibió la cara del diente
	public void refresh(Vector<String> arreglos){
		int j=0;
		for(int i=0; i<arreglos.size(); i++){
			if(!arreglos.get(i).equals("na"+Diente.keys[j])){
				botones.get(i).setIcon(mapaIconos.get(arreglos.get(i)));
			}
			j++;
			if(j == Diente.keys.length){
				j = 0;
			}
		}
	}
	
	public ArrayList<JButton> getBotones(){
		return botones;
	}
	
	//Genero los Botones
	private void generarDentadura(int x, int y){
		
		GridBagConstraints gbc_izq = new GridBagConstraints();
		gbc_izq.ipady = -10;
		gbc_izq.ipadx = -50;
		gbc_izq.insets = new Insets(0, 0, 0, 0);
		
		GridBagConstraints gbc_esq = new GridBagConstraints();
		gbc_esq.insets = new Insets(0, 0, 0, 0);
		gbc_esq.anchor = GridBagConstraints.WEST;
		
		GridBagConstraints gbc_entre = new GridBagConstraints();
		gbc_entre.ipady = -10;
		gbc_entre.ipadx = -35;
		gbc_entre.insets = new Insets(0, 0, 0, 15);
		
		for(int j=0; j<2; j++){
			for(int i=0; i<x*3; i++){
				
				esquinas.add(new JLabel(""));
				esquinas.get(esquinas.size()-1).setIcon(esquinaIR);
				gbc_esq.gridx = 1+ADULTO-i;
				gbc_esq.gridy = 3+(j*4+y);
				//gbc_esq.anchor = GridBagConstraints.NORTHWEST;
				contentPane.add(esquinas.get(esquinas.size()-1), gbc_esq);
				
				botones.add(new JButton(""));
				botones.get(botones.size()-1).setIcon(caraLateDer);		
				gbc_entre.gridx = 1+ADULTO-i;
				gbc_entre.gridy = 2+(j*4+y);
				gbc_entre.ipady = -10;
				gbc_entre.ipadx = -34;
				contentPane.add(botones.get(botones.size()-1), gbc_entre);
				
				esquinas.add(new JLabel(""));
				esquinas.get(esquinas.size()-1).setIcon(esquinaSR);
				gbc_esq.gridx = 1+ADULTO-i;
				gbc_esq.gridy = 1+(j*4+y);
				//gbc_esq.anchor = GridBagConstraints.SOUTHWEST;
				contentPane.add(esquinas.get(esquinas.size()-1), gbc_esq);
				
				i++;
				
				botones.add(new JButton(""));
				botones.get(botones.size()-1).setIcon(caraSup);	
				gbc_izq.gridx = 1+ADULTO-i;
				gbc_izq.gridy = 1+(j*4+y);
				gbc_izq.ipady = -10;
				gbc_izq.ipadx = -30;
				contentPane.add(botones.get(botones.size()-1), gbc_izq);
				
				botones.add(new JButton(""));
				botones.get(botones.size()-1).setIcon(caraCentral);		
				gbc_izq.gridx = 1+ADULTO-i;
				gbc_izq.gridy = 2+(j*4+y);
				gbc_izq.ipady = -10;
				gbc_izq.ipadx = -30;
				contentPane.add(botones.get(botones.size()-1), gbc_izq);
				
				botones.add(new JButton(""));
				botones.get(botones.size()-1).setIcon(caraInfe);		
				gbc_izq.gridx = 1+ADULTO-i;
				gbc_izq.gridy = 3+(j*4+y);
				gbc_izq.ipady = -10;
				gbc_izq.ipadx = -30;
				contentPane.add(botones.get(botones.size()-1), gbc_izq);
				
				i++;
				
				esquinas.add(new JLabel(""));
				esquinas.get(esquinas.size()-1).setIcon(esquinaIL);
				gbc_esq.gridx = 1+ADULTO-i;
				gbc_esq.gridy = 3+(j*4+y);
				//gbc_esq.anchor = GridBagConstraints.NORTHEAST;
				contentPane.add(esquinas.get(esquinas.size()-1), gbc_esq);
				
				botones.add(new JButton(""));
				botones.get(botones.size()-1).setIcon(caraLateIzq);		
				gbc_izq.gridx = 1+ADULTO-i;
				gbc_izq.gridy = 2+(j*4+y);
				gbc_izq.ipady = -10;
				gbc_izq.ipadx = -34;
				//gbc_izq.anchor = GridBagConstraints.EAST;
				contentPane.add(botones.get(botones.size()-1), gbc_izq);
				
				esquinas.add(new JLabel(""));
				esquinas.get(esquinas.size()-1).setIcon(esquinaSL);
				gbc_esq.gridx = 1+ADULTO-i;
				gbc_esq.gridy = 1+(j*4+y);
				//gbc_esq.anchor = GridBagConstraints.SOUTHEAST;
				contentPane.add(esquinas.get(esquinas.size()-1), gbc_esq);
				
			}
		}
		
		for(int j=0; j<2; j++){
			for(int i=0; i<x*3; i++){
				
				esquinas.add(new JLabel(""));
				esquinas.get(esquinas.size()-1).setIcon(esquinaIL);
				gbc_esq.gridx = 1+i+26;
				gbc_esq.gridy = 3+(j*4+y);
				//gbc_esq.anchor = GridBagConstraints.NORTHEAST;
				contentPane.add(esquinas.get(esquinas.size()-1), gbc_esq);
				
				botones.add(new JButton(""));
				botones.get(botones.size()-1).setIcon(caraLateIzq);		
				gbc_izq.gridx = 1+i+26;
				gbc_izq.gridy = 2+(j*4+y);
				gbc_izq.ipady = -10;
				gbc_izq.ipadx = -34;
				//gbc_izq.anchor = GridBagConstraints.EAST;
				contentPane.add(botones.get(botones.size()-1), gbc_izq);
				
				esquinas.add(new JLabel(""));
				esquinas.get(esquinas.size()-1).setIcon(esquinaSL);
				gbc_esq.gridx = 1+i+26;
				gbc_esq.gridy = 1+(j*4+y);
				//gbc_esq.anchor = GridBagConstraints.SOUTHEAST;
				contentPane.add(esquinas.get(esquinas.size()-1), gbc_esq);
				
				i++;
				
				botones.add(new JButton(""));
				botones.get(botones.size()-1).setIcon(caraSup);	
				gbc_izq.gridx = 1+i+26;
				gbc_izq.gridy = 1+(j*4+y);
				gbc_izq.ipady = -10;
				gbc_izq.ipadx = -30;
				contentPane.add(botones.get(botones.size()-1), gbc_izq);
				
				botones.add(new JButton(""));
				botones.get(botones.size()-1).setIcon(caraCentral);		
				gbc_izq.gridx = 1+i+26;
				gbc_izq.gridy = 2+(j*4+y);
				gbc_izq.ipady = -10;
				gbc_izq.ipadx = -30;
				contentPane.add(botones.get(botones.size()-1), gbc_izq);
				
				botones.add(new JButton(""));
				botones.get(botones.size()-1).setIcon(caraInfe);		
				gbc_izq.gridx = 1+i+26;
				gbc_izq.gridy = 3+(j*4+y);
				gbc_izq.ipady = -10;
				gbc_izq.ipadx = -30;
				contentPane.add(botones.get(botones.size()-1), gbc_izq);
				
				i++;
				
				esquinas.add(new JLabel(""));
				esquinas.get(esquinas.size()-1).setIcon(esquinaIR);
				gbc_esq.gridx = 1+i+26;
				gbc_esq.gridy = 3+(j*4+y);
				//gbc_esq.anchor = GridBagConstraints.NORTHWEST;
				contentPane.add(esquinas.get(esquinas.size()-1), gbc_esq);
				
				botones.add(new JButton(""));
				botones.get(botones.size()-1).setIcon(caraLateDer);		
				gbc_entre.gridx = 1+i+26;
				gbc_entre.gridy = 2+(j*4+y);
				gbc_entre.ipady = -10;
				gbc_entre.ipadx = -34;
				contentPane.add(botones.get(botones.size()-1), gbc_entre);
				
				esquinas.add(new JLabel(""));
				esquinas.get(esquinas.size()-1).setIcon(esquinaSR);
				gbc_esq.gridx = 1+i+26;
				gbc_esq.gridy = 1+(j*4+y);
				//gbc_esq.anchor = GridBagConstraints.SOUTHWEST;
				contentPane.add(esquinas.get(esquinas.size()-1), gbc_esq);
				
			}
		}
	}
}
