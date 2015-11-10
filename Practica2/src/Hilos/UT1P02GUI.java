package Hilos;

import Vista.FrameMundo;

/*Clase que crea un hilo que lanza la ventana principal del programa*/
public class UT1P02GUI  extends Thread{


	
	public UT1P02GUI(){

	}
	
	public void run(){
		new FrameMundo();
	}
	
	
	
}
