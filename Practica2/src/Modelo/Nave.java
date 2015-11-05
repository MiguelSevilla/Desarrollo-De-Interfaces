package Modelo;

import java.awt.Rectangle;

public class Nave {
	
	private int x;
	private int y;
	private int ancho;
	private int largo;
	
	
	
	public Nave(int x,int y){
		this.x=x;
		this.y=y;
		ancho=8;
		largo=60;
	}
	
	
	
	
	
	public void moverNave(int x,int y, Pantalla p){
		
		if( (x >= 10) && (x <= p.getAncho()-this.getLargo()-10) ){
			this.x=x;
			this.y=y;
		}
		
	}
	
	public Rectangle getLimites(){
		return new Rectangle(x,y,largo,ancho);
		
	}
	
	
	
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
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
}
