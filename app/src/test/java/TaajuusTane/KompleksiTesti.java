package TaajuusTane;

import org.junit.Test;
import static org.junit.Assert.*;

public class KompleksiTesti {
  @Test public void konstruktoriToimii() {
    Kompleksi k = new Kompleksi(1.0, 0.0);
    assertEquals(k.a, 1.0, 0.001);
    assertEquals(k.b, 0.0, 0.001);
  }

  // (a,b)+(c,d) = (a+c,b+d)
  @Test public void summaToimii() {
    Kompleksi k1 = new Kompleksi(3.0, 2.1);
    Kompleksi k2 = new Kompleksi(2.0, 1.6);
    Kompleksi summa = Kompleksi.summa(k1, k2);
    assertEquals(summa.a, 5.0, 0.001);
    assertEquals(summa.b, 3.7, 0.001);
  }

  // (a,b)-(c,d) = (a-c,b-d)
  @Test public void erotusToimii() {
    Kompleksi k1 = new Kompleksi(3.0, 2.1);
    Kompleksi k2 = new Kompleksi(2.0, 1.6);
    Kompleksi erotus = Kompleksi.erotus(k1, k2);
    assertEquals(erotus.a, 1.0, 0.001);
    assertEquals(erotus.b, 0.5, 0.001);
  }

  // (a,b)(c,d) = (ac−bd,ad+bc)
  @Test public void tuloToimii() {
    Kompleksi k1 = new Kompleksi(3.0, 2.0);
    Kompleksi k2 = new Kompleksi(1.0, 7.0);
    Kompleksi tulo = Kompleksi.tulo(k1, k2);
    assertEquals(tulo.a, -11.0, 0.001);
    assertEquals(tulo.b, 23.0, 0.001);
  }

  // e^(ix) = (cos(x), sin(x))
  @Test public void eksponenttiToimii() {
    Kompleksi k = Kompleksi.eksponentti(Math.PI);
    assertEquals(k.a, -1.0, 0.001);
    assertEquals(k.b, 0.0, 0.001);
  }

  // |k| = sqrt(aa+bb)
  @Test public void moduliToimii() {
    double d = Kompleksi.moduli(new Kompleksi(4.0, 3.0));
    assertEquals(d, 5.0, 0.001);
  }
}
