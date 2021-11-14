public class Canon {
  public boolean fire(int x, int y, Board board) {
    if (board.get(x, y)=='O') {
      System.out.println("Kaboom!");
      board.set(x, y, 'X');
      return true;
    }
    else if (board.get(x, y)==' ') {
      System.out.print("Sploosh!");
      String nearMiss = "...but it was a close one.";
      if (y==1) {
        if (x==1) {
          if (board.get(x+1, y)=='O' || board.get(x, y+1)=='O') {
            System.out.println(nearMiss);
          }
        }
        else if (x==board.getSize()) {
          if (board.get(x-1, y)=='O' || board.get(x, y+1)=='O') {
            System.out.println(nearMiss);
          }
        }
        else {
          if (board.get(x-1, y)=='O' || board.get(x, y+1)=='O' || board.get(x+1, y))
        }
      }
    }
    return false;
  }
}
