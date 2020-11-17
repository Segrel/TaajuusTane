package TaajuusTane;

/** Luokka kompleksiluvuille. */
public class Kompleksi {
  /** Reaaliosa. */
  private double a;
  /** Imaginaariosa. */
  private double b;

  /** Luo kompleksiluku a + bi.
  *
  * @param reaali Reaaliosa
  * @param imaginaari Imaginaariosa
  */
  public Kompleksi(double reaali, double imaginaari) {
    this.a = reaali;
    this.b = imaginaari;
  }

  /** Laske kahden kompleksiluvun summa.
  *
  * @param z Ensimmäinen termi
  * @param w Toinen termi
  * @return Summa
  */
  public static Kompleksi summa(Kompleksi z, Kompleksi w) {
    return new Kompleksi(z.a + w.a, z.b + w.b);
  }

  /** Laske kahden kompleksiluvun erotus.
  *
  * @param z Ensimmäinen termi
  * @param w Toinen termi
  * @return Erotus
  */
  public static Kompleksi erotus(Kompleksi z, Kompleksi w) {
    return new Kompleksi(z.a - w.a, z.b - w.b);
  }

  /** Laske kahden kompleksiluvun tulo.
  *
  * @param z Ensimmäinen termi
  * @param w Toinen termi
  * @return Tulo
  */
  public static Kompleksi tulo(Kompleksi z, Kompleksi w) {
    return new Kompleksi(z.a * w.a - z.b * w.b, z.a * w.b + z.b * w.a);
  }

  /** Laske kompleksiluku e^(ix).
  *
  * @param x Vaihekulma
  * @return Eksponentti
  */
  public static Kompleksi eksponentti(double x) {
    return new Kompleksi(Math.cos(x), Math.sin(x));
  }

  /** Laske kompleksiluvun moduli eli itseisarvo.
  *
  * @param z Kompleksiluku
  * @return Moduli
  */
  public static double moduli(Kompleksi z) {
    return Math.sqrt(z.a * z.a + z.b * z.b);
  }

  /** Palauta kompleksiluvun reaaliosa.
  *
  * @return Reaaliosa
  */
  public double reaali() {
    return a;
  }

  /** Palauta kompleksiluvun imaginaariosa.
  *
  * @return Imaginaariosa
  */
  public double imaginaari() {
    return b;
  }
}
