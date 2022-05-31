/***
 * @author Maximilian Raidl
 * @version 1.0
 */
package Figure;

import java.util.Random;


public enum FigureType {
    ROCK,PAPER,SCISSOR;

    /**
     * returns a random Figure Type
     * @return
     */
    public static FigureType getRandomFigureType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
