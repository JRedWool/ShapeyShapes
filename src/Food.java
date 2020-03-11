import java.awt.*;

public class Food extends Sprite {



    public Food(Color color, int x, int y, int width, int height, Board board, int phase) {
        super(color, x, y, width, height, board, phase);

    }






    @Override
    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }
}
