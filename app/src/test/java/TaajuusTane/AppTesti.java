package TaajuusTane;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mockStatic;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;

public class AppTesti {
  private final ByteArrayOutputStream tulostevuo = new ByteArrayOutputStream();
  private final PrintStream oletusTulostin = System.out;

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(tulostevuo));
  }

  @After
  public void restoreStreams() {
    System.setOut(oletusTulostin);
  }

  @Test public void mainToimii() throws Exception {
    Kompleksi[] testiSignaali = {
      new Kompleksi(-4.0, 0.0),
      new Kompleksi(-1.0, 1.0),
      new Kompleksi(3.0, 0.0),
      new Kompleksi(2.0, 1.0),
      };
    String[] args = new String[1];
    args[0] = "/tiedostopolku";
    try (MockedStatic<Tallenne> t = mockStatic(Tallenne.class)) {
      t.when(() -> Tallenne.lue(args[0])).thenReturn(testiSignaali);

      App app = new App();
      app.main(args);
      t.verify(() -> Tallenne.lue(args[0]));
      String[] tuloste = tulostevuo.toString().split("\n");
      assertEquals(2, tuloste.length);
      assertEquals("Luettiin audiotiedostosta 4 näytettä.", tuloste[0]);
      assertEquals("Perustaajuus on 11025Hz.", tuloste[1]);
    }
  }

  @Test public void mainToimiiParittomalla() throws Exception {
    Kompleksi[] testiSignaali = {
      new Kompleksi(1.0, 0.0),
      new Kompleksi(0.0, 1.0),
      new Kompleksi(1.0, 0.0),
      new Kompleksi(0.0, 1.0),
      new Kompleksi(1.0, 0.0),
      new Kompleksi(0.0, 1.0),
      };
    String[] args = new String[1];
    args[0] = "/tiedostopolku";
    try (MockedStatic<Tallenne> t = mockStatic(Tallenne.class)) {
      t.when(() -> Tallenne.lue(args[0])).thenReturn(testiSignaali);

      App app = new App();
      app.main(args);
      t.verify(() -> Tallenne.lue(args[0]));
      String[] tuloste = tulostevuo.toString().split("\n");
      assertEquals(3, tuloste.length);
      assertEquals("Luettiin audiotiedostosta 6 näytettä.", tuloste[0]);
      assertEquals("Perustaajuus on 0Hz.", tuloste[1]);
      assertEquals("2 näytettä jätettiin analysoimatta.", tuloste[2]);
    }
  }

  @Test(expected = Exception.class)
  public void mainHeittaaIlmanArgumentteja() throws Exception {
    String[] args = new String[0];

    App app = new App();
    app.main(args);
  }
}
