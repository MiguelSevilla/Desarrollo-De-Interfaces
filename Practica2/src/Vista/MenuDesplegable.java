package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Modelo.Mundo;

public class MenuDesplegable extends JMenuBar{

	 private JMenu menu1,menu2,menu3;
	 private JMenuItem item1, item2, item3, item4, item5 ,item6;
	 Mundo m;
	
	
	public MenuDesplegable(Mundo m){
		super();
		this.m=m;
		
		menu1 = new JMenu("Editar");
        add(menu1);
        menu2 = new JMenu("Nivel");
        add(menu2);
        menu3 = new JMenu("Ayuda");
        add(menu3);

	        item1 = new JMenuItem("Nueva Partida");
	        item1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                m.reiniciarMundo();
	            }
	        });
	        menu1.add(item1);

	        item2 = new JMenuItem("Salir");
	        menu1.add(item2);
	        item2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	System.exit(0);
	            }
	        });
	        
	        item3 = new JMenuItem("Nivel 1");
	        menu2.add(item3);
	        
	        item4 = new JMenuItem("Nivel 2");
	        menu2.add(item4);
	        
	        item5 = new JMenuItem("Controles");
	        menu3.add(item5);
	        
	        item6 = new JMenuItem("Acerca de");
	        menu3.add(item6);

	}
}
