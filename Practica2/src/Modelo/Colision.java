package Modelo;

public class Colision {

	private int posicioncolision; // Posicion de la bola donde choca con el bloque
	private int porcentajecolision;
	
	
	public Colision(){
		posicioncolision=0;
		porcentajecolision=0;
	}
	
	
	
	public int getPosicioncolision() {
		return posicioncolision;
	}


	public void setPosicioncolision(int posicioncolision) {
		this.posicioncolision = posicioncolision;
	}


	public int getPorcentajecolision() {
		return porcentajecolision;
	}


	public void setPorcentajecolision(int porcentajecolision) {
		this.porcentajecolision = porcentajecolision;
	}

	
	
}
