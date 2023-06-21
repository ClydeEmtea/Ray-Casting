import java.awt.*;

public class Block implements Constants {
    private int x;
    private int y;

    public Block(int x, int y) {
        this.x = x * SIZE;
        this.y = y * SIZE;
    }

    public void draw(Graphics g) {
        g.fillRect(this.x, this.y, SIZE, SIZE);
    }

    public boolean isColliding(float x, float y) {
        return (x >= this.x && x <= this.x + SIZE && y >= this.y && y <= this.y + SIZE);
    }
}
