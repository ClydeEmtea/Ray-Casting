import java.awt.*;

public interface Constants {
    int WIDTH = 1000;
    int HEIGHT = 500;
    int SIZE = 50;
    int DELAY = 20;
    int NUM_RAYS = 52;
    Color white = new Color(255, 255, 255);
    Color red = new Color(255, 0, 0);
    Color yellow = new Color(255, 255, 0);
    Color grey = new Color(128, 128, 128);

    int[][] MAP = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 1, 1, 1, 1, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 1, 0, 0, 0, 1, 0, 1,},
            {1, 0, 0, 1, 0, 0, 0, 1, 0, 1,},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 1,},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
    };

}