package modelo;

import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Musica {
	/*
	 * Clase para poner musica de fondo en el local
	 */

	private ArrayList<String> opcionesMusica;

	public Musica() {
		opcionesMusica = new ArrayList<>();
		opcionesMusica.add("resources/3DInstrumental.mp3");

	}

	public ArrayList<String> getOpcionesMusica() {
		return opcionesMusica;
	}

	public void lanzar(int indice) {
		if (indice >= 0 && indice < opcionesMusica.size()) {
			String rutaMP3 = opcionesMusica.get(indice);

			this.reproducirEnBucle(rutaMP3);
		}
	}

	public void reproducirEnBucle(String rutaMP3) {
		try {
			// Crear un objeto AdvancedPlayer con la ruta del archivo MP3
			FileInputStream fileInputStream = new FileInputStream(rutaMP3);
			Bitstream bitstream = new Bitstream(fileInputStream);
			int totalFrames = bitstream.readFrame().max_number_of_frames(0);
			fileInputStream.close();

			AdvancedPlayer player = new AdvancedPlayer(new FileInputStream(rutaMP3));

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

			player.play();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}// FIN CLASS
