package cube3d;

public class essai {
  public static void main(String[] args) {
    Fen�tre unNOuvell = new Fen�tre();
    unNOuvell.show();

    Thread lecompteur = new Thread(unNOuvell);

    lecompteur.start();

    while (true) {
      try {
        lecompteur.sleep(40);
        unNOuvell.run();
      } catch(InterruptedException e) {}
    }
  }
}