package TaajuusTane;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

import java.io.File;
import org.junit.Test;
import org.mockito.MockedStatic;

public class AppTesti {
  @Test public void mainToimii() throws Exception {
    Kompleksi[] tallenneData = {
      new Kompleksi(-4.0, 0.0),
      new Kompleksi(-1.0, 1.0),
      new Kompleksi(3.0, 0.0),
      new Kompleksi(2.0, 1.0),
      };
    Kompleksi[] muunnosData = {
      new Kompleksi(0.0, 2.0),
      new Kompleksi(-7.0, 3.0),
      new Kompleksi(-2.0, -2.0),
      new Kompleksi(-7.0, -3.0),
      };
    String[] args = new String[1];
    args[0] = "/tiedostopolku";
    try (MockedStatic<Tallenne> t = mockStatic(Tallenne.class)) {
      t.when(() -> Tallenne.lue(any(File.class))).thenReturn(tallenneData);
      try (MockedStatic<Fourier> f = mockStatic(Fourier.class)) {
        f.when(() -> Fourier.muunnos(tallenneData)).thenReturn(muunnosData);

        App app = new App();
        app.main(args);
        t.verify(() -> Tallenne.lue(any(File.class)));
        f.verify(() -> Fourier.muunnos(tallenneData));
      }
    }
  }

  @Test(expected = Exception.class)
  public void mainHeittaaIlmanArgumentteja() throws Exception {
    String[] args = new String[0];

    App app = new App();
    app.main(args);
  }
}
