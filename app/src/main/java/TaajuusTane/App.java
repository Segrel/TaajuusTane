package TaajuusTane;

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
    Kompleksi[] signaali = Tallenne.lue(args[0]);
    System.out.println("Luettiin audiotiedostosta " + Integer.toString(signaali.length) + " näytettä.");
    Analyysi analyysi = new Analyysi(signaali, 44100.0);
    System.out.println("Perustaajuus on " + Integer.toString(analyysi.perustaajuus()) + "Hz.");
    if (analyysi.sivuutettuja() > 0) {
      System.out.println(Integer.toString(analyysi.sivuutettuja()) + " näytettä jätettiin analysoimatta.");
    }
  }
}
