/*  Klassen Board skapar ett spelbräde till BattleShip som består av en
/   tvådimensionell char-array där bägge arrayernas längder sätts till int-
/   variabeln size i konstruktorn. Innehåller också en String gunner som innehåller
/   spelarens namn.
/
/   Metoder i klassen:
/   Getter- och setter-metod för tecken i matrisen, size och gunner.
/   clear-metod för att nollställa en posistion i matrisen.
/   show-metod för att visa brädet.
/   placeBoat-metod för att placera en båt, bestående av tre positioner i rad,
/     antingen horisontellt eller vertikalt, på brädet.
/   roomForBoat-metod för att kontrollera att placeringen är tillåten i förhållande
/     till tidigare placerade skepp.
/   showFog-metod för att visa motståndarens bräde med dess båtar maskerade.  */

public class Board {
  private int size;
  private char[][] gameBoard;
  private String gunner;
  public Board(int size) {
    if (size<8 || size >26) {
      System.out.println("This game doesn't play well with that size of board.");
      System.out.println("The size of the board will be set to 10x10.");
      size = 10;
    }
    else {
      this.size = size;
    }

    gameBoard = new char[size][size];
    for (int i=0; i<size; ++i){
      for (int j=0; j<size; ++j) {
        gameBoard[i][j]=' ';
      }
    }
  }

  public int getSize() {
    return size;
  }
  public char get(int x, int y) {
    return gameBoard[size-y][x-1];
  }

  public void setGunner(String s) {
    gunner=s;
  }

  public String getGunner() {
    return gunner;
  }

  public void set(int x, int y, char c) {
    if (x>0 && x<=size && y>0 && y<=size){
      y=size-y;
      gameBoard[y][x-1]=c;
    }
  }

  public void clear(int x, int y) {
    set(x,y,' ');
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
    System.out.println();
  }

  public void showFog() {
    for (int i=0; i<size; ++i) {
      if (size>9 && size-i<10) {
        System.out.print(size-i + ": ");
      }
      else System.out.print(size-i + ":");
      for (int j=0; j<size; ++j) {
        if(gameBoard[i][j]!='O') {
          System.out.print("[" + gameBoard[i][j] + "]");
        }
        else
          System.out.print("[ ]");
      }
      System.out.println();
    }
    System.out.print("    ");
    char xAxis= 'A';
    for (int x=0; x<size; ++x) {
      System.out.print((char)(xAxis+x) + "  ");
    }
    System.out.println();
  }

  public boolean placeBoat(int x, int y, char orient) {
    if (orient=='v' || orient=='V') {
      if (x<1 || x> size || y<2 || y>size-1) {
        System.out.println("This placement is invalid. The ship, or some part of it, is out of bounds. Try again.");
//      System.out.println("Denna placering är inte giltig då hela, eller någon del av, skeppet hamnar utanför spelplanen. Försök igen.");
        return false;
      } else if (roomForBoat(x, y, orient)) {
          set(x, y-1, 'O');
          set(x, y, 'O');
          set(x, y+1, 'O');
          return true;
        } else {
            System.out.println("One of your previously placed ships prevents this placement. Try again.");
//          System.out.println("Ett tidigare placerat skepp förhindrar denna placering. Gör om, gör rätt!");
            return false;
        }
      }
      else if (orient=='h' || orient=='H') {
        if (y<1 || y>size || x<2 || x>size-1) {
          System.out.println("This placement is invalid. The ship, or some part of it, is out of bounds. Try again.");
//        System.out.println("Denna placering är inte giltig då hela, eller någon del av, skeppet hamnar utanför spelplanen. Försök igen.");
          return false;
        } else if (roomForBoat(x, y, orient)) {
            set(x-1, y, 'O');
            set(x, y, 'O');
            set(x+1, y, 'O');
            return true;
          } else {
            System.out.println("One of your previously placed ships prevents this placement. Try again.");
//          System.out.println("Ett tidigare placerat skepp förhindrar denna placering. Gör om, gör rätt!");
            return false;
            }
    }
    return false;
  }
  /* Här kommer en funktion som kollar att ett nytt skepp inte hamnar direkt intill ett tidigare
  placerat skepp. Jag inser att min version går utöver uppgiften i labben, men ville göra ett spel
  som följer de klassiska placeringsreglerna i Sänka skepp. Det blev däremot över 150 rader kod
  för att undvika indexOutOfBounds-exceptions, och det ber jag om ursäkt för... */

  private boolean roomForBoat(int x, int y, char orient) {
    if (orient=='v' || orient=='V') {
      if (y==2) {
        for (int i=size-4; i<size; ++i) {
          if (x==1) {
            for (int j=0; j<2; ++j) {
              if (gameBoard[i][j]=='O') {
                return false;
              }
            }
          }
          else if (x==size) {
            for (int j=size-2; j<size; ++j) {
              if (gameBoard[i][j]=='O') {
                return false;
              }
            }
          }
          else {
            for (int j=x-2; j<=x; ++j) {
              if (gameBoard[i][j]=='O') {
                return false;
              }
            }
          }
        }
        return true;
      }
      else if (y==size-1) {
        for (int i=0; i<4; ++i) {
          if (x==1) {
            for (int j=0; j<2; ++j) {
              if (gameBoard[i][j]=='O') {
                return false;
              }
            }
          }
          else if (x==size) {
            for (int j=size-2; j<size; ++j) {
              if (gameBoard[i][j]=='O') {
                return false;
              }
            }
          }
          else {
            for (int j=x-2; j<=x; ++j) {
              if (gameBoard[i][j]=='O') {
                return false;
              }
            }
          }
        }
        return true;
      }
      else {
        for (int i=size-y-2; i<=size-y+2; ++i) {
          if (x==1) {
            for (int j=0; j<2; ++j) {
              if (gameBoard[i][j]=='O') {
                return false;
              }
            }
          }
          else if (x==size) {
            for (int j=size-2; j<size; ++j) {
              if (gameBoard[i][j]=='O') {
                return false;
              }
            }
          }
          else {
            for (int j=x-2; j<=x; ++j) {
              if (gameBoard[i][j]=='O') {
                return false;
              }
            }
          }
        }
        return true;
      }
    }
    else if (orient=='h' || orient=='H') {
      if (y==size) {
        for (int i=0; i<2; ++i) {
          if (x==2) {
            for (int j=0; j<4; ++j) {
              if (gameBoard[i][j]=='O') {
                return false;
              }
            }
          }
          else if (x==size-1) {
            for (int j=x-3; j<size; ++j) {
              if (gameBoard[i][j]=='O') {
                return false;
              }
            }
          }
          else {
            for (int j=x-3; j<=x+1; ++j) {
              if (gameBoard[i][j]=='O') {
                return false;
              }
            }
          }
        }
        return true;
      }
      else if (y==1) {
        for (int i=size-2; i<size; ++i) {
          if (x==2) {
            for (int j=0; j<4; ++j) {
              if (gameBoard[i][j]=='O') {
                return false;
              }
            }
          }
          else if (x==size-1) {
            for (int j=x-3; j<size; ++j) {
              if (gameBoard[i][j]=='O') {
                return false;
              }
            }
          }
          else {
            for (int j=x-3; j<=x+1; ++j) {
              if (gameBoard[i][j]=='O') {
                return false;
              }
            }
          }
        }
        return true;
      }
      else {
        for (int i=size-y-1; i<=size-y+1; ++i) {
          if (x==2) {
            for (int j=0; j<4; ++j) {
              if (gameBoard[i][j]=='O') {
                return false;
              }
            }
          }
          else if (x==size-1) {
            for (int j=x-3; j<size; ++j) {
              if (gameBoard[i][j]=='O') {
                return false;
              }
            }
          }
          else {
            for (int j=x-3; j<=x+1; ++j) {
              if (gameBoard[i][j]=='O') {
                return false;
              }
            }
          }
        }
        return true;
      }
    }
    else return false;
  }
}
