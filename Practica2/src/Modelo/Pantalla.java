package Modelo;

import java.awt.Rectangle;

public class Pantalla {
	private int ancho;
	private int largo;
	private Rectangle bordederecho;
	private Rectangle bordeizquierdo;
	private Rectangle bordearriba;
	private int tamañoborde;
	

	
	public Pantalla(int ancho,int largo){
		tamañoborde=10;
		this.ancho=ancho;
		this.largo=largo;
		bordeizquierdo= new Rectangle(0,0,tamañoborde,largo);
		bordearriba= new Rectangle(0,0,ancho,tamañoborde);
		bordederecho= new Rectangle(ancho-tamañoborde,0,tamañoborde,largo);
		
	}
	
	
	/*Getters y setters*/
	
	public int getAncho() {
		return ancho;
	}


	public void setAncho(int ancho) {
		this.ancho = ancho;
	}


	public int getLargo() {
		return largo;
	}


	public void setLargo(int largo) {
		this.largo = largo;
	}


	public void setBordederecho(Rectangle bordederecho) {
		this.bordederecho = bordederecho;
	}




	public Rectangle getBordeizquierdo() {
		return bordeizquierdo;
	}




	public void setBordeizquierdo(Rectangle bordeizquierdo) {
		this.bordeizquierdo = bordeizquierdo;
	}




	public Rectangle getBordearriba() {
		return bordearriba;
	}




	public void setBordearriba(Rectangle bordearriba) {
		this.bordearriba = bordearriba;
	}




	public int getTamañoborde() {
		return tamañoborde;
	}




	public void setTamañoborde(int tamañoborde) {
		this.tamañoborde = tamañoborde;
	}


	public Rectangle getBordederecho() {
		return bordederecho;
	}
	
}
