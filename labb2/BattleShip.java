public class BattleShip {
  public static void main(String[] args) {
    Board b1 = new Board(10);
    b1.show();
    b1.placeBoat(4, 3, 'h');
    b1.show();
    b1.placeBoat(6, 7, 'V');
    b1.show();
  }
}
