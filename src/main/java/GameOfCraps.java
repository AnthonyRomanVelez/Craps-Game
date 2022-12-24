 import java.util.Random;
public class GameOfCraps {
      // create random number generator for use in method rollDice
      private Random randomNumbers = new Random(); 
   
     // enumeration with constants that represent the game status
     private static enum Status { CONTINUE, WON, LOST };
  
     // constants that represent common rolls of the dice
     private final static int SNAKE_EYES = 2;
     private final static int TREY = 3;
     private final static int SEVEN = 7;
     private final static int YO_LEVEN = 11;
     private final static int BOX_CARS = 12;
                          int[] gamesWon;
                          int[] gamesLost;
                          int rollDice;
               
  
    // plays one game of craps
     public void play()
     {
        int myPoint = 0; // point if no win or loss on first roll
        Status gameStatus; // can contain CONTINUE, WON or LOST
        gamesWon = new int[22];
        gamesLost = new int[22];
        
        
        int sumOfDice = rollDice(); // first roll of the dice
        rollDice = 1;
        // determine game status and point based on first roll 
        switch ( sumOfDice ) 
        {
           case SEVEN: // win with 7 on first roll
           case YO_LEVEN: // win with 11 on first roll           
             gameStatus = Status.WON;
              break;
           case SNAKE_EYES: // lose with 2 on first roll
           case TREY: // lose with 3 on first roll
           case BOX_CARS: // lose with 12 on first roll
              gameStatus = Status.LOST;
              break;
           default: // did not win or lose, so remember point         
              gameStatus = Status.CONTINUE; // game is not over
              myPoint = sumOfDice; // remember the point
              System.out.printf( "Point is %d\n", myPoint );
              break; // optional at end of switch
        } // end switch 
        
        // while game is not complete
        while ( gameStatus == Status.CONTINUE ) // not WON or LOST
        { 
           sumOfDice = rollDice(); // roll dice again
           
           // determine game status
           if ( sumOfDice == myPoint ) // win by making point
              gameStatus = Status.WON;
                
           
           if ( sumOfDice == SEVEN ) // lose by rolling 7 before point
               gameStatus = Status.LOST;
        
        } // end while 
  
        // display won or lost message
         if(rollDice > 21)
              rollDice = 21;
         
        if ( gameStatus == Status.WON )
           System.out.println( "Player wins" );
        
        else
           System.out.println( "Player loses" );
        
         for(int i = 1; i <= 21; i++){
            System.out.printf("%d games won and %d games lost on roll %d", 
                               gamesWon[rollDice],gamesLost[rollDice],rollDice);
               rollDice++;
               System.out.println();
         }
         
         
     } // end method play
  
     // roll dice, calculate sum and display results
     public int rollDice()
     {
        // pick random die values
        int die1 = 1 + randomNumbers.nextInt( 6 ); // first die roll
        int die2 = 1 + randomNumbers.nextInt( 6 ); // second die roll
  
        int sum = die1 + die2; // sum of die values
  
        // display results of this roll
        System.out.printf( "Player rolled %d + %d = %d\n", 
           die1, die2, sum );
  
        return sum; // return sum of dice
     } // end method rollDice
     public static void main(String[] args){//Main function to call the methods
         GameOfCraps game = new GameOfCraps();
         game.play();
         
         
         
     }
  } // end class Craps
  

    

