package game;

public class Main {

  public static void main(String[] args) {
    ProgramaImpl pr = new ProgramaImpl();
    DbImpl db = new DbImpl();

    db.printMatrix(DbImpl.matrix);
    System.out.println("������� ������ X ��� 0");
    pr.determineSymbol();

    System.out.println("�� ����� ������ ������ ? Y/N ");
    boolean playUser = pr.userIsFirst();
    System.out.println("������ ��� !!!!");

    while (true) {
      if (playUser) {
        db.printMatrix(DbImpl.matrix);
        System.out.println("������ ����������� x y ");
        pr.playUser();
        playUser = false;
      } else {
        pr.playProgram();
        playUser = true;
      }
    }
  }

}
