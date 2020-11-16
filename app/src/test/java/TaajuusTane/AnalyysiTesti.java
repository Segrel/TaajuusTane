package TaajuusTane;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;

import org.junit.Test;
import org.mockito.MockedStatic;

public class AnalyysiTesti {
  @Test(expected = IllegalArgumentException.class)
  public void heittaaLyhyestaSignaalista() {
    Kompleksi[] testiSignaali = { new Kompleksi(1.0, 0.0) };

    Analyysi a = new Analyysi(testiSignaali, 44100.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void heittaaOudostaNaytteenottotaajuudesta() {
    Kompleksi[] testiSignaali = { new Kompleksi(1.0, 0.0), new Kompleksi(1.0, 0.0) };

    Analyysi a = new Analyysi(testiSignaali, 0.0);
  }

  @Test public void eiHeitaMuuten() {
    Kompleksi[] testiSignaali = { new Kompleksi(1.0, 0.0), new Kompleksi(1.0, 0.0) };
    Analyysi a = new Analyysi(testiSignaali, 2.0);
  }

  @Test public void perustaajuusToimii() {
    Kompleksi[] testiSignaali = {
      new Kompleksi(-4.0, 0.0),
      new Kompleksi(-1.0, 1.0),
      new Kompleksi(3.0, 0.0),
      new Kompleksi(-6.0, 1.0),
      };
    Kompleksi[] testiMuunnos = {
      new Kompleksi(-8.0, 2.0),
      new Kompleksi(-7.0, -5.0),
      new Kompleksi(6.0, -2.0),
      new Kompleksi(-7.0, 5.0),
      };
    try (MockedStatic<Fourier> t = mockStatic(Fourier.class)) {
      t.when(() -> Fourier.muunnos(testiSignaali)).thenReturn(testiMuunnos);

      Analyysi a = new Analyysi(testiSignaali, 44100.0);
      int perustaajuus = a.perustaajuus();
      t.verify(() -> Fourier.muunnos(testiSignaali));
      assertEquals(perustaajuus, 11025);
    }
  }
}
