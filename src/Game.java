import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;


public class Game extends JFrame{
    Board board;
    boolean mouseClicked = false;
    long moment;
    int positionX, positionY;



    public Game(){

        setTitle("Don't Starve Alone");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);


        board = new Board(this);

        add(board);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setCursor(getToolkit().createCustomCursor(new BufferedImage(3, 3, 2), new Point(0,0), "null"));
            }
        });



        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                positionX = e.getX();
                positionY = e.getY();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mouseClicked = true;
                moment = System.currentTimeMillis();

            }
        });


        pack();
        board.setup();
        setLocationRelativeTo(null);
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public boolean isMouseClicked() {return mouseClicked;}

    public long getMoment() {
        return moment;
    }

    public void setMouseClicked() {
        mouseClicked = false;
    }

    public static void main(String[] args){
        Game game = new Game();


    }




}
