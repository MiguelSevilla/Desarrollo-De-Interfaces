package Hilos;

import Modelo.Mundo;
import Modelo.UT1P02Vista;


public class UT1P02Pinta extends Thread{

	UT1P02Vista jp;
	Mundo m;
	
	public UT1P02Pinta(UT1P02Vista jp,Mundo m){
		this.jp=jp;
		this.m=m;
		
	}
	
	public void run(){
		while(true){
			
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
