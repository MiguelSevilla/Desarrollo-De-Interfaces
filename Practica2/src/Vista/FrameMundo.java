package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modelo.UT1P02Vista;

public class FrameMundo extends JFrame{

	private JLabel etVidas;
	private JLabel etPuntuacion;


	private UT1P02Vista vista;

	

	public FrameMundo(){
		super("Practica 2");
		setLayout(new BorderLayout());
		vista = new UT1P02Vista(this);
		etVidas = new JLabel("Vidas: " + (vista.getM().getVidas()));
		etPuntuacion = new JLabel("Puntuación: "+0);
		JPanel pinfo = new JPanel(new FlowLayout());
		
		pinfo.add(etVidas);
		pinfo.add(etPuntuacion);
		
		add(vista,BorderLayout.CENTER);
		add(pinfo,BorderLayout.SOUTH);
		
		setSize(600,720);
		
		
		//frame.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}


	
	
	public JLabel getEtVidas() {
		return etVidas;
	}


	public void setEtVidas(JLabel etVidas) {
		this.etVidas = etVidas;
	}


	public UT1P02Vista getVista() {
		return vista;
	}


	public void setVista(UT1P02Vista vista) {
		this.vista = vista;
	}

	
	public JLabel getEtPuntuacion() {
		return etPuntuacion;
	}


	public void setEtPuntuacion(JLabel etPuntuacion) {
		this.etPuntuacion = etPuntuacion;
	}
	
	
	
}
