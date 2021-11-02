import java.util.Scanner;

public class TicTacToeBoard {
  char[] board = new char[] {'7', '8', '9', '4', '5', '6', '1', '2', '3', };
  private String player1, player2;
  public void setPlayer1(String name) {
    this.player1=name;
  }
  public void setPlayer2(String name) {
    this.player2=name;
  }

  public boolean checkForWinner(boolean playerOneTurn) {
    char[] winningLine = new char[3];
    if (playerOneTurn) {
      winningLine = new char [] {'X', 'X', 'X'};
    }
    else {
      winningLine = new char[] {'O', 'O', 'O'};
    }
    for (int l=0; l<8; ++l) {
      char[] line = null;
      switch (l) {
        case 0:
          line = new char[] {board[0], board[1], board[2]};
          break;

        case 1:
          line = new char[] {board[3], board[4], board[5]};
          break;

        case 2:
          line = new char[] {board[6], board[7], board[8]};
          break;

        case 3:
          line = new char[] {board[0], board[4], board[8]};
          break;

        case 4:
          line = new char[] {board[2], board[4], board[6]};
          break;

        case 5:
          line = new char[] {board[0], board[3], board[6]};
          break;

        case 6:
          line = new char[] {board[1], board[4], board[7]};
          break;

        case 7:
          line = new char[] {board[2], board[5], board[8]};
          break;
      }
      System.out.println("line: " +line[0] + line[1] + line[2]);
      if (line[0]==winningLine[0] && line[1]==winningLine[1] && line[2]==winningLine[2]) {
        if (playerOneTurn) {
          System.out.println(this.player1 + " has won the game with three in a row!");
          this.printBoard();
          return true;
        }
        else {
          System.out.println(this.player2 + " has won the game with three in a row!");
          this.printBoard();
          return true;
        }
      }
    }
    boolean draw= true;
    for (int i=0; i<9; ++i) {
      if (board[i] != 'X' && board[i] != 'O') {
        draw=false;
      }
    }
    if (draw) {
      System.out.println("The game is a draw!");
      return true;
    }
    else return false;
  }

  public void printBoard() {
    String line = " |---|---|---|";
    String divide = " | ";
    System.out.println(line);
    System.out.print(divide);
    for (int i=0; i<9; ++i)
      if ((i+1)%3==0) {
        System.out.println(board[i] + divide);
        System.out.println(line);
        if (i<7) {
          System.out.print(divide);
        }
      }
      else System.out.print(board[i] + divide);
  }

  public void playTurn(boolean playerOneTurn) {
    Scanner sc = new Scanner(System.in);
    printBoard();
    int playInSquare = 0;
    while (playInSquare<1 || playInSquare>9) {
      if (playerOneTurn) {
        System.out.print(player1);
      }
      else {
        System.out.print(player2);
      }
      System.out.print(", choose an available square: ");
      playInSquare = sc.nextInt();
    }
    for (int i=0; i<9; ++i) {
  //    System.out.println(Character.getNumericValue(board[i]));
      if (Character.getNumericValue(board[i])==playInSquare) {
        if (playerOneTurn) {
          board[i]='X';
        }
        else board[i]='O';
      }
    }
//    System.out.println("That square was not available! Error. Programmer can't solve! Restart game!");
  }
}
