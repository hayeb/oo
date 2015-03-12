package assignment6;
/**
 *
 * @author Pieter Koopman, Sjaak Smetsers
 */
public class Main
{

    public static void main(String[] args) {
        int [] game = {1,2,3, 4,9,6, 7,5,8};

        SlidingGame s = new SlidingGame (game);
        System.out.println(s);
        Solver solver = new Solver(s);
        System.out.println(solver.solve());
    }
}
