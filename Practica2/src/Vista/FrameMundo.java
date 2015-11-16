package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameMundo extends JFrame{

	private JLabel etVidas;
	private JLabel etPuntuacion;
	private MenuDesplegable mdesple;


	private PanelPintar vista;

	

	public FrameMundo(){
		super("Practica 2");
		setLayout(new BorderLayout());
		vista = new PanelPintar(this);
		mdesple = new MenuDesplegable(vista.getM());
		etVidas = new JLabel("Vidas: " + (vista.getM().getVidas()));
		etPuntuacion = new JLabel("Puntuación: "+0);
		JPanel pinfo = new JPanel(new FlowLayout());
		
		pinfo.add(etVidas);
		pinfo.add(etPuntuacion);
		
		add(mdesple,BorderLayout.NORTH);
		add(vista,BorderLayout.CENTER);
		add(pinfo,BorderLayout.SOUTH);
		
		setSize(520,720);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}


	
	
	public JLabel getEtVidas() {
		return etVidas;
	}


	public void setEtVidas(JLabel etVidas) {
		this.etVidas = etVidas;
	}


	public PanelPintar getVista() {
		return vista;
	}


	public void setVista(PanelPintar vista) {
		this.vista = vista;
	}

	
	public JLabel getEtPuntuacion() {
		return etPuntuacion;
	}


	public void setEtPuntuacion(JLabel etPuntuacion) {
		this.etPuntuacion = etPuntuacion;
	}
	
	
	
}
