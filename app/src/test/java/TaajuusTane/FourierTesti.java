package TaajuusTane;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FourierTesti {
  @Test public void laskeeMuunnoksenOikein() {
    Kompleksi[] testiSignaali = {
      new Kompleksi(0.0, 0.0),
      new Kompleksi(1.0, 0.0),
      new Kompleksi(0.0, 0.0),
      new Kompleksi(0.0, 0.0),
      };

    Kompleksi[] testiMuunnos = Fourier.muunnos(testiSignaali);
    assertEquals(1.0, testiMuunnos[0].reaali(), 0.001);
    assertEquals(0.0, testiMuunnos[0].imaginaari(), 0.001);
    assertEquals(0.0, testiMuunnos[1].reaali(), 0.001);
    assertEquals(-1.0, testiMuunnos[1].imaginaari(), 0.001);
    assertEquals(-1.0, testiMuunnos[2].reaali(), 0.001);
    assertEquals(0.0, testiMuunnos[2].imaginaari(), 0.001);
    assertEquals(0.0, testiMuunnos[3].reaali(), 0.001);
    assertEquals(1.0, testiMuunnos[3].imaginaari(), 0.001);
  }

  @Test(expected = IllegalArgumentException.class)
  public void heittaaLyhyista() throws IllegalArgumentException {
    Kompleksi[] testiSignaali = { new Kompleksi(1.0, 0.0) };

    Kompleksi[] testiMuunnos = Fourier.muunnos(testiSignaali);
  }

  @Test(expected = IllegalArgumentException.class)
  public void heittaaVaaranPituisista() throws IllegalArgumentException {
    Kompleksi[] testiSignaali = {
      new Kompleksi(1.0, 0.0),
      new Kompleksi(1.0, 0.0),
      new Kompleksi(1.0, 0.0)
      };

    Kompleksi[] testiMuunnos = Fourier.muunnos(testiSignaali);
  }
}
