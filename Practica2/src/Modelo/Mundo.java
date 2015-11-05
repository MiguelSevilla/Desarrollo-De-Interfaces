package Modelo;


import java.awt.Frame;

import GestionDeSonido.ManejadorSonidos;
import Vista.FrameMundo;

public class Mundo {

	private FrameMundo frame;
	private Bloque [][] bloques;
	private Nave jugador;
	private Bola bola;
	private int vidas;
	private Pantalla pant;
	private boolean ganador; //Si tenemos ganador hay true
	private int puntuacion;
	private int inicio; //Si esta en 1 la bola esta sobre la nave
	private boolean gameover=false;
	//private ManejadorSonidos ms;
	
	
	public Mundo(FrameMundo v){
		frame = v;
		//ms = new  ManejadorSonidos();
		pant= new Pantalla(500,650);
		vidas=3;
		bloques = new Bloque[12][12];
		bola = new Bola(230,620-17);
		jugador = new Nave(210,620);
		puntuacion = 0;
		inicio = 1;
		ganador = false;
		
		inicializaMapa();
		
	}
	
	
	
	/*Metodos*/
	
	/*Mueve la nave sobre el eje de las x*/

	public void moverNave(int direccion){
		//Se mueve a la derecha
		if(direccion>0){
			if(jugador.getX()!= pant.getAncho())
				jugador.moverNave(jugador.getX()+1, jugador.getY(),pant);
		}else{
			if(jugador.getX()!= 0)
				jugador.moverNave(jugador.getX()-1, jugador.getY(),pant);
		}
	}
	
	
	public void inicializaMapa(){
		int e=0,p=0;
		
		for (int i=0;i<12;i++){
			for (int j=0;j<12;j++){
				
				bloques[i][j] = new Bloque((10+e),(10+p));
				e=e+40;
				if(j==11){
					e=0;
					p=p+20;
				}
			}
		}
	}
	
	public void incrementarVida(){
		vidas++;
	}
	
	public void quitarVida(){
		if(vidas>0){
			vidas--;
			frame.getEtVidas().setText("Vidas: " + (String.valueOf(vidas)));
			inicio=1;
		}
	}
	
	public void modificaPuntuacion(){
		puntuacion =puntuacion + 10;
		frame.getEtPuntuacion().setText("Puntuación: "+String.valueOf(puntuacion));
	}
	
	
	
	
	
	public void moverBolaAutomaticamente(){
		
		Colision col;
		
		/*Colision con la pantalla*/
		
		if(bola.getXpos()+1>=pant.getAncho()-bola.getTamaño()-pant.getTamañoborde()){
			bola.setAuxx(Bola.IZQUIERDA);
			//ManejadorSonidos.PARED.play();
			/*
			try {
				ms.sonidoPared();
			} catch (LineUnavailableException | IOException
					| UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		if(bola.getXpos()-1<=pant.getTamañoborde()){
			bola.setAuxx(Bola.DERECHA);
			/*
			try {
				ms.sonidoPared();
			} catch (LineUnavailableException | IOException
					| UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		if(bola.getYpos()-1<=pant.getTamañoborde()){
			bola.setAuxy(Bola.ABAJO);
			/*
			try {
				ms.sonidoPared();
			} catch (LineUnavailableException | IOException
					| UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		if(bola.getYpos()+1>=pant.getLargo()-bola.getTamaño()){
			quitarVida();
			if(vidas<1)
				terminarJuego();
			
			bola.reiniciarBola(jugador);
		}
		
	
		
		if(bola.colisionNaveExacta(jugador).getPosicioncolision()==Bloque.NORTE)
			bola.setAuxy(Bola.ARRIBA);
		if(bola.colisionNaveExacta(jugador).getPosicioncolision()==Bloque.OESTE)
			bola.setAuxx(Bola.IZQUIERDA);
		if(bola.colisionNaveExacta(jugador).getPosicioncolision()==Bloque.ESTE)
			bola.setAuxx(Bola.DERECHA);

		/*Colision bola con todos los bloques*/
		
		for (int i=0;i<12;i++){
			for (int j=0;j<12;j++){
				col=bola.colisionBloqueExacta(bloques[i][j]);
				
								
				if(col.getPosicioncolision()==Bloque.ESTE && bloques[i][j].getEstado()==Bloque.NORMAL){
					bola.setAuxx(Bola.DERECHA);
					bloques[i][j].setEstado(Bloque.DESTRUIDO);
					modificaPuntuacion();
				}
				if(col.getPosicioncolision()==Bloque.OESTE && bloques[i][j].getEstado()==Bloque.NORMAL){
					bola.setAuxx(Bola.IZQUIERDA);
					bloques[i][j].setEstado(Bloque.DESTRUIDO);
					modificaPuntuacion();
				}
				if(col.getPosicioncolision()==Bloque.NORTE && bloques[i][j].getEstado()==Bloque.NORMAL){
					bola.setAuxy(Bola.ARRIBA);
					bloques[i][j].setEstado(Bloque.DESTRUIDO);
					modificaPuntuacion();
				}
				if(col.getPosicioncolision()==Bloque.SUR && bloques[i][j].getEstado()==Bloque.NORMAL){
					bola.setAuxy(Bola.ABAJO);
					bloques[i][j].setEstado(Bloque.DESTRUIDO);
					modificaPuntuacion();
				}
			}
		}
		
		
		if(inicio==0){
	
			bola.setXpos(bola.getXpos()+bola.getAuxx());
			bola.setYpos(bola.getYpos()+bola.getAuxy());
		}
		
	}
	
	
	public void terminarJuego(){
		gameover=true;
	}
	
	
	

	/*Getters y Setters*/
	
	
	public int getPuntuacion() {
		return puntuacion;
	}


	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	
	public boolean isGameover() {
		return gameover;
	}


	public void setGameover(boolean gameover) {
		this.gameover = gameover;
	}



	public Bloque[][] getBloques() {
		return bloques;
	}


	public void setBloques(Bloque[][] bloques) {
		this.bloques = bloques;
	}


	public Nave getJugador() {
		return jugador;
	}


	public void setJugador(Nave jugador) {
		this.jugador = jugador;
	}


	public Bola getBola() {
		return bola;
	}


	public void setBola(Bola bola) {
		this.bola = bola;
	}


	public int getVidas() {
		return vidas;
	}


	public void setVidas(int vidas) {
		this.vidas = vidas;
	}


	public Pantalla getPant() {
		return pant;
	}


	public void setPant(Pantalla pant) {
		this.pant = pant;
	}

	
	public Frame getFrame() {
		return frame;
	}



	public void setFrame(FrameMundo frame) {
		this.frame = frame;
	}
	
	
	public int getInicio() {
		return inicio;
	}


	public void setInicio(int inicio) {
		this.inicio = inicio;
	}


	public boolean isGanador() {
		return ganador;
	}


	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}

	
}
