import java.util.ArrayList;

public class Player {
  //Constructor
  public Player(String n) {
    name = n;
  }

  private String name ="";

  //Gettermetod
  public String getName() {
    return name;
  }

  private int score =0;

  //Gettermetod
  public int getScore() {
    return score;
  }

  private ArrayList<Die> diceCollection = new ArrayList<Die>();

//Metoder i Player-klassen

  public void rollDice() {
    //Skall rulla alla tärningar i spelarens tärnings-lista.
    int numberOfDice = diceCollection.size();
    for (int i=0; i<numberOfDice; ++i) {
      diceCollection.get(i).roll();

    }
  }

  public int getDieValue() {
    //Skall summera och returnera värdet på spelarens alla tärningar i form av ett heltal.
    int total = 0;
    int numberOfDice = diceCollection.size();
    for (int i=0; i<numberOfDice; ++i) {
      total += diceCollection.get(i).getPresentValue();
    }
    return total;
  }

  public void increaseScore() {
    //Skall öka spelarens poäng med ett.
    ++score;
  }

  public void addDie(int sides) {
    //Skapar en ny tärning med sidor sides och lägger till den till spelaren.
    Die newDie = new Die(sides);
    diceCollection.add(newDie);
  }
}
