package Modelo;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import GestionDeImagenes.ManejadorImagenes;
import Hilos.UT1P02Pinta;
import Hilos.UT1P02Tiempo;
import Vista.FrameMundo;


public class UT1P02Vista extends JPanel implements KeyListener{
	
	
	
	private Mundo m;
	private ManejadorImagenes mi;
	private FrameMundo ventana;




	public UT1P02Vista(FrameMundo ventana){

		
		this.ventana= ventana;
		mi= new ManejadorImagenes();
		m= new Mundo(ventana);
		addKeyListener(this);


		UT1P02Tiempo reloj = new UT1P02Tiempo(this,m);
		UT1P02Pinta pinta = new UT1P02Pinta(this,m);
		
		reloj.start();
		pinta.start();
		
		// Características del marco
		setSize(m.getPant().getAncho(),m.getPant().getLargo());
		setFocusable(true);
		setVisible(true);
	}
	
	
	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		super.paint(g2);
		if(!m.isGameover()){
			if(m.isGanador()){
				g2.setColor(Color.BLACK);
				g2.fillRect(0, 0, m.getPant().getAncho(), m.getPant().getLargo());
				g2.setColor(Color.WHITE);
				g2.drawString("WINNER", 220, 320);
			}else{
				pintaPantalla(g2, m.getPant());
				pintaMarco(g2, m.getPant());
				pintaNave(g2,m.getJugador());
				pintaBola(g2,m.getBola());
				pintaBloques(g2,m.getBloques());
			}
		}else{
			g2.setColor(Color.BLACK);
			g2.fillRect(0, 0, m.getPant().getAncho(), m.getPant().getLargo());
			g2.setColor(Color.WHITE);
			g2.drawString("GAME OVER", 220, 320);
			
		}
	}
	
	
	public void pintaMarco(Graphics2D g, Pantalla p){
		g.drawImage(mi.getImgmarcoizq(), (int)p.getBordeizquierdo().getX(), (int)p.getBordeizquierdo().getY(), (int)p.getBordeizquierdo().getWidth(), (int)p.getBordeizquierdo().getHeight(),null);
		g.drawImage(mi.getImgmarcoder(), (int)p.getBordederecho().getX(), (int)p.getBordederecho().getY(), (int)p.getBordederecho().getWidth(), (int)p.getBordederecho().getHeight(),null);
		g.drawImage(mi.getImgmarcoarriba(), (int)p.getBordearriba().getX(), (int)p.getBordearriba().getY(), (int)p.getBordearriba().getWidth(), (int)p.getBordearriba().getHeight(),null);
		
	}
	
	public void pintaPantalla(Graphics2D g, Pantalla p){

		g.drawImage(mi.getImgpantalla(), 0, 0, p.getAncho(), p.getLargo(),null);
	}
	
	public void pintaBola(Graphics2D g, Bola b){
		
		g.drawImage(mi.getImgbola(), b.getXpos(), b.getYpos(), b.getTamaño(), b.getTamaño(),null);
		
	}
	
	public void pintaNave(Graphics2D g,Nave n){
		
		g.drawImage(mi.getImgnave(), n.getX(), n.getY(), n.getLargo(), n.getAncho(),null);
	}
	
	public void pintaBloques(Graphics2D g,Bloque[][] blo){

		int contador=0;

		for (int i=0;i<12;i++){
			for (int j=0;j<12;j++){
				if(blo[i][j].getEstado()==Bloque.NORMAL){

					g.drawImage(mi.getImgbloque().get(contador), blo[i][j].getX(),blo[i][j].getY(), blo[i][j].getAncho(), blo[i][j].getLargo(),null);

				}

			}
			contador++;
			if(contador==4)
				contador=0;

		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			m.getJugador().moverNave(m.getJugador().getX()+10,m.getJugador().getY(),m.getPant());
			if(m.getInicio()==1){
				m.getBola().setXpos(m.getJugador().getX()+20);
				m.getBola().setYpos(m.getJugador().getY()-m.getBola().getTamaño());
			}
		
    	}
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			
			m.getJugador().moverNave(m.getJugador().getX()-10, m.getJugador().getY(),m.getPant());
			if(m.getInicio()==1){
				m.getBola().setXpos(m.getJugador().getX()+20);
				m.getBola().setYpos(m.getJugador().getY()-m.getBola().getTamaño());
			}
		
    	}
		
		if ( e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			m.setInicio(0);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public Mundo getM() {
		return m;
	}



	public void setM(Mundo m) {
		this.m = m;
	}
	


	public Frame getVentana() {
		return ventana;
	}



	public void setVentana(FrameMundo ventana) {
		this.ventana = ventana;
	}
}

