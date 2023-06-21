import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class App extends JPanel implements ActionListener, Constants {
    public App() {
        this.setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(mkl = new MyKeyListener());
        start();
    }
    MyKeyListener mkl;
    Timer timer;
    List<Block> blocks;
    public Player player;

    public void start() {
        timer = new Timer(DELAY, this);
        timer.start();
        blocks = new ArrayList<>();
        createMap();
        player = new Player((float) Constants.WIDTH / 4, (float) Constants.HEIGHT / 2);
    }

    public void createMap() {
        for (int i = 0; i < Constants.MAP.length; i++) {
            for (int j = 0; j < Constants.MAP[i].length; j++) {
                if (Constants.MAP[i][j] == 1) {
                    blocks.add(new Block(j, i));
                }
            }
        }
    }

    public void drawMap(Graphics g) {
        for (Block block : blocks) {
            block.draw(g);
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {
        g.setColor(grey);
        drawMap(g);
        player.draw(g);
        player.move(blocks, mkl);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }
}