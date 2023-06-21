import java.awt.*;
import java.util.List;

public class Player implements Constants {
    private float x;
    private float y;
    private double angle = Math.PI;
    private final int speed = 1;
    private final double sense = 0.1;

    public Player(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(red);
        g.fillOval((int) this.x, (int) this.y, 20, 20);
    }

    public void move(List<Block> blocks, MyKeyListener mkl) {
        double dx = 0;
        double dy = 0;
        if (mkl.up) {
            dx +=  -1 * (speed * Math.cos(angle));
            dy +=  -1 * (speed * Math.sin(angle));
        }
        if (mkl.down) {
            dx +=  (speed * Math.cos(angle));
            dy +=  (speed * Math.sin(angle));
        }
        if (mkl.left) {
            dx =  -1 * (speed * Math.sin(angle));
            dy =  (speed * Math.cos(angle));
        }
        if (mkl.right) {
            dx =  (speed * Math.sin(angle));
            dy =  -1 * (speed * Math.cos(angle));
        }
        if (mkl.rotateLeft) {
            angle -= sense;
        }
        if (mkl.rotateRight) {
            angle += sense;
        }
        for (Block block : blocks) {
            if (!block.isColliding((float) (this.x + dx), (float) (this.y + dy))) {
                this.x += dx / 20;
                this.y += dy / 20;
            }
        }
    }

}
