//Max Brodheim
//Lab 1
//September 10th, 2016
//CPSC 124


//the AI in this game is mediocre at best:
//When it is in the lead, it plays defensively, and when it's losing agressively
//however, when its  losing badly, it plays terribly.


import java.util.Scanner;

public class Pig {
  public static void main (String[] args) {
    Scanner input = new Scanner (System.in); 
    String outputRound = "   This is your current score: ";
    String outputGame = "   These are the current scores in the game: ";
    
    double playerScore = 0;
    //player total score
    double playerRound = 0;
    //score this round
    double computerScore = 0;
    //computer's total score
    double computerRound = 0;
    //computer score this round
    int roll = 42;
    // value of the rolled die
    double whosTurn = 1;
    //denotes who's turn it is, -1 for computer, 1 for player
    
    System.out.println("   Welcome to Pig! Please enter a name for your opponent" );
    String name = input.nextLine();
    //gives your opponent a name
    System.out.println("(To quit, enter 'quit')");
    while ( playerScore < 100 && computerScore < 100 ) {
      if (whosTurn == 1) {
        
        System.out.println("   Would you like to roll? (yes/no)");
        String choice = input.nextLine();
        
        if ( choice.equals("yes") ) {
          roll = (int) (Math.random() * 6 + 1 );
          System.out.println ( "   Your roll is " + roll);
          if ( roll == 1 ) {
            playerRound = 0;
            System.out.println( "   Bad luck!! yours score for this round is now 0");
            System.out.println();
            System.out.println( outputGame );
            System.out.println( "      " + name + "'s score is " + computerScore);
            System.out.println( "      Your score is " + playerScore);
            System.out.println();
            whosTurn = -whosTurn;
          } else {
            playerRound = playerRound + roll;
            System.out.println( outputRound + playerRound);
          }
        } else if (choice.equals("no") ) {
          playerScore = playerRound + playerScore;
          playerRound = 0;
          whosTurn = -whosTurn;
          System.out.println();
          System.out.println( outputGame );
          System.out.println( "      " + name + "'s score is " + computerScore);
          System.out.println( "      Your score is " + playerScore);
          System.out.println();
        } else if (choice.equals("quit") ) {
          playerScore = 1000;
        } else {
          System.out.println("It's not that hard to type one of two words. Yes or No");
        }
      } else if (whosTurn == -1) {
        System.out.println( "   " + name + ", it's your turn now. Do you want to roll?");
        if (computerRound >= (playerScore - computerScore)  ) {
          System.out.println( name + ": Im not losing. I'll stick with this.");
          computerScore = computerScore + computerRound;
          computerRound= 0;
          System.out.println( outputGame );
          System.out.println();
          System.out.println( "      " + name + "'s score is " + computerScore);
          System.out.println( "      Your score is " + playerScore);
          System.out.println();
          whosTurn = -whosTurn;
        } else if (computerRound < (playerScore - computerScore)  || computerRound >= 30) {
          System.out.println(name + ": I'm losing! Better be aggresive");
          roll = (int) (Math.random() * 6 + 1 );
          if (roll == 1) {
            computerRound = 0;
            System.out.println("   Your roll is: " + roll);
            System.out.println(name + ": Aw shucks...");
            System.out.println( outputGame );
            System.out.println();
            System.out.println( "      " + name + "'s score is " + computerScore);
            System.out.println( "      Your score is " + playerScore);
            System.out.println();
            whosTurn = - whosTurn;
          } else {
            System.out.println("Your roll is: " +roll);
            System.out.println( name + ": YAY!");
            computerRound = computerRound + roll;
          }
          
          
          
          
        }
        
      }    
      
    }
    
    
    
    if (playerScore == 1000) {
      System.out.println("Sorry to see you go!");
    } else if (playerScore > computerScore) {
    System.out.println("The winner is: The Player!");
  }else {
    System.out.println("You lost to a computer. Maybe try kickboxing?");
  }
  
}
}
