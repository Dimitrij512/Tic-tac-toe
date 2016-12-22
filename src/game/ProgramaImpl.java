package game;

import java.util.Scanner;

import structure.Computer;
import structure.Programa;
import structure.User;

public class ProgramaImpl extends Programa {
  User user = new User();
  Computer comp = new Computer();
  public static int x = -1;
  public static int y = -1;

  @Override
  public boolean userIsFirst() {
    String inputAnswer = inputNumber();
    char answer = inputAnswer.charAt(0);
    if (answer == 'y') {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void determineSymbol() {
    String symbolInput = inputNumber();
    user.setSymbol(symbolInput.charAt(0));
    if (user.getSymbol() == '0') {
      comp.setSymbol('x');
    } else {
      comp.setSymbol('0');
    }
  }

  @Override
  public void checkWon() {
  }

  @Override
  public void countBonus() {
  }

  @Override
  public boolean isFreePlace(int x, int y) {
    if (DbImpl.matrix[x][y] == 0) {
      return true;
    } else {
      return false;
    }
  }

  public void playUser() {
    user.setX(Integer.parseInt(inputNumber()));
    user.setY(Integer.parseInt(inputNumber()));

    x = user.getX();
    y = user.getY();

    boolean isFree = true;

    while (isFree) {
      if (isFreePlace(x, y)) {
        DbImpl.matrix[x][y] = user.getSymbol();
        isFree = false;
      } else {
        System.out.println("Is busy plase !!!");
        System.out.println("Try again !!! \n Enter x and y !!!");
        isFree = true;
      }
    }
  }

  public void playProgram() {

    // checkHorizontal in right
    if (DbImpl.matrix[0][0] == comp.getSymbol() && DbImpl.matrix[0][1] == comp.getSymbol()
        && DbImpl.matrix[0][2] == 0) {
      DbImpl.matrix[0][2] = comp.getSymbol();

    } else if (DbImpl.matrix[1][0] == comp.getSymbol() && DbImpl.matrix[1][1] == comp.getSymbol()
        && DbImpl.matrix[1][2] == 0) {
      DbImpl.matrix[1][2] = comp.getSymbol();

    } else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[2][1] == comp.getSymbol()
        && DbImpl.matrix[2][2] == 0) {
      DbImpl.matrix[2][2] = comp.getSymbol();
      // checkHorizontal in left
    } else if (DbImpl.matrix[0][2] == comp.getSymbol() && DbImpl.matrix[0][1] == comp.getSymbol()
        && DbImpl.matrix[0][0] == 0) {
      DbImpl.matrix[0][0] = comp.getSymbol();

    } else if (DbImpl.matrix[1][2] == comp.getSymbol() && DbImpl.matrix[1][1] == comp.getSymbol()
        && DbImpl.matrix[1][0] == 0) {
      DbImpl.matrix[1][0] = comp.getSymbol();
    } else if (DbImpl.matrix[2][2] == comp.getSymbol() && DbImpl.matrix[2][1] == comp.getSymbol()
        && DbImpl.matrix[2][0] == 0) {
      DbImpl.matrix[2][0] = comp.getSymbol();
    } // check vertical high
    else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[1][0] == comp.getSymbol()
        && DbImpl.matrix[0][0] == 0) {
      DbImpl.matrix[0][0] = comp.getSymbol();

    } else if (DbImpl.matrix[2][1] == comp.getSymbol() && DbImpl.matrix[1][1] == comp.getSymbol()
        && DbImpl.matrix[0][1] == 0) {
      DbImpl.matrix[0][1] = comp.getSymbol();
    } else if (DbImpl.matrix[2][2] == comp.getSymbol() && DbImpl.matrix[1][2] == comp.getSymbol()
        && DbImpl.matrix[0][2] == 0) {
      DbImpl.matrix[0][2] = comp.getSymbol();
    } // check vertical bottom

    else if (DbImpl.matrix[0][0] == comp.getSymbol() && DbImpl.matrix[1][0] == comp.getSymbol()
        && DbImpl.matrix[2][0] == 0) {
      DbImpl.matrix[2][0] = comp.getSymbol();
    } else if (DbImpl.matrix[0][1] == comp.getSymbol() && DbImpl.matrix[1][1] == comp.getSymbol()
        && DbImpl.matrix[2][1] == 0) {
      DbImpl.matrix[2][1] = comp.getSymbol();
    } else if (DbImpl.matrix[0][2] == comp.getSymbol() && DbImpl.matrix[1][2] == comp.getSymbol()
        && DbImpl.matrix[2][2] == 0) {
      DbImpl.matrix[2][2] = comp.getSymbol();
    } // check diagonal bottom

    else if (DbImpl.matrix[0][2] == comp.getSymbol() && DbImpl.matrix[1][1] == comp.getSymbol()
        && DbImpl.matrix[2][0] == 0) {
      DbImpl.matrix[2][0] = comp.getSymbol();
    } else if (DbImpl.matrix[0][0] == user.getSymbol() && DbImpl.matrix[1][1] == user.getSymbol()
        && DbImpl.matrix[2][2] == 0) {
      DbImpl.matrix[2][2] = comp.getSymbol();
    }

    // check diagonal high
    else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[1][1] == comp.getSymbol()
        && DbImpl.matrix[0][2] == 0) {
      DbImpl.matrix[0][2] = comp.getSymbol();
    } else if (DbImpl.matrix[2][2] == comp.getSymbol() && DbImpl.matrix[1][1] == comp.getSymbol()
        && DbImpl.matrix[0][0] == 0) {
      DbImpl.matrix[0][0] = comp.getSymbol();

      // check center vertical
    } else if (DbImpl.matrix[0][0] == comp.getSymbol() && DbImpl.matrix[2][0] == comp.getSymbol()
        && DbImpl.matrix[1][0] == 0) {
      DbImpl.matrix[1][0] = comp.getSymbol();
    } else if (DbImpl.matrix[0][1] == comp.getSymbol() && DbImpl.matrix[2][1] == comp.getSymbol()
        && DbImpl.matrix[1][1] == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();
    } else if (DbImpl.matrix[0][2] == comp.getSymbol() && DbImpl.matrix[2][2] == comp.getSymbol()
        && DbImpl.matrix[1][2] == 0) {
      DbImpl.matrix[1][2] = comp.getSymbol();

      // check center horisontal
    } else if (DbImpl.matrix[0][0] == comp.getSymbol() && DbImpl.matrix[0][2] == comp.getSymbol()
        && DbImpl.matrix[0][1] == 0) {
      DbImpl.matrix[0][1] = comp.getSymbol();
    } else if (DbImpl.matrix[1][0] == comp.getSymbol() && DbImpl.matrix[1][2] == comp.getSymbol()
        && DbImpl.matrix[1][1] == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();
    } else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[2][2] == comp.getSymbol()
        && DbImpl.matrix[2][1] == 0) {
      DbImpl.matrix[2][1] = comp.getSymbol();

    }
    // check diagonal ceneter
    else if (DbImpl.matrix[0][0] == comp.getSymbol() && DbImpl.matrix[2][2] == comp.getSymbol()
        && DbImpl.matrix[1][1] == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();
    } else if (DbImpl.matrix[0][2] == comp.getSymbol() && DbImpl.matrix[2][0] == comp.getSymbol()
        && DbImpl.matrix[1][1] == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();
    }
    // --------------------------------------------------------------------------------------------------
    // checkHorizontal in right
    if (DbImpl.matrix[0][0] == user.getSymbol() && DbImpl.matrix[0][1] == user.getSymbol()
        && DbImpl.matrix[0][2] == 0) {
      DbImpl.matrix[0][2] = comp.getSymbol();

    } else if (DbImpl.matrix[1][0] == user.getSymbol() && DbImpl.matrix[1][1] == user.getSymbol()
        && DbImpl.matrix[1][2] == 0) {
      DbImpl.matrix[1][2] = comp.getSymbol();

    } else if (DbImpl.matrix[2][0] == user.getSymbol() && DbImpl.matrix[2][1] == user.getSymbol()
        && DbImpl.matrix[2][2] == 0) {
      DbImpl.matrix[2][2] = comp.getSymbol();
      // checkHorizontal in left
    } else if (DbImpl.matrix[0][2] == user.getSymbol() && DbImpl.matrix[0][1] == user.getSymbol()
        && DbImpl.matrix[0][0] == 0) {
      DbImpl.matrix[0][0] = comp.getSymbol();

    } else if (DbImpl.matrix[1][2] == user.getSymbol() && DbImpl.matrix[1][1] == user.getSymbol()
        && DbImpl.matrix[1][0] == 0) {
      DbImpl.matrix[1][0] = comp.getSymbol();
    } else if (DbImpl.matrix[2][2] == user.getSymbol() && DbImpl.matrix[2][1] == user.getSymbol()
        && DbImpl.matrix[2][0] == 0) {
      DbImpl.matrix[2][0] = comp.getSymbol();
    } // check vertical high
    else if (DbImpl.matrix[2][0] == user.getSymbol() && DbImpl.matrix[1][0] == user.getSymbol()
        && DbImpl.matrix[0][0] == 0) {
      DbImpl.matrix[0][0] = comp.getSymbol();

    } else if (DbImpl.matrix[2][1] == user.getSymbol() && DbImpl.matrix[1][1] == user.getSymbol()
        && DbImpl.matrix[0][1] == 0) {
      DbImpl.matrix[0][1] = comp.getSymbol();
    } else if (DbImpl.matrix[2][2] == user.getSymbol() && DbImpl.matrix[1][2] == user.getSymbol()
        && DbImpl.matrix[0][2] == 0) {
      DbImpl.matrix[0][2] = comp.getSymbol();
    } // check vertical bottom

    else if (DbImpl.matrix[0][0] == user.getSymbol() && DbImpl.matrix[1][0] == user.getSymbol()
        && DbImpl.matrix[2][0] == 0) {
      DbImpl.matrix[2][0] = comp.getSymbol();
    } else if (DbImpl.matrix[0][1] == user.getSymbol() && DbImpl.matrix[1][1] == user.getSymbol()
        && DbImpl.matrix[2][1] == 0) {
      DbImpl.matrix[2][1] = comp.getSymbol();
    } else if (DbImpl.matrix[0][2] == user.getSymbol() && DbImpl.matrix[1][2] == user.getSymbol()
        && DbImpl.matrix[2][2] == 0) {
      DbImpl.matrix[2][2] = comp.getSymbol();
    }
    // check diagonal bottom
    else if (DbImpl.matrix[0][2] == user.getSymbol() && DbImpl.matrix[1][1] == user.getSymbol()
        && DbImpl.matrix[2][0] == 0) {
      DbImpl.matrix[2][0] = comp.getSymbol();
    } else if (DbImpl.matrix[0][0] == comp.getSymbol() && DbImpl.matrix[1][1] == comp.getSymbol()
        && DbImpl.matrix[2][2] == 0) {
      DbImpl.matrix[2][2] = comp.getSymbol();
    }
    // check diagonal high
    else if (DbImpl.matrix[2][0] == user.getSymbol() && DbImpl.matrix[1][1] == user.getSymbol()
        && DbImpl.matrix[0][2] == 0) {
      DbImpl.matrix[0][2] = comp.getSymbol();
    } else if (DbImpl.matrix[2][2] == user.getSymbol() && DbImpl.matrix[1][1] == user.getSymbol()
        && DbImpl.matrix[0][0] == 0) {
      DbImpl.matrix[0][0] = comp.getSymbol();
      // check diagonal center
    } else if (DbImpl.matrix[0][0] == user.getSymbol() && DbImpl.matrix[2][2] == user.getSymbol()
        && DbImpl.matrix[1][1] == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();
    } else if (DbImpl.matrix[0][2] == user.getSymbol() && DbImpl.matrix[2][0] == user.getSymbol()
        && DbImpl.matrix[1][1] == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();
      // check center vertical
    } else if (DbImpl.matrix[0][0] == user.getSymbol() && DbImpl.matrix[2][0] == user.getSymbol()
        && DbImpl.matrix[1][0] == 0) {
      DbImpl.matrix[1][0] = comp.getSymbol();
    } else if (DbImpl.matrix[0][1] == user.getSymbol() && DbImpl.matrix[2][1] == user.getSymbol()
        && DbImpl.matrix[1][1] == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();
    } else if (DbImpl.matrix[0][2] == user.getSymbol() && DbImpl.matrix[2][2] == user.getSymbol()
        && DbImpl.matrix[2][1] == 0) {
      DbImpl.matrix[2][1] = comp.getSymbol();

      // check center horisontal
    } else if (DbImpl.matrix[0][0] == user.getSymbol() && DbImpl.matrix[0][2] == user.getSymbol()
        && DbImpl.matrix[0][1] == 0) {
      DbImpl.matrix[0][1] = comp.getSymbol();
    } else if (DbImpl.matrix[1][0] == user.getSymbol() && DbImpl.matrix[1][2] == user.getSymbol()
        && DbImpl.matrix[1][1] == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();
    } else if (DbImpl.matrix[2][0] == user.getSymbol() && DbImpl.matrix[2][2] == user.getSymbol()
        && DbImpl.matrix[2][1] == 0) {
      DbImpl.matrix[2][1] = comp.getSymbol();

      // play game
    } else if (x == -1 && y == -1) { // first step
      DbImpl.matrix[2][0] = comp.getSymbol();

    } else if (x == 2 && y == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();

    } else if (x != -1 && y != -1 && DbImpl.matrix[2][0] == 0) {
      DbImpl.matrix[2][0] = comp.getSymbol();

    } else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[2][2] == 0) {
      DbImpl.matrix[2][2] = comp.getSymbol();

      // } else if (DbImpl.matrix[0][2] == 0) {
      // DbImpl.matrix[0][2] = comp.getSymbol();

      // } else if (DbImpl.matrix[2][0] == comp.getSymbol() &&
      // DbImpl.matrix[2][2] == comp.getSymbol()
      // && DbImpl.matrix[0][2] == comp.getSymbol() && DbImpl.matrix[1][2] == 0)
      // {
      // DbImpl.matrix[1][2] = comp.getSymbol();
      // } else if (DbImpl.matrix[2][0] == comp.getSymbol() &&
      // DbImpl.matrix[2][2] == comp.getSymbol()
      // && DbImpl.matrix[0][2] == comp.getSymbol() && DbImpl.matrix[1][1] == 0)
      // {
      // DbImpl.matrix[1][1] = comp.getSymbol();
    }

  }

  public String inputNumber() {
    Scanner sc = new Scanner(System.in);
    String x = sc.nextLine();
    return x;
  }
}
