import java.awt.*;

public class Split {

    Board board;
    int x, y, w, h;

    public Split(Board board){
        /*this.board = board;
        x = board.getWidth()/2;
        y = 0;
        w = board.getWidth()/2;
        h = board.getHeight();
        */

       x = 600;
       y = 0;
       w = 700;
       h = 900;

    }


    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, w, h);
    }

}
