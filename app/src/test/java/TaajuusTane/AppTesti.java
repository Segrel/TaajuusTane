package TaajuusTane;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;

import org.junit.Test;
import org.mockito.MockedStatic;

public class AppTesti {
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
    }
  }

  @Test(expected = Exception.class)
  public void mainHeittaaIlmanArgumentteja() throws Exception {
    String[] args = new String[0];

    App app = new App();
    app.main(args);
  }
}
