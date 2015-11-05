package Modelo;

import java.awt.Color;
import java.awt.Rectangle;

public class Bola {

	final static int ABAJO = 1;
	final static int ARRIBA = -1;
	final static int DERECHA = 1;
	final static int IZQUIERDA = -1;
	
	Color color;
	private int xpos;
	private int ypos;
	private float xvel; //>0 derecha <0 izquierda
	private float yvel; //>0 arriba <0 abajo
	private int tamaño;
	private int auxx;
	private int auxy;
	
	
	
	
	public Bola(int x,int y){
		xpos=x;
		ypos=y;
		xvel=0;
		yvel=0;
		auxx=-1;
		auxy=1;	
		tamaño=17;
		color=Color.BLUE;
	}
	
	
	/* Metodos */
	
		
	public void moverBola(int x,int y){
		xpos=x;
		ypos=y;
	}
	
	public void alterarVelocidadBola(float x,float y){
		xvel=x;
		yvel=y;
	}
	
	public Rectangle getLimites(){
		return new Rectangle(xpos,ypos,tamaño,tamaño);
		
	}
	
	public boolean colisionNave(Nave n){
		return n.getLimites().intersects(getLimites());
	}
	
	public void reiniciarBola(Nave n){
		moverBola(n.getX()+20,n.getY()-tamaño);
	}

	
	/*Con el segundo bucle compruebo todo el lateral del "cuadrado" que contiene la bola*/
	
	public Colision colisionBloqueExacta(Bloque b){
		
		int contador=0;
		Colision c = new Colision();
		
		/*Compruebo si toca por el sur del bloque*/
		for(int i=0;i<b.getAncho();i++){
			for(int j=0;j<=getTamaño();j++){
				if(getYpos() == b.getY()+b.getLargo() && getXpos()+j==b.getX()+i){
					contador++;
					c.setPosicioncolision(Bloque.SUR);
				}
			}
		}
		
		/*Compruebo si toca por el este del bloque*/
		for(int i=0;i<b.getLargo();i++){
			for(int j=0;j<=getTamaño();j++){
				if(getXpos()== b.getX()+b.getAncho() && getYpos()+j==b.getY()+i){
					contador++;
					c.setPosicioncolision(Bloque.ESTE);
				}
			}
		}
		
		/*Compruebo si toca por el oeste del bloque*/
		for(int i=0;i<b.getLargo();i++){
			for(int j=0;j<getTamaño();j++){
				if(getXpos()+getTamaño()== b.getX() && getYpos()+j==b.getY()+i){
					contador++;
					c.setPosicioncolision(Bloque.OESTE);
				}
			}
		}
		
		/*Compruebo si toca por el norte del bloque*/
		for(int i=0;i<b.getAncho();i++){
			for(int j=0;j<getTamaño();j++){
				if(getYpos()+getTamaño()== b.getY() && getXpos()+j==b.getX()+i){
					contador++;
					c.setPosicioncolision(Bloque.NORTE);
				}
			}
		}
		
		c.setPorcentajecolision(contador);
		
		if(c.getPosicioncolision()==0){
			c.setPosicioncolision(Bloque.NO_COLISION);
		}
		
		return c;
	}
	
	
	public Colision colisionNaveExacta(Nave n){
		
		int contador=0;
		Colision c = new Colision();
		
		
		/*Compruebo si toca por el este del bloque*/
		for(int i=0;i<n.getAncho();i++){
			for(int j=0;j<=getTamaño();j++){
				if(getXpos()== n.getX()+n.getLargo() && getYpos()+j==n.getY()+i){
					contador++;
					c.setPosicioncolision(Bloque.ESTE);
				}
			}
		}
		
		/*Compruebo si toca por el oeste del bloque*/
		for(int i=0;i<n.getAncho();i++){
			for(int j=0;j<getTamaño();j++){
				if(getXpos()+getTamaño()== n.getX() && getYpos()+j==n.getY()+i){
					contador++;
					c.setPosicioncolision(Bloque.OESTE);
				}
			}
		}
		
		/*Compruebo si toca por el norte del bloque*/
		for(int i=0;i<n.getLargo();i++){
			for(int j=0;j<getTamaño();j++){
				if(getYpos()+getTamaño()== n.getY() && getXpos()+j==n.getX()+i){
					contador++;
					c.setPosicioncolision(Bloque.NORTE);
				}
			}
		}
		
		c.setPorcentajecolision(contador);
		
		if(c.getPosicioncolision()==0){
			c.setPosicioncolision(Bloque.NO_COLISION);
		}
		
		return c;
	}
	
	
	
	/*Getters y Setters*/
	

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	
	public int getXpos() {
		return xpos;
	}

	public void setXpos(int xpos) {
		this.xpos = xpos;
	}

	public int getYpos() {
		return ypos;
	}

	public void setYpos(int ypos) {
		this.ypos = ypos;
	}

	public float getXvel() {
		return xvel;
	}

	public void setXvel(float xvel) {
		this.xvel = xvel;
	}

	public float getYvel() {
		return yvel;
	}

	public void setYvel(float yvel) {
		this.yvel = yvel;
	}

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}

	public int getAuxx() {
		return auxx;
	}


	public void setAuxx(int auxx) {
		this.auxx = auxx;
	}

	public int getAuxy() {
		return auxy;
	}

	public void setAuxy(int auxy) {
		this.auxy = auxy;
	}
	
}
