package TaajuusTane;

/** Luokka kompleksiluvuille. */
public class Analyysi {
  /** Signaali. */
  private Kompleksi[] signaali;
  /** Signaali Fourier-muunnoksen jälkeen. */
  private Kompleksi[] muunnos;
  /** Näytteenottotaajuus. */
  private double naytteenottotaajuus;

  /** Luo uusi taajuusanalyysi.
  *
  * @param signaali Signaali aikatasossa
  * @param naytteenottotaajuus Signaalin näytteenottotaajuus
  * @throws IllegalArgumentException Signaali ei ole kelvollinen
  */
  public Analyysi(Kompleksi[] signaali, double naytteenottotaajuus) throws IllegalArgumentException {
    if (signaali.length < 2) {
      throw new IllegalArgumentException("Signaalisyöte on liian lyhyt.");
    }
    if (naytteenottotaajuus < 1) {
      throw new IllegalArgumentException("Näytteenottotaajuus ei voi olla alle 1Hz.");
    }
    this.signaali = signaali;
    this.naytteenottotaajuus = naytteenottotaajuus;
  }

  /** Määritä signaalin perustaajuus.
  *
  * @return Perustaajuus hertseissä.
  */
  public int perustaajuus() {
    muunnos = Fourier.muunnos(this.signaali);
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
    return (int) ((naytteenottotaajuus / muunnos.length) * suurinIndeksi);
  }
}
