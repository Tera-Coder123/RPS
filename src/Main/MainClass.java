/***
 * @author Maximilian Raidl
 * @version 1.0
 */
package Main;

import GUI.MainFrame;

public class MainClass{
    /**
     * Main class
     * @param args
     */
    public static void main(String[] args) {
       Game rsp = new Game();
       rsp.setName("Rock Paper Scissors");
       rsp.setAuthor("Maximilian Raidl");
       rsp.setDescription("A small 2D Game with awsome graphics :)");
       rsp.run();
    }
}