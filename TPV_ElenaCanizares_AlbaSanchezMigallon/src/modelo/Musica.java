package modelo;

import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.FileInputStream;
import java.io.IOException;

public class Musica {
	
	public Musica() {
		lanzar();
	}
	

	public  void lanzar() {
		// Ruta del archivo MP3
		String rutaMP3 = "resources/musica/piano.mp3";

		// Crear un objeto de la clase ReproductorMP3
		

		// Reproducir el sonido en bucle
		this.reproducirEnBucle(rutaMP3);
	}

	public void reproducirEnBucle(String rutaMP3) {

		try {
			// Crear un objeto AdvancedPlayer con la ruta del archivo MP3
			FileInputStream fileInputStream = new FileInputStream(rutaMP3);
			Bitstream bitstream = new Bitstream(fileInputStream);
			int totalFrames = bitstream.readFrame().max_number_of_frames(0);
			fileInputStream.close();

			AdvancedPlayer player = new AdvancedPlayer(new FileInputStream("resources/musica/piano.mp3"));

			// Agregar un listener para manejar eventos de reproducción
			player.setPlayBackListener(new PlaybackListener() {
				@Override
				public void playbackFinished(PlaybackEvent evt) {
					// Reproducir en bucle al alcanzar el final del archivo MP3
					if (evt.getFrame() == totalFrames) {
						try {
							player.close();
							reproducirEnBucle(rutaMP3);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});

			// Iniciar la reproducción
			player.play();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
