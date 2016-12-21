package game;

public class Main {

  public static void main(String[] args) {
    ProgramaImpl pr = new ProgramaImpl();
    DbImpl db = new DbImpl();

    db.printMatrix(DbImpl.matrix);
    System.out.println("Виберіть символ X або 0");
    pr.determineSymbol();

    System.out.println("Ви хочте почати першим ? Y/N ");
    boolean playUser = pr.userIsFirst();
    System.out.println("Почали гру !!!!");

    while (true) {
      if (playUser) {
        db.printMatrix(DbImpl.matrix);
        System.out.println("Введіть кооридинати x y ");
        pr.playUser();
        playUser = false;
      } else {
        pr.playProgram();
        playUser = true;
      }
    }
  }

}
