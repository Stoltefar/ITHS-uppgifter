/*  Klassen Board skapar ett spelbräde till BattleShip som består av en
/   tvådimensionell char-array där bägge arrayernas längder sätts till int-
/   variabeln size i konstruktorn.
/
/   Metoder i klassen:
/   Getter- och setter-metod för tecken i matrisen.
/   clear-metod för att nollställa en posistion i matrisen.
/   show-metod för att visa brädet.
/   placeBoat-metod för att placera en båt, bestående av tre positioner i rad,
/     antingen horisontellt eller vertikalt, på brädet.
/   showFog-metod för att visa motståndarens bräde med dess båtar maskerade.  */

public class Board {
  int size;
  char[][] gameBoard;
  public Board(int size) {
    this.size = size;
    gameBoard = new char[size][size];
    for (int i=0; i<size; ++i){
      for (int j=0; j<size; ++j) {
        gameBoard[i][j]=' ';
      }
    }
  }
  public void show() {
    for (int i=0; i<size; ++i) {
      if (size>9 && size-i<10) {
        System.out.print(size-i + ": ");
      }
      else System.out.print(size-i + ":");
      for (int j=0; j<size; ++j) {
        System.out.print("[" + gameBoard[i][j] + "]");
      }
      System.out.println();
    }
    System.out.print("    ");
    char xAxis= 'A';
    for (int x=0; x<size; ++x) {
      System.out.print((char)(xAxis+x) + "  ");
    }
  }
}
