/***
 * @author Maximilian Raidl
 * @version 1.0
 */
package Main;


import GUI.MainFrame;

public class Game implements _IMyGame {
    private String name;
    private String author;
    private String description;

    /**
     * run the programm
     */
    @Override
    public void run() {
        MainFrame.mainFrame = new MainFrame();
    }

    /**
     * set name of the programm
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set author for the programm
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * set description for the programm
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get the name of the programm
     * @return
     */
    @Override
    public String getName() {
        return null;
    }

    /**
     * get the description of the description
     * @return
     */
    @Override
    public String getDescription() {
        return null;
    }

    /**
     * get the author from the programm
     * @return
     */
    @Override
    public String getAuthor() {
        return null;
    }
}
