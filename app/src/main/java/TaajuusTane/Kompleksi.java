package TaajuusTane;

/** Luokka kompleksiluvuille */
public class Kompleksi {
  /** Reaaliosa */
  public double a;
  /** Imaginaariosa */
  public double b;

  /** Luo kompleksiluku a + bi
  * @param a Reaaliosa
  * @param b Imaginaariosa
  */
  public Kompleksi(double a, double b) {
    this.a = a;
    this.b = b;
  }

  /** Laske kahden kompleksiluvun summa
  * @param z Ensimmäinen termi
  * @param w Toinen termi
  * @return Summa
  */
  public static Kompleksi summa(Kompleksi z, Kompleksi w) {
    return new Kompleksi(z.a + w.a, z.b + w.b);
  }

  /** Laske kahden kompleksiluvun erotus
  * @param z Ensimmäinen termi
  * @param w Toinen termi
  * @return Erotus
  */
  public static Kompleksi erotus(Kompleksi z, Kompleksi w) {
    return new Kompleksi(z.a - w.a, z.b - w.b);
  }

  /** Laske kahden kompleksiluvun tulo
  * @param z Ensimmäinen termi
  * @param w Toinen termi
  * @return Tulo
  */
  public static Kompleksi tulo(Kompleksi z, Kompleksi w) {
    return new Kompleksi(z.a * w.a - z.b * w.b, z.a * w.b + z.b * w.a);
  }

  /** Laske kompleksiluku e^(ix)
  * @param x Vaihekulma
  * @return Eksponentti
  */
  public static Kompleksi eksponentti(double x) {
    return new Kompleksi(Math.cos(x), Math.sin(x));
  }

  /** Laske kompleksiluvun moduli eli itseisarvo
  * @param z Kompleksiluku
  * @return Moduli
  */
  public static double moduli(Kompleksi z) {
    return Math.sqrt(z.a * z.a + z.b * z.b);
  }
}
