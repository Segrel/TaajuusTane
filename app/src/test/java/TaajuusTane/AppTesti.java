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
    Kompleksi[] data = new Kompleksi[5];
    MockedStatic<Tallenne> t = mockStatic(Tallenne.class);
    t.when(() -> Tallenne.lue(any(File.class))).thenReturn(data);
    App app = new App();
    String[] args = new String[1];
    args[0] = "/tiedostopolku";
    app.main(args);
    t.verify(() -> Tallenne.lue(any(File.class)));
  }

  @Test(expected = Exception.class)
  public void mainHeittaaIlmanArgumentteja() throws Exception {
    App app = new App();
    String[] args = new String[0];
    app.main(args);
  }
}
