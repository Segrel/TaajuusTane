package TaajuusTane;

/** Luokka kompleksiluvuille. */
public class Analyysi {
  /** Signaali. */
  private Kompleksi[] signaali;
  /** Signaali Fourier-muunnoksen jälkeen. */
  private Kompleksi[] muunnos;
  /** Näytteenottotaajuus. */
  private double naytteenottotaajuus;
  /** Analyysin sivuuttamien näytteiden määrä. */
  private int sivuutettuja = 0;

  /** Luo uusi taajuusanalyysi.
  *
  * @param signaali Signaali aikatasossa
  * @param naytteenottotaajuus Signaalin näytteenottotaajuus
  * @throws IllegalArgumentException Signaali ei ole kelvollinen
  */
  public Analyysi(Kompleksi[] signaali, double naytteenottotaajuus) throws IllegalArgumentException {
    int n = signaali.length;
    if (n < 2) {
      throw new IllegalArgumentException("Signaalisyöte on liian lyhyt.");
    }
    // Käytetty algoritmi edellyttää syötteen vektorin pituudeksi jonkin kahden potenssin
    int leikkauspiste = kahdenPotenssiKorkeintaan(n);
    if (n != leikkauspiste) {
      signaali = leikkaa(signaali, leikkauspiste);
      sivuutettuja = n - leikkauspiste;
    }
    this.signaali = signaali;
    if (naytteenottotaajuus < 1) {
      throw new IllegalArgumentException("Näytteenottotaajuus ei voi olla alle 1Hz.");
    }
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

  /** Montako ääninäytettä jätettiin analysoimatta.
  *
  * @return Sivuutettujen ääninäytteiden määrä
  */
  public int sivuutettuja() {
    return sivuutettuja;
  }

  /** Etsi suurin kahden potenssi, joka on enintään annettu luku.
  *
  * @param n Luku
  * @return Suurin löydetty luku
  */
  private static int kahdenPotenssiKorkeintaan(int n) {
    return (int) Math.pow(2, Math.floor(Math.log(n) / Math.log(2)));
  }

  /** Leikkaa signaali halutun pituiseksi.
  *
  * @param signaali Taulukko
  * @param leikkauspiste Leikatun taulukon pituus
  * @return Leikattu taulukko
  */
  private static Kompleksi[] leikkaa(Kompleksi[] signaali, int leikkauspiste) {
    Kompleksi[] leikattuSignaali = new Kompleksi[leikkauspiste];
    for (int i = 0; i < leikkauspiste; i += 1) {
      leikattuSignaali[i] = signaali[i];
    }
    return leikattuSignaali;
  }
}
