package Modelo;

import java.awt.Color;
import java.awt.Rectangle;

/*Clase con los metodos y atributos de un bloque del juego*/
public class Bloque {
	
	private Color color;
	private int x;
	private int y;
	private int ancho;
	private int largo;
	private int estado;	/*1-normal 0-destruido*/
	
	
	/*CONSTANTES*/
	
	/*Estados de un bloque*/
	public final static int DESTRUIDO = 0;
	public final static int NORMAL = 1;
	
	/*Lados de la colision*/
	final static int NO_COLISION = 0;
	final static int NORTE = 1;
	final static int SUR = 2;
	final static int ESTE = 3;
	final static int OESTE = 4;
	
	
	
	/*Constructores*/
	
	
	public Bloque(int x,int y,Color color){
		this.x=x;
		this.y=y;
		this.color=color;
		estado=1;
	}
	
	public Bloque(int x,int y){
		this.x=x;
		this.y=y;
		this.color=Color.RED;
		estado=Bloque.NORMAL;
		ancho=40;
		largo=20;
	}
	
	/*Metodos*/
	
	public void destruirBloque(){
		estado=0;
	}
	
	
	public Rectangle getLimites(){
		return new Rectangle(x,y,ancho,largo);
		
	}
	
	
	/*Getters  y Setters*/
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
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

	
}
