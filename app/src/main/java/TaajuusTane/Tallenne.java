package TaajuusTane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

/** Luokka Tallenne-tiedostojen käsittelylle. */
public class Tallenne {
  /** Lue Tallenne-tiedosto.
  *
  * @param tiedostopolku Tiedostopolku luettavaan tiedostoon
  * @return Taulukko ääninäytteitä
  * @throws Exception Tiedoston käsittelyssä tapahtui virhe
  * @throws FileNotFoundException Annettua tiedostoa ei ole olemassa
  * @throws IOException Tiedoston luvussa tapahtui virhe
  * @throws UnsupportedAudioFileException Tallenteen audioformaatti ei ole tuettu
  */
  public static Kompleksi[] lue(String tiedostopolku)
      throws Exception, FileNotFoundException, IOException, UnsupportedAudioFileException {
    File tiedosto = new File(tiedostopolku);
    AudioInputStream audiovuo = AudioSystem.getAudioInputStream(tiedosto);
    AudioFormat metadata = audiovuo.getFormat();
    if (!metadata.getEncoding().equals(AudioFormat.Encoding.PCM_SIGNED)) {
      throw new Exception("Tallenteen tulee olla etumerkillisessä PCM-muodossa.");
    }
    if (metadata.isBigEndian()) {
      throw new Exception("Tallenteen tulee olla little-endian tavujärjestyksessä.");
    }
    if (metadata.getFrameRate() != 44100) {
      throw new Exception("Tallenteen näytteenottotaajuuden tulee olla 44.1 kHz.");
    }
    if (metadata.getFrameSize() != 2) {
      throw new Exception("Tallenteen näytteiden bittimäärän tulee olla 16.");
    }
    if (metadata.getChannels() != 1) {
      throw new Exception("Tallenteen tulee olla yksikanavainen.");
    }
    int pituus = (int) audiovuo.getFrameLength();
    Kompleksi[] data = new Kompleksi[pituus];
    ByteBuffer puskuri = ByteBuffer.allocate(2);
    puskuri.order(ByteOrder.LITTLE_ENDIAN);
    for (int i = 0; i < pituus; i += 1) {
      if (audiovuo.read(puskuri.array()) == -1) {
        throw new Exception(String.format("Oletettiin %d näytettä, luettiin vain %d.", pituus, (i + 1)));
      }
      data[i] = new Kompleksi(puskuri.getShort(0), 0.0);
    }
    return data;
  }
}
