import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.security.Key;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Game extends JFrame implements KeyListener{

    Board board;
    boolean mouseClicked = false;
    long moment;
    boolean enterPressed, upPressed, downPressed, leftPressed, rightPressed;


    public Game(){

        setTitle("Don't Starve Alone");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board = new Board(this);
        add(board);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setCursor(getToolkit().createCustomCursor(new BufferedImage(3, 3, 2), new Point(0,0), "null"));
            }
        });

        /*
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                positionX = e.getX();
                positionY = e.getY();
            }
        });
            */


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mouseClicked = true;
                moment = System.currentTimeMillis();

            }
        });

        addKeyListener(this);
        pack();
        setResizable(false);
        board.setup();
        setLocationRelativeTo(null);
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e){


        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = true;
            System.out.println("Phase 1");
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            enterPressed = true;
        }

    }


    @Override
    public void keyReleased(KeyEvent e){


        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = false;
            System.out.println("Phase 2");
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            enterPressed = false;
        }

    }

    public boolean isEnterPressed() {
        return enterPressed;
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }
}
