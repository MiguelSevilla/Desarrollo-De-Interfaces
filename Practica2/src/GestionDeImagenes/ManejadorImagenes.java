package GestionDeImagenes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ManejadorImagenes {


	private ArrayList<BufferedImage> imgbloque;
	private BufferedImage imgbola;
	private BufferedImage imgnave;
	private BufferedImage imgpantalla;
	private BufferedImage imgmarcoizq;
	private BufferedImage imgmarcoder;
	private BufferedImage imgmarcoarriba;
	
	public ManejadorImagenes(){
		
		
		inicializaPantalla();
		inicializaMarco();
		inicializaBola();
		inicializaNave();
		imgbloque = new ArrayList<BufferedImage>();
		inicializaBloques();
		
	}
	

	
	public void inicializaPantalla(){
		try {
			imgpantalla = ImageIO.read(new File("img/Background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void inicializaBola(){
		try {
			imgbola = ImageIO.read(new File("img/bola.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void inicializaNave(){
		try {
			imgnave = ImageIO.read(new File("img/minave.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void inicializaBloques(){
		try {
			imgbloque.add(ImageIO.read(new File("img/bloquepref.gif")));
			imgbloque.add(ImageIO.read(new File("img/bloqueazul.gif")));
			imgbloque.add(ImageIO.read(new File("img/bloquenaranja.gif")));
			imgbloque.add(ImageIO.read(new File("img/bloquerosa.gif")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void inicializaMarcoIzquierda(){
		try {
			imgmarcoizq=ImageIO.read(new File("img/marcoizquierda.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void inicializaMarcoDerecha(){
		try {
			imgmarcoder=ImageIO.read(new File("img/marcoderecha.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void inicializaMarcoArriba(){
		try {
			imgmarcoarriba=ImageIO.read(new File("img/marcoarriba.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void inicializaMarco(){
		inicializaMarcoDerecha();
		inicializaMarcoIzquierda();
		inicializaMarcoArriba();
	}
	
	
	/*Getters y setters*/
	
	
	public BufferedImage getImgmarcoizq() {
		return imgmarcoizq;
	}



	public void setImgmarcoizq(BufferedImage imgmarcoizq) {
		this.imgmarcoizq = imgmarcoizq;
	}



	public BufferedImage getImgmarcoder() {
		return imgmarcoder;
	}



	public void setImgmarcoder(BufferedImage imgmarcoder) {
		this.imgmarcoder = imgmarcoder;
	}



	public BufferedImage getImgmarcoarriba() {
		return imgmarcoarriba;
	}



	public void setImgmarcoarriba(BufferedImage imgmarcoarriba) {
		this.imgmarcoarriba = imgmarcoarriba;
	}
	
	public ArrayList<BufferedImage> getImgbloque() {
		return imgbloque;
	}



	public void setImgbloque(ArrayList<BufferedImage> imgbloque) {
		this.imgbloque = imgbloque;
	}



	public BufferedImage getImgbola() {
		return imgbola;
	}



	public void setImgbola(BufferedImage imgbola) {
		this.imgbola = imgbola;
	}



	public BufferedImage getImgnave() {
		return imgnave;
	}



	public void setImgnave(BufferedImage imgnave) {
		this.imgnave = imgnave;
	}



	public BufferedImage getImgpantalla() {
		return imgpantalla;
	}



	public void setImgpantalla(BufferedImage imgpantalla) {
		this.imgpantalla = imgpantalla;
	}
	


}
