package Hilos;

import Modelo.Mundo;
import Vista.PanelPintar;

/*Clase que genera un hilo que mueve el juego, se actualiza la bola constantemente*/
public class UT1P02Tiempo extends Thread{

	PanelPintar jp;
	Mundo m;
	
	public UT1P02Tiempo(PanelPintar jp,Mundo m){
		this.jp=jp;
		this.m=m;
		
	}
	
	public void run(){
		while(true){
			m.moverBolaAutomaticamente();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
