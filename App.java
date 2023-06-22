import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class App extends JPanel implements ActionListener, Constants {
    public App() { // Constructor
        this.setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT)); // Set window size
        this.setBackground(Color.BLACK); // Set background color
        this.setFocusable(true); // Allows the window to be focused
        this.addKeyListener(mkl = new MyKeyListener()); // Adds the MyKeyListener.java class to the JPanel
        start(); // Calls the start() method
    }
    // Variables
    MyKeyListener mkl;
    Timer timer;
    List<Block> blocks;
    public Player player;

// Starts the timer and creates the map
    public void start() {
        timer = new Timer(DELAY, this);
        timer.start();
        blocks = new ArrayList<>();
        createMap();
        player = new Player((float) Constants.WIDTH / 4,
                (float) Constants.HEIGHT / 2);
    }

    // Creates the map
    public void createMap() {
        for (int i = 0; i < Constants.MAP.length; i++) {
            for (int j = 0; j < Constants.MAP[i].length; j++) {
                if (Constants.MAP[i][j] == 1) {
                    blocks.add(new Block(j, i));
                }
            }
        }
    }

    // Draws the map
    public void drawMap(Graphics g) {
        for (Block block : blocks) {
            block.draw(g);
        }
    }

    // Paints the JPanel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    // Draws the map, the player, rays and moves the player
    public void draw(Graphics g) {
        drawMap(g);
        player.draw(g);
        player.move(blocks, mkl);
        player.cast(blocks, g);
    }

    // Repaints the JPanel
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }
}