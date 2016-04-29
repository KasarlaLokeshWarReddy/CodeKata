import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Lokeshwar Reddy Kasarla
 *
 */
public class BowlingGameTest extends Game
{
	 private Game game;
	 @Before
	  public void setUp() throws Exception 
	 {
	    game = new Game();
	  }
	  
	  public void rollGame(int n, int pinsDown) 
	  {
	    for (int i = 0; i < n; i++)
	      game.roll(pinsDown);
	  }
	  @Test
	  public void isGutterGame() throws Exception 
	  {
	  // no pins down in all throws
		  rollGame(20, 0);
	    assertEquals(0, game.score());
	  }
	  @Test
	  public void isAllOnes() throws Exception 
	  {
	  // one pin down in each throw
		  rollGame(20,1);
	    assertEquals(20, game.score());
	  }
	  @Test 
	  public void isAllThrees() throws Exception
	  {
		  //if three pins fall for every throw
		  rollGame(20,3);
		  assertEquals(60,game.score());
	  }
	  @Test
	  public void isOneSpare() throws Exception 
	  {
	    //if the first throw is spare, rext throw has 3 pins down and rest of the throws result zero
		rollSpare();
	    game.roll(3);
	    rollGame(17,0);
	    assertEquals(16,game.score());
	  }
	  @Test
	  public void isOneStrike() throws Exception 
	  {
	    //if first roll results a strike,  next two throws downs 3,4 pins and rest all rolls down zero pins
		rollStrike();
	    game.roll(3);
	    game.roll(4);
	    rollGame(17, 0);
	    assertEquals(24, game.score());
	  }
	  @Test
	  public void isPerfectGame() throws Exception 
	  {
		  // if every roll results in strike
	    rollGame(12,10);
	    assertEquals(300, game.score());
	  }
	  @Test
	  public void rollStrike() 
	  {
		  // rolling a strike, making 10 pins down
	    game.roll(10);
	  }
	  @Test
	  public void rollSpare() 
	  {
		  // making spare, sum of down pins in two rolls of a frame must be 10.
	    game.roll(3);
	    game.roll(7);
	  }
}
