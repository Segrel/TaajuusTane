package TaajuusTane;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.junit.Test;

public class TallenneTesti {
  @Test public void lukuToimii()
      throws FileNotFoundException, IOException, UnsupportedAudioFileException {
    Kompleksi[] t = Tallenne.lue("src/test/resources/kymmenykset.wav");
    assertEquals(0.0, t[0].reaali(), 0.001);
    assertEquals(0.0, t[0].imaginaari(), 0.001);
    assertEquals(0.1 * 32767.0, t[1].reaali(), 1.0);
    assertEquals(0.0, t[1].imaginaari(), 0.001);
    assertEquals(0.2 * 32767.0, t[2].reaali(), 1.0);
    assertEquals(0.0, t[2].imaginaari(), 0.001);
    assertEquals(0.3 * 32767.0, t[3].reaali(), 1.0);
    assertEquals(0.0, t[3].imaginaari(), 0.001);
    assertEquals(0.4 * 32767.0, t[4].reaali(), 1.0);
    assertEquals(0.0, t[4].imaginaari(), 0.001);
    assertEquals(0.5 * 32767.0, t[5].reaali(), 1.0);
    assertEquals(0.0, t[5].imaginaari(), 0.001);
    assertEquals(0.6 * 32767.0, t[6].reaali(), 1.0);
    assertEquals(0.0, t[6].imaginaari(), 0.001);
    assertEquals(0.7 * 32767.0, t[7].reaali(), 1.0);
    assertEquals(0.0, t[7].imaginaari(), 0.001);
    assertEquals(0.8 * 32767.0, t[8].reaali(), 1.0);
    assertEquals(0.0, t[8].imaginaari(), 0.001);
    assertEquals(0.9 * 32767.0, t[9].reaali(), 1.0);
    assertEquals(0.0, t[9].imaginaari(), 0.001);
  }

  @Test(expected = UnsupportedAudioFileException.class)
  public void lukuHeittaaVaarastaMuodosta()
      throws FileNotFoundException, IOException, UnsupportedAudioFileException {
    Kompleksi[] t = Tallenne.lue("src/test/resources/8bit-kymmenykset.wav");
  }

  @Test(expected = UnsupportedAudioFileException.class)
  public void lukuHeittaaVaarastaNaytteenottotaajuudesta()
      throws FileNotFoundException, IOException, UnsupportedAudioFileException {
    Kompleksi[] t = Tallenne.lue("src/test/resources/sr48000-kymmenykset.wav");
  }

  @Test(expected = UnsupportedAudioFileException.class)
  public void lukuHeittaaVaarastaBittimaarasta()
      throws FileNotFoundException, IOException, UnsupportedAudioFileException {
    Kompleksi[] t = Tallenne.lue("src/test/resources/32bit-kymmenykset.wav");
  }

  @Test(expected = UnsupportedAudioFileException.class)
  public void lukuHeittaaStereosta()
      throws FileNotFoundException, IOException, UnsupportedAudioFileException {
    Kompleksi[] t = Tallenne.lue("src/test/resources/stereo-kymmenykset.wav");
  }
}
