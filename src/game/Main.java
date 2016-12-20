package game;

public class Main {

  public static void main(String[] args) {
    DbImpl db = new DbImpl();
    db.printMatrix(db.matrix);
  }

}
