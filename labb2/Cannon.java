public class Cannon {
  public boolean fire(int x, int y, Board board) {
    if (board.get(x, y)=='O') {
      System.out.println("Kaboom!");
      board.set(x, y, 'X');
      return true;
    }
    else if (board.get(x, y)==' ') {
      System.out.print("Sploosh!");
      board.set(x, y, '.');
      boolean nearMiss = false;
      if (y!=1) {
        if (board.get(x, y-1)=='O') {
          nearMiss = true;
        }
      }
      if (y!=board.getSize()) {
        if (board.get(x, y+1)=='O') {
          nearMiss = true;
        }
      }
      if (x!=1) {
        if (board.get(x-1, y)=='O') {
          nearMiss = true;
        }
      }
      if (x!=board.getSize()) {
        if (board.get(x+1, y)=='O') {
          nearMiss = true;
        }
      }
      if (nearMiss) {
        System.out.println("...but it was a close one.");
      }
      return false;
    }
    else if (board.get(x, y)=='.' || board.get(x, y)=='X') {
      System.out.println("You have already made a shot at this location. Try again!");
      return true;
    }
    else {
      System.out.println("Om den här utskriften kommer är det nåt fel på tecknen i matrisen!");
      return true;
    }
  }
}
