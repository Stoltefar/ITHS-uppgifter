public class Cannon {
  public boolean fire(int x, int y, Board board) {
    if (board.get(x, y)=='O') {
      board.set(x, y, 'X');
      board.showFog();
      System.out.println("\nKaboom!\n");
      System.out.println("You will get another shot!");
      try  {
        Thread.sleep(3000);
      }
      catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
      return true;
    }
    else if (board.get(x, y)==' ') {
      board.set(x, y, '.');
      board.showFog();
      System.out.println("\nSploosh!");

      if (checkNear(x, y, board)) {
        try  {
          Thread.sleep(700);
        }
        catch(InterruptedException ex) {
          Thread.currentThread().interrupt();
        }
        System.out.println("...but it was a close one.");
      }
      System.out.println("Incoming! Take cover!");
      try  {
        Thread.sleep(3000);
      }
      catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
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
  private boolean checkNear(int x, int y, Board board) {
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
    return nearMiss;
  }
}
