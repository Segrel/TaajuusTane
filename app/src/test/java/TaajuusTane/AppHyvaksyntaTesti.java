package TaajuusTane;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(HyvaksyntaTesti.class)
public class AppHyvaksyntaTesti {
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

  @Test public void antaaOikeanTuloksenYhdelleTaajuudelle() throws Exception {
    String[] args = new String[1];
    args[0] = "src/test/resources/440hz.wav";
    App app = new App();
    app.main(args);
    String[] tuloste = tulostevuo.toString().split("\n");
    assertEquals(3, tuloste.length);
    assertEquals("Luettiin audiotiedostosta 33075 näytettä.", tuloste[0]);
    assertEquals("Perustaajuus on 440 Hz.", tuloste[1]);
    assertEquals("307 näytettä jätettiin analysoimatta.", tuloste[2]);
  }

  @Test public void antaaOikeanTuloksenMonellaTaajuudella() throws Exception {
    String[] args = new String[1];
    args[0] = "src/test/resources/200hz-400hz-800hz.wav";
    App app = new App();
    app.main(args);
    String[] tuloste = tulostevuo.toString().split("\n");
    assertEquals(3, tuloste.length);
    assertEquals("Luettiin audiotiedostosta 33075 näytettä.", tuloste[0]);
    assertEquals("Perustaajuus on 200 Hz.", tuloste[1]);
    assertEquals("307 näytettä jätettiin analysoimatta.", tuloste[2]);
  }
}
