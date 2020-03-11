import java.awt.*;

public class Enemy extends Sprite {
    int width = 100, height = 100, x = 500, y = 200;

    public Enemy(Color color, int x, int y, int width, int height, Board board, int phase) {
        super(color, x, y, width, height, board, phase);
    }


    @Override
    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}