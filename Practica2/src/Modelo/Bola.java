package Modelo;

import java.awt.Color;
import java.awt.Rectangle;

/*Clase con los metodos y atributos de la bola del juego*/

public class Bola {

	private int xpos;
	private int ypos;
	private int tama�o;
	private int auxx;
	private int auxy;
	
	/*CONSTANTES*/
	final static int ABAJO = 1;
	final static int ARRIBA = -1;
	final static int DERECHA = 1;
	final static int IZQUIERDA = -1;
	
	
	/*CONSTRUCTORES*/
	
	public Bola(int x,int y){
		xpos=x;
		ypos=y;
		auxx=-1;
		auxy=1;	
		tama�o=17;
	}
	
	
	/* METODOS */
	
		
	public void moverBola(int x,int y){
		xpos=x;
		ypos=y;
	}
	
	
	public void reiniciarBola(Nave n){
		moverBola(n.getX()+20,n.getY()-tama�o);
	}

	
	/*Con el segundo bucle compruebo todo el lateral del "cuadrado" que contiene la bola*/
	
	public Colision colisionBloqueExacta(Bloque b){
		
		int contador=0;
		Colision c = new Colision();
		
		/*Compruebo si toca por el sur del bloque*/
		for(int i=0;i<b.getAncho();i++){
			for(int j=0;j<=getTama�o();j++){
				if(getYpos() == b.getY()+b.getLargo() && getXpos()+j==b.getX()+i){
					contador++;
					c.setPosicioncolision(Bloque.SUR);
				}
			}
		}
		
		/*Compruebo si toca por el este del bloque*/
		for(int i=0;i<b.getLargo();i++){
			for(int j=0;j<=getTama�o();j++){
				if(getXpos()== b.getX()+b.getAncho() && getYpos()+j==b.getY()+i){
					contador++;
					c.setPosicioncolision(Bloque.ESTE);
				}
			}
		}
		
		/*Compruebo si toca por el oeste del bloque*/
		for(int i=0;i<b.getLargo();i++){
			for(int j=0;j<getTama�o();j++){
				if(getXpos()+getTama�o()== b.getX() && getYpos()+j==b.getY()+i){
					contador++;
					c.setPosicioncolision(Bloque.OESTE);
				}
			}
		}
		
		/*Compruebo si toca por el norte del bloque*/
		for(int i=0;i<b.getAncho();i++){
			for(int j=0;j<getTama�o();j++){
				if(getYpos()+getTama�o()== b.getY() && getXpos()+j==b.getX()+i){
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
			for(int j=0;j<=getTama�o();j++){
				if(getXpos()== n.getX()+n.getLargo() && getYpos()+j==n.getY()+i){
					contador++;
					c.setPosicioncolision(Bloque.ESTE);
				}
			}
		}
		
		/*Compruebo si toca por el oeste del bloque*/
		for(int i=0;i<n.getAncho();i++){
			for(int j=0;j<getTama�o();j++){
				if(getXpos()+getTama�o()== n.getX() && getYpos()+j==n.getY()+i){
					contador++;
					c.setPosicioncolision(Bloque.OESTE);
				}
			}
		}
		
		/*Compruebo si toca por el norte del bloque*/
		for(int i=0;i<n.getLargo();i++){
			for(int j=0;j<getTama�o();j++){
				if(getYpos()+getTama�o()== n.getY() && getXpos()+j==n.getX()+i){
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


	public int getTama�o() {
		return tama�o;
	}

	public void setTama�o(int tama�o) {
		this.tama�o = tama�o;
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
