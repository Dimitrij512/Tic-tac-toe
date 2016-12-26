package game;

import java.util.Scanner;

import structure.Computer;
import structure.Programa;
import structure.User;

public class ProgramaImpl extends Programa {
  public User user = new User();
  public static boolean endGdame = true;
  public static int countUserWin = 0;
  public static int countCompWin = 0;
  public static int countTie = 0;
  public Computer comp = new Computer();
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
  public void checkWon(char symbol) {
    if (DbImpl.matrix[0][0] == symbol && DbImpl.matrix[1][0] == symbol && DbImpl.matrix[2][0] == symbol
        || DbImpl.matrix[0][1] == symbol && DbImpl.matrix[1][1] == symbol && DbImpl.matrix[2][1] == symbol
        || DbImpl.matrix[0][2] == symbol && DbImpl.matrix[1][2] == symbol && DbImpl.matrix[2][2] == symbol
        || DbImpl.matrix[0][1] == symbol && DbImpl.matrix[1][1] == symbol && DbImpl.matrix[2][1] == symbol
        || DbImpl.matrix[0][0] == symbol && DbImpl.matrix[0][1] == symbol && DbImpl.matrix[0][2] == symbol
        || DbImpl.matrix[1][0] == symbol && DbImpl.matrix[1][1] == symbol && DbImpl.matrix[1][2] == symbol
        || DbImpl.matrix[2][0] == symbol && DbImpl.matrix[2][1] == symbol && DbImpl.matrix[2][2] == symbol
        || DbImpl.matrix[0][2] == symbol && DbImpl.matrix[1][1] == symbol && DbImpl.matrix[2][0] == symbol) {
      printWinnerText(symbol);
    }

  }

  public void printWinnerText(char symbol) {
    if (symbol == user.getSymbol()) {
      System.out.println("I can`t beleave it you WIN - USER WIN");
      endGdame = false;
      countUserWin++;
    } else {
      System.out.println("Computer is WINNER !!!");
      endGdame = false;
      countCompWin++;
    }
  }

  public void checkTie() {
    int countZeroInMatrix = 0;
    for (int i = 0; i < DbImpl.matrix.length; i++) {
      for (int j = 0; j < DbImpl.matrix[i].length; j++) {
        if (DbImpl.matrix[i][j] == 0) {
          countZeroInMatrix++;
        }
      }
    }
    if (countZeroInMatrix == 0) {
      System.out.println("IS TIE !!!");
      endGdame = false;
      countTie++;
    }
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

    boolean isFree = true;
    while (isFree) {
      x = user.getX();
      y = user.getY();
      if (isFreePlace(x, y)) {
        DbImpl.matrix[x][y] = user.getSymbol();
        isFree = false;
      } else {
        System.out.println("Is busy please !!!");
        System.out.println("Try again !!! \n Enter x and y !!!");
        user.setX(Integer.parseInt(inputNumber()));
        user.setY(Integer.parseInt(inputNumber()));
        isFree = true;
      }
    }
  }

  public void playProgram() {

    // checkHorizontal in right
    if (DbImpl.matrix[0][0] == comp.getSymbol() && DbImpl.matrix[0][1] == comp.getSymbol()
        && DbImpl.matrix[0][2] == 0) {
      DbImpl.matrix[0][2] = comp.getSymbol();
      return;

    } else if (DbImpl.matrix[1][0] == comp.getSymbol() && DbImpl.matrix[1][1] == comp.getSymbol()
        && DbImpl.matrix[1][2] == 0) {
      DbImpl.matrix[1][2] = comp.getSymbol();
      return;

    } else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[2][1] == comp.getSymbol()
        && DbImpl.matrix[2][2] == 0) {
      DbImpl.matrix[2][2] = comp.getSymbol();
      return;
      // checkHorizontal in left
    } else if (DbImpl.matrix[0][2] == comp.getSymbol() && DbImpl.matrix[0][1] == comp.getSymbol()
        && DbImpl.matrix[0][0] == 0) {
      DbImpl.matrix[0][0] = comp.getSymbol();
      return;

    } else if (DbImpl.matrix[1][2] == comp.getSymbol() && DbImpl.matrix[1][1] == comp.getSymbol()
        && DbImpl.matrix[1][0] == 0) {
      DbImpl.matrix[1][0] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[2][2] == comp.getSymbol() && DbImpl.matrix[2][1] == comp.getSymbol()
        && DbImpl.matrix[2][0] == 0) {
      DbImpl.matrix[2][0] = comp.getSymbol();
      return;
    } // check vertical high
    else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[1][0] == comp.getSymbol()
        && DbImpl.matrix[0][0] == 0) {
      DbImpl.matrix[0][0] = comp.getSymbol();
      return;

    } else if (DbImpl.matrix[2][1] == comp.getSymbol() && DbImpl.matrix[1][1] == comp.getSymbol()
        && DbImpl.matrix[0][1] == 0) {
      DbImpl.matrix[0][1] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[2][2] == comp.getSymbol() && DbImpl.matrix[1][2] == comp.getSymbol()
        && DbImpl.matrix[0][2] == 0) {
      DbImpl.matrix[0][2] = comp.getSymbol();
      return;
    } // check vertical bottom

    else if (DbImpl.matrix[0][0] == comp.getSymbol() && DbImpl.matrix[1][0] == comp.getSymbol()
        && DbImpl.matrix[2][0] == 0) {
      DbImpl.matrix[2][0] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[0][1] == comp.getSymbol() && DbImpl.matrix[1][1] == comp.getSymbol()
        && DbImpl.matrix[2][1] == 0) {
      DbImpl.matrix[2][1] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[0][2] == comp.getSymbol() && DbImpl.matrix[1][2] == comp.getSymbol()
        && DbImpl.matrix[2][2] == 0) {
      DbImpl.matrix[2][2] = comp.getSymbol();
      return;
    } // check diagonal bottom

    else if (DbImpl.matrix[0][2] == comp.getSymbol() && DbImpl.matrix[1][1] == comp.getSymbol()
        && DbImpl.matrix[2][0] == 0) {
      DbImpl.matrix[2][0] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[0][0] == user.getSymbol() && DbImpl.matrix[1][1] == user.getSymbol()
        && DbImpl.matrix[2][2] == 0) {
      DbImpl.matrix[2][2] = comp.getSymbol();
      return;
    }

    // check diagonal high
    else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[1][1] == comp.getSymbol()
        && DbImpl.matrix[0][2] == 0) {
      DbImpl.matrix[0][2] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[2][2] == comp.getSymbol() && DbImpl.matrix[1][1] == comp.getSymbol()
        && DbImpl.matrix[0][0] == 0) {
      DbImpl.matrix[0][0] = comp.getSymbol();
      return;

      // check center vertical
    } else if (DbImpl.matrix[0][0] == comp.getSymbol() && DbImpl.matrix[2][0] == comp.getSymbol()
        && DbImpl.matrix[1][0] == 0) {
      DbImpl.matrix[1][0] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[0][1] == comp.getSymbol() && DbImpl.matrix[2][1] == comp.getSymbol()
        && DbImpl.matrix[1][1] == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();
    } else if (DbImpl.matrix[0][2] == comp.getSymbol() && DbImpl.matrix[2][2] == comp.getSymbol()
        && DbImpl.matrix[1][2] == 0) {
      DbImpl.matrix[1][2] = comp.getSymbol();
      return;

      // check center horisontal
    } else if (DbImpl.matrix[0][0] == comp.getSymbol() && DbImpl.matrix[0][2] == comp.getSymbol()
        && DbImpl.matrix[0][1] == 0) {
      DbImpl.matrix[0][1] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[1][0] == comp.getSymbol() && DbImpl.matrix[1][2] == comp.getSymbol()
        && DbImpl.matrix[1][1] == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[2][2] == comp.getSymbol()
        && DbImpl.matrix[2][1] == 0) {
      DbImpl.matrix[2][1] = comp.getSymbol();
      return;

    }
    // check diagonal ceneter
    else if (DbImpl.matrix[0][0] == comp.getSymbol() && DbImpl.matrix[2][2] == comp.getSymbol()
        && DbImpl.matrix[1][1] == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[0][2] == comp.getSymbol() && DbImpl.matrix[2][0] == comp.getSymbol()
        && DbImpl.matrix[1][1] == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();
      return;
    }
    // --------------------------------------------------------------------------------------------------
    // checkHorizontal in right
    if (DbImpl.matrix[0][0] == user.getSymbol() && DbImpl.matrix[0][1] == user.getSymbol()
        && DbImpl.matrix[0][2] == 0) {
      DbImpl.matrix[0][2] = comp.getSymbol();
      return;

    } else if (DbImpl.matrix[1][0] == user.getSymbol() && DbImpl.matrix[1][1] == user.getSymbol()
        && DbImpl.matrix[1][2] == 0) {
      DbImpl.matrix[1][2] = comp.getSymbol();
      return;

    } else if (DbImpl.matrix[2][0] == user.getSymbol() && DbImpl.matrix[2][1] == user.getSymbol()
        && DbImpl.matrix[2][2] == 0) {
      DbImpl.matrix[2][2] = comp.getSymbol();
      return;
      // checkHorizontal in left
    } else if (DbImpl.matrix[0][2] == user.getSymbol() && DbImpl.matrix[0][1] == user.getSymbol()
        && DbImpl.matrix[0][0] == 0) {
      DbImpl.matrix[0][0] = comp.getSymbol();
      return;

    } else if (DbImpl.matrix[1][2] == user.getSymbol() && DbImpl.matrix[1][1] == user.getSymbol()
        && DbImpl.matrix[1][0] == 0) {
      DbImpl.matrix[1][0] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[2][2] == user.getSymbol() && DbImpl.matrix[2][1] == user.getSymbol()
        && DbImpl.matrix[2][0] == 0) {
      DbImpl.matrix[2][0] = comp.getSymbol();
      return;
    } // check vertical high
    else if (DbImpl.matrix[2][0] == user.getSymbol() && DbImpl.matrix[1][0] == user.getSymbol()
        && DbImpl.matrix[0][0] == 0) {
      DbImpl.matrix[0][0] = comp.getSymbol();
      return;

    } else if (DbImpl.matrix[2][1] == user.getSymbol() && DbImpl.matrix[1][1] == user.getSymbol()
        && DbImpl.matrix[0][1] == 0) {
      DbImpl.matrix[0][1] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[2][2] == user.getSymbol() && DbImpl.matrix[1][2] == user.getSymbol()
        && DbImpl.matrix[0][2] == 0) {
      DbImpl.matrix[0][2] = comp.getSymbol();
      return;
    } // check vertical bottom

    else if (DbImpl.matrix[0][0] == user.getSymbol() && DbImpl.matrix[1][0] == user.getSymbol()
        && DbImpl.matrix[2][0] == 0) {
      DbImpl.matrix[2][0] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[0][1] == user.getSymbol() && DbImpl.matrix[1][1] == user.getSymbol()
        && DbImpl.matrix[2][1] == 0) {
      DbImpl.matrix[2][1] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[0][2] == user.getSymbol() && DbImpl.matrix[1][2] == user.getSymbol()
        && DbImpl.matrix[2][2] == 0) {
      DbImpl.matrix[2][2] = comp.getSymbol();
      return;
    }
    // check diagonal bottom
    else if (DbImpl.matrix[0][2] == user.getSymbol() && DbImpl.matrix[1][1] == user.getSymbol()
        && DbImpl.matrix[2][0] == 0) {
      DbImpl.matrix[2][0] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[0][0] == comp.getSymbol() && DbImpl.matrix[1][1] == comp.getSymbol()
        && DbImpl.matrix[2][2] == 0) {
      DbImpl.matrix[2][2] = comp.getSymbol();
      return;
    }
    // check diagonal high
    else if (DbImpl.matrix[2][0] == user.getSymbol() && DbImpl.matrix[1][1] == user.getSymbol()
        && DbImpl.matrix[0][2] == 0) {
      DbImpl.matrix[0][2] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[2][2] == user.getSymbol() && DbImpl.matrix[1][1] == user.getSymbol()
        && DbImpl.matrix[0][0] == 0) {
      DbImpl.matrix[0][0] = comp.getSymbol();
      return;
      // check diagonal center
    } else if (DbImpl.matrix[0][0] == user.getSymbol() && DbImpl.matrix[2][2] == user.getSymbol()
        && DbImpl.matrix[1][1] == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[0][2] == user.getSymbol() && DbImpl.matrix[2][0] == user.getSymbol()
        && DbImpl.matrix[1][1] == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();
      return;
      // check center vertical
    } else if (DbImpl.matrix[0][0] == user.getSymbol() && DbImpl.matrix[2][0] == user.getSymbol()
        && DbImpl.matrix[1][0] == 0) {
      DbImpl.matrix[1][0] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[0][1] == user.getSymbol() && DbImpl.matrix[2][1] == user.getSymbol()
        && DbImpl.matrix[1][1] == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[0][2] == user.getSymbol() && DbImpl.matrix[2][2] == user.getSymbol()
        && DbImpl.matrix[1][2] == 0) {
      DbImpl.matrix[1][2] = comp.getSymbol();
      return;

      // check center horisontal
    } else if (DbImpl.matrix[0][0] == user.getSymbol() && DbImpl.matrix[0][2] == user.getSymbol()
        && DbImpl.matrix[0][1] == 0) {
      DbImpl.matrix[0][1] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[1][0] == user.getSymbol() && DbImpl.matrix[1][2] == user.getSymbol()
        && DbImpl.matrix[1][1] == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[2][0] == user.getSymbol() && DbImpl.matrix[2][2] == user.getSymbol()
        && DbImpl.matrix[2][1] == 0) {
      DbImpl.matrix[2][1] = comp.getSymbol();
      return;

      // play game
    } else if (x == -1 && y == -1) { // first step
      DbImpl.matrix[2][0] = comp.getSymbol();
      return;

    } else if (x == 2 && y == 0 && DbImpl.matrix[2][2] == 0 && DbImpl.matrix[0][2] == 0 && DbImpl.matrix[0][0] == 0
        || x == 0 && y == 0 && DbImpl.matrix[2][2] == 0 && DbImpl.matrix[0][2] == 0 && DbImpl.matrix[2][0] == 0
        || x == 2 && y == 2 && DbImpl.matrix[2][0] == 0 && DbImpl.matrix[0][2] == 0 && DbImpl.matrix[0][0] == 0
        || x == 0 && y == 2 && DbImpl.matrix[1][1] == 0 && DbImpl.matrix[2][2] == 0 && DbImpl.matrix[2][0] == 0
            && DbImpl.matrix[0][0] == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();
      return;

    } else if (x != -1 && y != -1 && DbImpl.matrix[2][0] == 0) {
      DbImpl.matrix[2][0] = comp.getSymbol();
      return;

    } else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[2][2] == 0) {
      DbImpl.matrix[2][2] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[2][2] == comp.getSymbol()
        && DbImpl.matrix[0][2] == user.getSymbol() && DbImpl.matrix[0][0] == 0) {
      DbImpl.matrix[0][0] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[2][2] == comp.getSymbol()
        && DbImpl.matrix[2][0] == user.getSymbol() && DbImpl.matrix[1][2] == user.getSymbol()
        && DbImpl.matrix[0][0] == 0) {
      DbImpl.matrix[0][0] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[2][2] == user.getSymbol()
        && DbImpl.matrix[0][2] == 0) {
      DbImpl.matrix[0][2] = comp.getSymbol();
      return;

    } else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[2][2] == comp.getSymbol()
        && DbImpl.matrix[0][1] == comp.getSymbol() && DbImpl.matrix[0][0] == user.getSymbol()
        && DbImpl.matrix[1][1] == user.getSymbol() && DbImpl.matrix[2][1] == user.getSymbol()
        && DbImpl.matrix[0][2] == 0) {
      DbImpl.matrix[0][2] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[1][0] == comp.getSymbol() && DbImpl.matrix[1][1] == comp.getSymbol()
        && DbImpl.matrix[0][0] == user.getSymbol() && DbImpl.matrix[1][2] == user.getSymbol()
        && DbImpl.matrix[0][2] == user.getSymbol() && DbImpl.matrix[2][1] == 0) {
      DbImpl.matrix[2][1] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[1][1] == comp.getSymbol() && DbImpl.matrix[2][1] == comp.getSymbol()
        && DbImpl.matrix[2][0] == user.getSymbol() && DbImpl.matrix[2][2] == user.getSymbol()
        && DbImpl.matrix[0][1] == user.getSymbol() && DbImpl.matrix[1][2] == 0) {
      DbImpl.matrix[1][2] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[2][2] == comp.getSymbol()
        && DbImpl.matrix[2][1] == user.getSymbol() && DbImpl.matrix[1][2] == user.getSymbol()
        && DbImpl.matrix[0][0] == 0) {
      DbImpl.matrix[0][0] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[2][2] == comp.getSymbol()
        && DbImpl.matrix[1][0] == user.getSymbol() && DbImpl.matrix[2][1] == user.getSymbol()
        && DbImpl.matrix[0][2] == 0) {
      DbImpl.matrix[0][2] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[2][0] == user.getSymbol() && DbImpl.matrix[0][2] == user.getSymbol()
        && DbImpl.matrix[1][1] == comp.getSymbol() && DbImpl.matrix[2][1] == 0) {
      DbImpl.matrix[2][1] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[2][2] == comp.getSymbol()
        && DbImpl.matrix[2][1] == user.getSymbol() && DbImpl.matrix[0][0] == user.getSymbol()
        && DbImpl.matrix[0][2] == 0) {
      DbImpl.matrix[0][2] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[2][2] == comp.getSymbol()
        && DbImpl.matrix[2][1] == user.getSymbol() && DbImpl.matrix[0][2] == user.getSymbol()
        && DbImpl.matrix[0][0] == 0) {
      DbImpl.matrix[0][0] = comp.getSymbol();
      return;
    } else if (DbImpl.matrix[2][0] == comp.getSymbol() && DbImpl.matrix[2][2] == comp.getSymbol()
        && DbImpl.matrix[2][1] == user.getSymbol() && DbImpl.matrix[0][2] == user.getSymbol()
        && DbImpl.matrix[1][1] == user.getSymbol() && DbImpl.matrix[0][0] == user.getSymbol()
        && DbImpl.matrix[1][2] == 0) {
      DbImpl.matrix[1][2] = comp.getSymbol();
      return;
    }
    // this is test

  }

  public String inputNumber() {
    Scanner sc = new Scanner(System.in);
    String x = sc.nextLine();
    return x;
  }
}
