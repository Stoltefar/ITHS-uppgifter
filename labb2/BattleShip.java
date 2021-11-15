public class BattleShip {
  public static void main(String[] args) {

/* TESTRADER FÖR KLASSERNA BOARD OCH CANNON */
    Board b1 = new Board(10);
    b1.show();
    b1.placeBoat(4, 3, 'h');
    b1.show();
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
    b1.showFog();




  }
}
