package structure;

public abstract class User extends Player {
  private int x;
  private int y;

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  abstract void input(int x, int y);

  abstract public void endGame();

}
