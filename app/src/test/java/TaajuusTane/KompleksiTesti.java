package TaajuusTane;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KompleksiTesti {
  @Test public void konstruktoriToimii() {
    Kompleksi k = new Kompleksi(1.0, 0.0);
    assertEquals(1.0, k.a, 0.001);
    assertEquals(0.0, k.b, 0.001);
  }

  // (a,b)+(c,d) = (a+c,b+d)
  @Test public void summaToimii() {
    Kompleksi k1 = new Kompleksi(3.0, 2.1);
    Kompleksi k2 = new Kompleksi(2.0, 1.6);

    Kompleksi summa = Kompleksi.summa(k1, k2);
    assertEquals(5.0, summa.a, 0.001);
    assertEquals(3.7, summa.b, 0.001);
  }

  // (a,b)-(c,d) = (a-c,b-d)
  @Test public void erotusToimii() {
    Kompleksi k1 = new Kompleksi(3.0, 2.1);
    Kompleksi k2 = new Kompleksi(2.0, 1.6);

    Kompleksi erotus = Kompleksi.erotus(k1, k2);
    assertEquals(1.0, erotus.a, 0.001);
    assertEquals(0.5, erotus.b, 0.001);
  }

  // (a,b)(c,d) = (ac−bd,ad+bc)
  @Test public void tuloToimii() {
    Kompleksi k1 = new Kompleksi(3.0, 2.0);
    Kompleksi k2 = new Kompleksi(1.0, 7.0);

    Kompleksi tulo = Kompleksi.tulo(k1, k2);
    assertEquals(-11.0, tulo.a, 0.001);
    assertEquals(23.0, tulo.b, 0.001);
  }

  // e^(ix) = (cos(x), sin(x))
  @Test public void eksponenttiToimii() {
    Kompleksi k = Kompleksi.eksponentti(Math.PI);
    assertEquals(-1.0, k.a, 0.001);
    assertEquals(0.0, k.b, 0.001);
  }

  // |k| = sqrt(aa+bb)
  @Test public void moduliToimii() {
    double d = Kompleksi.moduli(new Kompleksi(4.0, 3.0));
    assertEquals(5.0, d, 0.001);
  }
}
