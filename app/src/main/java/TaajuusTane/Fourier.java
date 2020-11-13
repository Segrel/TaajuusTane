package TaajuusTane;

/** Luokka Fourier-muunnoksille. */
public class Fourier {
  /** Tee Fourier-muunnos.
  *
  * @param signaali Syöte
  * @return Tulos
  * @throws IllegalArgumentException Syöte on virheellinen
  */
  public static Kompleksi[] muunnos(Kompleksi[] signaali) throws IllegalArgumentException {
    int n = signaali.length;
    if (n < 2) {
      throw new IllegalArgumentException("Syötteessä tulee olle vähintään 2 elementtiä.");
    }
    // Käytetty algoritmi edellyttää syötteen vektorin pituudeksi jonkin kahden potenssin
    int leikkauspiste = kahdenPotenssiKorkeintaan(n);
    if (n != leikkauspiste) {
      System.out.println("Jätetään viimeiset " + Integer.toString(n - leikkauspiste) + " näytettä huomiotta.");
      signaali = leikkaa(signaali, leikkauspiste);
    }
    return fft(signaali);
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

  /** Cooley-Tukey, radix 2, decimation in time (DIT).
  *
  * @param signaali Syöte jonka pituus on kahden potenssi
  * @return Tulos
  */
  private static Kompleksi[] fft(Kompleksi[] signaali) {
    int n = signaali.length;
    if (n == 1) {
      Kompleksi[] x = { signaali[0] };
      return x;
    }
    Kompleksi[] otos = new Kompleksi[n / 2];
    for (int k = 0; k < (n / 2); k += 1) {
      otos[k] = signaali[2 * k];
    }
    Kompleksi[] parilliset = fft(otos);
    for (int k = 0; k < (n / 2); k += 1) {
      otos[k] = signaali[2 * k + 1];
    }
    Kompleksi[] parittomat = fft(otos);
    Kompleksi[] x = new Kompleksi[n];
    for (int k = 0; k < (n / 2); k += 1) {
      Kompleksi w = Kompleksi.eksponentti(-2.0 * Math.PI * ((double) k / (double) n));
      x[k] = Kompleksi.summa(parilliset[k], Kompleksi.tulo(w, parittomat[k]));
      x[k + (n / 2)] = Kompleksi.erotus(parilliset[k], Kompleksi.tulo(w, parittomat[k]));
    }
    return x;
  }
}
