package TaajuusTane;

import java.io.File;

/** Komentorivikäyttöliittymä TaajuusTanelle. */
public class App {
  /** Suorita tallenteen analyysi.
  *
  * @param args Komentoriviargumentit
  * @throws Exception Poikkeus sovelluksen suorituksessa
  */
  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      throw new Exception("Anna komentoriviargumenttina polku tallenteeseen.");
    }
    Kompleksi[] signaali;
    signaali = Tallenne.lue(new File(args[0]));
    System.out.println("Luettiin audiotiedostosta näytteitä (kpl): " + Integer.toString(signaali.length));
    // todo tee fourier-muunnos
    // todo analysoi muunnoksen lopputulos
  }
}
