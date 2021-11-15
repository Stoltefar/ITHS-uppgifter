import java.util.Scanner;

public class BattleShip {
  public static void main(String[] args) {

/* TESTRADER FÖR KLASSERNA BOARD OCH CANNON */
/*    Board b1 = new Board(10);
    b1.show();
    b1.placeBoat(4, 3, 'h');
    b1.placeBoat(6, 7, 'V');
    b1.show();
    b1.placeBoat(4,7,'H');
    b1.placeBoat(10,10,'v');
    b1.showFog();
    Cannon kanon = new Cannon();
    kanon.fire(2,3,b1);
    b1.showFog();
    kanon.fire(6,6,b1);
    b1.showFog();
    kanon.fire(2,3,b1);
    b1.showFog();
    kanon.fire(2, 9, b1);
    System.out.println(turn(b1));
    b1.show();
*/
//    turn(b1);


    boolean gunnerOneTurn = true;

    Board g1Board = initialize();

  }

  private static Board initialize() {
    Scanner sc = new Scanner(System.in);
    clearScreen();
    Board playerBoard = new Board(10);
    playerBoard.show();
    System.out.println("Here's your empty playing field. You now have to put your four ships on it.");
    System.out.println("Each ship is three spaces large, and can be placed either horizontally or vertically.");
    System.out.println("To place a ship you will submit a coordinate which represents the middle space of the ship.");
    System.out.println("Then choose \"h\" for horizontal or \"v\" for vertical for the ship's orientation.");
    System.out.println("Press Enter to continue...");
    sc.nextLine();
    clearScreen();
    playerBoard.show();
    System.out.println("You cannot place a ship with some part of it outside the playing field,");
    System.out.println("or touching a previously placed ship, neither directly adjacent or on the corners.");
    System.out.println();
    System.out.println();
    System.out.println("Press Enter to start placing your ships...");
    sc.nextLine();
    int shipsToPlace = 4;
    clearScreen();
    while (shipsToPlace>0) {
      playerBoard.show();
      System.out.println("You have " + shipsToPlace + " ships left to place.");
      System.out.println();
      System.out.println("Enter the middle coordinate (E8 for example) for the ship you want to place: ");
      System.out.println();
      System.out.println();
      String xy = sc.nextLine();
      int x = yCharToYInt(xy.charAt(0));
      int y;
      if (xy.length()>2) {
        y = Integer.parseInt(xy.substring(1));
        System.out.println("Y-värde: " + y);
      }
      else {
        y = Character.getNumericValue(xy.charAt(1));
      }
      System.out.println("Do you want to place your ship [h]orizontally or [v]ertically?");
      char orient = sc.nextLine().charAt(0);
      if (playerBoard.placeBoat(x, y, orient)) {
        --shipsToPlace;
      }
      else {
        System.out.println("Press Enter to continue...");
        sc.nextLine();
      }
    }
    playerBoard.show();
    System.out.println();
    System.out.println("Great! You have successfully placed your ships!");
    System.out.println();
    System.out.println("Press Enter to continue...");
    sc.nextLine();
    return playerBoard;
  }


  private static boolean turn(Board target) {
    Scanner sc = new Scanner(System.in);
    Cannon gun = new Cannon();
    clearScreen();
    target.showFog();
    System.out.println("Submit the coordinate for your shot. Example: B3");
    String xy = sc.nextLine();
    int x = yCharToYInt(xy.charAt(0));
    int y = Character.getNumericValue(xy.charAt(1));
    return gun.fire(x, y, target);
  }

  private static void clearScreen() {
    for (int i=0; i<45; ++i) {
      System.out.println();
    }
  }

  private static int yCharToYInt(char y) {
    if (y>64 && y<91) {
      return y-64;
    }
    else if (y>96 && y<123) {
      return y-96;
    }
    else return 0;
  }
}
