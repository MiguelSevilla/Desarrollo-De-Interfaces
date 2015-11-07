package GestionDeSonido;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.midi.Soundbank;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ManejadorSonidos{

	
	
		public static final AudioClip PARED = Applet.newAudioClip(ManejadorSonidos.class.getResource("sounds/colisionpared.mp3"));

	
	
	
	
	public void sonidoPared() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		BufferedInputStream bis = new BufferedInputStream(getClass().getResourceAsStream("sounds/colisionpared.mp3"));
		System.out.println("buffer: "+bis);
		AudioInputStream ais = AudioSystem.getAudioInputStream(bis);
		System.out.println("AudioInputStream: "+ais);
		Clip sonido=AudioSystem.getClip();
		sonido.open(ais);
		sonido.start();
		System.out.println("buffer: "+bis+ "  AudioInputStream: "+ais+"  Clip: "+sonido);
	}
	
}
