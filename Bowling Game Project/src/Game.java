/**
 * 
 */

/**
 * @author Lokeshwar Reddy Kasarla
 * Bowling Green Game
 * Code Kata
 * 
 * Class Game with two methods roll(int) and score, two integer members rolls and thisRoll
 * lkasarla@kent.edu
 * Kent State University
 * 
 */
public class Game {
	// Defining rolls to capture no of pins down , 21 as maximum rolls
  private int rolls[] = new int[21];
  	// 
  private int thisRoll = 0;

  public void roll(int pins) 
  {
	  // storing the no of Pins down in rolls array 
	  rolls[thisRoll++] = pins;
  }
  public int score() 
  {
    int score = 0;
    int frameNumber = 0;
    for (int frame = 0; frame < 10; frame++) 
    {
    	// Checking for Strike 
    if (rolls[frameNumber] == 10) 
    	{
    		score += 10 + rolls[frameNumber+1] + rolls[frameNumber+2];
    		frameNumber++;
    	} 
    	// Checking for Spare
     else if (rolls[frameNumber]+rolls[frameNumber+1] == 10) 
     	{
    	 	score += 10 + rolls[frameNumber+2];
    	 	frameNumber += 2;
     	} 
    	// Normal roll 
     else 
     	{
    	 	score += rolls[frameNumber] + rolls[frameNumber+1];
    	 	frameNumber += 2;
     	}
    }
    return score;
  }
}
