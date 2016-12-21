package game;

import java.util.Scanner;

import structure.Computer;
import structure.Programa;
import structure.User;

public class ProgramaImpl extends Programa {
  User user = new User();
  Computer comp = new Computer();
  public static int x;
  public static int y;

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
    if (DbImpl.matrix[2][0] == 0) {
      // first way
      DbImpl.matrix[2][0] = comp.getSymbol();
    } else if (DbImpl.matrix[1][1] == 0) {
      DbImpl.matrix[1][1] = comp.getSymbol();

    } else if (x == 0 && y == 2) {
      DbImpl.matrix[0][0] = comp.getSymbol();

    } else if (x == 0 && y == 0 && DbImpl.matrix[1][1] == 0) {
      DbImpl.matrix[2][2] = comp.getSymbol();

    } else if (x == 1 && y == 0) {
      DbImpl.matrix[2][2] = comp.getSymbol();
    }

  }

  public String inputNumber() {
    Scanner sc = new Scanner(System.in);
    String x = sc.nextLine();
    return x;
  }
}
