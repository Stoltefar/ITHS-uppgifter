public class BattleShip {
  public static void main(String[] args) {
    Board b1 = new Board(10);
    b1.show();
    b1.set(5,5,'O');
    b1.show();
    b1.set(1, 7, 'X');
    b1.show();
    System.out.println(b1.get(1,7));
    b1.clear(5,5);
    b1.show();
  }
}
