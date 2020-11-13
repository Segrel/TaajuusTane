package TaajuusTane;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FourierTesti {
  @Test public void laskeeMuunnoksenOikein() {
    Kompleksi[] signaali = {
      new Kompleksi(0.0, 0.0),
      new Kompleksi(1.0, 0.0),
      new Kompleksi(0.0, 0.0),
      new Kompleksi(0.0, 0.0),
      };

    Kompleksi[] muunnos = Fourier.muunnos(signaali);
    assertEquals(muunnos[0].a,  1.0, 0.001);
    assertEquals(muunnos[0].b,  0.0, 0.001);
    assertEquals(muunnos[1].a,  0.0, 0.001);
    assertEquals(muunnos[1].b, -1.0, 0.001);
    assertEquals(muunnos[2].a, -1.0, 0.001);
    assertEquals(muunnos[2].b,  0.0, 0.001);
    assertEquals(muunnos[3].a,  0.0, 0.001);
    assertEquals(muunnos[3].b,  1.0, 0.001);
  }

  @Test public void leikkaaPituudenOikein() {
    Kompleksi[] signaali = {
      new Kompleksi(0.0, 0.0),
      new Kompleksi(1.0, 0.0),
      new Kompleksi(0.0, 0.0),
      new Kompleksi(0.0, 0.0),
      new Kompleksi(0.0, 0.0),
      new Kompleksi(1.0, 0.0),
      };

    Kompleksi[] muunnos = Fourier.muunnos(signaali);
    assertEquals(muunnos[0].a,  1.0, 0.001);
    assertEquals(muunnos[0].b,  0.0, 0.001);
    assertEquals(muunnos[1].a,  0.0, 0.001);
    assertEquals(muunnos[1].b, -1.0, 0.001);
    assertEquals(muunnos[2].a, -1.0, 0.001);
    assertEquals(muunnos[2].b,  0.0, 0.001);
    assertEquals(muunnos[3].a,  0.0, 0.001);
    assertEquals(muunnos[3].b,  1.0, 0.001);
  }

  @Test(expected = IllegalArgumentException.class)
  public void heittaaLyhyista() throws IllegalArgumentException {
    Kompleksi[] signaali = { new Kompleksi(1.0, 0.0) };

    Kompleksi[] muunnos = Fourier.muunnos(signaali);
  }
}
