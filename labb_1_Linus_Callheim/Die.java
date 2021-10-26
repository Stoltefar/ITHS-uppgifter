import java.util.Random;

public class Die {

  private int diceRange;
  //Gettermetod
  public int getDiceRange() {
    return diceRange;
  }

  private int presentValue;
  //Gettermetod
  public int getPresentValue() {
    return presentValue;
  }

  public void roll() {
    Random slump = new Random();
    presentValue = slump.nextInt(diceRange)+1;
    System.out.println("Rullar " + diceRange + "-sidig tärning.");
    try  {
      for (int i=0; i<(slump.nextInt(3)+1); ++i) {
        System.out.println("Tärningen rullar...");
        Thread.sleep(400);
      }
    }
    catch(InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
    System.out.println("...och stannar på " + presentValue + ".");
    System.out.println("-----------------------");
    try  {
      Thread.sleep(600);
    }
    catch(InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }

  public Die(int sidor) {
    diceRange = sidor;
    presentValue= sidor;
  }
}
