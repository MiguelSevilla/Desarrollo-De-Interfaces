package Modelo;

/*Clase que genera un objeto colision, donde tiene un porcentaje de colision y la posicion donde se produce
 * respecto a un objeto*/
public class Colision {

	private int posicioncolision; // Posicion de la bola donde choca con el bloque
	private int porcentajecolision; // Este atributo no se utiliza en las comprobaciones, lo cree para una version posterior
	
	
	public Colision(){
		posicioncolision=0;
		porcentajecolision=0;
	}
	
	
	/*Getters y setters*/
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
