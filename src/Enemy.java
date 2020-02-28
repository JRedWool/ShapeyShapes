import java.awt.*;

public class Enemy extends Sprite {
    int width = 100, height = 100, x = 500, y = 200;

    public Enemy(Color color, int x, int y, int width, int height, Board board) {
        super(color, x, y, width, height, board);
    }


    @Override
    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}