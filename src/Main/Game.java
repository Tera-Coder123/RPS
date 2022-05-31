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

    @Override
    public void run() {
        MainFrame.mainFrame = new MainFrame();
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getAuthor() {
        return null;
    }
}
