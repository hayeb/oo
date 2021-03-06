package assignment13a;
/**
 * Class to test the dice game.a
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s5373510
 *
 */
public class GameTest {

        private final Dice dice;
        private static final int PLAYERS = 3;
        private static final int THROWS =100;
        
        public GameTest() {
                dice = new Dice();
        }
        
        
       public void play(){
               for ( int i = 0; i < PLAYERS; i+= 1){
                       Player p = new Player ("p" + i, dice, THROWS);
                       Thread t  = new Thread(p);
                       t.start();
               }
       }
       
       public static void main(String[] args) {
               GameTest game = new GameTest();
               game.play();
       }
}
