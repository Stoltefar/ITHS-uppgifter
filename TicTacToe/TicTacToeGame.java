import java.util.Scanner;

public class TicTacToeGame {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    TicTacToeBoard b1 = new TicTacToeBoard();
//    b1.printBoard();
    boolean playerOnesTurn = true, gameOver=false;

    System.out.println("State the name of player 1: ");
    b1.setPlayer1(sc.nextLine());
    System.out.println("State the name of player 2: ");
    b1.setPlayer2(sc.nextLine());
    while (gameOver==false) {
      b1.playTurn(playerOnesTurn);
      gameOver=b1.checkForWinner(playerOnesTurn);
      playerOnesTurn = !playerOnesTurn;
    }
    System.out.println("GAME OVER!");
  }
}
