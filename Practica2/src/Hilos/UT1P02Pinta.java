package Hilos;

import Modelo.Mundo;
import Vista.PanelPintar;

/*Clase que crea un hilo que repinta constantemente la pantalla del juego*/
public class UT1P02Pinta extends Thread{

	PanelPintar jp;
	Mundo m;
	
	public UT1P02Pinta(PanelPintar jp,Mundo m){
		this.jp=jp;
		this.m=m;
		
	}
	
	public void run(){
		/*blucle infinito para que repinte constantemente el juego*/
		while(true){
			/*Metodo que limpia y pinta la pantalla*/
			jp.repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
