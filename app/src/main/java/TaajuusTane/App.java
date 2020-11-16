package TaajuusTane;

import java.io.File;

/** Komentorivikäyttöliittymä TaajuusTanelle. */
public class App {
  /** Suorita tallenteen analyysi.
  *
  * @param args Komentoriviargumentit
  * @throws Exception Poikkeus sovelluksen suorituksessa
  */
  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      throw new Exception("Anna komentoriviargumenttina polku tallenteeseen.");
    }
    Kompleksi[] signaali = Tallenne.lue(args[0]);
    System.out.println("Luettiin audiotiedostosta " + Integer.toString(signaali.length) + " näytettä.");
    Kompleksi[] muunnos = Fourier.muunnos(signaali);
    double suurin = 0.0;
    int suurinIndeksi = 0;
    // Meitä kiinnostaa vain ensimmäiset ~22kHz
    for (int i = 0; i < (muunnos.length / 2); i += 1) {
      double m = Kompleksi.moduli(muunnos[i]);
      if (m > suurin) {
        suurin = m;
        suurinIndeksi = i;
      }
    }
    int perustaajuus = (int) ((44100.0 / muunnos.length) * suurinIndeksi);
    System.out.println("Analyysi: perustaajuus on " + Integer.toString(perustaajuus) + "Hz.");
  }
}
