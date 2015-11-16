package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Mundo;


public class MenuDesplegable extends JMenuBar{

	 private JMenu menu1,menu3;
	 private JMenuItem item1, item2, item5 ,item6;
	 Mundo m;
	
	
	public MenuDesplegable(Mundo m){
		super();
		this.m=m;
		
		menu1 = new JMenu("Editar");
        add(menu1);
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
	        
	        item5 = new JMenuItem("Controles");
	        
	        item5.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){ Instrucciones dialog = new Instrucciones();
		         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		         dialog.setVisible(true);}
			});
	        menu3.add(item5);
	        
	        item6 = new JMenuItem("Acerca de...");
	        item6.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){ Acercade dialog = new Acercade();
		         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		         dialog.setVisible(true);}
			});
	        menu3.add(item6);

	}
	
	
	public class Instrucciones extends JDialog{
		
		private final JPanel contentPanel = new JPanel();
		
		public Instrucciones() {
	        // evita cambio de tamaño
	        setResizable(false);
	        // título del diáolog
	        setTitle("Como jugar");
	        // dimensiones que ocupa en la pantalla
	        setBounds(30, 100, 450, 110);
	        // capa que contendrá todo
	        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
	        JLabel miEtiqueta = new JLabel("Utiliza el espacio para lanzar la bola");
	        contentPanel.add(miEtiqueta);
	        JLabel miEtiqueta2 = new JLabel("Usa las flechas <- y -> para mover la nave a la izquierda y hacia la derecha.");
	        contentPanel.add(miEtiqueta2);
	        JLabel miEtiqueta3 = new JLabel("Ganas si destruyes todos los bloques");
	        contentPanel.add(miEtiqueta3);
	        // borde de la ventan
	        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	        // pone el panel centrado
	        getContentPane().add(contentPanel);
	        //Ponerlo como modal
	        setModal(true);
	        
	    }
	}
	
	public class Acercade extends JDialog{
		
		private final JPanel contentPanel = new JPanel();
		
		public Acercade() {
	        // evita cambio de tamaño
	        setResizable(false);
	        // título del diáolog
	        setTitle("Acerca de");
	        // dimensiones que ocupa en la pantalla
	        setBounds(100, 100, 325, 130);
	        // capa que contendrá todo
	        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
	        JLabel miEtiqueta = new JLabel("Autor: Miguel Ángel Sevilla Alonso");
	        contentPanel.add(miEtiqueta);
	        JLabel miEtiqueta2 = new JLabel("Ciclo: Desarrollo de Aplicaciones Multiplataforma");
	        contentPanel.add(miEtiqueta2);
	        JLabel miEtiqueta3 = new JLabel("Modulo: Desarrollo de Interfaces");
	        contentPanel.add(miEtiqueta3);
	        JLabel miEtiqueta4 = new JLabel("Edad apropiada: 3 - 99 años");
	        contentPanel.add(miEtiqueta4);
	        // borde de la ventan
	        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	        // pone el panel centrado
	        getContentPane().add(contentPanel);
	        //Ponerlo como modal
	        setModal(true);
	        
	    }
	}

}
