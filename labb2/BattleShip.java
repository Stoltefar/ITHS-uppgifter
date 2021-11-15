import java.util.Scanner;

public class BattleShip {
  public static void main(String[] args) {

/* TESTRADER FÖR KLASSERNA BOARD OCH CANNON */
    Board b1 = new Board(10);
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

//    turn(b1);


    boolean gunnerOneTurn = true;

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
