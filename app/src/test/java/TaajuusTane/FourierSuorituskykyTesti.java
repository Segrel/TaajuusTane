package TaajuusTane;

import java.util.Arrays;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(SuorituskykyTesti.class)
public class FourierSuorituskykyTesti {
  int lyhinPituus = 12; // käyttö: 2^lyhinPituus
  int pisinPituus = 20; // käyttö: 2^pisinPituus
  int otoskoko = 10;

  Kompleksi[] generoiSignaali(int pituus) {
    Kompleksi[] testiSignaali = new Kompleksi[pituus];
    for (int i = 0; i < pituus; i += 1) {
      testiSignaali[i] = new Kompleksi(Math.floor(Math.sin(2 * Math.PI * 440.0 * i / 44100.0) * 32767.0), 0.0);
    }
    return testiSignaali;
  }

  @Test public void mittaaSuoritusaika() {
    long t;
    long[] otos = new long[otoskoko];
    Kompleksi[] testiSignaali;
    System.out.println("syötteen pituus: mediaanikesto (ms)");
    for (int i = lyhinPituus; i <= pisinPituus; i += 1) {
      testiSignaali = generoiSignaali((int) Math.pow(2, i));
      Fourier.muunnos(testiSignaali);
      for (int j = 0; j < otoskoko; j += 1) {
        t = System.nanoTime();
        Fourier.muunnos(testiSignaali);
        t = System.nanoTime() - t;
        otos[j] = t;
      }
      Arrays.sort(otos);
      System.out.println("2^" + Integer.toString(i) + ": " + ((double) otos[otos.length / 2] / 1000000.0));
    }
  }
}
