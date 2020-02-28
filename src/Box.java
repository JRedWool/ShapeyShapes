import java.awt.*;

public class Box {


    Board board;
    int width, height, x, y;

    public void box(Board board){
        width = 400;
        height = 400;
        x = 20;
        y =  board.getHeight()-600;
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.drawRect(x, y, width, height);
    }

}
