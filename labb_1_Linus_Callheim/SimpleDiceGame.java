import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintStream; // Försökte lösa utskrift av svenska tecken i Powershell

public class SimpleDiceGame {
  public static void main(String[] args) {
/*    try {
    System.setOut(new PrintStream(System.out, true, "windows-1252"));
  }
  catch (Exception e) {
    System.out.println("Hoppsan!");
  } */

    ArrayList<Player> playerList = initialize();
    takeTurn(playerList);
    ArrayList<Player> winners = getWinners(playerList);
    System.out.println("Grattis!");
    for (int i=0; i<winners.size(); ++i) {
      System.out.println(winners.get(i).getName() + " är en vinnare med " + winners.get(i).getScore() + " poäng!");
    }


//    TESTRADER SOM ANVÄNTS FÖR ATT TESTA KLASSERNA UNDER KONSTRUKTION
/*    Die nr1 = new Die(12);
    System.out.println(nr1.getPresentValue());
    System.out.println();
    for (int i=0; i<12; ++i) {
      nr1.roll();
      System.out.println(nr1.getPresentValue());
    }
    Player testPlayer = new Player("TestSpelaren");
    testPlayer.addDie(8);
    testPlayer.addDie(6);
    testPlayer.addDie(10);
    System.out.println(testPlayer.getDieValue());
    testPlayer.rollDice();
    System.out.println(testPlayer.getDieValue());
*/

  }
  private static ArrayList<Player> initialize() {
    /* Metoden frågar först hur många spelare som vill spela, hur många
    tärningar varje spelare skall ha och hur många sidor tärningarna skall ha.
    Det frågar sedan efter namnen på spelarna. */
    int nrOfPlayers = 0;
    int nrOfDice = 0;
    int sidesOfDice =0;
    ArrayList<Player> players = new ArrayList<Player>();
    Scanner sc = new Scanner(System.in);

    do {
      System.out.print("Hur många spelare är med på nästa match? ");
      nrOfPlayers = sc.nextInt();
    } while (nrOfPlayers < 1);

    do {
      System.out.print("Hur många tärningar ska varje spelare ha? ");
      nrOfDice = sc.nextInt();
    } while (nrOfDice < 1);

    do {
      System.out.print("Hur många sidor har tärningarna? ");
      sidesOfDice = sc.nextInt();
      sc.nextLine(); // För att undvika nextLine-buggen i jdk-8
    } while ( sidesOfDice < 1);


    for (int p=0; p<nrOfPlayers; ++p) {
      System.out.print("Ange namn för Spelare " + (p+1) + ": ");
      String namn = sc.nextLine();
      Player spelare = new Player(namn);
      for (int d=0; d<nrOfDice; ++d) {
        spelare.addDie(sidesOfDice);
      }
      players.add(spelare);
    }
    System.out.println("\nNu kommer alla spelare få gissa på summan av de " +
    nrOfDice + " stycken " +sidesOfDice + "-sidiga tärningar som kastas.");
    System.out.println("Gissar man rätt så får man en poäng.");
    System.out.println("Spelaren som fått ihop flest poäng efter fem rundor har vunnit!\n");
    return players;
  }
  private static void takeTurn(ArrayList<Player> players) {
    /* Skall ta emot en lista av spelare och spela färdigt en hel omgång. Den skall
    gå igenom listan av spelare, rulla varje spelares tärningar, fråga efter en gissning
    och öka spelarens poäng om hen gissat rätt. */
    Scanner sc = new Scanner(System.in);
    int playerTurnsPerRound = players.size();

    int round = 1;
    while (round<=5) {
      for (int t=0; t<playerTurnsPerRound; ++t) {
        System.out.println("Runda " + round + ", " + players.get(t).getName() + "s tur.");
        System.out.println();
        System.out.print("Gissa på summan av vad alla dina tärningar kommer visa: ");
        int guess = sc.nextInt();
        System.out.println("Nu skall jag rulla dina tärningar...");
        players.get(t).rollDice();
        int result = players.get(t).getDieValue();
        System.out.println("Summan av dina tärningar blir: " + result + ".");
        System.out.println();
        if (guess == result) {
          System.out.println("Grattis! Du gissade rätt!");
          players.get(t).increaseScore();
          System.out.println("Du har nu " + players.get(t).getScore() + " poäng!");
        }
        else {
          System.out.println("Ingen poäng den här gången. Du får gissa bättre nästa gång det är din tur.");
        }
        if (!(round == 5 && t == (playerTurnsPerRound -1))) {
          System.out.println("Nu är det " + players.get((t+1)%playerTurnsPerRound).getName() + "s tur.");
          System.out.println("Tryck RETUR när hen är redo.");
          sc.nextLine();
          String key = sc.nextLine();
        }
        for (int i=0; i<25; ++i) {
          System.out.println();
        }
      }

      ++round;
    }
  }
  private static ArrayList<Player> getWinners(ArrayList<Player> players) {
    ArrayList<Player> winners = new ArrayList<Player>();
    for (int i=5; i>=0; i--) {
  //    System.out.println("Testar om winners är tom");
        if (winners.isEmpty()) {
        for (int j=0; j<players.size(); j++) {
    //      System.out.println("Testar om spelare " + j + " har " + i +"poäng.");
          if (players.get(j).getScore() == i) {
            winners.add(players.get(j));
          }
        }
      }
      else return winners;
    }
    System.out.println("Inte en enda futtig poäng för någon!?!\nJa,ja; då är väl alla vinnare trots allt...");
    return winners;
  }
}
